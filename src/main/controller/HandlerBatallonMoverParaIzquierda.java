package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Excepciones.YaMovioExcepcion;
import model.AlgoChess.Juego;
import vista.OrganizadorDeBatallones;

public class HandlerBatallonMoverParaIzquierda implements EventHandler<ActionEvent> {

    Juego juego;
    int[] coordenadas;
    OrganizadorDeBatallones organizadorDeBatallones;

    public HandlerBatallonMoverParaIzquierda (Juego nuevoJuego, int[]coordenadasCasillero, OrganizadorDeBatallones organizador) {
        this.juego = nuevoJuego;
        this.coordenadas = coordenadasCasillero;
        this.organizadorDeBatallones = organizador;
    }

    @Override
    public void handle (ActionEvent event) {
        organizadorDeBatallones.moverBatallonParaIzquierda(coordenadas);
        try {
            juego.moverBatallonParaIzquierda(coordenadas);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            coordenadaFueraDeRangoExcepcion.printStackTrace();
        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
            noHayUnidadEnCasilleroExcepcion.printStackTrace();
        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
            movimientoInvalidoExcepcion.printStackTrace();
        } catch (YaMovioExcepcion yaMovioExcepcion) {
            yaMovioExcepcion.printStackTrace();
        }
        organizadorDeBatallones.actualizarBatallones();
    }
}
