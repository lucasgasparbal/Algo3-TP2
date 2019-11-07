package model.AlgoChess.Equipos;

public class EquipoBlanco implements Equipo{

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
}
