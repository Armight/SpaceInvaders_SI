package modelPackage;

public class TiroGeziaPortaera implements TiroPortaera{
	public void shoot(int pX, int pY) {
		TiroGezia tiro = new TiroGezia(pX, pY-2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}

}
