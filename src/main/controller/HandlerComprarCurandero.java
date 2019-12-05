package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerComprarCurandero implements EventHandler<ActionEvent> {

    Juego juego;
    Label etiquetaOroRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;

    public HandlerComprarCurandero(Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador) {
        this.juego = nuevoJuego;
        this.etiquetaOroRestante = label;
        this.generadorDeEtiquetas = generador;
    }

    @Override
    public void handle (ActionEvent event) {
        try {
            juego.comprarCurandero();
            generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,"ORO: "+juego.oroRestante(),30);
        } catch (NoAlcanzaOroExcepcion noAlcanzaOroExcepcion) {
            noAlcanzaOroExcepcion.printStackTrace();
        }
    }
}