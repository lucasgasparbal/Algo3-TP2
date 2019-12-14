package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ColeccionUnidadesTest {



    @Test
    public void ColeccionUnidadesSeIniciaVacia(){

        ColeccionUnidades coleccion = new ColeccionUnidades();

        Assertions.assertTrue(coleccion.estaVacia());
    }

    @Test
    public void ColeccionUnidadesConUnidadAgregadaNoEstaVacia(){
        Soldado soldado = mock(Soldado.class);
        ColeccionUnidades coleccion = new ColeccionUnidades();

        coleccion.agregarUnidad(soldado);
        Assertions.assertFalse(coleccion.estaVacia());
    }

    @Test
    public void ColeccionUnidadesHayUnidadesVivasDevuelveFalseConColeccionDeUnidadesVacias(){
        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();

        Assert.assertFalse(coleccionUnidades.hayUnidadesVivas());
    }

    @Test
    public void ColeccionUnidadesHayUnidadesVivasDevuelveTrueConUnaSolaUnidadAgregadaViva(){
        Soldado soldado = mock(Soldado.class);
        when(soldado.murio()).thenReturn(false);
        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();
        coleccionUnidades.agregarUnidad(soldado);
        Assert.assertTrue(coleccionUnidades.hayUnidadesVivas());
    }

    @Test
    public void ColeccionUnidadesHayUnidadesVivasDevuelveTrueConUnaUnidadVivaYUnaUnidadMuerta(){
        Soldado soldado = mock(Soldado.class);
        Jinete jinete = mock(Jinete.class);
        when(soldado.murio()).thenReturn(false);
        when(jinete.murio()).thenReturn(true);
        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();
        coleccionUnidades.agregarUnidad(soldado);
        coleccionUnidades.agregarUnidad(jinete);
        Assert.assertTrue(coleccionUnidades.hayUnidadesVivas());
    }
}
