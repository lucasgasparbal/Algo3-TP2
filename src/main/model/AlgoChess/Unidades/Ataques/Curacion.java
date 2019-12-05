package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Unidad;

public class Curacion implements Ataque {

    private int dmg;

    public Curacion (int curacion) {
        dmg = curacion;
    }

    @Override
    public void atacar(Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
        if(!(atacante.esEnemigoDe(objetivo))){
           objetivo.recibirCuracion (dmg);
        }
        else throw new NoSePudoAtacarExcepcion();
    }
}
