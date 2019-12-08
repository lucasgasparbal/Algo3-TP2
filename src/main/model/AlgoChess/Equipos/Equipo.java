package model.AlgoChess.Equipos;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.ColeccionUnidades;
import model.AlgoChess.Unidades.Unidad;


public  class Equipo {

    private int identificador;

    public Equipo(int numeroIdentificador){
        identificador = numeroIdentificador;
    }

    public boolean esIgualA(Equipo unEquipo){
        return this.identificador == unEquipo.identificador;
    }

}
