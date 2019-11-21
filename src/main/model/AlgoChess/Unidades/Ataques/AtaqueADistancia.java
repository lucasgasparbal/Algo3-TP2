package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Unidad;
import model.AlgoChess.Tablero.Casillero;


public class AtaqueADistancia implements Ataque {

    private int dmg;

    public AtaqueADistancia (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo, Casillero posicionAtacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        if (objetivo.estaEnRangoMedianoDe(posicionAtacante)) {
            objetivo.sufrirDanio(dmg);
        }
        else throw new NoSePudoAtacarExcepcion();
    }
}
