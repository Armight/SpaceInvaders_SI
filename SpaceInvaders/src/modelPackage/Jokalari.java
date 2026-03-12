package modelPackage;

public class Jokalari extends Itsasontzi {

	
	//eraikitzaile ondo ipini
	public Jokalari(int pX, int pY, boolean pErakutsi,int pixelKop) {
		super(pX, pY, pErakutsi,pixelKop);
		
	}
	
	//POLIMORFISMO:
	
	public void shootPixel() {
		TiroTxikia tiro=new TiroTxikia(getX(), getY() -2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
	
	public void shootGezi() {}
	public void shootErronbo() {}
	
	
	//JOKALARI METODO OROKORRAK:
	
	public void sortuJokalaria(int pX, int pY) {
		if(!EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(pX, pY)) {
			this.setPosizio(pX, pY);
			EspazioModel.getGelaxkaMatrizea().getGelaxka(pX, pY).setEgoera("Jokalari");
		}
	}
	
	public void mugimenduaGaratuX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
			this.setPosizio(getX()+i, getY());//posizio berria atzitu
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
		
	}
	
	public void mugituJokalariaY(int i) {
		
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");//posizio zaharra matrizetik kendu
			this.setPosizio(getX(), getY()-i);//posizio berria atzitu
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");//posizio berria matrizean jarri
				
		
	}
	
	
	public void mugituX(int i) {
		
		int newX=this.getX()+i;
    	
    	boolean kanpo=EspazioModel.getGelaxkaMatrizea().espaziotikKanpo(newX, getY());
    	
    	String egoera= EspazioModel.getGelaxkaMatrizea().getGelaxka(newX, getY()).getEgoera();
    	if(egoera.equalsIgnoreCase("Etsaia")) { PartidaKudeatzailea.getPartidaKudeatzailea().jokoaBukatu(false);}//etsai bat badago mugitu garen gelaxkan, hil gara (galdu dugu)
    
    	else if(egoera.equalsIgnoreCase("Tiro")) {}//tiro bat badago mugitu nahi garen lekuan, ezingo gara mugitu
    	else if(!kanpo) {this.mugimenduaGaratuX(i);}
		
		
	}
	
	public void mugituY(int i) {//TODO
		
		
		
		
	}
	
	
	
	
	
	
}
	

