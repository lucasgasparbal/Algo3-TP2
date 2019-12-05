package vista;

import controller.HandlerCambiarAtaqueMovimiento;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import model.AlgoChess.Juego;

public class GeneradorDeCajaAtaqueMovimiento {

    String directorio_resources;

    public GeneradorDeCajaAtaqueMovimiento (String resources) {
        this.directorio_resources = resources;
    }

    public BorderPane generarCajaAtaqueMovimiento(Juego juego, HBox cajaMovimiento, HBox cajaAtaque ) {

        BorderPane menuTableroFinal = new BorderPane();

        Label etiquetaAtaque = new Label();
        Label etiquetaMovimiento = new Label();

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas(directorio_resources+"fonts/Adventurer.ttf");
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaAtaque,"MODO ATAQUE",30);
        ImageView imagenModoAtaque = new ImageView (directorio_resources+"combateON.png");

        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaMovimiento,"MODO MOVIMIENTO",30);
        ImageView imagenModoMovimiento = new ImageView (directorio_resources+"movimientoON.png");

        cajaAtaque.getChildren().addAll(imagenModoAtaque,etiquetaAtaque);
        cajaAtaque.setAlignment(Pos.CENTER);
        cajaAtaque.setSpacing(25);
        cajaAtaque.setPadding(new Insets(20));
        cajaMovimiento.getChildren().addAll(imagenModoMovimiento,etiquetaMovimiento);
        cajaMovimiento.setAlignment(Pos.CENTER);
        cajaMovimiento.setSpacing(25);
        cajaMovimiento.setPadding(new Insets(20));

        imagenModoAtaque.setOnMouseClicked(new HandlerCambiarAtaqueMovimiento(cajaMovimiento,menuTableroFinal,juego,generadorDeEtiquetas));
        imagenModoMovimiento.setOnMouseClicked(new HandlerCambiarAtaqueMovimiento(cajaAtaque,menuTableroFinal,juego,generadorDeEtiquetas));

        menuTableroFinal.setTop(cajaAtaque);

        return menuTableroFinal;
    }
}
