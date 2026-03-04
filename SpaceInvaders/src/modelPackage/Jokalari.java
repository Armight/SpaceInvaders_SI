package modelPackage;

public abstract class Jokalari extends Itsasontzi {

	private int pixelKop;
	
	protected Jokalari(int pX, int pY, boolean pErakutsi,int pixelKop) {
		super(pX, pY, pErakutsi);
		this.pixelKop=pixelKop;
	}
	
	
}
