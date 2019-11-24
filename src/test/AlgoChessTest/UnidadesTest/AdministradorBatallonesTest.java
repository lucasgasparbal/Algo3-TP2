package AlgoChessTest.UnidadesTest;
import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Tablero.Casillero;
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
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(2,2));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(2,3));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
        }

    @Test
    public void test03colocoTresSoldadosPeroNoEnLineaActualizoBatallonesAdministradorDeBatallonesSigueVacio () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(2,2));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(2,3));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(4,5));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test04colocoTresSoldadosEnFilaHorizontalAdministradorDeBatallonesContieneBatallon () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(2, 2));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(3, 2));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(4, 2));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test05colocoTresSoldadosEnFilaVerticalAdministradorDeBatallonesContieneBatallon () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(2, 4));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(2, 5));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(2, 6));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test06colocoTresSoldadosEnFilaVerticalAdministradorDeBatallonesContieneBatallon () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(9, 3));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9, 4));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 5));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();
    }

    @Test
    public void test07BatallonVerticalDejaDeExistirAlRomperseLaFormacion () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(9, 3));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9, 4));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(9, 5));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());

        soldado2.desplazarHaciaDerecha();

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(0,administradorBatallones.cantidadBatallones());
    }

    @Test
    public void test08 () throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion {
        AdministradorBatallones administradorBatallones = new AdministradorBatallones();
        Equipo equipo = new Equipo(1);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipo);
        Soldado soldado2 = new Soldado(equipo);
        Soldado soldado3 = new Soldado(equipo);
        Soldado soldado4 = new Soldado(equipo);

        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(6, 4));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(7, 4));
        soldado3.inicializarEnCasillero(tablero.conseguirCasillero(8, 4));
        soldado4.inicializarEnCasillero(tablero.conseguirCasillero(9, 4));

        administradorBatallones.agregarSoldado(soldado1);
        administradorBatallones.agregarSoldado(soldado2);
        administradorBatallones.agregarSoldado(soldado3);
        administradorBatallones.agregarSoldado(soldado4);

        administradorBatallones.actualizarBatallones();

        Assert.assertEquals(1,administradorBatallones.cantidadBatallones());
    }


}
