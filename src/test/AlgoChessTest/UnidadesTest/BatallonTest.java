package AlgoChessTest.UnidadesTest;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import model.AlgoChess.Unidades.Batallon;
import org.junit.Assert;
import org.junit.Test;

public class BatallonTest {

    @Test
    public void test01CreoBatallonVerticalLoMuevoHorizontalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(9, 3));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9, 4));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 5));

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
    public void test02CreoBatallonHorizontalLoMuevoVerticalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(4, 3));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(6, 3));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(5, 3));

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
    public void test03CreoBatallonVerticalLoMuevoVerticalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(5, 3));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(5, 4));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(5, 5));

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
    public void test04CreoBatallonHorizontalLoMuevoHorizontalmente() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(7, 6));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(8, 6));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 6));

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
    public void test05CreoBatallonHorizontalLoDesplazoDosVecesEnDosDireccionesVerificoPosiciones() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(7, 6));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(8, 6));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 6));

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaDerecha();
        batallon.desplazarBatallonHaciaDerecha();
        batallon.desplazarBatallonHaciaArriba();
        batallon.desplazarBatallonHaciaArriba();

        Assert.assertArrayEquals(new int[] {9,8}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {10,8}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {11,8}, soldado3.getPosicion());
    }

    @Test
    public void test06AvanzoBatallonPeroDejoAtrasUnaPieza() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);
        Soldado soldado4 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(7, 6));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(8, 6));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 6));
        soldado4.inicializarEnCasillero(tablero.conseguirCasillero(8, 8));

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaArriba();
        batallon.desplazarBatallonHaciaArriba();
        batallon.desplazarBatallonHaciaArriba();

        Assert.assertArrayEquals(new int[] {7,9}, soldado1.getPosicion());
        Assert.assertArrayEquals(new int[] {8,7}, soldado2.getPosicion());
        Assert.assertArrayEquals(new int[] {9,9}, soldado3.getPosicion());
    }

    @Test
    public void test07AvanzoBatallonPeroDejoAtrasUnaPiezaBatallonNoEsValido() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);
        Soldado soldado4 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(7, 6));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(8, 6));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 6));
        soldado4.inicializarEnCasillero(tablero.conseguirCasillero(8, 8));

        Batallon batallon = new Batallon ();

        batallon.agregarSoldado (soldado1);
        batallon.agregarSoldado (soldado2);
        batallon.agregarSoldado (soldado3);

        batallon.desplazarBatallonHaciaArriba();
        batallon.desplazarBatallonHaciaArriba();
        batallon.desplazarBatallonHaciaArriba();

        Assert.assertFalse(batallon.esValido());
    }
}


