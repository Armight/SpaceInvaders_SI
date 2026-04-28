package modelPackage;

import java.util.*;
import java.util.function.Consumer;

public class EtsaiMultipixel implements Pixel {
	private ArrayList<Pixel> etsaiKol = new ArrayList<Pixel>();
	private int x, y, id, random;

	public EtsaiMultipixel(int pX, int pY, int pId) {
		x = pX;
		y = pY;
		id = pId;
		
		int posizioak [][] = new int [][] {{1, 0}, {2, 0}, {-1, 0}, {-2, 0}, {0, 1}, {1, 1}, {-1, 1}, {0, 2}};
		for (int[] pos : posizioak) {
			Etsai e = new Etsai(x + pos[0], y + pos[1], id);
			etsaiKol.add(e);
		}
	}
	
	//Metodo orokorrak
	@Override
	public void sortu() {
		forEachPixel(Pixel::sortu);
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
	public int getId() {
		return this.id;
	}
		
	@Override
	public void setRandom(int r) {
		random = r;
		for (Pixel e : etsaiKol) {
			//random zenbaki berbera bidali monopixel bakoitzari
			e.setRandom(random); 
		}
	}
	
	@Override
	public boolean mugituRandom() {
		     
		if (random == 0) {
			x = x - 1;
        	return mugituX(-1); // ezkerrera
        } else if (random == 1) {
        	x = x + 1;
        	return mugituX(1);  // eskumara
        } else {
        	y = y + 1;
        	return mugituY(1);  // behera			
        }
	}
	
	@Override
	public boolean mugituX(int i) {
	    if (xLimiteakKonprobatu(i)) return true;
	    ezabatu();
	    forEachPixel(p -> p.mugituX(i));
	    return true;
	}
    
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) {
			return false;
		}
		
		ezabatu();
		for (Pixel e : etsaiKol) {
			e.mugituY(i);
		}
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		for (Pixel e : etsaiKol) {
			if (e.xLimiteakKonprobatu(i)) return true;
		}
		return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		for (Pixel e : etsaiKol) {
			if (e.yLimiteakKonprobatu(i)) return true;
		}
		return false;
	}
		
	@Override
	public void ezabatu() {
		for (Pixel e : etsaiKol) {
			e.ezabatu();
		}
	}
	
	@Override
	public int bizitzaKendu() {
		int hilDa = 0;
		for (Pixel e : etsaiKol) {
			hilDa = hilDa + e.bizitzaKendu();
		}
		return hilDa;
	}
	
	@Override
	public boolean kolisioak(Pixel pPixel) {
		for (Pixel e : etsaiKol) {
			if (e.kolisioak(pPixel)) return true;
		} return false;
	}
	
	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		for (Pixel e : etsaiKol) {
			if (e.etsaiKolisioak(pEtsai)) return true;
		} return false;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pPixel) {
		//pPixel Jokalari zein Tiro monopixel izan daiteke
		for (Pixel e : etsaiKol) {
			if (e.kolisioakKonprobatu(pPixel)) return true;
		}
		return false;
	}
	
	@Override
	public boolean etsaiEtsaiKonprobatu(Pixel pEtsai) {
		for (Pixel e : etsaiKol) {
			if (e.etsaiEtsaiKonprobatu(pEtsai)) return true;
		} return false;
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
	public void aldatuTiroa() {
		// TODO Auto-generated method stub
		
	}
	
//////////////////////////////////JAVA8////////////////////////////////////////////////
	
	
	//Behaviour parametrization:
	private void forEachPixel(Consumer<Pixel> action) {
		etsaiKol.forEach(action);
	}
	
}
