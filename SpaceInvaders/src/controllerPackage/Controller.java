package controllerPackage;

import java.awt.event.*;
import javax.swing.Timer;
import modelPackage.EspazioModel;
import viewPackage.HasieraPantaila;

public class Controller implements KeyListener, ActionListener {
    private EspazioModel model;
    private HasieraPantaila hasieraPantaila;
    private Timer timer;

    public Controller(EspazioModel model) {
        this.model = model;
        timer = new Timer(200, this);
        timer.start();
    }

    public void setHasieraPantaila(HasieraPantaila hasieraPantaila) {
        this.hasieraPantaila = hasieraPantaila;
    }
    //hasieran pantailanh aukeratzeko
    public void hasieraPantailaKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
                model.setItsasontziMota("Green");
                hasieraPantaila.erakutsiItsasontziHautatua("Green");
                break;
            case KeyEvent.VK_B:
                model.setItsasontziMota("Blue");
                hasieraPantaila.erakutsiItsasontziHautatua("Blue");
                break;
            case KeyEvent.VK_R:
                model.setItsasontziMota("Red");
                hasieraPantaila.erakutsiItsasontziHautatua("Red");
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            model.mugituJokalariX(-1);
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            model.mugituJokalariX(1);
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            model.mugituJokalariY(1);
        if(e.getKeyCode() == KeyEvent.VK_UP)
            model.mugituJokalariY(-1);
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            model.disparatu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}