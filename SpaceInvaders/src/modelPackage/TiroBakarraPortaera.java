package modelPackage;

public class TiroBakarraPortaera implements TiroPortaera{
	public void shoot(int pX, int pY) {
		Tiro tiro = new Tiro(pX, pY);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
}
