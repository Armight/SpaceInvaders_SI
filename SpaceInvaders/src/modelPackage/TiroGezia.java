
package modelPackage;

public class TiroGezia extends TiroMultipixel {
    
	public TiroGezia(int pX, int pY) {
		
		super(pX, pY);
		
		int posizioak [][] = new int [][] {{0,-1}, {-1, 0}, {1, 0}};
		
		for (int[] pos : posizioak) {
			Tiro t = new Tiro(pX + pos[0], pY + pos[1]);
			this.addTiro(t);
		}
    }
}