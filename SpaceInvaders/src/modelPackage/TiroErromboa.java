
package modelPackage;

public class TiroErromboa extends TiroMultipixel {
    public TiroErromboa(int pX, int pY) {
        
    	super(pX, pY);
    	
    	int posizioak[][] = new int[][] {{0, 0}, {1, 0}, {2, 0}, {-1, 0}, {-2, 0},
    		{0, 1}, {1, 1}, {-1, 1}, {0, -1}, {1, -1}, {-1, -1},
    		{0, -2}, {0, 2}};
    	
    	
    	for (int[] pos : posizioak) {
    		Tiro t = new Tiro(pX + pos[0], pY + pos[1]);
    		this.addTiro(t);
    	}
    }
}