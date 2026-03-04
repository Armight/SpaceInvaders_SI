package controllerPackage;

import java.awt.event.*;
import javax.swing.Timer;

import modelPackage.EspazioModel;


public class Controller implements KeyListener, ActionListener {
	 private EspazioModel model;
	    private Timer timer;

	    public Controller(EspazioModel model) {
	        this.model = model;
	        
	        //timer begiratu
	        //200milisegundoro, action perdormed() deitu.
	        //this= objektu hau, controllera
	        timer = new Timer(200, this);
	        timer.start();
	    }
	    
	    //teklak egiten dutena
	    //ez daude teklek egiten dutena inplementatuta oraindik
	    @Override
	    public void keyPressed(KeyEvent e) {

	        if(e.getKeyCode() == KeyEvent.VK_LEFT)
	            model.mugituJokalariX(-1);
	        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	            model.mugituJokalariX(1);
	        if(e.getKeyCode() == KeyEvent.VK_DOWN)
	            model.mugituJokalariY(-1);
	        if(e.getKeyCode() == KeyEvent.VK_UP)
	            model.mugituJokalariY(1);
	        

	        if(e.getKeyCode() == KeyEvent.VK_SPACE)
	            model.disparatu();
	    }
	    //egindakoa eguneratzeko:
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        model.update();
	    }

	    @Override public void keyReleased(KeyEvent e) {}
	    @Override public void keyTyped(KeyEvent e) {}
}
	
	

