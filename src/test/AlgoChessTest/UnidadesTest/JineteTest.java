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
    public void atacoCuranderoCatorceVecesMurioDevuelveFalse() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
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
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuranderoQuinceVecesMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
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
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoSoldadoVeinteVecesMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        int i = 0;
        Jinete jinete = new Jinete (equipoUno);
        Soldado soldado = new Soldado (equipoDos);
        Tablero tablero = new Tablero (equipoUno,equipoDos);
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        while (i<20) {
            try {
                jinete.atacar(soldado);
            }
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void JineteAtacaPiezaConEnemigoCercaUsaEspada() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, NoSePudoAtacarExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoDos);
        Soldado soldado2 = new Soldado(equipoDos);
        Jinete jinete = new Jinete (equipoUno);
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(10,11));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9,10));
        int i =0;
        while (i<19) {
            try {
                jinete.atacar(soldado1);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(soldado1.murio());
        jinete.atacar(soldado1);
        Assert.assertTrue(soldado1.murio());
    }

    @Test
    public void JineteAtacaPiezaCoAliadoCercaUsaEspada() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, NoSePudoAtacarExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoDos);
        Soldado soldado2 = new Soldado(equipoUno);
        Jinete jinete = new Jinete (equipoUno);
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10, 10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9, 11));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9, 10));
        int i = 0;
        while (i < 19) {
            try {
                jinete.atacar(soldado1);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(soldado1.murio());
        jinete.atacar(soldado1);
        Assert.assertTrue(soldado1.murio());
    }

    @Test
    public void JineteTieneAliadoCercaYEnemigoADistanciaMediaNoPuedeAtacarExcepcion() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, NoSePudoAtacarExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        equipoDos.establecerEquipoEnemigo(equipoUno);
        equipoUno.establecerEquipoEnemigo(equipoDos);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoDos);
        Soldado soldado2 = new Soldado(equipoUno);
        Jinete jinete = new Jinete (equipoUno);
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9,10));
        boolean seLanzaExcepcion = false;
        try {
            jinete.atacar(soldado1);
        }
        catch (NoSePudoAtacarExcepcion e) {
            seLanzaExcepcion = true;
        }
    }

    @Test
    public void jineteSeMueveHaciaArriba () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(1,1);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaArriba();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[1]= posicionInicial[1]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaArribaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(19,19);
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
        Casillero casilleroUno = tablero.conseguirCasillero(19,18);
        Casillero casilleroDos = tablero.conseguirCasillero(19,19);
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
        Casillero casillero = tablero.conseguirCasillero(2,2);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaAbajo();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[1]= posicionInicial[1]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaAbajoPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(0,0);
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
        Casillero casilleroUno = tablero.conseguirCasillero(19,19);
        Casillero casilleroDos = tablero.conseguirCasillero(19,18);
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
        Casillero casillero = tablero.conseguirCasillero(2,2);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaDerecha();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[0]= posicionInicial[0]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaLaDerechaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(19,0);
        Jinete jinete = new Jinete (equipoDos);
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
        Casillero casilleroUno = tablero.conseguirCasillero(18,19);
        Casillero casilleroDos = tablero.conseguirCasillero(19,19);
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
        Casillero casillero = tablero.conseguirCasillero(2,2);
        Jinete jinete = new Jinete (equipoUno);
        jinete.inicializarEnCasillero(casillero);
        int[] posicionInicial = jinete.getPosicion();
        jinete.desplazarHaciaIzquierda();
        int[] posicionFinal = jinete.getPosicion();
        posicionInicial[0]= posicionInicial[0]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void jineteIntentaMoverseParaLaIzquierdaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(0,19);
        Jinete jinete = new Jinete (equipoUno);
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
        Casillero casilleroUno = tablero.conseguirCasillero(19,19);
        Casillero casilleroDos = tablero.conseguirCasillero(18,19);
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

}


