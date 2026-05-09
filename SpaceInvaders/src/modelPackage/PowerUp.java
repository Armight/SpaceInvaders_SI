package modelPackage;

public class PowerUp implements Pixel{
	private int x,y;
	
	public PowerUp(int pX, int pY) {
		x = pX;
		y = pY;
	}
	
	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(x, y).setEgoera(new PowerUpEgoera());
	}
	@Override
	public void ezabatu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(x, y).setEgoera(new HutsikEgoera());
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) {
			return false;
		}
		
		y = y + 1;
   		sortu();
   		return true;
	}
	
	@Override
	public boolean kolisioak(Pixel pJokalaria) {
		return pJokalaria.kolisioakKonprobatu(this);
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pPixel) {
		if (x == pPixel.getX() && y == pPixel.getY()) {
			return true;
		} return false;
	}

	//metodo hay da dena kargatzeko jokalariarentzako
	public void aplikatu() {
        MunizioKudeatzailea.getMunizioKudeatzailea().denaKargatu();
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
	public boolean yLimiteakKonprobatu(int i) {
		int yBerria = y + i;
		if (yBerria >= 60) {
			return true;
		} else return false;
	}
	
	@Override public int getXBerria() { return x; }
    @Override public int getYBerria() { return y; }
    
    @Override public int getId() {return -1;}
    
    @Override public void setRandom(int r) {}
    @Override public boolean mugitu()                  { return false; }
    
    @Override public boolean xLimiteakKonprobatu(int i)      { return false; }
    @Override public boolean mugituX(int i)                  { return false; }
    
    @Override public int bizitzaKendu()                      { return 0; }
    @Override public void shoot()                            {}
    @Override public void aldatuTiroa()                      {}
    
    @Override public boolean etsaiEtsaiKonprobatu(Pixel p)   { return false; }
    @Override public boolean etsaiKolisioak(Pixel p)         { return false; }
	
}
