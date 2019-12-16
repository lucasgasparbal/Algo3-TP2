package AlgoChessTest.UnidadesTest;

import javafx.scene.control.Tab;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Tablero.DiccionarioCasilleroUnidad;
import model.AlgoChess.Unidades.*;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CatapultaTest {

    @Test
    public void atacoCincoVecesASoldadoMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, YaAtacoExcepcion {
        int i = 0;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        ColeccionUnidades coleccionUnidadesMock = mock(ColeccionUnidades.class);
        Tablero tableroMock = mock(Tablero.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);
        when(casilleroMockDos.aplicarMultiplicadorDanioAUnidadDeEquipo(any(Equipo.class))).thenReturn(1.0);

        Catapulta catapulta = new Catapulta (equipoUnoMock);
        catapulta.setTablero(tableroMock);
        Soldado soldado = new Soldado (equipoDosMock);
        soldado.setTablero(tableroMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        soldado.inicializarEnCasillero(casilleroMockDos);

        when(tableroMock.obtenerUnidadesConexasA(any(Unidad.class))).thenReturn(coleccionUnidadesMock);

        while (i<10) {
            catapulta.prepararTurno();
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
        Tablero tableroMock = mock(Tablero.class);
        ColeccionUnidades coleccionUnidadesMock = mock(ColeccionUnidades.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);

        Catapulta catapulta = new Catapulta (equipoUnoMock);
        Curandero curandero = new Curandero (equipoDosMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        catapulta.setTablero(tableroMock);
        curandero.inicializarEnCasillero(casilleroMockDos);
        curandero.setTablero(tableroMock);

        when(tableroMock.obtenerUnidadesConexasA(any(Unidad.class))).thenReturn(coleccionUnidadesMock);

        while (i<3) {
            try {
                catapulta.atacar(curandero);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion | YaAtacoExcepcion e) {}
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuatroVecesACuranderoMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, YaAtacoExcepcion {
        int i = 0;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);

        Tablero tableroMock = mock(Tablero.class);
        ColeccionUnidades coleccionUnidadesMock = mock(ColeccionUnidades.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);

        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoLejanoDe(casilleroMockUno)).thenReturn(true);
        when(casilleroMockDos.aplicarMultiplicadorDanioAUnidadDeEquipo(any(Equipo.class))).thenReturn(1.0);

        Catapulta catapulta = new Catapulta (equipoUnoMock);
        Curandero curandero = new Curandero (equipoDosMock);
        catapulta.inicializarEnCasillero(casilleroMockUno);
        catapulta.setTablero(tableroMock);
        curandero.inicializarEnCasillero(casilleroMockDos);
        curandero.setTablero(tableroMock);

        when(tableroMock.obtenerUnidadesConexasA(any(Unidad.class))).thenReturn(coleccionUnidadesMock);

        while (i<4) {
            catapulta.prepararTurno();
            catapulta.atacar(curandero);
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoAUnidadesCercanasACatapultaEnemigaMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, YaAtacoExcepcion {
        int i = 0;

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadasA = {1,1};
        int[] coordenadasB = {19,19};
        int[] coordenadasC = {18,19};

        Catapulta catapultaAliada = new Catapulta(equipoUno);
        Catapulta catapultaEnemiga = new Catapulta(equipoDos);
        Soldado soldadoEnemigo = new Soldado (equipoDos);

        tablero.inicializarUnidadEnCasillero(catapultaAliada,coordenadasA);
        tablero.inicializarUnidadEnCasillero(catapultaEnemiga,coordenadasB);
        tablero.inicializarUnidadEnCasillero(soldadoEnemigo,coordenadasC);

        while(i<6) {
            catapultaAliada.prepararTurno();
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

    @Test(expected = CatapultaNoSePuedeMoverExcepcion.class)
    public void CatapultaDesplazarHaciaIzquierdaLanzaExcepcion() throws CatapultaNoSePuedeMoverExcepcion{
        Equipo equipo = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipo);

        catapulta.desplazarHaciaIzquierda();
    }

    @Test(expected = CatapultaNoSePuedeMoverExcepcion.class)
    public void CatapultaDesplazarHaciaArribaLanzaExcepcion() throws CatapultaNoSePuedeMoverExcepcion{
        Equipo equipo = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipo);

        catapulta.desplazarHaciaArriba();
    }

    @Test(expected = CatapultaNoSePuedeMoverExcepcion.class)
    public void CatapultaDesplazarHaciaAbajoLanzaExcepcion() throws CatapultaNoSePuedeMoverExcepcion{
        Equipo equipo = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipo);

        catapulta.desplazarHaciaAbajo();
    }

    @Test(expected = CatapultaNoSePuedeMoverExcepcion.class)
    public void CatapultaDesplazarHaciaDerechaLanzaExcepcion() throws CatapultaNoSePuedeMoverExcepcion{
        Equipo equipo = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipo);

        catapulta.desplazarHaciaDerecha();
    }

    @Test (expected =  YaAtacoExcepcion.class)
    public void catapultaAtacaDosVecesSaltaExcepcion () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, YaAtacoExcepcion, ObjetivoNoEsEnemigoExcepcion, ObjetivoFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadasA = {1,1};
        int[] coordenadasB = {19,19};

        Catapulta catapultaAliada = new Catapulta(equipoUno);
        Soldado soldadoEnemigo = new Soldado (equipoDos);

        tablero.inicializarUnidadEnCasillero(catapultaAliada,coordenadasA);
        tablero.inicializarUnidadEnCasillero(soldadoEnemigo,coordenadasB);

        catapultaAliada.atacar(soldadoEnemigo);
        catapultaAliada.atacar(soldadoEnemigo);
    }
}
