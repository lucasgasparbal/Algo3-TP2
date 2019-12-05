package AlgoChessTest.IntegracionesTest.EntregaUnoTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class EntidadesTest {

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaVerificoPosicion() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoDos);
        int[] coordenadasA = {10 , 10};
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado.desplazarHaciaIzquierda();
        Assert.assertArrayEquals(new int[] {9,10}, soldado.getPosicion());

    }



    @Test(expected = CasilleroOcupadoExcepcion.class)
    public void intentoDesplazarPiezaACasilleroOcupadoLanzaCasilleroOcupadoExcepcion () throws CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldadoUno = new Soldado(equipoDos);
        Soldado soldadoDos = new Soldado(equipoUno);
        int[] coordenadasA = {10 , 10};
        int[] coordenadasB = {10,9};
        soldadoUno.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldadoDos.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));


        //Exception throw
        soldadoUno.desplazarHaciaAbajo();
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaYDerechaVerificoPosicion() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado unidadMovible = new Soldado(equipoDos);
        int[] coordenadasA = {10 , 10};
        unidadMovible.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        unidadMovible.prepararTurno();
        unidadMovible.desplazarHaciaIzquierda();
        unidadMovible.prepararTurno();
        unidadMovible.desplazarHaciaDerecha();

        Assert.assertArrayEquals(new int[] {10,10}, unidadMovible.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaArribaSeMueveHaciaArriba() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoDos);
        int[] coordenadasA = {10 , 10};
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado.desplazarHaciaArriba();

        Assert.assertArrayEquals(new int[] {10,11}, soldado.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaAbajoSeMueveHaciaAbajo() throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion {

        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoDos);
        int[] coordenadasA = {10 , 10};
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado.desplazarHaciaAbajo();

        Assert.assertArrayEquals(new int[] {10,9}, soldado.getPosicion());
    }

    @Test
    public void desplazoPiezaEnLasCuatroDirecciones() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion {
        Equipo equipoUno = new Equipo(2);
        Equipo equipoDos = new Equipo(1);
        Tablero tablero = new Tablero(equipoUno, equipoDos);
        Soldado soldado = new Soldado(equipoUno);
        int[] coordenadasC = {4,5};
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));
        soldado.desplazarHaciaArriba();
        soldado.prepararTurno();
        soldado.desplazarHaciaArriba();
        soldado.prepararTurno();
        soldado.desplazarHaciaDerecha();
        soldado.prepararTurno();
        soldado.desplazarHaciaDerecha();
        soldado.prepararTurno();
        soldado.desplazarHaciaDerecha();
        soldado.prepararTurno();
        soldado.desplazarHaciaAbajo();
        soldado.prepararTurno();
        soldado.desplazarHaciaIzquierda();

        Assert.assertArrayEquals(new int[] {6,6}, soldado.getPosicion());
    }
}
