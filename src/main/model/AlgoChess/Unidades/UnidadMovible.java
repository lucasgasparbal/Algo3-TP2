package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Tablero.Casillero;

public abstract class UnidadMovible extends Unidad {

    protected boolean movio = false;

    public UnidadMovible(Equipo unEquipo) {
        super(unEquipo);
    }

    @Override
    public void prepararTurno(){
        ataco = false;
        movio = false;
    }

    public void desplazarHaciaIzquierda() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroIzquierdo();
            nuevoCasillero.ocuparCasillero(this);
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

    public void desplazarHaciaDerecha() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroDerecho();
            nuevoCasillero.ocuparCasillero(this);
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

    public void desplazarHaciaArriba() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroSuperior();
            nuevoCasillero.ocuparCasillero(this);
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

    public void desplazarHaciaAbajo() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroInferior();
            nuevoCasillero.ocuparCasillero(this);
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

}
