package modelPackage;

public class Jokalari implements Pixel {

	private int x, y, bizitza;
	private String kolorea;
	protected TiroPortaera tiroPortaera;

	
	public Jokalari(int pX, int pY, String pKolorea) {
		x = pX;
		y = pY;
		kolorea = pKolorea;
		bizitza = 1;
		
	}
		
	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(x, y).setEgoera(new JokalariEgoera());
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
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		if (xLimiteakKonprobatu(i)) return false;
		
		x = x + i;
		this.sortu();
		return true;	
	}
	
	@Override
	public boolean mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		if (yLimiteakKonprobatu(i)) return false;
		
		y = y - i;
		this.sortu();
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		int xBerria = x + i;
		if (xBerria < 0 || xBerria > 99) return true;
		return false;
	}

	@Override
	public boolean yLimiteakKonprobatu(int i) {
		int yBerria = y - i;
		if (yBerria < 0 || yBerria > 59) return true;
		return false;
	}
	
	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.x, this.y).setEgoera(new HutsikEgoera());
	}
	
	@Override
	public void shoot() {
		if (y <= 2) {
			return;
		}else {
			tiroPortaera.shoot(getX(), getY());
		}
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
		// TODO Auto-generated method stub
		return false;		
	}



	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
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
	
