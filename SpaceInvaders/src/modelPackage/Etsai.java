package modelPackage;

public class Etsai implements Pixel {
	
	private int x, y, bizitza, id;
	private int xBerria, yBerria;
	
    public Etsai(int pX, int pY, int pId) {
        x = pX;
        y = pY;
        xBerria = pX;
        yBerria = pY;
        id = pId;
        bizitza = 1;
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
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
		
	@Override
	public boolean bizitzaKendu() {
		bizitza = bizitza - 1;
		if (bizitza <=0) {
			this.ezabatu();			
			return true;
		} else return false;
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
		xBerria = xBerria + i;

        this.setPosizio(xBerria, getY());
             
		espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
		
		espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
	}
	
	@Override
	public void mugituY(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
		yBerria = yBerria + i;

    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
    		return;
    	}
		
		this.setPosizio(getX(), yBerria);

    	espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
    	espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
	}
	

	@Override
    public boolean kolisioakKonprobatu(int pX, int pY) {
    	boolean kolisionatu = false;
    	if (getX() == pX && getY() == pY) {
    		kolisionatu = true;
    	}
    	return kolisionatu;
	}

	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.x, this.y).setEgoera("Hutsik");
		
	}

}

