package model.AlgoChess.Unidades.AtributosDeUnidades;

import model.AlgoChess.Excepciones.NoSePudoCurarExcepcion;

public class Vida {

    private int valorMaximo;
    private int valorActual;

    public Vida (int valorDeVida){
       valorActual = valorDeVida;
       valorMaximo = valorDeVida;
    }

    public void tomaDanio(double danio) {
        valorActual -= Math.ceil(danio);
    }

    public boolean acabo() {
        return valorActual<=0;
    }

    public void recibiCuracion(int curacion) throws NoSePudoCurarExcepcion {
        if (valorActual==valorMaximo) {
            throw new NoSePudoCurarExcepcion();
        }
        valorActual += curacion;

        if(valorActual > valorMaximo){
            valorActual = valorMaximo;
        }
    }

    public int getValor() {
        return valorActual;
    }
}
