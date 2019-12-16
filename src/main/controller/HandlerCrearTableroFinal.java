package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;
import vista.LanzadorExcepciones;
import vista.OrganizadorDeBatallones;
import vista.UltimaFichaSeleccionada;
import javafx.scene.paint.Color;

public class HandlerCrearTableroFinal implements EventHandler<ActionEvent> {

    GridPane tablero1;
    GridPane tablero2;
    Scene escena;
    BorderPane campoJuegoFinal;
    Label vida;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    Juego juego;
    HBox cajaAtaque,cajaMovimiento;
    String directorio_resources;
    UltimaFichaSeleccionada ultimaFichaSeleccionada;

    public HandlerCrearTableroFinal (Scene escenaAUsar, GridPane tableroBlanco, GridPane tableroNegro, BorderPane menuFinal, Label label, GeneradorDeEtiquetas generador, Juego nuevoJuego, HBox ataque, HBox mov, String directorio, UltimaFichaSeleccionada ultimaFicha) {
        this.tablero1 = tableroBlanco;
        this.tablero2 = tableroNegro;
        this.escena = escenaAUsar;
        this.campoJuegoFinal = menuFinal;
        this.vida = label;
        this.generadorDeEtiquetas = generador;
        this.juego = nuevoJuego;
        this.cajaAtaque = ataque;
        this.cajaMovimiento = mov;
        this.directorio_resources = directorio;
        this.ultimaFichaSeleccionada = ultimaFicha;
    }

    @Override
    public void handle(ActionEvent event) {
        juego.decidirOrdenTurnos();
        AudioClip audioComienzo = new AudioClip(directorio_resources+"sonidos/comienzo.wav");
        audioComienzo.play();
        ImageView fondo_tablero = new ImageView (directorio_resources+"fondo_tablero.png");
        VBox tableroFinal = new VBox(tablero1,tablero2);
        Label etiquetaErrores = generadorDeEtiquetas.generarEtiquetaNegrita(new Label(),"PLACEHOLDER",30);
        etiquetaErrores.setTextFill(Color.TRANSPARENT);
        ImageView fondoVictoria = new ImageView (directorio_resources+"fondoVictoria.png");
        StackPane pantallaVictoria = new StackPane (fondoVictoria);
        Group contenedorErrores = new Group (etiquetaErrores);
        LanzadorExcepciones lanzadorExcepciones = new LanzadorExcepciones(generadorDeEtiquetas,directorio_resources+"sonidos/error.wav");
        campoJuegoFinal.setBottom(contenedorErrores);
        campoJuegoFinal.setAlignment(contenedorErrores, Pos. CENTER);
        Group tableroFinalGrupo = new Group (tableroFinal);
        campoJuegoFinal.setCenter(tableroFinalGrupo);
        StackPane stackPane = new StackPane(fondo_tablero,campoJuegoFinal);
        Label etiquetaJugadorActual = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaJugadorActual,"Turno de " +juego.obtenerNombreJugadorEnTurno(),30);
        cajaAtaque.getChildren().add(0,etiquetaJugadorActual);
        ImageView marcoRojo = new ImageView (directorio_resources+"marcoRojo.png");
        int x = 0;
        OrganizadorDeBatallones organizadorDeBatallones = new OrganizadorDeBatallones(juego,tablero1,tablero2,directorio_resources);
        while (x<20) {
            int y = 0;
            while (y < 10) {
                int[]coordenadas = {x,y};
                StackPane casilleroSeleccionado1 = (StackPane)(tablero1.getChildren().get(x*10+y));
                casilleroSeleccionado1.setOnMouseClicked(new HandlerSeleccionarPieza(casilleroSeleccionado1,marcoRojo,ultimaFichaSeleccionada,vida,generadorDeEtiquetas,juego, coordenadas,tablero1,organizadorDeBatallones,contenedorErrores,pantallaVictoria,directorio_resources));
                casilleroSeleccionado1.setOnContextMenuRequested(new HandlerBatallon(juego,casilleroSeleccionado1,coordenadas,organizadorDeBatallones,contenedorErrores,lanzadorExcepciones));
                StackPane casilleroSeleccionado2 = (StackPane)(tablero2.getChildren().get(x*10+y));
                int[]coordenadas1 = {x,y+10};
                casilleroSeleccionado2.setOnMouseClicked(new HandlerSeleccionarPieza(casilleroSeleccionado2,marcoRojo,ultimaFichaSeleccionada,vida,generadorDeEtiquetas,juego,coordenadas1,tablero2,organizadorDeBatallones,contenedorErrores,pantallaVictoria,directorio_resources));
                casilleroSeleccionado2.setOnContextMenuRequested(new HandlerBatallon(juego,casilleroSeleccionado2,coordenadas1,organizadorDeBatallones,contenedorErrores,lanzadorExcepciones));
                y++;
            }
            x++;
        }
        organizadorDeBatallones.actualizarBatallones();
        escena.setRoot(stackPane);
    }
}
