package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Unidad;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public interface Ataque {

    void atacar (Unidad objetivo, Casillero posicionAtacante)  throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion;

}
