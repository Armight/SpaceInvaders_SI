package modelPackage;

public class Jokalari implements Pixel {//Jokalariaren pixela (leaf)
	private int x, y;
	private int bizitza;

	private String kolorea;
	
	protected Jokalari(int pX, int pY) {
		
		this.kolorea = "Morea";
	}
	
	//JOKALARI METODO OROKORRAK:
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	
	
	
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
		if (espazioa.getGelaxka(getX(), getY()).getEgoera().equals("Etsaia")) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
			
		} else {
			//posizio berria matrizean jarri
			espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari");
		}
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
		if (espazioa.getGelaxka(getX(), getY()).getEgoera().equals("Etsaia")) {
			PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
		} else {
			//posizio berria matrizean jarri
			espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari");	
		}
	}
	
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

	@Override
	public int getBizitza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosizio(int pX, int pY) {
		// TODO Auto-generated method stub
		
	}



}
	

