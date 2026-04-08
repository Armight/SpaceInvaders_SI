package modelPackage;

import java.util.ArrayList;

public class JokalariGorria extends Jokalari{
	private ArrayList<Pixel> pixelak;
	public JokalariGorria(int pX, int pY) {
		super(pX, pY);
		this.kolorea = "RED";
		this.tiroPortaera = new TiroBakarraPortaera();
		this.pixelak= new ArrayList<Pixel>();
		pixelak.add(new PixelSimple(pX, pY));			//erdiko pixel
		pixelak.add(new PixelSimple(pX + 1, pY));		//eskumako pixel
		pixelak.add(new PixelSimple(pX - 1, pY));		//ezkerreko pixel
		pixelak.add(new PixelSimple(pX, pY - 1));		//goiko pixel
		super.setPixelak(pixelak);
	}
	
	public void aldatuTiroa() {
		if (tiroPortaera instanceof TiroBakarraPortaera) {
			tiroPortaera = new TiroGeziaPortaera();
		}
		else if (tiroPortaera instanceof TiroGeziaPortaera){
			tiroPortaera = new TiroErromboaPortaera();
		}
		else {
			tiroPortaera = new TiroBakarraPortaera();
		}
	}

}
