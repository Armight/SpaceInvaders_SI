package modelPackage;

import java.util.*;

public class EtsaiMultipixel implements Pixel {
	private ArrayList<Pixel> etsaiKol = new ArrayList<Pixel>();
	int x, y, id, random;

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
		for (Pixel p : etsaiKol) {
			p.sortu();
		}
	}
	
	@Override
	public int getX() {
		return this.x;
	}
	
	@Override
	public int getXBerria() {
		return etsaiKol.get(0).getXBerria();
	}
	
	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public int getYBerria() {
		return etsaiKol.get(0).getYBerria();
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Pixel> getEtsaiKol(){
		return this.etsaiKol;
	}
	
	@Override
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
	
	@Override
	public HashSet<String> setRandom(int r) {
		HashSet<String> posEguneratua = new HashSet<String>();
		random = r;
		for (Pixel p : etsaiKol) {
			posEguneratua.addAll(p.setRandom(r)); 
		}
		return posEguneratua;
	}
	
	@Override
	public boolean xLimiteakKonprobatu() {
		for (Pixel p : etsaiKol) {
			if (p.xLimiteakKonprobatu()) return true;
		}
		return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu() {
		for (Pixel p : etsaiKol) {
			if (p.yLimiteakKonprobatu()) return true;
		}
		return false;
	}
		
	@Override
	public void mugituRandom() {
		ezabatu();
		if (random == 0) {
			x = x - 1;
        	mugituX(-1); // ezkerrera
        } else if (random == 1) {
        	x = x + 1;
        	mugituX(1);  // eskumara
        } else {
        	y = y + 1;
        	mugituY(1);  // behera			
        }
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.tiroKolisioak(this);
	}
	
	@Override
	public boolean kolisioakKonprobatu(int pX, int pY) {
		for (Pixel p : etsaiKol) {
			if (p.kolisioakKonprobatu(pX, pY)) return true;
		}
		return false;
	}
	
	@Override
	public void ezabatu() {
		for (Pixel p : etsaiKol) {
			p.ezabatu();
		}
	}
	
	@Override
	public void mugituX(int i) {
		for (Pixel p : etsaiKol) {
			p.mugituX(i);
		}
	}
	
	@Override
	public void mugituY(int i) {
		for (Pixel p : etsaiKol) {
			p.mugituY(i);
		}
	}
	
	@Override
	public int bizitzaKendu() {
		int hilDa = 0;
		for (Pixel p : etsaiKol) {
			hilDa = hilDa + p.bizitzaKendu();
		}
		return hilDa;
	}

	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
