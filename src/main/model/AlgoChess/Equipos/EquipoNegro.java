package model.AlgoChess.Equipos;

public class EquipoNegro implements Equipo{

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
}
