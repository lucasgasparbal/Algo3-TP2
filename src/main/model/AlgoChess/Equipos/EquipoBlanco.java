package model.AlgoChess.Equipos;

import model.AlgoChess.Tablero.Casillero;

public class EquipoBlanco extends Equipo{

    @Override
    //pre: ninguna
    //pos: devuelve true
    public boolean esBlanco() {
        return true;
    }

    @Override
    //pre:ninguna
    //pos: devuelve false
    public boolean esNegro() {
        return false;
    }

    @Override
    public boolean esIgualA(Equipo unEquipo) {
        return unEquipo.esBlanco();
    }

    @Override
    public boolean esEnemigoDeCasillero(Casillero unCasillero){
        return !unCasillero.esBlanco();
    }
}
