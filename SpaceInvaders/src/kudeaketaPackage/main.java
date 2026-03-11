package kudeaketaPackage;

import java.awt.EventQueue;

import java.util.ArrayList;

import modelPackage.PartidaKudeatzailea;
import viewPackage.Espazioa;
import viewPackage.HasieraPantaila;

public class main {
    public static void main(String[] args) {
    	HasieraPantaila hasierapnataila = new HasieraPantaila();
    	Espazioa espazioView = new Espazioa();
    	EventQueue.invokeLater(() -> PartidaKudeatzailea.getPartidaKudeatzailea());
    }
}