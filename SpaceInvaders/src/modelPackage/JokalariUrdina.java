package modelPackage;

public class JokalariUrdina extends JokalariMultipixel{
	JokalariUrdina(int pX, int pY) {
		super(pX, pY, "BLUE");
		this.tiroPortaera = new TiroBakarraPortaera();
		
	}
	
	public void aldatuTiroa() {
		if (tiroPortaera instanceof TiroBakarraPortaera) {
			tiroPortaera = new TiroErromboaPortaera();
		}
		else {
			tiroPortaera = new TiroBakarraPortaera();
		}
	}
	
}
