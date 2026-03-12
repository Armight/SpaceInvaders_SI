package modelPackage;

public abstract class Tiro extends Mugimendu {
	protected boolean kolisionatu = false;
	
    protected Tiro(int pX, int pY,int pPixelKop) {
        super(pX, pY, pPixelKop);
    }
    
    public abstract void mugitu();
    
    public void removeTiro() {
    	EspazioModel.getGelaxkaMatrizea().removeTiro(this);
    }
    
    public boolean espaziotikKanpo(int pY) {
    	if (pY < 2) { //Bakarrik gorantz jaurtitzean jarritako muga
    		return true;
    	} else return false;
    }
    
    public boolean getKolisionatu( ) {
    	return kolisionatu;
    }
    
    
   
    

    
}