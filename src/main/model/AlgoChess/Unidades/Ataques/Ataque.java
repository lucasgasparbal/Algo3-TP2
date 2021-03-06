package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.NoSePudoCurarExcepcion;
import model.AlgoChess.Excepciones.ObjetivoFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public interface Ataque {

    void atacar (Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion, NoSePudoCurarExcepcion;

}
