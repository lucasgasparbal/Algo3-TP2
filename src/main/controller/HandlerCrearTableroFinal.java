package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class HandlerCrearTableroFinal implements EventHandler<ActionEvent> {

    GridPane tablero1;
    GridPane tablero2;
    Scene escena;

    public HandlerCrearTableroFinal (Scene escenaAUsar, GridPane tableroBlanco, GridPane tableroNegro) {
        this.tablero1 = tableroBlanco;
        this.tablero2 = tableroNegro;
        this.escena = escenaAUsar;
    }

    @Override
    public void handle(ActionEvent event) {
        ImageView fondo_tablero = new ImageView ("file:/home/facundo/IdeaProjects/TP2/src/resources/fondo_tablero.png");
        VBox tableroFinal = new VBox(tablero1,tablero2);
        BorderPane menuTableroFinal = new BorderPane();
        Group tableroFinalGrupo = new Group (tableroFinal);
        menuTableroFinal.setCenter(tableroFinalGrupo);
        StackPane stackPane = new StackPane(fondo_tablero,menuTableroFinal);
        escena.setRoot(stackPane);
    }
}
