package viewPackage;



import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class GelaxkaView implements Observer{
	private JLabel JLabel;
	
	public GelaxkaView(JLabel pJLabel) {
		JLabel = pJLabel;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// Lo que tenga que hacer ponerlo aqui
		
	}
	
	
}




