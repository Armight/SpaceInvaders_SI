package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import controllerPackage.Controller;

public class HasieraPantaila extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel tituloLabel;
    private JLabel instrukzioakLabel;
    private JLabel hautatutaLabel;
    private Controller controller;

    public HasieraPantaila() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Space Invaders");
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

        // Titulo
        tituloLabel = new JLabel("SPACE INVADERS");
        tituloLabel.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        tituloLabel.setForeground(Color.GREEN);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.insets = new Insets(10, 10, 10, 10);
        contentPane.add(tituloLabel, gbc1);

        // Instrucciones seleccion nave
        instrukzioakLabel = new JLabel("* Press <G> Green  <B> Blue  <R> Red to play *");
        instrukzioakLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        instrukzioakLabel.setForeground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.insets = new Insets(10, 10, 10, 10);
        contentPane.add(instrukzioakLabel, gbc2);

        // Nave seleccionada
        hautatutaLabel = new JLabel("Hautatu itsasontzia...");
        hautatutaLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        hautatutaLabel.setForeground(Color.ORANGE);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.insets = new Insets(10, 10, 10, 10);
        contentPane.add(hautatutaLabel, gbc3);

        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void erakutsiItsasontziHautatua(String mota) {
        hautatutaLabel.setText("Hautatua: " + mota + " itsasontzia");
        switch (mota) {
            case "Green": hautatutaLabel.setForeground(Color.GREEN); break;
            case "Blue":  hautatutaLabel.setForeground(Color.BLUE);  break;
            case "Red":   hautatutaLabel.setForeground(Color.RED);   break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (controller != null) {
            controller.hasieraPantailaKeyPressed(e);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}