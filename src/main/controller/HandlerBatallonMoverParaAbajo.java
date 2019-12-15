package controller;

import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import model.AlgoChess.Unidades.PaqueteCoordenadasBatallon;
import vista.GeneradorDeEtiquetas;
import vista.LanzadorExcepciones;
import vista.MensajeDeError;
import vista.OrganizadorDeBatallones;

public class HandlerBatallonMoverParaAbajo implements EventHandler<ActionEvent> {

    Juego juego;
    int[] coordenadas;
    OrganizadorDeBatallones organizadorDeBatallones;
    Group contenedorErrores;
    LanzadorExcepciones lanzadorExcepciones;

    public HandlerBatallonMoverParaAbajo (Juego nuevoJuego, int[]coordenadasCasillero, OrganizadorDeBatallones organizador, Group contenedor, LanzadorExcepciones lanzador) {
        this.juego = nuevoJuego;
        this.coordenadas = coordenadasCasillero;
        this.organizadorDeBatallones = organizador;
        this.contenedorErrores = contenedor;
        this.lanzadorExcepciones = lanzador;
    }

    @Override
    public void handle (ActionEvent event) {
        PaqueteCoordenadasBatallon batallon = organizadorDeBatallones.encontrarBatallonCorrespondiente(coordenadas);
        try {
            juego.moverBatallonParaArriba(coordenadas);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            coordenadaFueraDeRangoExcepcion.printStackTrace();
        } catch (NoHayUnidadEnCasilleroExcepcion | MovimientoInvalidoExcepcion | YaMovioExcepcion noHayUnidadEnCasilleroExcepcion) {
            noHayUnidadEnCasilleroExcepcion.printStackTrace();
        } catch (BatallonYaSeMovioExcepcion batallonYaSeMovioExcepcion) {
            lanzadorExcepciones.lanzarExcepcion("El batallon ya se movio en este turno",contenedorErrores);
            return;
        } catch (BatallonNoSePuedeMoverExcepcion batallonNoSePuedeMoverExcepcion) {
            lanzadorExcepciones.lanzarExcepcion("El batallon no se puede desplazar en la direccion indicada",contenedorErrores);
            return;
        }
        organizadorDeBatallones.moverBatallonParaArriba(batallon);
        organizadorDeBatallones.actualizarBatallones();

    }
}