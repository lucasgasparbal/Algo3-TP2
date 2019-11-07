package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class CasilleroTest {

    @Test
    public void test01CasilleroRecienCreadoEstaVacio(){

        Equipo equipoMock = mock(Equipo.class);
        Casillero casillero = new Casillero(0,0,equipoMock);
        assert casillero.estaLibre();
    }

    @Test
    public void test02CasilleroOcupadoNoPuedeContenerUnaUnidad(){

        Equipo equipoMock = mock(Equipo.class);
        Unidad unidadMockUno = mock(Unidad.class);
        Unidad unidadMockDos = mock(Unidad.class);

        Casillero casillero = new Casillero(0,0,equipoMock);

        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero(unidadMockUno);
            casillero.ocuparCasillero(unidadMockDos);
        });
    }
}
