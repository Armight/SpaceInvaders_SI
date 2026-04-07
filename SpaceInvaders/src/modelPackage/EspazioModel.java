package modelPackage;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	private ArrayList<Tiro> tiroak;
	private ArrayList<Pixel> etsaiak; 
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
	    etsaiak = new ArrayList<Pixel>();
	    
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
		ArrayList<Pixel> etsaiakKopia= new ArrayList<Pixel>(this.etsaiak);//gure estaien arrayaren kopia
		for(Pixel e : etsaiakKopia) {
			//2. etsai guztiak mugitu
			e.mugituRandom();
		}
		
	}
	
	
	public void removeEtsai (Pixel e) {
		etsaiak.remove(e);
	}
	
	private Iterator<Pixel> getEtsaiIterator() {
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
				Pixel et = new EtsaiMultipixel(pos[0], pos[1], i+1);
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
	public void etsaiKolisioakKonprobatu(int pX, int pY, Tiro t) {/*
		Iterator<Pixel> itr = this.getEtsaiIterator(); 
		
		while(itr.hasNext()) {
			Pixel e = itr.next();
			if(e.kolisioakKonprobatu(pX,pY)) {
				boolean hilDa = e.bizitzaKendu();
				if (hilDa) { 
					itr.remove();
					tiroak.remove(t);
				}
			}
		}
		
		//bukaerako baldintza konprobatzeko da hau etsaiak ez badaude eta jokoaMartxan badago
		//Hau checkJokoa metodoa erabiltzeko era zuzenean da
		if (etsairikEz()) {
			PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
		}*/
	}
	
	public void tiroKolisioakKonprobatu(int pX, int pY, Etsai e) {
		/*Iterator<Tiro> itr = this.getTiroIterator(); 
		
		while(itr.hasNext()) {
			Tiro t = itr.next();
			if(t.kolisioakKonprobatu(pX, pY)) {
	 			boolean hilDa = e.bizitzaKendu();
				if (hilDa) { 
					etsaiak.remove(e);
					 itr.remove();
				}
			}
		}*/
	}
	
	public void jokalariKolisioakKonprobatu(int pX, int pY) {
		Iterator<Pixel> itr = this.getEtsaiIterator(); 

		while(itr.hasNext()) {
			Pixel e = itr.next();
			if(e.kolisioakKonprobatu(pX,pY)) {
				PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
			}
		}
	}

	public boolean etsaiEtsaiKolisioak(Set<String> pEtsaiPos, int pId) {
		Iterator<Pixel> itr = this.getEtsaiIterator();
		boolean kolisionatu = false;
		
		while(itr.hasNext() && !kolisionatu) {
			Pixel e = itr.next();
			kolisionatu = e.etsaiKolisioak(pEtsaiPos, pId);	
		}
		return kolisionatu;
	}
}

