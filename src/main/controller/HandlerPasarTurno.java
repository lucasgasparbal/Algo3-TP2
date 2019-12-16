package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerPasarTurno implements EventHandler<ActionEvent> {

    Juego juego;
    HBox cajaMovimiento,cajaAtaque;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    String directorio_resources;

    public HandlerPasarTurno(Juego nuevoJuego, HBox movimiento, HBox ataque, GeneradorDeEtiquetas generador) {
        this.juego = nuevoJuego;
        this.cajaMovimiento = movimiento;
        this.cajaAtaque = ataque;
        this.generadorDeEtiquetas = generador;
    }

    @Override
    public void handle (ActionEvent event) {
        juego.nuevoTurno(true);
        Label etiquetaJugadorActual = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaJugadorActual,"Turno de "+juego.obtenerNombreJugadorEnTurno(),30);
        if (juego.estaEnModoMovimiento()) {
            if (cajaMovimiento.getChildren().size() ==3) {cajaMovimiento.getChildren().remove(0);}
            cajaMovimiento.getChildren().add(0, etiquetaJugadorActual);
            return;
        }
        if (cajaAtaque.getChildren().size() ==3) { cajaAtaque.getChildren().remove(0);}
        cajaAtaque.getChildren().add(0, etiquetaJugadorActual);
    }
}
