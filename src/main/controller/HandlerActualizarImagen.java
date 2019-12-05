package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import vista.GeneradorDeEtiquetas;
import vista.ImageViewPiezaEnJuego;

public class HandlerActualizarImagen implements EventHandler<MouseEvent> {

    ImageViewPiezaEnJuego piezaEnJuego;
    String directorio;
    HBox cantidadRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    int cantidadFichasRestantes;

    public HandlerActualizarImagen(HBox cantidadRestanteFicha, ImageViewPiezaEnJuego imageview, String url, GeneradorDeEtiquetas generadorEtiquetas, int cantidadFichas) {
        this.piezaEnJuego = imageview;
        this.directorio = url;
        this.cantidadRestante = cantidadRestanteFicha;
        this.generadorDeEtiquetas = generadorEtiquetas;
        this.cantidadFichasRestantes = cantidadFichas;
    }

    public void handle (MouseEvent event) {
        Image imagenEnCasillero = new Image(directorio);
        cantidadFichasRestantes--;
        if (cantidadFichasRestantes <0) {
            return;
        }
        Label etiquetaRestantes = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaRestantes,"x"+Integer.toString(cantidadFichasRestantes),40);
        if (cantidadFichasRestantes==0) {
            etiquetaRestantes.setTextFill(Color.web("#FF0000"));
        }
        cantidadRestante.getChildren().remove(1);
        cantidadRestante.getChildren().add(etiquetaRestantes);
        piezaEnJuego.actualizarImagen(imagenEnCasillero);
    }
}
