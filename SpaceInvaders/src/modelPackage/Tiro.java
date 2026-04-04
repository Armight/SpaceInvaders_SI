package modelPackage;

public class Tiro extends Pixel {
	protected boolean kolisionatu = false;
	
    protected Tiro(int pX, int pY) {
        	super(pX, pY, 0);
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
    		espazioa.getGelaxka(getX(), getY()).setEgoera(new HutsikEgoera());  //Oraingo pixela kendu
    	
    		int yBerria = getY() - 1;
    		super.setPosizio(getX(), yBerria);
    		
    		String egoera = espazioa.getGelaxka(getX(), getY()).getEgoera();
    		if (egoera.equals("Etsaia")) {
    			kolisionatu = true;
    			espazioa.kolisioakKonprobatu(this.getX(),this.getY());
    			espazioa.getGelaxka(getX(), getY()).setEgoera(new HutsikEgoera()); 
    			espazioa.removeTiro(this);
    			return;
    		}
    		
    		if (this.espaziotikKanpo(getY())) {
    			espazioa.getGelaxka(getX(), getY()).setEgoera(new HutsikEgoera()); 
    			espazioa.removeTiro(this);
    			return;
    		}
    		espazioa.getGelaxka(getX(), getY()).setEgoera(new TiroEgoera());
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
    
    public boolean getKolisionatu( ) {
    		return kolisionatu;
    }










    
}