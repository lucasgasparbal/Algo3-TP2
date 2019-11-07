package model.AlgoChess.Unidades.AtributosDeUnidades;

import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;

public class Costo {

    private int costo;

    public Costo (int valor) {
        costo =  valor;
    }

    public int descontarCosto(int puntos) throws NoAlcanzanPuntosExcepcion {
        if (puntos < costo) throw new NoAlcanzanPuntosExcepcion();
        puntos -= costo;
        return puntos;
    }
}
