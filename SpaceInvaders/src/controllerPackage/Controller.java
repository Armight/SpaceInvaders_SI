package controllerPackage;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.Timer;

import modelPackage.EspazioModel;
import modelPackage.Jokalari;
import modelPackage.PartidaKudeatzailea;

public class Controller implements KeyListener, ActionListener {
    private static Controller nC;
    private Timer timer;

    private Controller() {
        timer = new Timer(200, this);
        timer.start();
    }

    public static Controller getController() {
        if (nC == null) {
            nC = new Controller();
        }
        return nC;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        PartidaKudeatzailea kudeatzailea = PartidaKudeatzailea.getPartidaKudeatzailea();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
                kudeatzailea.setItsasontziKolorea(Color.GREEN);
                break;
            case KeyEvent.VK_B:
                kudeatzailea.setItsasontziKolorea(Color.BLUE);
                break;
            case KeyEvent.VK_R:
                kudeatzailea.setItsasontziKolorea(Color.RED);
                break;
            case KeyEvent.VK_ENTER:
                kudeatzailea.jokoanHasi();
                break;
        }

        Jokalari jokalari = EspazioModel.getGelaxkaMatrizea().getJokalari();
        if (jokalari != null) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                jokalari.mugituJokalariaY(1); 
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                jokalari.mugituJokalariaY(-1); 
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                jokalari.mugituJokalariaX(-1);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                jokalari.mugituJokalariaX(1); 
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                jokalari.shoot(); 
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        EspazioModel.getGelaxkaMatrizea().jokoaEguneratu();
    }
}