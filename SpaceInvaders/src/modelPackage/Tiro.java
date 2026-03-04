package modelPackage;

public abstract class Tiro extends Mugimendu {
    
	protected Tiro(int pX, int pY, boolean pErakutsi) {
		super(pX, pY, pErakutsi); //poner true porque siempre se crea visible no?
	}
	    
    public void mugitu() {
        int newY = getY() - 1;
        setPosizio(getX(), newY);
        
        if (newY < 0) {
            setIkusmena(false);
        }
    }


}
