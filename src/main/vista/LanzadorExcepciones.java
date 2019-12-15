package vista;

import javafx.animation.SequentialTransition;
import javafx.scene.Group;
import javafx.scene.control.Label;
import vista.GeneradorDeEtiquetas;

public class LanzadorExcepciones {

    GeneradorDeEtiquetas generadorDeEtiquetas;

    public LanzadorExcepciones (GeneradorDeEtiquetas generador) {
        this.generadorDeEtiquetas = generador;
    }

    public void lanzarExcepcion (String textoDelError, Group contenedorErrores) {
        Label errorAImprimir = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(), textoDelError,30,"#FF0000");
        MensajeDeError mensajeDeError = new MensajeDeError();
        SequentialTransition error = mensajeDeError.generarAvisoParpadeante(errorAImprimir);
        contenedorErrores.getChildren().clear();
        contenedorErrores.getChildren().add(errorAImprimir);
        error.play();
    }
}
