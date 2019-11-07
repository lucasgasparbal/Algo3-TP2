package model;

public abstract class UnidadMovible extends Unidad {

    public UnidadMovible(int x, int y ) {
        ubicacion.cambiarA(x,y);
    }

    public boolean desplazarHaciaIzquierda() {
        return ubicacion.desplazarHaciaIzquierda();
    }

    public boolean desplazarHaciaDerecha() {
        return ubicacion.desplazarHaciaDerecha();
    }

    public void desplazarHaciaArriba() {
        ubicacion.desplazarHaciaArriba();
    }

    public void desplazarHaciaAbajo() {
        ubicacion.desplazarHaciaAbajo();
    }

    public int[] getPosicion() {
        return ubicacion.getUbicacion();
    }

}
