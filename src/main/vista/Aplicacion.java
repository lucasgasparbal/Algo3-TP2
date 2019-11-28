package vista;

import controller.HandlerCambiarLayout;
import controller.HandlerCrearTableroFinal;
import controller.HandlerActualizarImagen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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

        //1er Layout - Menu Inicial//

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas("Verdana");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre deseado");

        Button botonEnviar = new Button();
        botonEnviar.setText("Aceptar");

        Label etiquetaJugadorBlanco = generadorDeEtiquetas.generarEtiquetaNegrita("Ingresar nombre del jugador blanco",18);
        Label etiquetaJugadorNegro = generadorDeEtiquetas.generarEtiquetaNegrita("Ingresar nombre del jugador negro",18);

        ImageView imagenFondo = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fondo.jpg");

        ImageView imagenFondoMenu = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/menufondo.png");

        StackPane menuInicial = new StackPane ();
        menuInicial.getChildren().add(imagenFondo);

        HBox contenedorHorizontal = new HBox(botonEnviar);

        VBox contenedorPrincipal = new VBox(etiquetaJugadorBlanco, texto, contenedorHorizontal);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        StackPane menuNombreJugador = new StackPane ();
        menuNombreJugador.getChildren().addAll(imagenFondoMenu,contenedorPrincipal);

        Group grupoMenu = new Group(menuNombreJugador);
        menuInicial.getChildren().add(grupoMenu);
        menuInicial.setAlignment(grupoMenu,Pos.CENTER);

        Scene scene = new Scene (menuInicial,1600,1000);

        // 2do Layout - Compra de Fichas //

        Button botonContinuar = new Button();
        botonContinuar.setText ("Continuar");

        GeneradorDeBotones generadorDeBotones = new GeneradorDeBotones();

        ImageView fondo_compra_piezas = new ImageView ("file:/home/facundo/IdeaProjects/TP2/src/resources/fondoCompraFichas.png");

        Button botonComprarSoldado = generadorDeBotones.nuevoBoton("Comprar Soldado");
        Button botonComprarJinete = generadorDeBotones.nuevoBoton("Comprar Jinete");
        Button botonComprarCatapulta = generadorDeBotones.nuevoBoton("Comprar Catapulta");
        Button botonComprarCurandero = generadorDeBotones.nuevoBoton("Comprar Curandero");

        HBox contenedorDeFichas = new HBox();

        HBox contenedorDeBotones = new HBox();
        contenedorDeBotones.setSpacing(350);
        contenedorDeBotones.getChildren().addAll (botonComprarJinete,botonComprarSoldado, botonComprarCatapulta, botonComprarCurandero);
        Group grupoBotones = new Group(contenedorDeBotones);

        Label etiquetaOroRestante = generadorDeEtiquetas.generarEtiquetaNegrita("ORO RESTANTE: ",30);
        etiquetaOroRestante.setTextFill(Color.web("#ffd700"));

        Button botonReset = generadorDeBotones.nuevoBoton("Vender todas las piezas");

        HBox stackOro = new HBox(botonReset,etiquetaOroRestante,botonContinuar);
        stackOro.setSpacing(500);
        stackOro.setPadding(new Insets(20));
        stackOro.setMaxHeight(100);

        Label etiquetaPlaceholder = generadorDeEtiquetas.generarEtiquetaNegrita("PLACEHOLDER DESCRIPCIONES",40);
        etiquetaPlaceholder.setTextFill(Color.web("#8b0000"));

        ImageView imagenJinete = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/jinete.jpg"));
        ImageView imagenSoldado = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/soldado.png"));
        ImageView imagenCatapulta = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/catapulta.png"));
        ImageView imagenCurandero = new ImageView(("file:/home/facundo/IdeaProjects/TP2/src/resources/curandero.png"));

        VBox contenedorDescripcionesYBotones = new VBox ();
        contenedorDescripcionesYBotones.setSpacing(300);
        contenedorDescripcionesYBotones.setAlignment(Pos.CENTER);
        contenedorDescripcionesYBotones.getChildren().addAll (etiquetaPlaceholder,grupoBotones);

        contenedorDeFichas.getChildren().addAll(imagenJinete,imagenSoldado,imagenCatapulta,imagenCurandero);

        BorderPane menuCompraFichas = new BorderPane();
        menuCompraFichas.setCenter(contenedorDeFichas);
        menuCompraFichas.setTop(stackOro);
        menuCompraFichas.setBottom(contenedorDescripcionesYBotones);

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(fondo_compra_piezas,menuCompraFichas);

        // 3er Layout - Creacion tablero blanco //

        Label distribuirPiezasBlancas = generadorDeEtiquetas.generarEtiquetaNegrita("JUGADOR BLANCO DISTRIBUYA SUS PIEZAS: ",30);

        ImageView fondo_tablero1 = new ImageView ("file:/home/facundo/IdeaProjects/TP2/src/resources/fondo_tablero.png");

        Button botonFinalizarColocadoPiezasBlancas = generadorDeBotones.nuevoBoton("Finalizar");

        HBox colocadoPiezasBlancas = new HBox(distribuirPiezasBlancas,botonFinalizarColocadoPiezasBlancas);
        colocadoPiezasBlancas.setSpacing(600);
        colocadoPiezasBlancas.setPadding(new Insets(20));
        colocadoPiezasBlancas.setMaxHeight(100);

        ImageViewPiezaEnJuego ultimaPiezaSeleccionada = new ImageViewPiezaEnJuego();
        ImageView imagenFichaCatapulta = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaCatapulta.png");
        imagenFichaCatapulta.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/catapultaEnCasilleroBlanco.png"));
        ImageView imagenFichaSoldado = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaSoldado.png");
        imagenFichaSoldado.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/soldadoEnCasilleroBlanco.png"));
        ImageView imagenFichaJinete = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaJinete.png");
        imagenFichaJinete.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/jineteEnCasilleroBlanco.png"));
        ImageView imagenFichaCurandero = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaCurandero.png");
        imagenFichaCurandero.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/curanderoEnCasilleroBlanco.png"));

        GeneradorDeTablero generadorDeTablero = new GeneradorDeTablero ();

        GridPane tableroBlanco = generadorDeTablero.generarTablero("file:/home/facundo/IdeaProjects/TP2/src/resources/escaqueBlanco40.png",ultimaPiezaSeleccionada);
        Group grupoTableroBlanco = new Group (tableroBlanco);

        HBox contenedorFichasBlancasEnJuego = new HBox ();
        contenedorFichasBlancasEnJuego.getChildren().addAll(imagenFichaCatapulta,imagenFichaSoldado,imagenFichaJinete,imagenFichaCurandero);

        BorderPane menuJugadorBlanco = new BorderPane();
        menuJugadorBlanco.setCenter (grupoTableroBlanco);
        menuJugadorBlanco.setBottom(contenedorFichasBlancasEnJuego);
        menuJugadorBlanco.setTop(colocadoPiezasBlancas);

        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(fondo_tablero1,menuJugadorBlanco);

        // 4to Layout - Creacion tablero negro //

        Label distribuirPiezasNegras = generadorDeEtiquetas.generarEtiquetaNegrita("JUGADOR NEGRO DISTRIBUYA SUS PIEZAS: ",30);

        Button botonFinalizarColocadoPiezasNegras = generadorDeBotones.nuevoBoton("Finalizar");

        ImageView fondo_tablero2 = new ImageView ("file:/home/facundo/IdeaProjects/TP2/src/resources/fondo_tablero.png");

        HBox colocadoPiezasNegras = new HBox(distribuirPiezasNegras,botonFinalizarColocadoPiezasNegras);
        colocadoPiezasNegras.setSpacing(600);
        colocadoPiezasNegras.setPadding(new Insets(20));
        colocadoPiezasNegras.setMaxHeight(100);

        GridPane tableroNegro = generadorDeTablero.generarTablero("file:/home/facundo/IdeaProjects/TP2/src/resources/escaqueNegro40.png",ultimaPiezaSeleccionada);
        Group grupoTableroNegro = new Group (tableroNegro);

        ImageView imagenFichaCatapultaNegra = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaCatapultaNegra.png");
        imagenFichaCatapultaNegra.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/catapultaEnCasilleroNegro.png"));
        ImageView imagenFichaSoldadoNegro = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaSoldadoNegro.png");
        imagenFichaSoldadoNegro.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/soldadoEnCasilleroNegro.png"));
        ImageView imagenFichaJineteNegro = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaJineteNegro.png");
        imagenFichaJineteNegro.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/jineteEnCasilleroNegro.png"));
        ImageView imagenFichaCuranderoNegro = new ImageView("file:/home/facundo/IdeaProjects/TP2/src/resources/fichaCuranderoNegro.png");
        imagenFichaCuranderoNegro.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,"file:/home/facundo/IdeaProjects/TP2/src/resources/curanderoEnCasilleroNegro.png"));

        HBox contenedorFichasNegrasEnJuego = new HBox ();
        contenedorFichasNegrasEnJuego.getChildren().addAll(imagenFichaCatapultaNegra,imagenFichaSoldadoNegro,imagenFichaJineteNegro,imagenFichaCuranderoNegro);

        BorderPane menuJugadorNegro = new BorderPane();
        menuJugadorNegro.setCenter (grupoTableroNegro);
        menuJugadorNegro.setTop (colocadoPiezasNegras);
        menuJugadorNegro.setBottom (contenedorFichasNegrasEnJuego);

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(fondo_tablero2,menuJugadorNegro);

        // 5to Layout - Creacion tablero final //
        botonFinalizarColocadoPiezasNegras.setOnAction(new HandlerCrearTableroFinal(scene,tableroBlanco,tableroNegro));

        // Botones //

        botonEnviar.setOnAction(new HandlerCambiarLayout(stackPane1,scene));

        botonFinalizarColocadoPiezasNegras.setOnAction(new HandlerCrearTableroFinal(scene,tableroBlanco,tableroNegro));

        botonContinuar.setOnAction(new HandlerCambiarLayout(stackPane2,scene));

        botonFinalizarColocadoPiezasBlancas.setOnAction(new HandlerCambiarLayout(stackPane3,scene));

        stage.setScene(scene);

        stage.show();
    }
}
