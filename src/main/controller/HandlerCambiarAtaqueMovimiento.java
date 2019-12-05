package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerCambiarAtaqueMovimiento implements EventHandler<MouseEvent> {

    HBox caja;
    BorderPane borderPane;
    Juego juego;
    GeneradorDeEtiquetas generadorDeEtiquetas;


    public HandlerCambiarAtaqueMovimiento (HBox cajaUsada, BorderPane borderPaneUsado, Juego nuevoJuego, GeneradorDeEtiquetas generador) {
        this.caja = cajaUsada;
        this.borderPane = borderPaneUsado;
        this.juego = nuevoJuego;
        this.generadorDeEtiquetas = generador;
    }

    @Override
    public void handle(MouseEvent event) {
        Label etiquetaJugadorActual = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaJugadorActual,"Turno de " +juego.obtenerNombreJugadorEnTurno(),30);
        if (caja.getChildren().size() ==3) { caja.getChildren().remove(0);}
        caja.getChildren().add(0,etiquetaJugadorActual);
        juego.cambiarModo();
        borderPane.setTop(caja);
    }
}
