package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;

public class Tablero {

    final private int CantFilas = 20;
    final private int CantColumnas = 20;

    private Casillero[][] casilleros = new Casillero[CantFilas][CantColumnas];

    private void inicializarTableroParaEquipo(Equipo unEquipo, int inicioFila, int finalFila){
        for(int i = inicioFila; i < finalFila; i++){
            for(int j = 0; j < CantColumnas; j++){
                casilleros[i][j] = new Casillero(i,j,unEquipo);
            }
        }
    }

    public Tablero(Equipo unEquipo,Equipo otroEquipo){
        inicializarTableroParaEquipo(unEquipo, 0, CantFilas/2);
        inicializarTableroParaEquipo(otroEquipo, CantFilas/2, CantFilas);

    }

}
