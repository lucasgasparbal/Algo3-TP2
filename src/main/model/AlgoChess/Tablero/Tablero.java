package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public class Tablero {

    final private int CantFilas = 20;
    final private int CantColumnas = 20;

    private MatrizCasilleros matrizCasilleros;
    private Equipo equipoBlanco;
    private Equipo equipoNegro;


    public Tablero(Equipo equipoUno, Equipo equipoDos){
        equipoBlanco = equipoUno;
        equipoNegro = equipoDos;
        matrizCasilleros = new MatrizCasilleros(equipoUno,equipoDos);
    }

    public Casillero conseguirCasillero(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion {
        return matrizCasilleros.conseguirCasillero(coordenadas);
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

}
