package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;

public class SoldadoTest {



    @Test
    public void sufreDanioLetalMurioDevuelveTrue () {
        Equipo equipoMock = mock(Equipo.class);
        Soldado soldado = new Soldado (equipoMock);
        soldado.sufrirDanio(101);
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void sufreDanioNoLetalMurioDevuelveFalse () {
        Equipo equipoMock = mock(Equipo.class);
        Soldado soldado = new Soldado (equipoMock);
        soldado.sufrirDanio(59);
        Assert.assertFalse (soldado.murio());
    }

    @Test
    public void soldadoAtacaAOtroUnaVezMurioDevuelveFalse () throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoMock = mock(Equipo.class);
        Soldado soldado1 = new Soldado (equipoMock);
        Soldado soldado2 = new Soldado (equipoMock);
        Tablero tablero = new Tablero ();
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
       try {
           soldado1.atacar(soldado2);
       }
       catch (NoSePudoAtacarExcepcion e) {}
        Assert.assertFalse (soldado2.murio());
    }

    @Test
    public void soldadoAtacaAOtroDiezVecesMurioDevuelveTrue () throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        Equipo equipoMock = mock(Equipo.class);
        int i=0;
        Soldado soldado1 = new Soldado (equipoMock);
        Soldado soldado2 = new Soldado (equipoMock);
        Tablero tablero = new Tablero ();
        soldado1.inicializarEnCasillero(tablero.conseguirCasillero(10,10));
        soldado2.inicializarEnCasillero(tablero.conseguirCasillero(9,11));
        while (i<10) {
            try {
                soldado1.atacar(soldado2);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertTrue (soldado2.murio());
    }
}



