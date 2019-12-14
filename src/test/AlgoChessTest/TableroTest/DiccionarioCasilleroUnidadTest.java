package AlgoChessTest.TableroTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.DiccionarioCasilleroUnidad;
import model.AlgoChess.Unidades.ColeccionUnidades;
import model.AlgoChess.Unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class DiccionarioCasilleroUnidadTest {
    @Test(expected = NoHayUnidadEnCasilleroExcepcion.class)
    public void DiccionarioCasilleroUnidadObtenerUnidadEnCasilleroTiraExcepcionSiNoHayUnidadEnElCasillero() throws NoHayUnidadEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casillero = mock(Casillero.class);

        diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero);
    }

    @Test
    public void DiccionarioCasilleroUnidadObtenerUnidadEnCasilleroDevuelveUnidadSiLaAgregoAntes() throws NoHayUnidadEnCasilleroExcepcion, CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casillero = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);

        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casillero,unidad);

        Assert.assertEquals(unidad,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero));
    }

    @Test(expected = NoHayUnidadEnCasilleroExcepcion.class)

    public void DiccionarioCasilleroUnidadActualizoLaPosicionDeUnaUnidadNoLaPuedoConseguirPorSuCasilleroViejo() throws NoHayUnidadEnCasilleroExcepcion, CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Casillero casilleroB = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);
        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroA,unidad);
        unidad = diccionarioCasilleroUnidad.removerUnidadDeCasillero(casilleroA);
        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroB,unidad);

        diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroA);
    }

    @Test
    public void DiccionarioCasilleroUnidadActualizoLaPosicionDeUnaUnidadLaConsigoPorSuCasilleroNuevo() throws NoHayUnidadEnCasilleroExcepcion, CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Casillero casilleroB = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);
        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroA,unidad);
        unidad = diccionarioCasilleroUnidad.removerUnidadDeCasillero(casilleroA);
        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroB,unidad);

        Assert.assertEquals(unidad,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroB));
    }

    @Test(expected = CasilleroOcupadoExcepcion.class)

    public void DiccionarioCasilleroUnidadEnCasilleroColocarUnidadLanzaExcepcionCasilleroOcupadoExcepcionSiSeHabiaColocadoUnaUnidadAnteriormente() throws CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Unidad unidadUno = mock(Unidad.class);
        Unidad unidadDos = mock(Unidad.class);

        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroA,unidadUno);
        doCallRealMethod().when(casilleroA).ocuparCasillero();

        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroA,unidadDos);

    }

    @Test
    public void DiccionarioCasilleroUnidadEnCasilleroColocarUnidadTieneExiteSiSeColocaUnaNuevaUnidadEnUnCasilleroVaciado() throws CasilleroOcupadoExcepcion, NoHayUnidadEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Unidad unidadUno = mock(Unidad.class);
        Unidad unidadDos = mock(Unidad.class);

        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroA,unidadUno);
        doCallRealMethod().when(casilleroA).ocuparCasillero();
        doCallRealMethod().when(casilleroA).vaciar();
        diccionarioCasilleroUnidad.removerUnidadDeCasillero(casilleroA);

        diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casilleroA,unidadDos);
        Assert.assertEquals(unidadDos,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroA));
    }


    @Test
    public void DiccionarioCasilleroObtenerUnidadesConexasNoContieneALaUnidadParametro() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        /* MODELO POSICIONAMIENTO UNIDADES

          1   2       7
            0 3 4 5 6 8
                       9
        10
         */
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        ArrayList<Casillero> casillerosMock = new ArrayList<>();

        ArrayList<Unidad> unidadesMocks = new ArrayList<>();

        for(int i = 0; i < 11 ; i++){
            unidadesMocks.add(mock(Unidad.class));
            casillerosMock.add(mock(Casillero.class));

            diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casillerosMock.get(i),unidadesMocks.get(i));
            when(unidadesMocks.get(i).esAdyacenteA(any(Unidad.class))).thenReturn(false);
        }

        //Establezco adyacencias en los mocks para que se cumplan las relaciones del modelo representado arriba
        {
            when(unidadesMocks.get(0).esAdyacenteA(unidadesMocks.get(1))).thenReturn(true);
            when(unidadesMocks.get(0).esAdyacenteA(unidadesMocks.get(2))).thenReturn(true);
            when(unidadesMocks.get(0).esAdyacenteA(unidadesMocks.get(3))).thenReturn(true);

            when(unidadesMocks.get(1).esAdyacenteA(unidadesMocks.get(0))).thenReturn(true);

            when(unidadesMocks.get(2).esAdyacenteA(unidadesMocks.get(0))).thenReturn(true);
            when(unidadesMocks.get(2).esAdyacenteA(unidadesMocks.get(3))).thenReturn(true);
            when(unidadesMocks.get(2).esAdyacenteA(unidadesMocks.get(4))).thenReturn(true);

            when(unidadesMocks.get(3).esAdyacenteA(unidadesMocks.get(0))).thenReturn(true);
            when(unidadesMocks.get(3).esAdyacenteA(unidadesMocks.get(2))).thenReturn(true);
            when(unidadesMocks.get(3).esAdyacenteA(unidadesMocks.get(4))).thenReturn(true);

            when(unidadesMocks.get(4).esAdyacenteA(unidadesMocks.get(2))).thenReturn(true);
            when(unidadesMocks.get(4).esAdyacenteA(unidadesMocks.get(3))).thenReturn(true);
            when(unidadesMocks.get(4).esAdyacenteA(unidadesMocks.get(5))).thenReturn(true);

            when(unidadesMocks.get(5).esAdyacenteA(unidadesMocks.get(4))).thenReturn(true);
            when(unidadesMocks.get(5).esAdyacenteA(unidadesMocks.get(6))).thenReturn(true);

            when(unidadesMocks.get(6).esAdyacenteA(unidadesMocks.get(5))).thenReturn(true);
            when(unidadesMocks.get(6).esAdyacenteA(unidadesMocks.get(7))).thenReturn(true);
            when(unidadesMocks.get(6).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);

            when(unidadesMocks.get(7).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);
            when(unidadesMocks.get(7).esAdyacenteA(unidadesMocks.get(9))).thenReturn(true);

            when(unidadesMocks.get(8).esAdyacenteA(unidadesMocks.get(6))).thenReturn(true);
            when(unidadesMocks.get(8).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);
            when(unidadesMocks.get(8).esAdyacenteA(unidadesMocks.get(9))).thenReturn(true);

            when(unidadesMocks.get(9).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);
        }

        ColeccionUnidades unidadesConexas = diccionarioCasilleroUnidad.obtenerUnidadesConexasA(unidadesMocks.get(0));

        Assert.assertFalse(unidadesConexas.contieneUnidad(unidadesMocks.get(0)));
    }

    @Test
    public void DiccionarioCasilleroObtenerUnidadesConexasContieneSolamenteALasUnidadesConexas() throws CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion {
        /* MODELO POSICIONAMIENTO UNIDADES

          1   2       7
            0 3 4 5 6 8
                       9
        10
         */
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        ArrayList<Casillero> casillerosMock = new ArrayList<>();

        ArrayList<Unidad> unidadesMocks = new ArrayList<>();

        for(int i = 0; i < 11 ; i++){
            unidadesMocks.add(mock(Unidad.class));
            casillerosMock.add(mock(Casillero.class));

            diccionarioCasilleroUnidad.enCasilleroPonerUnidad(casillerosMock.get(i),unidadesMocks.get(i));
            when(unidadesMocks.get(i).esAdyacenteA(any(Unidad.class))).thenReturn(false);
        }

        //Establezco adyacencias en los mocks para que se cumplan las relaciones del modelo representado arriba
        {
            when(unidadesMocks.get(0).esAdyacenteA(unidadesMocks.get(1))).thenReturn(true);
            when(unidadesMocks.get(0).esAdyacenteA(unidadesMocks.get(2))).thenReturn(true);
            when(unidadesMocks.get(0).esAdyacenteA(unidadesMocks.get(3))).thenReturn(true);

            when(unidadesMocks.get(1).esAdyacenteA(unidadesMocks.get(0))).thenReturn(true);

            when(unidadesMocks.get(2).esAdyacenteA(unidadesMocks.get(0))).thenReturn(true);
            when(unidadesMocks.get(2).esAdyacenteA(unidadesMocks.get(3))).thenReturn(true);
            when(unidadesMocks.get(2).esAdyacenteA(unidadesMocks.get(4))).thenReturn(true);

            when(unidadesMocks.get(3).esAdyacenteA(unidadesMocks.get(0))).thenReturn(true);
            when(unidadesMocks.get(3).esAdyacenteA(unidadesMocks.get(2))).thenReturn(true);
            when(unidadesMocks.get(3).esAdyacenteA(unidadesMocks.get(4))).thenReturn(true);

            when(unidadesMocks.get(4).esAdyacenteA(unidadesMocks.get(2))).thenReturn(true);
            when(unidadesMocks.get(4).esAdyacenteA(unidadesMocks.get(3))).thenReturn(true);
            when(unidadesMocks.get(4).esAdyacenteA(unidadesMocks.get(5))).thenReturn(true);

            when(unidadesMocks.get(5).esAdyacenteA(unidadesMocks.get(4))).thenReturn(true);
            when(unidadesMocks.get(5).esAdyacenteA(unidadesMocks.get(6))).thenReturn(true);

            when(unidadesMocks.get(6).esAdyacenteA(unidadesMocks.get(5))).thenReturn(true);
            when(unidadesMocks.get(6).esAdyacenteA(unidadesMocks.get(7))).thenReturn(true);
            when(unidadesMocks.get(6).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);

            when(unidadesMocks.get(7).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);
            when(unidadesMocks.get(7).esAdyacenteA(unidadesMocks.get(9))).thenReturn(true);

            when(unidadesMocks.get(8).esAdyacenteA(unidadesMocks.get(6))).thenReturn(true);
            when(unidadesMocks.get(8).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);
            when(unidadesMocks.get(8).esAdyacenteA(unidadesMocks.get(9))).thenReturn(true);

            when(unidadesMocks.get(9).esAdyacenteA(unidadesMocks.get(8))).thenReturn(true);
        }

        ColeccionUnidades unidadesConexas = diccionarioCasilleroUnidad.obtenerUnidadesConexasA(unidadesMocks.get(0));

        for(int i = 1; i <= 9; i++){
            Assert.assertTrue(unidadesConexas.contieneUnidad(unidadesMocks.get(i)));
        }

        Assert.assertFalse(unidadesConexas.contieneUnidad(unidadesMocks.get(10)));
    }
}
