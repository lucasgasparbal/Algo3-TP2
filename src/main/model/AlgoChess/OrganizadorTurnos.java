package model.AlgoChess;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class OrganizadorTurnos {
    LinkedList<Jugador> colaJugadores = new LinkedList<Jugador>();

    public void agregarJugador(Jugador unJugador){
        colaJugadores.addLast(unJugador);
    }

    public void sortearOrden(){
        Collections.shuffle(colaJugadores);
    }

    public Jugador proximoJugador(){
        Jugador proximoJugador = colaJugadores.pollFirst();
        agregarJugador(proximoJugador);
        return proximoJugador;
    }
}
