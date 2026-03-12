package modelPackage;
public abstract class Espaziontzi extends Mugimendu {
	
	protected int bizitza;
	
	protected Espaziontzi(int pX, int pY, int pPixelKop) {
		super(pX, pY, pPixelKop);
	}
		
	public boolean bizitzaKendu() {
		bizitza = bizitza - 1;
		if (bizitza == 0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
			return true;
		} else return false;
	}
}


