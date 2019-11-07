package model.AlgoChess.Unidades;

import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public abstract class Unidad {

    Ubicacion ubicacion = new Ubicacion();

    Vida vida;

    Costo costo;

    public void recibirCuracion(int curacion) {
        vida.recibiCuracion(curacion);
    }

    public void sufrirDanio (int dmg) {
        vida.tomaDanio(dmg);
    }

    public boolean murio() {
        return (vida.acabo());
    }

    public int comprar (int fondos) throws NoAlcanzanPuntosExcepcion {
        return costo.descontarCosto (fondos);
    }

    public void atacar(Unidad objetivo) {};

}
