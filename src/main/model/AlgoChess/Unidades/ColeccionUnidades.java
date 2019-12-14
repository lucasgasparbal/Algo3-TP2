package model.AlgoChess.Unidades;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

import java.util.ArrayList;
import java.util.Iterator;

public class ColeccionUnidades {
    private ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public boolean estaVacia() {
        return unidades.isEmpty();
    }

    public void resetearAtaqueMovimiento() {
        for(Unidad unidad : unidades){
            unidad.prepararTurno();
        }
    }

    public void agregarUnidad(Unidad unidad){
        unidades.add(unidad);
    }


    public boolean hayUnidadesVivas() {
        for(Unidad unidad: unidades){
            if(!unidad.murio()){
                return true;
            }
        }

        return false;
    }
}