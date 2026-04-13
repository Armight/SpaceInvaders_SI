
package modelPackage;

public class TiroErromboa extends TiroMultipixel {
	int[] goikoa= {0,4};
    public TiroErromboa(int pX, int pY) {
        
    	super(pX, pY);
    	if(pY >= 6) { //OutOfBounds ez emateko goi goian sortzen dugunean tiroa.
    		int[][] posizioak = new int[][] {
        		{0, 0}, {0, -1}, {1, -1}, {-1, -1},
        	    {0, -2}, {1, -2}, {-1, -2}, {-2, -2}, {2, -2},
        	    {0, -3}, {1, -3}, {-1, -3}, {0, -4}};
        	
        	
        	for (int[] pos : posizioak) {
        		
        		Tiro t = new Tiro(pX + pos[0], pY + pos[1]);
        		this.addTiro(t);
    	
    		
    	}
    	
    	}
    }
    
    public static boolean puedeCrear(int pX, int pY) {
        EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();

        int[][] posizioak = new int[][] {
            {0, 0}, {0, -1}, {1, -1}, {-1, -1},
            {0, -2}, {1, -2}, {-1, -2}, {-2, -2}, {2, -2},
            {0, -3}, {1, -3}, {-1, -3}, {0, -4}
        };

        for (int[] pos : posizioak) {
            int x = pX + pos[0];
            int y = pY + pos[1];

            if (espazioa.espaziotikKanpo(x, y)) return false;

            String egoera = espazioa.getGelaxka(x, y).getEgoera();

            if (!egoera.equalsIgnoreCase("Hutsik")) {
                return false;
            }
        }

        return true;
    }
    
    
    
}