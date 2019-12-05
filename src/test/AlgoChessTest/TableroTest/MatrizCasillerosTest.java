package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.MatrizCasilleros;
import model.AlgoChess.Tablero.Tablero;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class MatrizCasillerosTest {
    Equipo equipoUno = new Equipo(1);
    Equipo equipoDos = new Equipo(2);
    Tablero tablero = new Tablero(equipoUno,equipoDos);
    MatrizCasilleros matriz = new MatrizCasilleros(equipoUno,equipoDos,tablero);

    private int[] coordenadaInvalidaUno = {-1,2};
    private int[] coordenadaInvalidaDos = {4,1500};

    @Test
    public void ConseguirCasilleroLanzaExcepcionEnCoordenadasInvalidasConNumeroNegativo(){

        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->matriz.conseguirCasillero(coordenadaInvalidaUno));
    }

    @Test
    public void ConseguirCasilleroLanzaExcepcionEnCoordenadasInvalidasConNumeroPositivoMayorA20(){

        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->matriz.conseguirCasillero(coordenadaInvalidaDos));
    }
}
