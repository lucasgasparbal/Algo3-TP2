package AlgoChessTest.JugadorTest;

import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Jugador.Jugador;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Test;
import org.junit.Assert;

public class JugadorTest {

    @Test
    public void intentoComprarCincoCatapultasTiraExcepcion () {
        Jugador jugador = new Jugador ();
        // Las unidades se crean antes de ver si las puedo costear, arreglar //
        boolean seLanzaExcepcion = false;
        Catapulta catapulta1 = new Catapulta (1,1);
        Catapulta catapulta2 = new Catapulta (2,2);
        Catapulta catapulta3 = new Catapulta (3,3);
        Catapulta catapulta4 = new Catapulta (4,4);
        Catapulta catapulta5 = new Catapulta (5,5);
        try {
            jugador.compra(catapulta1);
            jugador.compra(catapulta2);
            jugador.compra(catapulta3);
            jugador.compra(catapulta4);
            jugador.compra(catapulta5);
        }
        catch (NoAlcanzanPuntosExcepcion e) {
            seLanzaExcepcion = true;
        }
        Assert.assertTrue(seLanzaExcepcion);
    }

    @Test
    public void jugadorQueSeQuedaSinPiezasPierde () {
        Jugador jugador = new Jugador();
        Catapulta catapulta = new Catapulta (1,2);
        Soldado soldado = new Soldado (1,3);
        Jinete jinete = new Jinete (1,5);

        try {
            jugador.compra(catapulta);
            jugador.compra(soldado);
            jugador.compra(jinete);
        }
        catch (NoAlcanzanPuntosExcepcion e) {}

        catapulta.sufrirDanio(100);
        soldado.sufrirDanio(100);
        jinete.sufrirDanio(100);

        Assert.assertTrue (jugador.perdio());
    }

    @Test
    public void jugadorTieneUnaSolaPiezaVivaNoPierde () {
        Jugador jugador = new Jugador();
        Catapulta catapulta = new Catapulta (1,2);
        Soldado soldado = new Soldado (1,3);
        Curandero curandero = new Curandero(1,6);

        try {
            jugador.compra(catapulta);
            jugador.compra(soldado);
            jugador.compra(curandero);
        }
        catch(NoAlcanzanPuntosExcepcion ignored){}

        catapulta.sufrirDanio(100);
        soldado.sufrirDanio(99);
        curandero.sufrirDanio(100);

        Assert.assertFalse (jugador.perdio());
    }
}

