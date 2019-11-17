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

        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(0,0,tableroMock);
        assert casillero.estaLibre();
    }

    @Test
    public void CasilleroOcupadoNoPuedeSerOcupadoSiYaEstaOcupado(){

        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,tableroMock);

        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero();
            casillero.ocuparCasillero();
        });
    }

    @Test
    public void OcupoCasilleroRecienCreadoYNoEstaVacio() throws CasilleroOcupadoExcepcion {

        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,tableroMock);
        casillero.ocuparCasillero();

        Assertions.assertFalse(casillero.estaLibre());

    }

    @Test
    public void DesocupoCasilleroOcupadoYResultaVacio() throws CasilleroOcupadoExcepcion {

        Tablero tableroMock = mock(Tablero.class);

        Casillero casillero = new Casillero(0,0,tableroMock);
        casillero.ocuparCasillero();
        casillero.vaciar();

        Assertions.assertTrue(casillero.estaLibre());

    }
    @Test
    public void CasilleroCreadoEnMitadInferiorTableroEsDeEquipoBlanco(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(0, 16, tableroMock);

        Assertions.assertTrue(casillero.esBlanco());
    }

    @Test
    public void CasilleroCreadoEnMitadInferiorTableroNoEsDeEquipoNegro(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(0, 16, tableroMock);

        Assertions.assertFalse(casillero.esNegro());
    }

    @Test
    public void CasilleroCreadoEnMitadSuperiorTableroEsDeEquipoNegro(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(10, 16, tableroMock);

        Assertions.assertTrue(casillero.esNegro());
    }

    @Test
    public void CasilleroCreadoEnMitadSuperiorTableroNoEsDeEquipoBlanco(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(10, 16, tableroMock);

        Assertions.assertFalse(casillero.esBlanco());
    }

    @Test
    public void CasilleroDeEquipoBlancoNoAplicaPorcentajeExtraDeDañoAUnidadBlanca(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(8, 16, tableroMock);

        Assertions.assertEquals(0, casillero.aplicarPenalizacionAUnidadBlanca());
    }

    @Test
    public void CasilleroDeEquipoBlancoAplicaPorcentajeExtraDeDañoAUnidadNegra(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(8, 16, tableroMock);

        Assertions.assertEquals(5, casillero.aplicarPenalizacionAUnidadNegra());
    }

    @Test
    public void CasilleroDeEquipoNegroAplicaPorcentajeExtraDeDañoAUnidadBlanca(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(18, 16, tableroMock);

        Assertions.assertEquals(5, casillero.aplicarPenalizacionAUnidadBlanca());
    }

    @Test
    public void CasilleroDeEquipoNegroNoAplicaPorcentajeExtraDeDañoAUnidadNegra(){
        Tablero tableroMock = mock(Tablero.class);
        Casillero casillero = new Casillero(18, 16, tableroMock);

        Assertions.assertEquals(0, casillero.aplicarPenalizacionAUnidadNegra());
    }
}
