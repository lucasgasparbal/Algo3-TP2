package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class JineteTest {

    @Test
    public void atacoCuranderoCatorceVecesMurioDevuelveFalse() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoMock = mock(Equipo.class);

        int i = 0;

        Jinete jinete = new Jinete (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        Tablero tablero = new Tablero ();
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        curandero.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        while (i<14) {
            try {
                jinete.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuranderoQuinceVecesMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        Equipo equipoMock = mock(Equipo.class);
        int i = 0;
        Jinete jinete = new Jinete (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        Tablero tablero = new Tablero ();
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        curandero.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        while (i<15) {
            try {
                jinete.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoSoldadoVeinteVecesMurioDevuelveTrue() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {
        Equipo equipoMock = mock(Equipo.class);
        int i = 0;
        Jinete jinete = new Jinete (equipoMock);
        Soldado soldado = new Soldado (equipoMock);
        Tablero tablero = new Tablero ();
        soldado.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        while (i<20) {
            try {
                jinete.atacar(soldado);
            }
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void JineteAtacaPiezaConEnemigoCercaUsaEspada() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, NoSePudoAtacarExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        equipoNegro.establecerEquipoEnemigo(equipoBlanco);
        equipoBlanco.establecerEquipoEnemigo(equipoNegro);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipoNegro);
        Soldado soldado2 = new Soldado(equipoNegro);
        Jinete jinete = new Jinete (equipoBlanco);
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(10,11));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9,10));
        int i =0;
        while (i<19) {
            try {
                jinete.atacar(soldado1);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(soldado1.murio());
        jinete.atacar(soldado1);
        Assert.assertTrue(soldado1.murio());
    }

    @Test
    public void JineteAtacaPiezaCoAliadoCercaUsaEspada() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, NoSePudoAtacarExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        equipoNegro.establecerEquipoEnemigo(equipoBlanco);
        equipoBlanco.establecerEquipoEnemigo(equipoNegro);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipoNegro);
        Soldado soldado2 = new Soldado(equipoBlanco);
        Jinete jinete = new Jinete(equipoBlanco);
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10, 10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9, 11));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9, 10));
        int i = 0;
        while (i < 19) {
            try {
                jinete.atacar(soldado1);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(soldado1.murio());
        jinete.atacar(soldado1);
        Assert.assertTrue(soldado1.murio());
    }

    @Test
    public void JineteTieneAliadoCercaYEnemigoADistanciaMediaNoPuedeAtacarExcepcion() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, NoSePudoAtacarExcepcion {
        EquipoNegro equipoNegro = new EquipoNegro();
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        equipoNegro.establecerEquipoEnemigo(equipoBlanco);
        equipoBlanco.establecerEquipoEnemigo(equipoNegro);
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado(equipoNegro);
        Soldado soldado2 = new Soldado(equipoBlanco);
        Jinete jinete = new Jinete (equipoBlanco);
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        jinete.inicializarEnCasillero(tablero.conseguirCasillero(9,10));
        boolean seLanzaExcepcion = false;
        try {
            jinete.atacar(soldado1);
        }
        catch (NoSePudoAtacarExcepcion e) {
            seLanzaExcepcion = true;
        }
    }

}


