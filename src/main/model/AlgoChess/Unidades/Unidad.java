package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public abstract class Unidad {
    Casillero ubicacion;

    Vida vida;

    protected int costo;

    protected boolean puedeAtacar = true;

    protected Equipo equipo;

    public int comprarConPuntos(int puntos) throws NoAlcanzaOroExcepcion {
        if (costo > puntos){
            throw new NoAlcanzaOroExcepcion();
        }

        return puntos - costo;
    }
    public Unidad(Equipo unEquipo){
        equipo = unEquipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Casillero getUbicacion() {
        return ubicacion;
    }

    public void inicializarEnCasillero(Casillero unCasillero) throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        if(!unCasillero.perteneceAEquipo(equipo)){
            throw new CasilleroEnemigoExcepcion();
        }

        unCasillero.ocuparCasillero();
        ubicacion = unCasillero;
    }
    public void recibirCuracion(int curacion) {
        vida.recibiCuracion(curacion);
    }

    public void sufrirDanio (int dmg) {
        vida.tomaDanio(dmg);

        if(vida.acabo()){
            equipo.removerUnidad(this);
        }
    }

    public boolean murio() {
        return (vida.acabo());
    }

    public boolean esAdyacenteA(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.esAdyacenteA(unaUnidad.getUbicacion());
    }

    public boolean estaEnRangoCercanoDe(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoCercanoDe(unaUnidad.getUbicacion());
    }

    public boolean estaEnRangoMedianoDe(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoMedianoDe(unaUnidad.getUbicacion());
    }

    public boolean estaEnRangoLejanoDe(Unidad unaUnidad) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoLejanoDe(unaUnidad.getUbicacion());
    }

    public int[] getPosicion() {
        return ubicacion.coordenadas();
    }

    public int getVida() {
        return vida.getValor();
    }

    public boolean esEnemigoDe(Unidad unidad){
        return !unidad.perteneceAEquipo(equipo);
    }

    private boolean perteneceAEquipo(Equipo unEquipo){
        return equipo.esIgualA(unEquipo);
    }

}
