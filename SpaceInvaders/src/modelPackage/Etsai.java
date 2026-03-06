package modelPackage;

public abstract class Etsai extends Itsasontzi {
	//eraikitzaile ondo ipini
	
	private int bizitza;
	
    protected Etsai(int pX, int pY, boolean pErakutsi, int pPixelKop, int pBizitza) {
        super(pX, pY, pErakutsi, pPixelKop);
        this.bizitza=pBizitza;
    }
    
    
    public void hil() {
    	if (this.bizitza<=0) {
    		this.removeEtsai();
    	}
    }
    
    private void removeEtsai() {
    	EspazioModel.getGelaxkaMatrizea().removeEtsai(this);
    }
    
    public void bizitzaKendu() {
    	
    }
    
    public void mugituX(int i) {}
    public void mugituY() {}
    
    public void mugituRandom() {
        int r = (int)(Math.random() * 3); // 0, 1 edo 2

        if (r == 0) {
            mugituX(-1); // ezkerrera
        } else if (r == 1) {
            mugituX(1);  // eskumara
        } else {
            mugituY();  // behera
        }
    }

    
    
    
}