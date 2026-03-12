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
    	int newX=this.getX()+i;
    	
    	boolean kanpo=EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX()+i, getY());
    	String egoera= EspazioModel.getGelaxkaMatrizea().getGelaxka(newX, getY()).getEgoera();
    	if(egoera.equalsIgnoreCase("Etsaia")) {   	}//beste etsai bat badago mugitu nahi den lekuan, ez da mugituko
    	else if (egoera.equalsIgnoreCase("Jokalaria")) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().jokoaBukatu();
    	}//etsaiak jokalaria ikutu du, jokoa amaitzen da
    	else if(egoera.equalsIgnoreCase("Tiro")) {
    		this.bizitzaKendu();
    	}
    	else if(!kanpo) {this.mugimenduaGaratuX(i);}
    }
    
    
    public void mugimenduaGaratuX(int i) {
    	//i=-1 ezkerrera mugitu
    	//i=1 eskumara mugitu
    	
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
    		this.setPosizio(getX()+i, getY());
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
    }
    
    public void mugituY() {//etsaia bakarrik beherantz doa
    	
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
    		this.setPosizio(getX(), getY()+1);
    		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
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
    
    
    
    public int bizitzaKendu() {
    	bizitza = bizitza - 1;
    	if (bizitza <= 0) {
            
            EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
        }
    	return bizitza;
    	
    }
    
    public void beheraHeldu() {//matrizearen beherarte heltzen bada, jokalaria hil behar da
    	if(EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX(), getY()+1)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().jokoaBukatu();
    	}
    }
  
    
    protected void ezabatuEtsaia() {//ALDATU BEHAR DA, ESPAZIO MODEL-EN JARRI
    	EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
        EspazioModel.getGelaxkaMatrizea().removeEtsai(this);
           
    }
    
    protected boolean kolisioakKonprobatu (int pX, int pY) {
    	if (getX() == pX && getY() == pY) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
}

