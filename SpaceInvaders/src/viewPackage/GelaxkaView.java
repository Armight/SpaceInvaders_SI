package viewPackage;


//Observer implementado
import javax.swing.JPanel;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class GelaxkaView extends JPanel implements Observer{
	private JLabel jLabel;
	private static final long serialVersionUID = 1L;
	
	public GelaxkaView() {
		this.jLabel = new JLabel();
		this.jLabel.setOpaque(true);       
		this.jLabel.setBackground(Color.BLACK); //
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("Etsaia")) {
			this.jLabel.setBackground(Color.pink);
		} else if (arg.equals("Jokalari_RED")) {
			this.jLabel.setBackground(Color.red);
		} else if (arg.equals("Jokalari_GREEN")) {
			this.jLabel.setBackground(Color.green);
		} else if (arg.equals("Jokalari_BLUE")) {
			this.jLabel.setBackground(Color.blue);
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

