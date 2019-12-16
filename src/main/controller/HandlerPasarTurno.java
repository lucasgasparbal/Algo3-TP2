package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;
import vista.ImageViewPiezaEnJuego;
import vista.UltimaFichaSeleccionada;

public class HandlerPasarTurno implements EventHandler<ActionEvent> {

    Juego juego;
    HBox cajaMovimiento,cajaAtaque;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    String directorio_resources;
    UltimaFichaSeleccionada piezaSeleccionada;


    public HandlerPasarTurno(Juego nuevoJuego, HBox movimiento, HBox ataque, GeneradorDeEtiquetas generador, UltimaFichaSeleccionada ultimaPiezaSeleccionada) {
        this.juego = nuevoJuego;
        this.cajaMovimiento = movimiento;
        this.cajaAtaque = ataque;
        this.generadorDeEtiquetas = generador;
        this.piezaSeleccionada = ultimaPiezaSeleccionada;
    }

    @Override
    public void handle (ActionEvent event) {
        juego.nuevoTurno(true);
        Label etiquetaJugadorActual = new Label();
        piezaSeleccionada.limpiarSeleccionFicha();
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
