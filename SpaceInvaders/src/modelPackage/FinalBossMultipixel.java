package modelPackage;

import java.util.*;

public class FinalBossMultipixel implements Pixel {
	private ArrayList<Pixel> finalBossKol = new ArrayList<Pixel>();
	private int x, y;
	private Pixel ezkerP, eskuinP, beheP, goiP;
	private TiroPortaera tiroPortaera = new TiroBakarraPortaera();
	
	public FinalBossMultipixel(int pX, int pY) {
		x = pX;
		y = pY;
		
		int posizioak [][] = new int [][] {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, 
			{-1, 0}, {-2, 0}, {-3, 0}, {-4, 0}, {-5, 0}, {0, 1}, {1, 1}, {2, 1}, {3, 1}, {5, 1},
			{-1, 1}, {-2, 1}, {-3, 1}, {-5, 1}, {3, 2}, {5, 2}, {-3, 2}, {-5, 2}, {1, 3}, {2, 3}, 
			{-1, 3}, {-2, 3}, {0, -1}, {1, -1}, {3, -1}, {4, -1}, {-1, -1}, {-3, -1}, {-4, -1},
			{0, -2}, {1, -2}, {2, -2}, {3, -2}, {-1, -2}, {-2, -2}, {-3, -2}, {2, -3}, {-2, -3},
			{3, -4}, {-3, -4},};
		for (int[] pos : posizioak) {
			FinalBoss fb = new FinalBoss(x + pos[0], y + pos[1]);
			finalBossKol.add(fb);
		}
		
		for (Pixel fb : finalBossKol) {
			if (fb.getX() == x + 5 && fb.getY() == y) {
				eskuinP = fb;
			} else if (fb.getX() == x - 5 && fb.getY() == y) {
				ezkerP = fb;
			} else if (fb.getX() == x + 1 && fb.getY() == y + 3) {
				beheP = fb;
			} else if (fb.getX() == x + 3 && fb.getY() == y - 4) {
				goiP = fb;
			}
		}
	}
	
	@Override
	public void sortu() {
		finalBossKol.stream().forEach(fb -> fb.sortu());
		
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
	public boolean mugitu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int koordenatuak [][] = espazioa.getJokalariarenKoordenatuak();
		
		int dx = koordenatuak[0][0] - this.x;
		int i1 = 0;
		if (dx > 0) {
			i1 = 1;
		} else if (dx < 0) {
			i1 = -1;		
		}
		
		if (xLimiteakKonprobatu(i1)) { } 
		else this.mugituX(i1);
		
		int dy = koordenatuak[0][1] - this.y;
		int i2 = 0;
		if (dy > 0) {
			i2 = 1;
		} else if (dy < 0) {
			i2 = -1;
		}
		
		if (yLimiteakKonprobatu(i2)) { }
		else this.mugituY(i2);
				
		return false;
	}

	@Override
	public boolean mugituX(int i) {
		x = x + i;
		ezabatu();
		finalBossKol.stream().forEach(fb -> fb.mugituX(i));
		
		return false;
	}
	
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		if (ezkerP.xLimiteakKonprobatu(i)|| eskuinP.xLimiteakKonprobatu(i)) return true;
		return false;
	}

	@Override
	public boolean mugituY(int i) {
		y = y + i;
		ezabatu();
		finalBossKol.stream().forEach(fb -> fb.mugituY(i));
		
		return false;
	}

	@Override
	public boolean yLimiteakKonprobatu(int i) {
		if (goiP.yLimiteakKonprobatu(i)|| beheP.yLimiteakKonprobatu(i)) return true;
		return false;
	}
	
	@Override
	public void ezabatu() {
		finalBossKol.stream().forEach(fb -> fb.ezabatu());
	}
	
	@Override
	public boolean kolisioak(Pixel pPixel) {
		boolean konprobatu;
		konprobatu = finalBossKol.stream().anyMatch(fb -> fb.kolisioak(pPixel));
		return konprobatu;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pPixel) {
		boolean konprobatu;
		konprobatu = finalBossKol.stream().anyMatch(fb -> fb.kolisioakKonprobatu(pPixel));
		return konprobatu;
	}
	
	@Override
	public int bizitzaKendu() {
		int hilDa;
		hilDa = finalBossKol.stream().mapToInt(fb -> fb.bizitzaKendu()).sum();
		return hilDa;
	}
	
	@Override
	public void shoot() {
		// TODO Auto-generated method stub
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
	public void aldatuTiroa() {
		// TODO Auto-generated method stub
		
	}
	
}
