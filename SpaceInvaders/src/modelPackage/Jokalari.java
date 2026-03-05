package modelPackage;

public abstract class Jokalari extends Itsasontzi {

	
	
	protected Jokalari(int pX, int pY, boolean pErakutsi,int pixelKop) {
		super(pX, pY, pErakutsi);
		
	}
	
	protected void mugituEzkerrera(GelaxkaMatrizea espazio) {
		if (super.getX()>0) {
			Gelaxka g=GelaxkaMatrizea.getGelaxkaMatrizea().getGelaxka(this.getX(), this.getY());
			g.setEgoera("Hutsik");
			
			this.setPosizio(getX()-1, getY());
			GelaxkaMatrizea.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalaria");
			
			
		}
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
	
		






}
	
