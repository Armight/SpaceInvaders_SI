package modelPackage;

import java.util.*;

public class Jokalari implements Pixel {

	private int x, y, xBerria, yBerria, bizitza;
	private String kolorea;
	
	public Jokalari(int pX, int pY, String pKolorea) {
		x = pX;
		y = pY;
		kolorea = pKolorea;
		bizitza = 1;
	}
	
	//JOKALARI METODO OROKORRAK:
	
	@Override
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Jokalari_" + this.kolorea);
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
			
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
				
		x = xBerria;		
		//Jokalari eta tiroaren arteko kolisioa konprobatu liteke
		//Baina jokalaria ez da hain azkar mugitzen
		
		espazioa.jokalariKolisioakKonprobatu(x, y);
		
		espazioa.getGelaxka(x, y).setEgoera("Jokalari_" + this.kolorea);
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		xBerria = x + i;
		if (xBerria < 0 || xBerria >= 100) return true;
		return false;
	}
	
	@Override
	public void mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
		y = yBerria;
		//Jokalari eta tiroaren arteko kolisioa konprobatu liteke
		//Baina jokalaria ez da hain azkar mugitzen
				
		espazioa.jokalariKolisioakKonprobatu(x, y);
				
		espazioa.getGelaxka(x, y).setEgoera("Jokalari_" + this.kolorea);
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		yBerria = y - i;
		if (yBerria < 0 || yBerria >= 60) return true;
		return false;
	}
	
	@Override
	public void shoot() {
		if (y <= 2) {
			return;
		}else {
			Tiro tiro = new Tiro(x, y - 3);
			EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
		}
	}
	
	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.x, this.y).setEgoera("Hutsik");
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashSet setRandom(int r) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mugituRandom() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kolisioakKonprobatu(int pX, int pY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
	

