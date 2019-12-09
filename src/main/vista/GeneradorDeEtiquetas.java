package vista;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GeneradorDeEtiquetas {

    private String directorio;

    public GeneradorDeEtiquetas (String directorioResources) {
        this.directorio = directorioResources;
    }

    public Label generarEtiquetaNegrita (Label etiqueta, String texto, int tamLetra) {
        etiqueta.setText(texto);
        etiqueta.setFont((Font.loadFont(directorio,tamLetra)));
        etiqueta.setStyle ("-fx-font-weight: bold");
        return etiqueta;
    }

    public Label generarEtiquetaNegrita2 (Label etiqueta, String texto, int tamLetra,String color) {
        etiqueta.setText(texto);
        etiqueta.setFont((Font.loadFont(directorio,tamLetra)));
        etiqueta.setStyle ("-fx-font-weight: bold");
        etiqueta.setTextFill(Color.web(color));
        return etiqueta;
    }
}

