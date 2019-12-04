package model.AlgoChess.Unidades;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

import java.util.ArrayList;

public class ColeccionUnidades {
    private ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public boolean estaVacia() {
        return unidades.isEmpty();
    }

    public void agregarUnidad(Unidad unidad){
        unidades.add(unidad);
    }

    public boolean hayUnidadesAdyacentesA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        for(Unidad unidad : unidades){
            if(unidad.esAdyacenteA(unaUnidad)){ return true;}
        }
        return false;
    }

    public boolean hayUnidadesCercanasA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        for(Unidad unidad : unidades){
            if(unidad.estaEnRangoCercanoDe(unaUnidad)){ return true;}
        }
        return false;
    }

    public void removerUnidad(Unidad unidad){
        unidades.remove(unidad);
    }


}