package AlgoChessTest.TableroTest;

import model.AlgoChess.Tablero.AnalizadorRangos;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AnalizadorRangosTest {

    //coordenadasEnRangoCercano

    @Test
    public void test01coordenadasEnRangoCercanoDevuelveTrueSiLasCoordenadasEstanEnElLimiteDelRangoCercano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoCercano(0,0,2,2);
        assertTrue(test);
    }

    @Test
    public void test02coordenadasEnRangoCercanoDevuelveTrueSiLasCoordenadasEstanDentroDelRangoCercano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoCercano(0,0,1,0);
        assertTrue(test);
    }

    @Test
    public void test03coordenadasEnRangoCercanoDevuelveTrueSiAmbasCoordenadasEstanSobreLaMismaFilaYEnRangoCercano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoCercano(1,3,1,2);
        assertTrue(test);
    }

    @Test
    public void test04coordenadasEnRangoCercanoDevuelveFalseSiLasCoordenadasEstanFueraDelRangoCercano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoCercano(1,3,9,15);
        assertFalse(test);
    }

    //CoordenadasEnRangoMedianoTest

    @Test
    public void test05coordenadasEnRangoMedianoDevuelveTrueSiLasCoordenadasEstanEnElLimiteDelRangoMediano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoMediano(0,0,5,5);
        assertTrue(test);
    }

    @Test
    public void test06coordenadasEnRangoMedianoDevuelveTrueSiLasCoordenadasEstanDentroDelRangoMediano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoMediano(0,0,3,4);
        assertTrue(test);
    }

    @Test
    public void test07coordenadasEnRangoMedianoDevuelveTrueSiAmbasCoordenadasEstanSobreLaMismaFilaYEnRangoMediano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoMediano(1,3,1,7);
        assertTrue(test);
    }

    @Test
    public void test08coordenadasEnRangoMedianoDevuelveFalseSiLasCoordenadasEstanFueraDelRangoMediano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoMediano(1,3,9,15);
        assertFalse(test);
    }

    @Test
    public void test09coordenadasEnRangoMedianoDevuelveFalseSiLasCoordenadasEstanEnRangoCercano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoMediano(1,3,2,4);
        assertFalse(test);
    }

    //CoordenadasEnRangoLejanoTest

    @Test
    public void test10coordenadasEnRangoLejanoDevuelveTrueSiLasCoordenadasEstanDentroDelRangoLejano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoLejano(0,0,14,17);
        assertTrue(test);
    }

    @Test
    public void test11coordenadasEnRangoLejanoDevuelveTrueSiAmbasCoordenadasEstanSobreLaMismaFilaYEnRangoLejano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoLejano(1,3,1,18);
        assertTrue(test);
    }



    @Test
    public void test12coordenadasEnRangoLejanoDevuelveFalseSiLasCoordenadasEstanEnRangoCercano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoLejano(1,3,2,4);
        assertFalse(test);
    }

    @Test
    public void test13coordenadasEnRangoLejanoDevuelveFalseSiLasCoordenadasEstanEnElRangoMediano(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoLejano(1,3,4,7);
        assertFalse(test);
    }

    //coordenadasEnRangoDeMovimientoTest
    @Test
    public void test14coordenadasSonAdyacentesDevuelveTrueSiLasCoordenadasEstanEnElRangoAdyacente(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasSonAdyacentes(0,0,1,1);
        assertTrue(test);
    }

    @Test
    public void test15coordenadasSonAdyacentesDevuelveFalseSiLasCoordenadasNoEstanEnElRangoAdyacente(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasSonAdyacentes(0,0,3,5);
        assertFalse(test);
    }

    @Test
    public void coordenadasSonAdyacentesDevuelveFalseSiLasCoordenadasSonIguales(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasSonAdyacentes(0,0,0,0);
        assertFalse(test);
    }

    @Test
    public void coordenadasEstanEnRangoCercanoDevuelveFalseSiLasCoordenadasSonIguales(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoCercano(0,0,0,0);
        assertFalse(test);
    }

    @Test
    public void coordenadasEstanEnRangoMedianoDevuelveFalseSiLasCoordenadasSonIguales(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoMediano(0,0,0,0);
        assertFalse(test);
    }

    @Test
    public void coordenadasEstanEnRangoLejanoDevuelveFalseSiLasCoordenadasSonIguales(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();
        boolean test = analizadorRangos.coordenadasEstanEnRangoLejano(0,0,0,0);
        assertFalse(test);
    }

    @Test
    public void EstanEnRangoCercanoDevuelveFalseParaDosCoordenadasEnMismaColumnaPeroFilasLejanas(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();

        Assert.assertFalse(analizadorRangos.coordenadasEstanEnRangoCercano(0,2,9,2));
    }

    @Test
    public void EstanEnRangoCercanoDevuelveFalseParaDosCoordenadasUnaEnFilaAdyacenteALaOtraPeroEnDistintasColumnas(){
        AnalizadorRangos analizadorRangos = new AnalizadorRangos();

        Assert.assertFalse(analizadorRangos.coordenadasEstanEnRangoCercano(0,2,1,10));
    }
}
