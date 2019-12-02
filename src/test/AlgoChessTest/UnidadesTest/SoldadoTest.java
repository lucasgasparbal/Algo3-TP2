package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);

        int i=0;
        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );
        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado2.inicializarEnCasillero(casilleroMockDos);
       try {
           soldado1.atacar(soldado2);
       }
       catch (NoSePudoAtacarExcepcion e) {}
        Assert.assertFalse (soldado2.murio());
    }

    @Test
    public void soldadoAtacaAOtroDiezVecesMurioDevuelveTrue () throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {
        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock)).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock)).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);

        int i=0;
        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );
        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado2.inicializarEnCasillero(casilleroMockDos);
        while (i<10) {
            try {
                soldado1.atacar(soldado2);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertTrue (soldado2.murio());
    }

    @Test
    public void soldadoSeMueveHaciaArriba () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = new Casillero(1 ,1 , tablero , equipoUno);
        Soldado soldado1 = new Soldado (equipoUno);
        soldado1.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado1.getPosicion();
        soldado1.desplazarHaciaArriba();
        int[] posicionFinal = soldado1.getPosicion();
        posicionInicial[1]= posicionInicial[1]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoSeMueveHaciaAbajo () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = new Casillero(2 ,2 , tablero , equipoUno);
        Soldado soldado1 = new Soldado (equipoUno);
        soldado1.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado1.getPosicion();
        soldado1.desplazarHaciaAbajo();
        int[] posicionFinal = soldado1.getPosicion();
        posicionInicial[1]= posicionInicial[1]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoSeMueveHaciaLaDerecha () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = new Casillero(2 ,2 , tablero , equipoUno);
        Soldado soldado1 = new Soldado (equipoUno);
        soldado1.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado1.getPosicion();
        soldado1.desplazarHaciaDerecha();
        int[] posicionFinal = soldado1.getPosicion();
        posicionInicial[0]= posicionInicial[0]+1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

    @Test
    public void soldadoSeMueveHaciaLaIzquierda () throws MovimientoInvalidoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero casillero = new Casillero(2 ,2 , tablero , equipoUno);
        Soldado soldado1 = new Soldado (equipoUno);
        soldado1.inicializarEnCasillero(casillero);
        int[] posicionInicial = soldado1.getPosicion();
        soldado1.desplazarHaciaIzquierda();
        int[] posicionFinal = soldado1.getPosicion();
        posicionInicial[0]= posicionInicial[0]-1;

        Assert.assertArrayEquals(posicionInicial, posicionFinal);
    }

}






