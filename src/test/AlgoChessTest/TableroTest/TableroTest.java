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
        Tablero tablero = new Tablero();
        Assertions.assertThrows(CoordenadaFueraDeRangoExcepcion.class, ()->tablero.conseguirCasillero(-1,-1));
    }
}
