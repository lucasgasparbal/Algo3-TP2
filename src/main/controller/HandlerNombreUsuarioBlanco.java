package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;

public class HandlerNombreUsuarioBlanco implements EventHandler<ActionEvent> {

    StackPane nuevoLayout;
    Scene escena;
    Juego juego;
    TextField campoNombreNegro,campoNombreBlanco;
    Label etiquetaPiezasBlancas,etiquetaPiezasNegras,etiquetaOroRestante;
    String directorio_resources;
    GeneradorDeEtiquetas generadorDeEtiquetas;

    public HandlerNombreUsuarioBlanco(StackPane layoutAUsar, Scene escenaAUsar, TextField campoNegro, TextField campoBlanco, Label etiquetaBlanca, Label etiquetaNegra, String directorio, Juego nuevoJuego, Label label, GeneradorDeEtiquetas generador) {
        this.nuevoLayout = layoutAUsar;
        this.escena = escenaAUsar;
        this.campoNombreNegro=campoNegro;
        this.campoNombreBlanco=campoBlanco;
        this.etiquetaPiezasBlancas=etiquetaBlanca;
        this.etiquetaPiezasNegras=etiquetaNegra;
        this.directorio_resources = directorio;
        this.juego = nuevoJuego;
        this.etiquetaOroRestante = label;
        this.generadorDeEtiquetas=generador;
    }

    @Override
    public void handle(ActionEvent event) {
        while (this.campoNombreNegro.getText().trim().equals("")) {
            return;
        }
        etiquetaPiezasBlancas.setText(campoNombreBlanco.getText()+", por favor distribuya sus piezas");
        etiquetaPiezasNegras.setText(campoNombreNegro.getText()+", por favor distribuya sus piezas");
        juego.nombrarUsuarioBlanco(campoNombreBlanco.getText());
        juego.nombrarUsuarioNegro(campoNombreNegro.getText());
        etiquetaPiezasNegras.setFont((Font.loadFont(directorio_resources+"fonts/Adventurer.ttf",30)));
        etiquetaPiezasBlancas.setFont((Font.loadFont(directorio_resources+"fonts/Adventurer.ttf",30)));
        etiquetaPiezasNegras.setStyle("-fx-font-weight: bold");
        etiquetaPiezasBlancas.setStyle ("-fx-font-weight: bold");
        generadorDeEtiquetas.generarEtiquetaNegrita2(etiquetaOroRestante,juego.obtenerNombreJugadorEnTurno()+" - ORO: "+juego.oroRestante(),30,"#ffd700");
        escena.setRoot(nuevoLayout);
    }
}