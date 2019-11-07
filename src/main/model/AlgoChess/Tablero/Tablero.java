package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public class Tablero {

    final private int CantFilas = 20;
    final private int CantColumnas = 20;

    private Casillero[][] casilleros = new Casillero[CantFilas][CantColumnas];

    private void inicializarTableroParaEquipo(Equipo unEquipo, int inicioFila, int finalFila){
        for(int i = inicioFila; i < finalFila; i++){
            for(int j = 0; j < CantColumnas; j++){
                casilleros[i][j] = new Casillero(i,j,unEquipo, this);
            }
        }
    }

    public Tablero(Equipo unEquipo,Equipo otroEquipo){
        inicializarTableroParaEquipo(unEquipo, 0, CantFilas/2);
        inicializarTableroParaEquipo(otroEquipo, CantFilas/2, CantFilas);

    }

    private boolean coordenadaEnRango(int coordenada, int limiteSuperior){

        return ((0 <= coordenada) & (coordenada < limiteSuperior));

    }

    public Casillero conseguirCasillero(int x, int y) throws CoordenadaFueraDeRangoExcepcion{

        if (!(coordenadaEnRango(x,CantFilas)) & !(coordenadaEnRango(y,CantColumnas))){
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return casilleros[x][y];
    }

}
