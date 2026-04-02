package modelPackage;

public class Etsai extends Pixel {
		
    public Etsai(int pX, int pY) {
        super(pX, pY, 1);
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
		if (espazioa.getGelaxka(xBerria, getY()).getEgoera().equals("Tiro")) {
    			this.bizitzaKendu();
    			return;
		}
    	
		String egoera = espazioa.getGelaxka(xBerria, getY()).getEgoera();
    		if (egoera.equalsIgnoreCase("Etsaia")) return;
    	
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
        this.setPosizio(xBerria, getY());
        espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
	}
	
	@Override
	public void mugituY(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int yBerria = this.getY() + 1;

    		if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
    			return;
    		}
    		if (espazioa.getGelaxka(getX(), yBerria).getEgoera().equals("Tiro")) {
    			this.bizitzaKendu();
    			return;
    		}
    	
    		String egoera = espazioa.getGelaxka(getX(), yBerria).getEgoera();
    		if (egoera.equalsIgnoreCase("Etsaia")) return;
    		else {
    			espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
    			this.setPosizio(getX(), yBerria);
    			espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    		}
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
    
    public boolean kolisioakKonprobatu (int pX, int pY) {
    	if (getX() == pX && getY() == pY) {
    		return true;
    	} else return false;
    }

	@Override
	public boolean bizitzaKendu() {
		int bizitza = super.getBizitza();
		bizitza = bizitza - 1;
		if (bizitza <=0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
			EspazioModel.getGelaxkaMatrizea().ezabatuEtsai((Etsai)this);
			return true;
		} else return false;
	}

}

