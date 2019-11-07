package AlgoChessTest.EquiposTest;

import model.AlgoChess.Equipos.EquipoNegro;
import org.junit.Test;

import model.AlgoChess.Equipos.EquipoBlanco;


import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

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

   @Test
   public void test03EquipoBlancoEsIgualAEquipoBlanco(){
      EquipoBlanco equipoBlanco = new EquipoBlanco();
      assertTrue(equipoBlanco.esIgualA(equipoBlanco));
   }

   @Test
   public void test04EquipoBlancoNoEsIgualAEquipoNegro(){
      EquipoBlanco equipoBlanco = new EquipoBlanco();

      EquipoNegro equipoNegroMock = mock(EquipoNegro.class);
      when(equipoNegroMock.esBlanco()).thenReturn(false);

      assertFalse(equipoBlanco.esIgualA(equipoNegroMock));

      verify(equipoNegroMock,times(1)).esBlanco();
   }
}
