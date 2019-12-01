package vista;

import controller.HandlerCambiarAtaqueMovimiento;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class GeneradorDeCajaAtaqueMovimiento {

    String directorio_resources;
    private OperadorDeDirectorios operadorDeDirectorios = new OperadorDeDirectorios();

    public BorderPane generarCajaAtaqueMovimiento() {

        BorderPane menuTableroFinal = new BorderPane();

        GeneradorDeEtiquetas generadorDeEtiquetas = new GeneradorDeEtiquetas(operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("fonts/Adventurer.ttf"));
        Label etiquetaAtaque = generadorDeEtiquetas.generarEtiquetaNegrita("MODO ATAQUE",30);
        ImageView imagenModoAtaque = new ImageView (operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("combateON.png"));

        Label etiquetaMovimiento = generadorDeEtiquetas.generarEtiquetaNegrita("MODO MOVIMIENTO",30);
        ImageView imagenModoMovimiento = new ImageView (operadorDeDirectorios.obtenerDirectorioRelativoDeRecurso("movimientoON.png"));

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
