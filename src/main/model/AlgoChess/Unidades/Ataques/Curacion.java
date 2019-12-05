package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.NoSePudoCurarExcepcion;
import model.AlgoChess.Unidades.Unidad;
public class Curacion implements Ataque {

    private int dmg;

    public Curacion (int curacion) {
        dmg = curacion;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad atacante) throws NoSePudoCurarExcepcion {
        objetivo.recibirCuracion (dmg);
    }
}
