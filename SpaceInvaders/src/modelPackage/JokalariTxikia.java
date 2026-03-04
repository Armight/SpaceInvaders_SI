package modelPackage;

public class JokalariTxikia extends Jokalari {//4 pixeleko ontzia

	public JokalariTxikia(int pX, int pY, boolean pErakutsi, int pixelKop) {
		super(pX, pY, pErakutsi, pixelKop);
		
	}

	public void sortuJokalari4pixel() {
		int i=0;
		GelaxkaMatrizea espazioa=GelaxkaMatrizea.getGelaxkaMatrizea();
		while (i<4) {
			
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
