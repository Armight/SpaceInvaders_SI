package modelPackage;

public class JokalariMorea extends Jokalari {//1.sprinterako bakarrik, hurrengoetan ya Gorria, Berdea, Urdina kodetu
												//tiro bakarra du: pixel bateko tiroa.
	

	private static String kolorea="Morea";
	private static int pixelKop = 1;
	


	
	//eraikitzaile ondo ipini
	public JokalariMorea(int pX, int pY, boolean pErakutsi) {
		super(pX, pY, pErakutsi, pixelKop);
	}
	
	@Override
	public void sortuJokalaria(int pX, int pY) {
		super.sortuJokalaria(pX, pY);
		EspazioModel.getGelaxkaMatrizea().getGelaxka(pX, pY).setEgoera("Jokalari");
	}
	
	@Override
	public void mugituJokalariaX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		if(!this.xLimiteak(i)) return;
		
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
		this.setPosizio(getX()+i, getY());//posizio berria atzitu
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
	}
	
	@Override
	public void mugituJokalariaY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		if(!this.yLimiteak(i)) return;
		
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
		this.setPosizio(getX(), getY()-i);//posizio berria atzitu
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
	}
	
	@Override
	public void shoot() {
		TiroTxikia tiro=new TiroTxikia(getX(), getY() -2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
}

