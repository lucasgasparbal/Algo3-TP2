package model.AlgoChess.Tablero;

import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Unidades.ColeccionUnidades;
import model.AlgoChess.Unidades.Unidad;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DiccionarioCasilleroUnidad {
    Hashtable<Casillero, Unidad> diccionario = new Hashtable<>();

    public void enCasilleroPonerUnidad(Casillero casillero, Unidad unidad) throws CasilleroOcupadoExcepcion {
        casillero.ocuparCasillero();
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
        casillero.vaciar();
        return diccionario.remove(casillero);
    }

    public boolean unidadTieneEnemigosCercanos(Unidad unidad) throws CoordenadaFueraDeRangoExcepcion {

        for(Unidad unaUnidad : diccionario.values()){
            if(unaUnidad.esEnemigoDe(unidad) & unaUnidad.estaEnRangoCercanoDe(unidad)){
                return true;
            }
        }

        return false;
    }

    public boolean unidadTieneAliadosCercanos(Unidad unidad) throws CoordenadaFueraDeRangoExcepcion {

        for(Unidad unaUnidad : diccionario.values()){
            if(!unaUnidad.esEnemigoDe(unidad) & unaUnidad.estaEnRangoCercanoDe(unidad)){
                return true;
            }
        }

        return false;
    }

    public void desplazarUnidadDesdeHasta(Unidad unidad, Casillero origen, Casillero objetivo) throws CasilleroOcupadoExcepcion {
        enCasilleroPonerUnidad(objetivo,unidad);
        removerUnidadDeCasillero(origen);
    }

    private ArrayList<Unidad> obtenerUnidadesAdyacentesA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        ArrayList<Unidad> lista = new ArrayList<>();
        for(Unidad unidad: diccionario.values()){
            if(unidad.esAdyacenteA(unaUnidad)){
                lista.add(unidad);
            }
        }
        return lista;
    }

    public ColeccionUnidades obtenerUnidadesConexasA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        LinkedList<Unidad> cola = new LinkedList<>();
        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();
        cola.addLast(unaUnidad);

        while(!cola.isEmpty()){
            Unidad unidadActual = cola.pollFirst();
            for(Unidad unidad: obtenerUnidadesAdyacentesA(unidadActual)){
                if(unidad != unaUnidad & !coleccionUnidades.contieneUnidad(unidad)){
                    cola.addLast(unidad);
                    coleccionUnidades.agregarUnidad(unidad);
                }
            }
        }
        return coleccionUnidades;
    }
}
