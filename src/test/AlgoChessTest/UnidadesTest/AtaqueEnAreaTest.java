package AlgoChessTest.UnidadesTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.ObjetivoFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Ataques.AtaqueEnArea;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import model.AlgoChess.Unidades.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class AtaqueEnAreaTest {

    @Test
    public void AtaqueEnAreaAtacarAUnidadSinUnidadesConexasSoloHaceDanioALaUnidadParametro() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion {

        AtaqueEnArea ataqueEnArea = new AtaqueEnArea(20);

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);

        Catapulta catapulta = new Catapulta(equipoUno);
        Soldado soldado = new Soldado(equipoDos);
        Soldado soldadoB = new Soldado(equipoDos);

        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadasA = {1,2};
        int[] coordenadasB = {9,16};
        int[] coordenadasC = {2,16};
        tablero.inicializarUnidadEnCasillero(catapulta, coordenadasA);
        tablero.inicializarUnidadEnCasillero(soldado,coordenadasB);
        tablero.inicializarUnidadEnCasillero(soldadoB,coordenadasC);

        int vidaMaximaSoldado = soldado.getVida();
        int vidaMaximaSoldadoB = soldadoB.getVida();

        ataqueEnArea.atacar(soldado,catapulta);

        Assert.assertEquals(soldado.getVida(),vidaMaximaSoldado-20);
        Assert.assertEquals(soldadoB.getVida(),vidaMaximaSoldadoB);
    }

    @Test
    public void AtaqueEnAreaAtacarAUnidadConUnidadesConexasHaceDaniosIgualesALaUnidadParametroYASusUnidadesAdyacentesEnemigasDeCatapulta() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion {

        AtaqueEnArea ataqueEnArea = new AtaqueEnArea(20);

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);

        Catapulta catapulta = new Catapulta(equipoUno);
        Soldado soldadoA = new Soldado(equipoDos);
        Soldado soldadoB = new Soldado(equipoDos);
        Soldado soldadoC = new Soldado(equipoDos);

        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadasA = {1,2};
        int[] coordenadasB = {9,16};
        int[] coordenadasC = {8,16};
        int[] coordenadasD = {9,17};
        tablero.inicializarUnidadEnCasillero(catapulta, coordenadasA);
        tablero.inicializarUnidadEnCasillero(soldadoA,coordenadasB);
        tablero.inicializarUnidadEnCasillero(soldadoB,coordenadasC);
        tablero.inicializarUnidadEnCasillero(soldadoC,coordenadasD);

        int vidaMaximaSoldadoA = soldadoA.getVida();
        int vidaMaximaSoldadoB = soldadoB.getVida();
        int vidaMaximaSoldadoC = soldadoC.getVida();
        int vidaMaximaCatapulta = catapulta.getVida();

        ataqueEnArea.atacar(soldadoA,catapulta);

        Assert.assertEquals(soldadoA.getVida(),vidaMaximaSoldadoA-20);
        Assert.assertEquals(soldadoB.getVida(),vidaMaximaSoldadoB-20);
        Assert.assertEquals(soldadoC.getVida(),vidaMaximaSoldadoC-20);
        Assert.assertEquals(vidaMaximaCatapulta,catapulta.getVida());
    }

    @Test
    public void AtaqueEnAreaAtacarAUnidadConUnidadesConexasHaceDanioALaUnidadParametroYASusUnidadesAdyacentesAliadasDeCatapulta() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion {

        AtaqueEnArea ataqueEnArea = new AtaqueEnArea(20);

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);

        Catapulta catapulta = new Catapulta(equipoUno);
        Soldado soldadoA = new Soldado(equipoDos);
        Curandero curandero = new Curandero(equipoUno);
        Jinete jinete = new Jinete(equipoUno);

        Tablero tablero = new Tablero(equipoUno,equipoDos);

        int[] coordenadasA = {0,0};
        int[] coordenadasB = {9,10};
        int[] coordenadasC = {8,9};
        int[] coordenadasD = {7,8};
        tablero.inicializarUnidadEnCasillero(catapulta, coordenadasA);
        tablero.inicializarUnidadEnCasillero(soldadoA,coordenadasB);
        tablero.inicializarUnidadEnCasillero(curandero,coordenadasC);
        tablero.inicializarUnidadEnCasillero(jinete,coordenadasD);

        int vidaMaximaSoldadoA = soldadoA.getVida();
        int vidaMaximaCurandero = curandero.getVida();
        int vidaMaximaJinete= jinete.getVida();

        ataqueEnArea.atacar(soldadoA,catapulta);

        Assert.assertEquals(vidaMaximaSoldadoA-20,soldadoA.getVida());
        Assert.assertEquals(vidaMaximaCurandero-20,curandero.getVida());
        Assert.assertEquals(vidaMaximaJinete-20,jinete.getVida());
    }

    @Test
    public void AtaqueEnAreaAtacarAUnidadConUnidadesConexasQueFormanUnaLineaHastaCatapultaHaceDanioACatapulta() throws CasilleroOcupadoExcepcion, CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion {

        AtaqueEnArea ataqueEnArea = new AtaqueEnArea(20);

        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);

        Catapulta catapulta = new Catapulta(equipoUno);
        Soldado soldadoA = new Soldado(equipoDos);

        int[] coordenadasCatapulta = {0,0};
        int[] coordenadasSoldado = {10,10};

        Tablero tablero = new Tablero(equipoUno,equipoDos);

        tablero.inicializarUnidadEnCasillero(catapulta,coordenadasCatapulta);
        tablero.inicializarUnidadEnCasillero(soldadoA,coordenadasSoldado);

        for(int i= 1; i<=9; i++){
            int[] coordenadas = {10-i,10-i};
            Soldado soldadoAliado = new Soldado(equipoUno);
            tablero.inicializarUnidadEnCasillero(soldadoAliado,coordenadas);
        }

        int vidaMaximaCatapulta = catapulta.getVida();

        ataqueEnArea.atacar(soldadoA,catapulta);

        Assert.assertEquals(catapulta.getVida(),vidaMaximaCatapulta-20);

    }
}
