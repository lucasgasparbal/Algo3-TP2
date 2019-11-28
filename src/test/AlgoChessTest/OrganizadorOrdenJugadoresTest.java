package AlgoChessTest;

import model.AlgoChess.*;
import org.junit.Assert;
import org.junit.Test;

public class OrganizadorOrdenJugadoresTest {

    @Test
    public void  OrganizadorOrdenDeJugadoresProximoJugadorDevuelveJugadoresDistintosAlSerInvocadoMasDeUnaVezCuandoExisteMasDeUnJugador(){
        OrganizadorOrdenJugadores organizadorOrdenJugadores = new OrganizadorOrdenJugadores();
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        organizadorOrdenJugadores.agregarJugador(jugadorUno);
        organizadorOrdenJugadores.agregarJugador(jugadorDos);

        Jugador primerJugador = organizadorOrdenJugadores.proximoJugador();
        Jugador segundoJugador = organizadorOrdenJugadores.proximoJugador();

        Assert.assertNotEquals(primerJugador, segundoJugador);
    }
}
