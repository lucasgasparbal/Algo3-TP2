package AlgoChessTest.EquiposTest;

import model.AlgoChess.Equipos.EquipoNegro;
import org.junit.Test;

import static junit.framework.TestCase.*;


public class EquipoNegroTest{

    @Test
    public void test01esBlancoDevuelveFalseEnEquipoNegro(){
        EquipoNegro equipoNegro = new EquipoNegro();
        assertFalse(equipoNegro.esBlanco());
    };

    @Test
    public void test02esNegroDevuelveTrueEnEquipoNegro(){
        EquipoNegro equipoNegro = new EquipoNegro();
        assertTrue(equipoNegro.esNegro());
    };

}
