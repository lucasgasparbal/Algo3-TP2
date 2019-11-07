package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class Casillero{


    private interface EstadoCasillero{
        public abstract boolean vacio();
    }

    private class EstadoVacio implements EstadoCasillero{

        public boolean vacio(){ return true;}

    }

    private class EstadoOcupado implements EstadoCasillero{
        Unidad unidadContenida;

        public EstadoOcupado(Unidad unidadAContener){
            unidadContenida = unidadAContener;
        }
        public boolean vacio(){ return false;}

    }



    private EstadoCasillero estado =new EstadoVacio();
    private int x;
    private int y;
    Equipo equipo;

    public Casillero(int xDado, int yDado, Equipo equipoDado){
        x = xDado;
        y = yDado;
        equipo = equipoDado;
    }
    public boolean estaLibre(){
        return estado.vacio();
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

}
