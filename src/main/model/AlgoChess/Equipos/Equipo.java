package model.AlgoChess.Equipos;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.ColeccionUnidades;
import model.AlgoChess.Unidades.Unidad;

public  class Equipo {

    private ColeccionUnidades unidades = new ColeccionUnidades ();
    private int identificador;
    private Equipo equipoEnemigo;

    public Equipo(int numeroIdentificador){
        identificador = numeroIdentificador;
    }

    public void establecerEquipoEnemigo (Equipo rival) {
        equipoEnemigo = rival;
    }

    public int getIdentificador() {
        return identificador;
    }

    public boolean esBlanco(){return false;}
    public boolean esNegro(){return false;}
    public boolean esIgualA(Equipo unEquipo){return false;}

    public boolean hayUnidadesEnemigasCercanas(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return (equipoEnemigo.hayUnidadesAliadasCercanas(unaUnidad));
    }

    public boolean hayUnidadesAliadasCercanas(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return unidades.hayUnidadesCercanasA(unaUnidad);
    }

}
