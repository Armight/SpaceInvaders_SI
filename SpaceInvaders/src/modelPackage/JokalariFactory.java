package modelPackage;

public class JokalariFactory {
	private static JokalariFactory nJokalariFactory;
	
	private JokalariFactory() {}
	
	public static JokalariFactory getJK() {
		if (nJokalariFactory==null) {
			
			nJokalariFactory = new JokalariFactory();
		}
		return nJokalariFactory;
	}
	
	public Jokalari createJokalaria(String pKolorea, int pX, int pY) {
		Jokalari jokalaria = null;
		if (pKolorea.equals("GREEN")) {
			jokalaria = new Jokalari(pX,pY);
		}
		if (pKolorea.equals("RED")) {
			jokalaria = new Jokalari(pX,pY);
		}
		if (pKolorea.equals("BLUE")) {
			jokalaria = new Jokalari(pX,pY);
		}
		return jokalaria;
	}
	
}
