package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public abstract class Unidad {

    Casillero ubicacion;

    Vida vida;

    Costo costo;

    protected Equipo equipo;

    public Unidad(Equipo unEquipo){
        equipo = unEquipo;
    }

    public Casillero getUbicacion() {
        return ubicacion;
    }

    public void inicializarEnCasillero(Casillero unCasillero) throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        if(!unCasillero.perteneceAEquipo(equipo.getNumeroEquipo())){
            throw new CasilleroEnemigoExcepcion();
        }

        unCasillero.ocuparCasillero();
        ubicacion = unCasillero;
    }
    public void recibirCuracion(int curacion) {
        vida.recibiCuracion(curacion);
    }

    public void sufrirDanio (int dmg) {
        vida.tomaDanio(dmg);
    }

    public boolean murio() {
        return (vida.acabo());
    }

    public int comprar (int fondos) throws NoAlcanzanPuntosExcepcion {
        return costo.descontarCosto (fondos);
    }

    public boolean esAdyacenteA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.esAdyacenteA(unaUnidad.getUbicacion());
    }

    public boolean estaEnRangoCercanoDe(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoCercanoDe(unaUnidad.getUbicacion());
    }

    public boolean estaEnRangoMedianoDe(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoMedianoDe(unaUnidad.getUbicacion());
    }

    public boolean estaEnRangoLejanoDe(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoLejanoDe(unaUnidad.getUbicacion());
    }

    public int[] getPosicion() {
        return ubicacion.coordenadas();
    }

    public int getVida() {
        return vida.getValor();
    }
}
