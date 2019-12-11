package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;

public class Casillero{

    private final double MultiplicadorDanioPorTerritorioEnemigo = 1.05;

    private boolean estaVacio = true;
    private int x;
    private int y;
    private Equipo equipo;
    private AnalizadorRangos analizadorRangos = new AnalizadorRangos();

    public Casillero(int xDado, int yDado, Equipo unEquipo){
        x = xDado;
        y = yDado;
        equipo = unEquipo;
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
