package kudeaketaPackage;

import java.awt.EventQueue;

import java.util.ArrayList;

import modelPackage.PartidaKudeatzailea;
import viewPackage.AmaieraPantaila;
import viewPackage.EspazioaView;
import viewPackage.HasieraPantaila;

public class main {
    public static void main(String[] args) {
    	HasieraPantaila hasierapnataila = new HasieraPantaila();
    	EspazioaView espazioView = new EspazioaView();
    	AmaieraPantaila amaieraPantaila = new AmaieraPantaila();
    	EventQueue.invokeLater(() -> PartidaKudeatzailea.getPartidaKudeatzailea());
    }
}