package vista;

import controller.HandlerSeleccionarPieza;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import model.AlgoChess.Juego;
import model.AlgoChess.Unidades.PaqueteCoordenadasBatallon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class OrganizadorDeBatallones {

    GridPane tableroBlanco,tableroNegro;
    String directorio_resources;
    Juego juego;
    ArrayList<int[]> posicionesBatallon;

    public OrganizadorDeBatallones (Juego nuevoJuego, GridPane tablero1, GridPane tablero2, String directorio) {
        this.juego = nuevoJuego;
        this.tableroBlanco = tablero1;
        this.tableroNegro = tablero2;
        this.directorio_resources = directorio;
        this.posicionesBatallon = new ArrayList<int[]>();
    }

    public GridPane tableroAUsar (int y) {
        if (y>9) return tableroNegro;
        return tableroBlanco;
    }

    public void eliminarBatallones() {
        Iterator iterador = posicionesBatallon.iterator();
        while (iterador.hasNext()) {
            int[] coordenadas = (int[]) iterador.next();
            int x = coordenadas[0];
            int y = coordenadas[1];
            StackPane casilleroSeleccionado;
            if (y>9) {
                casilleroSeleccionado = (StackPane) (tableroNegro.getChildren().get(x * 10 +(y-10)));
            }
            else {casilleroSeleccionado = (StackPane) (tableroBlanco.getChildren().get(x * 10 +y));}
            casilleroSeleccionado.getChildren().remove(casilleroSeleccionado.getChildren().size()-1);
        }
        posicionesBatallon.clear();
    }

    public StackPane obtenerCasilleroCorrespondiente (int x, int y) {
        GridPane tablero = tableroAUsar(y);
        int correcion = 0;
        if (y>9) {correcion=10;}
        return (StackPane) tablero.getChildren().get(x*10+(y-correcion));
    }

    private void crearBatallones (ArrayList<PaqueteCoordenadasBatallon> batallones) {
        Iterator iterador = batallones.iterator();
        while (iterador.hasNext()) {
            PaqueteCoordenadasBatallon batallon = (PaqueteCoordenadasBatallon) iterador.next();
            int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
            int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
            int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
            posicionesBatallon.add(soldado1);
            posicionesBatallon.add(soldado2);
            posicionesBatallon.add(soldado3);
            StackPane casillero1 = obtenerCasilleroCorrespondiente(soldado1[0],soldado1[1]);
            StackPane casillero2 = obtenerCasilleroCorrespondiente(soldado2[0],soldado2[1]);
            StackPane casillero3 = obtenerCasilleroCorrespondiente(soldado3[0],soldado3[1]);
            if (soldado1[0]==soldado2[0]) {
                ImageView BV1 = new ImageView(directorio_resources+"BV1.png");
                ImageView BV2 = new ImageView(directorio_resources+"BV2.png");
                ImageView BV3 = new ImageView(directorio_resources+"BV3.png");
                casillero3.getChildren().add(BV1);
                casillero2.getChildren().add(BV2);
                casillero1.getChildren().add(BV3);
                continue;
            }
            ImageView BH1 = new ImageView(directorio_resources+"BH3.png");
            ImageView BH2 = new ImageView(directorio_resources+"BH2.png");
            ImageView BH3 = new ImageView(directorio_resources+"BH1.png");
            casillero3.getChildren().add(BH1);
            casillero2.getChildren().add(BH2);
            casillero1.getChildren().add(BH3);
        }
    }

    private void moverALaDerecha (int [] coordenadas) {
        StackPane casilleroOriginal=null;
        StackPane casilleroNuevo=null;
        if (coordenadas[1]>9) {
            casilleroOriginal = (StackPane) (tableroNegro.getChildren().get(coordenadas[0]* 10 + coordenadas[1]-10));
            casilleroNuevo = (StackPane) (tableroNegro.getChildren().get((coordenadas[0]+1) * 10 + coordenadas[1]-10));
        }
        else {
            casilleroOriginal = (StackPane) (tableroBlanco.getChildren().get(coordenadas[0]* 10 + coordenadas[1]));
            casilleroNuevo = (StackPane) (tableroBlanco.getChildren().get((coordenadas[0]+1) * 10 + coordenadas[1]));
        }
        if (casilleroNuevo.getChildren().size() == 2) {return;}
        casilleroNuevo.getChildren().add(1,casilleroOriginal.getChildren().get(1));
    }

    private void moverAbajo (int [] coordenadas) {
        StackPane casilleroOriginal;
        StackPane casilleroNuevo;
        if (coordenadas[1]>9) {
            casilleroOriginal = (StackPane) (tableroNegro.getChildren().get(coordenadas[0]* 10 + coordenadas[1]-10));
            if (coordenadas[1]==10) {
                casilleroNuevo = (StackPane) (tableroBlanco.getChildren().get((coordenadas[0]) * 10 + coordenadas[1]-1));
            }
            else {casilleroNuevo = (StackPane) (tableroNegro.getChildren().get((coordenadas[0]) * 10 + coordenadas[1]-11));}
        }
        else {
            casilleroOriginal = (StackPane) (tableroBlanco.getChildren().get(coordenadas[0]* 10 + coordenadas[1]));
            casilleroNuevo = (StackPane) (tableroBlanco.getChildren().get((coordenadas[0]) * 10 + coordenadas[1]-1));
        }
        if (casilleroNuevo.getChildren().size() == 2) {return;}
        casilleroNuevo.getChildren().add(1,casilleroOriginal.getChildren().get(1));

    }

    private void moverALaIzquierda (int [] coordenadas) {
        StackPane casilleroOriginal;
        StackPane casilleroNuevo;
        if (coordenadas[1] > 9) {
            casilleroOriginal = (StackPane) (tableroNegro.getChildren().get(coordenadas[0] * 10 + coordenadas[1] - 10));
            casilleroNuevo = (StackPane) (tableroNegro.getChildren().get((coordenadas[0] - 1) * 10 + coordenadas[1] - 10));
        } else {
            casilleroOriginal = (StackPane) (tableroBlanco.getChildren().get(coordenadas[0] * 10 + coordenadas[1]));
            casilleroNuevo = (StackPane) (tableroBlanco.getChildren().get((coordenadas[0] - 1) * 10 + coordenadas[1]));
        }
        if (casilleroNuevo.getChildren().size() ==2) {return;}
        casilleroNuevo.getChildren().add(1,casilleroOriginal.getChildren().get(1));

    }

    private void moverArriba (int [] coordenadas) {
        StackPane casilleroOriginal;
        StackPane casilleroNuevo;
        if (coordenadas[1]>9) {
            casilleroOriginal = (StackPane) (tableroNegro.getChildren().get(coordenadas[0]* 10 + coordenadas[1]-10));
            casilleroNuevo = (StackPane) (tableroNegro.getChildren().get((coordenadas[0]) * 10 + (coordenadas[1]-9)));
        }
        else {
            casilleroOriginal = (StackPane) (tableroBlanco.getChildren().get(coordenadas[0]* 10 + coordenadas[1]));
            if (coordenadas[1]==9) {
                casilleroNuevo = (StackPane) (tableroNegro.getChildren().get((coordenadas[0]) * 10 + (coordenadas[1]-9)));
            }
            else {casilleroNuevo = (StackPane) (tableroBlanco.getChildren().get((coordenadas[0]) * 10 + (coordenadas[1]+1)));}
        }
        if (casilleroNuevo.getChildren().size() == 2) {return;}
        casilleroNuevo.getChildren().add(1,casilleroOriginal.getChildren().get(1));
    }

    public PaqueteCoordenadasBatallon encontrarBatallonCorrespondiente (int[] coordenadas) {
        ArrayList<PaqueteCoordenadasBatallon> batallones = juego.obtenerPaqueteCoordenadasBatallones();
        Iterator iterador = batallones.iterator();
        PaqueteCoordenadasBatallon batallonADevolver = null;
        while (iterador.hasNext()) {
            PaqueteCoordenadasBatallon batallon = (PaqueteCoordenadasBatallon) iterador.next();
            int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
            int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
            int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
            if (Arrays.equals(soldado1, coordenadas) || Arrays.equals(soldado2, coordenadas) || Arrays.equals(soldado3, coordenadas)) {
                batallonADevolver = batallon;
            }
        }
        return batallonADevolver;
    }

    public void actualizarBatallones() {
        ArrayList<PaqueteCoordenadasBatallon> batallones = juego.obtenerPaqueteCoordenadasBatallones();
        crearBatallones(batallones);
    }

    public void moverBatallonParaDerecha(PaqueteCoordenadasBatallon batallon) {
        eliminarBatallones();
        int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
        int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
        int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
        moverALaDerecha(soldado3);
        moverALaDerecha(soldado2);
        moverALaDerecha(soldado1);
    }

    public void moverBatallonParaIzquierda(PaqueteCoordenadasBatallon batallon) {
        eliminarBatallones();
        int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
        int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
        int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
        moverALaIzquierda(soldado1);
        moverALaIzquierda(soldado2);
        moverALaIzquierda(soldado3);
    }

    public void moverBatallonParaArriba(PaqueteCoordenadasBatallon batallon) {
        eliminarBatallones();
        int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
        int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
        int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
        moverArriba(soldado3);
        moverArriba(soldado2);
        moverArriba(soldado1);
    }

    public void moverBatallonParaAbajo(PaqueteCoordenadasBatallon batallon) {
        eliminarBatallones();
        int[] soldado1 = batallon.obtenerCoordenadasPrimerSoldado();
        int[] soldado2 = batallon.obtenerCoordenadasSegundoSoldado();
        int[] soldado3 = batallon.obtenerCoordenadasTercerSoldado();
        moverAbajo(soldado1);
        moverAbajo(soldado2);
        moverAbajo(soldado3);
    }
}
