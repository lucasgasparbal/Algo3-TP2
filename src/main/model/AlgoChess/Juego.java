package model.AlgoChess;

public class Juego {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Jugador jugadorActual;
    OrganizadorOrdenJugadores organizadorOrdenJugadores;

    public Juego(){
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();
        organizadorOrdenJugadores = new OrganizadorOrdenJugadores();

        organizadorOrdenJugadores.agregarJugador(jugadorUno);
        organizadorOrdenJugadores.agregarJugador(jugadorDos);
        organizadorOrdenJugadores.sortearOrden();

        jugadorActual = organizadorOrdenJugadores.proximoJugador();
    }

    public void nuevoTurno(){
        jugadorActual.terminarTurno();
        jugadorActual = organizadorOrdenJugadores.proximoJugador();
        jugadorActual.prepararTurno();
    }
}
