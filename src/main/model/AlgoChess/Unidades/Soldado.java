package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Unidades.Ataques.AtaqueCuerpoACuerpo;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Soldado extends UnidadMovible {

    private AtaqueCuerpoACuerpo ataque = new AtaqueCuerpoACuerpo(10);

    public Soldado(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(100);
        costo = new Costo(1);
    }

    public void atacar(Unidad objetivo) {
        ataque.atacar(objetivo);
    }
}
