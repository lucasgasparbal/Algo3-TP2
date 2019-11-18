package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Unidades.Unidad;

public class AtaqueCuerpoACuerpo implements Ataque {

    private int dmg;

    public AtaqueCuerpoACuerpo (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo) {
        //aca se verifica que efectivamente se pueda atacar y como//
        objetivo.sufrirDanio (dmg);
    }
}