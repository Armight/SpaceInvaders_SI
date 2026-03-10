package viewPackage;
import java.awt.EventQueue;
import modelPackage.EspazioModel;
import controllerPackage.Controller;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Espazioa extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	private static Espazioa nEspazioa;
	private Controller controller;
	private GelaxkaView[][] pixelak = new GelaxkaView[60][100];
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Espazioa frame = Espazioa.getEspazioa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Espazioa() {
		addKeyListener(this);
		setFocusable(true);
		getContentPane().setBackground(Color.BLACK);
		
		// QUITAR los bordes y decoraciones de la ventana
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana
		
		// Ahora sí, 100x60 píxeles exactos sin bordes
		setBounds(100, 100, 100, 60);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// GridLayout sin espacios entre celdas
		getContentPane().setLayout(new GridLayout(60, 100, 0, 0));
		
		// Crear 6000 labels (60 filas * 100 columnas)
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				//JLabel lblNewLabel = new JLabel("");
				//lblNewLabel.setOpaque(true);       
				//lblNewLabel.setBackground(Color.WHITE);
				//getContentPane().add(lblNewLabel);
				GelaxkaView gelaxka = new GelaxkaView();
				this.pixelak[i][j] = gelaxka;
				getContentPane().add(gelaxka.getLabel());
			}
		}
	}
	public void konektatu() {
	    EspazioModel matrizea = EspazioModel.getGelaxkaMatrizea();
	    for (int i = 0; i < matrizea.getAltuera(); i++) {
	        for (int j = 0; j < matrizea.getZabalera(); j++) {
	            matrizea.getGelaxka(j, i).addObserver(this.pixelak[i][j]);
	        }
	    }
	}
	
	public void setController(Controller controller) {
	    this.controller = controller;
	}
	public static Espazioa getEspazioa() {  
		if (nEspazioa == null) {            
			nEspazioa = new Espazioa();     
		}                                   
		return nEspazioa;                   
	} 
	
	@Override
    public void keyPressed(KeyEvent e) {
        if (controller != null) {
            controller.keyPressed(e);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}