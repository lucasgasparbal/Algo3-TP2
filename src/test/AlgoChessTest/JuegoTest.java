package AlgoChessTest;

import model.AlgoChess.*;
import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void JuegoSeInicializaEnModoAtaque(){
        Juego juego = new Juego();

        Assert.assertFalse(juego.estaEnModoMovimiento());
    }


    @Test
    public void JuegoCambiarModoDesdeModoMovimientoHaceQueJuegoNoEsteMasEnModoMovimiento(){
        Juego juego = new Juego();
        juego.cambiarModo();
        juego.cambiarModo();
        Assert.assertFalse(juego.estaEnModoMovimiento());
    }

    @Test
    public void JuegoCambiarModoDesdeModoAtaqueHaceQueJuegoEsteEnModoMovimiento(){
        Juego juego = new Juego();
        juego.cambiarModo();
        Assert.assertTrue(juego.estaEnModoMovimiento());
    }
}
