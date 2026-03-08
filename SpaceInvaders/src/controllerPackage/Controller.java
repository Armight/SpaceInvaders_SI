package controllerPackage;

import java.awt.event.*;
import javax.swing.Timer;
import modelPackage.EspazioModel;
import modelPackage.Jokalari;
import modelPackage.JokalariMorea;
import viewPackage.HasieraPantaila;
import viewPackage.AmaieraPantaila;
import viewPackage.Espazioa;

public class Controller implements KeyListener, ActionListener {

    private Timer timer;
    private static Controller nireController = null;
    private HasieraPantaila hasieraPantaila;
    private Espazioa espazioa;
    private Jokalari jokalari;
    
    private String itsasontziMota;

    private Controller() {
    	EspazioModel.getGelaxkaMatrizea();
    	
        timer = new Timer(200, this);//200ms-ro tick eta actionPerformed() metodora deitu, bertan update() deituko da.
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
	        case KeyEvent.VK_1:
	            if (itsasontziMota != null) {  // solo si ha elegido nave
	                jokoanHasi();
	            }
	            break;
        }
    }
    //ESPAZIOA PANTAILA
    public void setEspazioa(viewPackage.Espazioa espazioa) {
        this.espazioa = espazioa;
    }
    
    
    //AMAIERA PANTAILA
    private AmaieraPantaila amaieraPantaila;

    public void setAmaieraPantaila(AmaieraPantaila amaieraPantaila) {
        this.amaieraPantaila = amaieraPantaila;
    }

    public void amaieraPantailaKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }
    public String getItsasontziMota() {
        return itsasontziMota;
    }

    // JOKALARIA:
    public void setJokalari(Jokalari jokalari) {
        this.jokalari = jokalari;
    }

    //JOKOA HASTEKO METODOA HASIERA PANTAILATIK ESPAZIORA
    private void jokoanHasi() {
        hasieraPantaila.dispose();
        
        //Jokalaria pantailaratu
        int pXErdia = EspazioModel.getGelaxkaMatrizea().getZabalera()/2;
        int pYBehean = EspazioModel.getGelaxkaMatrizea().getAltuera() - 2;
        jokalari = new JokalariMorea(pXErdia, pYBehean, true, 4);
        		
        espazioa.konektatu();
        jokalari.sortuJokalaria(pXErdia, pYBehean);
        espazioa.setVisible(true);
        espazioa.requestFocus();
    }

    //AMAIERA PANTAILARA JOATEKO
    public void jokoaAmaitu(String mezua) {
        espazioa.dispose();
        amaieraPantaila = new AmaieraPantaila(mezua);
        amaieraPantaila.setController(this);
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
    	//KONTUZZ HAU DA EA PANTAILAZ ALDATZEN DEN! KENDUKO DUGU GERO, TENPORALA DA.
    	if (e.getKeyCode() == KeyEvent.VK_F) {
            jokoaAmaitu("IRABAZI DUZU!");
        }
        if (jokalari != null) {
            if(e.getKeyCode() == KeyEvent.VK_UP)
                jokalari.mugituJokalariaY(-1);
            if(e.getKeyCode() == KeyEvent.VK_DOWN)
                jokalari.mugituJokalariaY(1);
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                jokalari.mugituJokalariaX(-1);
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
                jokalari.mugituJokalariaX(1);
        }
        // Sprint 1ean tiro txikia bakarrik
        if(e.getKeyCode() == KeyEvent.VK_SPACE)//SPACE= pixel bateko tiroa
        {
        	jokalari.shootPixel(); 
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // Sprint 1ean etsaien mugimendua hemen //???
    	
       EspazioModel.getGelaxkaMatrizea().update();
       
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}