package model.AlgoChess.Tablero;

import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Unidades.Unidad;

import java.util.Hashtable;

public class DiccionarioCasilleroUnidad {
    Hashtable<Casillero, Unidad> diccionario = new Hashtable<>();

    public void EnCasilleroPonerUnidad(Casillero casillero, Unidad unidad){
        diccionario.put(casillero, unidad);
    }

    public Unidad obtenerUnidadEnCasillero(Casillero casillero) throws NoHayUnidadEnCasilleroExcepcion {
        Unidad unidad = diccionario.get(casillero);
        if(unidad == null){
            throw new NoHayUnidadEnCasilleroExcepcion();
        }

        return unidad;
    }

    public Unidad removerUnidadDeCasillero(Casillero casillero){
        return diccionario.remove(casillero);
    }
}
