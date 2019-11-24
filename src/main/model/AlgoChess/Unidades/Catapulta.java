package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Ataques.AtaqueEnArea;
import model.AlgoChess.Unidades.AtributosDeUnidades.Costo;
import model.AlgoChess.Unidades.AtributosDeUnidades.Vida;

public class Catapulta extends Unidad {

    private AtaqueEnArea ataque = new AtaqueEnArea(20);

    public Catapulta (Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(50);
        costo = new Costo(5);
    }

    public void atacar (Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        ataque.atacar(objetivo,this);
    }
}
