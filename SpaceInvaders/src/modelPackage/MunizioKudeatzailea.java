package modelPackage;

public class MunizioKudeatzailea {

    private static MunizioKudeatzailea nMK;

    public static final int geziaMunizioMaximoa    = 30;
    public static final int erromboaMunizioMaximoa = 20;

    private int geziaMunizio;
    private int erromboaMunizio;

    private MunizioKudeatzailea() {
        geziaMunizio    = geziaMunizioMaximoa;
        erromboaMunizio = erromboaMunizioMaximoa;
    }

    public static MunizioKudeatzailea getMunizioKudeatzailea() {
        if (nMK == null) {
            nMK = new MunizioKudeatzailea();
        }
        return nMK;
    }

    // Gezien metodoak
    public int getGeziaMunizio() {
        return geziaMunizio;
    }

    public boolean geziaErabili() {
        if (geziaMunizio <= 0) return false;
        geziaMunizio = geziaMunizio - 1;
        return true;
    }

    public void geziaKargatu() {
        geziaMunizio = geziaMunizioMaximoa;
    }

    // Erromboen metodoak
    public int getErromboaMunizio() {
        return erromboaMunizio;
    }

   
    public boolean erromboaErabili() {
        if (erromboaMunizio <= 0) return false;
        erromboaMunizio = erromboaMunizio - 1;
        return true;
    }

    public void erromboaKargatu() {
        erromboaMunizio = erromboaMunizioMaximoa;
    }

 
    public void denaKargatu() {
        geziaKargatu();
        erromboaKargatu();
    }

    //Metodo hau da beste partida egiten bada ez eukitzeko lehen erabilitakoa
    public static void resetatu() {
        nMK = null;
    }
}