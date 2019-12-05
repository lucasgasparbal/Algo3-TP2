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

    public void actualizarCasilleroUnidad(Casillero casilleroViejo, Casillero casilleroNuevo) {
        Unidad unidad = diccionario.remove(casilleroViejo);
        diccionario.put(casilleroNuevo,unidad);
    }
}
