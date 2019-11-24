package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Unidad;


public class AtaqueADistancia implements Ataque {

    private int dmg;

    public AtaqueADistancia (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        if (objetivo.estaEnRangoMedianoDe(atacante)) {
            objetivo.sufrirDanio(dmg);
        }
        else throw new NoSePudoAtacarExcepcion();
    }
}
