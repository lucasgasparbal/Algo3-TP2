package controller;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import vista.ImageViewPiezaEnJuego;

public class HandlerColocarImagenCasillero implements EventHandler<MouseEvent> {

    GridPane tablero;
    ImageViewPiezaEnJuego piezaSeleccionada;
    int[] coordenadas = new int[2];
    Juego juego;
    Boolean segundaMitad;

    public HandlerColocarImagenCasillero(GridPane nuevoTablero,ImageViewPiezaEnJuego ultimaPiezaSeleccionada, int[] coordenadasAUsar, Juego nuevoJuego, Boolean esSegundaMitad) {
        this.tablero = nuevoTablero;
        this.piezaSeleccionada = ultimaPiezaSeleccionada;
        this.coordenadas = coordenadasAUsar;
        this.juego = nuevoJuego;
        this.segundaMitad = esSegundaMitad;
    }

    @Override
    public void handle(MouseEvent event) {
        ImageView piezaACargar = new ImageView();
        piezaACargar.setImage(piezaSeleccionada.devolverUltimaImagen());
        StackPane casillero = (StackPane)(tablero.getChildren().get(coordenadas[0]*10+coordenadas[1]));
        if (segundaMitad) {
            coordenadas[1]=coordenadas[1]+10;
        }
        casillero.getChildren().add(piezaACargar);
        if (piezaSeleccionada.soldado()) {
            try {
                juego.inicializarSoldadoEnCoordenadas(coordenadas);
            } catch (NoHaySoldadosEnBanquillaExcepcion noHaySoldadosEnBanquillaExcepcion) {
                noHaySoldadosEnBanquillaExcepcion.printStackTrace();
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                casilleroOcupadoExcepcion.printStackTrace();
            } catch (CasilleroEnemigoExcepcion casilleroEnemigoExcepcion) {
                casilleroEnemigoExcepcion.printStackTrace();
            } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                coordenadaFueraDeRangoExcepcion.printStackTrace();
            }
        }
        if (piezaSeleccionada.curandero()) {
            try {
                juego.inicializarCuranderoEnCoordenadas(coordenadas);
            } catch (NoHayCuranderosEnBanquillaExcepcion noHayCuranderosEnBanquillaExcepcion) {
                noHayCuranderosEnBanquillaExcepcion.printStackTrace();
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                casilleroOcupadoExcepcion.printStackTrace();
            } catch (CasilleroEnemigoExcepcion casilleroEnemigoExcepcion) {
                casilleroEnemigoExcepcion.printStackTrace();
            } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                coordenadaFueraDeRangoExcepcion.printStackTrace();
            }
        }
        if (piezaSeleccionada.catapulta()) {
            try {
                juego.inicializarCatapultaEnCoordenadas(coordenadas);
            } catch (NoHayCatapultasEnBanquillaExcepcion noHayCuranderosEnBanquillaExcepcion) {
                noHayCuranderosEnBanquillaExcepcion.printStackTrace();
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                casilleroOcupadoExcepcion.printStackTrace();
            } catch (CasilleroEnemigoExcepcion casilleroEnemigoExcepcion) {
                casilleroEnemigoExcepcion.printStackTrace();
            } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                coordenadaFueraDeRangoExcepcion.printStackTrace();
            }
        }
        if (piezaSeleccionada.jinete()) {
            try {
                juego.inicializarJineteEnCoordenadas(coordenadas);
            } catch (NoHayJinetesEnBanquillaExcepcion noHayCuranderosEnBanquillaExcepcion) {
                noHayCuranderosEnBanquillaExcepcion.printStackTrace();
            } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                casilleroOcupadoExcepcion.printStackTrace();
            } catch (CasilleroEnemigoExcepcion casilleroEnemigoExcepcion) {
                casilleroEnemigoExcepcion.printStackTrace();
            } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                coordenadaFueraDeRangoExcepcion.printStackTrace();
            }
        }
        piezaSeleccionada.limpiarPieza();
        piezaSeleccionada.borrarImagen();
    }

}
