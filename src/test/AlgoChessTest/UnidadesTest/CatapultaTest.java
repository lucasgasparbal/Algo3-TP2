package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CatapultaTest {

    @Test
    public void atacoCincoVecesASoldadoMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        int i = 0;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);

        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);

        Catapulta catapulta = new Catapulta (equipoUnoMock);
        Soldado soldado = new Soldado (equipoDosMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        soldado.inicializarEnCasillero(casilleroMockDos);
        when(catapulta.esEnemigoDe(soldado)).thenReturn(true);

        while (i<10) {
            try {
                catapulta.atacar(soldado);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void atacoTresVecesACuranderoMurioDevuelveFalse() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        int i = 0;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);

        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);

        Catapulta catapulta = new Catapulta (equipoUnoMock);
        Curandero curandero = new Curandero (equipoDosMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        curandero.inicializarEnCasillero(casilleroMockDos);

        while (i<3) {
            try {
                catapulta.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuatroVecesACuranderoMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        int i = 0;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);

        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);

        Catapulta catapulta = new Catapulta (equipoUnoMock);
        Curandero curandero = new Curandero (equipoDosMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        curandero.inicializarEnCasillero(casilleroMockDos);
        when(catapulta.esEnemigoDe(curandero)).thenReturn(true);

        while (i<4) {
            try {
                catapulta.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void catapultaNoPuedeAtacarDirectamenteAUnaPiesaAliada() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        boolean seLanzoExcepcion = false;
        Equipo equipoMock = mock(Equipo.class);

        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);

        Catapulta catapulta = new Catapulta (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        curandero.inicializarEnCasillero(casilleroMockDos);
        when(catapulta.esEnemigoDe(curandero)).thenReturn(false);

            try {
                catapulta.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {seLanzoExcepcion = true;};

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void atacoAUnidadesCercanasACatapultaEnemigaMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        int i = 0;

        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);

        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        Catapulta catapultaAliada = new Catapulta(equipoUnoMock);
        Catapulta catapultaEnemiga = new Catapulta(equipoDosMock);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);
        when(catapultaAliada.esEnemigoDe(catapultaEnemiga)).thenReturn(true);

        catapultaAliada.inicializarEnCasillero(casilleroMockUno);
        catapultaEnemiga.inicializarEnCasillero(casilleroMockDos);

        while(i<4) {
            try {
                catapultaAliada.atacar(catapultaEnemiga);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertTrue(catapultaEnemiga.murio());
    }

    @Test
    public void CatapultaComprarDevuelveLosPuntosRestadosSiLosPuntosSonMayoresASuCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipo);

        Assert.assertEquals(15,catapulta.comprarConPuntos(20));
    }

    @Test (expected = NoAlcanzaOroExcepcion.class)
    public void CatapultaComprarLanzaExcepcionSiLosPuntosDadosSonMenoresAlCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipo);

        catapulta.comprarConPuntos(1);
    }
}
