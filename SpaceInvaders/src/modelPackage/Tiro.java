package modelPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tiro implements Pixel {
	
	private int x, y;
	
    protected Tiro(int pX, int pY) {
        x = pX;
        y = pY;
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
	public void setPosizio(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
		    	
	@Override
    public void mugituY(int i) {
    		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");  //Oraingo pixela kendu
    	
    		int yBerria = getY() - 1;
    	    		
    		this.setPosizio(getX(), yBerria);
    		    		
    		espazioa.getGelaxka(getX(), getY()).setEgoera("Tiro");
    		
			espazioa.etsaiKolisioakKonprobatu(this.getX(),this.getY(), this);
			
    		if (this.espaziotikKanpo(getY())) {
    			espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik"); 
    			this.ezabatu();    			
				return;
    		}
	}
    
    public boolean espaziotikKanpo(int pY) {
    		if (pY < 2) { //Bakarrik gorantz jaurtitzean jarritako muga
    			return true;
    		} else return false;
    }
    

    
    @Override
    public boolean etsaiKolisioak(Pixel pEtsai) {
    	if (pEtsai instanceof Etsai) {
			if (x == pEtsai.getX() && 
					y == pEtsai.getY()) {
				return true;
			}
		} else if (pEtsai instanceof EtsaiMultipixel) {
			EtsaiMultipixel pMulti = (EtsaiMultipixel) pEtsai;
			for (Pixel pMono : pMulti.getEtsaiKol()) {
				if (this.etsaiKolisioak(pMono)) return true;
			}
		}
		return false;
    }

	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.removeTiro(this);
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
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashSet setRandom(int r) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mugituRandom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean xLimiteakKonprobatu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean yLimiteakKonprobatu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean kolisioakKonprobatu(int pX, int pY) {
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

	@Override
	public int bizitzaKendu() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}