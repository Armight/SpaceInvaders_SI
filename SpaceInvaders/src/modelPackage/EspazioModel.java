package modelPackage;

public class EspazioModel {
	private static EspazioModel nGM;
	private Gelaxka[][] matrizea;
	
	private EspazioModel() {
		matrizea = new Gelaxka[60][100];
	}
	
	public static EspazioModel getGelaxkaMatrizea() {
		if (nGM == null) {
			nGM = new EspazioModel();
		}
		return nGM;
	}
	
	public void matrizeaBete() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				matrizea[i][j] = new Gelaxka(i, j, "hutsik dago");
			}
		}
	}
		
			
//Setchange && notify (== metodoak) observer, bistan ezin daitezke objetuak interkambiatu bien artean, bakarrik emari deitu and egoera ikusi EDO String-ak bidali, View-k ez ditu objeturik erabiliko
	
	public Gelaxka getGelaxka(int pX, int pY) {//posizio horren gelaxka lortu
		return this.matrizea[pX][pY];
	}
	
	public void update() {
		
	}

}
