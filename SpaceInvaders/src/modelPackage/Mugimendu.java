package modelPackage;

public abstract class Mugimendu {

	private int x, y;
	private boolean erakutsi;//??
	private  int pixelKop;
	
	protected Mugimendu(int pX, int pY, boolean pErakutsi, int pPixelKop) {
		this.x= pX;
		this.y=pY;
		this.erakutsi=pErakutsi;
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
	 
	 
	 protected void setIkusmena(boolean pErakutsi) {
		 this.erakutsi=pErakutsi;
	 }
	
	 public boolean espaziotikKanpo(int pX, int pY) {
		 boolean kanpoan=false;
		 if(pX<0 || pX> EspazioModel.getGelaxkaMatrizea().getZabalera()) {
			 kanpoan=true;
		 }
		 if(pY<0 || pY>EspazioModel.getGelaxkaMatrizea().getAltuera()) {
			 kanpoan=true;
		 }
		 return kanpoan;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	
}

