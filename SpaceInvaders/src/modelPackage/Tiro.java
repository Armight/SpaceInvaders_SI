package modelPackage;

public abstract class Tiro extends Mugimendu {

    protected Tiro(int pX, int pY,int pPixelKop) {
        super(pX, pY, true, pPixelKop);  // true=visible, 1=pixel bakarra Sprint 1ean
    }

    public void mugitu() {
        int newY = getY() - 1;
        setPosizio(getX(), newY);

        if (newY < 0) {
            setIkusmena(false);
        }
    }
}