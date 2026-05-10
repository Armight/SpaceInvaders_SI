package modelPackage;

public class JokalariBerdea extends JokalariMultipixel{
	
	
	public JokalariBerdea(int pX, int pY) {
		super(pX, pY, "GREEN");
		this.tiroPortaera = new TiroBakarraPortaera();
		int posizioak [][];
		posizioak = new int[][] {{0,0},{-1,0},{1,0},{0,-1}};
		
		for (int[] pos : posizioak) {
			Jokalari j = new Jokalari(pX + pos[0], pY + pos[1], "GREEN");
			this.addJokalari(j);
		}
	}
	
	public void aldatuTiroa() {
		if (tiroPortaera instanceof TiroBakarraPortaera) {
			tiroPortaera = new TiroGeziaPortaera();
		}
		else {
			tiroPortaera = new TiroBakarraPortaera();
		}
	}
}

