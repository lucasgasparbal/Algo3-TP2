package AlgoChessTest.EquiposTest;

import org.junit.Test;

import model.AlgoChess.Equipos.EquipoBlanco;


import static junit.framework.TestCase.*;

public class EquipoBlancoTest{
   @Test
   public void test01esBlancoDevuelveTrueEnEquipoBlanco(){
      EquipoBlanco equipoBlanco = new EquipoBlanco();
      assertTrue(equipoBlanco.esBlanco());
   }

   @Test
   public void test02esNegroDevuelveFalseEnEquipoBlanco(){
      EquipoBlanco equipoBlanco = new EquipoBlanco();
      assertFalse(equipoBlanco.esNegro());
   }
}
