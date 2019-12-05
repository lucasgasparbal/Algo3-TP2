package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SoldadoTest {



    @Test
    public void sufreDanioLetalMurioDevuelveTrue () {
        Equipo equipoMock = mock(Equipo.class);
        Soldado soldado = new Soldado (equipoMock);
        soldado.sufrirDanio(101);
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void sufreDanioNoLetalMurioDevuelveFalse () {
        Equipo equipoMock = mock(Equipo.class);
        Soldado soldado = new Soldado (equipoMock);
        soldado.sufrirDanio(59);
        Assert.assertFalse (soldado.murio());
    }

    @Test
    public void soldadoAtacaAOtroUnaVezMurioDevuelveFalse () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);

        int i=0;
        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );
        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado2.inicializarEnCasillero(casilleroMockDos);
       try {
           soldado1.atacar(soldado2);
       }
       catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {}
        Assert.assertFalse (soldado2.murio());
    }

    @Test
    public void soldadoAtacaAOtroDiezVecesMurioDevuelveTrue () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);

        int i=0;
        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );
        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado2.inicializarEnCasillero(casilleroMockDos);
        while (i<10) {
            try {
                soldado1.atacar(soldado2);
            }
            catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion e) {}
            i++;
        }
        Assert.assertTrue (soldado2.murio());
    }

    @Test
    public void soldadoSeMueveHaciaArriba () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {1,1};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoUno);
        soldado.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado.getPosicion();
        soldado.desplazarHaciaArriba();
        int[] posicionFinal = soldado.getPosicion();
        posicionInicial[1]= posicionInicial[1]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoIntentaMoverseParaArribaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {19,19};

        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoDos);
        soldado.inicializarEnCasillero(casillero);
        try {
            soldado.desplazarHaciaArriba();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoIntentaMoverseParaArribaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,18};
        int[] coordenadasB = {19,19};

        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Soldado soldadoUno = new Soldado (equipoDos);
        Soldado soldadoDos = new Soldado (equipoDos);
        soldadoUno.inicializarEnCasillero(casilleroUno);
        soldadoDos.inicializarEnCasillero(casilleroDos);
        try {
            soldadoUno.desplazarHaciaArriba();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoSeMueveHaciaAbajo () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoUno);
        soldado.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado.getPosicion();
        soldado.desplazarHaciaAbajo();
        int[] posicionFinal = soldado.getPosicion();
        posicionInicial[1]= posicionInicial[1]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoIntentaMoverseParaAbajoPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {0,0};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoUno);
        soldado.inicializarEnCasillero(casillero);
        try {
            soldado.desplazarHaciaAbajo();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoIntentaMoverseParaAbajoPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,19};
        int[] coordenadasB = {19,18};

        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Soldado soldadoUno = new Soldado (equipoDos);
        Soldado soldadoDos = new Soldado (equipoDos);
        soldadoUno.inicializarEnCasillero(casilleroUno);
        soldadoDos.inicializarEnCasillero(casilleroDos);
        try {
            soldadoUno.desplazarHaciaAbajo();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoSeMueveHaciaLaDerecha () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoUno);
        soldado.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado.getPosicion();
        soldado.desplazarHaciaDerecha();
        int[] posicionFinal = soldado.getPosicion();
        posicionInicial[0]= posicionInicial[0]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoIntentaMoverseParaLaDerechaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {19,0};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoDos);
        soldado.inicializarEnCasillero(casillero);
        try {
            soldado.desplazarHaciaDerecha();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoIntentaMoverseParaLaDerechaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {18,19};
        int[] coordenadasB ={19,19};
        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Soldado soldadoUno = new Soldado (equipoDos);
        Soldado soldadoDos = new Soldado (equipoDos);
        soldadoUno.inicializarEnCasillero(casilleroUno);
        soldadoDos.inicializarEnCasillero(casilleroDos);
        try {
            soldadoUno.desplazarHaciaDerecha();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoSeMueveHaciaLaIzquierda () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoUno);
        soldado.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado.getPosicion();
        soldado.desplazarHaciaIzquierda();
        int[] posicionFinal = soldado.getPosicion();
        posicionInicial[0]= posicionInicial[0]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoIntentaMoverseParaLaIzquierdaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {0,19};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Soldado soldado = new Soldado (equipoUno);
        soldado.inicializarEnCasillero(casillero);
        try {
            soldado.desplazarHaciaIzquierda();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void soldadoIntentaMoverseParaLaIzquierdaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,19};
        int[] coordenadasB ={18,19};
        Casillero casilleroUno = tablero.conseguirCasillero(coordenadasA);
        Casillero casilleroDos = tablero.conseguirCasillero(coordenadasB);
        Soldado soldadoUno = new Soldado (equipoDos);
        Soldado soldadoDos = new Soldado (equipoDos);
        soldadoUno.inicializarEnCasillero(casilleroUno);
        soldadoDos.inicializarEnCasillero(casilleroDos);
        try {
            soldadoUno.desplazarHaciaIzquierda();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void SoldadoComprarDevuelveLosPuntosRestadosSiLosPuntosSonMayoresASuCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Soldado soldado = new Soldado(equipo);

        Assert.assertEquals(19,soldado.comprarConPuntos(20));
    }

    @Test (expected = NoAlcanzaOroExcepcion.class)
    public void SoldadoComprarLanzaExcepcionSiLosPuntosDadosSonMenoresAlCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Soldado soldado = new Soldado(equipo);

        soldado.comprarConPuntos(0);
    }

    @Test
    public void SoldadoEsEnemigoDeDevuelveTrueConUnaUnidadQueNoPertenezcaASuEquipo(){
        Equipo equipoUno = mock(Equipo.class);
        Equipo equipoDos = mock(Equipo.class);
        when(equipoUno.esIgualA(equipoDos)).thenReturn(false);
        Soldado soldadoUno = new Soldado(equipoUno);
        Soldado soldadoDos = new Soldado(equipoDos);

        Assert.assertTrue(soldadoUno.esEnemigoDe(soldadoDos));
    }

    @Test
    public void SoldadoEsEnemigoDeDevuelveFalseConUnaUnidadPertenecienteASuEquipo(){
        Equipo equipoUno = mock(Equipo.class);
        when(equipoUno.esIgualA(equipoUno)).thenReturn(true);
        Soldado soldadoUno = new Soldado(equipoUno);
        Soldado soldadoDos = new Soldado(equipoUno);

        Assert.assertFalse(soldadoUno.esEnemigoDe(soldadoDos));
    }

}






