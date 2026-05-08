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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
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
	public boolean mugituRandom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xLimiteakKonprobatu(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean yLimiteakKonprobatu(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kolisioakKonprobatu(Pixel p) {
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
	public boolean mugituX(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mugituY(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ezabatu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean kolisioak(Pixel p) {
		// TODO Auto-generated method stub
		return false;
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
