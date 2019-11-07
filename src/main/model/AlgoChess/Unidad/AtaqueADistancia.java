package model.AlgoChess.Unidad;

public class AtaqueADistancia implements Ataque {

    private int dmg;

    public AtaqueADistancia (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo) {
        //aca se verifica que efectivamente se pueda atacar y como//
        objetivo.sufrirDanio (dmg);
    }
}
