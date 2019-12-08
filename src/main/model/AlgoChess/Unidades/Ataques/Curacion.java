package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoCurarExcepcion;
import model.AlgoChess.Excepciones.ObjetivoFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;
public class Curacion implements Ataque {

    private int dmg;

    public Curacion (int curacion) {
        dmg = curacion;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad atacante) throws NoSePudoCurarExcepcion, ObjetivoFueraDeRangoExcepcion, CoordenadaFueraDeRangoExcepcion {
        if(!objetivo.estaEnRangoCercanoDe(atacante)){
            throw new ObjetivoFueraDeRangoExcepcion();
        }
        objetivo.recibirCuracion (dmg);
    }
}
