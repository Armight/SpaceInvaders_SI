package modelPackage;

public class TiroTxikia extends Tiro {

    public TiroTxikia(int pX, int pY) {
        super(pX, pY, 1);
    }
    
    public void mugitu() {
    	
    	EspazioModel espazio= EspazioModel.getGelaxkaMatrizea();

    	espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Hutsik");//oraingo pixel kendu

        super.setPosizio(getX(), super.getY()-1); // pixel bat igo

        
        if (super.getY() < 0) {//espaziotik irteten bada, ezabatu
        	espazio.removeTiro(this); 
           
        }
        espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Tiro");//ez bada espaziotik irten, gelaxka berriaren egoera aldatu
        }
    }
