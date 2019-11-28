package model.AlgoChess;
import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Unidades.Unidad;
import java.util.*;

public class Jugador {


    static int numeroJugadores = 1;

    private boolean estaEnTurno;
    public int identificador;
    private int puntos = 20;
    private LinkedList <Unidad> inventarioPiezas = new LinkedList<>();

    public Jugador(){
        identificador = numeroJugadores;
        numeroJugadores++;
    }

    public void compra(Unidad pieza) throws NoAlcanzanPuntosExcepcion {
        puntos = pieza.comprar (puntos);
        inventarioPiezas.add(pieza);
    }

    public boolean perdio() {
        for (Unidad pieza : inventarioPiezas) {
            if (!pieza.murio()) {
                return false;
            }
        }
        return true;
    }

    public void prepararTurno(){
        estaEnTurno = true;
    }

    public void terminarTurno(){
        estaEnTurno = false;
    }

    public boolean estaEnTurno(){
        return estaEnTurno;
    }
}
