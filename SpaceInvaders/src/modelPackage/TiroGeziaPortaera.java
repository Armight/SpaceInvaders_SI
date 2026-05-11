package modelPackage;

public class TiroGeziaPortaera implements TiroPortaera{
	public void shoot(int pX, int pY) {
		 if (!MunizioKudeatzailea.getMunizioKudeatzailea().geziaErabili()) return;
		TiroGezia tiro = new TiroGezia(pX, pY-2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
	
	/*
	public int getMunizio() { //ez da erabiltzen oraindik
		return MunizioKudeatzailea.getMunizioKudeatzailea().getGeziaMunizio();
	}*/

}
