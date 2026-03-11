package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import controllerPackage.Controller;
import modelPackage.PartidaKudeatzailea;

public class HasieraPantaila extends JFrame implements Observer{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel tituloLabel;
    private JLabel instrukzioakLabel;
    private JLabel hautatutaLabel;

    public HasieraPantaila() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Space Invaders");
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 620, 420);
        setResizable(false);

        contentPane = new JPanel() {
            private Image bgImage = new ImageIcon(getClass().getResource("/resources/fondoaHasPant.jpg")).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());
        setContentPane(contentPane);

        // Titulua
        tituloLabel = new JLabel("SPACE INVADERS");
        tituloLabel.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        tituloLabel.setForeground(Color.GREEN);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.insets = new Insets(10, 10, 10, 10);
        contentPane.add(tituloLabel, gbc1);

        //Ontziaren aukeraketa instrukzioak
        instrukzioakLabel = new JLabel("* Press <G> Green  <B> Blue  <R> Red to play *");
        instrukzioakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        instrukzioakLabel.setForeground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.insets = new Insets(10, 10, 10, 10);
        contentPane.add(instrukzioakLabel, gbc2);

        //Ontzi aukeratua
        hautatutaLabel = new JLabel("Hautatu itsasontzia...");
        hautatutaLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        hautatutaLabel.setForeground(Color.ORANGE);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.insets = new Insets(10, 10, 10, 10);
        contentPane.add(hautatutaLabel, gbc3);
        
        //Observer gehitu
        PartidaKudeatzailea kudeatzailea = PartidaKudeatzailea.getPartidaKudeatzailea();
        kudeatzailea.addObserver(this);
        
        //Listener gehitu
        Controller controller = Controller.getController();
        this.addKeyListener(controller);
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setVisible(true);
    }
    
    private void erakutsiItsasontziHautatua(Color pKolorea) {
    	String mota = this.kolorearenIzena(pKolorea);
    	hautatutaLabel.setText("Hautatua: " + mota + " - Press <1> to play!");
        switch (mota) {
            case "Green": hautatutaLabel.setForeground(Color.GREEN); break;
            case "Blue":  hautatutaLabel.setForeground(Color.BLUE);  break;
            case "Red":   hautatutaLabel.setForeground(Color.RED);   break;
        }
    }
    
    private String kolorearenIzena(Color pKolorea) {
    	if (pKolorea.equals(Color.GREEN)) return "Green";
    	if (pKolorea.equals(Color.BLUE)) return "Blue";
    	if (pKolorea.equals(Color.RED)) return "Red";
    	return "Ezezaguna";
    }
    
    @Override
   	public void update(Observable o, Object arg) {
   		if (arg != null) {
   			
   			//Itsasontziaren kolorea
   			if (arg instanceof Color) {
   				this.erakutsiItsasontziHautatua((Color)arg);
   				
   				//HasieraPantaila kendu
   			} else if (arg instanceof Boolean) {
   				Boolean b = (Boolean) arg;
   				boolean pantailaratu = b.booleanValue();
   				if (!pantailaratu) {
   					this.setVisible(pantailaratu);
   				}
   			}
   		}
   	}
}