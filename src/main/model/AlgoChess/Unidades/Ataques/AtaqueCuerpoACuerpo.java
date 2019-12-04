package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Unidad;

public class AtaqueCuerpoACuerpo implements Ataque {

    private int dmg;

    public AtaqueCuerpoACuerpo (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        if ((atacante.esEnemigoDe(objetivo)) && (objetivo.estaEnRangoCercanoDe(atacante))) {
            objetivo.sufrirDanio(dmg);
        }
        else throw new NoSePudoAtacarExcepcion();
    }
}
