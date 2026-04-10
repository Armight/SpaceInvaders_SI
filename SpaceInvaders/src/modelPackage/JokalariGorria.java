package modelPackage;

public class JokalariGorria extends Jokalari{

	JokalariGorria(int pX, int pY) {
		super(pX, pY, "RED");
		this.tiroPortaera = new TiroBakarraPortaera();
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
