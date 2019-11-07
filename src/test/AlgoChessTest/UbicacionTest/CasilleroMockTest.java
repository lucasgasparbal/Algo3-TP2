package test;

import org.junit.Assert;
import org.junit.Test;

import mocks.CasilleroMock;

public class CasilleroMockTest {

    @Test
    public void casilleroSeCreaVacio () {
        CasilleroMock casilleroMock = new CasilleroMock ();
        Assert.assertTrue(casilleroMock.estaLibre());
    }

    @Test
    public void ocupoCasilleroNoEstaLibre () {
        CasilleroMock casilleroMock = new CasilleroMock ();
        casilleroMock.ocuparCasillero();
        Assert.assertFalse(casilleroMock.estaLibre());
    }

}
