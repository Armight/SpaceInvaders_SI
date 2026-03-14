package viewPackage;

import java.awt.Color;

import java.awt.event.*;

import modelPackage.EspazioModel;
import modelPackage.Jokalari;
import modelPackage.PartidaKudeatzailea;

public class Controller implements KeyListener {
    private static Controller nC;
    //private Timer timer;

    private Controller() {
    	//Timer-a espazioModel-ean sartuko dugu ^-^
        //timer = new Timer(200, this);
        //timer.start();
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
       

        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
            	PartidaKudeatzailea.getPartidaKudeatzailea().setItsasontziKolorea(Color.GREEN);
                break;
            case KeyEvent.VK_B:
            	PartidaKudeatzailea.getPartidaKudeatzailea().setItsasontziKolorea(Color.BLUE);
                break;
            case KeyEvent.VK_R:
            	PartidaKudeatzailea.getPartidaKudeatzailea().setItsasontziKolorea(Color.RED);
                break;
            case KeyEvent.VK_ENTER:
            	PartidaKudeatzailea.getPartidaKudeatzailea().jokoanHasi();
                break;
            //Hau da ESC teklarako (AmaieraPantaila klasean hobeto azalduta T-T)
            case KeyEvent.VK_ESCAPE:
            	PartidaKudeatzailea.getPartidaKudeatzailea().irteeraEgin();
                break;
        }
        
        //ALDAKETAK: hemen ezin da egon modeloko objekturik

        
        
            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                EspazioModel.getGelaxkaMatrizea().mugituJokalariaY(1); 
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            	EspazioModel.getGelaxkaMatrizea().mugituJokalariaY(-1); 
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            	EspazioModel.getGelaxkaMatrizea().mugituJokalariaX(-1);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            	EspazioModel.getGelaxkaMatrizea().mugituJokalariaX(1); 
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            	EspazioModel.getGelaxkaMatrizea().shoot(); 
            }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    /*@Override
    public void actionPerformed(ActionEvent e) {
        EspazioModel.getGelaxkaMatrizea().jokoaEguneratu();
    } 
    Kenduta mugituko delako EspazioModel-era
    */ 
}