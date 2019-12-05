package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Ataques.AtaqueEnArea;
import model.AlgoChess.Unidades.AtributosDeUnidades.Vida;

public class Catapulta extends Unidad {

    private final static int Costo = 5;

    private final int VidaCatapulta = 50;

    private AtaqueEnArea ataque = new AtaqueEnArea(20);

    public Catapulta (Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaCatapulta);
        costo = Costo;
    }

    public void atacar (Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        ataque.atacar(objetivo,this);
    }
}
