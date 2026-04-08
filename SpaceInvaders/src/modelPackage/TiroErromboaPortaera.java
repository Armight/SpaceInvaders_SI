package modelPackage;

public class TiroErromboaPortaera implements TiroPortaera{
	public void shoot(int pX, int pY) {
		TiroErromboa tiro = new TiroErromboa(pX, pY-2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}

}
