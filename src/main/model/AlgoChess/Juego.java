package model.AlgoChess;

public class Juego {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Jugador jugadorActual;
    OrganizadorTurnos organizadorTurnos;

    public Juego(){
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();
        organizadorTurnos = new OrganizadorTurnos();

        organizadorTurnos.agregarJugador(jugadorUno);
        organizadorTurnos.agregarJugador(jugadorDos);
        organizadorTurnos.sortearOrden();

        jugadorActual = organizadorTurnos.proximoJugador();
    }
}
