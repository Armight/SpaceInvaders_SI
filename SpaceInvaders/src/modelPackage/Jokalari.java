package modelPackage;

public abstract class Jokalari extends Itsasontzi {

	
	//eraikitzaile ondo ipini
	protected Jokalari(int pX, int pY, boolean pErakutsi,int pixelKop) {
		super(pX, pY, pErakutsi,pixelKop);
		
	}
	
	//POLIMORFISMO:
	
	public void shootPixel() {
		TiroTxikia tiro=new TiroTxikia(getX(), getY() -2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
	
	public void shootGezi() {}
	public void shootErronbo() {}
	
	
	//JOKALARI METODO OROKORRAK:
	
	public void sortuJokalaria(int pX, int pY) {
		
		this.setPosizio(pX, pY);
		EspazioModel.getGelaxkaMatrizea().getGelaxka(pX, pY).setEgoera("Jokalari");
		
	}
	
	public void mugituJokalariaX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		if(!EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX()+i, getY())) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
			this.setPosizio(getX()+i, getY());//posizio berria atzitu
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
		}
			
		
	}
	
	public void mugituJokalariaY(int i) {
		
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		if(!EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(getX(), getY()-i)) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
			this.setPosizio(getX(), getY()-i);//posizio berria atzitu
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
				
		}}
	}
	
	

	
	
	
	
	
	
	
	

		







	
