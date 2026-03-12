package modelPackage;

public abstract class Itsasontzi extends Mugimendu {
	
	private int bizitza;
	protected Itsasontzi(int pX, int pY, boolean pErakutsi, int pPixelKop) {
		super(pX, pY, pErakutsi, pPixelKop);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean xLimiteak(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int zabalera = espazioa.getZabalera();
		int xBerria = this.getX() + i;
		if (xBerria >= zabalera || xBerria < 0) {
			return false;
		} else return true;
	}
	
	protected boolean yLimiteak(int i) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		int altuera = espazioa.getAltuera();
		int yBerria = this.getY() -i;
		if (yBerria < 0 || i == -1 && yBerria >= altuera) {
			return false;
		} else return true;
	}

	
}


