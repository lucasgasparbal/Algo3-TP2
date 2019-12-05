package model.AlgoChess.Unidades;

public class PaqueteCoordenadasBatallon {
    private int[] coordenadasPrimerSoldado;
    private int[] coordenadasSegundoSoldado;
    private int[] coordenadasTercerSoldado;
    public PaqueteCoordenadasBatallon(int[] coordenadasUno, int[] coordenadasDos, int[] coordenadasTres){
        coordenadasPrimerSoldado = coordenadasUno;
        coordenadasSegundoSoldado = coordenadasDos;
        coordenadasTercerSoldado = coordenadasTres;
    }

    public int[] obtenerCoordenadasPrimerSoldado(){
        return coordenadasPrimerSoldado;
    }

    public int[] obtenerCoordenadasSegundoSoldado(){
        return coordenadasSegundoSoldado;
    }

    public int[] obtenerCoordenadasTercerSoldado(){
        return coordenadasTercerSoldado;
    }
}
