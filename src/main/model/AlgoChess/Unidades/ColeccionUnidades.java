package model.AlgoChess.Unidades;

import java.util.ArrayList;

public class ColeccionUnidades {
    private ArrayList<Unidad> unidades = new ArrayList<Unidad>();

    public boolean estaVacia(){
        return unidades.isEmpty();
    }
}
