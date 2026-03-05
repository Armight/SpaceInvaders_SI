package controllerPackage;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class GelaxkaBista implements Observer{
	private JLabel JLabel;
	
	public GelaxkaBista(JLabel pJLabel) {
		JLabel = pJLabel;
	}

	@Override
	public void update(Observable o, Object arg) {
		// Lo que tenga que hacer ponerlo aqui
		
	}
	
	
}
