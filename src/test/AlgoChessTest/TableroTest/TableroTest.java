package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
import model.AlgoChess.Tablero.Tablero;
import org.junit.Test;

public class TableroTest {
    @Test
    public void test01ColocarPiezaAliadaEnCasilleroAliadoEsValido(){
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();

        Tablero tablero = new Tablero(equipoBlanco,equipoNegro);
    }
}
