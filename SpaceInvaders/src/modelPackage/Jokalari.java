package modelPackage;

public class Jokalari extends Pixel {

	protected String kolorea;
	
	protected Jokalari(int pX, int pY) {
		super(pX, pY, 1);
	
	}
	
	//JOKALARI METODO OROKORRAK:		
	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari");
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int xBerria = this.getX() + i;
		
		if (espazioa.espaziotikKanpo(xBerria, getY())) {
			return;
		}
		
		//jokalariaren tiro bat badago mugitu nahi den gelaxkan, ezingo da mugitu
		if (espazioa.getGelaxka(xBerria, getY()).getEgoera().equalsIgnoreCase("Tiro")) return; 
		
		//posizio zaharra matrizetik kendu
		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		//posizio berria atzitu
		this.setPosizio(getX()+i, getY());
		
		espazioa.jokalariKolisioakKonprobatu(getX(), getY());
		
		//posizio berria matrizean jarri
		espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari");
	}
	
	
	@Override
	public void mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int yBerria = this.getY() - i;
		if (espazioa.espaziotikKanpo(getX(), yBerria)) return;

		if (espazioa.getGelaxka(getX(), yBerria).getEgoera().equalsIgnoreCase("Tiro")) return;
		
		//posizio zaharra matrizetik kendu
		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		
		//posizio berria atzitu
		this.setPosizio(getX(), getY()-i);
		
		espazioa.jokalariKolisioakKonprobatu(getX(), getY());
		
		espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari");	
	}
	
	public String getKolorea() {return this.kolorea;}
	
	public void shoot() {
		if (this.getY() <= 2) {
			return;
		}else {
			Tiro tiro = new Tiro(getX(), getY() -2);
			EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
		}
	}

	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
	}



}
	

