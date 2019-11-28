import model.AlgoChess.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
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
