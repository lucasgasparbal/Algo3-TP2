package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaVerificoPosicion() {

        Soldado soldado = new Soldado(10, 10);
        soldado.desplazarHaciaIzquierda();
        Assert.assertArrayEquals(new int[] {9,10}, soldado.getPosicion());

    }

    @Test
    public void intentoDesplazarPiezaACasilleroOcupado () {
        //Falta implementar casos borde + excepciones//
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaIzquierdaYDerechaVerificoPosicion() {

        Soldado unidadMovible = new Soldado(10,10);
        unidadMovible.desplazarHaciaIzquierda();
        unidadMovible.desplazarHaciaDerecha();
        Assert.assertArrayEquals(new int[] {10,10}, unidadMovible.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaArriba() {

        Soldado soldado = new Soldado (10,10);
        soldado.desplazarHaciaArriba();
        Assert.assertArrayEquals(new int[] {10,11}, soldado.getPosicion());
    }

    @Test
    public void creoPiezaEnCentroLaDesplazoHaciaAbajo() {

        Soldado soldado = new Soldado(10,10);
        soldado.desplazarHaciaAbajo();
        Assert.assertArrayEquals(new int[] {10,9}, soldado.getPosicion());
    }

    @Test
    public void desplazoPiezaEnLasCuatroDirecciones() {

        Soldado soldado = new Soldado(4,5);
        soldado.desplazarHaciaArriba();
        soldado.desplazarHaciaArriba();
        soldado.desplazarHaciaDerecha();
        soldado.desplazarHaciaDerecha();
        soldado.desplazarHaciaDerecha();
        soldado.desplazarHaciaAbajo();
        soldado.desplazarHaciaIzquierda();
        Assert.assertArrayEquals(new int[] {6,6}, soldado.getPosicion());
    }

    @Test
    public void sufreDanioLetalMurioDevuelveTrue () {
        Soldado soldado = new Soldado (5,5);
        soldado.sufrirDanio(101);
        Assert.assertTrue(soldado.murio());
    }

    @Test
    public void sufreDanioNoLetalMurioDevuelveFalse () {
        Soldado soldado = new Soldado (5,4);
        soldado.sufrirDanio(59);
        Assert.assertFalse (soldado.murio());
    }

    @Test
    public void soldadoAtacaAOtroUnaVezMurioDevuelveFalse () {
        Soldado soldado1 = new Soldado (5,5);
        Soldado soldado2 = new Soldado (5,6);
        soldado1.atacar(soldado2);
        Assert.assertFalse (soldado2.murio());
    }

    @Test
    public void soldadoAtacaAOtroDiezVecesMurioDevuelveTrue () {
        int i=0;
        Soldado soldado1 = new Soldado (5,5);
        Soldado soldado2 = new Soldado (5,6);
        while (i<10) {
            soldado1.atacar(soldado2);
            i++;
        }
        Assert.assertTrue (soldado2.murio());
    }
}



