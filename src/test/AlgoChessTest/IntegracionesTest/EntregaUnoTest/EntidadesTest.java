package AlgoChessTest.IntegracionesTest.EntregaUnoTest;

import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class EntidadesTest {

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaVerificoPosicion() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(equipoNegro);
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaIzquierda();
        Assert.assertArrayEquals(new int[] {9,10}, soldado.getPosicion());

    }



    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void intentoDesplazarPiezaACasilleroOcupadoLanzaCasilleroOcupadoExcepcion () throws CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero();
        Soldado soldadoUno = new Soldado(equipoNegro);
        Soldado soldadoDos = new Soldado(equipoBlanco);

        soldadoUno.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldadoDos.inicializarEnCasillero(tablero.conseguirCasillero(9,10));


        //Exception throw
        soldadoUno.desplazarHaciaIzquierda();
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaYDerechaVerificoPosicion() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero();
        Soldado unidadMovible = new Soldado(equipoNegro);

        unidadMovible.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        unidadMovible.desplazarHaciaIzquierda();
        unidadMovible.desplazarHaciaDerecha();

        Assert.assertArrayEquals(new int[] {10,10}, unidadMovible.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaArribaSeMueveHaciaArriba() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(equipoNegro);

        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaArriba();

        Assert.assertArrayEquals(new int[] {10,11}, soldado.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaAbajoSeMueveHaciaAbajo() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion {

        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(equipoNegro);

        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaAbajo();

        Assert.assertArrayEquals(new int[] {10,9}, soldado.getPosicion());
    }

    @Test
    public void desplazoPiezaEnLasCuatroDirecciones() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion{
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado(equipoBlanco);

        soldado.inicializarEnCasillero(tablero.conseguirCasillero(4,5));
        soldado.desplazarHaciaArriba();
        soldado.desplazarHaciaArriba();
        soldado.desplazarHaciaDerecha();
        soldado.desplazarHaciaDerecha();
        soldado.desplazarHaciaDerecha();
        soldado.desplazarHaciaAbajo();
        soldado.desplazarHaciaIzquierda();

        Assert.assertArrayEquals(new int[] {6,6}, soldado.getPosicion());
    }
}
