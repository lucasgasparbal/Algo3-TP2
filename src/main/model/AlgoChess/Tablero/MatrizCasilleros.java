package model.AlgoChess.Tablero;

import javafx.scene.control.Tab;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public class MatrizCasilleros {

    final private int CantFilas = 20;
    final private int CantColumnas = 20;

    private Equipo equipoBlanco;
    private Equipo equipoNegro;
    private Casillero[][] casilleros = new Casillero[CantFilas][CantColumnas];

    private AnalizadorRangos analizadorRangos = new AnalizadorRangos();
    
    private void inicializarTableroParaEquipo(Tablero tablero, Equipo unEquipo, int inicioColumna, int finalColumna){
        for(int i = 0; i < CantFilas; i++){
            for(int j = inicioColumna; j < finalColumna; j++){
                casilleros[i][j] = new Casillero(i,j, tablero, unEquipo);
            }
        }
    }
    public MatrizCasilleros(Equipo equipoUno, Equipo equipoDos, Tablero tablero){
        equipoBlanco = equipoUno;
        equipoNegro = equipoDos;
        inicializarTableroParaEquipo(tablero, equipoUno, 0, CantColumnas/2);
        inicializarTableroParaEquipo(tablero, equipoDos, CantColumnas/2, CantFilas);
    }

    private boolean coordenadaEnRango(int coordenada, int limiteSuperior){

        return ((0 <= coordenada) & (coordenada < limiteSuperior));

    }

    private boolean coordenadasSonValidas(int x, int y){

        return (coordenadaEnRango(x,CantFilas) & coordenadaEnRango(y,CantColumnas));

    }

    public Casillero conseguirCasillero(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion {

        if (!coordenadasSonValidas(coordenadas[0],coordenadas[1])) {
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return casilleros[coordenadas[0]][coordenadas[1]];
    }

    public int contarCasillerosDeEquipoUno(){
        int contador = 0;
        for(int i = 0; i < CantFilas; i++){
            for(int j = 0; j < CantColumnas; j++){
                if (casilleros[i][j].perteneceAEquipo(equipoBlanco)){
                    contador++;
                }
            }
        }
        return contador;
    }
    public int contarCasillerosDeEquipoDos(){
        int contador = 0;
        for(int i = 0; i < CantFilas; i++){
            for(int j = 0; j < CantColumnas; j++){
                if (casilleros[i][j].perteneceAEquipo(equipoNegro)){
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

    private boolean parDeCoordenadasSonInvalidas(int[] coordenadaUno, int[] coordenadaDos){
        return (!coordenadasSonValidas(coordenadaUno[0], coordenadaUno[1]) | !coordenadasSonValidas(coordenadaDos[0],coordenadaDos[1]));
    }

    public boolean coordenadasEstanEnRangoCercano(int[] coordenadaUno, int[] coordenadaDos) throws  CoordenadaFueraDeRangoExcepcion{
        if( parDeCoordenadasSonInvalidas(coordenadaUno, coordenadaDos)){
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return analizadorRangos.coordenadasEstanEnRangoCercano(coordenadaUno[0],coordenadaUno[1],coordenadaDos[0],coordenadaDos[1]);
    }

    public boolean coordenadasEstanEnRangoMediano(int[] coordenadaUno, int[] coordenadaDos) throws  CoordenadaFueraDeRangoExcepcion{
        if( parDeCoordenadasSonInvalidas(coordenadaUno, coordenadaDos)){
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return analizadorRangos.coordenadasEstanEnRangoMediano(coordenadaUno[0],coordenadaUno[1],coordenadaDos[0],coordenadaDos[1]);
    }

    public boolean coordenadasEstanEnRangoLejano(int[] coordenadaUno, int[] coordenadaDos) throws  CoordenadaFueraDeRangoExcepcion{
        if( parDeCoordenadasSonInvalidas(coordenadaUno, coordenadaDos)){
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return analizadorRangos.coordenadasEstanEnRangoLejano(coordenadaUno[0],coordenadaUno[1],coordenadaDos[0],coordenadaDos[1]);
    }

    public boolean coordenadasSonAdyacentes(int[] coordenadaUno, int[] coordenadaDos) throws  CoordenadaFueraDeRangoExcepcion{
        if( parDeCoordenadasSonInvalidas(coordenadaUno, coordenadaDos)){
            throw new CoordenadaFueraDeRangoExcepcion();
        }

        return analizadorRangos.coordenadasSonAdyacentes(coordenadaUno[0],coordenadaUno[1],coordenadaDos[0],coordenadaDos[1]);
    }

}
