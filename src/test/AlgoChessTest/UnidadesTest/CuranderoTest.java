package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CuranderoTest {

    //Tambien deberia ser imposible revivir a piezas, una vez que mueren son eliminadas//
    @Test
    public void CuranderoCuraASoldadoHeridoSanaQuincePuntosDeVida() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {

        Equipo equipoUnoMock = mock(Equipo.class);
        Equipo equipoDosMock = mock(Equipo.class);
        Casillero casilleroMockUno = mock(Casillero.class);
        Casillero casilleroMockDos = mock(Casillero.class);
        when(casilleroMockUno.perteneceAEquipo(equipoUnoMock.getNumeroEquipo())).thenReturn(true);
        when(casilleroMockDos.perteneceAEquipo(equipoDosMock.getNumeroEquipo())).thenReturn(true);
        when(casilleroMockDos.estaEnRangoCercanoDe(casilleroMockUno)).thenReturn(true);

        int i=0;
        Soldado soldado1 = new Soldado (equipoUnoMock );
        Soldado soldado2 = new Soldado (equipoDosMock );

        soldado1.inicializarEnCasillero(casilleroMockUno);
        soldado2.inicializarEnCasillero(casilleroMockDos);
        while (i<5){
        try {
            soldado1.atacar(soldado2);
        }
        catch (NoSePudoAtacarExcepcion e) {}
        i++;
        }

        int vida_actual = soldado2.getVida();
        Curandero curandero = new Curandero (equipoDosMock );
        curandero.atacar(soldado2);

        Assert.assertEquals(vida_actual+15,soldado2.getVida());
    }

    @Test
    public void CuranderoCuraASoldadoConVidaCompletaNoSanaMasDelMaximo() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {

        Equipo equipoDosMock = mock(Equipo.class);

        int i=0;
        Soldado soldado2 = new Soldado (equipoDosMock );

        int vida_actual = soldado2.getVida();
        Curandero curandero = new Curandero (equipoDosMock );
        curandero.atacar(soldado2);

        Assert.assertEquals(vida_actual,soldado2.getVida());
    }
}
