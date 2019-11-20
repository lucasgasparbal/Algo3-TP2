package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.*;
import org.junit.jupiter.api.*;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ColeccionUnidadesTest {

    Casillero casillero = mock(Casillero.class);
    Soldado soldado = mock(Soldado.class);

    @Test
    public void ColeccionUnidadesSeIniciaVacia(){

        ColeccionUnidades coleccion = new ColeccionUnidades();

        Assertions.assertTrue(coleccion.estaVacia());
    }

    @Test
    public void ColeccionUnidadesConUnidadAgregadaNoEstaVacia(){

        ColeccionUnidades coleccion = new ColeccionUnidades();

        coleccion.agregarUnidad(soldado);
        Assertions.assertFalse(coleccion.estaVacia());
    }

    @Test
    public void ColeccionUnidadesHayUnidadesAdyacentesDevuelveFalseEnUnaColeccionSinUnidades() throws CoordenadaFueraDeRangoExcepcion {
        ColeccionUnidades coleccion = new ColeccionUnidades();

        Assertions.assertFalse(coleccion.hayUnidadesAdyacentesA(casillero));
    }
}
