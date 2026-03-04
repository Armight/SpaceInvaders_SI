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
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		if(pX-1>0) {
			espazioa.getGelaxka(pX, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX-1, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX+1, pY).setEgoera("Jokalaria");
			
		
			espazioa.getGelaxka(pX, pY+1).setEgoera("Jokalaria");
			
		
	}}}

