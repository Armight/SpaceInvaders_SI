package modelPackage;

import java.util.Observable;

public class Gelaxka extends Observable{
	private int posX;
	private int posY;
	private Egoera egoeraa;	//!!IZEN ALDAKETA egoeraa --> egoera
	private String egoera;
	
	public Gelaxka(int pX, int pY, String pEgoera) {
		this.posX = pX;
		this.posY = pY;
		this.egoera = pEgoera;
		this.egoeraa = new HutsikEgoera(); //!!IZEN ALDAKETA egoeraa --> egoera
	}
	
	
	public void setEgoera(String pEgoera) {
		this.egoeraa.setEgoera(posX, posY); //!!IZEN ALDAKETA egoeraa --> egoera
		setChanged();
		this.notifyObservers(egoera);
	}
	
	public void egoeraAldatu(Egoera pEgoera) {
		this.egoeraa = pEgoera; //!!IZEN ALDAKETA egoeraa --> egoera
	}
	
	public String getEgoera() {
		return egoeraa.getEgoera();
	}
	

}
