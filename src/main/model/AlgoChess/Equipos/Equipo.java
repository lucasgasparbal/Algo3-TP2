package model.AlgoChess.Equipos;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.ColeccionUnidades;

public abstract class Equipo {

    private ColeccionUnidades unidades = new ColeccionUnidades ();
    protected Equipo equipoEnemigo;

    public void establecerEquipoEnemigo (Equipo rival) {
        equipoEnemigo = rival;
    }

    public abstract boolean esBlanco();
    public abstract boolean esNegro();
    public abstract boolean esIgualA(Equipo unEquipo);

    public abstract boolean esEnemigoDeCasillero(Casillero unCasillero);

    public boolean hayUnidadesEnemigasCercanas(Casillero ubicacion) throws CoordenadaFueraDeRangoExcepcion {
        return (equipoEnemigo.hayUnidadesAliadasCercanas(ubicacion));
    }

    public boolean hayUnidadesAliadasCercanas(Casillero ubicacion) throws CoordenadaFueraDeRangoExcepcion {
        return unidades.hayUnidadesCercanasA(ubicacion);
    }

}
