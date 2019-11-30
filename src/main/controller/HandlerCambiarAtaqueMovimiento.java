package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HandlerCambiarAtaqueMovimiento implements EventHandler<MouseEvent> {

    HBox caja;
    BorderPane borderPane;

    public HandlerCambiarAtaqueMovimiento (HBox cajaUsada, BorderPane borderPaneUsado) {
        this.caja = cajaUsada;
        this.borderPane = borderPaneUsado;
    }

    @Override
    public void handle(MouseEvent event) {
        borderPane.setTop(caja);
    }
}
