package modelPackage;

public class GelaxkaMatrizea {
	private static GelaxkaMatrizea nGM;
	private Gelaxka[][] matrizea;
	
	private GelaxkaMatrizea() {
		matrizea = new Gelaxka[60][100];
	}
	
	public static GelaxkaMatrizea getGelaxkaMatrizea() {
		if (nGM == null) {
			nGM = new GelaxkaMatrizea();
		}
		return nGM;
	}
	
	public void matrizeaBete() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				matrizea[i][j] = new Gelaxka(i, j, "hutsik");
			}
		}
	}
		
			
			//Setchange && notify (== metodoak) observer, bistan ezin daitezke objetuak interkambiatu bien artean, bakarrik emari deitu and egoera ikusi EDO String-ak bidali, View-k ez ditu objeturik erabiliko
	

}
