package model.AlgoChess.Unidad;

import model.AlgoChess.Unidad.Ataque;

public class Curacion implements Ataque {

    public int dmg;

    public Curacion (int curacion) {
        dmg = curacion;
    }

    @Override
    public void atacar(Unidad objetivo) {
        objetivo.recibirCuracion (dmg);
    }
}
