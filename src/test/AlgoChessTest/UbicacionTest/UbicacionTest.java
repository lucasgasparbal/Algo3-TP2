package test;

import org.junit.Test;
import org.junit.Assert;

import model.Ubicacion;

public class UbicacionTest {

    @Test
    public void creoUbicacionValorEnXEsCero() {

        Ubicacion ubicacion = new Ubicacion();
        Assert.assertEquals(0, ubicacion.getX());

    }

    @Test
    public void creoUbicacionValorEnYEsCero() {

        Ubicacion ubicacion = new Ubicacion();
        Assert.assertEquals(0, ubicacion.getY());

    }

    @Test
    public void cambioValorXDeLaUbicacion() {

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setX(2);
        Assert.assertEquals(2, ubicacion.getX());

    }

    @Test
    public void cambioValorYDeLaUbicacion() {

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setY(3);
        Assert.assertEquals(3, ubicacion.getY());

    }

    @Test
    public void cambioAmbosValoresDeLaUbicacion() {

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.cambiarA(5, 6);
        Assert.assertEquals(5, ubicacion.getX());
        Assert.assertEquals(6, ubicacion.getY());

    }

}