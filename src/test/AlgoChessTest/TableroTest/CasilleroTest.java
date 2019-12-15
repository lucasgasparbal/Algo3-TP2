package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

public class CasilleroTest {

    Tablero tableroMock = mock(Tablero.class);
    Equipo equipoMock = mock(Equipo.class);
    Equipo equipoEnemigoMock = mock(Equipo.class);

    @Test
    public void CasilleroRecienCreadoEstaVacio() {


        Casillero casillero = new Casillero(0, 0, equipoMock);
        assert casillero.estaLibre();
    }

    @Test
    public void CasilleroOcupadoNoPuedeSerOcupadoSiYaEstaOcupado() {

        Unidad unidadMock = mock(Unidad.class);
        Casillero casillero = new Casillero(0, 0, equipoMock);


        Assertions.assertThrows(CasilleroOcupadoExcepcion.class, () -> {
            casillero.ocuparCasillero();
            casillero.ocuparCasillero();
        });
    }

    @Test
    public void OcupoCasilleroRecienCreadoYNoEstaVacio() throws CasilleroOcupadoExcepcion {

        Unidad unidadMock = mock(Unidad.class);
        Casillero casillero = new Casillero(0, 0, equipoMock);
        casillero.ocuparCasillero();

        Assertions.assertFalse(casillero.estaLibre());

    }

    @Test
    public void DesocupoCasilleroOcupadoYResultaVacio() throws CasilleroOcupadoExcepcion {
        Unidad unidadMock = mock(Unidad.class);
        Casillero casillero = new Casillero(0, 0, equipoMock);
        casillero.ocuparCasillero();
        casillero.vaciar();

        Assertions.assertTrue(casillero.estaLibre());

    }

    @Test
    public void CasilleroPerteneceAEquipoDevuelveTrueConElEquipoAsignadoEnSuConstruccionComoParametro(){

        Casillero casillero = new Casillero(0,0, equipoMock);
        when(equipoMock.esIgualA(equipoMock)).thenReturn(true);

        Assert.assertTrue(casillero.perteneceAEquipo(equipoMock));
        verify(equipoMock).esIgualA(equipoMock);
    }

    @Test
    public void CasilleroPerteneceAEquipoDevuelveFalseConElEquipoDistintoAlQuePertenece(){

        Casillero casillero = new Casillero(0,0, equipoMock);
        when(equipoMock.esIgualA(equipoEnemigoMock)).thenReturn(true);

        Assert.assertTrue(casillero.perteneceAEquipo(equipoEnemigoMock));
        verify(equipoMock).esIgualA(equipoEnemigoMock);
    }


    @Test
    public void CasilleroDevuelveMultiplicadorDeDanioIgualAUnoAUnidadDelMismoEquipo() {
        Casillero casillero = new Casillero(8, 16, equipoMock);
        when(equipoMock.esIgualA(equipoMock)).thenReturn(true);

        Assertions.assertEquals(1, casillero.aplicarMultiplicadorDanioAUnidadDeEquipo(equipoMock));
        verify(equipoMock).esIgualA(equipoMock);
    }

    @Test
    public void CasilleroDevuelveMultiplicadorDeDanioAumentadoParaUnidadEnemiga() {
        Casillero casillero = new Casillero(8, 16, equipoMock);
        when(equipoMock.esIgualA(equipoEnemigoMock)).thenReturn(false);

        Assertions.assertEquals(1.05, casillero.aplicarMultiplicadorDanioAUnidadDeEquipo(equipoEnemigoMock));
        verify(equipoMock).esIgualA(equipoEnemigoMock);
    }

    @Test
    public void CasilleroEstaALaDerechaDeOtroCasilleroDevuelveTrueSiElCasilleroSeEncuentraEnElPlanoDerechoDelOtroCasillero(){
        Equipo equipoMock = mock(Equipo.class);
        Casillero casilleroUno = new Casillero(5,6,equipoMock);
        Casillero casilleroDos = new Casillero(10,2,equipoMock);

        Assert.assertTrue(casilleroDos.estaALaDerechaDe(casilleroUno));
    }

    @Test
    public void CasilleroEstaALaDerechaDeOtroCasilleroDevuelveFalseSiElCasilleroNoSeSeEncuentraEnElPlanoDerechoDelOtroCasillero(){
        Equipo equipoMock = mock(Equipo.class);
        Casillero casilleroUno = new Casillero(5,6,equipoMock);
        Casillero casilleroDos = new Casillero(3,2,equipoMock);

        Assert.assertFalse(casilleroDos.estaALaDerechaDe(casilleroUno));
    }

    @Test
    public void CasilleroEstaArribaDeOtroCasilleroDevuelveTrueSiElCasilleroSeEncuentraEnElPlanoSuperiorDelOtroCasillero(){
        Equipo equipoMock = mock(Equipo.class);
        Casillero casilleroUno = new Casillero(5,6,equipoMock);
        Casillero casilleroDos = new Casillero(0,17,equipoMock);

        Assert.assertTrue(casilleroDos.estaArribaDe(casilleroUno));
    }

    @Test
    public void CasilleroEstaArribaDeOtroCasilleroDevuelveFalseSiElCasilleroNoSeSeEncuentraEnElPlanoDerechoDelOtroCasillero(){
        Equipo equipoMock = mock(Equipo.class);
        Casillero casilleroUno = new Casillero(5,6,equipoMock);
        Casillero casilleroDos = new Casillero(3,2,equipoMock);

        Assert.assertFalse(casilleroDos.estaArribaDe(casilleroUno));
    }

}