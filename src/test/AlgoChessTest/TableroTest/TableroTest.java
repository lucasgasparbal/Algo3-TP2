package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Tablero;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;

public class TableroTest {
    @Test
    public void test01ConseguirCasilleroLanzaExcepcionEnCoordenadasInvalidas(){
        Equipo equipoMock = mock(Equipo.class);
        Tablero tablero = new Tablero(equipoMock,equipoMock);
        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->tablero.conseguirCasillero(-1,-1));
    }
}
