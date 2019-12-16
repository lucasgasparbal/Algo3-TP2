package controller;

import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerComprarCatapulta implements EventHandler<ActionEvent> {

    Juego juego;
    Label etiquetaOroRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    HBox contenedorPiezas;
    SequentialTransition mensaje;
    Label oroLabel;
    String directorioResources;

    public HandlerComprarCatapulta(Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador, HBox contenedor, Label oroError, SequentialTransition mensajeDeError, String directorio_resources) {
        this.juego = nuevoJuego;
        this.etiquetaOroRestante = label;
        this.generadorDeEtiquetas = generador;
        this.contenedorPiezas = contenedor;
        this.juego = nuevoJuego;
        this.mensaje = mensajeDeError;
        this.oroLabel = oroError;
        this.oroLabel = oroError;
        this.directorioResources = directorio_resources;
    }

    @Override
    public void handle (ActionEvent event) {
        try {
            juego.comprarCatapulta();
            generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,juego.obtenerNombreJugadorEnTurno() +" - ORO: "+juego.oroRestante(),30);
            contenedorPiezas.getChildren().remove(2);
            Label nuevaCantidad = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),Integer.toString(juego.cantidadCatapultasEnBanquilla()),30,"#00FF00");
            contenedorPiezas.getChildren().add(2,nuevaCantidad);
            AudioClip audioCompra = new AudioClip(directorioResources+"sonidos/compraCatapulta.wav");
            audioCompra.play();
        } catch (NoAlcanzaOroExcepcion noAlcanzaOroExcepcion) {
            oroLabel.setVisible(true);
            AudioClip audioError = new AudioClip(directorioResources+"sonidos/error.wav");
            audioError.play();
            mensaje.play();
        }
    }
}