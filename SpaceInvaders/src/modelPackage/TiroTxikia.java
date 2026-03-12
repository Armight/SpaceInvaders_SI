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


        
        //Oraingo pixela etsai bat da, beraz "hutsik" egoeran jarri eta kolisio bat gertatu dela notifikatu
        if (espazio.getGelaxka(getX(), getY()-1).getEgoera().equals("Etsai")) {
        	super.kolisionatu = true; 
    		espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Hutsik");//ez bada espaziotik irten, gelaxka berriaren egoera aldatu
        	
        } else {
        	espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Hutsik");//oraingo pixel kendu
        	super.setPosizio(getX(), super.getY()-1); // pixel bat igo
        	if (super.espaziotikKanpo(getY())) {//espaziotik irteten bada, ezabatu
        		super.removeTiro();         
        	}
        
        	else {
        		espazio.getGelaxka(super.getX(), super.getY()).setEgoera("Tiro");//ez bada espaziotik irten, gelaxka berriaren egoera aldatu
        	}
        }
    }
}
