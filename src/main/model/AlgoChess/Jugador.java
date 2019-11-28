package model.AlgoChess;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Unidades.ColeccionUnidades;
import model.AlgoChess.Unidades.Unidad;
import java.util.*;

public class Jugador {


    static int numeroJugadores = 1;

    private boolean estaEnTurno;
    public int identificador;
    private int puntos = 20;
    private ColeccionUnidades unidades = new ColeccionUnidades();

    private Equipo equipo;

    public Jugador(){
        identificador = numeroJugadores;
        numeroJugadores++;
        equipo = new Equipo(identificador);
    }

    public void compra(Unidad pieza) throws NoAlcanzanPuntosExcepcion {
        puntos = pieza.comprar (puntos);
        equipo.agregarUnidad(pieza);
        pieza.setEquipo(equipo);
    }

    public boolean perdio() {
        return equipo.noTieneUnidades();
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
