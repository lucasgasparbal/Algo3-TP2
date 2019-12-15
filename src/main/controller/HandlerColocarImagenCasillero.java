package controller;

import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import vista.ImageViewPiezaEnJuego;

import java.net.NoRouteToHostException;

public class HandlerColocarImagenCasillero implements EventHandler<MouseEvent> {

    GridPane tablero;
    ImageViewPiezaEnJuego piezaSeleccionada;
    int[] coordenadas = new int[2];
    Juego juego;
    Boolean segundaMitad;
    Label etiquetaOro;
    SequentialTransition secuenciaOro;

    public HandlerColocarImagenCasillero(GridPane nuevoTablero, ImageViewPiezaEnJuego ultimaPiezaSeleccionada, int[] coordenadasAUsar, Juego nuevoJuego, Boolean esSegundaMitad, Label oro, SequentialTransition secuencia) {
        this.tablero = nuevoTablero;
        this.piezaSeleccionada = ultimaPiezaSeleccionada;
        this.coordenadas = coordenadasAUsar;
        this.juego = nuevoJuego;
        this.segundaMitad = esSegundaMitad;
        this.etiquetaOro = oro;
        this.secuenciaOro = secuencia;
    }

    @Override
    public void handle(MouseEvent event) {
        ImageView piezaACargar = new ImageView();
        piezaACargar.setImage(piezaSeleccionada.devolverUltimaImagen());
        StackPane casillero = (StackPane)(tablero.getChildren().get(coordenadas[0]*10+coordenadas[1]));
        if (segundaMitad) {
            coordenadas[1]=coordenadas[1]+10;
        }
        if (piezaSeleccionada.soldado()) {
            try {
                juego.inicializarSoldadoEnCoordenadas(coordenadas);
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                etiquetaOro.setVisible(true);
                secuenciaOro.play();
                return;
            } catch (CasilleroEnemigoExcepcion | CoordenadaFueraDeRangoExcepcion | NoHaySoldadosEnBanquillaExcepcion excepcion) { }
        }
        if (piezaSeleccionada.curandero()) {
            try {
                juego.inicializarCuranderoEnCoordenadas(coordenadas);
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                etiquetaOro.setVisible(true);
                secuenciaOro.play();
                return;
            } catch (CasilleroEnemigoExcepcion | CoordenadaFueraDeRangoExcepcion | NoHayCuranderosEnBanquillaExcepcion excepcion) { }
        }
        if (piezaSeleccionada.catapulta()) {
            try {
                juego.inicializarCatapultaEnCoordenadas(coordenadas);
            } catch (CasilleroEnemigoExcepcion | CoordenadaFueraDeRangoExcepcion | NoHayCatapultasEnBanquillaExcepcion excepcion) {
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                etiquetaOro.setVisible(true);
                secuenciaOro.play();
                return;
            }
        }
        if (piezaSeleccionada.jinete()) {
            try {
                juego.inicializarJineteEnCoordenadas(coordenadas);
            } catch (CasilleroEnemigoExcepcion | CoordenadaFueraDeRangoExcepcion | NoHayJinetesEnBanquillaExcepcion excepcion) {
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                etiquetaOro.setVisible(true);
                secuenciaOro.play();
                return;
            }
        }
        casillero.getChildren().add(piezaACargar);
        piezaSeleccionada.limpiarPieza();
        piezaSeleccionada.borrarImagen();
    }

}
