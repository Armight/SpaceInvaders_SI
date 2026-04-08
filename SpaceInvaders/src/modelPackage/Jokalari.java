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
		        espazioa.getGelaxka(ps.getX(), ps.getY()).setEgoera("Jokalari_" + this.kolorea);
		    }
	}
	
	@Override
	public void mugituX(int i) {
		//i=1 denean, eskumarantz mugitu
		//i=-1 denean, ezkerrerantz mugitu
		if((getX() <= 3 && i == -1)) {
			return;
		}else if(getX() >= 116 && i==1) {
			return;
		}
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int xBerria = this.getX() + i;
		boolean ahalDa= this.mugituAhalX(i);
		if(ahalDa) {
			this.ezabatu();
			this.mugituEtaMarraztuX(i);
			this.x +=i;
		}
		
		
		
		
		//espazioa.jokalariKolisioakKonprobatu(getX(), getY());
		
		
	}
	
	
	@Override
	public void mugituY(int i) {
		//i=1 denean, gorantz mugitu
		//i=-1 denean, beherantz mugitu
		if(getY()>= 58 && i == -1 || getY() <= 2 && i == 1) { //MUGAK
			return;
		}
		boolean ahalDa= this.mugituAhalDaY(i);
		if(ahalDa) {
			this.ezabatu();
			this.mugituEtaMarraztuY(i);
		}
		this.y -=i;
	/*	
		
		
		
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

	        if (espazioa.espaziotikKanpo(xBerria, p.getY())) {ahalDa=false;break;}

	        if (espazioa.getGelaxka(xBerria, p.getY()).getEgoera().equalsIgnoreCase("Tiro")) {ahalDa=false;}
	        
	        if (espazioa.getGelaxka(xBerria, p.getY()).getEgoera().equalsIgnoreCase("Etsai")) {
	        	ahalDa=false;
	        	PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
	        
	        }
		}
		return ahalDa;
	}
	
	private boolean mugituAhalDaY(int i) {
		boolean ahalDa=true;
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		Iterator<Pixel> itr= this.getItr();
		while (itr.hasNext()&& ahalDa) {
	        PixelSimple p=(PixelSimple) itr.next();
	        
	        int yBerria = p.getY() - i;
	        
	        if (espazioa.espaziotikKanpo(p.getX(),yBerria)) {ahalDa=false;}

	        if (espazioa.getGelaxka(p.getX(), yBerria).getEgoera().equalsIgnoreCase("Tiro")) {ahalDa=false;}
	        
	        if (espazioa.getGelaxka(p.getX(), yBerria).getEgoera().equalsIgnoreCase("Etsai")) {
	        	ahalDa=false;
	        	PartidaKudeatzailea.getPartidaKudeatzailea().setJokoaAmaitu();
	        }
		}
		
		return ahalDa;
	}
	
	private void mugituEtaMarraztuX(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		for (Pixel p : pixelak) {
	        
	        p.mugituX(i);
	        espazioa.getGelaxka(p.getX(), p.getY()).setEgoera("Jokalari_" + this.kolorea);
	    }
	}
	
	private void mugituEtaMarraztuY(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		for (Pixel p : pixelak) {
	        
	        p.mugituY(i);
	        espazioa.getGelaxka(p.getX(), p.getY()).setEgoera("Jokalari_" + this.kolorea);
	    }
	}
	
	public void ezabatu() {
		
		for (Pixel p : pixelak) {
	       p.ezabatu();
	        
	    }
	}
	public void setPixelak(ArrayList<Pixel> pPixelak) {
		this.pixelak = pPixelak;
	}



}
	

