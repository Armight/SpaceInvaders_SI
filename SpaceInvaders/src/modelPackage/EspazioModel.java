package modelPackage;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	private ArrayList<Pixel> tiroak;
	private ArrayList<Pixel> etsaiak; 
	private ArrayList<Pixel> pwrUp;
	private Pixel jokalari;
	private Pixel finalBoss;
	private boolean finalBossAktibo = false;
	private Timer timerEtsaiak;	//Timer bat etsaientzako kasu honetan 200ms-koa izango dena
	private Timer timerTiroak; //Timer bat tiroentzako, ezberdina 50ms-koa izango dena
	private Timer timerPwrUp;
	
	private int score;
	
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
	    pwrUp = new ArrayList<Pixel>();
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
	
	public boolean finalBosikEz() {
		if (PartidaKudeatzailea.getPartidaKudeatzailea().getJokoaMartxan()) {
			return !finalBossAktibo; //Aktibo ez dagoenean ez dago finalBosik, beraz metodoak true itzuli
		}        return false;
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
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		pk.setJokoaMartxan();
		int pXErdia = EspazioModel.getGelaxkaMatrizea().getZabalera() / 2; //50
		int pYBehean = EspazioModel.getGelaxkaMatrizea().getAltuera() - 2; //48
		
	    //jokalaria instantziatu
	    //jokalari = new Jokalari(pXErdia, pYBehean);
		String kolorea = pk.getKolorea();
		
		jokalari = JokalariFactory.getJokF().createJokalaria(kolorea, pXErdia, pYBehean);
	    
	    //Jokalaria eta etsaiak sortu
	    jokalari.sortu();
	    
	    if (pk.getMaila().equals("CHILL")) {
	    	this.sortuEtsaiZerrenda(5);
	    } else {
	    	finalBossAktibo = true;
	    	finalBoss = new FinalBossMultipixel(50, 10);
	    	
	    	int[] kont = {0};
	    	int[] pY = {15};
	    	sortuEtsaiZerrenda(pY[0]);
	    	Timer t = new Timer(3 * 1000, e -> {
	    		
	    		kont[0]++;
	    		pY[0] = pY[0] -5;
	    		
	    		sortuEtsaiZerrenda(pY[0]);
	    		
	    		if (kont[0] == 2) {
	    			((Timer)e.getSource()).stop();
	    		}
	    		
	    		
	    	});
	    	t.start();
	    	if (etsairikEz()) {
			    finalBoss.sortu();	
	    	}
	    }
	    
	    //Timerrak eraikitzailearen kanpoan
	    timerEtsaiak = sortuTimerEtsaiak();
	    timerTiroak  = sortuTimerTiroak();
	    timerPwrUp = sortuTimerPwrUp();
	    timerEtsaiak.start();
	    timerTiroak.start();
	    timerPwrUp.start();
	}
////////////////////////////////////////////////////////////////////////////////////////

	private Timer sortuTimerEtsaiak() {
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
	    return new Timer(200, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (PartidaKudeatzailea.getPartidaKudeatzailea().getJokoaMartxan()) {
	            	if (pk.getMaila().equals("CHILL") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
	            		mugituEtsaiak();
	            	} else {
	            		mugituFinalBoss();
	            	}
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
	                //PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
	            }
	        }
	    });
	}
////////////////////////////////////////////////////////////////////////////////////////

	
	private Timer sortuTimerPwrUp() {
	    return new Timer(400, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (PartidaKudeatzailea.getPartidaKudeatzailea().getJokoaMartxan()) {
	                mugituPowerUpak();
	            }
	            
	        }
	    });
	}
	
	public void geldituTimerrak() {
	    if (timerEtsaiak != null) timerEtsaiak.stop();
	    if (timerTiroak != null) timerTiroak.stop();
	    if (timerPwrUp != null) timerPwrUp.stop();
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
		this.tiroak =  tiroakCopia.stream()
				.peek(t -> t.ezabatu())
				.filter(t -> {
		            boolean mugituDa = ((Pixel) t).mugituY(-1);
		            if (!mugituDa) {
		                if (t instanceof TiroInfo) {
		                    score += ((TiroInfo) t).getPKenketa();
		                    if (score<0) {
		                    	score = 0;
		                    }
		                    PartidaKudeatzailea.getPartidaKudeatzailea().eguneratuPuntuazioa(score);
		                }
		            }
		            return mugituDa;
		        })
				.collect(Collectors.toCollection(ArrayList::new));
			new ArrayList<>(this.tiroak).forEach(t -> this.tiroKolisioak(t));
	}
	
	private Iterator<Pixel> getTiroIterator() {
		return this.tiroak.iterator();
	}

