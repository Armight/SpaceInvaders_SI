package modelPackage;

public class JokalariTxikia extends Jokalari {//4 pixeleko ontzia
	
	
	

	public JokalariTxikia(int pX, int pY, boolean pErakutsi, int pixelKop) {
		super(pX, pY, pErakutsi, pixelKop);
		
	}

	public void sortuJokalari4pixel(int pX, int pY) {//ontzia sortu koord hoietan
		
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria"); //ontziaren erdiko pixela
			
		
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");//ontziaren ezkerreko pixela
			
		
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");//ontziaren eskumako pixela
			
		
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");//ontziaren goiko pixela
			
		}
		
		
	
	
	
	protected void mugituEzkerrera4Pixel() {
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		if(this.getX()-1>0) {
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");
			
		
	}}}

