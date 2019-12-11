package AlgoChessTest.IntegracionesTest.EntregaUnoTest;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Tablero.Tablero;
import model.AlgoChess.Unidades.Catapulta;
import model.AlgoChess.Unidades.Curandero;
import model.AlgoChess.Unidades.Jinete;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TableroIntegracionTest {
    @Test
     public void test01TableroSeInicializaCorrectamente(){
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);

        Assertions.assertEquals(400, tablero.contarCasillerosVacios());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipoUno());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipoDos());
    }
    @Test
    public void test02TableroSeColocaPiezaAliadaEnSectorAliadoConExito() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Casillero  casillero;
        Jinete jinete = new Jinete(equipoUno);
        int[] coordenadasA = {5,5};
        casillero = tablero.conseguirCasillero(coordenadasA);
        jinete.inicializarEnCasillero(casillero);

        Assertions.assertArrayEquals(jinete.getPosicion(), casillero.coordenadas());
    }

    @Test
        public void test03TableroSeIntentaColocarPiezaAliadaEnSectorEnemigoYSeFalla() throws CoordenadaFueraDeRangoExcepcion{
            Equipo equipoUno = new Equipo(1);
            Equipo equipoDos = new Equipo(2);
            Tablero tablero = new Tablero(equipoUno,equipoDos);
            Casillero  casillero;
            Catapulta catapulta = new Catapulta(equipoDos);
            int[] coordenadasA = {5,5};
            casillero = tablero.conseguirCasillero(coordenadasA);

            Assertions.assertThrows(CasilleroEnemigoExcepcion.class, ()->{
                    catapulta.inicializarEnCasillero(casillero);
                });
    }

    @Test
    public void test04TableroSeIntentaColocarPiezaAliadaEnCasillaAliadaOcupadaYSeFalla() throws CoordenadaFueraDeRangoExcepcion{
        Equipo equipoUno = new Equipo(1);
        Equipo equipoDos = new Equipo(2);
        Tablero tablero = new Tablero(equipoUno,equipoDos);
        Catapulta catapulta = new Catapulta(equipoUno);
        Curandero curandero = new Curandero(equipoUno);
        int[] coordenadasA = {5,5};


            Assertions.assertThrows(CasilleroOcupadoExcepcion.class, ()->{
                tablero.inicializarUnidadEnCasillero(catapulta,coordenadasA);
                tablero.inicializarUnidadEnCasillero(curandero,coordenadasA);
            });
    }
}
