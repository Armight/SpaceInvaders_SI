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
	//PartidaKudeatzailetik partida amaitzeko beharrezkoa, EZINEZKOA mailan egonez gero
	private boolean finalBossAktibo = false;  
	private int score;
	//Timer bat etsaientzako kasu honetan 200ms-koa izango dena
	private Timer timerEtsaiak;
	//Timer bat tiroentzako, ezberdina 50ms-koa izango dena
	private Timer timerTiroak; 				
	private Timer timerPwrUp;
	
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
			//FinaBoss aktibo EZ dagoenean metodoak "true" itzuliko du
			return !finalBossAktibo;
		}        return false;
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
	    
	    //PRAKTIKA mailan egonda, bakarrik etsaien zerrenda bakarra sortu
	    if (pk.getMaila().equals("PRAKTIKA")) {
	    	this.sortuEtsaiZerrenda(5);
	    	
	    //EZINEZKOA mailan
	    } else {
	    	//FinalBoss aktibatu eta instantziatu
	    	finalBossAktibo = true;
	    	finalBoss = new FinalBossMultipixel(50, 10);
	    	
	    	//Timer-aren barruko kontagailua
	    	int[] kont = {0};
	    	//Timer-aren barruko etsaiZerrendaren Y posizioa
	    	int[] pY = {15};
	    	//Lehenengo etsai zerrendaren sorrera
	    	sortuEtsaiZerrenda(pY[0]);
	    	
	    	Timer t = new Timer(3 * 1000, e -> {
	    		
	    		//Kontagailua eta posizioa eguneratu
	    		kont[0]++;
	    		pY[0] = pY[0] -5;
	    		
	    		//Bigarren eta hirugarren etsaien zerrenda, y = 10, y = 5 posizioetan
	    		sortuEtsaiZerrenda(pY[0]);
	    		
	    		//Timerra birritan aktibatu ostean, gelditu
	    		if (kont[0] == 2) {
	    			((Timer)e.getSource()).stop();
	    		}
	    	});
	    	
	    	//Timerra hasi
	    	t.start();
	    	
	    	//Etsai normalen 3 zerrenda sortu ostean jokalariak etsai guztiak hil baditu FinalBoss sortu
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
	            	
	            	if (pk.getMaila().equals("PRAKTIKA") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
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
	            }
	        }
	    });
	}
	
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
	
	private Iterator<Pixel> getEtsaiIterator() {
		return etsaiak.iterator();
	}
	
	
	//ETSAIEN ARRAYAREN METODOAK:
																	
	private void sortuEtsaiZerrenda(int pY) {

	    // 1. Posizioak  (10, pY), (20, pY)... (80, pY) Streams erabiliz
	    List<int[]> etsaiPosizioak = 
	        java.util.stream.IntStream.rangeClosed(1, 8)
	            .mapToObj(i -> new int[]{i * 10, pY})
	            .collect(java.util.stream.Collectors.toList());

	    // 2. Posizioak
	    java.util.Collections.shuffle(etsaiPosizioak);

	    // 3.  4 - 8 etsai kop
	    int etsaiKop = 4 + (int)(Math.random() * 5);

	    // 4.Estaiak sortu Stream erabiliz
	    java.util.stream.IntStream.range(0, etsaiKop)
	        .mapToObj(i -> {
	            int[] pos = etsaiPosizioak.remove(0);
	            return new EtsaiMultipixel(pos[0], pos[1], i + 1);
	        })
	        .peek(Pixel::sortu) // sortu() estai bakoitzeko
	        .forEach(etsaiak::add); // zerrendara gehitu
	}
		
	
	//*************************JOKALARIAREN METODODAK:**************************
	public Pixel getJokalari() {
		return jokalari;
	}
	
	public void mugituJokalariaX(int i) { //Jokalari ezabatu kendu mugituX egiten delako eta horrela bug-a ekiditzen dugu
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		if (jokalari == null) return;
		
		if (!jokalari.mugituX(i)) return;
		
		//Jokalariaren kolisioak mailaren eta momentuaren araberakoak dira
		if (pk.getMaila().equals("PRAKTIKA") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
			this.jokalariEtsaiKolisioak(jokalari);
		} else {
			this.jokalariFinalBossKolisioak(jokalari);
		}
	}
	
	
	public void mugituJokalariaY(int i) { //Jokalari ezabatu kendu mugituY egiten delako eta horrela bug-a ekiditzen dugu
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		if (jokalari == null) return;
		
		if (!jokalari.mugituY(i)) return;
		
		if (pk.getMaila().equals("PRAKTIKA") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
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
	private void tiroKolisioak(Pixel pTiro) {
		PartidaKudeatzailea pk = PartidaKudeatzailea.getPartidaKudeatzailea();
		if (pk.getMaila().equals("PRAKTIKA") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
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
			if (pk.getMaila().equals("PRAKTIKA") && etsairikEz()) {
				PartidaKudeatzailea.getPartidaKudeatzailea().checkJokoa();
			}
			
		//Kolisioa FinalBoss-arekin konprobatu behar da
		} else {
			if (finalBoss.kolisioak(pTiro)) {
				if (pTiro instanceof TiroInfo) {
					TiroInfo ti = (TiroInfo) pTiro;
					score += ti.getPGehiketa()*2;
				}
				//Kolisioa gertatu da
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
	private void etsaiKolisioak(Pixel pEtsai) {
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
					if (pk.getMaila().equals("PRAKTIKA") || pk.getMaila().equals("EZINEZKOA") && !etsairikEz()) {
						etsaiak.remove(pEtsai);
						this.sortuPwrUp(pEtsai.getX(), pEtsai.getY());
						
					//Kolisioa finalBoss-arekin gertatu da
					} else {
						finalBoss.ezabatu();
						finalBossAktibo = false;
						PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(false);
					}
				}
			}
		}
	}
	
	public boolean etsaiEtsaiKolisioak(Pixel pEtsai) {

	    return etsaiak.stream()
	        // etsai hori bada, ez kexkatu
	        .filter(e -> e.getId() != pEtsai.getId())
	        // estaibat beste batekin kolisionatu...true
	        .anyMatch(e -> e.etsaiKolisioak(pEtsai));
	}
         

	
	private void etsaiJokalariKolisioak(Pixel pEtsai) {
		if (jokalari.kolisioak(pEtsai)) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
		}
	}
	
	private void jokalariEtsaiKolisioak(Pixel pJokalari) {

	    // etsairen batek jokalariarekin talka, jokoa amaitu
	    boolean kolisio = etsaiak.stream()
	        .anyMatch(e -> e.kolisioak(pJokalari));

	    if (kolisio) {
	        PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
	    }
	}


	//*************************FINALBOSS METODODAK:**************************
	//FinalBoss-ak jokalariaren atzetik egiteko jokalariaren koordenatuak behar ditu
	public int[][] getJokalariarenKoordenatuak() {
		int koordenatuak [][]= new int[][] {{jokalari.getX(), jokalari.getY()}};
		return koordenatuak;
	}
	
	private void mugituFinalBoss() {
		if (finalBoss == null) return;
        finalBoss.mugitu();
        finalBossJokalariKolisioak(finalBoss);
        
        //Tiro eta FinalBoss-aren arteko kolisioak begiratzeko
        etsaiKolisioak(finalBoss);
	}
	
	//Jokalariak finalBoss-arekin dituen kolisioak aztertzeko
	private void jokalariFinalBossKolisioak(Pixel pJokalari) {
		if (finalBoss == null) return;
		if (finalBoss.kolisioak(pJokalari)) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
		}
	}
	
	//FinalBoss-ak jokalariarekin dituen kolisioak frogatzeko
	private void finalBossJokalariKolisioak(Pixel pFinalBoss) {
		if (finalBoss == null) return;
		if (jokalari.kolisioak(pFinalBoss)) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu(true);
		}
	}
}

