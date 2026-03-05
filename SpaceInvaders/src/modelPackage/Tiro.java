package modelPackage;

public abstract class Tiro extends Mugimendu {

    protected Tiro(int pX, int pY,int pPixelKop) {
        super(pX, pY, true, pPixelKop);  // true=visible, 1=pixel bakarra Sprint 1ean
    }
    
    //Polimorfismo:
    public void mugitu() {}

    
}