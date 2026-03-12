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
        // Timer que cada 200ms llama a actionPerformed
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

        // Teclas de selección de color y inicio
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

        // Movimiento y disparo (solo si el juego ha comenzado)
        Jokalari jokalari = EspazioModel.getGelaxkaMatrizea().getJokalari();
        if (jokalari != null) {
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                jokalari.mugituJokalariaY(1); // subir (Y disminuye)
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                jokalari.mugituJokalariaY(-1); // bajar (Y aumenta)
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                jokalari.mugituJokalariaX(-1); // izquierda
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                jokalari.mugituJokalariaX(1); // derecha
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                jokalari.shootPixel(); // disparo básico
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        // Llamado por el Timer cada 200ms: actualiza el modelo (mover enemigos, tiros, etc.)
        EspazioModel.getGelaxkaMatrizea().update();
    }
}