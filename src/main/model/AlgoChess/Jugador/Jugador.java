package model.AlgoChess.Jugador;
import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Unidades.Unidad;
import java.util.*;

public class Jugador {

    private int puntos = 20;
    private LinkedList <Unidad> piezasEnJuego = new LinkedList<>();

    public void compra(Unidad pieza) throws NoAlcanzanPuntosExcepcion {
        puntos = pieza.comprar (puntos);
        piezasEnJuego.add(pieza);
    }

    public boolean perdio() {
        for (Unidad pieza : piezasEnJuego) {
            if (!pieza.murio()) {
                return false;
            }
        }
        return true;
    }
}
