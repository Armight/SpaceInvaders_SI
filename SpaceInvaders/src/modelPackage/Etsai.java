package modelPackage;

public abstract class Etsai extends Espaziontzi {
	
    protected Etsai(int pX, int pY, int pPixelKop) {
        super(pX, pY, pPixelKop);
    }
    
    //ETSAI METODO OROKORRAK:
    public abstract void sortuEtsaia();
    
    public abstract void mugituEtsaiX(int i);
    
    public abstract void mugituEtsaiY();
    
    public void mugituRandom() {
        int r = (int)(Math.random() * 3); // 0, 1 edo 2

        if (r == 0) {
           //mugituEtsaiX(-1); // ezkerrera
        } else if (r == 1) {
           //mugituEtsaiX(1);  // eskumara
        } else {
           //mugituEtsaiY();  // behera
        }
    }
    
    public boolean kolisioakKonprobatu (int pX, int pY) {
    	if (getX() == pX && getY() == pY) {
    		return true;
    	} else return false;
    }
    
    
    
    
    
    
    //MUGITZEKO:
    /*
    public void mugituX(int i) {
    	int newX=this.getX()+i;
    	String egoera= EspazioModel.getGelaxkaMatrizea().getGelaxka(newX, getY()).getEgoera();
    	
    	if(egoera.equalsIgnoreCase("Etsaia")) return; //beste etsai bat badago mugitu nahi den lekuan, ez da mugituko
    	else if (egoera.equalsIgnoreCase("Jokalaria")) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().jokoaBukatu(false);
    	}//etsaiak jokalaria ikutu du, jokoa amaitzen da
    	else if(egoera.equalsIgnoreCase("Tiro")) {
    		this.bizitzaKendu();
    	}
    	else if(!kanpo) {this.mugituEtsaiX(i);}
    }*/
    
    
    
    
    
    //MUGIMENDU SEUDORANDOM-A SORTU
    
   
   
    //ETSAIAREN SORRERA/EZABAKETA METODOAK:
    
    
    
    
    /////////ALDATRUUTHRHGEFSD´LFEROTGJFVMKDFKGTJBIKF
    public boolean bizitzaEguneratu() {
    	boolean hilDa = super.bizitzaKendu();
    	if (hilDa) {
            EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
        }
    	return hilDa;
    }
    
    /*
    public void beheraHeldu() {//matrizearen beherarte heltzen bada, jokalaria hil behar da
    	if(EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX(), getY()+1)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().jokoaBukatu(false);
    	}
    }*/
  
    
    protected void ezabatuEtsaia() {//ALDATU BEHAR DA, ESPAZIO MODEL-EN JARRI
    	EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
        EspazioModel.getGelaxkaMatrizea().removeEtsai(this);
           
    }
    

}

