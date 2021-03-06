package AlgoChessTest.JugadorTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Jugador;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {

    @Test
    public void intentoComprarCincoCatapultasTiraExcepcion () {
        Jugador jugador = new Jugador ();
        boolean seLanzaExcepcion = false;
        try {
            jugador.comprarCatapulta();
            jugador.comprarCatapulta();
            jugador.comprarCatapulta();
            jugador.comprarCatapulta();
            jugador.comprarCatapulta();
        }
        catch (NoAlcanzaOroExcepcion e) {
            seLanzaExcepcion = true;
        }
        Assert.assertTrue(seLanzaExcepcion);
    }

    @Test
    public void jugadorPerdioDevuelveTrueSiTodasSusPiezasEnJuegoMurieron () throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, NoAlcanzaOroExcepcion, NoHaySoldadosEnBanquillaExcepcion, NoHayCatapultasEnBanquillaExcepcion, NoHayJinetesEnBanquillaExcepcion {
        Casillero casilleroMock = mock(Casillero.class);

        Jugador jugador = new Jugador();
        jugador.comprarSoldado();
        jugador.comprarCatapulta();
        jugador.comprarJinete();
        when(casilleroMock.perteneceAEquipo(any(Equipo.class))).thenReturn(true);
        when(casilleroMock.aplicarMultiplicadorDanioAUnidadDeEquipo(any(Equipo.class))).thenReturn(1.0);
        Soldado soldado = jugador.tomarSoldadoDeBanquilla();
        Catapulta catapulta = jugador.tomarCatapultaDeBanquilla();
        Jinete jinete = jugador.tomarJineteDeBanquilla();

        soldado.inicializarEnCasillero(casilleroMock);
        catapulta.inicializarEnCasillero(casilleroMock);
        jinete.inicializarEnCasillero(casilleroMock);

        jugador.removerCatapultaDeBanquilla();
        jugador.removerJineteDeBanquilla();
        jugador.removerSoldadoDeBanquilla();

        catapulta.sufrirDanio(100);
        soldado.sufrirDanio(100);
        jinete.sufrirDanio(100);

        Assert.assertTrue (jugador.perdio());
    }

    @Test
    public void jugadorTieneUnaSolaPiezaVivaNoPierde () throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion, NoAlcanzaOroExcepcion, NoHaySoldadosEnBanquillaExcepcion, NoHayCatapultasEnBanquillaExcepcion, NoHayJinetesEnBanquillaExcepcion {
        Casillero casilleroMock = mock(Casillero.class);

        Jugador jugador = new Jugador();
        jugador.comprarSoldado();
        jugador.comprarCatapulta();
        jugador.comprarJinete();
        when(casilleroMock.perteneceAEquipo(any(Equipo.class))).thenReturn(true);
        Soldado soldado = jugador.tomarSoldadoDeBanquilla();
        Catapulta catapulta = jugador.tomarCatapultaDeBanquilla();
        Jinete jinete = jugador.tomarJineteDeBanquilla();

        soldado.inicializarEnCasillero(casilleroMock);
        catapulta.inicializarEnCasillero(casilleroMock);
        jinete.inicializarEnCasillero(casilleroMock);

        jugador.removerCatapultaDeBanquilla();
        jugador.removerJineteDeBanquilla();
        jugador.removerSoldadoDeBanquilla();

        catapulta.sufrirDanio(100);
        soldado.sufrirDanio(99);
        jinete.sufrirDanio(100);

        Assert.assertFalse (jugador.perdio());
    }

    @Test
    public void JugadorInstanciasDistintasTienenNumerosIdentificadoresDistintos() {
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        Assert.assertNotEquals(jugadorUno.identificador, jugadorDos.identificador);

    }

    @Test
    public void JugadorEstaEnTurnoSiJugadorPreparoTurnoPreviamente() {
        Jugador jugadorUno = new Jugador();

        jugadorUno.prepararTurno();

        Assert.assertTrue(jugadorUno.estaEnTurno());
    }

    @Test
    public void JugadorNoEstaEnTurnoSiJugadorTerminoTurnoPreviamente() {
        Jugador jugadorUno = new Jugador();

        jugadorUno.terminarTurno();

        Assert.assertFalse(jugadorUno.estaEnTurno());
    }

    @Test

    public void JugadorSeteoNombreDevuelveElMismoNombre(){
        Jugador jugador = new Jugador();

        jugador.setNombre("Algoritmos Tres");
        String nombre = jugador.getNombre();

        Assert.assertEquals("Algoritmos Tres", nombre);
    }

    @Test
    public void JugadorComienzaCon20Puntos(){
        Jugador jugador = new Jugador();

        Assert.assertEquals(20, jugador.oroRestante());
    }

    @Test
    public void JugadorCompraUnSoldadoLeRestaElCostoDeSoldadoASuOro() throws NoAlcanzaOroExcepcion {
        Jugador jugador = new Jugador();
        jugador.comprarSoldado();

        Assert.assertEquals(19, jugador.oroRestante());
    }

    @Test
    public void JugadorCompraUnjineteLeRestaElCostoDeJineteASuOro() throws NoAlcanzaOroExcepcion {
        Jugador jugador = new Jugador();
        jugador.comprarJinete();

        Assert.assertEquals(17, jugador.oroRestante());
    }

    @Test
    public void JugadorCompraUnCuranderoLeRestaElCostoDeCuranderoASuOro() throws NoAlcanzaOroExcepcion {
        Jugador jugador = new Jugador();
        jugador.comprarCurandero();

        Assert.assertEquals(18, jugador.oroRestante());
    }

    @Test
    public void JugadorCompraUnaCatapultaLeRestaElCostoDeCatapultaASuOro() throws NoAlcanzaOroExcepcion {
        Jugador jugador = new Jugador();
        jugador.comprarCatapulta();

        Assert.assertEquals(15, jugador.oroRestante());
    }

    @Test

    public void JugadorIntentaComprarDeMasYSuOroNoPasaDeCero(){
        Jugador jugador = new Jugador();

        for(int i = 0; i < 21; i++){
            try {
                jugador.comprarSoldado();
            } catch (NoAlcanzaOroExcepcion ignored) {
            }
        }

        Assert.assertEquals(0,jugador.oroRestante());

    }

    @Test

    public void JugadorEsDuenioDeUnaUnidadQueEstaEnSuEquipo(){
        Jugador jugador = new Jugador();
        Equipo equipo = jugador.getEquipo();
        Soldado soldado = mock(Soldado.class);
        when(soldado.perteneceAEquipo(equipo)).thenReturn(true);
        Assert.assertTrue(jugador.esDuenioDe(soldado));
    }
}

