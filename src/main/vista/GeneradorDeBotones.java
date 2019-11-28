package vista;

import javafx.scene.control.Button;

public class GeneradorDeBotones {

    public Button nuevoBoton (String texto) {
        Button botonNuevo = new Button();
        botonNuevo.setText (texto);
        botonNuevo.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        return botonNuevo;
    }
}
