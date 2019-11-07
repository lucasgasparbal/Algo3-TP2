package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Unidades.Ataques.*;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Jinete extends UnidadMovible {

    private AtaqueCuerpoACuerpo ataque1 = new AtaqueCuerpoACuerpo(5);
    private AtaqueADistancia ataque2 = new AtaqueADistancia(15);

    public Jinete(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(100);
        costo = new Costo (3);
    }

    public void atacar (Unidad objetivo) {
        // aca falta la logica que le hace atacar de una u otra forma //
        ataque1.atacar(objetivo);

    }
}
