package kudeaketaPackage;

import java.awt.EventQueue;

import modelPackage.PartidaKudeatzailea;
import viewPackage.AmaieraPantaila;
import viewPackage.EspazioaView;
import viewPackage.HasieraPantaila;

public class main {
    public static void main(String[] args) {
    	new HasieraPantaila();
    	EventQueue.invokeLater(() -> PartidaKudeatzailea.getPartidaKudeatzailea());
    }
}