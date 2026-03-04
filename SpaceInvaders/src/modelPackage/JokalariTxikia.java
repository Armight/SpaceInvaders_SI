package modelPackage;

public class JokalariTxikia extends Jokalari {//4 pixeleko ontzia
	
	
	

	public JokalariTxikia(int pX, int pY, boolean pErakutsi, int pixelKop) {
		super(pX, pY, pErakutsi, pixelKop);
		
	}

	public void sortuJokalari4pixel(int pX, int pY) {
		
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		if(pX-1>0) {
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");
			
		}
		
		
	}
	
	
	protected void mugituEzkerrera4Pixel() {
		if (super.getX()-1>0) {
			int i=1;
			GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
			if(i==1) {//ontziaren eskumako pixel kendu
				espazioa.getGelaxka(this.getX()+1, this.getY()).setEgoera("Hutsik");
				
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
	}
}
