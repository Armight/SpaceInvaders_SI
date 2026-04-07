package modelPackage;

public class Tiro implements Pixel {
	
	private int x, y;
	
    protected Tiro(int pX, int pY) {
        x = pX;
        y = pY;
    }
    
    @Override
	public void sortu() {
		// TODO Auto-generated method stub
		
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
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
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
    	    		
    		this.setPosizio(getX(), yBerria);
    		    		
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Tiro");
    		
			espazioa.etsaiKolisioakKonprobatu(this.getX(),this.getY(), this);
			
    		if (this.espaziotikKanpo(getY())) {
    			espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik"); 
    			this.ezabatu();    			
				return;
    		}
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
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.removeTiro(this);
	}

	

	



}