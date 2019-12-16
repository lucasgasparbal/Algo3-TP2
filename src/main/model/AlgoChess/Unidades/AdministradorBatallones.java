package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class AdministradorBatallones {

    private ArrayList<Batallon> batallones =new ArrayList<>();

    private ArrayList<Soldado> soldados =new ArrayList<Soldado>();

    public int cantidadBatallones() {
        return (batallones.size());
    }

    public void agregarSoldado (Soldado soldado) {
        soldados.add(soldado);
    }

    private void destruirBatallones () {
        int i = 0;
        while (i < batallones.size()) {
            if (!batallones.get(i).esValido()) {
                batallones.remove(i);
            }
            i++;
        }
    }

    private boolean crearBatallon(int posicionInicial, Batallon nuevoBatallon, int posicionAEvaluar) {
        return ((posicionAEvaluar == posicionInicial+1) || (posicionAEvaluar == posicionInicial+2));
    }

    private void crearBatallones () {
        Iterator iterador1 = soldados.iterator();
        Soldado soldado1, soldado2;
        while (iterador1.hasNext()) {
            soldado1 = (Soldado) iterador1.next();
            if (soldado1.tieneBatallon()) {
                continue;
            }
            Iterator iterador2 = soldados.iterator();
            Batallon nuevoBatallonHorizontal = new Batallon();
            Batallon nuevoBatallonVertical = new Batallon();
            nuevoBatallonHorizontal.agregarSoldado(soldado1);
            nuevoBatallonVertical.agregarSoldado(soldado1);
            int[] posicionInicial = soldado1.getPosicion();
            while (iterador2.hasNext()) {
                soldado2 = (Soldado) iterador2.next();
                if (soldado2.tieneBatallon() || soldado2.esEnemigoDe(soldado1)) {
                    continue;
                }
                int[] posicionSoldado = Arrays.copyOf(soldado2.getPosicion(), 2);
                if (posicionInicial[0] == posicionSoldado[0]) {
                    if (crearBatallon(posicionInicial[1],nuevoBatallonHorizontal,posicionSoldado[1]))  {
                        nuevoBatallonHorizontal.agregarSoldado(soldado2);
                    }
                }
                if (posicionInicial[1] == posicionSoldado[1]) {
                    if (crearBatallon(posicionInicial[0],nuevoBatallonVertical,posicionSoldado[0]))  {
                        nuevoBatallonVertical.agregarSoldado(soldado2);
                    }
                }
                if (nuevoBatallonHorizontal.completo()) {
                    batallones.add(nuevoBatallonHorizontal);
                    break;
                }
                if (nuevoBatallonVertical.completo()) {
                    batallones.add(nuevoBatallonVertical);
                    break;
                }
            }
        }
    }

    public void actualizarBatallones () {
        destruirBatallones();
        crearBatallones();
    }

    public ArrayList<PaqueteCoordenadasBatallon> obtenerPaqueteCoordenadasBatallonParaEquipo(Equipo equipo){
        ArrayList<PaqueteCoordenadasBatallon> listaAEntregar = new ArrayList<>();
        for(Batallon batallon:batallones){
            if(batallon.esDeEquipo(equipo)){
                listaAEntregar.add(batallon.obtenerPaqueteCoordenadas());
            }
        }

        return listaAEntregar;
    }


    public void eliminarSoldado(int[] coordenadas) {
        Iterator iterador = soldados.iterator();
        Soldado soldado = null;
        boolean encontrado = false;
        while (iterador.hasNext()) {
            soldado = (Soldado) iterador.next();
            if (Arrays.equals(soldado.getPosicion(), coordenadas)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            soldado.quitarBatallon();
            soldados.remove(soldado);
        }
    }
}

