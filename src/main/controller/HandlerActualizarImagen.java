package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import vista.ImageViewPiezaEnJuego;

public class HandlerActualizarImagen implements EventHandler<MouseEvent> {

    ImageViewPiezaEnJuego piezaEnJuego;
    String directorio;

    public HandlerActualizarImagen(ImageViewPiezaEnJuego imageview, String url) {
        this.piezaEnJuego = imageview;
        this.directorio = url;
    }

    public void handle (MouseEvent event) {
        Image imagenEnCasillero = new Image(directorio);
        piezaEnJuego.actualizarImagen(imagenEnCasillero);
    }
}
