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
		if (super.getPixelKop()==4) {
			this.sortuJokalari4pixel(pX, pY);
		}
	}
	
	public void mugituJokalariaX(int i) {
		if (super.getPixelKop()==4) {
			this.mugituX4Pixel(i);
			
		}
	}
	
	public void mugituJokalariaY(int i) {
		if (super.getPixelKop()==4) {
			this.mugituY4Pixel(i);
			
		}
	}
	
	

	
	
	
	
	
	
	
	//4 PIXELEKO JOKALARIAREN METODOAK:
	private void sortuJokalari4pixel(int pX, int pY) {//ontzia sortu koord hoietan
		
		EspazioModel espazioa=EspazioModel.getGelaxkaMatrizea();
		
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria"); //ontziaren erdiko pixela
			
		
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");//ontziaren ezkerreko pixela
			
		
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");//ontziaren eskumako pixela
			
		
			espazioa.getGelaxka(pX, pY-1).setEgoera("Jokalaria");//ontziaren goiko pixela
			
		}
	
	private void mugituX4Pixel(int i) {
		//i=-1 denean, eskumarantz mugitu
		//i=1 denean, ezkerrerantz mugitu
		
		EspazioModel espazioa=EspazioModel.getGelaxkaMatrizea();
		
		//Limite horizontalak zehaztu
		int zabalera = espazioa.getZabalera();
		
		//Eskumarantz mugitu nahi bada eta eskumako pixelaren hurrengoa limitea bada
		if (i == -1 && getX() + 1 >= zabalera - 1) return;
		//Ezkerrerantz mugitu nahi bada eta ezkerreko pixelaren hurrengoa limitea bada
		if (i == 1 && getX() - 1 <= 0) return;
		
		espazioa.getGelaxka(this.getX()+i, this.getY()).setEgoera("Hutsik"); 
		espazioa.getGelaxka(this.getX(), this.getY()-1).setEgoera("Hutsik"); 
			
		this.setPosizio(getX()-i, getY());//posizio berria atzitu jokalariari
			
		espazioa.getGelaxka(this.getX()-i, this.getY()).setEgoera("Jokalaria");
		espazioa.getGelaxka(this.getX(), this.getY()-1).setEgoera("Jokalaria");
	}
	
	private void mugituY4Pixel(int i) {//TODO METODO HAU KONPROBATU ONDO DAGOEN
		//i=-1 denean, gorantz mugitu
		//i=1 denean, beherantz mugitu
		EspazioModel espazioa=EspazioModel.getGelaxkaMatrizea();
		
		//Limite bertikalak zehaztu
		int altuera = espazioa.getAltuera();
		
		//Gorantz egin nahi duzu baina hurrengo pixela (x, 0) posizioan badago
		if (i == -1 && getY() - 2 <= 0) return;
		//Beherantz egin nahi duzu baina hurrengo pixela (x, altuera max) posizioan dago
		if (i == 1 && getY() + 1 >= altuera - 1) return;

		espazioa.getGelaxka(this.getX(), this.getY()).setEgoera("Hutsik");
		espazioa.getGelaxka(this.getX(), this.getY()-1).setEgoera("Hutsik");
		espazioa.getGelaxka(this.getX()-1, this.getY()).setEgoera("Hutsik");
		espazioa.getGelaxka(this.getX()+1, this.getY()).setEgoera("Hutsik");
		
		super.setPosizio(getX(), getY()+i);//posizio berria sartu jokalariari
			
		sortuJokalari4pixel(getX(), getY());	
	}
}
		







	
