package vista;

import controller.*;
import javafx.animation.SequentialTransition;
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
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import model.AlgoChess.Juego;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public double width;
    public double heigth;

    @Override
    public void start (Stage stage) throws Exception {

        Juego juego = new Juego();

        String directorio_resources = "file:/home/facundo/IdeaProjects/TP2/src/resources/";

        GeneradorDeBotones generadorDeBotones = new GeneradorDeBotones(directorio_resources+"fonts/Adventurer.ttf");

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas(directorio_resources+"fonts/Adventurer.ttf");

        stage.setTitle("AlgoChess");

        String nombreJugadorBlanco="";
        String nombreJugadorNegro="";

        //1er Layout - Menu Inicial//

        TextField textoJugadorBlanco = new TextField();
        textoJugadorBlanco.setPromptText("Ingrese el nombre deseado");
        TextField textoJugadorNegro = new TextField();
        textoJugadorNegro.setPromptText("Ingrese el nombre deseado");

        Button botonEnviar = generadorDeBotones.nuevoBoton("Aceptar");

        Button botonEmpezar = generadorDeBotones.nuevoBoton("Empezar juego");

        Label etiquetaJugadorBlanco = new Label ();

        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaJugadorBlanco,"Ingresar nombre del jugador blanco",18);

        ImageView imagenFondo = new ImageView(directorio_resources+"fondo.jpg");

        ImageView imagenFondoMenu = new ImageView(directorio_resources+"menufondo.png");

        StackPane menuInicial = new StackPane ();
        menuInicial.getChildren().add(imagenFondo);

        HBox contenedorHorizontal = new HBox(botonEnviar);

        VBox contenedorPrincipal = new VBox(etiquetaJugadorBlanco, textoJugadorBlanco, contenedorHorizontal);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        StackPane menuNombreJugador = new StackPane ();
        menuNombreJugador.getChildren().addAll(imagenFondoMenu,contenedorPrincipal);

        Group grupoMenu = new Group(menuNombreJugador);
        menuInicial.getChildren().add(grupoMenu);
        menuInicial.setAlignment(grupoMenu,Pos.CENTER);

        Scene scene = new Scene (menuInicial,1600,1000);

        // 2do Layout - Compra de Fichas //

        Label noHayOroError = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(), "No hay suficiente oro",30,"#FF0000");

        noHayOroError.setVisible(false);

        MensajeDeError mensajeDeError = new MensajeDeError();

        SequentialTransition oroError = mensajeDeError.generarAvisoParpadeante(noHayOroError);

        Button botonComenzarJuego = generadorDeBotones.nuevoBoton("Colocar piezas");

        ImageView fondo_compra_piezas = new ImageView (directorio_resources+"fondoCompraFichas.png");

        Label etiquetaOroRestante = new Label();

        HBox etiquetasPiezasRestantes = new HBox();

        VBox contenedorDescripcionesYBotones = new VBox ();

        int[] cantidadFichas = juego.conseguirCantidadPiezasEnBanquilla();

        GeneradorCajaImagenesConFichasCompradas generadorCajaImagenesConFichasCompradas = new GeneradorCajaImagenesConFichasCompradas(directorio_resources,etiquetasPiezasRestantes,generadorDeEtiquetas, contenedorDescripcionesYBotones);
        VBox cajaImagenesFichasCompradas = generadorCajaImagenesConFichasCompradas.generar(cantidadFichas);

        Button botonComprarSoldado = generadorDeBotones.nuevoBoton("Comprar Soldado");
        botonComprarSoldado.setOnAction(new HandlerComprarSoldado(juego,etiquetaOroRestante,generadorDeEtiquetas,etiquetasPiezasRestantes,noHayOroError,oroError));
        Button botonComprarJinete = generadorDeBotones.nuevoBoton("Comprar Jinete");
        botonComprarJinete.setOnAction(new HandlerComprarJinete(juego,etiquetaOroRestante,generadorDeEtiquetas,etiquetasPiezasRestantes,noHayOroError,oroError));
        Button botonComprarCatapulta = generadorDeBotones.nuevoBoton("Comprar Catapulta");
        botonComprarCatapulta.setOnAction(new HandlerComprarCatapulta(juego,etiquetaOroRestante,generadorDeEtiquetas,etiquetasPiezasRestantes,noHayOroError,oroError));
        Button botonComprarCurandero = generadorDeBotones.nuevoBoton("Comprar Curandero");
        botonComprarCurandero.setOnAction(new HandlerComprarCurandero(juego,etiquetaOroRestante,generadorDeEtiquetas,etiquetasPiezasRestantes,noHayOroError,oroError));

        HBox contenedorDeBotones = new HBox();
        contenedorDeBotones.setSpacing(275);
        contenedorDeBotones.getChildren().addAll (botonComprarJinete,botonComprarSoldado, botonComprarCatapulta, botonComprarCurandero);
        contenedorDeBotones.setAlignment(Pos.CENTER);
        Group grupoBotones = new Group(contenedorDeBotones);

        Button botonReset = generadorDeBotones.nuevoBoton("Vender todas las piezas");
        botonReset.setOnAction(new HandlerVenderTodasLasPiezas(juego,etiquetaOroRestante,generadorDeEtiquetas,etiquetasPiezasRestantes));

        Button botonComprarFichasNegras = generadorDeBotones.nuevoBoton("Siguiente");

        HBox stackOro = new HBox(botonReset,etiquetaOroRestante,noHayOroError,botonComprarFichasNegras);
        stackOro.setAlignment(Pos.CENTER);
        stackOro.setSpacing(200);
        stackOro.setPadding(new Insets(20));
        stackOro.setMargin(etiquetaOroRestante,new Insets(0,0,0,130));
        stackOro.setMaxHeight(100);

        botonComprarFichasNegras.setOnAction(new HandlerCompraFichasNegras(juego,stackOro,etiquetaOroRestante,botonComenzarJuego,generadorDeEtiquetas,etiquetasPiezasRestantes));

        Label etiquetaPlaceholder = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaPlaceholder,"Haga click en la unidad para obtener mas informacion",40);
        etiquetaPlaceholder.setTextFill(Color.WHITE);

        contenedorDescripcionesYBotones.setSpacing(200);
        contenedorDescripcionesYBotones.setAlignment(Pos.CENTER);
        contenedorDescripcionesYBotones.getChildren().addAll (etiquetaPlaceholder,grupoBotones);

        BorderPane menuCompraFichas = new BorderPane();
        menuCompraFichas.setCenter(cajaImagenesFichasCompradas);
        menuCompraFichas.setTop(stackOro);
        menuCompraFichas.setBottom(contenedorDescripcionesYBotones);

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(fondo_compra_piezas,menuCompraFichas);

        // 3er Layout - Creacion tablero blanco //

        Label yaHayPiezaError = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(), "El casillero esta ocupado",30,"#FF0000");

        yaHayPiezaError.setVisible(false);

        SequentialTransition piezaUbicadaMalError = mensajeDeError.generarAvisoParpadeante(yaHayPiezaError);

        Label distribuirPiezasBlancas = new Label();

        ImageView fondo_tablero1 = new ImageView (directorio_resources+"fondo_tablero.png");

        Button botonFinalizarColocadoPiezasBlancas = generadorDeBotones.nuevoBoton("Finalizar");

        HBox colocadoPiezasBlancas = new HBox(distribuirPiezasBlancas,yaHayPiezaError,botonFinalizarColocadoPiezasBlancas);
        colocadoPiezasBlancas.setSpacing(300);
        colocadoPiezasBlancas.setPadding(new Insets(20));
        colocadoPiezasBlancas.setMaxHeight(100);

        ImageViewPiezaEnJuego ultimaPiezaSeleccionada = new ImageViewPiezaEnJuego();
        GeneradorCajaFichasRestantes generadorCajaFichasBlancasRestantes = new GeneradorCajaFichasRestantes(directorio_resources+"fichasBlancas/",ultimaPiezaSeleccionada, generadorDeEtiquetas);
        StackPane cajaFichasBlancasRestantes = null;

        GeneradorDeTablero generadorDeTablero = new GeneradorDeTablero ();
        GridPane tableroBlanco = generadorDeTablero.generarTablero(directorio_resources+"escaqueBlanco40.png",ultimaPiezaSeleccionada,juego,false,yaHayPiezaError,piezaUbicadaMalError);
        Group grupoTableroBlanco = new Group (tableroBlanco);

        BorderPane menuJugadorBlanco = new BorderPane();
        menuJugadorBlanco.setCenter (grupoTableroBlanco);
        menuJugadorBlanco.setBottom(cajaFichasBlancasRestantes);
        menuJugadorBlanco.setTop(colocadoPiezasBlancas);

        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(fondo_tablero1,menuJugadorBlanco);

        // 4to Layout - Creacion tablero negro //

        Label yaHayPiezaNegraError = generadorDeEtiquetas.generarEtiquetaNegrita2(new Label(), "El casillero esta ocupado",30,"#FF0000");
        yaHayPiezaNegraError.setVisible(false);
        SequentialTransition piezaNegraUbicadaMalError = mensajeDeError.generarAvisoParpadeante(yaHayPiezaNegraError);

        Label distribuirPiezasNegras = new Label();

        Button botonFinalizarColocadoPiezasNegras = generadorDeBotones.nuevoBoton("Finalizar");

        ImageView fondo_tablero2 = new ImageView (directorio_resources+"fondo_tablero.png");

        StackPane cajaFichasNegrasRestantes = null;
        HBox colocadoPiezasNegras = new HBox(distribuirPiezasNegras,yaHayPiezaNegraError,botonFinalizarColocadoPiezasNegras);
        colocadoPiezasNegras.setSpacing(300);
        colocadoPiezasNegras.setPadding(new Insets(20));
        colocadoPiezasNegras.setMaxHeight(100);

        GeneradorCajaFichasRestantes generadorCajaFichasNegrasRestantes = new GeneradorCajaFichasRestantes(directorio_resources+"fichasNegras/",ultimaPiezaSeleccionada, generadorDeEtiquetas);

        GridPane tableroNegro = generadorDeTablero.generarTablero(directorio_resources+"escaqueNegro40.png",ultimaPiezaSeleccionada,juego,true,yaHayPiezaNegraError,piezaNegraUbicadaMalError);
        Group grupoTableroNegro = new Group (tableroNegro);

        BorderPane menuJugadorNegro = new BorderPane();
        menuJugadorNegro.setCenter (grupoTableroNegro);
        menuJugadorNegro.setTop (colocadoPiezasNegras);
        menuJugadorNegro.setBottom (cajaFichasNegrasRestantes);

        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(fondo_tablero2,menuJugadorNegro);

        // 5to Layout - Creacion tablero final //

        GeneradorDeCajaAtaqueMovimiento generadorDeCajaAtaqueMovimiento = new GeneradorDeCajaAtaqueMovimiento(directorio_resources);

        HBox cajaAtaque = new HBox();

        HBox cajaMovimiento = new HBox();

        BorderPane campoJuegoFinal = generadorDeCajaAtaqueMovimiento.generarCajaAtaqueMovimiento(juego,cajaMovimiento,cajaAtaque);

        StackPane informacionPieza = new StackPane();
        ImageView fondoDetallesPieza = new ImageView(directorio_resources+"menuDetallesUnidad.png");
        informacionPieza.getChildren().add(fondoDetallesPieza);
        Button terminarTurno = generadorDeBotones.nuevoBoton("TERMINAR TURNO");
        terminarTurno.setMaxSize(200,100);
        terminarTurno.setStyle("-fx-border-color: #000000; -fx-background-color: #ff0000; -fx-border-width: 2px");
        terminarTurno.setOnAction(new HandlerPasarTurno(juego,cajaMovimiento,cajaAtaque,generadorDeEtiquetas));
        VBox vidaPieza = new VBox ();
        vidaPieza.setSpacing(100);
        Label vida = new Label();
        Label ataques = new Label();
        generadorDeEtiquetas.generarEtiquetaNegrita(vida,"- Vida: ",40);
        vida.setTextFill(Color.web("#FFFFFF"));
        generadorDeEtiquetas.generarEtiquetaNegrita(ataques,"- Ataques: ",40);
        ataques.setTextFill(Color.web("#FFFFFF"));
        vidaPieza.getChildren().addAll(vida,ataques);
        informacionPieza.getChildren().add(vidaPieza);
        informacionPieza.getChildren().add(terminarTurno);
        campoJuegoFinal.setRight(informacionPieza);
        informacionPieza.setMargin(vidaPieza,new Insets(70,0,0,100));
        informacionPieza.setMargin(fondoDetallesPieza,new Insets(0,100,125,45));
        informacionPieza.setMargin(terminarTurno,new Insets(630,100,0,0));

        // 5to Layout - Creacion tablero final //
        botonFinalizarColocadoPiezasNegras.setOnAction(new HandlerCrearTableroFinal(scene,tableroBlanco,tableroNegro,campoJuegoFinal,vida,generadorDeEtiquetas, juego,cajaAtaque,cajaMovimiento,directorio_resources));

        // Botones //

        botonEnviar.setOnAction(new HandlerNombreUsuarioNegro(menuNombreJugador,contenedorPrincipal,botonEmpezar,generadorDeEtiquetas, textoJugadorBlanco,textoJugadorNegro));

        botonEmpezar.setOnAction(new HandlerNombreUsuarioBlanco(stackPane1,scene,textoJugadorNegro,textoJugadorBlanco,distribuirPiezasBlancas,distribuirPiezasNegras,directorio_resources,juego,etiquetaOroRestante,generadorDeEtiquetas));

        botonComenzarJuego.setOnAction (new HandlerCrearTableroParcial(stackPane2,scene,juego,menuJugadorBlanco,generadorCajaFichasBlancasRestantes));

        botonFinalizarColocadoPiezasBlancas.setOnAction(new HandlerCrearTableroParcial(stackPane3,scene,juego,menuJugadorNegro,generadorCajaFichasNegrasRestantes));

        stage.setScene(scene);

        stage.show();
    }
}
