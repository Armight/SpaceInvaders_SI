package modelPackage;

public abstract class Etsai extends Espaziontzi {
		
    protected Etsai(int pX, int pY, int pPixelKop) {
        super(pX, pY, pPixelKop);
    }
    
    //ETSAI METODO OROKORRAK:
    public abstract void sortuEtsaia();
    
    public abstract void mugituEtsaiX(int i);
    
    public abstract void mugituEtsaiY();
    
    public void mugituRandom() {
        int r = (int)(Math.random() * 3); // 0, 1 edo 2

        if (r == 0) {
           mugituEtsaiX(-1); // ezkerrera
        } else if (r == 1) {
           mugituEtsaiX(1);  // eskumara
        } else {
           mugituEtsaiY();  // behera
        }
    }
    
    public boolean kolisioakKonprobatu (int pX, int pY) {
    	if (getX() == pX && getY() == pY) {
    		return true;
    	} else return false;
    }
}

