package kudeaketaPackage;

import viewPackage.HasieraPantaila;
import viewPackage.Espazioa;
import controllerPackage.Controller;

public class PartidaKudeatzailea {

    private HasieraPantaila hasieraPantaila;
    private Espazioa espazioa;
    private Controller controller;

    public PartidaKudeatzailea() {
        // 1. CONTROLLERA EGIN
        // Controller barne EspazioModel sortzen da
        controller = Controller.getController();

        // 2. ESPAZIOA SORTU
        espazioa = Espazioa.getEspazioa();
        espazioa.konektatu();
        espazioa.setController(controller);
        controller.setEspazioa(espazioa);

        // 3. HASIERA PANTAILA
        hasieraPantaila = new HasieraPantaila();
        hasieraPantaila.setController(controller);
        controller.setHasieraPantaila(hasieraPantaila);
    }
}