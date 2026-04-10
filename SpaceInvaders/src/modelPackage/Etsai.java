package modelPackage;

public class Etsai implements Pixel {
	
	private int x, y, bizitza, id;
	private int xBerria, yBerria, random;
	
    public Etsai(int pX, int pY, int pId) {
        x = pX;
        y = pY;
        xBerria = pX;
        yBerria = pY;
        id = pId;
        bizitza = 1;
    }
    
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(x, y).setEgoera("Etsaia");
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
	public int getXBerria() {
		return xBerria;
		
	}

	@Override
	public int getYBerria() {
		return yBerria;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	
	@Override
	public void setRandom(int r) {
		random = r;
		xBerria = x;
		yBerria = y;
		if (random == 0) {
        	xBerria = x -1; // ezkerrera
        } else if (random == 1) {
        	xBerria = x +1;  // eskumara
        } else {
        	yBerria = y +1;  // behera			
        }
	}
	
	@Override
	public boolean mugituRandom() {
		ezabatu();
		if (random == 0) {
			x = x - 1;
        	return mugituX(-1); // ezkerrera
        } else if (random == 1) {
        	x = x + 1;
        	return mugituX(1);  // eskumara
        } else {
        	y = y + 1;
        	return mugituY(1);  // behera			
        }
	}
	
	@Override
	public boolean mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		if (xLimiteakKonprobatu(i)) return true;
	    x = xBerria;
	    this.sortu();
	    return true;
	}

	
	@Override
	public boolean mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		if (yLimiteakKonprobatu(i)) return false;
		y = yBerria;
		this.sortu();
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		if (xBerria < 0 || xBerria > 99) return true;
		return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		if (yBerria > 59) return true;
		return false;
	}
	
	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.x, this.y).setEgoera("Hutsik");
	}
	
	@Override
	public int bizitzaKendu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		bizitza = bizitza - 1;
		if (bizitza <= 0) {
	    	espazioa.getGelaxka(x, y).setEgoera("Hutsik");
			return -1;
		} else return 0;
	}

	@Override
	public boolean kolisioak(Pixel pPixel) {
		return pPixel.kolisioakKonprobatu(this);
	}
	
	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		return pEtsai.etsaiEtsaiKonprobatu(this);
	}

	@Override
	public boolean kolisioakKonprobatu(Pixel pPixel) {
		if (x == pPixel.getX() && y == pPixel.getY()) {
			return true;
		} return false;
	}
	
	@Override
	public boolean etsaiEtsaiKonprobatu(Pixel pEtsai) {
		if (xBerria == pEtsai.getXBerria() && yBerria == pEtsai.getYBerria()) {
			return true;
		} return false;
	}
	
	
	@Override
	public void shoot() {
		// TODO Auto-generated method stub
	}
}

