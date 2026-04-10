package modelPackage;

public class JokalariBerdea extends JokalariMultipixel{
	
	
	public JokalariBerdea(int pX, int pY) {
			super(pX, pY, "GREEN");
			this.tiroPortaera = new TiroBakarraPortaera();
			
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

