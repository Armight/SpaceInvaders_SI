package modelPackage;

public class TiroTxikia extends Tiro {

    public TiroTxikia(int pX, int pY, int pPixelKop) {
        super(pX, pY, 1);
    }
    
    public void mugitu() {
        int newY = getY() - 1;
        setPosizio(getX(), newY);

        if (newY < 0) {
            setIkusmena(false);
        }
    }
}