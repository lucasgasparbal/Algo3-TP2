package model.AlgoChess.Unidades;

import java.util.LinkedList;

public class BanquillaUnidades {
    private LinkedList<Soldado> soldados = new LinkedList<>();
    private LinkedList<Jinete> jinetes = new LinkedList<>();
    private LinkedList<Curandero> curanderos = new LinkedList<>();
    private LinkedList<Catapulta> catapultas = new LinkedList<>();

    public boolean tieneSoldados(){
        return !soldados.isEmpty();
    }

    public boolean tieneJinetes(){
        return !jinetes.isEmpty();
    }

    public boolean tieneCuranderos(){
        return !curanderos.isEmpty();
    }

    public boolean tieneCatapultas(){
        return !catapultas.isEmpty();
    }

    public void agregarSoldado(Soldado unSoldado){
        soldados.add(unSoldado);
    }

    public void agregarJinete(Jinete unJinete){
        jinetes.add(unJinete);
    }

    public void agregarCurandero(Curandero unCurandero){
        curanderos.add(unCurandero);
    }

    public void agregarCatapulta(Catapulta unaCatapulta){
        catapultas.add(unaCatapulta);
    }

    public int cantidadSoldados(){
        return soldados.size();
    }

    public int cantidadJinetes(){
        return jinetes.size();
    }

    public int cantidadCuranderos(){
        return curanderos.size();
    }

    public int cantidadCatapultas(){
        return catapultas.size();
    }
}
