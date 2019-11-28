package vista;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GeneradorDeEtiquetas {

    private String fuente;

    public GeneradorDeEtiquetas (String fuenteLetra) {
        this.fuente = fuenteLetra;
    }

    public Label generarEtiquetaNegrita (String texto, int tamLetra) {
        Label etiqueta = new Label();
        etiqueta.setText(texto);
        etiqueta.setFont (Font.font (fuente,tamLetra));
        etiqueta.setStyle ("-fx-font-weight: bold");
        return etiqueta;
    }
}
