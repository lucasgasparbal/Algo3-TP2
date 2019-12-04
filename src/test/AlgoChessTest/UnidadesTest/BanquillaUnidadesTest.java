package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Unidades.BanquillaUnidades;
import model.AlgoChess.Unidades.*;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BanquillaUnidadesTest {
    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeSolados(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneSoldados());
    }

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeJinetes(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneJinetes());
    }

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeCuranderos(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneCuranderos());
    }

    @Test
    public void BanquillaUnidadesRecienCreadaNoPoseeCatapultas(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        Assert.assertFalse(banquillaUnidades.tieneCatapultas());
    }

    @Test
    public void BanquillaUnidadeSiAgregoSoldadoLaBanquillaTieneSoldado(){
        Soldado soldado = mock(Soldado.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarSoldado(soldado);
        Assert.assertTrue(banquillaUnidades.tieneSoldados());
    }

    @Test
    public void BanquillaUnidadeSiAgregoJineteLaBanquillaTieneJinete(){
        Jinete jinete = mock(Jinete.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarJinete(jinete);
        Assert.assertTrue(banquillaUnidades.tieneJinetes());
    }

    @Test
    public void BanquillaUnidadeSiAgregoCuranderoLaBanquillaTieneCuranderos(){
        Curandero curandero = mock(Curandero.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCurandero(curandero);
        Assert.assertTrue(banquillaUnidades.tieneCuranderos());
    }

    @Test
    public void BanquillaUnidadeSiAgregoCatapultaLaBanquillaTieneCatapulta(){
        Catapulta catapulta = mock(Catapulta.class);
        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCatapulta(catapulta);
        Assert.assertTrue(banquillaUnidades.tieneCatapultas());
    }
}
