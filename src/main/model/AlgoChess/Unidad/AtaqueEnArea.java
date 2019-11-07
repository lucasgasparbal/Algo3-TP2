package model.AlgoChess.Unidad;

import model.AlgoChess.Unidad.Ataque;

public class AtaqueEnArea implements Ataque {

        public int dmg;

        public AtaqueEnArea (int danio) {
            dmg = danio;
        }

        @Override
        public void atacar(Unidad objetivo) {
            //aca se verifica que efectivamente se pueda atacar y como//
            objetivo.sufrirDanio (dmg);
        }
}

