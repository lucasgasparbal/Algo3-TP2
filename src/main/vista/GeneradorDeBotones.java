package vista;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class GeneradorDeBotones {

    String directorio_fuente;

    public GeneradorDeBotones (String fuente_a_usar) {
        this.directorio_fuente = fuente_a_usar;
    }

    public Button nuevoBoton (String texto) {

        Button botonNuevo = new Button();
        botonNuevo.setText (texto);
        botonNuevo.setFont(Font.loadFont(directorio_fuente,15));
        botonNuevo.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        return botonNuevo;
    }
}
