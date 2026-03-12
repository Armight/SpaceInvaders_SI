package modelPackage;

public abstract class Mugimendu {

	private int x, y;
	private  int pixelKop;
	protected boolean kolisionatu;
	
	protected Mugimendu(int pX, int pY, int pPixelKop) {
		this.x= pX;
		this.y=pY;
		this.pixelKop=pPixelKop;
	}
	
	public int getPixelKop() {
		return this.pixelKop;
	}
	protected int getX() {
		return this.x;
	}
	protected int getY() {
		return this.y;
	}
	 protected void setPosizio(int pX, int pY) {
		 this.x=pX;
		 this.y=pY;
	 }
	 
	 /*
	 protected void setIkusmena(boolean pErakutsi) {
		 this.erakutsi=pErakutsi;
	 }*/
	 
	
 
	
}

