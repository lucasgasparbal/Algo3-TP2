package model.AlgoChess;

import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;

public class Juego {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Jugador jugadorActual;
    OrganizadorOrdenJugadores organizadorOrdenJugadores;

    public Juego(){
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();

        jugadorUno.setEnemigo(jugadorDos);
        jugadorDos.setEnemigo(jugadorUno);

        organizadorOrdenJugadores = new OrganizadorOrdenJugadores();

        organizadorOrdenJugadores.agregarJugador(jugadorUno);
        organizadorOrdenJugadores.agregarJugador(jugadorDos);

        jugadorActual = organizadorOrdenJugadores.proximoJugador();
    }


    public void decidirOrdenTurnos(){
        organizadorOrdenJugadores.sortearOrden();
    }

    public void nombrarUsuarioBlanco(String nombre){
        jugadorUno.setNombre(nombre);
    }

    public void nombrarUsuarioNegro(String nombre){
        jugadorDos.setNombre(nombre);
    }

    public void comprarSoldado() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarSoldado();
    }
    public void comprarJinete() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarJinete();
    }
    public void comprarCurandero() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarCurandero();
    }
    public void comprarCatapulta() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarCatapulta();
    }

    public int oroRestante(){
        return jugadorActual.oroRestante();
    }

    public String obtenerNombreJugadorEnTurno(){
        return jugadorActual.getNombre();
    }

    public void nuevoTurno(){
        jugadorActual.terminarTurno();
        jugadorActual = organizadorOrdenJugadores.proximoJugador();
        jugadorActual.prepararTurno();
    }
}
