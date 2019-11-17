package model.AlgoChess.Equipos;

import model.AlgoChess.Tablero.Casillero;

public class EquipoNegro extends Equipo{

    @Override
    //pre:ninguna
    //pos: devuelve false
    public boolean esBlanco() {
        return false;
    }

    @Override
    //pre:ninguna
    //pos: devuelve true
    public boolean esNegro() {
        return true;
    }

    @Override
    public boolean esIgualA(Equipo unEquipo) {
        return unEquipo.esNegro();
    }

    @Override
    public boolean esEnemigoDeCasillero(Casillero unCasillero){
        return !unCasillero.esNegro();
    }
}
