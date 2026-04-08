package modelPackage;

public class TiroErromboaPortaera implements TiroPortaera{
	public void shoot(int pX, int pY) {
		TiroErromboa tiro = new TiroErromboa(pX, pY);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}

}
