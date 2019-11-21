package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Unidad;

public class AtaqueEnArea implements Ataque {

        private int dmg;

        public AtaqueEnArea (int danio) {
            dmg = danio;
        }

        @Override
        public void atacar(Unidad objetivo, Casillero posicionAtacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {
            //aca se verifica que efectivamente se pueda atacar y como//
            objetivo.sufrirDanio (dmg);
        }
}

