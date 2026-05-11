package modelPackage;

import java.util.*;

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
		etsaiKol.stream().forEach(e -> e.sortu());
		
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
		etsaiKol.stream().forEach(e -> e.setRandom(random));
		
	}
	
	@Override
	public boolean mugitu() {
		     
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
		if (xLimiteakKonprobatu(i)) {
	        return true;
	    } else {
	    	ezabatu();
	    	etsaiKol.stream().forEach(e -> e.mugituX(i));
		    
		    return true;
	    }
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) {
			return false;
		}
		
		ezabatu();
		etsaiKol.stream().forEach(e -> e.mugituY(i));
		
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		boolean konprobatu;
		konprobatu = etsaiKol.stream().anyMatch(e-> e.xLimiteakKonprobatu(i));
		return konprobatu;
		
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		boolean konprobatu;
		konprobatu = etsaiKol.stream().anyMatch(j -> j.yLimiteakKonprobatu(i));
		return konprobatu;
		
	}
		
	@Override
	public void ezabatu() {
		etsaiKol.stream().forEach(e -> e.ezabatu());
	
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
		boolean konprobatu;
		konprobatu = etsaiKol.stream().anyMatch(e -> e.kolisioak(pPixel));
		return konprobatu;
		
	}
	
	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = etsaiKol.stream().anyMatch(e -> e.etsaiKolisioak(pEtsai));
		return konprobatu;
		
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pPixel) {
		//pPixel Jokalari zein Tiro monopixel izan daiteke
		boolean konprobatu;
		konprobatu = etsaiKol.stream().anyMatch(e -> e.kolisioakKonprobatu(pPixel));
		return konprobatu;
		
	}
	
	@Override
	public boolean etsaiEtsaiKonprobatu(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = etsaiKol.stream().anyMatch(e -> e.etsaiEtsaiKonprobatu(pEtsai));
		return konprobatu;
		
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
	
}
