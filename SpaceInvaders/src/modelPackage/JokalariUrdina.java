package modelPackage;

import java.util.ArrayList;

public class JokalariUrdina extends Jokalari{
	private ArrayList<Pixel> pixelak;
	public JokalariUrdina(int pX, int pY) {
		super(pX, pY);
		this.kolorea = "BLUE";
		this.pixelak= new ArrayList<Pixel>();
		pixelak.add(new PixelSimple(pX, pY));	 		//Pixel zentrala		
		pixelak.add(new PixelSimple(pX, pY + 1));		//Beheko Pixela		
		pixelak.add(new PixelSimple(pX - 1, pY));		//Erdiko ezkerreko Pixela	
		pixelak.add(new PixelSimple(pX + 1, pY));		//Erdiko eskuineko Pixela
		pixelak.add(new PixelSimple(pX - 1, pY - 1));	//Goihiko ezkerreko Pixela
		pixelak.add(new PixelSimple(pX + 1, pY - 1));	//Goihiko eskuineko Pixela
		pixelak.add(new PixelSimple(pX -1, pY + 1));
		pixelak.add(new PixelSimple(pX + 1, pY + 1));
		pixelak.add(new PixelSimple(pX -2, pY + 1));
		pixelak.add(new PixelSimple(pX + 2, pY + 1));
		super.setPixelak(pixelak);
	}
	
}
