package modelPackage;

import java.util.*;

public class JokalariMultipixel implements Pixel{
	
	private ArrayList<Pixel> jokalariKol = new ArrayList<Pixel>();
	private int x, y;
	private String kolorea;
	protected TiroPortaera tiroPortaera;
	
	protected JokalariMultipixel(int pX, int pY, String pKolorea) {
		x = pX;
		y = pY;
		kolorea = pKolorea;
	}
		
	protected void addJokalari(Jokalari pJokalari) {
		jokalariKol.add(pJokalari);
	}
	
	@Override
	public void sortu() {
		jokalariKol.stream().forEach(j -> j.sortu());
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
		return true;
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) return false;

		this.ezabatu();
		y = y - i;
		jokalariKol.stream().forEach(j -> j.mugituY(i));
		return true;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(t -> t.xLimiteakKonprobatu(i));
		return konprobatu;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(j -> j.yLimiteakKonprobatu(i));
		return konprobatu;
	}
	
	@Override
	public void ezabatu() {
		jokalariKol.stream().forEach(j -> j.ezabatu());
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
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = jokalariKol.stream().anyMatch(j -> j.kolisioakKonprobatu(pEtsai));
		return konprobatu;
	}

	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean mugitu() {
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