package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Unidad;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public interface Ataque {

    void atacar (Unidad objetivo, Unidad atacante)  throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion;

}
