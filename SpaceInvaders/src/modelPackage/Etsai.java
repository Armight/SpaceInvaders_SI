package modelPackage;

import java.util.*;

public class Etsai implements Pixel {
	
	private int x, y, bizitza, id;
	private int xBerria, yBerria, random;
	
    public Etsai(int pX, int pY, int pId) {
        x = pX;
        y = pY;
        xBerria = pX;
        yBerria = pY;
        id = pId;
        bizitza = 1;
    }
    
    //ETSAI METODO OROKORRAK:
	public void sortu() {
		EspazioModel.getGelaxkaMatrizea().getGelaxka(x, y).setEgoera("Etsaia");
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
	public HashSet<String> setRandom(int r) {
		HashSet<String> posEguneratua = new HashSet<String>();
		random = r;
		xBerria = x;
		yBerria = y;
		if (r == 0) {
        	xBerria = x -1; // ezkerrera
        } else if (r == 1) {
        	xBerria = x +1;  // eskumara
        } else {
        	yBerria = y +1;  // behera			
        }
		String posBerria = xBerria + "," + yBerria;
		posEguneratua.add(posBerria);
		return posEguneratua;
	}
	
	@Override
	public boolean xLimiteakKonprobatu(int i) {
		if (xBerria < 0 || xBerria >= 100) return true;
		return false;
	}
	
	@Override
	public boolean yLimiteakKonprobatu(int i) {
		if (yBerria >= 59) return true;
		return false;
	}
	
	@Override
	public boolean kolisioakKonprobatu(int pX, int pY) {
		if (x == pX && y == pY) return true;
		return false;
	}
	
	@Override
	public void mugituRandom() {
		ezabatu();
		if (random == 0) {
        	mugituX(-1); // ezkerrera
        } else if (random == 1) {
        	mugituX(1);  // eskumara
        } else {
        	mugituY(1);  // behera			
        }
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.tiroKolisioak(this);
	}
	
	@Override
	public void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(this.x, this.y).setEgoera("Hutsik");
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
        x = xBerria;
             
		espazioa.getGelaxka(x, y).setEgoera("Etsaia");
	}
	
	@Override
	public void mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
				
		y = yBerria;

    	espazioa.getGelaxka(x, y).setEgoera("Etsaia");
   	}
	
	@Override
	public int bizitzaKendu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		bizitza = bizitza - 1;
		if (bizitza <= 0) {
	    	espazioa.getGelaxka(x, y).setEgoera("Hutsik");
			return -1;
		} else return 0;
	}

	@Override
	public boolean etsaiKolisioak(Pixel pEtsai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}


}

