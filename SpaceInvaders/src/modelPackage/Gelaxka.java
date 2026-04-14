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
		
	public void setEgoera(Egoera berria) {
	    this.egoera = berria;
	    setChanged();
	    notifyObservers(berria.getIzena());
	}
	
	public Egoera getEgoera() {
		return egoera.getEgoera();
	}

}
