package controllerPackage;

import java.awt.event.*;
import javax.swing.Timer;
import modelPackage.EspazioModel;

import modelPackage.GelaxkaMatrizea;

import modelPackage.Jokalari;
import modelPackage.Tiro;

import viewPackage.HasieraPantaila;


public class Controller implements KeyListener, ActionListener {

	 	
	private Timer timer;
	private static Controller nireController=null;
	private HasieraPantaila hasieraPantaila;
	private Jokalari jokalari;
	private Tiro tiro;

    

	    private Controller() {
	        
	        
	        //timer begiratu
	        //200milisegundoro, action perdormed() deitu.
	        //this= objektu hau, controllera
	        timer = new Timer(200, this);
	        timer.start();
	    }
	    
	    public static Controller getController() {
	    	if (nireController.equals(null)) {
	    		Controller nireController= new Controller();
	    	}
	    	return nireController;
	    }
	    
	    
	   
	    
	    	


//HASIERA PANTAILA:
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
    
    
  //JOKALARIA:
    
    public void jokalariaSortu(int pX, int pY) {
    	this.jokalari.sortuJokalaria(pX, pY);
    }

 
    @Override
    public void keyPressed(KeyEvent e) {
    	GelaxkaMatrizea model=GelaxkaMatrizea.getGelaxkaMatrizea();
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            this.jokalari.mugituJokalariaX(-1);
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            this.jokalari.mugituJokalariaX(1);
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            this.jokalari.mugituJokalariaY(-1);
        if(e.getKeyCode() == KeyEvent.VK_UP)
        	this.jokalari.mugituJokalariaY(1);
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            this.tiro.disparatu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	GelaxkaMatrizea model=GelaxkaMatrizea.getGelaxkaMatrizea();
        model.update();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}