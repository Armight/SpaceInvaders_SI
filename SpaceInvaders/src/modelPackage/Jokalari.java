package modelPackage;

public abstract class Jokalari extends Itsasontzi {

	
	//eraikitzaile ondo ipini
	public Jokalari(int pX, int pY, boolean pErakutsi,int pixelKop) {
		super(pX, pY, pErakutsi,pixelKop);
		
	}
	
	//JOKALARI METODO OROKORRAK:
	public abstract void shoot();
		
	public void sortuJokalaria(int pX, int pY) {
		this.setPosizio(pX, pY);
	}
	
	public abstract void mugituJokalariaX(int i);
	
	public abstract void mugituJokalariaY(int i);
}
	

