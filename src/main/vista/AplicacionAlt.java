package vista;

import controller.HandlerCambiarLayout;
import controller.HandlerCrearTableroFinal;
import controller.HandlerNombreUsuarioNegro;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AplicacionAlt extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public double width;
    public double heigth;

    @Override
    public void start (Stage stage) throws Exception {

        OperadorDeDirectorios operadorDeDirectorios = new OperadorDeDirectorios();

        String directorio_resources = "C:/Users/gaspa/Desktop/Algo3/TP2/Algo3-TP2/src/main/resources/";

        GeneradorDeBotones generadorDeBotones = new GeneradorDeBotones(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fonts/Adventurer.ttf"));

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fonts/Adventurer.ttf"));

        stage.setTitle("AlgoChess");

        //1er Layout - Menu Inicial//

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre deseado");

        Button botonEnviar = generadorDeBotones.nuevoBoton("Aceptar");

        Button botonEmpezar = generadorDeBotones.nuevoBoton("Empezar juego");

        Label etiquetaJugadorBlanco = generadorDeEtiquetas.generarEtiquetaNegrita("Ingresar nombre del jugador blanco",18);

        ImageView imagenFondo = new ImageView(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fondo.jpg"));

        ImageView imagenFondoMenu = new ImageView(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("menufondo.png"));

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

        Button botonContinuar = generadorDeBotones.nuevoBoton("Continuar");

        ImageView fondo_compra_piezas = new ImageView (operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fondoCompraFichas.png"));

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

        ImageView imagenJinete = new ImageView(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("jinete.png"));
        ImageView imagenSoldado = new ImageView((operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("soldado.png")));
        ImageView imagenCatapulta = new ImageView((operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("catapulta.png")));
        ImageView imagenCurandero = new ImageView((operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("curandero.png")));

        VBox contenedorDescripcionesYBotones = new VBox ();
        contenedorDescripcionesYBotones.setSpacing(300);
        contenedorDescripcionesYBotones.setAlignment(Pos.CENTER);
        contenedorDescripcionesYBotones.getChildren().addAll (etiquetaPlaceholder,grupoBotones);

        contenedorDeFichas.getChildren().addAll(imagenJinete,imagenSoldado,imagenCatapulta,imagenCurandero);
        contenedorDeFichas.setSpacing(150);

        contenedorDeFichas.setMargin(imagenJinete,new Insets(45,0,0,0));
        contenedorDeFichas.setMargin(imagenSoldado,new Insets(20,0,0,20));
        contenedorDeFichas.setMargin(imagenCatapulta,new Insets(30,0,0,0));
        contenedorDeFichas.setMargin(imagenCurandero,new Insets(0,0,0,0));

        BorderPane menuCompraFichas = new BorderPane();
        menuCompraFichas.setCenter(contenedorDeFichas);
        menuCompraFichas.setTop(stackOro);
        menuCompraFichas.setBottom(contenedorDescripcionesYBotones);

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(fondo_compra_piezas,menuCompraFichas);

        // 3er Layout - Creacion tablero blanco //

        int[] cantidadFichasBlancas = {1,1,99,99}; // lo cambio por el getter de Juego

        Label distribuirPiezasBlancas = generadorDeEtiquetas.generarEtiquetaNegrita("JUGADOR BLANCO DISTRIBUYA SUS PIEZAS: ",30);

        ImageView fondo_tablero1 = new ImageView (operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fondo_tablero.png"));

        Button botonFinalizarColocadoPiezasBlancas = generadorDeBotones.nuevoBoton("Finalizar");

        HBox colocadoPiezasBlancas = new HBox(distribuirPiezasBlancas,botonFinalizarColocadoPiezasBlancas);
        colocadoPiezasBlancas.setSpacing(800);
        colocadoPiezasBlancas.setPadding(new Insets(20));
        colocadoPiezasBlancas.setMaxHeight(100);

        ImageViewPiezaEnJuego ultimaPiezaSeleccionada = new ImageViewPiezaEnJuego();

        GeneradorCajaFichasRestantes generadorCajaFichasRestantes = new GeneradorCajaFichasRestantes();
        StackPane cajaFichasBlancasRestantes = generadorCajaFichasRestantes.generarCajaFichasRestantes(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fichasBlancas/"),ultimaPiezaSeleccionada, generadorDeEtiquetas,cantidadFichasBlancas);

        GeneradorDeTablero generadorDeTablero = new GeneradorDeTablero ();
        GridPane tableroBlanco = generadorDeTablero.generarTablero(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("escaqueBlanco40.png"),ultimaPiezaSeleccionada);
        Group grupoTableroBlanco = new Group (tableroBlanco);

        BorderPane menuJugadorBlanco = new BorderPane();
        menuJugadorBlanco.setCenter (grupoTableroBlanco);
        menuJugadorBlanco.setBottom(cajaFichasBlancasRestantes);
        menuJugadorBlanco.setTop(colocadoPiezasBlancas);

        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(fondo_tablero1,menuJugadorBlanco);

        // 4to Layout - Creacion tablero negro //

        int[] cantidadFichasNegras = {2,2,99,99};

        Label distribuirPiezasNegras = generadorDeEtiquetas.generarEtiquetaNegrita("JUGADOR NEGRO DISTRIBUYA SUS PIEZAS: ",30);

        Button botonFinalizarColocadoPiezasNegras = generadorDeBotones.nuevoBoton("Finalizar");

        ImageView fondo_tablero2 = new ImageView (operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fondo_tablero.png"));

        StackPane cajaFichasNegrasRestantes = generadorCajaFichasRestantes.generarCajaFichasRestantes(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fichasNegras/"),ultimaPiezaSeleccionada,generadorDeEtiquetas,cantidadFichasNegras);

        HBox colocadoPiezasNegras = new HBox(distribuirPiezasNegras,botonFinalizarColocadoPiezasNegras);
        colocadoPiezasNegras.setSpacing(800);
        colocadoPiezasNegras.setPadding(new Insets(20));
        colocadoPiezasNegras.setMaxHeight(100);

        GridPane tableroNegro = generadorDeTablero.generarTablero(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("escaqueBlanco40.png"),ultimaPiezaSeleccionada);
        Group grupoTableroNegro = new Group (tableroNegro);

        BorderPane menuJugadorNegro = new BorderPane();
        menuJugadorNegro.setCenter (grupoTableroNegro);
        menuJugadorNegro.setTop (colocadoPiezasNegras);
        menuJugadorNegro.setBottom (cajaFichasNegrasRestantes);

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(fondo_tablero2,menuJugadorNegro);

        // 5to Layout - Creacion tablero final //

        GeneradorDeCajaAtaqueMovimientoAlt generadorDeCajaAtaqueMovimiento = new GeneradorDeCajaAtaqueMovimientoAlt();
        BorderPane campoJuegoFinal = generadorDeCajaAtaqueMovimiento.generarCajaAtaqueMovimiento();
        StackPane informacionPieza = new StackPane();
        ImageView fondoDetallesPieza = new ImageView(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("menuDetallesUnidad.png"));
        informacionPieza.getChildren().add(fondoDetallesPieza);
        Button terminarTurno = generadorDeBotones.nuevoBoton("TERMINAR TURNO");
        terminarTurno.setMaxSize(200,100);
        terminarTurno.setStyle("-fx-border-color: #000000; -fx-background-color: #ff0000; -fx-border-width: 2px");
        VBox vidaPieza = new VBox ();
        vidaPieza.setSpacing(100);
        Label vida = generadorDeEtiquetas.generarEtiquetaNegrita("- Vida: ",40);
        vida.setTextFill(Color.web("#FFFFFF"));
        Label ataques = generadorDeEtiquetas.generarEtiquetaNegrita("- Ataques: ",40);
        ataques.setTextFill(Color.web("#FFFFFF"));
        vidaPieza.getChildren().addAll(vida,ataques);
        informacionPieza.getChildren().add(vidaPieza);
        informacionPieza.getChildren().add(terminarTurno);
        campoJuegoFinal.setRight(informacionPieza);
        informacionPieza.setMargin(vidaPieza,new Insets(70,0,0,100));
        informacionPieza.setMargin(fondoDetallesPieza,new Insets(0,100,125,45));
        informacionPieza.setMargin(terminarTurno,new Insets(630,100,0,0));


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
