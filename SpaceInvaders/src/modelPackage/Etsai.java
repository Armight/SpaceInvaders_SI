package modelPackage;

public abstract class Etsai extends Itsasontzi {
	//eraikitzaile ondo ipini
	
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
    		this.sortuEtsai4Pixel(pX, pY);
    	}
    }
    
    public void ezabatuEtsai() {
    	if (super.getPixelKop() == 4) {
    		this.ezabatuEtsai4Pixel();
    	}
    }
    
    public void bizitzaKendu() {
    	bizitza = bizitza - 1;
    	if (this.bizitza <= 0) {
    		this.ezabatuEtsai();
    	}
    }
    
    //4 PIXELEKO ETSAIAREN METODOAK:
    protected void sortuEtsai4Pixel(int pX, int pY) {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	
    	espazioa.getGelaxka(pX, pY).setEgoera("Etsai"); //erdiko pixela
		espazioa.getGelaxka(pX-1, pY).setEgoera("Etsai");//ezkerreko pixela
		espazioa.getGelaxka(pX+1, pY).setEgoera("Etsai");//eskumako pixela
		espazioa.getGelaxka(pX, pY+1).setEgoera("Etsai");//beheko pixela
    }
    

    
    protected void ezabatuEtsai4Pixel() {
            EspazioModel espazio = EspazioModel.getGelaxkaMatrizea();

    		espazio.getGelaxka(getX(), getY()).setEgoera("Hutsik");
            espazio.getGelaxka(getX()-1, getY()).setEgoera("Hutsik");
            espazio.getGelaxka(getX()+1, getY()).setEgoera("Hutsik");
            espazio.getGelaxka(getX(), getY()+1).setEgoera("Hutsik");
    }
}

    
    
    
