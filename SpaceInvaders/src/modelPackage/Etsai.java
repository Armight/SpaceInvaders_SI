package modelPackage;

public class Etsai implements Pixel {
	
	private int x, y, bizitza, id;
	private int xBerria, yBerria, random;
	
    public Etsai(int pX, int pY, int pId) {
        x = pX;
        y = pY;
        bizitza = 1;
        id = pId;

        xBerria = pX;
        yBerria = pY;

    }
    
    //ETSAI METODO OROKORRAK:
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public int getBizitza() {
		return this.bizitza;
	}

	@Override
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
	
	@Override
	public boolean bizitzaKendu() {
		int bizitza = this.getBizitza();
		bizitza = bizitza - 1;
		if (bizitza <=0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
			return true;
		} else return false;
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
		if (espazioa.espaziotikKanpo(xBerria, getY())) {
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

    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
    		return;
    	}

    	espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		
		this.setPosizio(getX(), yBerria);

    	espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
    	espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
	}
    
    public void mugituRandom() {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	boolean kolisionatu = espazioa.etsaiEtsaiKolisioak(xBerria, yBerria, id);
    	if (kolisionatu) return;
        
    	//Herentziaz int parametro bat sartu beharra dago
		//Etsaien posizioak dagoeneko kalkulatu dira
    	//beraz ez da parametroa erabiliko
        if (random == 0) {
        		mugituX(0); // ezkerrera
        } else if (random == 1) {
        		mugituX(0);  // eskumara
        } else {
        		mugituY(0);  // behera			
        }
    }
	
	public void posizioRandom() {
		random = (int)(Math.random() * 3); //0, 1 edo 2
		if (random == 0) {
			xBerria = xBerria - 1;
		} else if (random == 1) {
			xBerria = xBerria + 1;
		} else {
			yBerria = yBerria + 1;
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean etsaiKolisioak(int pX, int pY, int pId) {
		boolean kolisionatu = false;
		if (xBerria == pX && yBerria == pY && id != pId) {
			kolisionatu = true;
		}
		return kolisionatu;
	}
	
    public boolean kolisioakKonprobatu(int pX, int pY) {
    	boolean kolisionatu = false;
    	if (getX() == pX && getY() == pY) {
    		kolisionatu = true;
    	}
    	return kolisionatu;
	}

}

