package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Tablero.Casillero;
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
        Casillero casillero = new Casillero(0,0,equipoMock);
        assert casillero.estaLibre();
    }

    @Test
    public void test02CasilleroOcupadoNoPuedeSerOcupadoPorNuevaUnidad(){

        Equipo equipoMock = mock(Equipo.class);
        Unidad unidadMockUno = mock(Unidad.class);
        Unidad unidadMockDos = mock(Unidad.class);

        Casillero casillero = new Casillero(0,0,equipoMock);

        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero(unidadMockUno);
            casillero.ocuparCasillero(unidadMockDos);
        });
    }
    @Test
    public void test03CasilleroDeUnEquipoNoAceptaSerColocadoConUnidadEnemiga(){
        Equipo equipoCasilleroMock = mock(Equipo.class);

        Catapulta catapultaMock = mock(Catapulta.class);
        when(catapultaMock.esDelEquipo(equipoCasilleroMock)).thenReturn(false);

        Casillero casillero = new Casillero(0,0,equipoCasilleroMock);
        Assertions.assertThrows(CasilleroEnemigoExcepcion.class, () ->{
            casillero.colocarUnidad(catapultaMock);
        });


    }
}
