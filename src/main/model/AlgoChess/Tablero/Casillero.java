package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class Casillero{


    private interface EstadoCasillero{
        public abstract boolean vacio();
        public abstract Unidad getUnidadContenida();
    }

    private class EstadoVacio implements EstadoCasillero{

        public boolean vacio(){ return true;}
        public Unidad getUnidadContenida(){
            return null;
        }

    }

    private class EstadoOcupado implements EstadoCasillero{
        public Unidad unidadContenida;

        public EstadoOcupado(Unidad unidadAContener){
            unidadContenida = unidadAContener;
        }
        public boolean vacio(){ return false;}
        public Unidad getUnidadContenida(){
            return unidadContenida;
        }

    }



    private EstadoCasillero estado =new EstadoVacio();
    private int x;
    private int y;
    private Equipo equipo;
    private Tablero tablero;


    public Casillero(int xDado, int yDado, Equipo equipoDado, Tablero tableroDado){
        x = xDado;
        y = yDado;
        equipo = equipoDado;
        tablero = tableroDado;
    }
    public boolean estaLibre(){
        return estado.vacio();
    }

    public boolean esDeEquipo(Equipo unEquipo){
        return equipo.esIgualA(unEquipo);
    }

    public void ocuparCasillero(Unidad unidad) throws CasilleroOcupadoExcepcion {

        if(!estado.vacio()){
            throw new CasilleroOcupadoExcepcion();
        }

        estado = new EstadoOcupado(unidad); 
    }

    public void colocarUnidad(Unidad unidad) throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        if(!unidad.esDelEquipo(equipo)){
            throw new CasilleroEnemigoExcepcion();
        }

        ocuparCasillero(unidad);
    }

    public Unidad getUnidad(){
        return estado.getUnidadContenida();
    }
    public void vaciar(){
        estado = new EstadoVacio();
    }

    public int[] coordenadas(){
        return (new int[]{x, y});
    }

    public Casillero obtenerCasilleroSuperior() throws CoordenadaFueraDeRangoExcepcion {
            return tablero.conseguirCasillero(x, y+1);
    }

    public Casillero obtenerCasilleroInferior() throws CoordenadaFueraDeRangoExcepcion {
        return tablero.conseguirCasillero(x, y-1);
    }

    public Casillero obtenerCasilleroIzquierdo() throws CoordenadaFueraDeRangoExcepcion {
        return tablero.conseguirCasillero(x-1, y);
    }

    public Casillero obtenerCasilleroDerecho() throws CoordenadaFueraDeRangoExcepcion {
        return tablero.conseguirCasillero(x+1, y);
    }

}
