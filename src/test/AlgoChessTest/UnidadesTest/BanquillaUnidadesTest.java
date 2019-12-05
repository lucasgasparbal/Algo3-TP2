package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Excepciones.NoHayCatapultasEnBanquillaExcepcion;
import model.AlgoChess.Excepciones.NoHayCuranderosEnBanquillaExcepcion;
import model.AlgoChess.Excepciones.NoHayJinetesEnBanquillaExcepcion;
import model.AlgoChess.Excepciones.NoHaySoldadosEnBanquillaExcepcion;
import model.AlgoChess.Unidades.BanquillaUnidades;
import model.AlgoChess.Unidades.*;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BanquillaUnidadesTest {

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeSolados() {

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneSoldados());
    }

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeJinetes() {

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneJinetes());
    }

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeCuranderos() {

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneCuranderos());
    }

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeCatapultas() {

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneCatapultas());
    }

    @Test
    public void BanquillaUnidadeSiAgregoSoldadoLaBanquillaTieneSoldado() {
        Soldado soldado = mock(Soldado.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarSoldado(soldado);
        Assert.assertTrue(banquillaUnidades.tieneSoldados());
    }

    @Test
    public void BanquillaUnidadeSiAgregoJineteLaBanquillaTieneJinete() {
        Jinete jinete = mock(Jinete.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarJinete(jinete);
        Assert.assertTrue(banquillaUnidades.tieneJinetes());
    }

    @Test
    public void BanquillaUnidadeSiAgregoCuranderoLaBanquillaTieneCuranderos() {
        Curandero curandero = mock(Curandero.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCurandero(curandero);
        Assert.assertTrue(banquillaUnidades.tieneCuranderos());
    }

    @Test
    public void BanquillaUnidadeSiAgregoCatapultaLaBanquillaTieneCatapulta() {
        Catapulta catapulta = mock(Catapulta.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCatapulta(catapulta);
        Assert.assertTrue(banquillaUnidades.tieneCatapultas());
    }

    @Test
    public void BanquillaUnidadesCantidadSoldadosDevuelveLaCantidadDeSoldadosAgregados() {
        Soldado soldadoUno = mock(Soldado.class);
        Soldado soldadoDos = mock(Soldado.class);
        Soldado soldadoTres = mock(Soldado.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarSoldado(soldadoUno);
        banquillaUnidades.agregarSoldado(soldadoDos);
        banquillaUnidades.agregarSoldado(soldadoTres);

        Assert.assertEquals(3, banquillaUnidades.cantidadSoldados());
    }

    @Test
    public void BanquillaUnidadesCantidadJinetesDevuelveLaCantidadDeJinetesAgregados(){
        Jinete jineteUno = mock(Jinete.class);
        Jinete jineteDos = mock(Jinete.class);
        Jinete jineteTres = mock(Jinete.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarJinete(jineteUno);
        banquillaUnidades.agregarJinete(jineteDos);
        banquillaUnidades.agregarJinete(jineteTres);

        Assert.assertEquals(3,banquillaUnidades.cantidadJinetes());
    }

    @Test
    public void BanquillaUnidadesCantidadCuranderosDevuelveLaCantidadDeCuranderosAgregados(){
        Curandero curanderoUno = mock(Curandero.class);
        Curandero curanderoDos = mock(Curandero.class);
        Curandero curanderoTres = mock(Curandero.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCurandero(curanderoUno);
        banquillaUnidades.agregarCurandero(curanderoDos);
        banquillaUnidades.agregarCurandero(curanderoTres);

        Assert.assertEquals(3,banquillaUnidades.cantidadCuranderos());
    }

    @Test
    public void BanquillaUnidadesCantidadCatapultasDevuelveLaCantidadDeCatapultasAgregados(){
        Catapulta catapultaUno = mock(Catapulta.class);
        Catapulta catapultaDos = mock(Catapulta.class);
        Catapulta catapultaTres = mock(Catapulta.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCatapulta(catapultaUno);
        banquillaUnidades.agregarCatapulta(catapultaDos);
        banquillaUnidades.agregarCatapulta(catapultaTres);

        Assert.assertEquals(3,banquillaUnidades.cantidadCatapultas());
    }

    @Test(expected = NoHaySoldadosEnBanquillaExcepcion.class)
    public void BanquillaUnidadesTomarSoldadoSinSoldadosLanzaExcepcion() throws NoHaySoldadosEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.tomarSoldado();
    }

    @Test
    public void BanquillaUnidadesTomarSoldadoConSoldadosDevuelveElUltimoSoldadoDado() throws NoHaySoldadosEnBanquillaExcepcion {
        Soldado soldadoUno = mock(Soldado.class);
        Soldado soldadoDos = mock(Soldado.class);
        Soldado soldadoTres = mock(Soldado.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarSoldado(soldadoUno);
        banquillaUnidades.agregarSoldado(soldadoDos);
        banquillaUnidades.agregarSoldado(soldadoTres);

        Assert.assertEquals(soldadoTres,banquillaUnidades.tomarSoldado());
    }

    @Test(expected = NoHaySoldadosEnBanquillaExcepcion.class)
    public void BanquillaUnidadesRemoverSoldadoSinSoldadosLanzaExcepcion() throws NoHaySoldadosEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.removerSoldado();
    }

    @Test(expected = NoHayJinetesEnBanquillaExcepcion.class)
    public void BanquillaUnidadesTomarJineteSinJinetesLanzaExcepcion() throws NoHayJinetesEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.tomarJinete();
    }

    @Test
    public void BanquillaUnidadesTomarJineteConJinetesDevuelveElUltimoJineteDado() throws NoHayJinetesEnBanquillaExcepcion {
        Jinete jineteUno = mock(Jinete.class);
        Jinete jineteDos = mock(Jinete.class);
        Jinete jineteTres = mock(Jinete.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarJinete(jineteUno);
        banquillaUnidades.agregarJinete(jineteDos);
        banquillaUnidades.agregarJinete(jineteTres);

        Assert.assertEquals(jineteTres,banquillaUnidades.tomarJinete());
    }

    @Test(expected = NoHayJinetesEnBanquillaExcepcion.class)
    public void BanquillaUnidadesRemoverJineteSinJinetesLanzaExcepcion() throws NoHayJinetesEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.removerJinete();
    }

    @Test(expected = NoHayCuranderosEnBanquillaExcepcion.class)
    public void BanquillaUnidadesTomarCuranderoSinCuranderosLanzaExcepcion() throws NoHayCuranderosEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.tomarCurandero();
    }

    @Test
    public void BanquillaUnidadesTomarCuranderoConCuranderosDevuelveElUltimoCuranderoDado() throws NoHayCuranderosEnBanquillaExcepcion {
        Curandero curanderoUno = mock(Curandero.class);
        Curandero curanderoDos = mock(Curandero.class);
        Curandero curanderoTres = mock(Curandero.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCurandero(curanderoUno);
        banquillaUnidades.agregarCurandero(curanderoDos);
        banquillaUnidades.agregarCurandero(curanderoTres);

        Assert.assertEquals(curanderoTres,banquillaUnidades.tomarCurandero());
    }

    @Test(expected = NoHayCuranderosEnBanquillaExcepcion.class)
    public void BanquillaUnidadesRemoverCuranderoSinCuranderosLanzaExcepcion() throws NoHayCuranderosEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.removerCurandero();
    }

    @Test(expected = NoHayCatapultasEnBanquillaExcepcion.class)
    public void BanquillaUnidadesTomarCatapultaSinCatapultasLanzaExcepcion() throws NoHayCatapultasEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.tomarCatapulta();
    }

    @Test
    public void BanquillaUnidadesTomarCatapultaConCatapultasDevuelveElUltimoCatapultaDado() throws NoHayCatapultasEnBanquillaExcepcion {
        Catapulta catapultaUno = mock(Catapulta.class);
        Catapulta catapultaDos = mock(Catapulta.class);
        Catapulta catapultaTres = mock(Catapulta.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCatapulta(catapultaUno);
        banquillaUnidades.agregarCatapulta(catapultaDos);
        banquillaUnidades.agregarCatapulta(catapultaTres);

        Assert.assertEquals(catapultaTres,banquillaUnidades.tomarCatapulta());
    }

    @Test(expected = NoHayCatapultasEnBanquillaExcepcion.class)
    public void BanquillaUnidadesRemoverCatapultaSinCatapultasLanzaExcepcion() throws NoHayCatapultasEnBanquillaExcepcion {
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.removerCatapulta();
    }

    @Test
    public void BanquillaUnidadesRemoverSoldadoConSoldadosReduceLaCantidadDeSoldadosEnUno() throws NoHaySoldadosEnBanquillaExcepcion {
        Soldado soldadoUno = mock(Soldado.class);
        Soldado soldadoDos = mock(Soldado.class);
        Soldado soldadoTres = mock(Soldado.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarSoldado(soldadoUno);
        banquillaUnidades.agregarSoldado(soldadoDos);
        banquillaUnidades.agregarSoldado(soldadoTres);
        banquillaUnidades.removerSoldado();

        Assert.assertEquals(2,banquillaUnidades.cantidadSoldados());
    }

    @Test
    public void BanquillaUnidadesRemoverJineteConJinetesReduceLaCantidadDeJinetesEnUno() throws NoHayJinetesEnBanquillaExcepcion {
        Jinete jineteUno = mock(Jinete.class);
        Jinete jineteDos = mock(Jinete.class);
        Jinete jineteTres = mock(Jinete.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarJinete(jineteUno);
        banquillaUnidades.agregarJinete(jineteDos);
        banquillaUnidades.agregarJinete(jineteTres);
        banquillaUnidades.removerJinete();

        Assert.assertEquals(2,banquillaUnidades.cantidadJinetes());
    }

    @Test
    public void BanquillaUnidadesRemoverCuranderoConCuranderosReduceLaCantidadDeCuranderosEnUno() throws NoHayCuranderosEnBanquillaExcepcion {
        Curandero curanderoUno = mock(Curandero.class);
        Curandero curanderoDos = mock(Curandero.class);
        Curandero curanderoTres = mock(Curandero.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCurandero(curanderoUno);
        banquillaUnidades.agregarCurandero(curanderoDos);
        banquillaUnidades.agregarCurandero(curanderoTres);
        banquillaUnidades.removerCurandero();

        Assert.assertEquals(2,banquillaUnidades.cantidadCuranderos());
    }

    @Test
    public void BanquillaUnidadesRemoverCatapultaConCatapultasReduceLaCantidadDeCatapultasEnUno() throws NoHayCatapultasEnBanquillaExcepcion {
        Catapulta catapultaUno = mock(Catapulta.class);
        Catapulta catapultaDos = mock(Catapulta.class);
        Catapulta catapultaTres = mock(Catapulta.class);

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCatapulta(catapultaUno);
        banquillaUnidades.agregarCatapulta(catapultaDos);
        banquillaUnidades.agregarCatapulta(catapultaTres);
        banquillaUnidades.removerCatapulta();

        Assert.assertEquals(2,banquillaUnidades.cantidadCatapultas());
    }

}
