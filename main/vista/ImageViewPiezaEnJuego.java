package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewPiezaEnJuego extends ImageView {

    public Image ultimaImagen;

    public ImageViewPiezaEnJuego() {
        super();
    }

    public void actualizarImagen(Image imagen) {
        ultimaImagen = imagen;
    }

    public Image devolverUltimaImagen () {
        return ultimaImagen;
    }

}
