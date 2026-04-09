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
	public void mugituX(int i) {
		for (Pixel j : jokalariKol) {
			j.mugituX(i);
		}
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		for (Pixel j : jokalariKol) {
			if (j.xLimiteakKonprobatu(i)) return true;
		}
		return false;
	}

	@Override
	public void mugituY(int i) {
		for (Pixel j : jokalariKol) {
			j.mugituY(i);
		}		
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		for (Pixel j : jokalariKol) {
			if (j.yLimiteakKonprobatu(i)) return true;
		}
		return false;
	}
	
	@Override
	public void shoot() {
		Pixel j = jokalariKol.get(0); //Goiko pixela
		j.shoot();
	}

	

	

	@Override
	public void mugituRandom() {
		// TODO Auto-generated method stub
		
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
	public void ezabatu() {
		for (Pixel j : jokalariKol) {
			j.ezabatu();
		}	
	}

	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
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
