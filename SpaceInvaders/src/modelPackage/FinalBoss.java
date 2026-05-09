package modelPackage;

public class FinalBoss implements Pixel {
	
	private int x, y;
	
	public FinalBoss(int pX, int pY) {
		x = pX;
		y = pY;
	}

	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(x, y).setEgoera(new FinalBossEgoera());
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
	public boolean mugituX(int i) {
		x = x + i;
		ezabatu();
		this.sortu();
		return false;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		if (x + i < 0 || x + i > 99) return true;
		return false;
	}
	
	@Override
	public boolean mugituY(int i) {
		y = y + i;
		ezabatu();
		this.sortu();
		return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		if (y + i > 59 || y + i < 0) return true;
		return false;
	}

	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.x, this.y).setEgoera(new HutsikEgoera());		
	}
	
	@Override
	public boolean kolisioak(Pixel pPixel) {
		return pPixel.kolisioakKonprobatu(this);
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pPixel) {
		if (x == pPixel.getX() && y == pPixel.getY()) {
			return true;
		} return false;
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
	public boolean mugitu() {
		// TODO Auto-generated method stub
		return false;
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
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aldatuTiroa() {
		// TODO Auto-generated method stub
		
	}

}
