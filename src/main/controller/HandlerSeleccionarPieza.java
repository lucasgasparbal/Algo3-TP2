package controller;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;
import vista.UltimaFichaSeleccionada;

public class HandlerSeleccionarPieza implements EventHandler<MouseEvent> {

    StackPane casilleroSeleccionado;
    ImageView marco;
    UltimaFichaSeleccionada ultimaFichaSeleccionada;
    Group placeholder = new Group();
    Label vidaPieza;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    Juego juego;
    int[]coordenadas;

    public HandlerSeleccionarPieza (StackPane casillero, ImageView marcoRojo, UltimaFichaSeleccionada ultimaFicha, Label vida, GeneradorDeEtiquetas generador, Juego nuevoJuego, int[]coord) {
        this.casilleroSeleccionado = casillero;
        this.marco = marcoRojo;
        this.ultimaFichaSeleccionada = ultimaFicha;
        this.vidaPieza = vida;
        this.generadorDeEtiquetas = generador;
        this.juego = nuevoJuego;
        this.coordenadas=coord;
    }

    public void handle (MouseEvent event) {
        if (ultimaFichaSeleccionada.hayFichaSeleccionada()) {
            int[]coordenadasPiezaSeleccionada = ultimaFichaSeleccionada.obtenerCoordenadas();
            placeholder.getChildren().add(marco);
            if (juego.estaEnModoMovimiento()) {
                if (coordenadasPiezaSeleccionada[0] == coordenadas [0]) {
                    if (coordenadasPiezaSeleccionada[1] == coordenadas [1]+1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaAbajo(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            noHayUnidadEnCasilleroExcepcion.printStackTrace();
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            coordenadaFueraDeRangoExcepcion.printStackTrace();
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            unidadActivaNoEsDeJugadorEnTurnoExcepcion.printStackTrace();
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            casilleroOcupadoExcepcion.printStackTrace();
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            movimientoInvalidoExcepcion.printStackTrace();
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            catapultaNoSePuedeMoverExcepcion.printStackTrace();
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            yaMovioExcepcion.printStackTrace();
                        }
                    }
                    if (coordenadasPiezaSeleccionada[1] == coordenadas[1]-1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaArriba(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            noHayUnidadEnCasilleroExcepcion.printStackTrace();
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            casilleroOcupadoExcepcion.printStackTrace();
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            unidadActivaNoEsDeJugadorEnTurnoExcepcion.printStackTrace();
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            movimientoInvalidoExcepcion.printStackTrace();
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            coordenadaFueraDeRangoExcepcion.printStackTrace();
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            catapultaNoSePuedeMoverExcepcion.printStackTrace();
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            yaMovioExcepcion.printStackTrace();
                        }
                    }
                }
                if (coordenadasPiezaSeleccionada[1] == coordenadas [1]) {
                    if (coordenadasPiezaSeleccionada[0] == coordenadas [0]+1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaIzquierda(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            noHayUnidadEnCasilleroExcepcion.printStackTrace();
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            coordenadaFueraDeRangoExcepcion.printStackTrace();
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            unidadActivaNoEsDeJugadorEnTurnoExcepcion.printStackTrace();
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            casilleroOcupadoExcepcion.printStackTrace();
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            movimientoInvalidoExcepcion.printStackTrace();
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            catapultaNoSePuedeMoverExcepcion.printStackTrace();
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            yaMovioExcepcion.printStackTrace();
                        }
                    }
                    if (coordenadasPiezaSeleccionada[0] == coordenadas[0]-1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaDerecha(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            noHayUnidadEnCasilleroExcepcion.printStackTrace();
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            casilleroOcupadoExcepcion.printStackTrace();
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            unidadActivaNoEsDeJugadorEnTurnoExcepcion.printStackTrace();
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            movimientoInvalidoExcepcion.printStackTrace();
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            coordenadaFueraDeRangoExcepcion.printStackTrace();
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            catapultaNoSePuedeMoverExcepcion.printStackTrace();
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            yaMovioExcepcion.printStackTrace();
                        }
                    }
                }
                casilleroSeleccionado.getChildren().add(ultimaFichaSeleccionada.obtenerImagenFicha());
                ultimaFichaSeleccionada.limpiarSeleccionFicha();
                return;
            }
            if (juego.estaEnModoMovimiento()==false) {
                try {
                    juego.atacarPieza(ultimaFichaSeleccionada.obtenerCoordenadas(),coordenadas);
                } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                    noHayUnidadEnCasilleroExcepcion.printStackTrace();
                } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                    coordenadaFueraDeRangoExcepcion.printStackTrace();
                } catch (ObjetivoFueraDeRangoExcepcion objetivoFueraDeRangoExcepcion) {
                    objetivoFueraDeRangoExcepcion.printStackTrace();
                } catch (ObjetivoNoEsEnemigoExcepcion objetivoNoEsEnemigoExcepcion) {
                    objetivoNoEsEnemigoExcepcion.printStackTrace();
                } catch (ObjetivoEsEnemigoExcepcion objetivoEsEnemigoExcepcion) {
                    objetivoEsEnemigoExcepcion.printStackTrace();
                } catch (NoSePudoCurarExcepcion noSePudoCurarExcepcion) {
                    noSePudoCurarExcepcion.printStackTrace();
                } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                    unidadActivaNoEsDeJugadorEnTurnoExcepcion.printStackTrace();
                } catch (YaAtacoExcepcion yaAtacoExcepcion) {
                    yaAtacoExcepcion.printStackTrace();
                }
                ultimaFichaSeleccionada.limpiarSeleccionFicha();
                return;
            }
        }
        casilleroSeleccionado.getChildren().add(marco);
        if (casilleroSeleccionado.getChildren().size() >2) {
            try {
               generadorDeEtiquetas.generarEtiquetaNegrita(vidaPieza,"- Vida: "+juego.obtenerVida(coordenadas),40);
            } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                coordenadaFueraDeRangoExcepcion.printStackTrace();
            } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                noHayUnidadEnCasilleroExcepcion.printStackTrace();
            }
            vidaPieza.setTextFill(Color.web("#FFFFFF"));
            ultimaFichaSeleccionada.seleccionarFicha((ImageView)casilleroSeleccionado.getChildren().get(1),coordenadas);
        }
    }
}
