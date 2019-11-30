package vista;

import controller.HandlerCambiarLayout;
import controller.HandlerCrearTableroFinal;
import controller.HandlerActualizarImagen;
import controller.HandlerNombreUsuarioNegro;
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

        String directorio_resources = "file:/home/facundo/IdeaProjects/TP2/src/resources/";

        GeneradorDeBotones generadorDeBotones = new GeneradorDeBotones(directorio_resources+"fonts/Adventurer.ttf");

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas(directorio_resources+"fonts/Adventurer.ttf");

        stage.setTitle("AlgoChess");

        //1er Layout - Menu Inicial//

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre deseado");

        Button botonEnviar = new Button();
        botonEnviar.setText("Aceptar");

        Button botonEmpezar = new Button();
        botonEmpezar.setText("Empezar Juego");

        Label etiquetaJugadorBlanco = generadorDeEtiquetas.generarEtiquetaNegrita("Ingresar nombre del jugador blanco",18);

        ImageView imagenFondo = new ImageView(directorio_resources+"fondo.jpg");

        ImageView imagenFondoMenu = new ImageView(directorio_resources+"menufondo.png");

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

        ImageView fondo_compra_piezas = new ImageView (directorio_resources+"fondoCompraFichas.png");

        Button botonComprarSoldado = generadorDeBotones.nuevoBoton("Comprar Soldado");
        Button botonComprarJinete = generadorDeBotones.nuevoBoton("Comprar Jinete");
        Button botonComprarCatapulta = generadorDeBotones.nuevoBoton("Comprar Catapulta");
        Button botonComprarCurandero = generadorDeBotones.nuevoBoton("Comprar Curandero");

        HBox contenedorDeFichas = new HBox();

        HBox contenedorDeBotones = new HBox();
        contenedorDeBotones.setSpacing(275);
        contenedorDeBotones.getChildren().addAll (botonComprarJinete,botonComprarSoldado, botonComprarCatapulta, botonComprarCurandero);
        contenedorDeBotones.setAlignment(Pos.CENTER);
        Group grupoBotones = new Group(contenedorDeBotones);

        Label etiquetaOroRestante = generadorDeEtiquetas.generarEtiquetaNegrita("ORO RESTANTE: ",30);
        etiquetaOroRestante.setTextFill(Color.web("#ffd700"));

        Button botonReset = generadorDeBotones.nuevoBoton("Vender todas las piezas");

        HBox stackOro = new HBox(botonReset,etiquetaOroRestante,botonContinuar);
        stackOro.setSpacing(500);
        stackOro.setPadding(new Insets(20));
        stackOro.setMaxHeight(100);

        Label etiquetaPlaceholder = generadorDeEtiquetas.generarEtiquetaNegrita("PLACEHOLDER DESCRIPCIONES",40);
        etiquetaPlaceholder.setTextFill(Color.web("#ffd700"));

        ImageView imagenJinete = new ImageView((directorio_resources+"jinete.jpg"));
        ImageView imagenSoldado = new ImageView((directorio_resources+"soldado.png"));
        ImageView imagenCatapulta = new ImageView((directorio_resources+"catapulta.png"));
        ImageView imagenCurandero = new ImageView((directorio_resources+"curandero.png"));

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

        ImageView fondo_tablero1 = new ImageView (directorio_resources+"fondo_tablero.png");

        Button botonFinalizarColocadoPiezasBlancas = generadorDeBotones.nuevoBoton("Finalizar");

        HBox colocadoPiezasBlancas = new HBox(distribuirPiezasBlancas,botonFinalizarColocadoPiezasBlancas);
        colocadoPiezasBlancas.setSpacing(600);
        colocadoPiezasBlancas.setPadding(new Insets(20));
        colocadoPiezasBlancas.setMaxHeight(100);

        ImageViewPiezaEnJuego ultimaPiezaSeleccionada = new ImageViewPiezaEnJuego();
        ImageView imagenFichaCatapulta = new ImageView(directorio_resources+"fichaCatapulta.png");
        imagenFichaCatapulta.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"catapultaEnCasilleroBlanco.png"));
        ImageView imagenFichaSoldado = new ImageView(directorio_resources+"fichaSoldado.png");
        imagenFichaSoldado.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"soldadoEnCasilleroBlanco.png"));
        ImageView imagenFichaJinete = new ImageView(directorio_resources+"fichaJinete.png");
        imagenFichaJinete.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"jineteEnCasilleroBlanco.png"));
        ImageView imagenFichaCurandero = new ImageView(directorio_resources+"fichaCurandero.png");
        imagenFichaCurandero.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"curanderoEnCasilleroBlanco.png"));

        GeneradorDeTablero generadorDeTablero = new GeneradorDeTablero ();

        GridPane tableroBlanco = generadorDeTablero.generarTablero(directorio_resources+"escaqueBlanco40.png",ultimaPiezaSeleccionada);
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

        ImageView fondo_tablero2 = new ImageView (directorio_resources+"fondo_tablero.png");

        HBox colocadoPiezasNegras = new HBox(distribuirPiezasNegras,botonFinalizarColocadoPiezasNegras);
        colocadoPiezasNegras.setSpacing(600);
        colocadoPiezasNegras.setPadding(new Insets(20));
        colocadoPiezasNegras.setMaxHeight(100);

        GridPane tableroNegro = generadorDeTablero.generarTablero("file:/home/facundo/IdeaProjects/TP2/src/resources/escaqueNegro40.png",ultimaPiezaSeleccionada);
        Group grupoTableroNegro = new Group (tableroNegro);

        ImageView imagenFichaCatapultaNegra = new ImageView(directorio_resources+"fichaCatapultaNegra.png");
        imagenFichaCatapultaNegra.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"catapultaEnCasilleroNegro.png"));
        ImageView imagenFichaSoldadoNegro = new ImageView(directorio_resources+"fichaSoldadoNegro.png");
        imagenFichaSoldadoNegro.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"soldadoEnCasilleroNegro.png"));
        ImageView imagenFichaJineteNegro = new ImageView(directorio_resources+"fichaJineteNegro.png");
        imagenFichaJineteNegro.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"jineteEnCasilleroNegro.png"));
        ImageView imagenFichaCuranderoNegro = new ImageView(directorio_resources+"fichaCuranderoNegro.png");
        imagenFichaCuranderoNegro.setOnMouseClicked(new HandlerActualizarImagen(ultimaPiezaSeleccionada,directorio_resources+"curanderoEnCasilleroNegro.png"));

        HBox contenedorFichasNegrasEnJuego = new HBox ();
        contenedorFichasNegrasEnJuego.getChildren().addAll(imagenFichaCatapultaNegra,imagenFichaSoldadoNegro,imagenFichaJineteNegro,imagenFichaCuranderoNegro);

        BorderPane menuJugadorNegro = new BorderPane();
        menuJugadorNegro.setCenter (grupoTableroNegro);
        menuJugadorNegro.setTop (colocadoPiezasNegras);
        menuJugadorNegro.setBottom (contenedorFichasNegrasEnJuego);

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(fondo_tablero2,menuJugadorNegro);

        // 5to Layout - Creacion tablero final //

        GeneradorDeCajaAtaqueMovimiento generadorDeCajaAtaqueMovimiento = new GeneradorDeCajaAtaqueMovimiento(directorio_resources);
        BorderPane campoJuegoFinal = generadorDeCajaAtaqueMovimiento.generarCajaAtaqueMovimiento();

        //Botones Ataque/Movimiento //

        // 5to Layout - Creacion tablero final //
        botonFinalizarColocadoPiezasNegras.setOnAction(new HandlerCrearTableroFinal(scene,tableroBlanco,tableroNegro,campoJuegoFinal));

        // Botones //

        botonEnviar.setOnAction(new HandlerNombreUsuarioNegro(menuNombreJugador,contenedorPrincipal,botonEmpezar,generadorDeEtiquetas));

        botonEmpezar.setOnAction(new HandlerCambiarLayout(stackPane1,scene));

        botonContinuar.setOnAction(new HandlerCambiarLayout(stackPane2,scene));

        botonFinalizarColocadoPiezasBlancas.setOnAction(new HandlerCambiarLayout(stackPane3,scene));

        stage.setScene(scene);

        stage.show();
    }
}
