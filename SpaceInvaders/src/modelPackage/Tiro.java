package modelPackage;

public class Tiro implements Pixel {
	
	private int x, y;
	
    public Tiro(int pX, int pY) {
        x = pX;
        y = pY;
    }
    
    @Override
	public void sortu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(x, y).setEgoera("Tiro");
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
    public boolean mugituY(int i) {
			
    		if (yLimiteakKonprobatu(i)) {
    			return false;
    		}
    		
    		y = y -1;
       		sortu();
       		return true;
    }
	
	public void mugituYSinple() {this.y=y-1;
	sortu();}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		int yBerria = y + i;
		if (yBerria < 2) {
			return true;
		} else return false;
	}

	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(x, y).setEgoera("Hutsik");
	}
	
	@Override
    public boolean kolisioak(Pixel pEtsai) {
    	return pEtsai.kolisioakKonprobatu(this);
    }
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		if (x == pEtsai.getX() && y == pEtsai.getY()) {
			return true;
		} return false;
	}

    @Override
	public boolean mugituX(int i) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRandom(int r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mugituRandom() {
		// TODO Au
		return false;
		
	}

	@Override
	public boolean xLimiteakKonprobatu(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean etsaiEtsaiKonprobatu(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getXBerria() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYBerria() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void aldatuTiroa() {}
}