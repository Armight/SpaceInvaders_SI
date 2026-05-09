package modelPackage;

public class TiroErromboaPortaera implements TiroPortaera{
	public void shoot(int pX, int pY) {
		 if (!MunizioKudeatzailea.getMunizioKudeatzailea().geziaErabili()) return;
		TiroErromboa tiro = new TiroErromboa(pX, pY-2);
		EspazioModel.getGelaxkaMatrizea().addTiro(tiro);
	}
	
	public int getMunizio() {  //ez da erabiltzen oraindik
		return MunizioKudeatzailea.getMunizioKudeatzailea().getErromboaMunizio();
	}
}
