package model.AlgoChess.Tablero;

import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public class Casillero{

    private int numeroEquipo;

    private final double MultiplicadorDanioPorTerritorioEnemigo = 1.05;

    private boolean estaVacio = true;
    private int x;
    private int y;
    private Tablero tablero;


    public Casillero(int xDado, int yDado, Tablero tableroDado, int identificadorEquipo){
        x = xDado;
        y = yDado;
        numeroEquipo = identificadorEquipo;
        tablero = tableroDado;
    }

    public boolean estaLibre(){
        return estaVacio;
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

    public boolean perteneceAEquipo(int numeroIdentificadorEquipo){
        return numeroIdentificadorEquipo == numeroEquipo;
    }

    public double aplicarMultiplicadorDanioAUnidadDeEquipo(int numeroIdentificadorEquipo){

        if (numeroIdentificadorEquipo == numeroEquipo){
            return 1;
        }

        return MultiplicadorDanioPorTerritorioEnemigo;
    }

    public boolean esAdyacenteA(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return tablero.coordenadasSonAdyacentes(this.coordenadas(),otroCasillero.coordenadas());
    }

    public boolean estaEnRangoCercanoDe(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return tablero.coordenadasEstanEnRangoCercano(this.coordenadas(), otroCasillero.coordenadas());
    }

    public boolean estaEnRangoMedianoDe(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return tablero.coordenadasEstanEnRangoMediano(this.coordenadas(), otroCasillero.coordenadas());
    }

    public boolean estaEnRangoLejanoDe(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return tablero.coordenadasEstanEnRangoMediano(this.coordenadas(), otroCasillero.coordenadas());
    }

}
