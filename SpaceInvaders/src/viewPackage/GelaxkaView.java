package viewPackage;


//Observer implementado
import javax.swing.JPanel;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class GelaxkaView extends JPanel implements Observer{
	private JLabel jLabel;
	

	public GelaxkaView(JLabel pJLabel) {
		JLabel jLabel = pJLabel;
		
	}
	public GelaxkaView() {
		this.jLabel = new JLabel();
		this.jLabel.setOpaque(true);       
		this.jLabel.setBackground(Color.BLACK); //
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("Etsai")) {
			this.jLabel.setBackground(Color.red);
		} else if (arg.equals("Jokalari")) {
			this.jLabel.setBackground(new Color(160,32,240));
		} else if (arg.equals("Hutsik")) {
			this.jLabel.setBackground(Color.black);
		} else if (arg.equals("Tiro")) {
			this.jLabel.setBackground(Color.yellow);
		}
	}
	
	public JLabel getLabel() {
		return this.jLabel;
	}
	
	
}




