package AlgoChessTest.TableroTest;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Tablero;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TableroTest {

    private Tablero tablero = new Tablero();

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
    public void ConseguirCasilleroLanzaExcepcionEnCoordenadasInvalidas(){

        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->tablero.conseguirCasillero(-1,-1));
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasSonAdyacentes(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveTrueEnCoordenadasAdyacentes() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasSonAdyacentes(coordenadaA,coordenadaB));
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveFalseEnCoordenadasNoAdyacentes() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasSonAdyacentes(coordenadaA,coordenadaC));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveFalseEnCoordenadasNoCercanas() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaD));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveTrueEnCoordenadasAdyacentes() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaB));
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveTrueConCoordenadasEnBordeSuperiorDeRangoCercano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoCercano(coordenadaA,coordenadaC));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveFalseConCoordenadasEnRangoCercano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaC));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveTrueConCoordenadasEnBordeInferiorDeRangoMediano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaD));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveTrueConCoordenadasEnBordeSuperiorDeRangoMediano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaE));
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveTrueConCoordenadasEnInteriorDeRangoMediano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoMediano(coordenadaA,coordenadaF));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseEnCoordenadasIguales() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaA));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseConCoordenadasCercanas() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaB));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseConCoordenadaMedianas() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertFalse(tablero.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaF));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveTrueConCoordenadasEnLimiteInferiorDeRangoLejano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaG));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveTrueConCoordenadasEnInteriorDeRangoLejano() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaH));
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveTrueConCoordenadasEnLaOtraPuntaDelTablero() throws CoordenadaFueraDeRangoExcepcion {
        Assertions.assertTrue(tablero.coordenadasEstanEnRangoLejano(coordenadaA,coordenadaI));
    }
}
