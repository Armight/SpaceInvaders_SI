package kudeaketaPackage;

import java.awt.EventQueue;

import modelPackage.PartidaKudeatzailea;
import viewPackage.AmaieraPantaila;
import viewPackage.EspazioaView;
import viewPackage.HasieraPantaila;

public class main {
    public static void main(String[] args) {
    	HasieraPantaila hasieraPantaila = new HasieraPantaila();
    	EspazioaView espazioView = new EspazioaView();
    	AmaieraPantaila amaieraPantaila = new AmaieraPantaila();
    	EventQueue.invokeLater(() -> PartidaKudeatzailea.getPartidaKudeatzailea());
    }
}