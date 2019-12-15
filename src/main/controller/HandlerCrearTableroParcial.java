package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import model.AlgoChess.Juego;
import vista.GeneradorCajaFichasRestantes;

public class HandlerCrearTableroParcial implements EventHandler<ActionEvent> {

    StackPane nuevoLayout;
    Scene escena;
    Juego juego;
    BorderPane menuJugador;
    GeneradorCajaFichasRestantes generadorCajaFichasRestantes;

    public HandlerCrearTableroParcial(StackPane layoutAUsar, Scene escenaAUsar , Juego nuevoJuego, BorderPane menu, GeneradorCajaFichasRestantes generador) {
        this.nuevoLayout = layoutAUsar;
        this.escena = escenaAUsar;
        this.juego = nuevoJuego;
        this.menuJugador = menu;
        this.generadorCajaFichasRestantes = generador;
    }

    @Override
    public void handle(ActionEvent event) {
        juego.nuevoTurno(true);
        int[] cantidadFichas = new int[4];
        cantidadFichas[0] = juego.cantidadSoldadosEnBanquilla();
        cantidadFichas[1] = juego.cantidadJinetesEnBanquilla();
        cantidadFichas[2] = juego.cantidadCuranderosEnBanquilla();
        cantidadFichas[3] = juego.cantidadCatapultasEnBanquilla();
        StackPane cajaFichas = generadorCajaFichasRestantes.generarCajaFichasRestantes(cantidadFichas);
        menuJugador.setBottom(cajaFichas);
        escena.setRoot(nuevoLayout);
    }
}
