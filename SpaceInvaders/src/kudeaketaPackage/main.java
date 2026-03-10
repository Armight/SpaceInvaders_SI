package kudeaketaPackage;

import java.awt.EventQueue;

import java.util.ArrayList;

import modelPackage.PartidaKudeatzailea;
import viewPackage.Espazioa;

public class main {
    public static void main(String[] args) {
    	Espazioa espazioView = Espazioa.getEspazioa();
       EventQueue.invokeLater(() -> PartidaKudeatzailea.getPartidaKudeatzailea());
    }
}