package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Unidad;

public class Curacion implements Ataque {

    private int dmg;

    public Curacion (int curacion) {
        dmg = curacion;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad Atacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        objetivo.recibirCuracion (dmg);
    }
}
