package model.AlgoChess.Unidades.AtributosDeUnidades;

import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;

public class Costo {

    private int costo;

    public Costo (int valor) {
        costo =  valor;
    }

    public int descontarCosto(int puntos) throws NoAlcanzaOroExcepcion {
        if (puntos < costo) throw new NoAlcanzaOroExcepcion();
        puntos -= costo;
        return puntos;
    }
}
