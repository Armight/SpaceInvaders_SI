
package modelPackage;

import java.util.ArrayList;

public class TiroMultipixel implements Pixel{
	private ArrayList<Pixel> tiroKol = new ArrayList<Pixel>();
	
	protected TiroMultipixel(int pX, int pY) {
	}
	
	protected void addTiro(Tiro t) {
		tiroKol.add(t);
	}
	
	@Override
	public void sortu() {
		for (Pixel t : tiroKol) {
			t.sortu();
		}
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) {
			return false;
		}
		
		for (Pixel t : tiroKol) {
			t.mugituY(i);
		}
		return true;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		for (Pixel t : tiroKol) {
			if (t.yLimiteakKonprobatu(i)) return true;
		}
		return false;
	}
	
	@Override
	public void ezabatu() {
		for (Pixel t : tiroKol) {
			t.ezabatu();
		}
	}
	
	@Override
	public boolean kolisioak(Pixel pEtsai) {
		for (Pixel t : tiroKol) {
			if (t.kolisioak(pEtsai)) return true;
		} return false;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		for (Pixel t : tiroKol) {
			if (t.kolisioakKonprobatu(pEtsai)) return true;
		}
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
	public boolean mugituRandom() {
		// TODO Auto-generated method stub
		return false;		
	}

	@Override
	public boolean xLimiteakKonprobatu(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean mugituX(int i) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot() {
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
		return 0;
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
	
	public void aldatuTiroa() {}
}



