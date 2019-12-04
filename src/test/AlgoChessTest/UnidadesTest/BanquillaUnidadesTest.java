package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Unidades.BanquillaUnidades;
import org.junit.Assert;
import org.junit.Test;

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

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarSoldado();
        Assert.assertTrue(banquillaUnidades.tieneSoldados());
    }

    @Test
    public void BanquillaUnidadeSiAgregoJineteLaBanquillaTieneJinete(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarJinete();
        Assert.assertTrue(banquillaUnidades.tieneJinetes());
    }

    @Test
    public void BanquillaUnidadeSiAgregoCuranderoLaBanquillaTieneCuranderos(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCurandero();
        Assert.assertTrue(banquillaUnidades.tieneCuranderos());
    }

    @Test
    public void BanquillaUnidadeSiAgregoCatapultaLaBanquillaTieneCatapulta(){

        BanquillaUnidades banquillaUnidades = new BanquillaUnidades();

        banquillaUnidades.agregarCatapulta();
        Assert.assertTrue(banquillaUnidades.tieneCatapultas());
    }
}
