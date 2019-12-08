package model.AlgoChess.Unidades;

import model.AlgoChess.Excepciones.NoHayCatapultasEnBanquillaExcepcion;
import model.AlgoChess.Excepciones.NoHayCuranderosEnBanquillaExcepcion;
import model.AlgoChess.Excepciones.NoHayJinetesEnBanquillaExcepcion;
import model.AlgoChess.Excepciones.NoHaySoldadosEnBanquillaExcepcion;

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
        soldados.addLast(unSoldado);
    }

    public void agregarJinete(Jinete unJinete){
        jinetes.addLast(unJinete);
    }

    public void agregarCurandero(Curandero unCurandero){
        curanderos.addLast(unCurandero);
    }

    public void agregarCatapulta(Catapulta unaCatapulta){
        catapultas.addLast(unaCatapulta);
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



    public Soldado tomarSoldado() throws NoHaySoldadosEnBanquillaExcepcion {
        if(!tieneSoldados()){
            throw new NoHaySoldadosEnBanquillaExcepcion();
        }
        return soldados.getLast();
    }

    public Soldado removerSoldado() throws NoHaySoldadosEnBanquillaExcepcion {
        if(!tieneSoldados()){
            throw new NoHaySoldadosEnBanquillaExcepcion();
        }
        return soldados.removeLast();
    }

    public Jinete tomarJinete() throws NoHayJinetesEnBanquillaExcepcion {
        if(!tieneJinetes()){
            throw new NoHayJinetesEnBanquillaExcepcion();
        }
        return jinetes.getLast();
    }

    public Jinete removerJinete() throws NoHayJinetesEnBanquillaExcepcion {
        if(!tieneJinetes()){
            throw new NoHayJinetesEnBanquillaExcepcion();
        }
        return jinetes.removeLast();
    }

    public Curandero tomarCurandero() throws NoHayCuranderosEnBanquillaExcepcion {
        if(!tieneCuranderos()){
            throw new NoHayCuranderosEnBanquillaExcepcion();
        }
        return curanderos.getLast();
    }

    public Curandero removerCurandero() throws NoHayCuranderosEnBanquillaExcepcion {
        if(!tieneCuranderos()){
            throw new NoHayCuranderosEnBanquillaExcepcion();
        }
       return curanderos.removeLast();
    }

    public Catapulta tomarCatapulta() throws NoHayCatapultasEnBanquillaExcepcion {
        if(!tieneCatapultas()){
            throw new NoHayCatapultasEnBanquillaExcepcion();
        }
        return catapultas.getLast();
    }

    public Catapulta removerCatapulta() throws NoHayCatapultasEnBanquillaExcepcion {
        if(!tieneCatapultas()){
            throw new NoHayCatapultasEnBanquillaExcepcion();
        }
        return catapultas.removeLast();
    }
}
