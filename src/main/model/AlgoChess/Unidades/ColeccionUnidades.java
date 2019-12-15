package model.AlgoChess.Unidades;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ColeccionUnidades {
    private HashSet<Unidad> unidades = new HashSet<Unidad>();

    public boolean estaVacia() {
        return unidades.isEmpty();
    }

    public void resetearAtaqueMovimiento() {
        for(Unidad unidad : unidades){
            unidad.prepararTurno();
        }
    }

    public void agregarUnidad(Unidad unidad){
        if(!contieneUnidad(unidad)){
            unidades.add(unidad);
        }
    }

    public boolean contieneUnidad(Unidad unidad){
        return unidades.contains(unidad);
    }

    public boolean hayUnidadesVivas() {
        for(Unidad unidad: unidades){
            if(!unidad.murio()){
                return true;
            }
        }

        return false;
    }

    public void daniarTodasLasUnidades(int danio){
        for(Unidad unidad : unidades){
            unidad.sufrirDanio(danio);
        }
    }

    public void prepararTurno(){
        for(Unidad unidad: unidades){
            unidad.prepararTurno();
        }
    }
}