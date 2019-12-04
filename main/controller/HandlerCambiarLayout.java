package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class HandlerCambiarLayout implements EventHandler<ActionEvent> {

    StackPane nuevoLayout;
    Scene escena;

    public HandlerCambiarLayout(StackPane layoutAUsar, Scene escenaAUsar ) {
        this.nuevoLayout = layoutAUsar;
        this.escena = escenaAUsar;
    }

    @Override
    public void handle(ActionEvent event) {
        escena.setRoot(nuevoLayout);
    }
}
