package viewPackage;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class AmaieraPantaila extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel mezuaLabel;
    private JLabel instrukzioakLabel;

    public AmaieraPantaila(String mezua) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Space Invaders");
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        contentPane = new JPanel() {
            private Image bgImage = new ImageIcon(getClass().getResource("/resources/fondoaAmaPant.jpg")).getImage();
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

        mezuaLabel = new JLabel(mezua);
        mezuaLabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        mezuaLabel.setForeground(mezua.equals("IRABAZI DUZU!") ? Color.GREEN : Color.RED);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.insets = new Insets(10, 10, 10, 10);
        contentPane.add(mezuaLabel, gbc1);

        instrukzioakLabel = new JLabel("* Press <ESC> to exit *");
        instrukzioakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        instrukzioakLabel.setForeground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.insets = new Insets(10, 10, 10, 10);
        contentPane.add(instrukzioakLabel, gbc2);

        setFocusable(true);
        setVisible(true);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
 
    
}