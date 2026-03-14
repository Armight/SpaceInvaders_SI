package viewPackage;

import java.awt.Color;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Timer;

import modelPackage.EspazioModel;
import modelPackage.PartidaKudeatzailea;

public class Controller implements KeyListener {
    private static Controller nC;
    private Set<Integer> teklakSakatuta = new HashSet<>();
    private Timer inputTimer;
    

    private Controller() {
    	inputTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prozesatuInputak();
            }
        });
        inputTimer.start();
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
            default:
            	teklakSakatuta.add(e.getKeyCode());
        }
        
        //ALDAKETAK: hemen ezin da egon modeloko objekturik

        
        
}
        
    
    private void prozesatuInputak() {
    	if (teklakSakatuta.contains(KeyEvent.VK_UP) || teklakSakatuta.contains(KeyEvent.VK_W)) {
            EspazioModel.getGelaxkaMatrizea().mugituJokalariaY(1); 
        }
        if (teklakSakatuta.contains(KeyEvent.VK_DOWN) || teklakSakatuta.contains(KeyEvent.VK_S)) {
        	EspazioModel.getGelaxkaMatrizea().mugituJokalariaY(-1); 
        }
        if (teklakSakatuta.contains(KeyEvent.VK_LEFT)  || teklakSakatuta.contains(KeyEvent.VK_A)) {
        	EspazioModel.getGelaxkaMatrizea().mugituJokalariaX(-1);
        }
        if (teklakSakatuta.contains(KeyEvent.VK_RIGHT)  || teklakSakatuta.contains(KeyEvent.VK_D) ) {
        	EspazioModel.getGelaxkaMatrizea().mugituJokalariaX(1); 
        }
        if (teklakSakatuta.contains(KeyEvent.VK_SPACE)  ) {
        	EspazioModel.getGelaxkaMatrizea().shoot(); 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {teklakSakatuta.remove(e.getKeyCode());} //pultsatutako teklak ezabatzeko
    	
    /*@Override
    public void actionPerformed(ActionEvent e) {
        EspazioModel.getGelaxkaMatrizea().jokoaEguneratu();
    } 
    Kenduta mugituko delako EspazioModel-era
    */ 
}