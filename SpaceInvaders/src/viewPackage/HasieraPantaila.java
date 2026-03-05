package viewPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HasieraPantaila extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel tituloLabel;
    private JLabel instrukzioakLabel;
    private JLabel hautatutaLabel;
    private String hautatutakoItasontzia = "";

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
        tituloLabel.setForeground(Color.PINK);
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

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_G:
                hautatutakoItasontzia = "Green";
                hautatutaLabel.setText("Hautatua: Green itsasontzia");
                hautatutaLabel.setForeground(Color.GREEN);
                jokoanHasi();
                break;
            case KeyEvent.VK_B:
                hautatutakoItasontzia = "Blue";
                hautatutaLabel.setText("Hautatua: Blue itsasontzia");
                hautatutaLabel.setForeground(Color.BLUE);
                jokoanHasi();
                break;
            case KeyEvent.VK_R:
                hautatutakoItasontzia = "Red";
                hautatutaLabel.setText("Hautatua: Red itsasontzia");
                hautatutaLabel.setForeground(Color.RED);
                jokoanHasi();
                break;
        }
    }

    private void jokoanHasi() {
        // Sprint 2an osatu - Espazioa pantaila ireki
        System.out.println("Jokoa hasten da: " + hautatutakoItasontzia);
        // new Espazioa(hautatutakoItasontzia);
        // this.dispose();
    }

    public String getHautatutakoItasontzia() {
        return hautatutakoItasontzia;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new HasieraPantaila());
    }
}