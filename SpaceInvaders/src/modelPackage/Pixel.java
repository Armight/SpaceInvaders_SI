package modelPackage;

public abstract class Pixel {

	private int x, y;
	private int bizitza;
	
	
	protected Pixel(int pX, int pY, int pBizitza) {
		this.x = pX;
		this.y = pY;
		this.bizitza = pBizitza;
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
	 
	 public abstract boolean bizitzaKendu();
	 
	 public abstract void mugituX(int i);
	 
	 public abstract void mugituY(int i);
	 
	 public abstract void sortu();
		
}

