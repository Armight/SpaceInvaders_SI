package modelPackage;

import java.util.*;

public class EtsaiMultipixel implements Pixel {
	private ArrayList<Pixel> etsaiKol = new ArrayList<Pixel>();
	Set<String> posBerriak = new HashSet<>();
	private int x, y, xBerria, yBerria, id, random;
	int posizioak[][];

	public EtsaiMultipixel(int pX, int pY, int pId) {
		x = pX;
		y = pY;
		xBerria = pX;
		yBerria = pY;
		id = pId;
		
		posizioak = new int [][] {{1, 0}, {2, 0}, {-1, 0}, {-2, 0}, {0, 1}, {1, 1}, {-1, 1}, {0, 2}};
	}
	
	@Override
	public void sortu() {
		for (int[] pos : posizioak) {
			Etsai e = new Etsai(x + pos[0], y + pos[1], id);
			e.sortu();
			etsaiKol.add(e);
		}
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
	public void setPosizio(int pX, int pY) {
		posBerriak.clear();
		for (int[] pos : posizioak) {
			String key = (pX + pos[0]) + "," + (pY + pos[1]);
			posBerriak.add(key);
		}	
	}
	
	public void posizioRandom() {
		random = (int)(Math.random() * 3); //0, 1 edo 2
		xBerria = x;
		yBerria = y;
		if (random == 0) {
			xBerria = xBerria - 1;
		} else if (random == 1) {
			xBerria = xBerria + 1;
		} else {
			yBerria = yBerria + 1;
		}
	}
	
	@Override
	public void mugituRandom() {
		this.posizioRandom();
		
		this.setPosizio(xBerria, yBerria);
		
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	boolean kolisionatu = espazioa.etsaiEtsaiKolisioak(this.posBerriak, this.id);
    	if (kolisionatu) return;
    	
    	this.xLimiteakKonprobatu();
    	   	
    	this.x = xBerria;
    	this.y = yBerria;
    	
    	this.ezabatu();
    	        
        if (random == 0) {
        	mugituX(-1); // ezkerrera
        } else if (random == 1) {
        	mugituX(1);  // eskumara
        } else {
            mugituY(1);  // behera			
        }
	}
	
	private void xLimiteakKonprobatu() {
		
	}

	@Override
	public void mugituX(int i) {
		for (Pixel e : etsaiKol) {
			e.mugituX(i);
		}
	}

	@Override
	public void mugituY(int i) {
		for (Pixel e : etsaiKol) {
			e.mugituY(i);
		}
	}
	
	@Override
	public void ezabatu() {
		for (Pixel e : etsaiKol) {
			e.ezabatu();
		}
		
	}

	@Override
	public boolean kolisioakKonprobatu(int pX, int pY) {
		for (Pixel e : etsaiKol) {
			if(e.kolisioakKonprobatu(pX, pY)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean etsaiKolisioak(Set<String> etsaiPosizioak, int pId) {
		if (id == pId) return false;
		for (String pos : posBerriak) {
			if (etsaiPosizioak.contains(pos)) {
				return true;
			}
		}
		return false;
	}
}
