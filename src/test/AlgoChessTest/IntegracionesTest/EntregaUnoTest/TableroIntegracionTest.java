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
        Tablero tablero = new Tablero();

        Assertions.assertEquals(400, tablero.contarCasillerosVacios());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipoUno());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipoDos());
    }
    @Test
    public void test02TableroSeColocaPiezaAliadaEnSectorAliadoConExito() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion{
        Equipo equipo = new Equipo(1);
        Casillero  casillero;
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(equipo);

        casillero = tablero.conseguirCasillero(5,5);
        jinete.inicializarEnCasillero(casillero);

        Assertions.assertArrayEquals(jinete.getPosicion(), casillero.coordenadas());
    }

    @Test
        public void test03TableroSeIntentaColocarPiezaAliadaEnSectorEnemigoYSeFalla() throws CoordenadaFueraDeRangoExcepcion{
            Equipo equipoDos = new Equipo(2);
            Casillero  casillero;
            Tablero tablero = new Tablero();
            Catapulta catapulta = new Catapulta(equipoDos);

            casillero = tablero.conseguirCasillero(5,5);

            Assertions.assertThrows(CasilleroEnemigoExcepcion.class, ()->{
                    catapulta.inicializarEnCasillero(casillero);
                });
    }

    @Test
    public void test04TableroSeIntentaColocarPiezaAliadaEnCasillaAliadaOcupadaYSeFalla() throws CoordenadaFueraDeRangoExcepcion{
        Equipo equipo = new Equipo(1);
        Casillero  casillero;
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(equipo);
        Curandero curandero = new Curandero(equipo);
        casillero = tablero.conseguirCasillero(5,5);


            Assertions.assertThrows(CasilleroOcupadoExcepcion.class, ()->{
                catapulta.inicializarEnCasillero(casillero);
                curandero.inicializarEnCasillero(casillero);
            });
    }
}
