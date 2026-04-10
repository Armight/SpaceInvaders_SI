package modelPackage;

import java.util.*;

public class JokalariMultipixel implements Pixel{
	
	private ArrayList<Pixel> jokalariKol = new ArrayList<Pixel>();
	private int x, y;
	private String kolorea;
	
	JokalariMultipixel(int pX, int pY, String pKolorea) {
		x = pX;
		y = pY;
		kolorea = pKolorea;
		
		int posizioak [][] = new int[][] {{0,0}, {1,0}, {-1,0}, {0,-1}};
		
		for (int[] pos : posizioak) {
			Jokalari j = new Jokalari(x + pos[0], y + pos[1], kolorea);
			jokalariKol.add(j);
			}
		}
		
	@Override
	public void sortu() {
		for (Pixel j : jokalariKol) {
			j.sortu();
		}
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
	public boolean mugituX(int i) {
		if (xLimiteakKonprobatu(i)) return false;
		
		this.ezabatu();
		x = x + i;
		for (Pixel j : jokalariKol) {
			j.mugituX(i);
		}
		return true;
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) return false;

		this.ezabatu();
		y = y - i;
		for (Pixel j : jokalariKol) {
			j.mugituY(i);
		}
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		for (Pixel j : jokalariKol) {
			if (j.xLimiteakKonprobatu(i)) return true;
		}
		return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		for (Pixel j : jokalariKol) {
			if (j.yLimiteakKonprobatu(i)) return true;
		}
		return false;
	}
	
	@Override
	public void ezabatu() {
		for (Pixel j : jokalariKol) {
			j.ezabatu();
		}	
	}
	
	@Override
	public void shoot() {
		if (y <= 2) {
			return;
		}else {
			Pixel tiro = new Tiro(x, y - 10);
			tiro.sortu();
			EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
		}
	}
	
	@Override
	public boolean kolisioak(Pixel pEtsai) {
		for (Pixel j : jokalariKol) {
			if (j.kolisioak(pEtsai)) return true;
		}
		return false;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		for (Pixel j : jokalariKol) {
			if (j.kolisioakKonprobatu(pEtsai)) return true;
		}
		return false;
	}

	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean mugituRandom() {
		// TODO Auto-generated method stub
		return false;		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void setRandom(int r) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean etsaiEtsaiKonprobatu(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getXBerria() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYBerria() {
		// TODO Auto-generated method stub
		return 0;
	}
}
