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

public class GeneradorDeCajaAtaqueMovimiento {

    String directorio_resources;

    public GeneradorDeCajaAtaqueMovimiento (String resources) {
        this.directorio_resources = resources;
    }

    public BorderPane generarCajaAtaqueMovimiento() {

        BorderPane menuTableroFinal = new BorderPane();

        Label etiquetaAtaque = new Label();
        Label etiquetaMovimiento = new Label();

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas(directorio_resources+"fonts/Adventurer.ttf");
        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaAtaque,"MODO ATAQUE",30);
        ImageView imagenModoAtaque = new ImageView (directorio_resources+"combateON.png");

        generadorDeEtiquetas.generarEtiquetaNegrita(etiquetaMovimiento,"MODO MOVIMIENTO",30);
        ImageView imagenModoMovimiento = new ImageView (directorio_resources+"movimientoON.png");

        HBox cajaAtaque = new HBox (imagenModoAtaque,etiquetaAtaque);
        cajaAtaque.setAlignment(Pos.CENTER);
        cajaAtaque.setSpacing(25);
        cajaAtaque.setPadding(new Insets(20));
        HBox cajaMovimiento = new HBox (imagenModoMovimiento,etiquetaMovimiento);
        cajaMovimiento.setAlignment(Pos.CENTER);
        cajaMovimiento.setSpacing(25);
        cajaMovimiento.setPadding(new Insets(20));

        imagenModoAtaque.setOnMouseClicked(new HandlerCambiarAtaqueMovimiento(cajaMovimiento,menuTableroFinal));
        imagenModoMovimiento.setOnMouseClicked(new HandlerCambiarAtaqueMovimiento(cajaAtaque,menuTableroFinal));

        menuTableroFinal.setTop(cajaAtaque);

        return menuTableroFinal;
    }
}
