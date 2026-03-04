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
	}}
	
