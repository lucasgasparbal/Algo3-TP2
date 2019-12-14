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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuranderoTest {

    @Test
    public void CuranderoCuraASoldadoHeridoSanaQuincePuntosDeVida() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, ObjetivoEsEnemigoExcepcion, NoSePudoCurarExcepcion, YaAtacoExcepcion, ObjetivoFueraDeRangoExcepcion {

        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Tablero tableroMock = mock(Tablero.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        Casillero casilleroMockTres = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockTres.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);
        when(casilleroMockDos.aplicarMultiplicadorDanioAUnidadDeEquipo(any(Equipo.class))).thenReturn(1.0);
        when(equipoDosMock.esIgualA(equipoDosMock)).thenReturn(true);
        int i=0;
        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );

        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado1.setTablero(tableroMock);
        soldado2.inicializarEnCasillero(casilleroMockDos);
        soldado2.setTablero(tableroMock);
        while (i<5){
        try {
            soldado1.prepararTurno();
            soldado1.atacar(soldado2);
        }
        catch (ObjetivoFueraDeRangoExcepcion | ObjetivoNoEsEnemigoExcepcion | YaAtacoExcepcion e) {}
        i++;
        }

        int vida_actual = soldado2.getVida();
        Curandero curandero = new Curandero (equipoDosMock );
        curandero.inicializarEnCasillero(casilleroMockTres);
        curandero.setTablero(tableroMock);

        when(soldado2.estaEnRangoCercanoDe(curandero)).thenReturn(true);
        curandero.atacar(soldado2);

        Assert.assertEquals(vida_actual+15,soldado2.getVida());
    }

    @Test
    public void CuranderoIntentaCurarACatapultaAliadaSaltaExcepcion() throws ObjetivoEsEnemigoExcepcion , NoSePudoCurarExcepcion {
        boolean seLanzoExcepcion = false;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta(equipoMock);
        Curandero curandero = new Curandero(equipoMock);
        when(curandero.esEnemigoDe(catapulta)).thenReturn(false);
        try {
            curandero.atacar(catapulta);
        }catch (ObjetivoEsEnemigoExcepcion | NoSePudoCurarExcepcion | YaAtacoExcepcion | ObjetivoFueraDeRangoExcepcion | CoordenadaFueraDeRangoExcepcion e){
            seLanzoExcepcion = true;
        }
        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test(expected = ObjetivoEsEnemigoExcepcion.class)
    public void CuranderoIntentaCurarACatapultaEnemigaSaltaExcepcion() throws NoSePudoCurarExcepcion, ObjetivoEsEnemigoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion, YaAtacoExcepcion {

        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroUno = mock(Casillero.class);
        Casillero casilleroDos = mock(Casillero.class);
        when(casilleroUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        Catapulta catapulta = new Catapulta(equipoUnoMock);
        Curandero curandero = new Curandero(equipoDosMock);
        catapulta.inicializarEnCasillero(casilleroUno);
        curandero.inicializarEnCasillero(casilleroDos);

            curandero.atacar(catapulta);
    }

    @Test
    public void CuranderoCuraASoldadoConVidaCompletaNoSanaMasDelMaximo() throws ObjetivoEsEnemigoExcepcion, NoSePudoCurarExcepcion, YaAtacoExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        Equipo equipoMock = mock(Equipo.class);
        when(equipoMock.esIgualA(equipoMock)).thenReturn(true);
        Casillero casilleroUno = mock(Casillero.class);
        Casillero casilleroDos = mock(Casillero.class);
        when(casilleroUno.perteneceAEquipo(equipoMock)).thenReturn(true);
        when(casilleroDos.perteneceAEquipo(equipoMock)).thenReturn(true);
        Soldado soldado = new Soldado (equipoMock );
        Curandero curandero = new Curandero (equipoMock);
        soldado.inicializarEnCasillero(casilleroUno);
        curandero.inicializarEnCasillero(casilleroDos);
        when(soldado.estaEnRangoCercanoDe(curandero)).thenReturn(true);

        int vida_actual = soldado.getVida();

        curandero.atacar(soldado);

        Assert.assertEquals(vida_actual,soldado.getVida());
    }

    @Test
    public void curanderoSeMueveHaciaArriba () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadas = {1,1};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);
        int[] posicionInicial = curandero.getPosicion();
        curandero.desplazarHaciaArriba();
        int[] posicionFinal = curandero.getPosicion();
        posicionInicial[1]= posicionInicial[1]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaArribaPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {19,19};

        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoDos);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);

        try {
            curandero.desplazarHaciaArriba();
        }
        catch (MovimientoInvalidoExcepcion | YaMovioExcepcion e) {
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

        int[] coordenadasA = {19,18};
        int[] coordenadasB = {19,19};

        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        tablero.inicializarUnidadEnCasillero(curanderoUno,coordenadasA);
        tablero.inicializarUnidadEnCasillero(curanderoDos,coordenadasB);
        try {
            curanderoUno.desplazarHaciaArriba();
        }
        catch (CasilleroOcupadoExcepcion | YaMovioExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoSeMueveHaciaAbajo () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);

        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);

        curandero.desplazarHaciaAbajo();
        int[] posicionFinal = curandero.getPosicion();
        int[] coordenadasEsperadas = {2,1};

        Assert.assertArrayEquals(coordenadasEsperadas, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaAbajoPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {0,0};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);
        try {
            curandero.desplazarHaciaAbajo();
        }
        catch (MovimientoInvalidoExcepcion | YaMovioExcepcion e) {
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

        int[] coordenadasA = {19,19};
        int[] coordenadasB = {19,18};

        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        tablero.inicializarUnidadEnCasillero(curanderoUno,coordenadasA);
        tablero.inicializarUnidadEnCasillero(curanderoDos,coordenadasB);
        try {
            curanderoUno.desplazarHaciaAbajo();
        }
        catch (CasilleroOcupadoExcepcion | YaMovioExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoSeMueveHaciaLaDerecha () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);

        curandero.desplazarHaciaDerecha();
        int[] posicionFinal = curandero.getPosicion();
        int[] posicionEsperada = {3,2};

        Assert.assertArrayEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaLaDerechaPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {19,0};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoUno);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);
        try {
            curandero.desplazarHaciaDerecha();
        }
        catch (MovimientoInvalidoExcepcion | YaMovioExcepcion e) {
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
        int[] coordenadasA = {18,19};
        int[] coordenadasB ={19,19};
        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        tablero.inicializarUnidadEnCasillero(curanderoUno,coordenadasA);
        tablero.inicializarUnidadEnCasillero(curanderoDos,coordenadasB);
        try {
            curanderoUno.desplazarHaciaDerecha();
        }
        catch (CasilleroOcupadoExcepcion | YaMovioExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoSeMueveHaciaLaIzquierda () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {2,2};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoUno);

        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);
        curandero.desplazarHaciaIzquierda();
        int[] posicionFinal = curandero.getPosicion();
        int[] posicionEsperada = {1,2};

        Assert.assertArrayEquals(posicionEsperada, posicionFinal);
    }

    @Test
    public void curanderoIntentaMoverseParaLaIzquierdaPeroSeSaleDelTablero () throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadas = {0,19};
        Casillero casillero = tablero.conseguirCasillero(coordenadas);
        Curandero curandero = new Curandero (equipoDos);
        curandero.inicializarEnCasillero(casillero);
        curandero.setTablero(tablero);
        try {
            curandero.desplazarHaciaIzquierda();
        }
        catch (MovimientoInvalidoExcepcion | YaMovioExcepcion e) {
            seLanzoExcepcion = true;
        }

        Assert.assertTrue(seLanzoExcepcion);
    }

    @Test
    public void curanderoIntentaMoverseParaLaIzquierdaPeroEstabaOcupadoElCasillero () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        boolean seLanzoExcepcion = false;
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        int[] coordenadasA = {19,19};
        int[] coordenadasB ={18,19};
        Curandero curanderoUno = new Curandero (equipoDos);
        Curandero curanderoDos = new Curandero (equipoDos);
        tablero.inicializarUnidadEnCasillero(curanderoUno,coordenadasA);
        tablero.inicializarUnidadEnCasillero(curanderoDos,coordenadasB);
        try {
            curanderoUno.desplazarHaciaIzquierda();
        }
        catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
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
