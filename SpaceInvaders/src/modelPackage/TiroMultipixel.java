
package modelPackage;

import java.util.ArrayList;

public class TiroMultipixel implements Pixel{
	private int x, y;
	private ArrayList<Pixel> tiroKol = new ArrayList<Pixel>();
	
	protected TiroMultipixel(int pX, int pY) {
		x = pX;
		y = pY;
	}
	
	protected void addTiro(Tiro t) {
		tiroKol.add(t);
	}
	
	@Override
	public void sortu() {
		if(!this.konprobatu()) {
			tiroKol.stream().forEach(t -> t.sortu());
		}
		
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) {
			return false;
		}
		
		if(this.konprobatu()) return false;
		tiroKol.stream().forEach(p -> p.mugituY(i));
		return true;
	}
	
	private boolean konprobatuTiroaBadago(Pixel p) {
		if (EspazioModel.getGelaxkaMatrizea().tiroaDago(p.getX(), p.getY()-1)) {return true;}
		return false;
	}
	
	private boolean konprobatu() {
		return tiroKol.stream().allMatch(p -> this.konprobatuTiroaBadago(p));
	}
	

	@Override
	public boolean yLimiteakKonprobatu(int i) { //anymatch
		boolean konprobatu;
		konprobatu = tiroKol.stream().anyMatch(t -> t.yLimiteakKonprobatu(i));
		return konprobatu;
	}
	
	@Override
	public void ezabatu() {
		tiroKol.stream().forEach(t -> t.ezabatu());
	}
	
	@Override
	public boolean kolisioak(Pixel pEtsai) { //anymatch
		boolean konprobatu;
		konprobatu = tiroKol.stream().anyMatch(t -> t.kolisioak(pEtsai));
		return konprobatu;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = tiroKol.stream().anyMatch(t -> t.kolisioak(pEtsai));
		return konprobatu;
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
	public boolean mugitu() {
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



