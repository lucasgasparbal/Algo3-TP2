package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
    HBox piezasRestantes;

    public HandlerCompraFichasNegras (Juego nuevoJuego, HBox hbox, Label label, Button button, GeneradorDeEtiquetas generador, HBox contenedor) {
        this.juego = nuevoJuego;
        this.stackOroRestante = hbox;
        this.etiquetaOroRestante = label;
        this.botonComenzarJuego = button;
        this.generadorDeEtiquetas = generador;
        this.piezasRestantes = contenedor;
    }

    @Override
    public void handle (ActionEvent event) {
        juego.nuevoTurno(true);
        stackOroRestante.getChildren().remove(3);
        stackOroRestante.getChildren().add(botonComenzarJuego);
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,juego.obtenerNombreJugadorEnTurno() +" - ORO: "+juego.oroRestante(),30);
        piezasRestantes.getChildren().clear();
        Label soldadosComprados = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label jinetesComprados = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label curanderosComprados = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label catapultasCompradas = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        piezasRestantes.getChildren().addAll(jinetesComprados,soldadosComprados,catapultasCompradas,curanderosComprados);

    }
}
