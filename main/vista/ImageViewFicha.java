package vista;

import javafx.scene.image.ImageView;

public class ImageViewFicha extends ImageView {

    public int[] coordenadas = new int[2];

    public int[] obtenerCoordenadas() {
        return coordenadas;
    }

    public ImageViewFicha (int x,int y,String url) {
        super(url);
        this.coordenadas[0] = x;
        this.coordenadas[1] = y;
    }
}