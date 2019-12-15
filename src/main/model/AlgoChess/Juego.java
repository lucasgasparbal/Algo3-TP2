package model.AlgoChess;

import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.PaqueteCoordenadasBatallon;
import model.AlgoChess.Unidades.Unidad;

import java.util.ArrayList;

public class Juego {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Jugador jugadorActual;
    Tablero tablero;
    OrganizadorOrdenJugadores organizadorOrdenJugadores;
    boolean modoMovimiento = false;


    public Juego(){
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();

        organizadorOrdenJugadores = new OrganizadorOrdenJugadores();

        organizadorOrdenJugadores.agregarJugador(jugadorUno);
        organizadorOrdenJugadores.agregarJugador(jugadorDos);

        jugadorActual = organizadorOrdenJugadores.proximoJugador();
        tablero = new Tablero(jugadorUno.getEquipo(),jugadorDos.getEquipo());
    }

    public void cambiarModo () {
        modoMovimiento = !modoMovimiento;
    }

    public boolean estaEnModoMovimiento () {
        return modoMovimiento;
    }


    public void decidirOrdenTurnos(){
        organizadorOrdenJugadores.sortearOrden();
    }

    public void nombrarUsuarioBlanco(String nombre){
        jugadorUno.setNombre(nombre);
    }

    public void nombrarUsuarioNegro(String nombre){
        jugadorDos.setNombre(nombre);
    }

