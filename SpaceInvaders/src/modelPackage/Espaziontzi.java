package modelPackage;
public abstract class Espaziontzi extends Mugimendu {
	
	protected int bizitza;
	
	protected Espaziontzi(int pX, int pY, int pPixelKop) {
		super(pX, pY, pPixelKop);
	}
		
	public boolean bizitzaKendu() { //metodo honek kodeak hainbat egoeratatik deitua izan daiteke, kondizio espezifiko batzuk pasatzen badira metodoa == bada, azkenean -1 balioa hartu dezake eta etsaia ez da inoiz hilko, horregatik <= iointzen dugu
		bizitza = bizitza - 1;
		if (bizitza <=0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
			EspazioModel.getGelaxkaMatrizea().ezabatuEtsai((Etsai)this);
			return true;
		} else return false;
	}
}


