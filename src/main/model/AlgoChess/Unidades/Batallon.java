package model.AlgoChess.Unidades;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;

import java.util.Arrays;

import java.util.ArrayList;

public class Batallon {

    public ArrayList<Soldado> integrantes = new ArrayList<>();

    //refactorizar esto, es un asco//
    public void agregarSoldado(Soldado integrante) {
        integrantes.add(integrante);
        if (integrantes.size() == 3) {
            Soldado temp1 = integrantes.get(1);
            Soldado temp2 = integrantes.get(2);
            int[] posicionAdyacente1 = Arrays.copyOf(integrantes.get(1).getPosicion(), 2);
            int[] posicionAdyacente2 = Arrays.copyOf(integrantes.get(2).getPosicion(), 2);
            if ((posicionAdyacente1[0] > posicionAdyacente2[0]) || (posicionAdyacente1[1] > posicionAdyacente2[1])) {
                integrantes.remove(2);
                integrantes.remove(1);
                integrantes.add(temp2);
                integrantes.add(temp1);
            }
            int i=0;
            while (i<3) {
                integrantes.get(i).asignarBatallon(this);
                i++;
            }
        }
    }

    public void desplazarBatallonHaciaIzquierda() throws MovimientoInvalidoExcepcion {
        int i = 0;
        while (i < integrantes.size()) {
            try {
                integrantes.get(i).desplazarHaciaIzquierda();
            }
            catch (CasilleroOcupadoExcepcion e) {}
            i++;
        }
    }

    public void desplazarBatallonHaciaDerecha() throws MovimientoInvalidoExcepcion {
        int i = 2;
        while (i > -1) {
            try {
                integrantes.get(i).desplazarHaciaDerecha();
            }
            catch (CasilleroOcupadoExcepcion e) { }
            i--;
        }
    }

    public void desplazarBatallonHaciaArriba() throws MovimientoInvalidoExcepcion {
        int i = 2;
        while (i > -1) {
            try {
                integrantes.get(i).desplazarHaciaArriba();
            }
            catch (CasilleroOcupadoExcepcion e) {}
            i--;
        }
    }

    public void desplazarBatallonHaciaAbajo() throws MovimientoInvalidoExcepcion {
        int i = 0;
        while (i < integrantes.size()) {
            try {
                integrantes.get(i).desplazarHaciaAbajo();
            }
            catch (CasilleroOcupadoExcepcion e) {}
            i++;
        }
    }

    public boolean completo() {
        return (integrantes.size() == 3);
    }

    public boolean esValido() {
        int[] posicion1 = Arrays.copyOf(integrantes.get(0).getPosicion(), 2);
        int[] posicion2 = Arrays.copyOf(integrantes.get(1).getPosicion(), 2);
        int[] posicion3 = Arrays.copyOf(integrantes.get(2).getPosicion(), 2);
        if (posicion1[0] > posicion2[0] || posicion1[1] > posicion2[1]) {
            return false;
        }
        if (posicion2[0] > posicion3[0] || posicion2[1] > posicion3[1]) {
        return false;
        }
        return true;
    }
}
