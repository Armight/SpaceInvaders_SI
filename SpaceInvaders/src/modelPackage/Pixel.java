package modelPackage;

public interface Pixel {

									//!!!MODIFICAR DE PUBLIC A PRIVATE
	public abstract void sortu();
	
	public int getX();
	
	public int getY();
	
	public int getBizitza();
	
	public void setPosizio(int pX, int pY);
	 
	public abstract boolean bizitzaKendu();
	 
	public abstract void mugituX(int i);
	 
	public abstract void mugituY(int i);
		
}

