package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;

public class CuranderoTest {

    //Habria que hacer que no pueda curar mas de la vida maxima//
    //Tambien deberia ser imposible revivir a piezas, una vez que mueren son eliminadas//
    @Test
    public void MatoUnSoldadoYLoCuroMurioDevuelveFalse() throws CoordenadaFueraDeRangoExcepcion, NoSePudoAtacarExcepcion, CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion {

        Equipo equipoMock = mock(Equipo.class);
        int i=0;
        Soldado soldado1 = new Soldado (equipoMock );
        Soldado soldado2 = new Soldado (equipoMock );
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
        Curandero curandero = new Curandero (equipoMock );
        Assert.assertTrue (soldado2.murio());
        curandero.atacar(soldado2);
        Assert.assertFalse (soldado2.murio());
    }
}
