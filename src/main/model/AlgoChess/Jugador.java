package model.AlgoChess;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.NoAlcanzaOroExcepcion;
import model.AlgoChess.Unidades.BanquillaUnidades;
import model.AlgoChess.Unidades.ColeccionUnidades;
import model.AlgoChess.Unidades.*;

public class Jugador {

    final private int MonedasIniciales = 20;

    static private int numeroJugadores = 1;

    private Jugador enemigo;

    private String nombre;

    private BanquillaUnidades banquillaUnidades = new BanquillaUnidades();
    private boolean estaEnTurno;
    public int identificador;
    private int oro = MonedasIniciales;
    private ColeccionUnidades unidades = new ColeccionUnidades();

    private Equipo equipo;

    public Jugador(){
        identificador = numeroJugadores;
        numeroJugadores++;
        equipo = new Equipo(identificador);
    }

    public void setEnemigo(Jugador unJugador){
        enemigo = unJugador;
    }

    public void comprarSoldado() throws NoAlcanzaOroExcepcion {

        Soldado soldado = new Soldado(equipo);
        oro = soldado.comprarConPuntos(oro);
        banquillaUnidades.agregarSoldado(soldado);

    }

    public void comprarJinete() throws NoAlcanzaOroExcepcion {
        Jinete jinete = new Jinete(equipo);
        oro = jinete.comprarConPuntos(oro);
        banquillaUnidades.agregarJinete(jinete);

    }
    public void comprarCurandero() throws NoAlcanzaOroExcepcion {
        Curandero curandero = new Curandero(equipo);
        oro = curandero.comprarConPuntos(oro);
        banquillaUnidades.agregarCurandero(curandero);

    }
    public void comprarCatapulta() throws NoAlcanzaOroExcepcion {
        Catapulta catapulta = new Catapulta(equipo);
        oro = catapulta.comprarConPuntos(oro);
        banquillaUnidades.agregarCatapulta(catapulta);

    }

    public void agregarUnidad(Unidad unidad){
        equipo.agregarUnidad(unidad);
        unidad.setEquipo(equipo);
    }
    public boolean perdio() {
        return equipo.noTieneUnidades();
    }

    public void prepararTurno(){
        estaEnTurno = true;
    }

    public void terminarTurno(){
        estaEnTurno = false;
    }

    public boolean estaEnTurno(){
        return estaEnTurno;
    }

    public void setNombre(String unNombre){
        nombre = unNombre;
    }

    public int oroRestante(){
        return oro;
    }

    public String getNombre(){
        return nombre;
    }
}
