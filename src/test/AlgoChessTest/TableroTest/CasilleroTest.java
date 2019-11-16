package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Unidad;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasilleroTest {

    @Test
    public void CasilleroRecienCreadoEstaVacio(){

        Equipo equipoMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(0,0,equipoMock,tableroMock);
        assert casillero.estaLibre();
    }

    @Test
    public void CasilleroOcupadoNoPuedeSerOcupadoSiYaEstaOcupado(){

        Equipo equipoMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,equipoMock,tableroMock);

        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero();
            casillero.ocuparCasillero();
        });
    }

    @Test
    public void OcupoCasilleroRecienCreadoYNoEstaVacio() throws CasilleroOcupadoExcepcion {

        Equipo equipoMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,equipoMock,tableroMock);
        casillero.ocuparCasillero();

        Assertions.assertFalse(casillero.estaLibre());

    }

    @Test
    public void DesocupoCasilleroOcupadoYResultaVacio() throws CasilleroOcupadoExcepcion {

        Equipo equipoMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,equipoMock,tableroMock);
        casillero.ocuparCasillero();
        casillero.vaciar();

        Assertions.assertTrue(casillero.estaLibre());

    }
    @Test
    public void CasilleroDeUnEquipoNoAceptaSerColocadoConUnidadEnemiga(){
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
