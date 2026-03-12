package modelPackage;
public abstract class Espaziontzi extends Mugimendu {
	//Izen aldaketa
	protected int bizitza;
	
	protected Espaziontzi(int pX, int pY, int pPixelKop) {
		super(pX, pY, pPixelKop);
	}
	
	protected int getBizitza() {
		return bizitza;
	}
	
	protected void bizitzaKendu() {
		bizitza = bizitza - 1;
		if (bizitza == 0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
		}
	}
}


