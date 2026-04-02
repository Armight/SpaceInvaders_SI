package modelPackage;

public abstract class Tiro extends Pixel {
	protected boolean kolisionatu = false;
	
    protected Tiro(int pX, int pY) {
        
        	super(pX, pY, -1);
        
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