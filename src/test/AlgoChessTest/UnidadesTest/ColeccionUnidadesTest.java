package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Unidades.*;
import org.junit.jupiter.api.*;
import org.junit.Test;

public class ColeccionUnidadesTest {
    @Test
    public void ColeccionUnidadesSeIniciaVacia(){

        ColeccionUnidades coleccion = new ColeccionUnidades();

        Assertions.assertTrue(coleccion.estaVacia());
    }
}
