package modelPackage;

public class TiroTxikia extends Tiro {
	
	private static int dmg=1;

    public TiroTxikia(int pX, int pY) {
        super(pX, pY);
    }
    
    
    @Override
    public void mugitu() {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");  //Oraingo pixela kendu
    	
    	int yBerria = getY() - 1;
    	super.setPosizio(getX(), yBerria);
    	String egoera = espazioa.getGelaxka(getX(), getY()).getEgoera();
    	if (egoera.equals("Etsaia")) {
    		kolisionatu = true; if (kolisionatu) System.out.println(kolisionatu);
    		espazioa.kolisioakKonprobatu(this.getX(),this.getY());
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik"); 
    		this.removeTiro();
    		return;
    	} 
    	if (super.espaziotikKanpo(getY())) {
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik"); 
    		super.removeTiro();
    		return;
    	}
    	espazioa.getGelaxka(getX(), getY()).setEgoera("Tiro");
  
    }


	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void mugituX(int i) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mugituY(int i) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void sortu() {
		// TODO Auto-generated method stub
		
	}
    
     
    }
