package modelPackage;

import java.util.Observable;

public class Gelaxka extends Observable{
	private int posX;
	private int posY;
	private Egoera egoera;	//!!IZEN ALDAKETA egoeraa --> egoera
	
	
	public Gelaxka(int pX, int pY) {
		this.posX = pX;
		this.posY = pY;
		//this.egoera = pEgoera;
		this.egoera = new HutsikEgoera(); //!!IZEN ALDAKETA egoeraa --> egoera
	}
	
	
	public void setEgoera(String pEgoera) {
		this.egoera.setEgoera(posX, posY); //!!IZEN ALDAKETA egoeraa --> egoera
		setChanged();
		this.notifyObservers(pEgoera);
	}
	
	public void egoeraAldatu(Egoera pEgoera) {
		this.egoera = pEgoera; //!!IZEN ALDAKETA egoeraa --> egoera
	}
	
	public String getEgoera() {
		return egoera.getEgoera();
	}
	

}
