package model;

public class Ubicacion {

    private int x = 0;

    private int y = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int i) {
        x = i;
    }

    public void setY(int i) {
        y = i;
    }

    public boolean desplazarHaciaIzquierda() {
        x-=1;
        return (x>1);
    }

    public boolean desplazarHaciaDerecha() {
        x+=1;
        return (x<20);
    }

    public void cambiarA(int x, int y) {
        this.setX (x);
        this.setY (y);
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
}
