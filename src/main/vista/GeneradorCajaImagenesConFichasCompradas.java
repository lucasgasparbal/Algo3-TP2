package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.AlgoChess.Juego;

public class GeneradorCajaImagenesConFichasCompradas {

    private HBox piezas;
    private String directorio_resources;
    GeneradorDeEtiquetas generadorDeEtiquetas;

    public GeneradorCajaImagenesConFichasCompradas(String directorio, HBox piezasCompradas, GeneradorDeEtiquetas generador) {
        this.directorio_resources = directorio;
        this.piezas = piezasCompradas;
        this.generadorDeEtiquetas = generador;
    }

    public VBox generar(int[] cantidadDeFichas) {
        VBox contenedorADevolver = new VBox();
        HBox contenedorImagenes = new HBox();
        ImageView imagenJinete = new ImageView((directorio_resources+"jinete.png"));
        ImageView imagenSoldado = new ImageView((directorio_resources+"soldado.png"));
        ImageView imagenCatapulta = new ImageView((directorio_resources+"catapulta.png"));
        ImageView imagenCurandero = new ImageView((directorio_resources+"curandero.png"));
        Label soldadosComprados = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label jinetesComprados = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label curanderosComprados = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        Label catapultasCompradas = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(),"0",30,"#00FF00");
        piezas.getChildren().addAll(jinetesComprados,soldadosComprados,catapultasCompradas,curanderosComprados);
        piezas.setAlignment(Pos.CENTER);
        piezas.setSpacing(400);
        contenedorImagenes.getChildren().addAll(imagenJinete,imagenSoldado,imagenCatapulta,imagenCurandero);
        contenedorImagenes.setSpacing(150);
        contenedorImagenes.setMargin(imagenJinete,new Insets(45,0,0,50));
        contenedorImagenes.setMargin(imagenSoldado,new Insets(20,0,0,20));
        contenedorImagenes.setMargin(imagenCatapulta,new Insets(30,0,0,0));
        contenedorImagenes.setMargin(imagenCurandero,new Insets(0,0,0,0));
        contenedorADevolver.getChildren().addAll(contenedorImagenes,piezas);
        return contenedorADevolver;
    }
}
