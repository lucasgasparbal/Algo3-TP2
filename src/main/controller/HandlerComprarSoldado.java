package controller;

import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;
import vista.MensajeDeError;

public class HandlerComprarSoldado implements EventHandler<ActionEvent> {

    Juego juego;
    Label etiquetaOroRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    HBox contenedorPiezas;
    SequentialTransition mensaje;
    Label oroLabel;
    String directorioResources;

    public HandlerComprarSoldado(Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador, HBox contenedor, Label oroError,SequentialTransition mensajeDeError, String directorio_resources) {
        this.juego = nuevoJuego;
        this.etiquetaOroRestante = label;
        this.generadorDeEtiquetas = generador;
        this.contenedorPiezas = contenedor;
        this.mensaje = mensajeDeError;
        this.oroLabel = oroError;
        this.directorioResources = directorio_resources;
    }

    @Override
    public void handle (ActionEvent event) {
        try {
            juego.comprarSoldado();
            generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,juego.obtenerNombreJugadorEnTurno() +" - ORO: "+juego.oroRestante(),30);
            contenedorPiezas.getChildren().remove(1);
            Label nuevaCantidad = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),Integer.toString(juego.cantidadSoldadosEnBanquilla()),30,"#00FF00");
            contenedorPiezas.getChildren().add(1,nuevaCantidad);
            AudioClip audioCompra = new AudioClip(directorioResources+"sonidos/compraSoldado.wav");
            audioCompra.play();
        } catch (NoAlcanzaOroExcepcion noAlcanzaOroExcepcion) {
            oroLabel.setVisible(true);
            AudioClip audioError = new AudioClip(directorioResources+"sonidos/error.wav");
            audioError.play();
            mensaje.play();
        }
    }
}
