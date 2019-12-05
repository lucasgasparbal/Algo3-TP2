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
    public void atacoCincoVecesASoldadoMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion {
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

        while (i<10) {
                catapulta.atacar(soldado);
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void atacoTresVecesACuranderoMurioDevuelveFalse() throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
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
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion | NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuatroVecesACuranderoMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion {
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

        while (i<4) {
                catapulta.atacar(curandero);
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoAUnidadesCercanasACatapultaEnemigaMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion {
        int i = 0;

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadasA = {1,1};
        int[] coordenadasB = {19,19};
        int[] coordenadasC = {18,19};
        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Casillero casilleroTres = tablero.conseguirCasillero(coordenadasC);

        Catapulta catapultaAliada = new Catapulta(equipoUno);
        Catapulta catapultaEnemiga = new Catapulta(equipoDos);
        Soldado soldadoEnemigo = new Soldado (equipoDos);

        catapultaAliada.inicializarEnCasillero(casilleroUno);
        catapultaEnemiga.inicializarEnCasillero(casilleroDos);
        soldadoEnemigo.inicializarEnCasillero(casilleroTres);

        while(i<6) {
            catapultaAliada.atacar(soldadoEnemigo);
            i++;
        }
        Assert.assertTrue(soldadoEnemigo.murio());
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
