package modelPackage;

public abstract class Tiro extends Mugimendu {

    protected Tiro(int pX, int pY,int pPixelKop) {
        super(pX, pY, true, pPixelKop);  // true=visible, 1=pixel bakarra Sprint 1ean
    }
    
    //Polimorfismo:
    public void mugitu() {}
    
    public void removeTiro() {
    	EspazioModel.getGelaxkaMatrizea().removeTiro(this);
    }
    
    public boolean espaziotikKanpo(int pY) {
    	if (pY < 2) { //Bakarrik gorantz jaurtitzean jarritako muga
    		return true;
    	} else return false;
    }
    
    public void bizitzaKendu() {
    	
    }
    
    public boolean kolisioakKonprobatu() {
		return false; }

    
}