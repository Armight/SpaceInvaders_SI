package modelPackage;

public abstract class Jokalari extends Itsasontzi {

	
	
	protected Jokalari(int pX, int pY, boolean pErakutsi,int pixelKop) {
		super(pX, pY, pErakutsi);
		
	}
	
	
	
	//4 PIXELEKO JOKALARIAREN METODOAK:
	
	protected void sortuJokalari4pixel(int pX, int pY) {//ontzia sortu koord hoietan
		
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria"); //ontziaren erdiko pixela
			
		
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");//ontziaren ezkerreko pixela
			
		
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");//ontziaren eskumako pixela
			
		
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");//ontziaren goiko pixela
			
		}
	
	
	protected void mugituX4Pixel(int i) {
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		if((i<0 && this.getX()-1>0)||(i>0&&this.getX()+1<60)) {
			
				espazioa.getGelaxka(this.getX()-i, this.getY()).setEgoera("Hutsik");//eskumako pixela kendu 
				espazioa.getGelaxka(this.getX(), this.getY()+1).setEgoera("Hutsik");//goiko pixela kendu 
			
				this.setPosizio(getX()+i, getY());//posizio berria atzitu jokalariari
			
				espazioa.getGelaxka(this.getX()+i, this.getY()).setEgoera("Jokalaria");//ezkerreko pixela jarri
				espazioa.getGelaxka(this.getX(), this.getY()+1).setEgoera("Jokalaria");//goiko pixela jarri
			}
			
			
		}
	protected void mugituY4Pixel(int i) {
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		if((i<0 && this.getY()<100)||(i>0&&this.getX()+1<0)) {
			espazioa.getGelaxka(this.getX(), this.getY()-i).setEgoera("Hutsik");//goiko pixela kendu
			espazioa.getGelaxka(this.getX()-1, this.getY()).setEgoera("Hutsik");//ezkerreko pixela kendu
			espazioa.getGelaxka(this.getX()+1, this.getY()).setEgoera("Hutsik");//eskumako pixela kendu
			
			super.setPosizio(getX(), getY()+i);//posizio berria sartu jokalariari
			
			espazioa.getGelaxka(this.getX(), this.getY()).setEgoera("Jokalaria");//erdiko pixela jarri (oin gauden tokian)
			espazioa.getGelaxka(this.getX()+1, this.getY()).setEgoera("Jokalaria");//eskumako pixela jarri
			espazioa.getGelaxka(this.getX()-1, this.getY()).setEgoera("Jokalaria");//ezkerreko pixela jarri
			
		}
		
		
		
		
	}
		






}
	
