package modelPackage;

import java.util.*;

public class JokalariMultipixel implements Pixel{
	
	private ArrayList<Pixel> jokalariKol = new ArrayList<Pixel>();
	private int x, y;
	private String kolorea;
	protected TiroPortaera tiroPortaera;
	
	JokalariMultipixel(int pX, int pY, String pKolorea) {
		x = pX;
		y = pY;
		kolorea = pKolorea;
		int posizioak [][];
		if(kolorea.equals("RED")) {
			posizioak = new int[][] {{0,0},{-2,0},{-1,0},{1,0},{2,0},{-1,-1},{1,-1},{-3,1},{-2,1},{-1,1},{1,1},{2,1},{3,1}} ;
		}else if (kolorea.equals("BLUE")){ //urdina
			posizioak = new int[][] {{0,0},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{0,1},{1,1}};
		}
		else  {//berdea
			posizioak = new int[][] {{0,0},{-1,0},{1,0},{0,-1}};
		}
		
		
		for (int[] pos : posizioak) {
			Jokalari j = new Jokalari(x + pos[0], y + pos[1], kolorea);
			jokalariKol.add(j);
			}
		}
		
	@Override
	public void sortu() {
		jokalariKol.stream().forEach(j -> j.sortu());
		//for (Pixel j : jokalariKol) {
			//j.sortu();
		//}
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
		jokalariKol.stream().forEach(j -> j.mugituX(i));
		//for (Pixel j : jokalariKol) {
			//j.mugituX(i);
		//}
		return true;
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) return false;

		this.ezabatu();
		y = y - i;
		jokalariKol.stream().forEach(j -> j.mugituY(i));
		//for (Pixel j : jokalariKol) {
			//j.mugituY(i);
		//}
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(t -> t.xLimiteakKonprobatu(i));
		return konprobatu;
		//for (Pixel j : jokalariKol) {
			//if (j.xLimiteakKonprobatu(i)) return true;
		//}
		//return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(j -> j.yLimiteakKonprobatu(i));
		return konprobatu;
		//for (Pixel j : jokalariKol) {
			//if (j.yLimiteakKonprobatu(i)) return true;
		//}
		//return false;
	}
	
	@Override
	public void ezabatu() {
		jokalariKol.stream().forEach(j -> j.ezabatu());
		//for (Pixel j : jokalariKol) {
			//j.ezabatu();
		//}	
	}
	
	@Override
	public void shoot() {
		if (y <= 2) {
			return;
		}else {
			tiroPortaera.shoot(getX(), getY());
		}
	}
	
	@Override
	public boolean kolisioak(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(j -> j.kolisioak(pEtsai));
		return konprobatu;
		//for (Pixel j : jokalariKol) {
			//if (j.kolisioak(pEtsai)) return true;
		//}
		//return false;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(j -> j.kolisioakKonprobatu(pEtsai));
		return konprobatu;
		//for (Pixel j : jokalariKol) {
			//if (j.kolisioakKonprobatu(pEtsai)) return true;
		//}
		//return false;
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
	
	public void aldatuTiroa() {}
}