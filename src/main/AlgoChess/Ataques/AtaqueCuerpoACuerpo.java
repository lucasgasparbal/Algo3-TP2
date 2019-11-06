package model;

public class AtaqueCuerpoACuerpo implements Ataque {

    public int dmg;

    public AtaqueCuerpoACuerpo (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo) {
        //aca se verifica que efectivamente se pueda atacar y como//
        objetivo.sufrirDanio (dmg);
    }
}
