package model.AlgoChess.Unidad.Ataques;

import model.AlgoChess.Unidad.Ataques.Ataque;

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
