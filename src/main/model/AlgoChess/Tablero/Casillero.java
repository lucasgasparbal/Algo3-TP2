package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class Casillero{

    private final int MitadDelTablero = 10;

    private abstract class EquipoCasillero{
        private final int PorcentajeDañoPorEstarEnTerritorioEnemigo = 5;

        public abstract boolean esBlanco();
        public abstract boolean esNegro();
        public abstract boolean esIgualA(Equipo unEquipo);
    }

    private class EquipoBlanco extends EquipoCasillero{
        @Override
        public boolean esBlanco() {
            return true;
        }

        @Override
        public boolean esNegro() {
            return false;
        }

        @Override
        public boolean esIgualA(Equipo unEquipo) {
            return unEquipo.esBlanco();
        }
    }

    private class EquipoNegro extends EquipoCasillero{
        @Override
        public boolean esBlanco() {
            return false;
        }

        @Override
        public boolean esNegro() {
            return true;
        }

        @Override
        public boolean esIgualA(Equipo unEquipo) {
            return unEquipo.esNegro();
        }
    }


    private boolean estaVacio = true;
    private int x;
    private int y;
    private EquipoCasillero equipo;
    private Tablero tablero;


    public Casillero(int xDado, int yDado, Tablero tableroDado){
        x = xDado;
        y = yDado;
        if (x < MitadDelTablero){
            equipo = new EquipoBlanco();
        }else{
            equipo = new EquipoNegro();
        }

        tablero = tableroDado;
    }

    public boolean estaLibre(){
        return estaVacio;
    }

    public boolean esBlanco(){
        return equipo.esBlanco();
    }

    public boolean esNegro(){
        return equipo.esNegro();
    }
    public void ocuparCasillero() throws CasilleroOcupadoExcepcion {

        if(!estaVacio){
            throw new CasilleroOcupadoExcepcion();
        }

        estaVacio = false;
    }

    public void vaciar(){
        estaVacio = true;
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
