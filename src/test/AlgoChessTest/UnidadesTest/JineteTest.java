package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

    @Test
    public void atacoCuranderoCatorceVecesMurioDevuelveFalse() {
        int i = 0;
        Jinete jinete = new Jinete (3,2);
        Curandero curandero = new Curandero (4,6);
        while (i<14) {
            jinete.atacar(curandero);
            i++;
        }
        Assert.assertFalse(curandero.murio());
    }

    @Test
    public void atacoCuranderoQuinceVecesMurioDevuelveTrue() {
        int i = 0;
        Jinete jinete = new Jinete (3,2);
        Curandero curandero = new Curandero (4,6);
        while (i<15) {
            jinete.atacar(curandero);
            i++;
        }
        Assert.assertTrue(curandero.murio());
    }

    @Test
    public void atacoSoldadoVeinteVecesMurioDevuelveTrue() {
        int i = 0;
        Jinete jinete = new Jinete (3,2);
        Soldado soldado = new Soldado (4,6);
        while (i<20) {
            jinete.atacar(soldado);
            i++;
        }
        Assert.assertTrue(soldado.murio());
    }
}
