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
			jokalaria = new JokalariBerdea(pX,pY);
		}
		else if (pKolorea.equals("RED")) {
			jokalaria = new JokalariGorria(pX,pY);
		}
		else if (pKolorea.equals("BLUE")) {
			jokalaria = new JokalariUrdina(pX,pY);
		}
		return jokalaria;
	}
	
}