//******************************ETSAIEN METODOAK:	********************************
	private void mugituEtsaiak() {
	    // 1. Listaren kopia
	    List<Pixel> etsaiakKopia = new ArrayList<>(etsaiak);

	    // 2. Etsai bakoitzari randoma esleitu JAVA8 lambda + forEach
	    etsaiakKopia.forEach(e -> e.setRandom((int)(Math.random() * 3)));

	    // 3. Mugimendua JAVA8 Streams
	    etsaiakKopia.stream()
	        // Filtratu etsaiak ez dutenak beste etsai batzukin kolisionatuko JAVA8 filter
	        .filter(e -> !etsaiEtsaiKolisioak(e))
	        // Etsai bakoitza mugitu+konprobatu JAVA8 forEach
	        .forEach(e -> {
	            if (e.mugitu()) {
	                
	                etsaiKolisioak(e);
	                etsaiJokalariKolisioak(e);
	            } else {
	                PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
	            }
	        });
	}
	
	public void removeEtsai (Pixel e) {
		etsaiak.remove(e);
	}
	
	private Iterator<Pixel> getEtsaiIterator() {
		return etsaiak.iterator();
	}
	
	
	//ETSAIEN ARRAYAREN METODOAK:
																	
		private void sortuEtsaiZerrenda(int pY) {
			//8 etsaiek har dezaketen posizioen ArrayList-a sortu
			//(10,5), (20, 5) ... (80,5)
			ArrayList<int[]> etsaiPosizioak = new ArrayList<int []>();
			int pX= 0;
			for (int i = 0; i < 8; i++) {
				pX = pX + 10;
				etsaiPosizioak.add(new int [] {pX, pY});
			}
			//Posizio guztiak nahastu
			Collections.shuffle(etsaiPosizioak);
			//4...8 etasien arteko zenbaki random bat sortu
			//int etsaiKop = 8;
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
	
	public void mugituJokalariaX(int i) { //Jokalari ezabatu kendu mugituX egiten delako eta horrela bug-a ekiditzen dugu
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		if (jokalari == null) return;
		
		if (!jokalari.mugituX(i)) return;
		if (pk.getMaila().equals("CHILL") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
			this.jokalariEtsaiKolisioak(jokalari);
		} else {
			this.jokalariFinalBossKolisioak(jokalari);
		}
	}
	
	
	public void mugituJokalariaY(int i) { //Jokalari ezabatu kendu mugituY egiten delako eta horrela bug-a ekiditzen dugu
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		if (jokalari == null) return;
		
		if (!jokalari.mugituY(i)) return;
		if (pk.getMaila().equals("CHILL") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
			this.jokalariEtsaiKolisioak(jokalari);
		} else {
			this.jokalariFinalBossKolisioak(jokalari);
		}
	}
	
	public void shoot() {
		if (jokalari == null) return;
		jokalari.shoot();
	}
	
	//*************************POWER UP-aren METODODAK:**************************
	
	public void sortuPwrUp(int pX, int pY) {
	    // %35 probabilitatea powerup bat sortzeko gure kasuan 
		if (pX < 0 || pX > 99 || pY < 0 || pY > 59) {
	        return;
	    }
	    if (Math.random() < 0.35) {
	        PowerUp pu = new PowerUp(pX, pY);
	        pu.sortu();
	        pwrUp.add(pu);
	    }
	}
	
	private void mugituPowerUpak() {
		ArrayList<Pixel> powerUpakKopia = new ArrayList<>(pwrUp);

	    for (Pixel pu : powerUpakKopia) {
	        pu.ezabatu();// mugituTiro metodoaren antzera implementatuta
	        boolean mugitu = pu.mugituY(1);  // 1 da eta ez -1 tiroen kontrako noranzkoan doazelako

	        if (!mugitu) {
	            // Limitera ailegatzean
	            pwrUp.remove(pu);
	        }
	    }

	    // Jokalariarekin kolisioak konprobatu
	    new ArrayList<>(pwrUp).forEach(pu -> pwrUpJokalariKolisioa(pu));
	}
	
	private void pwrUpJokalariKolisioa(Pixel pPowerUp) {
	    if (jokalari != null && jokalari.kolisioak(pPowerUp)) {
	        ((PowerUp) pPowerUp).aplikatu();   // munizio guztia kargatu
	        pPowerUp.ezabatu();
	        pwrUp.remove(pPowerUp);
	    }
	}
	
	//*************************KOLISIOEN METODODAK:**************************
	
	public boolean tiroaDago(int pX, int pY) {
		if(this.matrizea[pY][pX].getEgoera().equals("Tiro")) {return true;}
		return false;
	}

	//Tiroak metodo hau deitu tiroaren eta etsai guztien arteko kolisioak konprobatzeko
	public void tiroKolisioak(Pixel pTiro) {
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		if (pk.getMaila().equals("CHILL") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
			Iterator<Pixel> itr = this.getEtsaiIterator(); 
			
			while(itr.hasNext()) {
				Pixel e = itr.next();
				if(e.kolisioak(pTiro)) {
					if (pTiro instanceof TiroInfo) {
						TiroInfo ti = (TiroInfo) pTiro;
						score += ti.getPGehiketa();
						PartidaKudeatzailea.getPartidaKudeatzailea().eguneratuPuntuazioa(score);
					}
					pTiro.ezabatu();
					tiroak.remove(pTiro);
					int hilDa = e.bizitzaKendu();
					if (hilDa < 0) { 
						itr.remove();
						this.sortuPwrUp(e.getX(), e.getY()); //etsaia hil den tokian sortu powerUp-a
					}
				}
				
			}
			
			//bukaerako baldintza konprobatzeko da hau etsaiak ez badaude eta jokoaMartxan badago
			//Hau checkJokoa metodoa erabiltzeko era zuzenean da
			if (pk.getMaila().equals("CHILL") && etsairikEz()) {
				PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
			}
		} else {
			if (finalBoss.kolisioak(pTiro)) {
				if (pTiro instanceof TiroInfo) {
					TiroInfo ti = (TiroInfo) pTiro;
					score += ti.getPGehiketa()*2;
				}
				pTiro.ezabatu();
				tiroak.remove(pTiro);
				int hilDa = finalBoss.bizitzaKendu();
				if (hilDa < 0) {
					finalBoss.ezabatu();
					finalBossAktibo = false;
					PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(false);
				}
			}
		}
		
	}
	
	//Etsaiak metodo hau deitu etsaiaren eta tiro guztien arteko kolisioak konprobatzeko
	public void etsaiKolisioak(Pixel pEtsai) {
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		Iterator<Pixel> itr = this.getTiroIterator(); 
		
		while(itr.hasNext()) {
			Pixel t = itr.next();
			if(t.kolisioak(pEtsai)) {
				if (t instanceof TiroInfo) {
					TiroInfo ti = (TiroInfo) t;
					score += ti.getPGehiketa();
					PartidaKudeatzailea.getPartidaKudeatzailea().eguneratuPuntuazioa(score);
				}
				t.ezabatu();
				itr.remove();
	 			int hilDa = pEtsai.bizitzaKendu();
				if (hilDa < 0) { 
					if (pk.getMaila().equals("CHILL") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
						etsaiak.remove(pEtsai);
						this.sortuPwrUp(pEtsai.getX(), pEtsai.getY());
					} else {
						finalBoss.ezabatu();
						finalBossAktibo = false;
						PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(false);
					}
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
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
		}
	}
	
	public void jokalariEtsaiKolisioak(Pixel pJokalari) {
		Iterator<Pixel> itr = this.getEtsaiIterator(); 
		
		while(itr.hasNext()) {
			Pixel e = itr.next();
			if(e.kolisioak(pJokalari)) {
				PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);	
			}
		}
	}

	//*************************FINALBOSS METODODAK:**************************

	public int[][] getJokalariarenKoordenatuak() {
		int koordenatuak [][]= new int[][] {{jokalari.getX(), jokalari.getY()}};
		return koordenatuak;
	}
	
	public void mugituFinalBoss() {
		if (finalBoss == null) return;
        finalBoss.mugitu();
        finalBossJokalariKolisioak(finalBoss);
        etsaiKolisioak(finalBoss);
	}
	
	public void jokalariFinalBossKolisioak(Pixel pJokalari) {
		if (finalBoss == null) return;
		if (finalBoss.kolisioak(pJokalari)) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
		}
	}
	
	public void finalBossJokalariKolisioak(Pixel pFinalBoss) {
		if (finalBoss == null) return;
		if (jokalari.kolisioak(pFinalBoss)) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
		}
	}
		


//*************************JAVA 8 METODOAK:**************************

	private void forEachEtsaiDo(Consumer<Pixel> action) {
	    new ArrayList<>(etsaiak).forEach(action);
	}
}

