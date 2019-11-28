package AlgoChessTest.JugadorTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Jugador;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;

public class JugadorTest {

    @Test
    public void intentoComprarCincoCatapultasTiraExcepcion () {
        Casillero casilleroMock = mock(Casillero.class);
        Equipo equipoMock = mock(Equipo.class);
        Jugador jugador = new Jugador ();
        // Las unidades se crean antes de ver si las puedo costear, arreglar //
        boolean seLanzaExcepcion = false;
        Catapulta catapulta1 = new Catapulta (equipoMock);
        Catapulta catapulta2 = new Catapulta (equipoMock);
        Catapulta catapulta3 = new Catapulta (equipoMock);
        Catapulta catapulta4 = new Catapulta (equipoMock);
        Catapulta catapulta5 = new Catapulta (equipoMock);
        try {
            jugador.compra(catapulta1);
            jugador.compra(catapulta2);
            jugador.compra(catapulta3);
            jugador.compra(catapulta4);
            jugador.compra(catapulta5);
        }
        catch (NoAlcanzanPuntosExcepcion e) {
            seLanzaExcepcion = true;
        }
        Assert.assertTrue(seLanzaExcepcion);
    }

    @Test
    public void jugadorQueSeQuedaSinPiezasPierde () {
        Casillero casilleroMock = mock(Casillero.class);
        Equipo equipoMock = mock(Equipo.class);

        Catapulta catapulta = new Catapulta (equipoMock);
        Jugador jugador = new Jugador();
        Soldado soldado = new Soldado (equipoMock);
        Jinete jinete = new Jinete (equipoMock);

        try {
            jugador.compra(catapulta);
            jugador.compra(soldado);
            jugador.compra(jinete);
        }
        catch (NoAlcanzanPuntosExcepcion e) {}

        catapulta.sufrirDanio(100);
        soldado.sufrirDanio(100);
        jinete.sufrirDanio(100);

        Assert.assertTrue (jugador.perdio());
    }

    @Test
    public void jugadorTieneUnaSolaPiezaVivaNoPierde () {
        Casillero casilleroMock = mock(Casillero.class);
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Jugador jugador = new Jugador();
        Soldado soldado = new Soldado (equipoMock);
        Curandero curandero = new Curandero(equipoMock);

        try {
            jugador.compra(catapulta);
            jugador.compra(soldado);
            jugador.compra(curandero);
        }
        catch(NoAlcanzanPuntosExcepcion ignored){}

        catapulta.sufrirDanio(100);
        soldado.sufrirDanio(99);
        curandero.sufrirDanio(100);

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
}

