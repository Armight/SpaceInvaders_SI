package modelPackage;

import java.awt.Color;
import java.util.Observable;

import controllerPackage.Controller;


public class PartidaKudeatzailea extends Observable {
	private static PartidaKudeatzailea nPK;
	private Color itsasontziKolorea;
	
	private PartidaKudeatzailea() {
		Controller controller = Controller.getController();
	}
	
	public static PartidaKudeatzailea getPartidaKudeatzailea() {
		if (nPK == null) {
			nPK = new PartidaKudeatzailea();
		}
		return nPK;
	}
	
	public void setItsasontziKolorea(Color pKolorea ) {
		this.itsasontziKolorea = pKolorea;
		setChanged();
		notifyObservers(pKolorea);
	}
	
	public Color getKolorea() {
		return this.itsasontziKolorea;
	}
	
}

	
	
	
/*
	private static PartidaKudeatzailea nPK;
    private HasieraPantaila hasieraPantaila;
    private AmaieraPantaila amaieraPantaila;
    private Espazioa espazioa;
    private Controller controller;

    private PartidaKudeatzailea() {
        // 1. CONTROLLERA EGIN
        // Controller barne EspazioModel sortzen da
        controller = Controller.getController();

        // 2. ESPAZIOA SORTU
        espazioa = Espazioa.getEspazioa();
        espazioa.konektatu();
        espazioa.setController(controller);
        controller.setEspazioa(espazioa);

        // 3. HASIERA PANTAILA
        hasieraPantaila = new HasieraPantaila();
        hasieraPantaila.setController(controller);
        controller.setHasieraPantaila(hasieraPantaila);        
    }
    
    
    public static PartidaKudeatzailea getPartidaKudeatzailea() {
    	if (nPK == null) {
    		nPK = new PartidaKudeatzailea();
    	} 
    	return nPK;
    }
    
    //4. AMAIERA PANTAILA
    public void partidaAmaitu(boolean pEtsairikEz) {
    	if (pEtsairikEz) {
    		amaieraPantaila = new AmaieraPantaila("IRABAZI DUZU!");
    		amaieraPantaila.setController(controller);
    		controller.setAmaieraPantaila(amaieraPantaila);
    	}
    }
}*/
