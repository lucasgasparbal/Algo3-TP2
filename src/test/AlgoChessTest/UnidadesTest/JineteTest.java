package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
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
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock.getIdentificador())).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock.getIdentificador())).thenReturn(true);
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
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock.getIdentificador())).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock.getIdentificador())).thenReturn(true);
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
        Tablero tablero = new Tablero ();
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
        Tablero tablero = new Tablero();
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
        Tablero tablero = new Tablero();
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
        Tablero tablero = new Tablero();
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

}


