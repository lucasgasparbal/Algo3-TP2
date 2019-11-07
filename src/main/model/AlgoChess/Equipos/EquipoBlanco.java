package AlgoChess.Equipos;

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
}
