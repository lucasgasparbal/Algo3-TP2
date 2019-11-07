package model.AlgoChess.Unidades;

public abstract class UnidadMovible extends Unidad {

    public UnidadMovible(int x, int y ) {
        ubicacion.cambiarA(x,y);
    }

    public void desplazarHaciaIzquierda() {
        ubicacion.desplazarHaciaIzquierda();
    }

    public void desplazarHaciaDerecha() {
        ubicacion.desplazarHaciaDerecha();
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
