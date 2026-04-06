package modelPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class Jokalari implements Pixel {
	private ArrayList<Pixel> pixelak;
	private int x,y;//pixel zentrala

	protected String kolorea;
	
	protected Jokalari(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		this.pixelak= new ArrayList<Pixel>();
		pixelak.add(new PixelSimple(x, y));			//erdiko pixel
		pixelak.add(new PixelSimple(x + 1, y));		//eskumako pixel
		pixelak.add(new PixelSimple(x - 1, y));		//ezkerreko pixel
		pixelak.add(new PixelSimple(x, y - 1));		//goiko pixel
		
		
	
	}
	private Iterator<Pixel> getItr(){
		return this.pixelak.iterator();
	}
	
	//JOKALARI METODO OROKORRAK:		
	@Override
	public void sortu() {
		 EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();

		    for (Pixel p : pixelak) {
		        PixelSimple ps = (PixelSimple) p;
		        espazioa.getGelaxka(ps.getX(), ps.getY())
		            .setEgoera("Jokalari_" + this.kolorea);
		    }
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int xBerria = this.getX() + i;
		boolean ahalDa= this.mugituAhalX(i);
		if(ahalDa) {
			this.ezabatu();
			this.mugituEtaMarraztuX(i);
		}
		
		
		
		//espazioa.jokalariKolisioakKonprobatu(getX(), getY());
		
		
	}
	
	
	@Override
	public void mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
	/*	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int yBerria = this.getY() - i;
		if (espazioa.espaziotikKanpo(getX(), yBerria)) return;

		if (espazioa.getGelaxka(getX(), yBerria).getEgoera().equalsIgnoreCase("Tiro")) return;
		
		//posizio zaharra matrizetik kendu
		espazioa.getGelaxka(getX(), getY()).setEgoera("Hutsik");
		
		//posizio berria atzitu
		this.setPosizio(getX(), getY()-i);
		
		espazioa.jokalariKolisioakKonprobatu(getX(), getY());
		
		espazioa.getGelaxka(getX(), getY()).setEgoera("Jokalari_" + this.kolorea);	*/
	}
	
	public String getKolorea() {return this.kolorea;}
	
	public void shoot() {
		if (this.getY() <= 2) {
			return;
		}else {
			Tiro tiro = new Tiro(getX(), getY() -2);
			EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
		}
	}

	@Override
	public boolean bizitzaKendu() {
		// TODO Auto-generated method stub
		return false;
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
	public int getBizitza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPosizio(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		
	}
	
	private boolean mugituAhalX(int i) {
		boolean ahalDa=true;
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		Iterator<Pixel> itr= this.getItr();
		while (itr.hasNext()&& ahalDa) {
	        PixelSimple p=(PixelSimple) itr.next();
	        
	        int xBerria = p.getX() + i;

	        if (espazioa.espaziotikKanpo(xBerria, p.getY())) {ahalDa=false;}

	        if (espazioa.getGelaxka(xBerria, p.getY()).getEgoera().equalsIgnoreCase("Tiro")) {ahalDa=false;}
	        
	        if (espazioa.getGelaxka(xBerria, p.getY()).getEgoera().equalsIgnoreCase("Etsai")) {
	        	ahalDa=false;
	        	PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
	        
	        }
		}
		return ahalDa;
	}
	
	private void ezabatu() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		for (Pixel p : pixelak) {
	        PixelSimple ps = (PixelSimple) p;
	        espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Hutsik");
	    }
	}
	
	private void mugituEtaMarraztuX(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		for (Pixel p : pixelak) {
	        
	        p.mugituX(i);
	        espazioa.getGelaxka(p.getX(), p.getY()).setEgoera("Jokalari_" + this.kolorea);
	    }
	}



}
	

