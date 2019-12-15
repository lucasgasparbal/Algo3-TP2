package model.AlgoChess.Tablero;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Unidades.*;

import java.util.ArrayList;

public class Tablero {

    private AdministradorBatallones administradorBatallones = new AdministradorBatallones();
    private MatrizCasilleros matrizCasilleros;

    private DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();

    public Tablero(Equipo equipoUno, Equipo equipoDos){
        matrizCasilleros = new MatrizCasilleros(equipoUno,equipoDos, this);
    }

    public void actualizarBatallones() {
        administradorBatallones.actualizarBatallones();
    }

    public void inicializarUnidadEnCasillero(Unidad unidad, int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        Casillero casillero = matrizCasilleros.conseguirCasillero(coordenadas);
        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casillero,unidad);
        try{
            unidad.inicializarEnCasillero(casillero);
        }catch(CasilleroEnemigoExcepcion casilleroEnemigoExcepcion){
            diccionarioCasilleroUnidad.removerUnidadDeCasillero(casillero);
            throw casilleroEnemigoExcepcion;
        }
        unidad.setTablero(this);
    }

    public void inicializarSoldadoEnCasillero(Soldado soldado, int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        inicializarUnidadEnCasillero(soldado,coordenadas);
        administradorBatallones.agregarSoldado(soldado);
        administradorBatallones.actualizarBatallones();
    }

    public void moverBatallonParaArriba(int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {
        Casillero casillero = matrizCasilleros.conseguirCasillero(coordenadasSoldado);
        Soldado soldadoBatallon = (Soldado) diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero);
        soldadoBatallon.moverBatallonParaArriba();
    }

    public void moverBatallonParaAbajo(int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {
        Casillero casillero = matrizCasilleros.conseguirCasillero(coordenadasSoldado);
        Soldado soldadoBatallon = (Soldado) diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero);
        soldadoBatallon.moverBatallonParaAbajo();
    }

    public void moverBatallonParaIzquierda(int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {
        Casillero casillero = matrizCasilleros.conseguirCasillero(coordenadasSoldado);
        Soldado soldadoBatallon = (Soldado) diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero);
        soldadoBatallon.moverBatallonParaIzquierda();
    }

    public void moverBatallonParaDerecha(int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonNoSePuedeMoverExcepcion, BatallonYaSeMovioExcepcion {
        Casillero casillero = matrizCasilleros.conseguirCasillero(coordenadasSoldado);
        Soldado soldadoBatallon = (Soldado) diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero);
        soldadoBatallon.moverBatallonParaDerecha();
    }

    public Casillero conseguirCasillero(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion {
        return matrizCasilleros.conseguirCasillero(coordenadas);
    }

    public Unidad conseguirUnidad(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion {

        return diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(matrizCasilleros.conseguirCasillero(coordenadas));
    }

    public int contarCasillerosDeEquipoUno(){
        return matrizCasilleros.contarCasillerosDeEquipoUno();
    }
    public int contarCasillerosDeEquipoDos(){
        return matrizCasilleros.contarCasillerosDeEquipoDos();
    }

    public int contarCasillerosVacios(){
       return matrizCasilleros.contarCasillerosVacios();
    }

    public void enCasilleroPonerUnidad(Casillero casillero, Unidad unidad) throws CasilleroOcupadoExcepcion {
        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casillero,unidad);
    }

    public void prepararTurno(){
        administradorBatallones.actualizarBatallones();
    }

    public ArrayList<PaqueteCoordenadasBatallon> obtenerPaqueteCoordenadasBatallonParaEquipo(Equipo unEquipo){
        return administradorBatallones.obtenerPaqueteCoordenadasBatallonParaEquipo(unEquipo);
    }

    public boolean unidadTieneEnemigosCercanos(Unidad unidad) throws CoordenadaFueraDeRangoExcepcion {
        return diccionarioCasilleroUnidad.unidadTieneEnemigosCercanos(unidad);
    }

    public boolean unidadTieneAliadosCercanos(Unidad unidad) throws CoordenadaFueraDeRangoExcepcion {
        return diccionarioCasilleroUnidad.unidadTieneAliadosCercanos(unidad);
    }

    public Casillero DesplazarUnidadHaciaArribaDesde(Unidad unidad, Casillero casilleroAntiguo) throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        Casillero casilleroNuevo = casilleroAntiguo;
        try {
            casilleroNuevo = matrizCasilleros.obtenerCasilleroSuperiorA(casilleroAntiguo);

            diccionarioCasilleroUnidad.desplazarUnidadDesdeHasta(unidad, casilleroAntiguo,casilleroNuevo);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

        return casilleroNuevo;
    }

    public Casillero DesplazarUnidadHaciaAbajoDesde(Unidad unidad, Casillero casilleroAntiguo) throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        Casillero casilleroNuevo = casilleroAntiguo;
        try {
            casilleroNuevo = matrizCasilleros.obtenerCasilleroInferiorA(casilleroAntiguo);

            diccionarioCasilleroUnidad.desplazarUnidadDesdeHasta(unidad, casilleroAntiguo,casilleroNuevo);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

        return casilleroNuevo;
    }

    public Casillero DesplazarUnidadHaciaIzquierdaDesde(Unidad unidad, Casillero casilleroAntiguo) throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        Casillero casilleroNuevo = casilleroAntiguo;
        try {
            casilleroNuevo = matrizCasilleros.obtenerCasilleroIzquierdoA(casilleroAntiguo);

            diccionarioCasilleroUnidad.desplazarUnidadDesdeHasta(unidad, casilleroAntiguo,casilleroNuevo);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

        return casilleroNuevo;
    }

    public Casillero DesplazarUnidadHaciaDerechaDesde(Unidad unidad, Casillero casilleroAntiguo) throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        Casillero casilleroNuevo = casilleroAntiguo;
        try {
            casilleroNuevo = matrizCasilleros.obtenerCasilleroDerechoA(casilleroAntiguo);

            diccionarioCasilleroUnidad.desplazarUnidadDesdeHasta(unidad, casilleroAntiguo,casilleroNuevo);
        } catch (CoordenadaFueraDeRangoExcepcion coordenadaFueraDeRangoExcepcion) {
            throw new MovimientoInvalidoExcepcion();
        }

        return casilleroNuevo;
    }

    public ColeccionUnidades obtenerUnidadesConexasA(Unidad unidad) throws CoordenadaFueraDeRangoExcepcion {
        return diccionarioCasilleroUnidad.obtenerUnidadesConexasA(unidad);
    }
}
