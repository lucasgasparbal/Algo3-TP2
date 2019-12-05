package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UltimaFichaSeleccionada {

    boolean hayFichaSeleccionada = false;
    ImageView imagenSeleccionada;

    public void seleccionarFicha(ImageView imagen) {
        hayFichaSeleccionada=true;
        imagenSeleccionada=imagen;
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
}
