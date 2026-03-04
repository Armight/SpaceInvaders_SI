package modelPackage;

public class JokalariTxikia extends Jokalari {//4 pixeleko ontzia
	
	
	

	public JokalariTxikia(int pX, int pY, boolean pErakutsi, int pixelKop) {
		super(pX, pY, pErakutsi, pixelKop);
		
	}

	public void sortuJokalari4pixel(int pX, int pY) {
		int i=1;
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		if(i==1) {//ontziaren erdiko pixel
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria");
			i++;
		}
		else if (i==2) {//ontziaren ezkerreko pixel
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");
			i++;
		}
		else if (i==3) {//ontziaren eskumako pixel
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");
			i++;
		}
		else if (i==4) {//ontziaren goiko pixel
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");
			i++;
		}
		
		
	}
	
	protected void mugituEzkerrera4Pixel(GelaxkaMatrizea espazio) {
		if (super.getX()>0) {
			int i=0;
			while (i<4) {
				
			}
			Gelaxka g=GelaxkaMatrizea.getGelaxkaMatrizea().getGelaxka(this.getX(), this.getY());
			g.setEgoera("Hutsik");
			
			this.setPosizio(getX()-1, getY());
			GelaxkaMatrizea.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalaria");}
		}

}
