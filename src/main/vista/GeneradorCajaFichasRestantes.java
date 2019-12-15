package vista;

import controller.HandlerActualizarImagen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GeneradorCajaFichasRestantes {

    String directorioElementos;
    ImageViewPiezaEnJuego ultimaPiezaSeleccionada;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    VBox contenedorFichasBotones;

    public GeneradorCajaFichasRestantes (String directorio, ImageViewPiezaEnJuego ultimaPieza, GeneradorDeEtiquetas generador) {
        this.directorioElementos = directorio;
        this.ultimaPiezaSeleccionada = ultimaPieza;
        this.generadorDeEtiquetas = generador;

    }

    public StackPane generarCajaFichasRestantes(int[] cantidadFichas) {

        HBox soldadosRestantes = new HBox();
        HBox jinetesRestantes = new HBox();
        HBox curanderosRestantes = new HBox();
        HBox catapultasRestantes = new HBox();

        ImageView imagenFichaSoldado = new ImageView(directorioElementos+"fichaSoldado.png");
        imagenFichaSoldado.setOnMouseClicked(new HandlerActualizarImagen(soldadosRestantes,ultimaPiezaSeleccionada,directorioElementos+"fichaSoldado32.png",generadorDeEtiquetas,cantidadFichas[0],"Soldado"));
        ImageView imagenFichaJinete = new ImageView(directorioElementos+"fichaJinete.png");
        imagenFichaJinete.setOnMouseClicked(new HandlerActualizarImagen(jinetesRestantes,ultimaPiezaSeleccionada,directorioElementos+"fichaJinete32.png",generadorDeEtiquetas,cantidadFichas[1],"Jinete"));
        ImageView imagenFichaCurandero = new ImageView(directorioElementos+"fichaCurandero.png");
        imagenFichaCurandero.setOnMouseClicked(new HandlerActualizarImagen(curanderosRestantes,ultimaPiezaSeleccionada,directorioElementos+"fichaCurandero32.png",generadorDeEtiquetas,cantidadFichas[2],"Curandero"));
        ImageView imagenFichaCatapulta = new ImageView(directorioElementos+"fichaCatapulta.png");
        imagenFichaCatapulta.setOnMouseClicked(new HandlerActualizarImagen(catapultasRestantes,ultimaPiezaSeleccionada,directorioElementos+"fichaCatapulta32.png",generadorDeEtiquetas,cantidadFichas[3],"Catapulta"));

        StackPane cajaFichasRestantes = new StackPane();

        Label etiquetaSoldadosRestantes= new Label();
        Label etiquetaJinetesRestantes=new Label();
        Label etiquetaCuranderosRestantes = new Label();
        Label etiquetaCatapultasRestantes = new Label();

        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaSoldadosRestantes,"x"+Integer.toString(cantidadFichas[0]),40);
        soldadosRestantes.getChildren().addAll(imagenFichaSoldado,etiquetaSoldadosRestantes);
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaJinetesRestantes,"x"+Integer.toString(cantidadFichas[1]),40);
        jinetesRestantes.getChildren().addAll(imagenFichaJinete,etiquetaJinetesRestantes);
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaCuranderosRestantes,"x"+Integer.toString(cantidadFichas[2]),40);
        curanderosRestantes.getChildren().addAll(imagenFichaCurandero,etiquetaCuranderosRestantes);
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaCatapultasRestantes,"x"+Integer.toString(cantidadFichas[3]),40);
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
