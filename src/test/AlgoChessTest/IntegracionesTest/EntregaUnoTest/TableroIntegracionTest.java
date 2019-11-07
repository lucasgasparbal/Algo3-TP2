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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableroIntegracionTest {
    @Test
     public void test01TableroSeInicializaCorrectamente(){
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();

        Tablero tablero = new Tablero(equipoBlanco,equipoNegro);

        Assertions.assertEquals(400, tablero.contarCasillerosVacios());
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipo(equipoBlanco));
        Assertions.assertEquals(200, tablero.contarCasillerosDeEquipo(equipoNegro));
    }
    @Test
    public void test02TableroSeColocaPiezaAliadaEnSectorAliadoConExito(){
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();
        Casillero  casillero;
        Tablero tablero = new Tablero(equipoBlanco,equipoNegro);
        Jinete jinete = new Jinete(equipoBlanco);

        try {
            casillero = tablero.conseguirCasillero(5,5);
            jinete.inicializarEnCasillero(casillero);
            Assertions.assertTrue(casillero.getUnidad() == jinete);
        } catch (CasilleroEnemigoExcepcion | CoordenadaFueraDeRangoExcepcion | CasilleroOcupadoExcepcion ignored) {
        }
    }

    @Test
        public void test03TableroSeIntentaColocarPiezaAliadaEnSectorEnemigoYSeFalla(){
            EquipoBlanco equipoBlanco = new EquipoBlanco();
            EquipoNegro equipoNegro = new EquipoNegro();
            Casillero  casillero;
            Tablero tablero = new Tablero(equipoBlanco,equipoNegro);
            Catapulta catapulta = new Catapulta(equipoNegro);

            try {
                casillero = tablero.conseguirCasillero(5,5);
                Assertions.assertThrows(CasilleroEnemigoExcepcion.class, ()->{
                    catapulta.inicializarEnCasillero(casillero);
                });

            } catch (CoordenadaFueraDeRangoExcepcion ignored) {
            }
    }

    @Test
    public void test04TableroSeIntentaColocarPiezaAliadaEnCasillaAliadaOcupadaYSeFalla(){
        EquipoBlanco equipoBlanco = new EquipoBlanco();
        EquipoNegro equipoNegro = new EquipoNegro();
        Casillero  casillero;
        Tablero tablero = new Tablero(equipoBlanco,equipoNegro);
        Catapulta catapulta = new Catapulta(equipoBlanco);
        Curandero curandero = new Curandero(equipoBlanco);

        try {
            casillero = tablero.conseguirCasillero(5,5);
            Assertions.assertThrows(CasilleroOcupadoExcepcion.class, ()->{
                catapulta.inicializarEnCasillero(casillero);
                curandero.inicializarEnCasillero(casillero);
            });

        } catch (CoordenadaFueraDeRangoExcepcion ignored) {
        }
    }
}
