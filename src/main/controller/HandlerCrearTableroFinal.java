package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import vista.UltimaFichaSeleccionada;

public class HandlerCrearTableroFinal implements EventHandler<ActionEvent> {

    GridPane tablero1;
    GridPane tablero2;
    Scene escena;
    BorderPane campoJuegoFinal;

    public HandlerCrearTableroFinal (Scene escenaAUsar, GridPane tableroBlanco, GridPane tableroNegro, BorderPane menuFinal) {
        this.tablero1 = tableroBlanco;
        this.tablero2 = tableroNegro;
        this.escena = escenaAUsar;
        this.campoJuegoFinal = menuFinal;
    }

    @Override
    public void handle(ActionEvent event) {
        ImageView fondo_tablero = new ImageView ("file:/home/facundo/IdeaProjects/TP2/src/resources/fondo_tablero.png");
        VBox tableroFinal = new VBox(tablero1,tablero2);
        Group tableroFinalGrupo = new Group (tableroFinal);
        campoJuegoFinal.setCenter(tableroFinalGrupo);
        StackPane stackPane = new StackPane(fondo_tablero,campoJuegoFinal);
        UltimaFichaSeleccionada ultimaFichaSeleccionada = new UltimaFichaSeleccionada();
        ImageView marcoRojo = new ImageView ("file:/home/facundo/IdeaProjects/TP2/src/resources/marcoRojo.png");
        int x = 0;
        while (x<20) {
            int y = 0;
            while (y < 10) {
                StackPane casilleroSeleccionado1 = (StackPane)(tablero1.getChildren().get(x*10+y));
                casilleroSeleccionado1.setOnMouseClicked(new HandlerSeleccionarPieza(casilleroSeleccionado1,marcoRojo,ultimaFichaSeleccionada));
                StackPane casilleroSeleccionado2 = (StackPane)(tablero2.getChildren().get(x*10+y));
                casilleroSeleccionado2.setOnMouseClicked(new HandlerSeleccionarPieza(casilleroSeleccionado2,marcoRojo,ultimaFichaSeleccionada));
                y++;
            }
            x++;
        }
        escena.setRoot(stackPane);

    }
}
