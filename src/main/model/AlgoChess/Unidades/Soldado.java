package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoSePudoAtacarExcepcion;
import model.AlgoChess.Unidades.Ataques.AtaqueCuerpoACuerpo;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Soldado extends UnidadMovible {

    private boolean tieneBatallon=false;

    private Batallon batallon ;

    private AtaqueCuerpoACuerpo ataque = new AtaqueCuerpoACuerpo(10);

    public boolean tieneBatallon () {
        return tieneBatallon;
    }

    public Soldado(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(100);
        costo = new Costo(1);
    }

    public void atacar(Unidad objetivo) throws NoSePudoAtacarExcepcion, CoordenadaFueraDeRangoExcepcion {
        ataque.atacar(objetivo,this);
    }

    public void asignarBatallon(Batallon batallonAsignado) {
        tieneBatallon = true;
        batallon = batallonAsignado;
    }
}
