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
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
	
	@Override
	public void mugituX(int i) {
		if (this.xLimiteakKonprobatu()) return;
		for (Pixel j : jokalariKol) {
			j.mugituX(i);
		}
	}
	
	@Override
	public boolean xLimiteakKonprobatu() {
		for (Pixel j : jokalariKol) {
			if (j.xLimiteakKonprobatu()) return true;
		}
		return false;
	}

	

	

	

	@Override
	public void mugituRandom() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public boolean yLimiteakKonprobatu() {
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

	

	@Override
	public void mugituY(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ezabatu() {
		// TODO Auto-generated method stub
		
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
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public HashSet<String> setRandom(int r) {
		// TODO Auto-generated method stub
		return null;
	}
}
