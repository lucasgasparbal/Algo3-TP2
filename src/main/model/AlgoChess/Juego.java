package model.AlgoChess;

import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Tablero;

public class Juego {
    Jugador jugadorUno;
    Jugador jugadorDos;
    Jugador jugadorActual;
    Tablero tablero;
    OrganizadorOrdenJugadores organizadorOrdenJugadores;

    public Juego(){
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();

        jugadorUno.setEnemigo(jugadorDos);
        jugadorDos.setEnemigo(jugadorUno);

        organizadorOrdenJugadores = new OrganizadorOrdenJugadores();

        organizadorOrdenJugadores.agregarJugador(jugadorUno);
        organizadorOrdenJugadores.agregarJugador(jugadorDos);

        jugadorActual = organizadorOrdenJugadores.proximoJugador();
        tablero = new Tablero(jugadorUno.getEquipo(),jugadorDos.getEquipo());
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
        tablero.inicializarUnidadEnCasillero(jugadorActual.tomarSoldadoDeBanquilla(),coordenadas);
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

}
