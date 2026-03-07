package modelPackage;

import java.util.ArrayList;


public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	
	private ArrayList<Tiro> tiroak;
	private ArrayList<Etsai> etsaiak; //TODO: ETSAIEN METODOAK
	
	private EspazioModel() {
		matrizea = new Gelaxka[60][100];
		//inizializatzeko zuzenean
	    for (int i = 0; i < 60; i++) {
	        for (int j = 0; j < 100; j++) {
	            matrizea[i][j] = new Gelaxka(i, j, "hutsik dago");
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

		
			
//Setchange && notify (== metodoak) observer, bistan ezin daitezke objetuak interkambiatu bien artean, bakarrik emari deitu and egoera ikusi EDO String-ak bidali, View-k ez ditu objeturik erabiliko
	
	public Gelaxka getGelaxka(int pX, int pY) {//posizio horren gelaxka lortu
		return this.matrizea[pX][pY];
	}
	
	//MATRIZEAREN METODOAK
	
	public int getZabalera() {//x
		return this.matrizea.length;
	}
	
	public int getAltuera() {//y
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
	
	
	
	
	//UPDATE:
	public void update() {
		
		this.mugituTiroak();
		this.mugituEtsaiak();
		
		
	    
	}

}
