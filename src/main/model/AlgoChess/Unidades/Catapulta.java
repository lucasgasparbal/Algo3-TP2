package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.*;
import model.AlgoChess.Unidades.Ataques.AtaqueEnArea;
import model.AlgoChess.Unidades.AtributosDeUnidades.Vida;

public class Catapulta extends Unidad {

    private final static int Costo = 5;

    private final int VidaCatapulta = 50;

    private AtaqueEnArea ataque = new AtaqueEnArea(20);

    public Catapulta (Equipo unEquipo) {
        super(unEquipo);
        vida = new Vida(VidaCatapulta);
        costo = Costo;
    }

    public void atacar (Unidad objetivo) throws CoordenadaFueraDeRangoExcepcion, ObjetivoFueraDeRangoExcepcion, ObjetivoNoEsEnemigoExcepcion, YaAtacoExcepcion {
       if(ataco){
           throw new YaAtacoExcepcion();
       }
        if(!objetivo.esEnemigoDe(this)){
            throw new ObjetivoNoEsEnemigoExcepcion();
        }
        ataque.atacar(objetivo,this);
        ataco = true;
    }
    @Override
    public void recibirCuracion(int curacion) throws NoSePudoCurarExcepcion {
        throw new NoSePudoCurarExcepcion();
    }

    @Override
    public void desplazarHaciaAbajo() throws CatapultaNoSePuedeMoverExcepcion {
        throw new CatapultaNoSePuedeMoverExcepcion();
    }

    @Override
    public void desplazarHaciaArriba() throws CatapultaNoSePuedeMoverExcepcion {
        throw new CatapultaNoSePuedeMoverExcepcion();
    }

    @Override
    public void desplazarHaciaDerecha() throws CatapultaNoSePuedeMoverExcepcion {
        throw new CatapultaNoSePuedeMoverExcepcion();
    }

    @Override
    public void desplazarHaciaIzquierda() throws  CatapultaNoSePuedeMoverExcepcion {
        throw new CatapultaNoSePuedeMoverExcepcion();
    }
}
