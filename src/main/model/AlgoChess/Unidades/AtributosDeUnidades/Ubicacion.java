package model.AlgoChess.Unidades.AtributosDeUnidades;

import model.AlgoChess.Tablero.Casillero;

public class Ubicacion {

    private Casillero casillero;

    private int x;
    private int y;

    public void posicionarEn(Casillero unCasillero){
    }
    public void desplazarHaciaIzquierda() {
        x-=1;
    }

    public void desplazarHaciaDerecha() {
        x+=1;
    }

    public int[] getUbicacion() {
        return new int [] {x,y};
    }

    public void desplazarHaciaArriba() {
        y+=1;
    }

    public void desplazarHaciaAbajo() {
        y-=1;
    }

    public void cambiarA(int i, int j) {
        x=i;
        y=j;
    }
}
