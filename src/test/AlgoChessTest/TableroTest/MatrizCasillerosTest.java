package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.MatrizCasilleros;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class MatrizCasillerosTest {
    Equipo equipoUno = new Equipo(1);
    Equipo equipoDos = new Equipo(2);
    MatrizCasilleros matriz = new MatrizCasilleros(equipoUno,equipoDos);

    private int[] coordenadaInvalidaUno = {-1,2};
    private int[] coordenadaInvalidaDos = {4,1500};
    private int[] coordenadaA = {0,0};
    private int[] coordenadaB = {1,1};
    private int[] coordenadaC = {2,0};
    private int[] coordenadaD = {3,0};
    private int[] coordenadaE = {5,5};
    private int[] coordenadaF = {4,2};
    private int[] coordenadaG = {6,0};
    private int[] coordenadaH = {14,17};
    private int[] coordenadaI = {19,19};

    @Test
    public void ConseguirCasilleroLanzaExcepcionEnCoordenadasInvalidasConNumeroNegativo(){

        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->matriz.conseguirCasillero(coordenadaInvalidaUno));
    }

    @Test
    public void ConseguirCasilleroLanzaExcepcionEnCoordenadasInvalidasConNumeroPositivoMayorA20(){

        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->matriz.conseguirCasillero(coordenadaInvalidaDos));
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasSonAdyacentes(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveTrueEnCoordenadasAdyacentes() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasSonAdyacentes(coordenadaA,coordenadaB));
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveFalseEnCoordenadasNoAdyacentes() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasSonAdyacentes(coordenadaA,coordenadaC));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveFalseEnCoordenadasNoCercanas() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaD));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveTrueEnCoordenadasAdyacentes() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaB));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveTrueConCoordenadasEnBordeSuperiorDeRangoCercano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaC));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveFalseConCoordenadasEnRangoCercano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaC));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveTrueConCoordenadasEnBordeInferiorDeRangoMediano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaD));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveTrueConCoordenadasEnBordeSuperiorDeRangoMediano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaE));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveTrueConCoordenadasEnInteriorDeRangoMediano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaF));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseConCoordenadasCercanas() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaB));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseConCoordenadaMedianas() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(matriz.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaF));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveTrueConCoordenadasEnLimiteInferiorDeRangoLejano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaG));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveTrueConCoordenadasEnInteriorDeRangoLejano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaH));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveTrueConCoordenadasEnLaOtraPuntaDelTablero() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(matriz.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaI));
    }
}
