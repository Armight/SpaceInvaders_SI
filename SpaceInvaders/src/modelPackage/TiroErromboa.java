package modelPackage;

import java.util.ArrayList;

public class TiroErromboa implements Pixel {
	private ArrayList<Pixel> tiroPixelak;
    public TiroErromboa(int pX, int pY) {
        
    	this.tiroPixelak= new ArrayList<Pixel>();
		tiroPixelak.add(new PixelSimple(pX, pY));
		
		tiroPixelak.add(new PixelSimple(pX, pY-1));
		tiroPixelak.add(new PixelSimple(pX+1, pY-1));
		tiroPixelak.add(new PixelSimple(pX-1, pY-1));
		
		tiroPixelak.add(new PixelSimple(pX, pY-2));
		tiroPixelak.add(new PixelSimple(pX+1, pY-2));
		tiroPixelak.add(new PixelSimple(pX-1, pY-2));
		tiroPixelak.add(new PixelSimple(pX-2, pY-2));
		tiroPixelak.add(new PixelSimple(pX+2, pY-2));
		
		tiroPixelak.add(new PixelSimple(pX, pY-3));
		tiroPixelak.add(new PixelSimple(pX+1, pY-3));
		tiroPixelak.add(new PixelSimple(pX-1, pY-3));
		
		tiroPixelak.add(new PixelSimple(pX, pY-4));
		
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
	public int getBizitza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosizio(int pX, int pY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mugituX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mugituY(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
		for (Pixel p: tiroPixelak) {
			PixelSimple ps = (PixelSimple) p;
    		
    		espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik");  //Oraingo pixela kendu
    	
    		int yBerria = ps.getY() - 1;
    		ps.setPosizio(ps.getX(), yBerria);
		}
		for (Pixel p: tiroPixelak) {
			PixelSimple ps = (PixelSimple) p;
			
    		espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Tiro"); 
    		
			espazioa.etsaiKolisioakKonprobatu(ps.getX(),ps.getY(), ps);
			
    		if (this.espaziotikKanpo(ps.getY()-4)) {
    			espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik"); 
    			espazioa.removeTiro(ps);
    			return;
    		}
		}
	}
		
	
	public boolean espaziotikKanpo(int pY) {
		if (pY < 2) { //Bakarrik gorantz jaurtitzean jarritako muga
			return true;
		} else return false;
}

	@Override
	public void sortu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ezabatu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean kolisioakKonprobatu(int pX, int pY) {
		// TODO Auto-generated method stub
		return false;
	}
}