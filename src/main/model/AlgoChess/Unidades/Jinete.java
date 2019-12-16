package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.ObjetivoFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.ObjetivoNoEsEnemigoExcepcion;
import model.AlgoChess.Excepciones.YaAtacoExcepcion;
import model.AlgoChess.Unidades.Ataques.*;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public class Jinete extends UnidadMovible {

    private final static int Costo = 3;
    private final int VidaJinete = 100;
    private final int DanioCuerpoACuerpo = 5;
    private final int DanioAtaqueDistancia = 15;

    private AtaqueCuerpoACuerpo ataqueEspada = new AtaqueCuerpoACuerpo(DanioCuerpoACuerpo);
    private AtaqueADistancia ataqueArco = new AtaqueADistancia(DanioAtaqueDistancia);

    public Jinete(Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaJinete);
        costo = Costo;
    }

    public void atacar (Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, ObjetivoFueraDeRangoExcepcion, YaAtacoExcepcion {
        if(ataco){
            throw new YaAtacoExcepcion();
        }
        if(!objetivo.esEnemigoDe(this)){
            throw new ObjetivoNoEsEnemigoExcepcion();
        }
        if (!tablero.unidadTieneEnemigosCercanos(this) ||  tablero.unidadTieneAliadosCercanos(this)) {
            ataqueArco.atacar(objetivo,this);
        }
        else ataqueEspada.atacar(objetivo,this);

        ataco = true;
    }
}
