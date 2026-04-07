package modelPackage;

import java.util.ArrayList;

public class JokalariGorria extends Jokalari{
	private ArrayList<Pixel> pixelak;
	public JokalariGorria(int pX, int pY) {
		super(pX, pY);
		this.kolorea = "RED";
		this.pixelak= new ArrayList<Pixel>();
		pixelak.add(new PixelSimple(pX, pY));			//erdiko pixel
		pixelak.add(new PixelSimple(pX + 1, pY));		//eskumako pixel
		pixelak.add(new PixelSimple(pX - 1, pY));		//ezkerreko pixel
		pixelak.add(new PixelSimple(pX, pY - 1));		//goiko pixel
		super.setPixelak(pixelak);
	}
	

}
