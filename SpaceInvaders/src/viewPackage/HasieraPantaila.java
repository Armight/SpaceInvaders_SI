package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import modelPackage.PartidaKudeatzailea;

public class HasieraPantaila extends JFrame implements Observer{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel tituloLabel;
    private JLabel instrukzioak1Label;
    private JLabel instrukzioak2Label;
    private JLabel hautatutaLabel;
    private JLabel zailtasunLabel;

    public HasieraPantaila() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Space Invaders");
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 620, 420);
        setResizable(false);

        contentPane = new JPanel() {
            private Image bgImage = new ImageIcon(getClass().getResource("/resources/tetelestai.png")).getImage();
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
        gbc1.gridy = 1;
        gbc1.insets = new Insets(10, 10, 10, 10);
        contentPane.add(tituloLabel, gbc1);

        //Ontziaren aukeraketa instrukzioak
        instrukzioak1Label = new JLabel("* Press <G> Green  <B> Blue  <R> Red to choose spaceship *");
        instrukzioak1Label.setFont(new Font("Arial", Font.PLAIN, 16));
        instrukzioak1Label.setForeground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(10, 10, 10, 10);
        contentPane.add(instrukzioak1Label, gbc2);

        //Ontzi aukeratua
        hautatutaLabel = new JLabel("Hautatu espaziontzia...");
        hautatutaLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        hautatutaLabel.setForeground(Color.ORANGE);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.insets = new Insets(10, 10, 10, 10);
        contentPane.add(hautatutaLabel, gbc3);
        
        //Zailtasun aukeraketa instrukzioak
        instrukzioak2Label = new JLabel("* Press <C> CHILL  <E> EZINEZKOA to choose difficulty level *");
        instrukzioak2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        instrukzioak2Label.setForeground(Color.WHITE);
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;
        gbc4.insets = new Insets(10, 10, 10, 10);
        contentPane.add(instrukzioak2Label, gbc4);
        
        //Zailtasun maila aukeratu
        zailtasunLabel = new JLabel("Zailtasun maila aukeratu...");
        zailtasunLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        zailtasunLabel.setForeground(Color.ORANGE);
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 4;
        gbc5.insets = new Insets(10, 10, 10, 10);
        contentPane.add(zailtasunLabel, gbc5);
        
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
    
    private void erakutsiItsasontziHautatua(String pKolorea) {
    	String espaziontzi = "ANTONIO";
    	hautatutaLabel.setText("Hautatua: " + pKolorea);
        switch (pKolorea) {
            case "GREEN": hautatutaLabel.setForeground(Color.GREEN); break;
            case "BLUE":  hautatutaLabel.setForeground(Color.BLUE);  break;
            case "RED":   hautatutaLabel.setForeground(Color.RED); espaziontzi = "PACO";  break;
        }
    	hautatutaLabel.setText("Hautatua: " + espaziontzi);
    }
    
    private void erakutsiMailaHautatua(String pMaila) {
    	zailtasunLabel.setText("Hautatua: " + pMaila + " - Press <ENTER> to play!");
    	switch (pMaila) {
    	case "CHILL": zailtasunLabel.setForeground(new Color(0, 255, 255)); break;
    	case "EZINEZKOA": zailtasunLabel.setForeground(new Color(255, 0, 144)); break;
    	}
    }
    
    @Override
   	public void update(Observable o, Object arg) {
   		if (arg != null) {
   			
   			//Itsasontziaren kolorea
   			if (arg instanceof String) {
   				if(arg.equals("GREEN") || arg.equals("RED") || arg.equals("BLUE")) {
   					this.erakutsiItsasontziHautatua((String)arg);
   				} else if (arg.equals("AISE") || arg.equals("EZINEZKOA")) {
   					this.erakutsiMailaHautatua((String)arg);
   				}
   				String agindu = arg.toString();
   				if (agindu.equals("HasieraPantaila itzali")) {
   					this.dispose();
   					new EspazioaView();
   				}
   				
   				
   			//HasieraPantaila kendu
   			} 
   				
   				
   			
   		}
   	}
}
