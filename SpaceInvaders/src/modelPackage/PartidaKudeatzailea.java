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
	
	//metodo hau ESC teklarako da, baina uste dut zuzenean egin ahalko zela System.exit(0) ipini
	//era honetan kudetzailea erabiltzen dugu, orduan ondo
	public void irteeraEgin() {
	    System.exit(0);
	}
	
	public void jokoanHasi() {
		EspazioModel espazioModel = EspazioModel.getGelaxkaMatrizea();
		this.hasieraItzali();
		
		//EspazioView erakutsi eta EspazioView eta EspazioModel konektatu
		this.espazioViewErakutsi();
		
		espazioModel.jokoanHasi();
	}
	
	private void hasieraItzali() {
		setChanged();
		notifyObservers("HasieraPantaila itzali");
	}
	
	private void espazioViewErakutsi() {
		setChanged();
		notifyObservers("EspazioView erakutsi");
	}
	
	private void espazioViewItzali() {
		setChanged();
		notifyObservers("EspazioView itzali");
	}
	
	
	private void amaieraPantailaErakutsi(boolean pIrabazi) {
		String mezua;
		if (pIrabazi) mezua = "irabazia";
		else mezua = "galdua";
	
		setChanged();
		notifyObservers(mezua);
	}
	
	public void checkJokoa() {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		if (espazioa.getJokoaAmaitu()) {	//Etsai bat Y limitera ailegatu da edo jokalari bat etsai batekin talka egin du
			this.jokoaBukatu(false);
		} else if (espazioa.etsairikEz()) {
			this.jokoaBukatu(true);
		}
	}
	
	private void jokoaBukatu(boolean pIrabazi) {//TODO, jokoa amaitzeko metodoa da, espaziotik amaiera pantailara joateko
		this.espazioViewItzali( );
		this.amaieraPantailaErakutsi(pIrabazi);
	}
	
}
