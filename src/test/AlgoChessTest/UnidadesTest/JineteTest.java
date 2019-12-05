package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JineteTest {

    @Test
    public void atacoCuranderoCatorceVecesMurioDevuelveFalse() throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        int i = 0;

        Jinete jinete = new Jinete (equipoUnoMock);
        Curandero curandero = new Curandero (equipoDosMock);
        jinete.inicializarEnCasillero(casilleroMockUno);
        curandero.inicializarEnCasillero(casilleroMockDos);
        while (i<14) {
            try {
                jinete.atacar(curandero);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {};
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuranderoQuinceVecesMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);
        int i = 0;

        Jinete jinete = new Jinete (equipoUnoMock);
        Curandero curandero = new Curandero (equipoDosMock);
        jinete.inicializarEnCasillero(casilleroMockUno);
        curandero.inicializarEnCasillero(casilleroMockDos);
        while (i<15) {
            try {
                jinete.atacar(curandero);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {};
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoSoldadoVeinteVecesMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        int i = 0;
        Jinete jinete = new Jinete (equipoUno);
        Soldado soldado = new Soldado (equipoDos);
        Tablero tablero = new Tablero (equipoUno,equipoDos);
        int[] coordenadasA = {10,10};
        int[] coordenadasB = {9,9};
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        while (i<20) {
            try {
                jinete.atacar(soldado);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {};
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void JineteAtacaPiezaConEnemigoCercaUsaEspada() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado1 = new Soldado(equipoDos);
        Soldado soldado2 = new Soldado(equipoDos);
        Jinete jinete = new Jinete(equipoUno);
        int[] coordenadasA = {10,10};
        int[] coordenadasB = {10,11};
        int[] coordenadasC = {9,9};
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        int i =0;
        while (i<19) {
            try {
                jinete.atacar(soldado1);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {}
            i++;
        }
        Assert.assertFalse(soldado1.murio());
        jinete.atacar(soldado1);
        Assert.assertTrue(soldado1.murio());
    }

    @Test
    public void JineteAtacaPiezaCoAliadoCercaUsaEspada() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoDos);
        Soldado soldado2 = new Soldado(equipoUno);
        Jinete jinete = new Jinete (equipoUno);
        int[] coordenadasA = {10,10};
        int[] coordenadasB = {10,9};
        int[] coordenadasC = {9,9};
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        int i = 0;
        while (i < 19) {
            try {
                jinete.atacar(soldado1);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {}
            i++;
        }
        Assert.assertFalse(soldado1.murio());
        jinete.atacar(soldado1);
        Assert.assertTrue(soldado1.murio());
    }

    @Test
    public void JineteTieneAliadoCercaYEnemigoADistanciaMediaNoPuedeAtacarExcepcion() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoDos);
        Soldado soldado2 = new Soldado(equipoUno);
        Jinete jinete = new Jinete (equipoUno);
        int[] coordenadasA = {10,10};
        int[] coordenadasB = {10,9};
        int[] coordeandasC = {9,9};
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(coordeandasC));
        boolean seLanzaExcepcion = false;
        try {
            jinete.atacar(soldado1);
        }
        catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {
            seLanzaExcepcion = true;
        }
    }

    @Test
    public void jineteSeMueveHaciaArriba () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {1,1};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaArriba();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[1]= posicionInicial[1]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaArribaPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {19,19};

        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoDos);
        jinete.inicializarEnCasillero(casillero);
        try {
            jinete.desplazarHaciaArriba();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteIntentaMoverseParaArribaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,18};
        int[] coordenadasB = {19,19};

        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Jinete jineteUno = new Jinete (equipoDos);
        Jinete jineteDos = new Jinete (equipoDos);
        jineteUno.inicializarEnCasillero(casilleroUno);
        jineteDos.inicializarEnCasillero(casilleroDos);
        try {
            jineteUno.desplazarHaciaArriba();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteSeMueveHaciaAbajo () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaAbajo();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[1]= posicionInicial[1]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaAbajoPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {0,0};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        try {
            jinete.desplazarHaciaAbajo();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteIntentaMoverseParaAbajoPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,19};
        int[] coordenadasB = {19,18};

        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Jinete jineteUno = new Jinete (equipoDos);
        Jinete jineteDos = new Jinete (equipoDos);
        jineteUno.inicializarEnCasillero(casilleroUno);
        jineteDos.inicializarEnCasillero(casilleroDos);
        try {
            jineteUno.desplazarHaciaAbajo();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteSeMueveHaciaLaDerecha () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaDerecha();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[0]= posicionInicial[0]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaLaDerechaPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {19,0};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        try {
            jinete.desplazarHaciaDerecha();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteIntentaMoverseParaLaDerechaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {18,19};
        int[] coordenadasB ={19,19};
        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Jinete jineteUno = new Jinete (equipoDos);
        Jinete jineteDos = new Jinete (equipoDos);
        jineteUno.inicializarEnCasillero(casilleroUno);
        jineteDos.inicializarEnCasillero(casilleroDos);
        try {
            jineteUno.desplazarHaciaDerecha();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteSeMueveHaciaLaIzquierda () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaIzquierda();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[0]= posicionInicial[0]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaLaIzquierdaPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {0,19};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Jinete jinete = new Jinete (equipoDos);
        jinete.inicializarEnCasillero(casillero);
        try {
            jinete.desplazarHaciaIzquierda();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void jineteIntentaMoverseParaLaIzquierdaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,19};
        int[] coordenadasB ={18,19};
        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Jinete jineteUno = new Jinete (equipoDos);
        Jinete jineteDos = new Jinete (equipoDos);
        jineteUno.inicializarEnCasillero(casilleroUno);
        jineteDos.inicializarEnCasillero(casilleroDos);
        try {
            jineteUno.desplazarHaciaIzquierda();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void JineteComprarDevuelveLosPuntosRestadosSiLosPuntosSonMayoresASuCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Jinete jinete = new Jinete(equipo);

        Assert.assertEquals(17,jinete.comprarConPuntos(20));
    }

    @Test (expected = NoAlcanzaOroExcepcion.class)
    public void JineteComprarLanzaExcepcionSiLosPuntosDadosSonMenoresAlCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Jinete jinete = new Jinete(equipo);

        jinete.comprarConPuntos(1);
    }

}


