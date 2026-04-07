package modelPackage;

import java.util.ArrayList;
import java.util.List;

public class TiroTaldea implements Pixel{
	private List<Pixel> tiroKol = new ArrayList<Pixel>();
	
	@Override
	public void mugituY(int i) {
		for (Pixel tiro : tiroKol) {
			tiro.mugituY(0);
		}
		
	}
	
	@Override
	public void mugituX(int i) {
		for (Pixel tiro : tiroKol) {
			tiro.mugituX(0);
		}
	}
	
	@Override
	public void sortu() {
		for (Pixel tiro : tiroKol) {
			tiro.sortu();
		}
	}
	
	@Override
	public void ezabatu() {
		for (Pixel tiro : tiroKol) {
			tiro.ezabatu();
		}
	}
	
	@Override
	public boolean bizitzaKendu() {
		return false;
	}
	
	@Override
    public int getX() {
        return 0;
    }
 
    @Override
    public int getY() {
        return 0;
    }
 
    @Override
    public int getBizitza() { 
    	return 0; 
    }
    
    @Override
    public void setPosizio(int pX, int pY) {	
    
    }
    
    @Override
    public boolean kolisioakKonprobatu(int pX, int pY) {
        for (Pixel tiro : tiroKol) {
            if (tiro.kolisioakKonprobatu(pX, pY)) {
                return true;
            }
        }
        return false;
    }
	
	public void addTiro(Pixel pTiro) {
		tiroKol.add(pTiro);
	}
	
	public void removeTiro(Pixel pTiro) {
		tiroKol.remove(pTiro);
	}
	
	
}
