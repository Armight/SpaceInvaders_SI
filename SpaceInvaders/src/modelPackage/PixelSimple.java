package modelPackage;

public class PixelSimple implements Pixel{
	private int x,y;

	public PixelSimple(int pX,int pY) {
		this.x=pX;
		this.y=pY;
	}
	
	@Override
	public void mugituX(int i) {
		this.x=this.x+i;
		
	}

	@Override
	public void mugituY(int i) {
		this.y=this.y - i;
		
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public int getBizitza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
		
	}

	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void sortu() {
		// TODO Auto-generated method stub
		
	}
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.getX(), this.getY()).setEgoera("Hutsik");
	}

}
