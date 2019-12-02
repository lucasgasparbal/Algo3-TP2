package AlgoChessTest.IntegracionesTest.EntregaUnoTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class EntidadesTest {

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaVerificoPosicion() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoDos);
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaIzquierda();
        Assert.assertArrayEquals(new int[] {9,10}, soldado.getPosicion());

    }



    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void intentoDesplazarPiezaACasilleroOcupadoLanzaCasilleroOcupadoExcepcion () throws CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldadoUno = new Soldado(equipoDos);
        Soldado soldadoDos = new Soldado(equipoUno);

        soldadoUno.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldadoDos.inicializarEnCasillero(tablero.conseguirCasillero(9,10));


        //Exception throw
        soldadoUno.desplazarHaciaIzquierda();
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaYDerechaVerificoPosicion() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado unidadMovible = new Soldado(equipoDos);

        unidadMovible.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        unidadMovible.desplazarHaciaIzquierda();
        unidadMovible.desplazarHaciaDerecha();

        Assert.assertArrayEquals(new int[] {10,10}, unidadMovible.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaArribaSeMueveHaciaArriba() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoDos);

        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaArriba();

        Assert.assertArrayEquals(new int[] {10,11}, soldado.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaAbajoSeMueveHaciaAbajo() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion {

        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoDos);

        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaAbajo();

        Assert.assertArrayEquals(new int[] {10,9}, soldado.getPosicion());
    }

    @Test
    public void desplazoPiezaEnLasCuatroDirecciones() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion{
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoUno);

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
