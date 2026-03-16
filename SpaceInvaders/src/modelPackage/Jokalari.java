package modelPackage;

public abstract class Jokalari extends Espaziontzi {

	private String kolorea;
	
	protected Jokalari(int pX, int pY,int pixelKop, int pBizitza, String pKolorea) {
		super(pX, pY, pixelKop);
		super.bizitza = 1;
		this.kolorea = pKolorea;
	}
	
	//JOKALARI METODO OROKORRAK:		
	public abstract void sortuJokalaria();
	
	public abstract void mugituJokalariaX(int i);
	
	public abstract void mugituJokalariaY(int i);
	
	public abstract void shoot();
}
	

