package controllerPackage;

import java.awt.event.*;
import javax.swing.Timer;
import modelPackage.EspazioModel;
import modelPackage.Jokalari;
import modelPackage.TiroTxikia;
import viewPackage.HasieraPantaila;

public class Controller implements KeyListener, ActionListener {

    private Timer timer;
    private static Controller nireController = null;
    private HasieraPantaila hasieraPantaila;
    private Jokalari jokalari;
    private TiroTxikia tiro;
    private String itsasontziMota;

    private Controller() {
        timer = new Timer(200, this);
        timer.start();
    }

    public static Controller getController() {
        if (nireController == null) {
            nireController = new Controller();
        }
        return nireController;
    }

    // HASIERA PANTAILA:
    public void setHasieraPantaila(HasieraPantaila hasieraPantaila) {
        this.hasieraPantaila = hasieraPantaila;
    }

    public void hasieraPantailaKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
                itsasontziMota = "Green";
                hasieraPantaila.erakutsiItsasontziHautatua("Green");
                break;
            case KeyEvent.VK_B:
                itsasontziMota = "Blue";
                hasieraPantaila.erakutsiItsasontziHautatua("Blue");
                break;
            case KeyEvent.VK_R:
                itsasontziMota = "Red";
                hasieraPantaila.erakutsiItsasontziHautatua("Red");
                break;
        }
    }

    public String getItsasontziMota() {
        return itsasontziMota;
    }

    // JOKALARIA:
    public void setJokalari(Jokalari jokalari) {
        this.jokalari = jokalari;
    }

    public void setTiro(Tiro tiro) {
        this.tiro = tiro;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (jokalari != null) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
                jokalari.mugituJokalariaX(-1);
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                jokalari.mugituJokalariaX(1);
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
                jokalari.mugituJokalariaY(-1);
            if(e.getKeyCode() == KeyEvent.VK_UP)
                jokalari.mugituJokalariaY(1);
        }
        // Sprint 1ean tiro txikia bakarrik
        if(e.getKeyCode() == KeyEvent.VK_SPACE && tiro != null)//SPACE= pixel bateko tiroa
        {
        	jokalari.shootPixel();
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Sprint 1ean etsaien mugimendua hemen
        EspazioModel.getGelaxkaMatrizea();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}