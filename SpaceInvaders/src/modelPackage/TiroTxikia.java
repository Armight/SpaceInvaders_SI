package modelPackage;

public class TiroTxikia extends Tiro {
	
	private static int dmg=1;

    public TiroTxikia(int pX, int pY) {
        super(pX, pY, 1);
    }
    
    
    
    public int getDMG() {
    	return TiroTxikia.dmg;
    }
    
    
    
    public void mugitu() {
    	
    	EspazioModel espazio= EspazioModel.getGelaxkaMatrizea();

    	espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Hutsik");//oraingo pixel kendu

        super.setPosizio(getX(), super.getY()-1); // pixel bat igo

        
        if (super.espaziotikKanpo(getX(), getY())) {//espaziotik irteten bada, ezabatu
        	super.removeTiro();
           
        }
        else {
        	espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Tiro");//ez bada espaziotik irten, gelaxka berriaren egoera aldatu
        	}
        }
    }
