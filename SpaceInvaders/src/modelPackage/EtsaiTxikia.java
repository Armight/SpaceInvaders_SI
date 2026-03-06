package modelPackage;

public class EtsaiTxikia extends Etsai {
	
    private static int pixelKop = 4;//etsai txikia 4 pixeleko etsaia da
    
    //eraikitzailea ondo ipini
    public EtsaiTxikia(int pX, int pY) {
        super(pX, pY, true, pixelKop,1);//etsai txikiaren bizitza=1
        
    }
    
    public void mugituX(int i) {//i=-1 denean, ezkerrerantz mugitu
    							//i=1 denean, eskumarantz mugitu
    	EspazioModel espazio = EspazioModel.getGelaxkaMatrizea();
    	
    	espazio.getGelaxka(getX()-i, getY()).setEgoera("Hutsik");
    	espazio.getGelaxka(getX(), getY()+1).setEgoera("Hutsik");
    	
    	this.setPosizio(getX()+i, getY());//posizio berria atzitu
    	
    	espazio.getGelaxka(getX()+i, getY()).setEgoera("Etsaia");
    	espazio.getGelaxka(getX(), getY()+1).setEgoera("Etsaia");
    	
    }
    
    public void mugituY() {
    	//etsaia ezin da gorantz mugitu
    	EspazioModel espazio = EspazioModel.getGelaxkaMatrizea();
    	
    	espazio.getGelaxka(getX(), getY()).setEgoera("Hutsik");//erdikoa kendu
    	espazio.getGelaxka(getX()-1, getY()).setEgoera("Hutsik");//ezkerrekoa kendu
    	espazio.getGelaxka(getX()+1, getY()).setEgoera("Hutsik");//eskumakoa kendu
    	
    	this.setPosizio(getX(), getY()+1);//posizio berria
    	
    	espazio.getGelaxka(getX()-1, getY()).setEgoera("Etsaia");
    	espazio.getGelaxka(getX()+1, getY()).setEgoera("Etsaia");
    	espazio.getGelaxka(getX(), getY()+1).setEgoera("Etsaia");
    }
    
    
}

