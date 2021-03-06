package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class ImageViewPiezaEnJuego {

    public Image ultimaImagen;
    AudioClip audioColocada;
    AudioClip audioError;
    boolean esSoldado = false;
    boolean esJinete = false;
    boolean esCurandero = false;
    boolean esCatapulta = false;

    private void resetearOtras (boolean clase1, boolean clase2, boolean clase3) {
        clase1 = false;
        clase2 = false;
        clase3 = false;
    }

    public ImageViewPiezaEnJuego (String direccion) {
        this.audioColocada = new AudioClip(direccion+"fichaColocada.wav");
        this.audioError= new AudioClip(direccion+"error.wav");
    }

    public void esUnSoldado() {
        esSoldado = true;
        resetearOtras(esJinete,esCatapulta,esCurandero);
    }

    public void esUnCurandero() {
        esCurandero = true;
        resetearOtras(esJinete,esCatapulta,esSoldado);
    }

    public void esUnJinete() {
        esJinete = true;
        resetearOtras(esSoldado,esCatapulta,esCurandero);
    }

    public void esUnaCatapulta() {
        esCatapulta = true;
        resetearOtras(esJinete,esSoldado,esCurandero);
    }

    public void limpiarPieza() {
        esSoldado = false;
        esJinete=false;
        esCurandero=false;
        esCatapulta=false;
    }

    public boolean soldado () {
        return esSoldado;
    }

    public boolean jinete() {
        return esJinete;
    }

    public boolean curandero () {
        return esCurandero;
    }

    public boolean catapulta () {
        return esCatapulta;
    }

    public ImageViewPiezaEnJuego() {
        super();
    }

    public void actualizarImagen(Image imagen) {
        ultimaImagen = imagen;
    }

    public Image devolverUltimaImagen () {
        return ultimaImagen;
    }

    public void borrarImagen() {
        ultimaImagen=null;
    }

    public AudioClip devolverAudio() {
        return audioColocada;
    }

    public AudioClip devolverAudioError () {
        return audioError;
    }
}
