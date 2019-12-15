package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class HandlerImagenDescripcion implements EventHandler<MouseEvent> {

    VBox contenedorDescripciones;
    Text descripcion;

    public HandlerImagenDescripcion (VBox contenedor, Text texto) {
        this.contenedorDescripciones = contenedor;
        this.descripcion = texto;
    }

    public void handle (MouseEvent event) {
        contenedorDescripciones.setAlignment(Pos.TOP_CENTER);
        contenedorDescripciones.getChildren().remove(0);
        contenedorDescripciones.getChildren().add(0,descripcion);
    }
}
