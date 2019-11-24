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
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).esAdyacenteA(unaUnidad)){ return true;}
        }
        return false;
    }

    public boolean hayUnidadesCercanasA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).estaEnRangoCercanoDe(unaUnidad)){ return true;}
        }
        return false;
    }
}