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
import org.junit.jupiter.api.Assertions;

public class EntidadesTest {
    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaVerificoPosicion() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero(equipoBlanco, equipoNegro);
        Soldado soldado = new Soldado(equipoNegro);
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado.desplazarHaciaIzquierda();
        Assert.assertArrayEquals(new int[] {9,10}, soldado.getPosicion());

    }

    @Test
    public void intentoDesplazarPiezaACasilleroOcupado () {
        boolean test = false;
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero(equipoBlanco, equipoNegro);
        Soldado soldadoUno = new Soldado(equipoNegro);
        Soldado soldadoDos = new Soldado(equipoBlanco);
        try {
            soldadoUno.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
            soldadoDos.inicializarEnCasillero(tablero.conseguirCasillero(9,10));
        } catch (CasilleroEnemigoExcepcion | CasilleroOcupadoExcepcion | CoordenadaFueraDeRangoExcepcion casilleroEnemigoExcepcion) {
        }
        try {
            soldadoUno.desplazarHaciaIzquierda();
        } catch (MovimientoInvalidoExcepcion ignored) {
        } catch (CasilleroOcupadoExcepcion casilleroOcupadoExcepcion) {
            test = true;
        }
        assert (test);

    }
    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaYDerechaVerificoPosicion() {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero(equipoBlanco, equipoNegro);
        Soldado unidadMovible = new Soldado(equipoNegro);
        try {
            unidadMovible.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        } catch (CasilleroEnemigoExcepcion | CasilleroOcupadoExcepcion | CoordenadaFueraDeRangoExcepcion ignored) {
        }
        try {
            unidadMovible.desplazarHaciaIzquierda();
            unidadMovible.desplazarHaciaDerecha();
        } catch (MovimientoInvalidoExcepcion | CasilleroOcupadoExcepcion ignored) {
        }

        Assert.assertArrayEquals(new int[] {10,10}, unidadMovible.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaArriba() {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero(equipoBlanco, equipoNegro);
        Soldado soldado = new Soldado(equipoNegro);
        try {
            soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        } catch (CasilleroEnemigoExcepcion | CasilleroOcupadoExcepcion | CoordenadaFueraDeRangoExcepcion ignored) {
        }
        try {
            soldado.desplazarHaciaArriba();
        } catch (MovimientoInvalidoExcepcion | CasilleroOcupadoExcepcion ignored) {
        }
        Assert.assertArrayEquals(new int[] {10,11}, soldado.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaAbajo() {

        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero(equipoBlanco, equipoNegro);
        Soldado soldado = new Soldado(equipoNegro);
        try {
            soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        } catch (CasilleroEnemigoExcepcion | CasilleroOcupadoExcepcion | CoordenadaFueraDeRangoExcepcion ignored) {
        }
        try {
            soldado.desplazarHaciaAbajo();
        } catch (MovimientoInvalidoExcepcion | CasilleroOcupadoExcepcion ignored) {
        }
        Assert.assertArrayEquals(new int[] {10,9}, soldado.getPosicion());
    }

    @Test
    public void desplazoPiezaEnLasCuatroDirecciones() {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        Tablero tablero = new Tablero(equipoBlanco, equipoNegro);
        Soldado soldado = new Soldado(equipoBlanco);
        try {
            soldado.inicializarEnCasillero(tablero.conseguirCasillero(4,5));
        } catch (CasilleroEnemigoExcepcion | CasilleroOcupadoExcepcion | CoordenadaFueraDeRangoExcepcion ignored) {
        }
        try {
            soldado.desplazarHaciaArriba();
            soldado.desplazarHaciaArriba();
            soldado.desplazarHaciaDerecha();
            soldado.desplazarHaciaDerecha();
            soldado.desplazarHaciaDerecha();
            soldado.desplazarHaciaAbajo();
            soldado.desplazarHaciaIzquierda();
        } catch (MovimientoInvalidoExcepcion | CasilleroOcupadoExcepcion ignored) {
        }
        Assert.assertArrayEquals(new int[] {6,6}, soldado.getPosicion());
    }
}
