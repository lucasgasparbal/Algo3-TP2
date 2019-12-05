package controller;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import vista.UltimaFichaSeleccionada;

public class HandlerSeleccionarPieza implements EventHandler<MouseEvent> {

    StackPane casilleroSeleccionado;
    ImageView marco;
    UltimaFichaSeleccionada ultimaFichaSeleccionada;
    Group placeholder = new Group();

    public HandlerSeleccionarPieza (StackPane casillero, ImageView marcoRojo, UltimaFichaSeleccionada ultimaFicha) {
        this.casilleroSeleccionado = casillero;
        this.marco = marcoRojo;
        this.ultimaFichaSeleccionada = ultimaFicha;
    }

    public void handle (MouseEvent event) {
        System.out.print(casilleroSeleccionado.getChildren().size());
        if (ultimaFichaSeleccionada.hayFichaSeleccionada()) {
            placeholder.getChildren().add(marco);
            casilleroSeleccionado.getChildren().add(ultimaFichaSeleccionada.obtenerImagenFicha());
            ultimaFichaSeleccionada.limpiarSeleccionFicha();
            return;
        }
        casilleroSeleccionado.getChildren().add(marco);
        if (casilleroSeleccionado.getChildren().size() >1) {
            ultimaFichaSeleccionada.seleccionarFicha((ImageView)casilleroSeleccionado.getChildren().get(1));
        }
    }
}
