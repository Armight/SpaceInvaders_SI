package modelPackage;

import java.util.ArrayList;
import java.util.Iterator;

import kudeaketaPackage.PartidaKudeatzailea;


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
	
	public static EspazioModel getGelaxkaMatrizea() {
		if (nGM == null) {
			nGM = new EspazioModel();
		}
		return nGM;
	}
	
	public void setJokalari(Jokalari pJokalari) {
		this.jokalari = pJokalari;
	}
	
	public Gelaxka getGelaxka(int pX, int pY) {//posizio horren gelaxka lortu
		return this.matrizea[pY][pX];
	}
	
	//MATRIZEAREN METODOAK:
	
	public int getAltuera() {//y
		return this.matrizea.length;
	}
	
	public int getZabalera() {//x
		return this.matrizea[0].length;
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
	
	//TIROEN ARRAYAREN METODOAK:
	
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
	
	//ETSAIEN ARRAYAREN METODOAK:
	
	public void removeEtsai(Etsai pEtsai) {
		this.etsaiak.remove(pEtsai);
		pEtsai.bizitzaKendu();
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
	
	private Iterator<Etsai> getEtsaiIterator(){
		return etsaiak.iterator();
	}
	
	public void kolisioakKonprobatu(int pX, int pY) {
		Iterator<Etsai> itr = this.getEtsaiIterator();
		boolean aurkituta = false;
		
		while (itr.hasNext() && !aurkituta) {
			Etsai et = itr.next();
			if (et.kolisioakKonprobatu(pX, pY)) {
				this.removeEtsai(et);
				aurkituta = true;
			}
		}
	}
	
	
	public boolean etsairikEz() {
		return this.etsaiak.isEmpty();
	}
	
	//UPDATE:
	public void update() {
		
		this.mugituTiroak();
		this.mugituEtsaiak();
		
		
	    
	}

}
