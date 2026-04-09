package modelPackage;

import java.util.ArrayList;

public class Tiro  implements Pixel{
	private int x,y;
	private ArrayList<Pixel> tiroPixelak;
    protected Tiro(int pX, int pY) {
    		this.tiroPixelak= new ArrayList<Pixel>();
    		tiroPixelak.add(new PixelSimple(pX, pY));
    }
    
	@Override
	public void sortu() {
		// TODO Auto-generated method stub
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
    		    		
    		espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Tiro"); 
    		
			espazioa.etsaiKolisioakKonprobatu(ps.getX(),ps.getY(), this);
			
    		if (this.espaziotikKanpo(ps.getY())) {
    			espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik"); 
    			espazioa.removeTiro(this);
    			return;
    		}
		}
	}
    

	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
	}

    public boolean espaziotikKanpo(int pY) {
    		if (pY < 2) { //Bakarrik gorantz jaurtitzean jarritako muga
    			return true;
    		} else return false;
    }
    
    public boolean kolisioakKonprobatu(int pX, int pY) {
    	if (getX() == pX && getY() == pY) {
			return true;
		} else return false;
    }

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public int getBizitza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosizio(int pX, int pY) {
		this.x = pX;
	    this.y = pY;
	}

	@Override
	public void ezabatu() {
		// TODO Auto-generated method stub
		
	}

	
}