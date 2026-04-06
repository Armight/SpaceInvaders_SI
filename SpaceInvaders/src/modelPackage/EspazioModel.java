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
	private Timer timerEtsaiak;	//Timer bat etsaientzako kasu honetan 200ms-koa izango dena
	private Timer timerTiroak; //Timer bat tiroentzako, ezberdina 50ms-koa izango dena
	
	private EspazioModel() {
		matrizea = new Gelaxka[60][100];
		//inizializatzeko zuzenean
	    for (int i = 0; i < 60; i++) {
	        for (int j = 0; j < 100; j++) {
	            matrizea[i][j] = new Gelaxka(i, j);
	        }
	    }
	    tiroak = new ArrayList<Tiro>();
	    etsaiak = new ArrayList<Etsai>();
	    
	}
	
	public static EspazioModel getGelaxkaMatrizea() {//EMA
		if (nGM == null) {
			nGM = new EspazioModel();
		}
		return nGM;
	}
	
	//*************MATRIZEAREN METODOAK****************************
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
	public boolean etsairikEz() {
		if (PartidaKudeatzailea.getPartidaKudeatzailea().getJokoaMartxan()) {
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
		PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaMartxan();
		int pXErdia = EspazioModel.getGelaxkaMatrizea().getZabalera() / 2; //50
		int pYBehean = EspazioModel.getGelaxkaMatrizea().getAltuera() - 2; //48
		
	    //jokalaria instantziatu
	    //jokalari = new Jokalari(pXErdia, pYBehean);
		String kolorea = PartidaKudeatzailea.getPartidaKudeatzailea().getKolorea();
		jokalari = JokalariFactory.getJokF().createJokalaria(kolorea, pXErdia, pYBehean);
	    
	    //Jokalaria eta etsaiak sortu
	    jokalari.sortu();
	    this.sortuEtsaiZerrenda();
	    
	    //Timerrak eraikitzailearen kanpoan
	    timerEtsaiak = sortuTimerEtsaiak();
	    timerTiroak  = sortuTimerTiroak();
	    timerEtsaiak.start();
	    timerTiroak.start();
	}
	
	private Timer sortuTimerEtsaiak() {
	    return new Timer(200, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (PartidaKudeatzailea.getPartidaKudeatzailea().getJokoaMartxan()) {
	                mugituEtsaiak();
	                PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
	            }
	        }
	    });
	}

	private Timer sortuTimerTiroak() {
	    return new Timer(50, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (PartidaKudeatzailea.getPartidaKudeatzailea().getJokoaMartxan()) {
	                mugituTiroak();
	                PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
	            }
	        }
	    });
	}
	
	public void geldituTimerrak() {
	    if (timerEtsaiak != null) timerEtsaiak.stop();
	    if (timerTiroak != null) timerTiroak.stop();
	}

//***********************TIROEN METODOAK:********************************
	
	public void removeTiro(Tiro pTiro) {
			this.tiroak.remove(pTiro);
		}
		
	public void addTiro(Tiro pTiro) {
			this.tiroak.add(pTiro);
		}
		
	private void mugituTiroak() {
			ArrayList<Tiro> tiroakCopia= new ArrayList<Tiro>(this.tiroak);//gure tiroen arrayaren kopia
			for (Tiro t : tiroakCopia) {
				//Herentziaz int parametro bat sartu beharra dago
				//Tiroa bakarrik gorantz egin dezake, beraz ez da parametroa erabiliko
				//pantailan dauden tiro guztiak posizio bat aurrera egiteko
			    t.mugituY(0);
			}
		}
	
	private Iterator<Tiro> getTiroIterator() {
		return this.tiroak.iterator();
	}
//******************************ETSAIEN METODOAK:	********************************
	private void mugituEtsaiak() {
		ArrayList<Etsai> etsaiakKopia= new ArrayList<Etsai>(this.etsaiak);//gure estaien arrayaren kopia
		for(Etsai e : etsaiakKopia) {
			//1. Hurrengo random posizioak konparatu
			e.posizioRandom();
		}
		for(Etsai e : etsaiakKopia) {
			//2. etsai guztiak mugitu
			e.mugituRandom();
		}
		
	}
	
	
	public void removeEtsai (Etsai e) {
		etsaiak.remove(e);
	}
	
	private Iterator<Etsai> getEtsaiIterator() {
		return etsaiak.iterator();
	}
	
	
	//ETSAIEN ARRAYAREN METODOAK:
		private void sortuEtsaiZerrenda() {
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
				Etsai et = new Etsai(pos[0], pos[1], i+1);
				et.sortu();
				this.etsaiak.add(et);
			}
			
		}
	
	
	
	//*************************JOKALARIAREN METODODAK:**************************
	public Jokalari getJokalari() {
		return jokalari;
	}
	
	public void mugituJokalariaX(int i) {
		if (jokalari == null) return;
		this.jokalari.mugituX(i);
	}
	public void mugituJokalariaY(int i) {
		if (jokalari == null) return;
		this.jokalari.mugituY(i);
	}
	public void shoot() {
		if (jokalari == null) return;
		this.jokalari.shoot();
	}
		
	
	//*************************KOLISIOEN METODODAK:**************************
	public void etsaiKolisioakKonprobatu(int pX, int pY) {
		Iterator<Etsai> itr = this.getEtsaiIterator(); 
		
		while(itr.hasNext()) {
			Etsai e = itr.next();
			if(e.kolisioakKonprobatu(pX,pY)) {
				boolean hilDa = e.bizitzaKendu();
				if (hilDa) { 
					itr.remove();
				}
			}
		}
		
		//bukaerako baldintza konprobatzeko da hau etsaiak ez badaude eta jokoaMartxan badago
		//Hau checkJokoa metodoa erabiltzeko era zuzenean da
		if (etsairikEz()) {
			PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
		}
	}
	
	public void tiroKolisioakKonprobatu(int pX, int pY, Etsai e) {
		Iterator<Tiro> itr = this.getTiroIterator(); 
		
		while(itr.hasNext()) {
			Tiro t = itr.next();
			if(t.kolisioakKonprobatu(pX, pY)) {
				boolean hilDa = e.bizitzaKendu();
				if (hilDa) { 
					etsaiak.remove(e);
				}
			}
		}
	}
	
	public void jokalariKolisioakKonprobatu(int pX, int pY) {
		Iterator<Etsai> itr = this.getEtsaiIterator(); 

		while(itr.hasNext()) {
			Etsai e = itr.next();
			if(e.kolisioakKonprobatu(pX,pY)) {
				PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
			}
		}
	}

	public boolean etsaiEtsaiKolisioak(int pX, int pY, int pId) {
		Iterator<Etsai> itr = this.getEtsaiIterator();
		boolean kolisionatu = false;
		
		while(itr.hasNext() && !kolisionatu) {
			Etsai e = itr.next();
			kolisionatu = e.etsaiKolisioak(pX, pY, pId);	
		}
		return kolisionatu;
	}
}

