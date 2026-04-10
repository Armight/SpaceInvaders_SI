package modelPackage;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	private ArrayList<Pixel> tiroak;
	private ArrayList<Pixel> etsaiak; 
	private Pixel jokalari;

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
	    tiroak = new ArrayList<Pixel>();
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
		
	public void addTiro(Pixel pTiro) {
			this.tiroak.add(pTiro);
		}
		
	private void mugituTiroak() {
			ArrayList<Pixel> tiroakCopia= new ArrayList<Pixel>(this.tiroak);//gure tiroen arrayaren kopia
			for (Pixel t : tiroakCopia) {
				
				//Tiroa yLimitera ailegatu bada ezin izan da sortu
				//Beraz ezabatu egin da
				t.ezabatu();
				if (!t.mugituY(-1)) {
					tiroak.remove(t);;
				}
			    this.tiroKolisioak(t);
			}
		}
	
	private Iterator<Pixel> getTiroIterator() {
		return this.tiroak.iterator();
	}
//******************************ETSAIEN METODOAK:	********************************
	private void mugituEtsaiak() {		
		ArrayList<Pixel> etsaiakKopia= new ArrayList<Pixel>(this.etsaiak);//gure estaien arrayaren kopia
		
		//1. Etsai guztien posizio berriak kalkulatu
		//HashMap baten gorde giltza = id eta HashSet<String> = posizioa(k) izanda
		for(Pixel e : etsaiakKopia) {
			//random zenbakia kalkulatu
			int r = (int)(Math.random() * 3); //0, 1 edo 2
			e.setRandom(r);
		}
		
		//2. Etsai bakoitzeko konprobatu ea berak egin nahi duen mugimendua beste etsai batek egin nahi badu
		for (Pixel e : etsaiakKopia) {
			
			//Ez dago beste etsairik berak egin nahi duen mugimendua egingo duenik
			if (!this.etsaiEtsaiKolisioak(e)) {
				
				if (e.mugituRandom()) {
					this.etsaiKolisioak(e);
					this.etsaiJokalariKolisioak(e);
				} else {
					PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
				}
			}
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
	public Pixel getJokalari() {
		return jokalari;
	}
	
	public void mugituJokalariaX(int i) {
		if (jokalari == null) return;
		jokalari.ezabatu();
		if (!jokalari.mugituX(i)) return;
		this.jokalariEtsaiKolisioak(jokalari);
	}
	
	
	public void mugituJokalariaY(int i) {
		if (jokalari == null) return;
		jokalari.ezabatu();
		if (!jokalari.mugituY(i)) return;
		this.jokalariEtsaiKolisioak(jokalari);
	}
	
	public void shoot() {
		if (jokalari == null) return;
		jokalari.shoot();
	}
	
	//*************************KOLISIOEN METODODAK:**************************
	
	//Tiroak metodo hau deitu tiroaren eta etsai guztien arteko kolisioak konprobatzeko
	public void tiroKolisioak(Pixel pTiro) {
		Iterator<Pixel> itr = this.getEtsaiIterator(); 
		
		while(itr.hasNext()) {
			Pixel e = itr.next();
			if(e.kolisioak(pTiro)) { 
				int hilDa = e.bizitzaKendu();
				if (hilDa < 0) { 
					itr.remove();
					pTiro.ezabatu();
					tiroak.remove(pTiro);
				}
			}
		}
		
		//bukaerako baldintza konprobatzeko da hau etsaiak ez badaude eta jokoaMartxan badago
		//Hau checkJokoa metodoa erabiltzeko era zuzenean da
		if (etsairikEz()) {
			PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
		}
	}
	
	//Etsaiak metodo hau deitu etsaiaren eta tiro guztien arteko kolisioak konprobatzeko
	public void etsaiKolisioak(Pixel pEtsai) {
		Iterator<Pixel> itr = this.getTiroIterator(); 
		
		while(itr.hasNext()) {
			Pixel t = itr.next();
			if(t.kolisioak(pEtsai)) {
	 			int hilDa = pEtsai.bizitzaKendu();
				if (hilDa < 0) { 
					etsaiak.remove(pEtsai);
					t.ezabatu();
					itr.remove();
				}
			}
		}
	}
	
	//ETSAI-ETSAI KOLISIOAK ERREBISATU BEHAR DIRA
	public boolean etsaiEtsaiKolisioak(Pixel pEtsai) {
		boolean ezMugitu = false;
		Iterator<Pixel> itr = this.getEtsaiIterator(); 
		
		while(itr.hasNext()) {
			Pixel e = itr.next();
			if (pEtsai.getId() == e.getId()) continue;
			
			if(e.etsaiKolisioak(pEtsai)) {
				ezMugitu = true;
				break;
			}
		}
		return ezMugitu;		
	}
	
	public void etsaiJokalariKolisioak(Pixel pEtsai) {
		if (jokalari.kolisioak(pEtsai)) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
		}
	}
	
	public void jokalariEtsaiKolisioak(Pixel pJokalari) {
		Iterator<Pixel> itr = this.getEtsaiIterator(); 
		
		while(itr.hasNext()) {
			Pixel e = itr.next();
			if(e.kolisioak(pJokalari)) {
				PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();	
			}
		}
	}		
}

