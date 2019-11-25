package vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public double width;
    public double heigth;

    @Override
    public void start (Stage stage) throws Exception {

        stage.setTitle("AlgoChess");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre deseado");

        Button botonEnviar = new Button();
        botonEnviar.setText("Aceptar");

        Label etiquetaJugador1 = new Label();
        etiquetaJugador1.setText("Ingrese nombre del Jugador 1");
        etiquetaJugador1.setFont (Font.font ("Verdana",20));
        etiquetaJugador1.setStyle ("-fx-font-weight: bold");

        ImageView imagenFondo = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fondo.jpg");

        ImageView imagenFondoMenu = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/menufondo.png");

        StackPane menuInicial = new StackPane ();
        menuInicial.getChildren().add(imagenFondo);

        HBox contenedorHorizontal = new HBox(botonEnviar);

        VBox contenedorPrincipal = new VBox(etiquetaJugador1, texto, contenedorHorizontal);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        StackPane menuNombreJugador = new StackPane ();
        menuNombreJugador.getChildren().addAll(imagenFondoMenu,contenedorPrincipal);

        Group grupoMenu = new Group(menuNombreJugador);
        menuInicial.getChildren().add(grupoMenu);
        menuInicial.setAlignment(grupoMenu,Pos.CENTER);

        Scene scene = new Scene(menuInicial,1600,1000);

        Button botonComprarSoldado = new Button ();
        botonComprarSoldado.setText ("Comprar Soldado");
        botonComprarSoldado.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        Button botonComprarJinete = new Button ();
        botonComprarJinete.setText ("Comprar Jinete");
        botonComprarJinete.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        Button botonComprarCatapulta = new Button ();
        botonComprarCatapulta.setText ("Comprar Catapulta");
        botonComprarCatapulta.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        Button botonComprarCurandero = new Button ();
        botonComprarCurandero.setText ("Comprar Curandero");
        botonComprarCurandero.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);

        HBox contenedorDeFichas = new HBox();

        HBox contenedorDeBotones = new HBox();
        contenedorDeBotones.setSpacing(250);

        contenedorDeBotones.getChildren().add(botonComprarJinete);
        contenedorDeBotones.getChildren().add(botonComprarSoldado);
        contenedorDeBotones.getChildren().add(botonComprarCatapulta);
        contenedorDeBotones.getChildren().add(botonComprarCurandero);

        Group grupoBotones = new Group(contenedorDeBotones);

        Label oroRestante = new Label();
        oroRestante.setText("ORO RESTANTE: ");
        oroRestante.setFont (Font.font ("Verdana",30));
        oroRestante.setStyle ("-fx-font-weight: bold");

        Button botonReset = new Button ();
        botonReset.setText ("Resetear");

        HBox stackOro = new HBox(botonReset,oroRestante);
        stackOro.setSpacing(500);
        stackOro.setPadding(new Insets(20));
        stackOro.setMaxHeight(100);

        BorderPane border = new BorderPane();

        ImageView imagenPlaceholder1 = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/descripcionUnidades.jpg");
        ImageView imagenPlaceholder2 = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/descripcionUnidades.jpg");
        ImageView imagenPlaceholder3 = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/descripcionUnidades.jpg");
        ImageView imagenPlaceholder4 = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/descripcionUnidades.jpg");

        HBox contenedorDeDescripciones = new HBox();

        contenedorDeDescripciones.getChildren().add(imagenPlaceholder1);
        contenedorDeDescripciones.getChildren().add(imagenPlaceholder2);
        contenedorDeDescripciones.getChildren().add(imagenPlaceholder3);
        contenedorDeDescripciones.getChildren().add(imagenPlaceholder4);

        ImageView imagenJinete = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/jinete.jpg"));
        ImageView imagenSoldado = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/soldado.png"));
        ImageView imagenCatapulta = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/catapulta.png"));
        ImageView imagenCurandero = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/curandero.png"));

        StackPane menuCompraFichas = new StackPane ();
        menuCompraFichas.getChildren().addAll (contenedorDeDescripciones,grupoBotones);
        menuCompraFichas.setAlignment(grupoBotones, Pos.BOTTOM_CENTER);

        contenedorDeFichas.getChildren().add(imagenJinete);
        contenedorDeFichas.getChildren().add(imagenSoldado);
        contenedorDeFichas.getChildren().add(imagenCatapulta);
        contenedorDeFichas.getChildren().add(imagenCurandero);
        border.setCenter(contenedorDeFichas);
        border.setTop(stackOro);
        border.setBottom(menuCompraFichas);

        botonEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene.setRoot(border);
            }
        });

        stage.setScene(scene);

        stage.show();

    }
}
