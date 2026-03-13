package modelPackage;

import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Iterator;


public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	private ArrayList<Tiro> tiroak;
	private ArrayList<Etsai> etsaiak; 
	private Jokalari jokalari;
	private boolean jokoaMartxan = false;
	private boolean jokoaAmaitu = false;
    private Timer timer; // Timer berria EspazioModelerako
	
	private EspazioModel() {
		matrizea = new Gelaxka[60][100];
		//inizializatzeko zuzenean
	    for (int i = 0; i < 60; i++) {
	        for (int j = 0; j < 100; j++) {
	            matrizea[i][j] = new Gelaxka(i, j, "hutsik");
	        }
	    }
	    tiroak = new ArrayList<Tiro>();
	    etsaiak = new ArrayList<Etsai>();
	    
	    //Timerra hemen EspazioModelerako :D
	    //Kasu honetan mugitzean orain ez da ...(200,this).. orain EspazioModel ez denez ActionListener
	    //(Controllera bai zen) momentuan sortzen dugu eta egin dugun importekin ez da beharrezkoa egitea
	    // public class EspazioModel implements ActionListener eta gauza horiek
	    timer = new Timer(200, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            jokoaEguneratu();
	        }
	    });
	    timer.start();
	}
	
	public static EspazioModel getGelaxkaMatrizea() {//EMA
		if (nGM == null) {
			nGM = new EspazioModel();
		}
		return nGM;
	}
	
	//MATRIZEAREN METODOAK
	public int getAltuera() {  
		return this.matrizea.length;  //y
	}
	
	public int getZabalera() {
		return this.matrizea[0].length;  //x
	}
	
	public Gelaxka getGelaxka(int pX, int pY) {  //posizio horren gelaxka lortu
		return this.matrizea[pY][pX];
	}
	
	//JOKOAREN KUDEAKETA
	public void setJokoaAmaitu() {
		jokoaAmaitu = true;
	}
	
	public boolean getJokoaAmaitu() {
		return this.jokoaAmaitu;
	}
	
	private void checkJokoa() {
		PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
	}
	
	public boolean etsairikEz() {
		if (jokoaMartxan) {
			return etsaiak.isEmpty();
		} else return false;
	}
	
	public boolean espaziotikKanpo(int pX, int pY) {
		 boolean kanpoan = false;
		 
		 if (pX < 0 || pX >= this.getZabalera()) {
			 kanpoan = true;
		 }
		 if (pY < 0 || pY >= this.getAltuera()) {
			 kanpoan = true;
		 }
		 return kanpoan;
	 }
	
	//JOKOA HASTEKO
	public void jokoanHasi() {
		//Jokalariaren koordenatuak lortu
		this.jokoaMartxan = true;
		int pXErdia = EspazioModel.getGelaxkaMatrizea().getZabalera() / 2; //50
		int pYBehean = EspazioModel.getGelaxkaMatrizea().getAltuera() - 2; //48
		
	    //jokalaria instantziatu
	    jokalari = new JokalariMorea(pXErdia, pYBehean);
	    
	    //Jokalaria eta etsaiak sortu
	    jokalari.sortuJokalaria();
	    this.sortuEtsaiZerrenda();
	}
	

//TIROEN METODOAK:
	
	public void removeTiro(Tiro pTiro) {
			this.tiroak.remove(pTiro);
		}
		
	public void addTiro(Tiro pTiro) {
			this.tiroak.add(pTiro);
		}
		
	private void mugituTiroak() {
			ArrayList<Tiro> tiroakCopia= new ArrayList<Tiro>(this.tiroak);//gure tiroen arrayaren kopia
			for (Tiro t : tiroakCopia) {
			    t.mugitu();//pantailan dauden tiro guztiak posizio bat aurrera egiteko
			}
		}


//ETSAIEN METODOAK:	
	private void mugituEtsaiak() {
		ArrayList<Etsai> etsaiakKopia= new ArrayList<Etsai>(this.etsaiak);//gure estaien arrayaren kopia
		for(Etsai e : etsaiakKopia) {
			e.mugituRandom();//pantailan dauden etsai guztiak behera/eskumara/ezkerrera mugitzeko 
		}
	}
	
	//JOKALARIAREN METODODAK:
	public Jokalari getJokalari() {
		return jokalari;
	}
	
	//ETSAIEN ARRAYAREN METODOAK:
	public void sortuEtsaiZerrenda() {
		//8 etsaiek har dezaketen posizioen ArrayList-a sortu
		//(10,5), (20, 5) ... (80,5)
		ArrayList<int[]> etsaiPosizioak = new ArrayList<int []>();
		int pX= 0;
		for (int i = 0; i < 8; i++) {
			pX = pX + 10;
			etsaiPosizioak.add(new int [] {pX, 5});
		}
		//Posizio guztiak nahastu
		Collections.shuffle(etsaiPosizioak);
		//4...8 etasien arteko zenbaki random bat sortu
		int etsaiKop = 4 + (int)(Math.random() * 5);
		for (int i = 0; i < etsaiKop; i++) {
			int[] pos = etsaiPosizioak.remove(0);
			Etsai et = new EtsaiTxikia(pos[0], pos[1]);
			et.sortuEtsaia();
			this.etsaiak.add(et);
		}
		
	}
		
	private Iterator<Tiro> getTiroIterator(){
		return tiroak.iterator();
	}
	
	public void kolisioakKonprobatu( ) {
		Iterator<Tiro> itrT = this.getTiroIterator();
		ArrayList<Etsai> etsaiakKopia= new ArrayList<Etsai>(this.etsaiak);//gure estaien arrayaren kopia
		ArrayList<Tiro> ezabatuTiroak = new ArrayList<Tiro>();
		ArrayList<Etsai> ezabatuEtsai = new ArrayList<Etsai>();
		
		//TIROAK KONPROBATU
		while (itrT.hasNext()) {
			Tiro t = itrT.next();
			if (t.getKolisionatu()) {
				//tiroa gorde gerorako
				ezabatuTiroak.add(t);
				itrT.remove();
			}
		}
		//ETSAIAK KONPROBATU
		if (!ezabatuTiroak.isEmpty()) {
			for (Etsai e : etsaiakKopia) {
				//Etsai bakoitzeko kolisionatu duten tiro guztiak konprobatu
				for (Tiro t : ezabatuTiroak) {
					if(e.kolisioakKonprobatu(t.getX(), t.getY())) {
						boolean hilDa = e.bizitzaKendu();
						if (hilDa) {
							ezabatuEtsai.add(e);
						}
					}
				}
			}
		}
		etsaiak.removeAll(ezabatuEtsai);
	}
	
	
	
	//UPDATE:
	public void jokoaEguneratu() {
		this.mugituTiroak();
		this.kolisioakKonprobatu( );
		this.mugituEtsaiak();   
		this.checkJokoa();
	}
}

