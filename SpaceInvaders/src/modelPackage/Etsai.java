package modelPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class Etsai implements Pixel {
	private ArrayList<Pixel> pixelak;
	
	private int x,y;
	private int id;
	
	
    public Etsai(int pX, int pY, int pId) {
        
    	id = pId;
        pixelak = new ArrayList<>();

        pixelak.add(new PixelSimple(pX, pY));
        pixelak.add(new PixelSimple(pX + 1, pY));
        pixelak.add(new PixelSimple(pX - 1, pY));
        pixelak.add(new PixelSimple(pX, pY + 1));
        
        this.x=pX;
        this.y=pY;

        

    }
    private Iterator<Pixel> getItr(){
    	return this.pixelak.iterator();
    }
    
    //ETSAI METODO OROKORRAK:
	@Override
	public void sortu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();

	    for (Pixel p : pixelak) {
	        espazioa.getGelaxka(p.getX(), p.getY()).setEgoera("Etsaia");
	    }
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		
		/*
		
		espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);*/
	}
	
	@Override
	public void mugituY(int i) {
		/*EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();

    	if (espazioa.espaziotikKanpo(getX(), yBerria)) {
    		PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
    		return;
    	}

    	espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		
		this.setPosizio(getX(), yBerria);

    	espazioa.getGelaxka(getX(), getY()).setEgoera("Etsaia");
    	
    	espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);*/
	}
	//boolean kolisionatu = espazioa.etsaiEtsaiKolisioak(xBerria, yBerria, id);
	//if (kolisionatu) return;
    public void mugituRandom() {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	double random=(int) this.getRandom();
    	
        if (random == 0) {// ezkerrera

        	boolean ahalDa=this.mugituAhalDaX(-1);
        	mugituX(-1); 
        } else if (random == 1) {
        		mugituX(1);  // eskumara
        } else {
        		mugituY(0);  // behera			
        }
    }
    
    private boolean mugituAhalDaX(int i) {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	boolean ahalDa=true;

        for (Pixel p : pixelak) {
            PixelSimple ps = (PixelSimple) p;
            int xBerria = ps.getX() + i;

            if (espazioa.espaziotikKanpo(xBerria, ps.getY())) ahalDa=false;

            String egoera = espazioa.getGelaxka(xBerria, ps.getY()).getEgoera();
            
            if (egoera.equalsIgnoreCase("Tiro")) {
            	ahalDa=false;
            	//mugitu (pantailan ikusteko hil dela)?
            	this.ezabatu();
            }
            if (egoera.equalsIgnoreCase("Etsai")) {
            	boolean kolisionatu = espazioa.etsaiEtsaiKolisioak(xBerria, this.y, this.id); 
            	if (kolisionatu) {ahalDa=false;}
            	
            }
            if (egoera.contains("Jokalari")) {
            	ahalDa=false;
            	PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
            }
        }

        return ahalDa;
    }
    
    public void ezabatu() {
    	for (Pixel p: pixelak) {
    		p.ezabatu();
    	}
    	
    }
	
	public void posizioRandom() {/*
		random = (int)(Math.random() * 3); //0, 1 edo 2
		if (random == 0) {
			xBerria = xBerria - 1;
		} else if (random == 1) {
			xBerria = xBerria + 1;
		} else {
			yBerria = yBerria + 1;}
		*/
	}
	
	private double getRandom() {
		return Math.random()*3;
	}
	
	public boolean etsaiKolisioak(int pX, int pY, int pId) {
		boolean kolisionatu = false;
		if (this.x == pX && this.y == pY && id != pId) {
			kolisionatu = true;
		}
		return kolisionatu;
	
	}
	
	public int getId() {
		return this.id;
	}
    
    public boolean kolisioakKonprobatu(int pX, int pY) {
    	boolean kolisionatu = false;
    	if (getX() == pX && getY() == pY) {
    		kolisionatu = true;
    	}
    	return kolisionatu;
	}

	@Override
	public boolean bizitzaKendu() {
		int bizitza = getBizitza();
		bizitza = bizitza - 1;
		if (bizitza <=0) {
			EspazioModel.getGelaxkaMatrizea().getGelaxka(getX(), getY()).setEgoera("Hutsik");
			//EspazioModel.getGelaxkaMatrizea().removeEtsai(this);
			return true;
		} else return false;
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

}

