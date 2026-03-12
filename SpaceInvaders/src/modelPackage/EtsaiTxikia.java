package modelPackage;

public class EtsaiTxikia extends Etsai {
    
    public EtsaiTxikia(int pX, int pY) {
    	//Etsai txikiaren pixelKop = 1, bizitza = 1, 
        super(pX, pY, 1);
        super.bizitza = 1;
    }
    
    @Override
    public void sortuEtsaia() {//Estaia matrizean sortzeko eta gehitzeko
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
	}
    
    @Override
    public void mugituEtsaiX(int i) {
    	//i=1 denean, eskumarantz mugitu
    	//i=-1 denean, ezkerrerantz mugitu
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	int xBerria = this.getX() + i;
    	if (espazioa.espaziotikKanpo(xBerria, getY())) {
    		return;
    	}

    	EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
    	this.setPosizio(getX()+i, getY());
    	EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Etsaia");
    }
    
    @Override
    public void mugituEtsaiY() {//etsaia bakarrik beherantz doa
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	int yBerria = this.getY() + 1;
    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		espazioa.setJokoaAmaitu();
    		return;
    	}
    	
    	espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
    	this.setPosizio(getX(), getY()+1);
    	espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
    }
       
}