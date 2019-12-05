package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class Tablero {

    final private int CantFilas = 20;
    final private int CantColumnas = 20;

    private MatrizCasilleros matrizCasilleros;
    private Equipo equipoBlanco;
    private Equipo equipoNegro;

    private DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();

    public Tablero(Equipo equipoUno, Equipo equipoDos){
        equipoBlanco = equipoUno;
        equipoNegro = equipoDos;
        matrizCasilleros = new MatrizCasilleros(equipoUno,equipoDos, this);
    }

    public void inicializarUnidadEnCasillero(Unidad unidad, int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        Casillero casillero = matrizCasilleros.conseguirCasillero(coordenadas);
        unidad.inicializarEnCasillero(casillero);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casillero,unidad);
    }
    public Casillero conseguirCasillero(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion {
        return matrizCasilleros.conseguirCasillero(coordenadas);
    }

    public Unidad conseguirUnidad(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion {

        return diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(matrizCasilleros.conseguirCasillero(coordenadas));
    }

    public int contarCasillerosDeEquipoUno(){
        return matrizCasilleros.contarCasillerosDeEquipoUno();
    }
    public int contarCasillerosDeEquipoDos(){
        return matrizCasilleros.contarCasillerosDeEquipoDos();
    }

    public int contarCasillerosVacios(){
       return matrizCasilleros.contarCasillerosVacios();
    }

    public void enCasilleroPonerUnidad(Casillero casillero, Unidad unidad){
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casillero,unidad);
    }

    public void vaciarCasillero(Casillero casillero){
        diccionarioCasilleroUnidad.removerUnidadDeCasillero(casillero);
    }

}
