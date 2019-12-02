package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;


public class CatapultaTest {
/*
    @Test
    public void atacoCincoVecesASoldadoMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion {
        int i = 0;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Soldado soldado = new Soldado (equipoMock);
        while (i<10) {
            try {
                catapulta.atacar(soldado);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertTrue(soldado.murio());

    }

    @Test
    public void atacoTresVecesACuranderoMurioDevuelveFalse() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion {
        int i = 0;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        while (i<3) {
            try {
                catapulta.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {}
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuatroVecesACuranderoMurioDevuelveTrue() throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion {
        int i = 0;
        Equipo equipoMock = mock(Equipo.class);
        Catapulta catapulta = new Catapulta (equipoMock);
        Curandero curandero = new Curandero (equipoMock);
        while (i<4) {
            try {
                catapulta.atacar(curandero);
            }
            catch (NoSePudoAtacarExcepcion e) {};
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }
*/
}
