package model.AlgoChess.Equipos;

import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.ColeccionUnidades;

public abstract class Equipo {

    private ColeccionUnidades unidades;
    private Equipo equipoEnemigo;

    public abstract boolean esBlanco();
    public abstract boolean esNegro();
    public abstract boolean esIgualA(Equipo unEquipo);

    public abstract boolean esEnemigoDeCasillero(Casillero unCasillero);
}
