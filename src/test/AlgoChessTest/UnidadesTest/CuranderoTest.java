package test;

import org.junit.Test;
import org.junit.Assert;
import model.Soldado;
import model.Curandero;

public class CuranderoTest {

    //Habria que hacer que no pueda curar mas de la vida maxima//

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
    curandero.curar(soldado2);
    Assert.assertFalse (soldado2.murio());
    }
}
