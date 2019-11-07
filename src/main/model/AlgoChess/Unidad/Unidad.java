package model.AlgoChess.Unidad;

public abstract class Unidad {

    Ubicacion ubicacion = new Ubicacion();

    Vida vida;

    public void recibirCuracion(int curacion) {
        vida.recibiCuracion(curacion);
    }

    public void sufrirDanio (int dmg) {
        vida.tomaDanio(dmg);
    }

    public boolean murio() {
        return (vida.acabo());
    }

}
