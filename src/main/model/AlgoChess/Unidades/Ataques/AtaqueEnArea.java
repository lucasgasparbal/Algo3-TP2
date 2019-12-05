package model.AlgoChess.Unidades.Ataques;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.ObjetivoFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class AtaqueEnArea implements Ataque {

        private int dmg;

        public AtaqueEnArea (int danio) {
            dmg = danio;
        }

        @Override
        public void atacar(Unidad objetivo, Unidad atacante) throws CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion {
                if(!objetivo.estaEnRangoLejanoDe(atacante)){
                        throw new ObjetivoFueraDeRangoExcepcion();
                }
                        objetivo.sufrirDanio(dmg);
        }



}

