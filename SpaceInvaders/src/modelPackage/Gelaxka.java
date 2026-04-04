package modelPackage;

import java.util.Observable;

public class Gelaxka extends Observable{
	private int posX;
	private int posY;
	private Egoera egoera;
	
	
	public Gelaxka(int pX, int pY) {
		this.posX = pX;
		this.posY = pY;
		this.egoera = new HutsikEgoera(); 
	}
		
	public void setEgoera(String pEgoera) {
		this.egoera.setEgoera(this); 
		setChanged();
		this.notifyObservers(pEgoera);
	}
		
	public void egoeraAldatu(Egoera pEgoera) {
		this.egoera = pEgoera; 
	}
	
	public String getEgoera() {
		return egoera.getEgoera();
	}

}
