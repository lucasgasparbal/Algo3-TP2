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
        public void atacar(Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion {

                if ((atacante.esEnemigoDe(objetivo) &&objetivo.estaEnRangoLejanoDe(atacante))) {
                        objetivo.sufrirDanio(dmg);
                     /*   atacarALasUnidadesAdyacentes(objetivo, atacante);*/
                }
               else throw new NoSePudoAtacarExcepcion();
        }



}

