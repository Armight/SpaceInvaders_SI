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

}
