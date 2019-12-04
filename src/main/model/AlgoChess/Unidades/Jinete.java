package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Ataques.*;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Jinete extends UnidadMovible {

    private final static int Costo = 3;
    private final int VidaJinete = 100;
    private final int DanioCuerpoACuerpo = 5;
    private final int DanioAtaqueDistancia = 15;

    private AtaqueCuerpoACuerpo ataqueEspada = new AtaqueCuerpoACuerpo(DanioCuerpoACuerpo);
    private AtaqueADistancia ataqueArco = new AtaqueADistancia(DanioAtaqueDistancia);

    public Jinete(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaJinete);
        costo = Costo;
    }

    public void atacar (Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        if (equipo.hayUnidadesEnemigasCercanas(this) || equipo.hayUnidadesAliadasCercanas(this)) {
            ataqueArco.atacar(objetivo,this);
        }
        else ataqueEspada.atacar(objetivo,this);
    }
}
