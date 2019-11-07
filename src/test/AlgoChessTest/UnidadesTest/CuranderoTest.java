package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

public class CuranderoTest {

    //Habria que hacer que no pueda curar mas de la vida maxima//
    //Tambien deberia ser imposible revivir a piezas, una vez que mueren son eliminadas//
    @Test
    public void MatoUnSoldadoYLoCuroMurioDevuelveFalse() {
    int i=0;
    Soldado soldado1 = new Soldado (5,5);
    Soldado soldado2 = new Soldado (5,6);
    while (i<10) {
        soldado1.atacar(soldado2);
        i++;
        }
    Curandero curandero = new Curandero (3,6);
    Assert.assertTrue (soldado2.murio());
    curandero.atacar(soldado2);
    Assert.assertFalse (soldado2.murio());
    }
}
