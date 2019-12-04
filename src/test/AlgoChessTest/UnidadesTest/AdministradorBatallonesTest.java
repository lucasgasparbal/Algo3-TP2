package AlgoChessTest.UnidadesTest;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Tablero.Tablero;
import org.junit.Test;
import org.junit.Assert;
import model.AlgoChess.Unidades.Soldado;
import model.AlgoChess.Unidades.AdministradorBatallones;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;

public class AdministradorBatallonesTest {

    @Test
    public void test01creoAdministradorBatallonesEstaVacio () {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test02colocoDosSoldadosActualizoBatallonesAdministradorDeBatallonesSigueVacio () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        int[] coordenadasA = {2,2};
        int[] coordenadasB = {2,3};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
        }

    @Test
    public void test03colocoTresSoldadosPeroNoEnLineaActualizoBatallonesAdministradorDeBatallonesSigueVacio () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);
        int[] coordenadasA = {2,2};
        int[] coordenadasB = {2,3};
        int[] coordenadasC = {4,5};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test04colocoTresSoldadosEnFilaHorizontalAdministradorDeBatallonesContieneBatallon () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {2,2};
        int[] coordenadasB = {3,2};
        int[] coordenadasC = {4,2};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test05colocoTresSoldadosEnFilaVerticalAdministradorDeBatallonesContieneBatallon () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);
        int[] coordenadasA = {2,4};
        int[] coordenadasB = {2,5};
        int[] coordenadasC = {2,6};
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test06colocoTresSoldadosEnFilaVerticalAdministradorDeBatallonesContieneBatallon () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {9,3};
        int[] coordenadasB = {9,4};
        int[] coordenadasC = {9,5};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();
    }

    @Test
    public void test07BatallonVerticalDejaDeExistirAlRomperseLaFormacion () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Soldado soldado1 = new Soldado(equipoUno);
        Soldado soldado2 = new Soldado(equipoUno);
        Soldado soldado3 = new Soldado(equipoUno);

        int[] coordenadasA = {9,3};
        int[] coordenadasB = {9,4};
        int[] coordenadasC = {9,5};

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasA));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasB));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(coordenadasC));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());

        soldado2.desplazarHaciaDerecha();

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
    }


}
