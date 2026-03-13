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
    	if (espazioa.getGelaxka(xBerria, getY()).getEgoera().equals("Tiro")) {
    		this.bizitzaKendu();
    		return;
    	}
    	
    	String egoera = espazioa.getGelaxka(xBerria, getY()).getEgoera();
    	if (egoera.equalsIgnoreCase("Etsaia")) return;
    	
    	espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
        this.setPosizio(xBerria, getY());
        espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    }
    
    @Override
    public void mugituEtsaiY() {//etsaia bakarrik beherantz doa
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	int yBerria = this.getY() + 1;

    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		espazioa.setJokoaAmaitu();
    		return;
    	}
    	if (espazioa.getGelaxka(getX(), yBerria).getEgoera().equals("Tiro")) {
    		this.bizitzaKendu();
    		return;
    	}
    	
    	String egoera = espazioa.getGelaxka(getX(), yBerria).getEgoera();
    	if (egoera.equalsIgnoreCase("Etsaia")) return;
    	else {
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
        	this.setPosizio(getX(), yBerria);
        	espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	}
    }
       
}