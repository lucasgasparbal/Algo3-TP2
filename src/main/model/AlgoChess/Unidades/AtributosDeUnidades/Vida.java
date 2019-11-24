package model.AlgoChess.Unidades.AtributosDeUnidades;

public class Vida {

    private int valorMaximo;
    private int valorActual;

    public Vida (int valorDeVida){
       valorActual = valorDeVida;
       valorMaximo = valorDeVida;
    }

    public void tomaDanio(int danio) {
        valorActual -= danio;
    }

    public boolean acabo() {
        return valorActual<=0;
    }

    public void recibiCuracion(int curacion) {
        valorActual += curacion;

        if(valorActual > valorMaximo){
            valorActual = valorMaximo;
        }
    }

    public int getValor() {
        return valorActual;
    }
}
