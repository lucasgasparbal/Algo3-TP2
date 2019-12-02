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

    public boolean esIgualA(Equipo unEquipo){
        return this.identificador == unEquipo.identificador;
    }

    public boolean hayUnidadesEnemigasCercanas(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return (equipoEnemigo.hayUnidadesAliadasCercanas(unaUnidad));
    }

    public boolean hayUnidadesAliadasCercanas(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return unidades.hayUnidadesCercanasA(unaUnidad);
    }

    public void removerUnidad(Unidad unidad){
        unidades.removerUnidad(unidad);
    }

    public void agregarUnidad(Unidad unidad){
        unidades.agregarUnidad(unidad);
    }

    public boolean noTieneUnidades(){
        return unidades.estaVacia();
    }

}
