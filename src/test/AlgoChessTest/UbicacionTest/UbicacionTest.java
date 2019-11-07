package AlgoChessTest.UbicacionTest;

import model.AlgoChess.Unidades.AtributosDeUnidades.Ubicacion;
import org.junit.Test;
import org.junit.Assert;

public class UbicacionTest {

    @Test
    public void creoUbicacionValorEnXEYEsCero() {

        Ubicacion ubicacion = new Ubicacion();
        Assert.assertArrayEquals(new int[] {0,0}, ubicacion.getUbicacion());
    }

    @Test
    public void cambioAmbosValoresDeLaUbicacion() {

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.cambiarA(5, 6);
        Assert.assertArrayEquals(new int[] {5,6}, ubicacion.getUbicacion());
    }

}