package AlgoChessTest.TableroTest;

import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.NoHayUnidadEnCasilleroExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.DiccionarioCasilleroUnidad;
import model.AlgoChess.Unidades.Unidad;
import org.junit.Assert;
import org.junit.Test;

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

        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casillero,unidad);

        Assert.assertEquals(unidad,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casillero));
    }

    @Test(expected = NoHayUnidadEnCasilleroExcepcion.class)

    public void DiccionarioCasilleroUnidadActualizoLaPosicionDeUnaUnidadNoLaPuedoConseguirPorSuCasilleroViejo() throws NoHayUnidadEnCasilleroExcepcion, CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Casillero casilleroB = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidad);
        unidad = diccionarioCasilleroUnidad.removerUnidadDeCasillero(casilleroA);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroB,unidad);

        diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroA);
    }

    @Test
    public void DiccionarioCasilleroUnidadActualizoLaPosicionDeUnaUnidadLaConsigoPorSuCasilleroNuevo() throws NoHayUnidadEnCasilleroExcepcion, CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Casillero casilleroB = mock(Casillero.class);
        Unidad unidad = mock(Unidad.class);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidad);
        unidad = diccionarioCasilleroUnidad.removerUnidadDeCasillero(casilleroA);
        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroB,unidad);

        Assert.assertEquals(unidad,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroB));
    }

    @Test(expected = CasilleroOcupadoExcepcion.class)

    public void DiccionarioCasilleroUnidadEnCasilleroColocarUnidadLanzaExcepcionCasilleroOcupadoExcepcionSiSeHabiaColocadoUnaUnidadAnteriormente() throws CasilleroOcupadoExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Unidad unidadUno = mock(Unidad.class);
        Unidad unidadDos = mock(Unidad.class);

        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidadUno);
        doCallRealMethod().when(casilleroA).ocuparCasillero();

        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidadDos);

    }

    @Test
    public void DiccionarioCasilleroUnidadEnCasilleroColocarUnidadTieneExiteSiSeColocaUnaNuevaUnidadEnUnCasilleroVaciado() throws CasilleroOcupadoExcepcion, NoHayUnidadEnCasilleroExcepcion {
        DiccionarioCasilleroUnidad diccionarioCasilleroUnidad = new DiccionarioCasilleroUnidad();
        Casillero casilleroA = mock(Casillero.class);
        Unidad unidadUno = mock(Unidad.class);
        Unidad unidadDos = mock(Unidad.class);

        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidadUno);
        doCallRealMethod().when(casilleroA).ocuparCasillero();
        doCallRealMethod().when(casilleroA).vaciar();
        diccionarioCasilleroUnidad.removerUnidadDeCasillero(casilleroA);

        diccionarioCasilleroUnidad.EnCasilleroPonerUnidad(casilleroA,unidadDos);
        Assert.assertEquals(unidadDos,diccionarioCasilleroUnidad.obtenerUnidadEnCasillero(casilleroA));
    }

}
