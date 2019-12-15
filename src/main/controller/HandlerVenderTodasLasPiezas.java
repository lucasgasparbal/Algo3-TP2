package controller;

import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerVenderTodasLasPiezas implements EventHandler<ActionEvent> {

    Juego juego;
    Label etiquetaOroRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    HBox contenedorPiezas;

    public HandlerVenderTodasLasPiezas (Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador, HBox contenedor) {
        this.juego = nuevoJuego;
        etiquetaOroRestante = label;
        generadorDeEtiquetas = generador;
        contenedorPiezas = contenedor;
    }

    public void handle (ActionEvent event) {
        juego.venderTodasUnidades();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,juego.obtenerNombreJugadorEnTurno() +" - ORO: "+juego.oroRestante(),30);
        contenedorPiezas.getChildren().clear();
        Label nuevaCantidad1 = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label nuevaCantidad2 = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label nuevaCantidad3 = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label nuevaCantidad4 = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        contenedorPiezas.getChildren().addAll(nuevaCantidad1,nuevaCantidad2,nuevaCantidad3,nuevaCantidad4);
    }
}
