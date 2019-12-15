package controller;

import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Juego;
import vista.GeneradorDeEtiquetas;
import vista.MensajeDeError;
import vista.OrganizadorDeBatallones;
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
    GridPane tablero;
    OrganizadorDeBatallones organizadorDeBatallones;
    Group contenedorErrores;
    StackPane pantallaVictoria;

    public HandlerSeleccionarPieza (StackPane casillero, ImageView marcoRojo, UltimaFichaSeleccionada ultimaFicha, Label vida, GeneradorDeEtiquetas generador, Juego nuevoJuego, int[]coord, GridPane tableroActual, OrganizadorDeBatallones organizador, Group grupo, StackPane stackPane) {
        this.casilleroSeleccionado = casillero;
        this.marco = marcoRojo;
        this.ultimaFichaSeleccionada = ultimaFicha;
        this.vidaPieza = vida;
        this.generadorDeEtiquetas = generador;
        this.juego = nuevoJuego;
        this.coordenadas=coord;
        this.tablero = tableroActual;
        this.organizadorDeBatallones = organizador;
        this.contenedorErrores = grupo;
        this.pantallaVictoria = stackPane;
    }

    public void lanzarExcepcion (String textoDelError) {
        Label errorAImprimir = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(), textoDelError,30,"#FF0000");
        MensajeDeError mensajeDeError = new MensajeDeError();
        SequentialTransition error = mensajeDeError.generarAvisoParpadeante(errorAImprimir);
        contenedorErrores.getChildren().clear();
        contenedorErrores.getChildren().add(errorAImprimir);
        error.play();
    }

    public void handle (MouseEvent event) {
        MouseButton botonApretado = event.getButton();
        if (ultimaFichaSeleccionada.hayFichaSeleccionada()) {
            int[]coordenadasPiezaSeleccionada = ultimaFichaSeleccionada.obtenerCoordenadas();
            placeholder.getChildren().add(marco);
            if (juego.estaEnModoMovimiento()) {
                if (coordenadasPiezaSeleccionada[0] == coordenadas [0]) {
                    if (coordenadasPiezaSeleccionada[1] == coordenadas [1]+1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaAbajo(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            lanzarExcepcion("No hay unidad en el casillero seleccionado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            lanzarExcepcion("El casillero destino esta fuera de rango");
                            return;
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            lanzarExcepcion("La unidad no es del jugador actual");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            lanzarExcepcion("El casillero destino esta ocupado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            lanzarExcepcion("El movimiento es invalido");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            lanzarExcepcion("La catapulta no se puede mover");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            lanzarExcepcion("La unidad ya se movio este turno");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        }
                    }
                    if (coordenadasPiezaSeleccionada[1] == coordenadas[1]-1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaArriba(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            lanzarExcepcion("No hay unidad en el casillero seleccionado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            lanzarExcepcion("El casillero destino esta fuera de rango");
                            return;
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            lanzarExcepcion("La unidad no es del jugador actual");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            lanzarExcepcion("El casillero destino esta ocupado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            lanzarExcepcion("El movimiento es invalido");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            lanzarExcepcion("La catapulta no se puede mover");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            lanzarExcepcion("La unidad ya se movio este turno");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        }
                    }
                }
                else if (coordenadasPiezaSeleccionada[1] == coordenadas [1]) {
                    if (coordenadasPiezaSeleccionada[0] == coordenadas [0]+1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaIzquierda(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            lanzarExcepcion("No hay unidad en el casillero seleccionado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            lanzarExcepcion("El casillero destino esta fuera de rango");
                            return;
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            lanzarExcepcion("La unidad no es del jugador actual");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            lanzarExcepcion("El casillero destino esta ocupado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            lanzarExcepcion("El movimiento es invalido");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            lanzarExcepcion("La catapulta no se puede mover");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            lanzarExcepcion("La unidad ya se movio este turno");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        }
                    }
                    if (coordenadasPiezaSeleccionada[0] == coordenadas[0]-1) {
                        try {
                            juego.moverPiezaEnCoordenadaHaciaDerecha(coordenadasPiezaSeleccionada);
                        } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                            lanzarExcepcion("No hay unidad en el casillero seleccionado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                            lanzarExcepcion("El casillero destino esta fuera de rango");
                            return;
                        } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                            lanzarExcepcion("La unidad no es del jugador actual");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
                            lanzarExcepcion("El casillero destino esta ocupado");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (MovimientoInvalidoExcepcion movimientoInvalidoExcepcion) {
                            lanzarExcepcion("El movimiento es invalido");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (CatapultaNoSePuedeMoverExcepcion catapultaNoSePuedeMoverExcepcion) {
                            lanzarExcepcion("La catapulta no se puede mover");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        } catch (YaMovioExcepcion yaMovioExcepcion) {
                            lanzarExcepcion("La unidad ya se movio este turno");
                            ultimaFichaSeleccionada.limpiarSeleccionFicha();
                            return;
                        }
                    }
                }
                else {
                    lanzarExcepcion("El casillero destino esta fuera de rango");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                    return;
                }
                casilleroSeleccionado.getChildren().add(ultimaFichaSeleccionada.obtenerImagenFicha());
                organizadorDeBatallones.actualizarBatallones();
                ultimaFichaSeleccionada.limpiarSeleccionFicha();
                return;
            }
            if (juego.estaEnModoMovimiento()==false) {
                try {
                    if (juego.atacarPieza(ultimaFichaSeleccionada.obtenerCoordenadas(),coordenadas)) {
                        StackPane casilleroVictima = (StackPane) tablero.getChildren().get(coordenadas[0]*10+coordenadas[1]);
                        casilleroVictima.getChildren().remove(1);
                        if (juego.rivalPerdio()) {
                            Label etiquetaVictoria = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),juego.obtenerNombreJugadorEnTurno()+ ", BIEN HECHO", 40,"#ffd700");
                            pantallaVictoria.getChildren().add(etiquetaVictoria);
                            pantallaVictoria.setAlignment(etiquetaVictoria, Pos.TOP_CENTER);
                            Scene secondScene = new Scene(pantallaVictoria,512,512);
                            Stage ventanaVictoria = new Stage();
                            ventanaVictoria.setTitle("FELICITACIONES");
                            ventanaVictoria.setScene(secondScene);
                            ventanaVictoria.show();
                        }
                    };
                } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) {
                    lanzarExcepcion("No hay unidad en el casillero seleccionado");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                    lanzarExcepcion("El ataque no se puede realizar");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (ObjetivoFueraDeRangoExcepcion objetivoFueraDeRangoExcepcion) {
                    lanzarExcepcion("El objetivo esta fuera de rango");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (ObjetivoNoEsEnemigoExcepcion objetivoNoEsEnemigoExcepcion) {
                    lanzarExcepcion("El objetivo es una unidad aliada, no se puede atacar");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (ObjetivoEsEnemigoExcepcion objetivoEsEnemigoExcepcion) {
                    lanzarExcepcion("El objetivo es una unidad enemiga, no se puede curar");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (NoSePudoCurarExcepcion noSePudoCurarExcepcion) {
                    lanzarExcepcion("La unidad ya tiene la vida al maximo, no se puede curar");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (UnidadActivaNoEsDeJugadorEnTurnoExcepcion unidadActivaNoEsDeJugadorEnTurnoExcepcion) {
                    lanzarExcepcion("La unidad no le pertenece al jugador actual");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                } catch (YaAtacoExcepcion yaAtacoExcepcion) {
                    lanzarExcepcion("La unidad ya ataco este turno");
                    ultimaFichaSeleccionada.limpiarSeleccionFicha();
                }
                ultimaFichaSeleccionada.limpiarSeleccionFicha();
                organizadorDeBatallones.actualizarBatallones();
                return;
            }
        };
        if (botonApretado == MouseButton.PRIMARY) {
            casilleroSeleccionado.getChildren().add(marco);
            if (casilleroSeleccionado.getChildren().size() >2) {
                try {
                    generadorDeEtiquetas.generarEtiquetaNegrita(vidaPieza, "- Vida: " + juego.obtenerVida(coordenadas), 40);
                } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
                    coordenadaFueraDeRangoExcepcion.printStackTrace();
                } catch (NoHayUnidadEnCasilleroExcepcion noHayUnidadEnCasilleroExcepcion) { }
                vidaPieza.setTextFill(Color.web("#FFFFFF"));
                ultimaFichaSeleccionada.seleccionarFicha((ImageView) casilleroSeleccionado.getChildren().get(1), coordenadas);
            }
        }
    }
}
