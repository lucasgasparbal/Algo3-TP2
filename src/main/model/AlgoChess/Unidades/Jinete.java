package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
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

    public void atacar (Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        if (equipo.hayUnidadesEnemigasCercanas(ubicacion) || equipo.hayUnidadesAliadasCercanas(ubicacion)) {
            ataque2.atacar(objetivo,ubicacion);
        }
        else ataque1.atacar(objetivo,ubicacion);
    }
}
