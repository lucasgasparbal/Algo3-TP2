package AlgoChessTest;

import model.AlgoChess.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Or;

public class OrganizadorTurnosTest {

    @Test
    public void  OrganizadorTurnosProximoJugadorDevuelveJugadoresDistintosAlSerInvocadoMasDeUnaVez(){
        OrganizadorTurnos organizadorTurnos = new OrganizadorTurnos();
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        organizadorTurnos.agregarJugador(jugadorUno);
        organizadorTurnos.agregarJugador(jugadorDos);

        Jugador primerJugador = organizadorTurnos.proximoJugador();
        Jugador segundoJugador = organizadorTurnos.proximoJugador();

        Assert.assertNotEquals(primerJugador, segundoJugador);
    }
}
