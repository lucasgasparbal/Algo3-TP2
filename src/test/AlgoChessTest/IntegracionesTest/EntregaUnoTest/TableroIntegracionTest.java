package AlgoChessTest.IntegracionesTest.EntregaUnoTest;

import model.AlgoChess.Equipos.EquipoBlanco;
import model.AlgoChess.Equipos.EquipoNegro;
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
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();

        Tablero tablero = new Tablero();

        Assertions.assertEquals(400, tablero.contarCasillerosVacios());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipoBlanco());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipoNegro());
    }
    @Test
    public void test02TableroSeColocaPiezaAliadaEnSectorAliadoConExito() throws CasilleroEnemigoExcepcion, CoordenadaFueraDeRangoExcepcion, CasilleroOcupadoExcepcion{
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();
        Casillero  casillero;
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete(equipoBlanco);

        casillero = tablero.conseguirCasillero(5,5);
        jinete.inicializarEnCasillero(casillero);

        Assertions.assertArrayEquals(jinete.getPosicion(), casillero.coordenadas());
    }

    @Test
        public void test03TableroSeIntentaColocarPiezaAliadaEnSectorEnemigoYSeFalla() throws CoordenadaFueraDeRangoExcepcion{
            EquipoBlanco equipoBlanco = new EquipoBlanco();
            EquipoNegro equipoNegro = new EquipoNegro();
            Casillero  casillero;
            Tablero tablero = new Tablero();
            Catapulta catapulta = new Catapulta(equipoNegro);

            casillero = tablero.conseguirCasillero(5,5);

            Assertions.assertThrows(CasilleroEnemigoExcepcion.class, ()->{
                    catapulta.inicializarEnCasillero(casillero);
                });
    }

    @Test
    public void test04TableroSeIntentaColocarPiezaAliadaEnCasillaAliadaOcupadaYSeFalla() throws CoordenadaFueraDeRangoExcepcion{
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();
        Casillero  casillero;
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(equipoBlanco);
        Curandero curandero = new Curandero(equipoBlanco);
        casillero = tablero.conseguirCasillero(5,5);


            Assertions.assertThrows(CasilleroOcupadoExcepcion.class, ()->{
                catapulta.inicializarEnCasillero(casillero);
                curandero.inicializarEnCasillero(casillero);
            });
    }
}
