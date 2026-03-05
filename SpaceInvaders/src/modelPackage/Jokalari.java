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
			
		
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");//ontziaren goiko pixela
			
		}
	
	
	private void mugituX4Pixel(int i) {
		EspazioModel espazioa=EspazioModel.getGelaxkaMatrizea();
		if((i<0 && this.getX()-1>0)||(i>0&&this.getX()+1<60)) {
			
				espazioa.getGelaxka(this.getX()-i, this.getY()).setEgoera("Hutsik");//eskumako pixela kendu 
				espazioa.getGelaxka(this.getX(), this.getY()-1).setEgoera("Hutsik");//goiko pixela kendu 
			
				this.setPosizio(getX()+i, getY());//posizio berria atzitu jokalariari
			
				espazioa.getGelaxka(this.getX()+i, this.getY()).setEgoera("Jokalaria");//ezkerreko pixela jarri
				espazioa.getGelaxka(this.getX(), this.getY()-1).setEgoera("Jokalaria");//goiko pixela jarri
			}
			
			
		}
	private void mugituY4Pixel(int i) {
		EspazioModel espazioa=EspazioModel.getGelaxkaMatrizea();
		if((i<0 && this.getY()<100)||(i>0&&this.getY()+1<0)) {
			espazioa.getGelaxka(this.getX(), this.getY()+i).setEgoera("Hutsik");//goiko pixela kendu
			espazioa.getGelaxka(this.getX()-1, this.getY()).setEgoera("Hutsik");//ezkerreko pixela kendu
			espazioa.getGelaxka(this.getX()+1, this.getY()).setEgoera("Hutsik");//eskumako pixela kendu
			
			super.setPosizio(getX(), getY()-i);//posizio berria sartu jokalariari
			
			espazioa.getGelaxka(this.getX(), this.getY()).setEgoera("Jokalaria");//erdiko pixela jarri (oin gauden tokian)
			espazioa.getGelaxka(this.getX()+1, this.getY()).setEgoera("Jokalaria");//eskumako pixela jarri
			espazioa.getGelaxka(this.getX()-1, this.getY()).setEgoera("Jokalaria");//ezkerreko pixela jarri
			
		}
		
		
		
		
	}
		






}
	
