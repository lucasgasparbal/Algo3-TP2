package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerComprarSoldado implements EventHandler<ActionEvent> {

    Juego juego;
    Label etiquetaOroRestante;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    HBox contenedorPiezas;

    public HandlerComprarSoldado(Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador, HBox contenedor) {
        this.juego = nuevoJuego;
        this.etiquetaOroRestante = label;
        this.generadorDeEtiquetas = generador;
        this.contenedorPiezas = contenedor;
    }

    @Override
    public void handle (ActionEvent event) {
        try {
            juego.comprarSoldado();
            generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaOroRestante,"ORO: "+juego.oroRestante(),30);
            contenedorPiezas.getChildren().remove(1);
            Label nuevaCantidad = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),Integer.toString(juego.cantidadSoldadosEnBanquilla()),30,"#00FF00");
            contenedorPiezas.getChildren().add(1,nuevaCantidad);
        } catch (NoAlcanzaOroExcepcion noAlcanzaOroExcepcion) {
            noAlcanzaOroExcepcion.printStackTrace();
        }
    }
}
