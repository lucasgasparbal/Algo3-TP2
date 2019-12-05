package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.ObjetivoFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;


public class AtaqueADistancia implements Ataque {

    private int dmg;

    public AtaqueADistancia (int danio) {
        dmg = danio;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion {

        if(!objetivo.estaEnRangoMedianoDe(atacante)){
            throw new ObjetivoFueraDeRangoExcepcion();
        }
        objetivo.sufrirDanio(dmg);
    }
}
