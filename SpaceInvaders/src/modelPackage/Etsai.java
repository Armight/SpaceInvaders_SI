package modelPackage;

//Komentario prueba
public abstract class Etsai extends Itsasontzi {
	//eraikitzaile ondo ipini
	//proba push
	private int bizitza;
	
    protected Etsai(int pX, int pY, boolean pErakutsi, int pPixelKop, int pBizitza) {
        super(pX, pY, pErakutsi, pPixelKop);
        this.bizitza=pBizitza;
    }
    
    

    
    //MUGITZEKO:
    
    public void mugituX(int i) {
    	//i=-1 ezkerrera mugitu
    	//i=1 eskumara mugitu
    	if(!EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX()+i, getY())) {
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
    		this.setPosizio(getX()+i, getY());
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	}
    }
    
    
    public void mugituY() {//etsaia bakarrik beherantz doa
    	if(!EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX(), getY()+1)) {
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
    		this.setPosizio(getX(), getY()+1);
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	}
    }
    
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
    
    public void sortuEtsaia(int pX, int pY) {//Estaia matrizean sortzeko eta gehitzeko
    	if(!EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(pX, pY)) {
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(pX, pY).setEgoera("Etsaia");
    		EspazioModel.getGelaxkaMatrizea().addEtsai(this);
    	}
    }
    
    public void ezabatuEtsai() {
    	this.ezabatuEtsai();
    }
    
    public int bizitzaKendu() {
    	bizitza = bizitza - 1;
    	if (this.bizitza == 0) {
    		this.ezabatuEtsai();
    		return 0;
    	} else return -1;
    	
    }
    
    public boolean beheraHeldu() {//matrizearen beherarte heltzen bada, jokalaria hil behar da
    	if(EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX(), getY()+1)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().partidaAmaitu(false);
    	}
    }
  
    
    

    
    protected void ezabatuEtsaia() {
    	EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
        EspazioModel.getGelaxkaMatrizea().removeEtsai(this);
           
    }
}

    
    
    
