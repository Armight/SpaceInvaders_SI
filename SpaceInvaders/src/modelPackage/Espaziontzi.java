package modelPackage;

public abstract class Espaziontzi extends Mugimendu {
	
	protected int bizitza;
	
	protected Espaziontzi(int pX, int pY, int pPixelKop) {
		super(pX, pY, pPixelKop);
	}
	
	protected int getBizitza() {
		return bizitza;
	}
	
	protected boolean bizitzaKendu() {
		bizitza = bizitza - 1;
		if (bizitza == 0) {
			return true;
		} else return false;
	}
}


