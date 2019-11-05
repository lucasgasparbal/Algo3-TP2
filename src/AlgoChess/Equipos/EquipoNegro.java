package AlgoChess.Equipos;

public class EquipoNegro implements Equipo{

    @Override
    public boolean esBlanco() {
        return false;
    }

    @Override
    public boolean esNegro() {
        return true;
    }
}
