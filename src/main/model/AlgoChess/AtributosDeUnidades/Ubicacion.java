package model;

public class Ubicacion {

    private int x = 0;

    private int y = 0;

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
