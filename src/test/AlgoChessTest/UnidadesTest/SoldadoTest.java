package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.MovimientoInvalidoExcepcion;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.*;
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
    public void soldadoAtacaAOtroUnaVezMurioDevuelveFalse () {
        Equipo equipoMock = mock(Equipo.class);
        Soldado soldado1 = new Soldado (equipoMock);
        Soldado soldado2 = new Soldado (equipoMock);
        soldado1.atacar(soldado2);
        Assert.assertFalse (soldado2.murio());
    }

    @Test
    public void soldadoAtacaAOtroDiezVecesMurioDevuelveTrue () {
        Equipo equipoMock = mock(Equipo.class);
        int i=0;
        Soldado soldado1 = new Soldado (equipoMock);
        Soldado soldado2 = new Soldado (equipoMock);
        while (i<10) {
            soldado1.atacar(soldado2);
            i++;
        }
        Assert.assertTrue (soldado2.murio());
    }
}



