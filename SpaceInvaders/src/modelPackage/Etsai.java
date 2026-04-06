package modelPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class Etsai implements Pixel {
	private ArrayList<Pixel> pixelak;
	
	private int x,y;
	private int id;
	
	
    public Etsai(int pX, int pY, int pId) {
        
    	id = pId;
    	this.x=pX;
        this.y=pY;
        pixelak = new ArrayList<>();

        pixelak.add(new PixelSimple(pX, pY));
        pixelak.add(new PixelSimple(pX + 1, pY));
        pixelak.add(new PixelSimple(pX - 1, pY));
        pixelak.add(new PixelSimple(pX, pY + 1));
        
        

        

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
	public void mugituX(int i) { // FOR DESBERDINETAN IPINI ERDIKO PIXELA EGUNERATZEAN BERRIRO IKUS AHAL IZATEKO
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		
		espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
		
		
		//ETSAIAK MUGITZEA
		
		if (!mugituAhalDaX(i)) { return;} // Ezin bada mugitu ez egin ezer ez.
		for (Pixel p: pixelak) {
			PixelSimple ps = (PixelSimple) p;
			espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik");
			ps.mugituX(i); // i-ren balioaren arabera mugituko da eta baloreak aldatuko ditu
				
		}
		this.x += i;
		for (Pixel p: pixelak) {
			PixelSimple ps = (PixelSimple) p;
			espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik");
			espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Etsaia");
		}
		
		 
	}
	
	@Override
	public void mugituY(int i) { // FOR DESBERDINETAN IPINI ERDIKO PIXELA EGUNERATZEAN BERRIRO IKUS AHAL IZATEKO
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		for (Pixel p: pixelak) { 
			PixelSimple ps = (PixelSimple) p;
			if (espazioa.espaziotikKanpo(ps.getX(), ps.getY()+1)) {
				PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
				return;
			}else {
				espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik");
				ps.mugituY(-1);
				
			}
		}
		this.y += -1;
		for (Pixel p: pixelak) {
			PixelSimple ps = (PixelSimple) p;
			espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Etsaia");
		}
    	espazioa.tiroKolisioakKonprobatu(getX(), getY(), this);
		return;
	}
	//boolean kolisionatu = espazioa.etsaiEtsaiKolisioak(xBerria, yBerria, id);
	//if (kolisionatu) return;
    public void mugituRandom() {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	double random=(int) this.getRandom();
    	
        if (random == 0) {// ezkerrera

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
		// TODO Auto-generated method stub
		
	}

}

