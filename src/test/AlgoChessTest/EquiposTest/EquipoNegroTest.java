package AlgoChessTest.EquiposTest;

import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


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

    @Test
    public void test03EquipoNegroEsIgualAEquipoNegro(){
        EquipoNegro equipoNegro = new EquipoNegro();
        assertTrue(equipoNegro.esIgualA(equipoNegro));
    }

    @Test
    public void test04EquipoNegroNoEsIgualAEquipoBlanco(){
        EquipoNegro equipoNegro = new EquipoNegro();

        EquipoBlanco equipoBlancoMock = mock(EquipoBlanco.class);
        when(equipoBlancoMock.esNegro()).thenReturn(false);

        assertFalse(equipoNegro.esIgualA(equipoBlancoMock));

        verify(equipoBlancoMock,times(1)).esNegro();
    }
}
