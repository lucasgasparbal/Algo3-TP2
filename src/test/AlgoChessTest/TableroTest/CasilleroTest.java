package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasilleroTest {

    @Test
    public void test01CasilleroRecienCreadoEstaVacio(){

        Equipo equipoMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(0,0,equipoMock,tableroMock);
        assert casillero.estaLibre();
    }

    @Test
    public void test02CasilleroOcupadoNoPuedeSerOcupadoPorNuevaUnidad(){

        Equipo equipoMock = mock(Equipo.class);
        Unidad unidadMockUno = mock(Unidad.class);
        Unidad unidadMockDos = mock(Unidad.class);
        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,equipoMock,tableroMock);

        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero(unidadMockUno);
            casillero.ocuparCasillero(unidadMockDos);
        });
    }
    @Test
    public void test03CasilleroDeUnEquipoNoAceptaSerColocadoConUnidadEnemiga(){
        Equipo equipoCasilleroMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);
        Catapulta catapultaMock = mock(Catapulta.class);
        when(catapultaMock.esDelEquipo(equipoCasilleroMock)).thenReturn(false);

        Casillero casillero = new Casillero(0,0,equipoCasilleroMock,tableroMock);
        Assertions.assertThrows(CasilleroEnemigoExcepcion.class, () ->{
            casillero.colocarUnidad(catapultaMock);
        });
    }
}
