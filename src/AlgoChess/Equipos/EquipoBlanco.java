package AlgoChess.Equipos;

public class EquipoBlanco implements Equipo{

    @Override
    public boolean esBlanco() {
        return true;
    }

    @Override
    public boolean esNegro() {
        return false;
    }
}
