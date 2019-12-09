package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UltimaFichaSeleccionada {

    boolean hayFichaSeleccionada = false;
    ImageView imagenSeleccionada;
    int[] coordenadas;
    boolean estaEnBatallon = false;

    public void seleccionarFicha(ImageView imagen, int[]coord) {
        hayFichaSeleccionada=true;
        imagenSeleccionada=imagen;
        coordenadas = coord;
    }

    public void limpiarSeleccionFicha() {
        imagenSeleccionada=null;
        hayFichaSeleccionada = false;
    }

    public boolean hayFichaSeleccionada() {
        return hayFichaSeleccionada;
    }

    public ImageView obtenerImagenFicha() {
        return imagenSeleccionada;
    }

    public int[] obtenerCoordenadas() {return coordenadas;}
}
