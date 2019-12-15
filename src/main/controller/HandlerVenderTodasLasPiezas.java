package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.AlgoChess.Juego;

public class HandlerVenderTodasLasPiezas implements EventHandler<ActionEvent> {

    Juego juego;

    public HandlerVenderTodasLasPiezas (Juego nuevoJuego){
        this.juego = nuevoJuego;
    }

    public void handle (ActionEvent event) {
    }
}
