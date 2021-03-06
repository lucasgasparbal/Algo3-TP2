package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.*;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public abstract class Unidad {
    Casillero ubicacion;
    Tablero tablero;
    Vida vida;

    protected int costo;

    protected boolean ataco = false;

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

    public void setTablero(Tablero tablero){
        this.tablero = tablero;
    }
    public Casillero getUbicacion() {
        return ubicacion;
    }

    public void inicializarEnCasillero(Casillero unCasillero) throws CasilleroEnemigoExcepcion{

        if(!unCasillero.perteneceAEquipo(equipo)){
            throw new CasilleroEnemigoExcepcion();
        }
        ubicacion = unCasillero;
    }
    public void recibirCuracion(int curacion) throws NoSePudoCurarExcepcion {
        vida.recibiCuracion(curacion);
    }

    public void sufrirDanio (int dmg) {
        vida.tomaDanio(dmg*ubicacion.aplicarMultiplicadorDanioAUnidadDeEquipo(equipo));

        if(vida.acabo()){
            ubicacion.vaciar();
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

    public ColeccionUnidades obtenerUnidadesConexas() throws CoordenadaFueraDeRangoExcepcion {
        return tablero.obtenerUnidadesConexasA(this);
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

    public boolean perteneceAEquipo(Equipo unEquipo){
        return equipo.esIgualA(unEquipo);
    }

    public abstract void atacar(Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoEsEnemigoExcepcion, NoSePudoCurarExcepcion, YaAtacoExcepcion;

    public abstract void desplazarHaciaArriba() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion;
    public abstract void desplazarHaciaAbajo() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion;
    public abstract void desplazarHaciaDerecha() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion;
    public abstract void desplazarHaciaIzquierda() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion;

    public abstract void prepararTurno();
}
