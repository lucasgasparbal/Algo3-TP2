package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.Ataques.AtaqueCuerpoACuerpo;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Soldado extends UnidadMovible {

    private static final int Costo = 1;
    private final int VidaSoldado = 100;

    private boolean tieneBatallon = false;
    private boolean seMovioConBatallon = false;

    private Batallon batallon;

    private AtaqueCuerpoACuerpo ataque = new AtaqueCuerpoACuerpo(10);

    public boolean tieneBatallon() {
        return tieneBatallon;
    }

    public Soldado(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaSoldado);
        costo = Costo;
    }

    public void desplazarConBatallonHaciaArriba() throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion {
        if (seMovioConBatallon) {
            throw new BatallonYaSeMovioExcepcion();
        }

        boolean seHabiaMovido = false;
        if (movio) {
            seHabiaMovido = true;
            movio = false;
        }
        desplazarHaciaArriba();
        if (!seHabiaMovido) {
            movio = false;
        }
        seMovioConBatallon = true;
    }

    public void desplazarConBatallonHaciaAbajo() throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion {
        if (seMovioConBatallon) {
            throw new BatallonYaSeMovioExcepcion();
        }

        boolean seHabiaMovido = false;
        if (movio) {
            seHabiaMovido = true;
            movio = false;
        }
        desplazarHaciaAbajo();
        if (!seHabiaMovido) {
            movio = false;
        }
        seMovioConBatallon = true;
    }

    public void desplazarConBatallonHaciaIzquierda() throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion {
        if (seMovioConBatallon) {
            throw new BatallonYaSeMovioExcepcion();
        }

        boolean seHabiaMovido = false;
        if (movio) {
            seHabiaMovido = true;
            movio = false;
        }
        desplazarHaciaIzquierda();
        if (!seHabiaMovido) {
            movio = false;
        }
        seMovioConBatallon = true;
    }

    public void desplazarConBatallonHaciaDerecha() throws CasilleroOcupadoExcepcion, MovimientoInvalidoExcepcion, YaMovioExcepcion, BatallonYaSeMovioExcepcion {

        if (seMovioConBatallon) {
            throw new BatallonYaSeMovioExcepcion();
        }

        boolean seHabiaMovido = false;
        if (movio) {
            seHabiaMovido = true;
            movio = false;
        }
        desplazarHaciaDerecha();
        if (!seHabiaMovido) {
            movio = false;
        }
        seMovioConBatallon = true;
    }


    @Override
    public void prepararTurno() {
        super.prepararTurno();
        seMovioConBatallon = false;
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

    public void moverBatallonParaArriba () throws YaMovioExcepcion, MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        batallon.desplazarBatallonHaciaArriba();
    }

    public void moverBatallonParaAbajo () throws YaMovioExcepcion, MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        batallon.desplazarBatallonHaciaAbajo();
    }

    public void moverBatallonParaIzquierda () throws YaMovioExcepcion, MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
        batallon.desplazarBatallonHaciaIzquierda();
    }

    public void moverBatallonParaDerecha () throws YaMovioExcepcion, MovimientoInvalidoExcepcion, BatallonYaSeMovioExcepcion, BatallonNoSePuedeMoverExcepcion {
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

    public boolean estaALaDerechaDe(Soldado unSoldado){
        return ubicacion.estaALaDerechaDe(unSoldado.ubicacion);
    }

    public boolean estaArribaDe(Soldado unSoldado) {
        return ubicacion.estaArribaDe(unSoldado.ubicacion);
    }
}
