package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Tablero.Casillero;

public abstract class UnidadMovible extends Unidad {

    public UnidadMovible(Equipo unEquipo) {
        super(unEquipo);
    }

    public void ocuparCasillero(Casillero unCasillero) throws CasilleroOcupadoExcepcion {
        unCasillero.ocuparCasillero();
    }


    public void desplazarHaciaIzquierda() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroIzquierdo();
            nuevoCasillero.ocuparCasillero();
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

    public void desplazarHaciaDerecha() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroDerecho();
            nuevoCasillero.ocuparCasillero();
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

    public void desplazarHaciaArriba() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroSuperior();
            nuevoCasillero.ocuparCasillero();
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

    public void desplazarHaciaAbajo() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion {
        try {
            Casillero nuevoCasillero = ubicacion.obtenerCasilleroInferior();
            nuevoCasillero.ocuparCasillero();
            ubicacion.vaciar();
            ubicacion = nuevoCasillero;
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

    }

}
