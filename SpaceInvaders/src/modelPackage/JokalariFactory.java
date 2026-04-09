package modelPackage;

public class JokalariFactory {
	private static JokalariFactory nJokalariFactory;
	
	private JokalariFactory() {}
	
	public static JokalariFactory getJokF() {
		if (nJokalariFactory==null) {
			
			nJokalariFactory = new JokalariFactory();
		}
		return nJokalariFactory;
	}
	
	public Pixel createJokalaria(String pKolorea, int pX, int pY) {
				
		if (pKolorea.equals("GREEN")) {
			return new JokalariBerdea(pX,pY);
		}
		else if (pKolorea.equals("RED")) {
			return new JokalariGorria(pX,pY);
		}
		else if (pKolorea.equals("BLUE")) {
			return new JokalariUrdina(pX,pY);
		}
		return null;
	}
	
}
