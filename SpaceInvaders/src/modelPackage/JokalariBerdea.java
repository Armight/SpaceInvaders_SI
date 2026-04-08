package modelPackage;

import java.util.ArrayList;

public class JokalariBerdea extends Jokalari{
	private ArrayList<Pixel> pixelak;
	public JokalariBerdea(int pX, int pY) {
		super(pX, pY);
		this.kolorea = "GREEN";
		this.tiroPortaera = new TiroBakarraPortaera();
		this.pixelak= new ArrayList<Pixel>();
		pixelak.add(new PixelSimple(pX, pY));	 		//Pixel zentrala		
		pixelak.add(new PixelSimple(pX, pY + 1));		//Beheko Pixela		
		pixelak.add(new PixelSimple(pX - 1, pY));		//Erdiko ezkerreko Pixela	
		pixelak.add(new PixelSimple(pX + 1, pY));		//Erdiko eskuineko Pixela
		pixelak.add(new PixelSimple(pX - 1, pY - 1));	//Goihiko ezkerreko Pixela
		pixelak.add(new PixelSimple(pX + 1, pY - 1));	//Goihiko eskuineko Pixela
		pixelak.add(new PixelSimple(pX -1, pY + 1));
		pixelak.add(new PixelSimple(pX + 1, pY + 1));
		super.setPixelak(pixelak);
	}
	
	public void aldatuTiroa() {
		if (tiroPortaera instanceof TiroBakarraPortaera) {
			tiroPortaera = new TiroGeziaPortaera();
		}
		else {
			tiroPortaera = new TiroBakarraPortaera();
		}
	}
	
}
