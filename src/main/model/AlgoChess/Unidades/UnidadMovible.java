package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Excepciones.YaMovioExcepcion;

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

    public void desplazarHaciaIzquierda() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        if(movio){
            throw new YaMovioExcepcion();
        }
        ubicacion = tablero.DesplazarUnidadHaciaIzquierdaDesde(this,ubicacion);
        movio = true;
    }

    public void desplazarHaciaDerecha() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        if(movio){
            throw new YaMovioExcepcion();
        }
        ubicacion = tablero.DesplazarUnidadHaciaDerechaDesde(this,ubicacion);
        movio = true;
    }

    public void desplazarHaciaArriba() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        if(movio){
            System.out.println("NIGGERS");
            throw new YaMovioExcepcion();
        }
        ubicacion = tablero.DesplazarUnidadHaciaArribaDesde(this,ubicacion);
        movio = true;
    }

    public void desplazarHaciaAbajo() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        if(movio){
            throw new YaMovioExcepcion();
        }
        ubicacion = tablero.DesplazarUnidadHaciaAbajoDesde(this,ubicacion);
        movio = true;
    }

}
