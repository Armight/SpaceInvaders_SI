package modelPackage;

public class Etsai extends Pixel {
	
	int id;
	
    public Etsai(int pX, int pY, int pId) {
        super(pX, pY, 1);
        id = pId;
    }
    
    //ETSAI METODO OROKORRAK:
	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int xBerria = this.getX() + i;

		if (espazioa.espaziotikKanpo(xBerria, getY())) {
    			return;
		}
		
		if (espazioa.etsaiEtsaiKolisioak(xBerria, getY())) {
        	return;
        }
		
		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		        
        this.setPosizio(xBerria, getY());       
		espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
		
		espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
	}
	
	@Override
	public void mugituY(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int yBerria = this.getY() + 1;

    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
    		return;
    	}
    	
    	if (espazioa.etsaiEtsaiKolisioak(getX(), yBerria)) {
        	return;
        }

    	espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		
		this.setPosizio(getX(), yBerria);
    	espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
    	espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
	}
        
    public void mugituRandom() {
        int r = (int)(Math.random() * 3); // 0, 1 edo 2

        if (r == 0) {
        		mugituX(-1); // ezkerrera
        } else if (r == 1) {
        		mugituX(1);  // eskumara
        } else {
        		//Herentziaz int parametro bat sartu beharra dago
        		//Etsaia bakarrik beherantz egin dezake, beraz ez da parametroa erabiliko
        		mugituY(0);  // behera			
        }
    }
    
    public int getId() {
    	return this.id;
    }
    
    public boolean kolisioakKonprobatu (int pX, int pY, int pId) {
    	boolean kolisionatu = false;
    	if (getX() == pX && getY() == pY) {
    		if (this.id != pId) kolisionatu = true;
    	}
    	return kolisionatu;
    }

	@Override
	public boolean bizitzaKendu() {
		int bizitza = super.getBizitza();
		bizitza = bizitza - 1;
		if (bizitza <=0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
			//EspazioModel.getGelaxkaMatrizea().removeEtsai(this);
			return true;
		} else return false;
	}

}

