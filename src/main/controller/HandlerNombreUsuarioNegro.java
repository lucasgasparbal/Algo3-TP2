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
    TextField campoNombreBlanco,campoNombreNegro;

    public HandlerNombreUsuarioNegro(StackPane stackPane, VBox vbox, Button button, GeneradorDeEtiquetas generadorEtiquetas,TextField campoTextoBlanco, TextField campoTextoNegro) {
        this.menuNombreJugador = stackPane;
        this.contenedorViejo = vbox;
        this.botonEmpezar = button;
        this.generadorDeEtiquetas = generadorEtiquetas;
        this.campoNombreBlanco = campoTextoBlanco;
        this.campoNombreNegro = campoTextoNegro;
    }

    @Override
    public void handle (ActionEvent event) {

        while (this.campoNombreBlanco.getText().trim().equals("")) {
            return;
        }
        Label etiquetaJugadorNegro = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaJugadorNegro,"Ingresar nombre del jugador negro",18);

        HBox contenedorHorizontal = new HBox(botonEmpezar);

        VBox contenedorNuevo = new VBox(etiquetaJugadorNegro, campoNombreNegro, contenedorHorizontal);
        contenedorNuevo.setSpacing(10);
        contenedorNuevo.setPadding(new Insets(20));

        menuNombreJugador.getChildren().remove(contenedorViejo);
        menuNombreJugador.getChildren().add(contenedorNuevo);
    }
}
