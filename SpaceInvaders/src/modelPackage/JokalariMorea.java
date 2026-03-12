package modelPackage;

public class JokalariMorea extends Jokalari {//1.sprinterako bakarrik, hurrengoetan ya Gorria, Berdea, Urdina kodetu
												//tiro bakarra du: pixel bateko tiroa.
		
	public JokalariMorea(int pX, int pY) {
		//JokalariMorearen pixelKop = 1, bizitza = 1, kolorea = Morea
		super(pX, pY, 1, 1, "Morea");
	}
	
	@Override
	public void sortuJokalaria() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");
	}
	
	@Override
	public void mugituJokalariaX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	int xBerria = this.getX() + i;
    	if (espazioa.espaziotikKanpo(xBerria, getY())) {
    		return;
    	}
		
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
		this.setPosizio(getX()+i, getY());//posizio berria atzitu
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
	}
	
	@Override
	public void mugituJokalariaY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	int yBerria = this.getY() - i;
    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		return;
    	}
    	
		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
		this.setPosizio(getX(), getY()-i);//posizio berria atzitu
		espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
	}
	
	@Override
	public void shoot() {
		TiroTxikia tiro = new TiroTxikia(getX(), getY() -2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
}