    public void comprarSoldado() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarSoldado();
    }
    public void comprarJinete() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarJinete();
    }
    public void comprarCurandero() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarCurandero();
    }
    public void comprarCatapulta() throws NoAlcanzaOroExcepcion {
        jugadorActual.comprarCatapulta();
    }

    public int oroRestante(){
        return jugadorActual.oroRestante();
    }

    public String obtenerNombreJugadorEnTurno(){
        return jugadorActual.getNombre();
    }

    public void nuevoTurno(){
        jugadorActual.terminarTurno();
        jugadorActual = organizadorOrdenJugadores.proximoJugador();
        jugadorActual.prepararTurno();
        jugadorActual.resetearUnidades();
    }

    public int cantidadSoldadosEnBanquilla(){
        return jugadorActual.cantidadSoldadosEnBanquilla();
    }

    public int cantidadJinetesEnBanquilla(){
        return jugadorActual.cantidadJinetesEnBanquilla();
    }

    public int cantidadCuranderosEnBanquilla(){
        return jugadorActual.cantidadCuranderosEnBanquilla();
    }

    public int cantidadCatapultasEnBanquilla(){
        return jugadorActual.cantidadCatapultasEnBanquilla();
    }

    public void inicializarSoldadoEnCoordenadas(int[] coordenadas) throws NoHaySoldadosEnBanquillaExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion {
        tablero.inicializarSoldadoEnCasillero(jugadorActual.tomarSoldadoDeBanquilla(),coordenadas);
        jugadorActual.removerSoldadoDeBanquilla();
    }

    public void inicializarJineteEnCoordenadas(int[] coordenadas) throws NoHayJinetesEnBanquillaExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion {
        tablero.inicializarUnidadEnCasillero(jugadorActual.tomarJineteDeBanquilla(),coordenadas);
        jugadorActual.removerJineteDeBanquilla();
    }

    public void inicializarCuranderoEnCoordenadas(int[] coordenadas) throws NoHayCuranderosEnBanquillaExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion {
        tablero.inicializarUnidadEnCasillero(jugadorActual.tomarCuranderoDeBanquilla(), coordenadas);
        jugadorActual.removerCuranderoDeBanquilla();
    }

    public void inicializarCatapultaEnCoordenadas(int[] coordenadas) throws NoHayCatapultasEnBanquillaExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion {
        tablero.inicializarUnidadEnCasillero(jugadorActual.tomarCatapultaDeBanquilla(), coordenadas);
        jugadorActual.removerCatapultaDeBanquilla();
    }

    public int obtenerVida(int[] coordenadas) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion {
        return tablero.conseguirUnidad(coordenadas).getVida();
    }

    public boolean atacarPieza(int[] coordenadasAtacante, int[] coordenadasObjetivo) throws NoHayUnidadEnCasilleroExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, ObjetivoEsEnemigoExcepcion, NoSePudoCurarExcepcion, UnidadActivaNoEsDeJugadorEnTurnoExcepcion, YaAtacoExcepcion {
        Unidad unidadAtacante = tablero.conseguirUnidad(coordenadasAtacante);
        Unidad unidadObjetivo = tablero.conseguirUnidad(coordenadasObjetivo);
        if (!jugadorActual.esDuenioDe(unidadAtacante)){
            throw new UnidadActivaNoEsDeJugadorEnTurnoExcepcion();
        }
        unidadAtacante.atacar(unidadObjetivo);

        return unidadObjetivo.murio();
    }
    
    public void moverBatallonParaArriba (int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        tablero.moverBatallonParaArriba(coordenadasSoldado);
    }

    public void moverBatallonParaAbajo (int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        tablero.moverBatallonParaAbajo(coordenadasSoldado);
    }

    public void moverBatallonParaIzquierda (int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        tablero.moverBatallonParaIzquierda(coordenadasSoldado);
    }

    public void moverBatallonParaDerecha (int[] coordenadasSoldado) throws CoordenadaFueraDeRangoExcepcion, NoHayUnidadEnCasilleroExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        tablero.moverBatallonParaDerecha(coordenadasSoldado);
    }

    public void moverPiezaEnCoordenadaHaciaArriba(int[] coordenadas) throws NoHayUnidadEnCasilleroExcepcion, CoordenadaFueraDeRangoExcepcion, UnidadActivaNoEsDeJugadorEnTurnoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion {

        Unidad unidad = tablero.conseguirUnidad(coordenadas);
        if (!jugadorActual.esDuenioDe(unidad)){
            throw new UnidadActivaNoEsDeJugadorEnTurnoExcepcion();
        }
        unidad.desplazarHaciaArriba();
        tablero.actualizarBatallones();
    }

    public void moverPiezaEnCoordenadaHaciaAbajo(int[] coordenadas) throws NoHayUnidadEnCasilleroExcepcion, CoordenadaFueraDeRangoExcepcion, UnidadActivaNoEsDeJugadorEnTurnoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion {

        Unidad unidad = tablero.conseguirUnidad(coordenadas);
        if (!jugadorActual.esDuenioDe(unidad)){
            throw new UnidadActivaNoEsDeJugadorEnTurnoExcepcion();
        }
        unidad.desplazarHaciaAbajo();
        tablero.actualizarBatallones();
    }

    public void moverPiezaEnCoordenadaHaciaIzquierda(int[] coordenadas) throws NoHayUnidadEnCasilleroExcepcion, CoordenadaFueraDeRangoExcepcion, UnidadActivaNoEsDeJugadorEnTurnoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion {

        Unidad unidad = tablero.conseguirUnidad(coordenadas);
        if (!jugadorActual.esDuenioDe(unidad)){
            throw new UnidadActivaNoEsDeJugadorEnTurnoExcepcion();
        }
        unidad.desplazarHaciaIzquierda();
        tablero.actualizarBatallones();
    }

    public void moverPiezaEnCoordenadaHaciaDerecha(int[] coordenadas) throws NoHayUnidadEnCasilleroExcepcion, CoordenadaFueraDeRangoExcepcion, UnidadActivaNoEsDeJugadorEnTurnoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, CatapultaNoSePuedeMoverExcepcion, YaMovioExcepcion {

        Unidad unidad = tablero.conseguirUnidad(coordenadas);
        if (!jugadorActual.esDuenioDe(unidad)){
            throw new UnidadActivaNoEsDeJugadorEnTurnoExcepcion();
        }
        unidad.desplazarHaciaDerecha();
        tablero.actualizarBatallones();
    }

    public ArrayList<PaqueteCoordenadasBatallon> obtenerPaqueteCoordenadasBatallones(){
        ArrayList<PaqueteCoordenadasBatallon> batallonesJugadorUno = tablero.obtenerPaqueteCoordenadasBatallonParaEquipo(jugadorActual.getEquipo());
        nuevoTurno();
        ArrayList<PaqueteCoordenadasBatallon> batallonesJugadorDos = tablero.obtenerPaqueteCoordenadasBatallonParaEquipo(jugadorActual.getEquipo());
        batallonesJugadorDos.addAll(batallonesJugadorUno);
        nuevoTurno();
        return (batallonesJugadorDos);
    }

    public int[] conseguirCantidadPiezasEnBanquilla() {
        int[] piezasEnBanquilla = new int[4];
        piezasEnBanquilla[0] = cantidadSoldadosEnBanquilla();
        piezasEnBanquilla[1] = cantidadJinetesEnBanquilla();
        piezasEnBanquilla[2] = cantidadCuranderosEnBanquilla();
        piezasEnBanquilla[3] = cantidadCatapultasEnBanquilla();
        return piezasEnBanquilla;
    }
}
