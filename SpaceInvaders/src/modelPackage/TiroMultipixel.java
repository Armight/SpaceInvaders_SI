
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
		if(!this.konprobatu()) {
			//for (Pixel t : tiroKol) {
				//t.sortu();
			
		
			//}
			tiroKol.stream().forEach(t -> t.sortu());
		}
		
	}
	
	@Override
	public boolean mugituY(int i) {
		if (yLimiteakKonprobatu(i)) {
			return false;
		}
		
		if(this.konprobatu()) return false;
		//for (Pixel p : tiroKol) {
			
			//p.mugituY(i);
			
		//}
		tiroKol.stream().forEach(p -> p.mugituY(i));
		return true;
	}
	
	private boolean konprobatuTiroaBadago(Pixel p) {
		if (EspazioModel.getGelaxkaMatrizea().tiroaDago(p.getX(), p.getY()-1)) {return true;}
		return false;
	}
	
	private boolean konprobatu() {
		boolean tiroaDago=true;
		for (Pixel p : tiroKol) {
			tiroaDago=this.konprobatuTiroaBadago(p);
		}
		return tiroaDago;
				
	}
	

	@Override
	public boolean yLimiteakKonprobatu(int i) { //anymatch
		boolean konprobatu;
		konprobatu = tiroKol.stream().anyMatch(t -> t.yLimiteakKonprobatu(i));
		return konprobatu;
		//for (Pixel t : tiroKol) {
			//if (t.yLimiteakKonprobatu(i)) return true;
			
		//}
	}
	
	@Override
	public void ezabatu() {
		//for (Pixel t : tiroKol) {
			//t.ezabatu();
		//}
		tiroKol.stream().forEach(t -> t.ezabatu());
	}
	
	@Override
	public boolean kolisioak(Pixel pEtsai) { //anymatch
		boolean konprobatu;
		konprobatu = tiroKol.stream().anyMatch(t -> t.kolisioak(pEtsai));
		return konprobatu;
		//for (Pixel t : tiroKol) {
			//if (t.kolisioak(pEtsai)) return true;
		//} return false;
	}
	
	@Override
	public boolean kolisioakKonprobatu(Pixel pEtsai) {
		boolean konprobatu;
		konprobatu = tiroKol.stream().anyMatch(t -> t.kolisioak(pEtsai));
		return konprobatu;
		//for (Pixel t : tiroKol) {
			//if (t.kolisioakKonprobatu(pEtsai)) return true;
		//}
		//return false;
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



