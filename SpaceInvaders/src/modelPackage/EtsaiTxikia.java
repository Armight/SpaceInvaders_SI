package modelPackage;

public class EtsaiTxikia extends Etsai {
	
	


    private static int pixelKop = 4;
    //eraikitzailea ondo ipini
    public EtsaiTxikia(int pX, int pY) {
        super(pX, pY, true, pixelKop,1);//etsai txikiaren bizitza=1
        
    }
    
    public void mugituX(int i) {//i=-1 denean, ezkerrerantz mugitu
    							//i=1 denean, eskumarantz mugitu
    	EspazioModel espazio = EspazioModel.getGelaxkaMatrizea();
    	
    	espazio.getGelaxka(getX()-i, getY()).setEgoera("Hutsik");
    	espazio.getGelaxka(getX(), getY()+1).setEgoera("Hutsik");
    	
    	espazio.getGelaxka(getX()+i, getY());//etsaiaren posizio berria
    	
    	espazio.getGelaxka(getX()+i, getY()).setEgoera("Etsaia");
    	espazio.getGelaxka(getX(), getY()+1).setEgoera("Etsaia");
    	
    
    	
    }
    
    public void mugituY(int i) {
    	
    }
    
    
}

