package test;

import model.Costo;

import model.NoAlcanzanPuntosExcepcion;
import org.junit.Test;
import org.junit.Assert;

public class CostoTest {

    @Test
    public void costoDescuentaPuntosCorrectamente() {
        int puntos = 100;
        Costo costo = new Costo (10);
        try {
            puntos = costo.descontarCosto(puntos);
        }
        catch (NoAlcanzanPuntosExcepcion e) { }
        Assert.assertEquals(puntos,90);
    }

    @Test
    public void variosCostosDescuentanPuntosCorrectamente() {
        int puntos = 150;
        Costo costo1 = new Costo (20);
        Costo costo2 = new Costo (5);
        Costo costo3 = new Costo (33);
        try {
            puntos = costo1.descontarCosto(puntos);
            puntos = costo2.descontarCosto(puntos);
            puntos = costo3.descontarCosto(puntos);
        }
        catch (NoAlcanzanPuntosExcepcion e) { }
        Assert.assertEquals(puntos,92);
    }

    @Test
    public void noAlcanzanLosPuntosTiraExcepcion() {
        int puntos = 10;
        Costo costo = new Costo (15);
        boolean seLanzoError = false;
        try {
            puntos = costo.descontarCosto(puntos);
        }
        catch (NoAlcanzanPuntosExcepcion e) {
            seLanzoError = true;
        }
        Assert.assertTrue(seLanzoError);
    }
}
