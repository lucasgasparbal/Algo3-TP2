package AlgoChessTest.EquipoTest;

import model.AlgoChess.Equipos.Equipo;
import org.junit.Assert;
import org.junit.Test;

public class EquipoTest {

    @Test
    public void EquipoEsIgualAEquipoDevuelveFalseEnEquiposConDistintosIdentificadores(){

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);

        Assert.assertFalse(equipoUno.esIgualA(equipoDos));
    }
}
