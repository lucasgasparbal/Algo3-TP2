package vista;

import controller.HandlerColocarImagenCasillero;
import controller.HandlerMouseEntrandoANodo;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GeneradorDeTablero {

    int x = 0;
    int y = 0;
    int[] coordenadas = new int[2];

    public GridPane generarTablero (String url_escaque_64, ImageViewPiezaEnJuego ultimaPiezaSeleccionada) {
        x=0;
        y=0;
        GridPane nuevoTablero = new GridPane();
        while (x<20) {
            y = 0;
            while (y < 10) {
                StackPane casilleroNuevo = new StackPane();
                ImageViewFicha imagenDeCasillero = new ImageViewFicha(x, y, url_escaque_64);
                casilleroNuevo.getChildren().add(imagenDeCasillero);
                nuevoTablero.add(casilleroNuevo,x,y);
                int[] coordenadasCasillero = imagenDeCasillero.obtenerCoordenadas();
                y++;
                casilleroNuevo.setOnMouseEntered(new HandlerMouseEntrandoANodo(coordenadas, coordenadasCasillero[0], coordenadasCasillero[1]));
                casilleroNuevo.setOnMouseClicked(new HandlerColocarImagenCasillero(nuevoTablero,ultimaPiezaSeleccionada,coordenadas));
            }
            x++;
        }
        return nuevoTablero;
    }
}