package modelPackage;

public class JokalariGorria extends JokalariMultipixel{

	JokalariGorria(int pX, int pY) {
		super(pX, pY, "RED");
		this.tiroPortaera = new TiroBakarraPortaera();
		int posizioak [][];
		posizioak = new int[][] {{0,0},{-2,0},{-1,0},{1,0},{2,0},{-1,-1},{1,-1},
			{-3,1},{-2,1},{-1,1},{1,1},{2,1},{3,1}} ;
		
		for (int[] pos : posizioak) {
			Jokalari j = new Jokalari(pX + pos[0], pY + pos[1], "RED");
			this.addJokalari(j);
		}
	}
	
	public void aldatuTiroa() {
		if (tiroPortaera instanceof TiroBakarraPortaera) {
			tiroPortaera = new TiroGeziaPortaera();
		}
		else if (tiroPortaera instanceof TiroGeziaPortaera){
			tiroPortaera = new TiroErromboaPortaera();
		}
		else {
			tiroPortaera = new TiroBakarraPortaera();
		}
	}
}
