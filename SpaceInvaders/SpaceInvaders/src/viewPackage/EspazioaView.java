package viewPackage;
import modelPackage.EspazioModel;
import modelPackage.PartidaKudeatzailea;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.Color;
//Commit prueba2
public class EspazioaView extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	private GelaxkaView[][] pixelak = new GelaxkaView[60][100];
	
	public EspazioaView() {
		getContentPane().setBackground(Color.BLACK);
		
		//Leihoaren ertzak eta dekorazioak kendu
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); //Leihoa maximizatu
		
		//100x60 pixeleko dimentsioak ezarri
		setBounds(100, 100, 100, 60);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Gelaxken artean tarterik gabeko GridLayout
		getContentPane().setLayout(new GridLayout(60, 100, 0, 0));
		
		//6000 label sortu (60 zutabe x 100 ilara)
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				GelaxkaView gelaxka = new GelaxkaView();
				this.pixelak[i][j] = gelaxka;
				getContentPane().add(gelaxka.getLabel());
			}
		}
		
		//Observer gehitu
		PartidaKudeatzailea kudeatzailea = PartidaKudeatzailea.getPartidaKudeatzailea();
		kudeatzailea.addObserver(this);
		
		//Listener gehitu
		Controller controller = Controller.getController();
		this.addKeyListener(controller);
		
		setFocusable(true);
        this.setVisible(false);
	}
	
	private void konektatu() {
	    EspazioModel matrizea = EspazioModel.getGelaxkaMatrizea();
	    for (int i = 0; i < matrizea.getAltuera(); i++) {
	        for (int j = 0; j < matrizea.getZabalera(); j++) {
	            matrizea.getGelaxka(j, i).addObserver(this.pixelak[i][j]);
	        }
	    }
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg != null) {
			
			//EspazioView eta EspazioModel konektatu eta EspazioView ikusgarri egin
			if (arg instanceof String) {
				String agindu = arg.toString();
				if (agindu.equals("EspazioView erakutsi")) {
					this.konektatu();
			        this.requestFocusInWindow();
					this.setVisible(true);
				} else if (agindu.equals("EspazioView itzali")){
					this.dispose();
					new AmaieraPantaila();
				}
			}
		}
	}
}