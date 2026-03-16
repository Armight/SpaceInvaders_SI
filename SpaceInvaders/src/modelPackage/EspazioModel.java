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
	private Timer timerEtsaiak;	//Timer bat etsaientzako kasu honetan 200ms-koa izango dena
	private Timer timerTiroak; //Timer bat tiroentzako, ezberdina 50ms-koa izango dena
	
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
	public void setJokoaAmaitu() {
		jokoaAmaitu = true;
		//Hemen ipini check jokoa, zeren eta etsaia muga edo limiteera ailegatzen denean setJokoaAmaitu()
		//metodoa  deitzen dute, era honetan zuzenean egiten dugu, konkretuki 
		//mugituJokalariaX() eta mugituJokalariaY() metodoak JokalariMorea klasean eta
		//EtsaiTxikia klasea mugituEtsaiY() metodoarekin
		this.checkJokoa();
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
	            if (jokoaMartxan) {
	                mugituEtsaiak();
	                checkJokoa();
	            }
	        }
	    });
	}

	private Timer sortuTimerTiroak() {
	    return new Timer(50, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (jokoaMartxan) {
	                mugituTiroak();
	                checkJokoa();
	            }
	        }
	    });
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
			    t.mugitu();//pantailan dauden tiro guztiak posizio bat aurrera egiteko
			}
		}
	private Iterator<Tiro> getTiroIterator(){
		return tiroak.iterator();
	}


//******************************ETSAIEN METODOAK:	********************************
	private void mugituEtsaiak() {
		ArrayList<Etsai> etsaiakKopia= new ArrayList<Etsai>(this.etsaiak);//gure estaien arrayaren kopia
		for(Etsai e : etsaiakKopia) {
			e.mugituRandom();//pantailan dauden etsai guztiak behera/eskumara/ezkerrera mugitzeko 
			
		}
	}
	public void ezabatuEtsai (Etsai e) {
		etsaiak.remove(e);
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
				Etsai et = new EtsaiTxikia(pos[0], pos[1]);
				et.sortuEtsaia();
				this.etsaiak.add(et);
			}
			
		}
	
	
	
	//*************************JOKALARIAREN METODODAK:**************************
	public Jokalari getJokalari() {
		return jokalari;
	}
	
	public void mugituJokalariaX(int i) {
		this.jokalari.mugituJokalariaX(i);
	}
	public void mugituJokalariaY(int i) {
		this.jokalari.mugituJokalariaY(i);
	}
	public void shoot() {
		this.jokalari.shoot();
	}
		
	
	//**********************************************************
	public void kolisioakKonprobatu( int pX, int pY) {
		Iterator<Tiro> itrT = this.getTiroIterator();
		
		ArrayList<Tiro> ezabatuTiroak = new ArrayList<Tiro>();
		ArrayList<Etsai> ezabatuEtsai = new ArrayList<Etsai>();
		
		//TIROAK KONPROBATU
		/*while (itrT.hasNext()) {
			Tiro t = itrT.next();
			if (t.getKolisionatu()) {
				//tiroa gorde gerorako
				ezabatuTiroak.add(t);
				itrT.remove();
			}
		}*/
		//ETSAIAK KONPROBATU
		//if (!ezabatuTiroak.isEmpty()) {
			for (Etsai e : etsaiak) {
				//Etsai bakoitzeko kolisionatu duten tiro guztiak konprobatu
				//for (Tiro t : ezabatuTiroak) {
					if(e.kolisioakKonprobatu(pX,pY)) {
						boolean hilDa = e.bizitzaKendu();
						if (hilDa) {
							etsaiak.remove(e);
							break;
						}
					}
				}
			
		
		etsaiak.removeAll(ezabatuEtsai);
		
		//bukaerako baldintza konprobatzeko da hau etsaiak ez badaude eta jokoaMartxan badago
		//Hau checkJokoa metodoa erabiltzeko era zuzenean da
		if (etsairikEz()) {
		    this.checkJokoa();
		}
	}
	
}

