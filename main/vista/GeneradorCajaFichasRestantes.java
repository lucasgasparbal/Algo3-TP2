package vista;

import controller.HandlerActualizarImagen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class GeneradorCajaFichasRestantes {

    public StackPane generarCajaFichasRestantes(String directorioElementos, ImageViewPiezaEnJuego ultimaPiezaSeleccionada, GeneradorDeEtiquetas generadorDeEtiquetas, int[] cantidadFichas) {

        HBox soldadosRestantes = new HBox();
        HBox jinetesRestantes = new HBox();
        HBox curanderosRestantes = new HBox();
        HBox catapultasRestantes = new HBox();

        ImageView imagenFichaSoldado = new ImageView(directorioElementos+"fichaSoldado.png");
        imagenFichaSoldado.setOnMouseClicked(new HandlerActualizarImagen(soldadosRestantes,ultimaPiezaSeleccionada,directorioElementos+"soldadoEnCasillero.png",generadorDeEtiquetas,cantidadFichas[0]));
        ImageView imagenFichaJinete = new ImageView(directorioElementos+"fichaJinete.png");
        imagenFichaJinete.setOnMouseClicked(new HandlerActualizarImagen(jinetesRestantes,ultimaPiezaSeleccionada,directorioElementos+"jineteEnCasillero.png",generadorDeEtiquetas,cantidadFichas[1]));
        ImageView imagenFichaCurandero = new ImageView(directorioElementos+"fichaCurandero.png");
        imagenFichaCurandero.setOnMouseClicked(new HandlerActualizarImagen(curanderosRestantes,ultimaPiezaSeleccionada,directorioElementos+"curanderoEnCasillero.png",generadorDeEtiquetas,cantidadFichas[2]));
        ImageView imagenFichaCatapulta = new ImageView(directorioElementos+"fichaCatapulta.png");
        imagenFichaCatapulta.setOnMouseClicked(new HandlerActualizarImagen(catapultasRestantes,ultimaPiezaSeleccionada,directorioElementos+"catapultaEnCasillero.png",generadorDeEtiquetas,cantidadFichas[3]));

        StackPane cajaFichasRestantes = new StackPane();

        Label etiquetaSoldadosRestantes = generadorDeEtiquetas.generarEtiquetaNegrita("x"+Integer.toString(cantidadFichas[0]),40);
        soldadosRestantes.getChildren().addAll(imagenFichaSoldado,etiquetaSoldadosRestantes);
        Label etiquetaJinetesRestantes = generadorDeEtiquetas.generarEtiquetaNegrita("x"+Integer.toString(cantidadFichas[1]),40);
        jinetesRestantes.getChildren().addAll(imagenFichaJinete,etiquetaJinetesRestantes);
        Label etiquetaCuranderosRestantes = generadorDeEtiquetas.generarEtiquetaNegrita("x"+Integer.toString(cantidadFichas[2]),40);
        curanderosRestantes.getChildren().addAll(imagenFichaCurandero,etiquetaCuranderosRestantes);
        Label etiquetaCatapultasRestantes = generadorDeEtiquetas.generarEtiquetaNegrita("x"+Integer.toString(cantidadFichas[3]),40);
        catapultasRestantes.getChildren().addAll(imagenFichaCatapulta,etiquetaCatapultasRestantes);

        ImageView imagenCajaFichas = new ImageView(directorioElementos+"cajaFichas.png");

        HBox fichasRestantes = new HBox (soldadosRestantes,jinetesRestantes,curanderosRestantes,catapultasRestantes);
        fichasRestantes.setSpacing(200);

        Group nuevoGrupo = new Group(fichasRestantes);

        cajaFichasRestantes.getChildren().addAll(imagenCajaFichas,nuevoGrupo);
        cajaFichasRestantes.setAlignment(nuevoGrupo, Pos.CENTER_LEFT);
        cajaFichasRestantes.setMargin(nuevoGrupo,new Insets(0,0,0,125));

        return cajaFichasRestantes;
    }
}
