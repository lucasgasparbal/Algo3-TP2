package controller;

import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.StackPane;
import model.AlgoChess.Juego;
import vista.OrganizadorDeBatallones;

public class HandlerBatallon implements EventHandler<ContextMenuEvent> {

    Juego juego;
    StackPane casilleroSeleccionado;
    int[]coordenadas;
    OrganizadorDeBatallones organizadorDeBatallones;

    public HandlerBatallon (Juego nuevoJuego, StackPane casillero, int[]coordenadasCasillero, OrganizadorDeBatallones organizador) {
        this.juego = nuevoJuego;
        this.casilleroSeleccionado = casillero;
        this.coordenadas=coordenadasCasillero;
        this.organizadorDeBatallones = organizador;
    }

    @Override
    public void handle (ContextMenuEvent event) {
        if (casilleroSeleccionado.getChildren().size() <3) {
            return;
        }
        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("Mover para arriba");
        item1.setOnAction(new HandlerBatallonMoverParaArriba(juego,coordenadas,organizadorDeBatallones));
        MenuItem item2 = new MenuItem("Mover para abajo");
        item2.setOnAction(new HandlerBatallonMoverParaAbajo(juego,coordenadas,organizadorDeBatallones));
        MenuItem item3 = new MenuItem("Mover para izquierda");
        item3.setOnAction(new HandlerBatallonMoverParaIzquierda(juego,coordenadas,organizadorDeBatallones));
        MenuItem item4 = new MenuItem("Mover para derecha");
        item4.setOnAction(new HandlerBatallonMoverParaDerecha(juego,coordenadas,organizadorDeBatallones));
        contextMenu.getItems().addAll(item1,item2,item3,item4);
        contextMenu.show(casilleroSeleccionado, event.getScreenX(), event.getScreenY());
    }
}
