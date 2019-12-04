package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class HandlerMouseEntrandoANodo implements EventHandler<MouseEvent> {

    int[] coordenadas = new int[2];
    int x2;
    int y2;

    public HandlerMouseEntrandoANodo (int[] coordenadasAReemplazar, int x1, int y1) {
        this.coordenadas = coordenadasAReemplazar;
        x2 = x1;
        y2 = y1;
    }

    @Override
    public void handle(MouseEvent event) {
        this.coordenadas[0] = x2;
        this.coordenadas[1] = y2;
    }
}
