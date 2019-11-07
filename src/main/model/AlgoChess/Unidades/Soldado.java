package model.AlgoChess.Unidades;

import model.AlgoChess.Unidades.Ataques.AtaqueCuerpoACuerpo;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Soldado extends UnidadMovible {

    private AtaqueCuerpoACuerpo ataque = new AtaqueCuerpoACuerpo(10);

    public Soldado(int x, int y) {
        super(x, y);
        vida = new Vida(100);
        costo = new Costo(1);
    }

    public void atacar(Unidad objetivo) {
        ataque.atacar(objetivo);
    }
}
