package model.AlgoChess.Equipos;

import model.AlgoChess.Tablero.Casillero;

public abstract class Equipo {

    public abstract boolean esBlanco();
    public abstract boolean esNegro();
    public abstract boolean esIgualA(Equipo unEquipo);

    public abstract boolean esEnemigoDeCasillero(Casillero unCasillero);
}
