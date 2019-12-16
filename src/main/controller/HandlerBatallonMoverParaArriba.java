package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import model.AlgoChess.Unidades.PaqueteCoordenadasBatallon;
import vista.GeneradorDeEtiquetas;
import vista.LanzadorExcepciones;
import vista.OrganizadorDeBatallones;

public class HandlerBatallonMoverParaArriba implements EventHandler<ActionEvent> {

    Juego juego;
    int[] coordenadas;
    OrganizadorDeBatallones organizadorDeBatallones;
    Group contenedorErrores;
    LanzadorExcepciones lanzadorExcepciones;

    public HandlerBatallonMoverParaArriba (Juego nuevoJuego, int[]coordenadasCasillero, OrganizadorDeBatallones organizador, Group contenedor, LanzadorExcepciones lanzador) {
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
            juego.moverBatallonParaAbajo(coordenadas);
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
        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
            lanzadorExcepciones.lanzarExcepcion("El batallon no pertenece al jugador en turno",contenedorErrores);
            return;
        }
        organizadorDeBatallones.moverBatallonParaAbajo( batallon);
        organizadorDeBatallones.actualizarBatallones();
    }
}
