package model.AlgoChess.Unidades;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;

import java.util.Arrays;

import java.util.ArrayList;

public class Batallon {

    private ArrayList<Soldado> integrantes = new ArrayList<>();

    public void agregarSoldado(Soldado integrante) {
        integrantes.add(integrante);
        if (integrantes.size() == 3) {
            ordenarBatallon();
        }
    }

    private void ordenarBatallon(){
        Soldado soldadoUno = integrantes.get(1);
        Soldado soldadoDos = integrantes.get(2);
        if (soldadoUno.estaALaDerechaDe(soldadoDos) || soldadoUno.estaArribaDe(soldadoDos)) {
            integrantes.remove(2);
            integrantes.remove(1);
            integrantes.add(soldadoDos);
            integrantes.add(soldadoUno);
        }
        int i=0;
        while (i<3) {
            integrantes.get(i).asignarBatallon(this);
            i++;
        }
    }

    public void desplazarBatallonHaciaIzquierda() throws YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        int i = 0;
        int cantidadMovimientosInvalidos = 0;
        while (i < integrantes.size()) {
            try {
                integrantes.get(i).desplazarConBatallonHaciaIzquierda();
            }
            catch (CasilleroOcupadoExcepcion | MovimientoInvalidoExcepcion e) {
                cantidadMovimientosInvalidos ++;
                if(cantidadMovimientosInvalidos == integrantes.size()){
                    throw new BatallonNoSePuedeMoverExcepcion();
                }
            }
            i++;
        }
    }

    public void desplazarBatallonHaciaDerecha() throws YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        int i = 2;
        int cantidadMovimientosInvalidos = 0;
        while (i > -1) {
            try {
                integrantes.get(i).desplazarConBatallonHaciaDerecha();
            }
            catch (CasilleroOcupadoExcepcion | MovimientoInvalidoExcepcion e) {
                cantidadMovimientosInvalidos ++;
                if(cantidadMovimientosInvalidos == integrantes.size()){
                    throw new BatallonNoSePuedeMoverExcepcion();
                }
            }
            i--;
        }
    }

    public void desplazarBatallonHaciaArriba() throws YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        int i = 2;
        int cantidadMovimientosInvalidos = 0;
        while (i > -1) {
            try {
                integrantes.get(i).desplazarConBatallonHaciaArriba();
            }
            catch (CasilleroOcupadoExcepcion | MovimientoInvalidoExcepcion e) {
                cantidadMovimientosInvalidos ++;
                if(cantidadMovimientosInvalidos == integrantes.size()){
                    throw new BatallonNoSePuedeMoverExcepcion();
                }
            }
            i--;
        }
    }

    public void desplazarBatallonHaciaAbajo() throws YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        int i = 0;
        int cantidadMovimientosInvalidos = 0;
        while (i < integrantes.size()) {
            try {
                integrantes.get(i).desplazarConBatallonHaciaAbajo();
            }
            catch (CasilleroOcupadoExcepcion | MovimientoInvalidoExcepcion e) {
                cantidadMovimientosInvalidos ++;
                if(cantidadMovimientosInvalidos == integrantes.size()){
                    throw new BatallonNoSePuedeMoverExcepcion();
                }
            }
            i++;
        }
    }

    public boolean completo() {
        return (integrantes.size() == 3);
    }
    
    public void desarmarBatallon() {
        int i =0;
        while (i<3) {
            integrantes.get(i).quitarBatallon();
            i++;
        }
    }    

    public boolean esValido() {
		 if (!integrantes.get(0).tieneBatallon() || !integrantes.get(1).tieneBatallon() || !integrantes.get(2).tieneBatallon())  { return false;}
        int[] posicion1 = Arrays.copyOf(integrantes.get(0).getPosicion(), 2);
        int[] posicion2 = Arrays.copyOf(integrantes.get(1).getPosicion(), 2);
        int[] posicion3 = Arrays.copyOf(integrantes.get(2).getPosicion(), 2);
        if (posicion1[0] > posicion2[0] || posicion1[1] > posicion2[1]) {
            desarmarBatallon();
            return false;
        }
        if (posicion2[0] > posicion3[0] || posicion2[1] > posicion3[1]) {
            desarmarBatallon();
            return false;
        }
        if (posicion1[1] < posicion2[1]-1 || posicion3[1] > posicion2[1]+1) {
            desarmarBatallon();
            return false;
        }
        if (posicion1[0] < posicion2[0]-1 || posicion3[0] > posicion2[0]+1) {
            desarmarBatallon();
            return false;
        }
        return true;
    }

    public PaqueteCoordenadasBatallon obtenerPaqueteCoordenadas(){
       PaqueteCoordenadasBatallon paqueteCoordenadasBatallon = new PaqueteCoordenadasBatallon(integrantes.get(0).getPosicion(),integrantes.get(1).getPosicion(),integrantes.get(2).getPosicion());
       return paqueteCoordenadasBatallon;
    }

    public boolean esDeEquipo(Equipo unEquipo){
        return integrantes.get(0).perteneceAEquipo(unEquipo);
    }

    public void prepararTurno(){
        int i = 0;
        while (i < integrantes.size()){
            integrantes.get(i).prepararTurno();
            i++;
        }
    }
}
