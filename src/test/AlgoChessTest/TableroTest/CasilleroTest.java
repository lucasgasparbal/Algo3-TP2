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
    public void CasilleroRecienCreadoEstaVacio() {

        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(0, 0, tableroMock, 1);
        assert casillero.estaLibre();
    }

    @Test
    public void CasilleroOcupadoNoPuedeSerOcupadoSiYaEstaOcupado() {

        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0, 0, tableroMock, 1);

        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero();
            casillero.ocuparCasillero();
        });
    }

    @Test
    public void OcupoCasilleroRecienCreadoYNoEstaVacio() throws CasilleroOcupadoExcepcion {

        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0, 0, tableroMock, 1);
        casillero.ocuparCasillero();

        Assertions.assertFalse(casillero.estaLibre());

    }

    @Test
    public void DesocupoCasilleroOcupadoYResultaVacio() throws CasilleroOcupadoExcepcion {

        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0, 0, tableroMock, 1);
        casillero.ocuparCasillero();
        casillero.vaciar();

        Assertions.assertTrue(casillero.estaLibre());

    }

    @Test
    public void CasilleroDevuelveMultiplicadorDeDanioIgualAUnoAUnidadDeEquipoUno() {
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(8, 16, tableroMock, 1);

        Assertions.assertEquals(1, casillero.aplicarMultiplicadorDanioAUnidadDeEquipo(1));
    }

    @Test
    public void CasilleroDevuelveMultiplicadorDeDanioAumentadoParaUnidadEnemiga() {
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(8, 16, tableroMock, 1);

        Assertions.assertEquals(1.05, casillero.aplicarMultiplicadorDanioAUnidadDeEquipo(2));
    }

}