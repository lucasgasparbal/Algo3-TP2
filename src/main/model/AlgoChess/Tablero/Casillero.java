package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Unidades.Unidad;

public class Casillero{

    private final double MultiplicadorDanioPorTerritorioEnemigo = 1.05;

    private boolean estaVacio = true;
    private int x;
    private int y;
    private Tablero tablero;
    private Equipo equipo;
    private AnalizadorRangos analizadorRangos = new AnalizadorRangos();

    public Casillero(int xDado, int yDado, Tablero tableroDado, Equipo unEquipo){
        x = xDado;
        y = yDado;
        tablero = tableroDado;
        equipo = unEquipo;
    }

    public boolean estaLibre(){
        return estaVacio;
    }

    public void ocuparCasillero(Unidad unidad) throws CasilleroOcupadoExcepcion {

        if(!estaVacio){
            throw new CasilleroOcupadoExcepcion();
        }

        estaVacio = false;

        tablero.enCasilleroPonerUnidad(this,unidad);
    }

    public void vaciar(){
        estaVacio = true;
        tablero.vaciarCasillero(this);
    }

    public int[] coordenadas(){
        return (new int[]{x, y});
    }

    private Casillero obtenerCasilleroDeCoordenada(int xDeseada, int yDeseada) throws CoordenadaFueraDeRangoExcepcion {
        int[] coordenadasNuevas = {xDeseada,yDeseada};
        return tablero.conseguirCasillero(coordenadasNuevas);
    }

    public Casillero obtenerCasilleroSuperior() throws CoordenadaFueraDeRangoExcepcion {
        return obtenerCasilleroDeCoordenada(x,y+1);
    }

    public Casillero obtenerCasilleroInferior() throws CoordenadaFueraDeRangoExcepcion {
        return obtenerCasilleroDeCoordenada(x,y-1);
    }

    public Casillero obtenerCasilleroIzquierdo() throws CoordenadaFueraDeRangoExcepcion {
        return obtenerCasilleroDeCoordenada(x-1,y);
    }

    public Casillero obtenerCasilleroDerecho() throws CoordenadaFueraDeRangoExcepcion {
        return obtenerCasilleroDeCoordenada(x+1,y);
    }

    public double aplicarMultiplicadorDanioAUnidadDeEquipo(Equipo unEquipo){

        if(equipo.esIgualA(unEquipo)){
            return 1;
        }

        return MultiplicadorDanioPorTerritorioEnemigo;
    }

    public boolean esAdyacenteA(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return analizadorRangos.coordenadasSonAdyacentes(x,y, otroCasillero.x, otroCasillero.y);
    }

    public boolean estaEnRangoCercanoDe(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return analizadorRangos.coordenadasEstanEnRangoCercano(x,y, otroCasillero.x, otroCasillero.y);
    }

    public boolean estaEnRangoMedianoDe(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return analizadorRangos.coordenadasEstanEnRangoMediano(x,y, otroCasillero.x, otroCasillero.y);
    }

    public boolean estaEnRangoLejanoDe(Casillero otroCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return analizadorRangos.coordenadasEstanEnRangoLejano(x,y, otroCasillero.x, otroCasillero.y);
    }

    public boolean perteneceAEquipo(Equipo unEquipo){
        return equipo.esIgualA(unEquipo);
    }
}
