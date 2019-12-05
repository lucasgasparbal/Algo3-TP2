package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerCompraFichasNegras implements EventHandler<ActionEvent> {

    Juego juego;
    HBox stackOroRestante;
    Label etiquetaOroRestante;
    Button botonComenzarJuego;
    GeneradorDeEtiquetas generadorDeEtiquetas;

    public HandlerCompraFichasNegras (Juego nuevoJuego, HBox hbox, Label label, Button button, GeneradorDeEtiquetas generador) {
        this.juego = nuevoJuego;
        this.stackOroRestante = hbox;
        this.etiquetaOroRestante = label;
        this.botonComenzarJuego = button;
        this.generadorDeEtiquetas = generador;
    }

    @Override
    public void handle (ActionEvent event) {
        juego.nuevoTurno();
        stackOroRestante.getChildren().remove(2);
        stackOroRestante.getChildren().add(botonComenzarJuego);
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,"ORO: "+juego.oroRestante(),30);

    }
}
