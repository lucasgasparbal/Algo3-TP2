package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.AlgoChess.Juego;
import model.AlgoChess.Unidades.PaqueteCoordenadasBatallon;

import java.util.ArrayList;
import java.util.Iterator;

public class OrganizadorDeBatallones {

    GridPane tableroBlanco,tableroNegro;
    String directorio_resources;
    Juego juego;

    public OrganizadorDeBatallones (Juego nuevoJuego, GridPane tablero1, GridPane tablero2, String directorio) {
        this.juego = nuevoJuego;
        this.tableroBlanco = tablero1;
        this.tableroNegro = tablero2;
        this.directorio_resources = directorio;
    }

    public void actualizarBatallones () {
        ArrayList<PaqueteCoordenadasBatallon> batallones = juego.obtenerPaqueteCoordenadasBatallones();
        Iterator iterador = batallones.iterator();
        while (iterador.hasNext()) {
            System.out.print("holas");
            PaqueteCoordenadasBatallon batallon = (PaqueteCoordenadasBatallon) iterador.next();
            int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
            int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
            int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
            System.out.print(soldado1[0]);
            System.out.print(soldado1[1]);
            System.out.print(soldado2[0]);
            System.out.print(soldado2[1]);
            System.out.print(soldado3[0]);
            System.out.print(soldado3[1]);
            if (soldado1[0]==soldado2[0]) {
                System.out.println("HOLAS");
                ImageView BV1 = new ImageView(directorio_resources+"BV1.png");
                ImageView BV2 = new ImageView(directorio_resources+"BV2.png");
                ImageView BV3 = new ImageView(directorio_resources+"BV3.png");
                StackPane casillero1 = (StackPane)(tableroBlanco.getChildren().get(soldado1[0]*10+soldado1[1]));
                StackPane casillero2 = (StackPane)(tableroBlanco.getChildren().get(soldado2[0]*10+soldado2[1]));
                StackPane casillero3 = (StackPane)(tableroBlanco.getChildren().get(soldado3[0]*10+soldado3[1]));
                casillero3.getChildren().add(BV1);
                casillero2.getChildren().add(BV2);
                casillero1.getChildren().add(BV3);
            }
        }
    }
}
