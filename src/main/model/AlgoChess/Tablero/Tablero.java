package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class Tablero {

    final private int CantFilas = 20;
    final private int CantColumnas = 20;

    private Casillero[][] casilleros = new Casillero[CantFilas][CantColumnas];

    private AnalizadorRangos analizadorRangos = new AnalizadorRangos();
    private void inicializarTableroParaEquipo(Equipo unEquipo, int inicioFila, int finalFila){
        for(int i = inicioFila; i < finalFila; i++){
            for(int j = 0; j < CantColumnas; j++){
                casilleros[i][j] = new Casillero(i,j, this);
            }
        }
    }

    public Tablero(){
        for(int i = 0; i < CantFilas; i++){
            for(int j = 0; j < CantColumnas; j++){
                casilleros[i][j] = new Casillero(i,j, this);
            }
        }

    }

    private boolean coordenadaEnRango(int coordenada, int limiteSuperior){

        return ((0 <= coordenada) & (coordenada < limiteSuperior));

    }

    public Casillero conseguirCasillero(int x, int y) throws CoordenadaFueraDeRangoExcepcion {

        if (!(coordenadaEnRango(x, CantFilas)) & !(coordenadaEnRango(y, CantColumnas))) {
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return casilleros[x][y];
    }

    public int contarCasillerosDeEquipoBlanco(){
        int contador = 0;
        for(int i = 0; i < CantFilas; i++){
            for(int j = 0; j < CantColumnas; j++){
                if (casilleros[i][j].esBlanco()){
                    contador++;
                }
            }
        }
        return contador;
    }
    public int contarCasillerosDeEquipoNegro(){
        int contador = 0;
        for(int i = 0; i < CantFilas; i++){
            for(int j = 0; j < CantColumnas; j++){
                if (casilleros[i][j].esNegro()){
                    contador++;
                }
            }
        }
        return contador;
    }

    public int contarCasillerosVacios(){
        int contador = 0;
        for(int i = 0; i < CantFilas; i++){
            for(int j = 0; j < CantColumnas; j++){
                if(casilleros[i][j].estaLibre()){
                    contador++;
                }
            }

        }
        return contador;
    }

}
