package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerComprarJinete implements EventHandler<ActionEvent> {

    Juego juego;
    Label etiquetaOroRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    HBox contenedorPiezas;

    public HandlerComprarJinete(Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador, HBox contenedor) {
        this.juego = nuevoJuego;
        this.etiquetaOroRestante = label;
        this.generadorDeEtiquetas = generador;
        this.contenedorPiezas = contenedor;
    }

    @Override
    public void handle (ActionEvent event) {
        try {
            juego.comprarJinete();
            generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,"ORO: "+juego.oroRestante(),30);
            contenedorPiezas.getChildren().remove(0);
            Label nuevaCantidad = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),Integer.toString(juego.cantidadJinetesEnBanquilla()),30,"#00FF00");
            contenedorPiezas.getChildren().add(0,nuevaCantidad);
        } catch (NoAlcanzaOroExcepcion noAlcanzaOroExcepcion) {
            noAlcanzaOroExcepcion.printStackTrace();
        }
    }
}