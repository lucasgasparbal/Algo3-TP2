package vista;

import controller.HandlerImagenDescripcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.AlgoChess.Juego;

public class GeneradorCajaImagenesConFichasCompradas {

    private HBox piezas;
    private String directorio_resources;
    GeneradorDeEtiquetas generadorDeEtiquetas;
    VBox contenedorFichasBotones;

    public GeneradorCajaImagenesConFichasCompradas(String directorio, HBox piezasCompradas, GeneradorDeEtiquetas generador, VBox contenedor) {
        this.directorio_resources = directorio;
        this.piezas = piezasCompradas;
        this.generadorDeEtiquetas = generador;
        this.contenedorFichasBotones = contenedor;
    }

    public VBox generar(int[] cantidadDeFichas) {
        VBox contenedorADevolver = new VBox();
        HBox contenedorImagenes = new HBox();
        String descripcionJinete = "- Costo: 3\n" +
                "- Vida: 100\n" +
                "- Daño cuerpo a cuerpo: 5\n" +
                "- Daño a distancia: 15\n" +
                "- Si hay al menos un Soldado de Infantería aliado cerca o no hay ningún enemigo cerca, \n" +
                " su arma de ataque es un Arco y Flecha y únicamente puede atacar a enemigos en distancia media.\n" +
                "- Si no hay ningún aliado cercano y hay enemigos cercanos , su arma de ataque es una Espada \n" +
                "y únicamente puede atacar a enemigos en distancia corta.\n" +
                "\n";
        String descripcionSoldado = "- Costo: 1\n" +
                "- Vida: 100\n" +
                "- Daño cuerpo a cuerpo: 10\n" +
                "- Daño a distancia: 0\n" +
                "- Puede atacar a un enemigo a corta distancia.\n" +
                "- Si hay más de 3 Soldados contiguos (en cualquier dirección) se comportan como un Batallón y" +
                "  PUEDEN moverse los 3 al mismo tiempo en el mismo turno.\n" +
                " Esto significa que cada uno de los soldados se va a mover en la dirección solicitada \n" +
                " En caso que uno no pueda moverse al casillero, únicamente ese Soldado se quedará quieto, y los demás si se moverán \n " +
                "\n";
        String descripcionCatapulta = "- Costo: 5\n" +
                "- Vida: 50\n" +
                "- Daño cuerpo a cuerpo: 0\n" +
                "- Daño a distancia: 20\n" +
                "- No puede moverse en toda la partida.\n" +
                "- Ataca en una distancia lejana únicamente. [Puede dañar tanto a Enemigos como Aliados]\n" +
                "- Causa daño a la primera unidad enemiga alcanzada, y a todas las unidades directamente contiguas, \n y si a su vez la segunda unidad tiene otra unidad contigua, \n también causa el mismo daño (y así sucesivamente)\n";
        String descripcionCurandero = "- Costo: 2\n" +
                "- Vida: 75\n" +
                "- Curación: 15\n" +
                "- Puede curar a una unidad Aliada (menos a la Catapulta) en una distancia cercana.\n";

        Text soldadoTexto = new Text();
        soldadoTexto.setText (descripcionSoldado);
        soldadoTexto.setFont (Font.loadFont(directorio_resources+"fonts/Adventurer.ttf",23));
        soldadoTexto.setFill(Color.WHITE);

        Text jineteTexto = new Text();
        jineteTexto.setText (descripcionJinete);
        jineteTexto.setFont (Font.loadFont(directorio_resources+"fonts/Adventurer.ttf",23));
        jineteTexto.setFill(Color.WHITE);

        Text curanderoTexto = new Text();
        curanderoTexto.setText (descripcionCurandero);
        curanderoTexto.setFont (Font.loadFont(directorio_resources+"fonts/Adventurer.ttf",23));
        curanderoTexto.setFill(Color.WHITE);

        Text catapultaTexto = new Text ();
        catapultaTexto.setText (descripcionCatapulta);
        catapultaTexto.setFont (Font.loadFont(directorio_resources+"fonts/Adventurer.ttf",23));
        catapultaTexto.setFill(Color.WHITE);

        ImageView imagenJinete = new ImageView((directorio_resources+"jinete.png"));
        ImageView imagenSoldado = new ImageView((directorio_resources+"soldado.png"));
        ImageView imagenCatapulta = new ImageView((directorio_resources+"catapulta.png"));
        ImageView imagenCurandero = new ImageView((directorio_resources+"curandero.png"));
        imagenSoldado.setOnMouseClicked(new HandlerImagenDescripcion(contenedorFichasBotones,soldadoTexto));
        imagenJinete.setOnMouseClicked(new HandlerImagenDescripcion(contenedorFichasBotones,jineteTexto));
        imagenCurandero.setOnMouseClicked(new HandlerImagenDescripcion(contenedorFichasBotones,curanderoTexto));
        imagenCatapulta.setOnMouseClicked(new HandlerImagenDescripcion(contenedorFichasBotones,catapultaTexto));

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
