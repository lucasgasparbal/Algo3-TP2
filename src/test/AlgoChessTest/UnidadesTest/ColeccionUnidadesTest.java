package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ColeccionUnidadesTest {



    @Test
    public void ColeccionUnidadesSeIniciaVacia(){

        ColeccionUnidades coleccion = new ColeccionUnidades();

        Assertions.assertTrue(coleccion.estaVacia());
    }

    @Test
    public void ColeccionUnidadesContieneUnidadDevuelveFalsePasandoleUnaUnidadNoAgregada(){
        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();
        Unidad unidadMock = mock(Unidad.class);

        Assert.assertFalse(coleccionUnidades.contieneUnidad(unidadMock));
    }

    @Test
    public void ColeccionUnidadesConUnidadAgregadaNoEstaVacia(){
        Soldado soldado = mock(Soldado.class);
        ColeccionUnidades coleccion = new ColeccionUnidades();

        coleccion.agregarUnidad(soldado);
        Assertions.assertFalse(coleccion.estaVacia());
    }

    @Test
    public void ColeccionUnidadesContieneUnidadDevuelveTrueConUnaUnidadAnteriormenteAgregada(){
        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();
        Unidad unidadMock = mock(Unidad.class);

        coleccionUnidades.agregarUnidad(unidadMock);

        Assert.assertTrue(coleccionUnidades.contieneUnidad(unidadMock));
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

    @Test
    public void ColeccionUnidadCausarDanioATodasLasUnidadesDaniaATodasLasUnidadesPorElValorDado() throws CasilleroEnemigoExcepcion {
        Equipo equipoMock = mock(Equipo.class);
        Casillero casilleroMock = mock(Casillero.class);
        when(casilleroMock.perteneceAEquipo(equipoMock)).thenReturn(true);
        when(casilleroMock.aplicarMultiplicadorDanioAUnidadDeEquipo(any(Equipo.class))).thenReturn(1.0);
        Soldado soldado = new Soldado(equipoMock);
        soldado.inicializarEnCasillero(casilleroMock);
        Jinete jinete = new Jinete(equipoMock);
        jinete.inicializarEnCasillero(casilleroMock);
        Curandero curandero = new Curandero(equipoMock);
        curandero.inicializarEnCasillero(casilleroMock);

        ColeccionUnidades coleccionUnidades = new ColeccionUnidades();

        coleccionUnidades.agregarUnidad(soldado);
        coleccionUnidades.agregarUnidad(jinete);
        coleccionUnidades.agregarUnidad(curandero);

        int vidaMaximaSoldado = soldado.getVida();
        int vidaMaximaJinete = jinete.getVida();
        int vidaMaximaCurandero = curandero.getVida();

        coleccionUnidades.daniarTodasLasUnidades(20);

        Assert.assertEquals(vidaMaximaSoldado-20,soldado.getVida());
        Assert.assertEquals(vidaMaximaJinete-20,jinete.getVida());
        Assert.assertEquals(vidaMaximaCurandero-20,curandero.getVida());

    }
}
