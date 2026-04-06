package modelPackage;

public class Tiro   implements TiroElementua, Pixel{
	private int x,y;
	
    protected Tiro(int pX, int pY) {
        	this.x=pX;
        	this.y=pY;
    }
    
	@Override
	public void sortu() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mugituX(int i) {
		// TODO Auto-generated method stub	
	}
	
	@Override
    public void mugituY(int i) {
    		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");  //Oraingo pixela kendu
    	
    		int yBerria = getY() - 1;
    	    		
    		setPosizio(getX(), yBerria);
    		    		
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Tiro");
    		
			espazioa.etsaiKolisioakKonprobatu(this.getX(),this.getY(), this);
			
    		if (this.espaziotikKanpo(getY())) {
    			espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik"); 
    			espazioa.removeTiro(this);
    			return;
    		}
	}
    

	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
	}

    public boolean espaziotikKanpo(int pY) {
    		if (pY < 2) { //Bakarrik gorantz jaurtitzean jarritako muga
    			return true;
    		} else return false;
    }
    
    public boolean kolisioakKonprobatu(int pX, int pY) {
    	if (getX() == pX && getY() == pY) {
			return true;
		} else return false;
    }

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
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
	public void ezabatu() {
		// TODO Auto-generated method stub
		
	}

	
}