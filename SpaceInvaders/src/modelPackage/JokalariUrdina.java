package modelPackage;

public class JokalariUrdina extends JokalariMultipixel{
	JokalariUrdina(int pX, int pY) {
		super(pX, pY, "BLUE");
		this.tiroPortaera = new TiroBakarraPortaera();
		int posizioak [][];
		posizioak = new int[][] {{0,0},{-1,0},{1,0},{-1,-1},
			{1,-1},{-1,1},{0,1},{1,1}};
		
		for (int[] pos : posizioak) {
			Jokalari j = new Jokalari(pX + pos[0], pY + pos[1], "BLUE");
			this.addJokalari(j);
		}
	}
	
	public void aldatuTiroa() {
		if (tiroPortaera instanceof TiroBakarraPortaera) {
			tiroPortaera = new TiroErromboaPortaera();
		}
		else {
			tiroPortaera = new TiroBakarraPortaera();
		}
	}
	
}
