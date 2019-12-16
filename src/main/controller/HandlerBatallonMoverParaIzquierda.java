package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import model.AlgoChess.Unidades.PaqueteCoordenadasBatallon;
import vista.LanzadorExcepciones;
import vista.OrganizadorDeBatallones;

public class HandlerBatallonMoverParaIzquierda implements EventHandler<ActionEvent> {

    Juego juego;
    int[] coordenadas;
    OrganizadorDeBatallones organizadorDeBatallones;
    Group contenedorErrores;
    LanzadorExcepciones lanzadorExcepciones;

    public HandlerBatallonMoverParaIzquierda (Juego nuevoJuego, int[]coordenadasCasillero, OrganizadorDeBatallones organizador, Group contenedor, LanzadorExcepciones lanzador) {
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
            juego.moverBatallonParaIzquierda(coordenadas);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            coordenadaFueraDeRangoExcepcion.printStackTrace();
        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
            noHayUnidadEnCasilleroExcepcion.printStackTrace();
        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
            movimientoInvalidoExcepcion.printStackTrace();
        } catch (YaMovioExcepcion yaMovioExcepcion) {
            yaMovioExcepcion.printStackTrace();
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
        organizadorDeBatallones.moverBatallonParaIzquierda(batallon);
        organizadorDeBatallones.actualizarBatallones();
    }
}
