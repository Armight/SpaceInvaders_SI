package modelPackage;

public abstract class Etsai extends Itsasontzi {
	//eraikitzaile ondo ipini
	//proba push
	private int bizitza;
	
    protected Etsai(int pX, int pY, boolean pErakutsi, int pPixelKop, int pBizitza) {
        super(pX, pY, pErakutsi, pPixelKop);
        this.bizitza=pBizitza;
    }
    
    

    
    //POLIMORFISMO:
    
    public void mugituX(int i) {}
    
    
    public void mugituY() {}
    
    public boolean kolisioakKonprobatu(int pX, int pY) { 
    	return false;
    }
    
    //MUGIMENDU SEUDORANDOM-A SORTU
    
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
   
    //ETSAIAREN SORRERA/EZABAKETA METODOAK:
    
    public void sortuEtsaia(int pX, int pY) {
    	if (super.getPixelKop() == 4) {
    		this.sortuEtsai(pX, pY);
    	}
    }
    
    public void ezabatuEtsai() {
    	if (super.getPixelKop() == 4) {
    		this.ezabatuEtsaia();
    	}
    }
    
    public int bizitzaKendu() {
    	bizitza = bizitza - 1;
    	if (this.bizitza == 0) {
    		this.ezabatuEtsai();
    		return 0;
    	} else return -1;
    	
    }
    
    //4 PIXELEKO ETSAIAREN METODOAK:
    protected void sortuEtsai(int pX, int pY) {
    	
    }
    

    
    protected void ezabatuEtsaia() {
           
    }
}

    
    
    
