package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Excepciones.YaMovioExcepcion;
import model.AlgoChess.Juego;
import vista.OrganizadorDeBatallones;

public class HandlerBatallonMoverParaDerecha implements EventHandler<ActionEvent> {

    Juego juego;
    int[] coordenadas;
    OrganizadorDeBatallones organizadorDeBatallones;

    public HandlerBatallonMoverParaDerecha (Juego nuevoJuego, int[]coordenadasCasillero, OrganizadorDeBatallones organizador) {
        this.juego = nuevoJuego;
        this.coordenadas = coordenadasCasillero;
        this.organizadorDeBatallones = organizador;
    }

    @Override
    public void handle (ActionEvent event) {
        organizadorDeBatallones.moverBatallonParaDerecha(coordenadas);
        try {
            juego.moverBatallonParaDerecha(coordenadas);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            coordenadaFueraDeRangoExcepcion.printStackTrace();
        } catch (NoHayUnidadEnCasilleroExcepcion | MovimientoInvalidoExcepcion | YaMovioExcepcion noHayUnidadEnCasilleroExcepcion) {
            noHayUnidadEnCasilleroExcepcion.printStackTrace();
        }
        organizadorDeBatallones.actualizarBatallones();
    }
}
