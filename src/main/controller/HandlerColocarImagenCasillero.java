package controller;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import vista.ImageViewPiezaEnJuego;

public class HandlerColocarImagenCasillero implements EventHandler<MouseEvent> {

    GridPane tablero;
    ImageViewPiezaEnJuego piezaSeleccionada;
    int[] coordenadas = new int[2];

    public HandlerColocarImagenCasillero(GridPane nuevoTablero,ImageViewPiezaEnJuego ultimaPiezaSeleccionada, int[] coordenadasAUsar) {
        this.tablero = nuevoTablero;
        this.piezaSeleccionada = ultimaPiezaSeleccionada;
        this.coordenadas = coordenadasAUsar;
    }

    @Override
    public void handle(MouseEvent event) {
        ImageView piezaACargar = new ImageView();
        piezaACargar.setImage(piezaSeleccionada.devolverUltimaImagen());
        tablero.add(piezaACargar,coordenadas[0],  coordenadas[1]);

    }

}