package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Unidades.Ataques.AtaqueCuerpoACuerpo;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Soldado extends UnidadMovible {

    private static final int Costo = 1;
    private final int VidaSoldado = 100;

    private boolean tieneBatallon=false;

    private Batallon batallon ;

    private AtaqueCuerpoACuerpo ataque = new AtaqueCuerpoACuerpo(10);

    public boolean tieneBatallon () {
        return tieneBatallon;
    }

    public Soldado(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaSoldado);
        costo = Costo;
    }

    public void atacar(Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, ObjetivoFueraDeRangoExcepcion, YaAtacoExcepcion {
        if(ataco){
            throw new YaAtacoExcepcion();
        }
        if(!objetivo.esEnemigoDe(this)){
            throw new ObjetivoNoEsEnemigoExcepcion();
        }
        ataque.atacar(objetivo,this);
        ataco = true;
    }

    public void moverBatallonParaArriba () throws YaMovioExcepcion, MovimientoInvalidoExcepcion {
        batallon.desplazarBatallonHaciaArriba();
    }

    public void moverBatallonParaAbajo () throws YaMovioExcepcion, MovimientoInvalidoExcepcion {
        batallon.desplazarBatallonHaciaAbajo();
    }

    public void moverBatallonParaIzquierda () throws YaMovioExcepcion, MovimientoInvalidoExcepcion {
        batallon.desplazarBatallonHaciaIzquierda();
    }

    public void moverBatallonParaDerecha () throws YaMovioExcepcion, MovimientoInvalidoExcepcion {
        batallon.desplazarBatallonHaciaDerecha();
    }


    public void asignarBatallon(Batallon batallonAsignado) {
        tieneBatallon = true;
        batallon = batallonAsignado;
    }

    public void quitarBatallon() {
        tieneBatallon = false;
        batallon = null;
    }
}
