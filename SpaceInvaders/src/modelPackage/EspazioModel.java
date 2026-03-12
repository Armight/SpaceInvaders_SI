package modelPackage;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

//PROBA
public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	
	private ArrayList<Tiro> tiroak;
	private ArrayList<Etsai> etsaiak; //TODO: ETSAIEN METODOAK
	private Jokalari jokalari;
	
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
	
	public boolean espaziotikKanpo(int pX, int pY) {
		 boolean kanpoan=false;
		 if(pX<0 || pX> this.getZabalera()) {
			 kanpoan=true;
		 }
		 if(pY<0 || pY>this.getAltuera()) {
			 kanpoan=true;
		 }
		 return kanpoan;
	 }
	
	//JOKOA HASTEKO
	public void jokoanHasi() {
		//Jokalariaren koordenatuak lortu
		int pXErdia = EspazioModel.getGelaxkaMatrizea().getZabalera() / 2; //50
		int pYBehean = EspazioModel.getGelaxkaMatrizea().getAltuera() - 2; //5
		
	    //jokalaria instantziatu
	    jokalari = new JokalariMorea(pXErdia, pYBehean, true, 4);
	    
	    //Jokalaria eta etsaiak sortu
	    jokalari.sortuJokalaria(pXErdia, pYBehean);
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

	public void removeEtsai(Etsai pEtsai) {
		this.etsaiak.remove(pEtsai);
	}
	
	public void addEtsai(Etsai pEtsai) {
		this.etsaiak.add(pEtsai);
	}
	
	private void mugituEtsaiak() {
		ArrayList<Etsai> etsaiakKopia= new ArrayList<Etsai>(this.etsaiak);//gure estaien arrayaren kopia
		for(Etsai e : etsaiakKopia) {
			e.mugituRandom();//pantailan dauden etsai guztiak behera/eskumara/ezkerrera mugitzeko 
		}
	}
	
	
	public void setJokalari(Jokalari pJokalari) {
		this.jokalari = pJokalari;
	}
	

	
	//JOKALARIAREN METODODAK:
	public Jokalari getJokalari() {
		return jokalari;
	}
	
	
	
	//ETSAIEN ARRAYAREN METODOAK:
	public void sortuEtsaiZerrenda() {
		int pX = 50;
		int pY = 5;
		Etsai et = new EtsaiTxikia(50,5);
		et.sortuEtsaia(pX, pY);
		this.etsaiak.add(et);
		
		
		/*
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
			et.sortuEtsaia(pos[0], pos[1]);
			this.etsaiak.add(et);
		}*/
		
	}
	
	
	
	
	
														
	//BEHARREZKOA???
	
	
	private Iterator<Etsai> getEtsaiIterator(){
		return etsaiak.iterator();
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
				//indizea gorde geroago ezabatzeko
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
						int hilDa = e.bizitzaKendu();
						if (hilDa == 0) {
							ezabatuEtsai.add(e);
						}
					}
				}
			}
		}
		etsaiak.removeAll(ezabatuEtsai);
	}
	
	public void etsairikEz() {
		PartidaKudeatzailea kudeatzailea = PartidaKudeatzailea.getPartidaKudeatzailea();
		
		if (this.etsaiak != null && this.etsaiak.isEmpty()) {
			kudeatzailea.jokoaBukatu(true);	//true itzuliko da jokoa irabazi egin denean
		}
	}
	
	//UPDATE:
	public void jokoaEguneratu() {
		this.mugituTiroak();
		this.kolisioakKonprobatu( );
		this.etsairikEz();
		this.mugituEtsaiak();   
	}
}

