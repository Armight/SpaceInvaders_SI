package kudeaketaPackage;

import modelPackage.GelaxkaMatrizea;
import viewPackage.HasieraPantaila;
import viewPackage.AmaieraPantaila;
import controllerPackage.Controller;

public class PartidaKudeatzailea {

    private HasieraPantaila hasieraPantaila;
    private AmaieraPantaila amaieraPantaila;
    private Controller controller;
    private GelaxkaMatrizea matrizea;

    public PartidaKudeatzailea() {
        // 1. Inicializar la matriz
        matrizea = GelaxkaMatrizea.getGelaxkaMatrizea();
        matrizea.matrizeaBete();

        // 2. Crear el controller
        controller = Controller.getController();

        // 3. Crear y conectar la pantalla de inicio
        hasieraPantaila = new HasieraPantaila();
        hasieraPantaila.setController(controller);
        controller.setHasieraPantaila(hasieraPantaila);
    }

    public void amaieraErakutsi(String mezua) {
        // Cuando el juego termina, mostrar pantalla de fin
        if (hasieraPantaila != null) {
            hasieraPantaila.dispose();
        }
        amaieraPantaila = new AmaieraPantaila();
        amaieraPantaila.setVisible(true);
    }
}