package modelPackage;

import java.util.ArrayList;

public class Jokalari implements Pixel {
	private ArrayList<Pixel> pixelak;
	private int x,y;//pixel zentrala

	protected String kolorea;
	
	protected Jokalari(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		pixelak.add(new PixelSimple(x, y));			//erdiko pixel
		pixelak.add(new PixelSimple(x + 1, y));		//eskumako pixel
		pixelak.add(new PixelSimple(x - 1, y));		//ezkerreko pixel
		pixelak.add(new PixelSimple(x, y - 1));		//goiko pixel
	
	}
	
	//JOKALARI METODO OROKORRAK:		
	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari_" + this.kolorea);
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
		//TODO MUGIMENDU BERRIA- 4 PIXEL
		//posizio zaharra matrizetik kendu
		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		//posizio berria atzitu
		this.setPosizio(getX()+i, getY());
		
		espazioa.jokalariKolisioakKonprobatu(getX(), getY());
		
		//posizio berria matrizean jarri
		espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari_" + this.kolorea);
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
		
		espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari_" + this.kolorea);	
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

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
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
	
	private void konprobatuX(int x, int y) {
		
	}



}
	

