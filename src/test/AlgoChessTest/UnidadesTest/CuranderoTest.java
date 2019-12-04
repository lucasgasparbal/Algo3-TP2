package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuranderoTest {

    @Test
    public void CuranderoNoPuedeCurarAUnaPiesaEnemiga() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        boolean seLanzoExcepcion = false;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);

        Soldado soldado = new Soldado (equipoUnoMock );
        Curandero curandero = new Curandero (equipoDosMock );
        when(curandero.esEnemigoDe(soldado)).thenReturn(true);
        try{
            curandero.atacar(soldado);
        }catch (NoSePudoAtacarExcepcion e){seLanzoExcepcion = true;}

        Assert.assertTrue(seLanzoExcepcion);
    }
    @Test
    public void CuranderoCuraASoldadoHeridoSanaQuincePuntosDeVida() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        int i=0;
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);

        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );
        Curandero curandero = new Curandero (equipoDosMock );

        when(soldado1.esEnemigoDe(soldado2)).thenReturn(true);

        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado2.inicializarEnCasillero(casilleroMockDos);
        while (i<5){
        try {
            soldado1.atacar(soldado2);
        }
        catch (NoSePudoAtacarExcepcion e) {}
        i++;
        }

        int vida_actual = soldado2.getVida();
        curandero.atacar(soldado2);

        Assert.assertEquals(vida_actual+15,soldado2.getVida());
    }

    @Test
    public void CuranderoCuraASoldadoConVidaCompletaNoSanaMasDelMaximo() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {

        Equipo equipoDosMock = mock(Equipo.class);

        int i=0;
        Soldado soldado2 = new Soldado (equipoDosMock );

        int vida_actual = soldado2.getVida();
        Curandero curandero = new Curandero (equipoDosMock );
        curandero.atacar(soldado2);

        Assert.assertEquals(vida_actual,soldado2.getVida());
    }

    @Test
    public void curanderoSeMueveHaciaArriba () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(1,1);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        int[] posicionInicial = curandero.getPosicion();
        curandero.desplazarHaciaArriba();
        int[] posicionFinal = curandero.getPosicion();
        posicionInicial[1]= posicionInicial[1]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaArribaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(19,19);
        Curandero curandero = new Curandero (equipoDos);
        curandero.inicializarEnCasillero(casillero);
        try {
            curandero.desplazarHaciaArriba();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoIntentaMoverseParaArribaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casilleroUno = tablero.conseguirCasillero(19,18);
        Casillero casilleroDos = tablero.conseguirCasillero(19,19);
        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        curanderoUno.inicializarEnCasillero(casilleroUno);
        curanderoDos.inicializarEnCasillero(casilleroDos);
        try {
            curanderoUno.desplazarHaciaArriba();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoSeMueveHaciaAbajo () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(2,2);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        int[] posicionInicial = curandero.getPosicion();
        curandero.desplazarHaciaAbajo();
        int[] posicionFinal = curandero.getPosicion();
        posicionInicial[1]= posicionInicial[1]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaAbajoPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(0,0);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        try {
            curandero.desplazarHaciaAbajo();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoIntentaMoverseParaAbajoPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casilleroUno = tablero.conseguirCasillero(19,19);
        Casillero casilleroDos = tablero.conseguirCasillero(19,18);
        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        curanderoUno.inicializarEnCasillero(casilleroUno);
        curanderoDos.inicializarEnCasillero(casilleroDos);
        try {
            curanderoUno.desplazarHaciaAbajo();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoSeMueveHaciaLaDerecha () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(2,2);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        int[] posicionInicial = curandero.getPosicion();
        curandero.desplazarHaciaDerecha();
        int[] posicionFinal = curandero.getPosicion();
        posicionInicial[0]= posicionInicial[0]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaLaDerechaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(19,0);
        Curandero curandero = new Curandero (equipoDos);
        curandero.inicializarEnCasillero(casillero);
        try {
            curandero.desplazarHaciaDerecha();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoIntentaMoverseParaLaDerechaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casilleroUno = tablero.conseguirCasillero(18,19);
        Casillero casilleroDos = tablero.conseguirCasillero(19,19);
        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        curanderoUno.inicializarEnCasillero(casilleroUno);
        curanderoDos.inicializarEnCasillero(casilleroDos);
        try {
            curanderoUno.desplazarHaciaDerecha();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoSeMueveHaciaLaIzquierda () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(2,2);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        int[] posicionInicial = curandero.getPosicion();
        curandero.desplazarHaciaIzquierda();
        int[] posicionFinal = curandero.getPosicion();
        posicionInicial[0]= posicionInicial[0]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaLaIzquierdaPeroSeSaleDelTablero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = tablero.conseguirCasillero(0,19);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        try {
            curandero.desplazarHaciaIzquierda();
        }
        catch (MovimientoInvalidoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoIntentaMoverseParaLaIzquierdaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casilleroUno = tablero.conseguirCasillero(19,19);
        Casillero casilleroDos = tablero.conseguirCasillero(18,19);
        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        curanderoUno.inicializarEnCasillero(casilleroUno);
        curanderoDos.inicializarEnCasillero(casilleroDos);
        try {
            curanderoUno.desplazarHaciaIzquierda();
        }
        catch (CasilleroOcupadoExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void CuranderoComprarDevuelveLosPuntosRestadosSiLosPuntosSonMayoresASuCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Curandero curandero = new Curandero(equipo);

        Assert.assertEquals(18,curandero.comprarConPuntos(20));
    }

    @Test (expected = NoAlcanzaOroExcepcion.class)
    public void CuranderoComprarLanzaExcepcionSiLosPuntosDadosSonMenoresAlCosto() throws NoAlcanzaOroExcepcion {
        Equipo equipo = mock(Equipo.class);
        Curandero curandero = new Curandero(equipo);

        curandero.comprarConPuntos(1);
    }

}
