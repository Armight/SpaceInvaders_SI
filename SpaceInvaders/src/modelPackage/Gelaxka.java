package modelPackage;

import java.util.Observable;

public class Gelaxka extends Observable{
	private int posX;
	private int posY;
	private String egoera;
	
	
	public Gelaxka(int pX, int pY, String pEgoera) {
		this.posX = pX;
		this.posY = pY;
		this.egoera = pEgoera;
	}
	
	public void setEgoera(String pEgoera) {
		this.egoera=pEgoera;
		setChanged();
		this.notifyObservers(egoera);
	}
	
	public String getEgoera() {
		return egoera;
	}
	

}
