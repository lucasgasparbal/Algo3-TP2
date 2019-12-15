package AlgoChessTest.UnidadesTest;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import model.AlgoChess.Unidades.Batallon;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BatallonTest {

    @Test
    public void test01CreoBatallonVerticalLoMuevoHorizontalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {9,3};
        int[] coordenadasB = {9,4};
        int[] coordenadasC = {9,5};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado1.setTablero(tablero);
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado2.setTablero(tablero);
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        soldado3.setTablero(tablero);

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaDerecha();

        Assert.assertArrayEquals(new int[] {10,3}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {10,4}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {10,5}, soldado3.getPosicion());
        }

    @Test
    public void test02CreoBatallonHorizontalLoMuevoVerticalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {4,3};
        int[] coordenadasB = {6,3};
        int[] coordenadasC = {5,3};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado1.setTablero(tablero);
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado2.setTablero(tablero);
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        soldado3.setTablero(tablero);

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaArriba();

        Assert.assertArrayEquals(new int[] {4,4}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {6,4}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {5,4}, soldado3.getPosicion());
    }

    @Test
    public void test03CreoBatallonVerticalLoMuevoVerticalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {5,3};
        int[] coordenadasB = {5,4};
        int[] coordenadasC = {5,5};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado1.setTablero(tablero);
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado2.setTablero(tablero);
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        soldado3.setTablero(tablero);

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaArriba();

        Assert.assertArrayEquals(new int[] {5,4}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {5,5}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {5,6}, soldado3.getPosicion());
    }

    @Test
    public void test04CreoBatallonHorizontalLoMuevoHorizontalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {7,6};
        int[] coordenadasB = {8,6};
        int[] coordenadasC = {9,6};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado1.setTablero(tablero);
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado2.setTablero(tablero);
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        soldado3.setTablero(tablero);
        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaDerecha();

        Assert.assertArrayEquals(new int[] {8,6}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {9,6}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {10,6}, soldado3.getPosicion());
    }

    @Test
    public void test05CreoBatallonHorizontalLoDesplazoDosVecesEnDosDireccionesVerificoPosiciones() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {7,6};
        int[] coordenadasB = {8,6};
        int[] coordenadasC = {9,6};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado1.setTablero(tablero);
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado2.setTablero(tablero);
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        soldado3.setTablero(tablero);

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaDerecha();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaDerecha();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaArriba();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaArriba();

        Assert.assertArrayEquals(new int[] {9,8}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {10,8}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {11,8}, soldado3.getPosicion());
    }

    @Test
    public void test06AvanzoBatallonPeroDejoAtrasUnaPieza() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);
        Soldado soldado4 = new Soldado(equipoUno);

        int[] coordenadasA = {7,6};
        int[] coordenadasB = {8,6};
        int[] coordenadasC = {9,6};
        int[] coordenadasD = {8,8};

        tablero.inicializarUnidadEnCasillero(soldado1,coordenadasA);
        tablero.inicializarUnidadEnCasillero(soldado2,coordenadasB);
        tablero.inicializarUnidadEnCasillero(soldado3,coordenadasC);
        tablero.inicializarUnidadEnCasillero(soldado4,coordenadasD);

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaArriba();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaArriba();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaArriba();

        Assert.assertArrayEquals(new int[] {7,9}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {8,7}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {9,9}, soldado3.getPosicion());
    }

    @Test
    public void test07AvanzoBatallonPeroDejoAtrasUnaPiezaBatallonNoEsValido() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);
        Soldado soldado4 = new Soldado(equipoUno);

        int[] coordenadasA = {7,6};
        int[] coordenadasB = {8,6};
        int[] coordenadasC = {9,6};
        int[] coordenadasD = {8,8};

        tablero.inicializarUnidadEnCasillero(soldado1,coordenadasA);
        tablero.inicializarUnidadEnCasillero(soldado2,coordenadasB);
        tablero.inicializarUnidadEnCasillero(soldado3,coordenadasC);
        tablero.inicializarUnidadEnCasillero(soldado4,coordenadasD);

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaArriba();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaArriba();
        batallon.prepararTurno();
        batallon.desplazarBatallonHaciaArriba();

        Assert.assertFalse(batallon.esValido());
    }

    @Test(expected = BatallonNoSePuedeMoverExcepcion.class)
    public void BatallonDesplazarHaciaDerechaTodosMovimientosDeIntegrantesSonInvalidosLanzaExcepcion() throws MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        Batallon batallon = new Batallon();
        Soldado soldadoMockUno = mock(Soldado.class);
        Soldado soldadoMockDos = mock(Soldado.class);
        Soldado soldadoMockTres= mock(Soldado.class);
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockUno).desplazarConBatallonHaciaDerecha();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockDos).desplazarConBatallonHaciaDerecha();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockTres).desplazarConBatallonHaciaDerecha();

        batallon.agregarSoldado(soldadoMockUno);
        batallon.agregarSoldado(soldadoMockDos);
        batallon.agregarSoldado(soldadoMockTres);

        batallon.desplazarBatallonHaciaDerecha();
    }

    @Test(expected = BatallonNoSePuedeMoverExcepcion.class)
    public void BatallonDesplazarHaciaIzquierdaTodosMovimientosDeIntegrantesSonInvalidosLanzaExcepcion() throws MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        Batallon batallon = new Batallon();
        Soldado soldadoMockUno = mock(Soldado.class);
        Soldado soldadoMockDos = mock(Soldado.class);
        Soldado soldadoMockTres= mock(Soldado.class);
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockUno).desplazarConBatallonHaciaIzquierda();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockDos).desplazarConBatallonHaciaIzquierda();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockTres).desplazarConBatallonHaciaIzquierda();

        batallon.agregarSoldado(soldadoMockUno);
        batallon.agregarSoldado(soldadoMockDos);
        batallon.agregarSoldado(soldadoMockTres);

        batallon.desplazarBatallonHaciaIzquierda();
    }

    @Test(expected = BatallonNoSePuedeMoverExcepcion.class)
    public void BatallonDesplazarHaciaArribaTodosMovimientosDeIntegrantesSonInvalidosLanzaExcepcion() throws MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        Batallon batallon = new Batallon();
        Soldado soldadoMockUno = mock(Soldado.class);
        Soldado soldadoMockDos = mock(Soldado.class);
        Soldado soldadoMockTres= mock(Soldado.class);
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockUno).desplazarConBatallonHaciaArriba();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockDos).desplazarConBatallonHaciaArriba();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockTres).desplazarConBatallonHaciaArriba();

        batallon.agregarSoldado(soldadoMockUno);
        batallon.agregarSoldado(soldadoMockDos);
        batallon.agregarSoldado(soldadoMockTres);

        batallon.desplazarBatallonHaciaArriba();
    }

    @Test(expected = BatallonNoSePuedeMoverExcepcion.class)
    public void BatallonDesplazarHaciaAbajoTodosMovimientosDeIntegrantesSonInvalidosLanzaExcepcion() throws MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        Batallon batallon = new Batallon();
        Soldado soldadoMockUno = mock(Soldado.class);
        Soldado soldadoMockDos = mock(Soldado.class);
        Soldado soldadoMockTres= mock(Soldado.class);
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockUno).desplazarConBatallonHaciaAbajo();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockDos).desplazarConBatallonHaciaAbajo();
        doThrow(new MovimientoInvalidoExcepcion()).when(soldadoMockTres).desplazarConBatallonHaciaAbajo();

        batallon.agregarSoldado(soldadoMockUno);
        batallon.agregarSoldado(soldadoMockDos);
        batallon.agregarSoldado(soldadoMockTres);

        batallon.desplazarBatallonHaciaAbajo();
    }
}


