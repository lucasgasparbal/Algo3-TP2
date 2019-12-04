package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import vista.GeneradorDeEtiquetas;

public class HandlerNombreUsuarioNegro implements EventHandler<ActionEvent> {

    VBox contenedorViejo;
    StackPane menuNombreJugador;
    Button botonEmpezar;
    GeneradorDeEtiquetas generadorDeEtiquetas;

    public HandlerNombreUsuarioNegro(StackPane stackPane, VBox vbox, Button button, GeneradorDeEtiquetas generadorEtiquetas) {
        this.menuNombreJugador = stackPane;
        this.contenedorViejo = vbox;
        this.botonEmpezar = button;
        this.generadorDeEtiquetas = generadorEtiquetas;
    }

    @Override
    public void handle (ActionEvent event) {

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre deseado");

        Label etiquetaJugadorNegro = generadorDeEtiquetas.generarEtiquetaNegrita("Ingresar nombre del jugador negro",18);

        HBox contenedorHorizontal = new HBox(botonEmpezar);

        VBox contenedorNuevo = new VBox(etiquetaJugadorNegro, texto, contenedorHorizontal);
        contenedorNuevo.setSpacing(10);
        contenedorNuevo.setPadding(new Insets(20));

        menuNombreJugador.getChildren().remove(contenedorViejo);
        menuNombreJugador.getChildren().add(contenedorNuevo);

    }
}
