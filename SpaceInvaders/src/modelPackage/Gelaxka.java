package modelPackage;

import viewPackage.Observer;

public class Gelaxka extends Observable{
	private int posX;
	private int posY;
	private String egoera;
	private Observer observer;
	
	private Gelaxka() {
		
	}
	
	public Gelaxka(int pX, int pY, String pEgoera) {
		this.posX = pX;
		this.posY = pY;
		this.egoera = pEgoera;
	}

	@Override
	public void addObserver(Observer observer) {
		this.observer = observer;
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observer = null;
		
	}
	
	public void eguneratuEgoera(String pEgoera) {
		this.egoera = pEgoera;
		this.notifyObservers();
	}

	private void notifyObservers() {
		this.observer.update(this.egoera);
	}
	
	public void setEgoera(String pEgoera) {
		this.egoera=pEgoera;
	}
	

}
