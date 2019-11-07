package model.AlgoChess.Tablero;

public class AnalizadorRangos {

    final private int RangoCercanoCotaMinima = 1;
    final private int RangoCercanoCotaMaxima = 2;

    final private int RangoMedianoCotaMinima = 3;
    final private int RangoMedianoCotaMaxima = 5;

    final private int RangoLejanoCotaMinima = 6;
    final private int RangoLejanoCotaMaxima = Integer.MAX_VALUE; //para representar infinito positivo

    private boolean numeroEnRango(int numero, int rangoCotaMinima, int rangoCotaMaxima){
        return (rangoCotaMinima <= numero) & (numero <= rangoCotaMaxima);
    }

    //pre: xUno, yUno, xDos yDos son numeros enteros pertenecientes a dos duplas que representan puntos en un plano
    //pos: devuelve true si, tomando un punto como centro de un cuadrado de 4x4, el otro punto esta ubicado en un cuadrado de 4x4 excluyendo su centro.
    //En otro caso devuelve false.
    public boolean coordenadasEstanEnRangoCercano(int xUno, int yUno, int xDos, int yDos){
        int restaAbsolutaCoordenadaX = Math.abs(xUno-xDos);
        int restaAbsoultaCoordeandaY = Math.abs(yUno-yDos);
        boolean coordenadaXEnRango = numeroEnRango(restaAbsolutaCoordenadaX, RangoCercanoCotaMinima, RangoCercanoCotaMaxima);
        boolean coordenadaYEnRango = numeroEnRango(restaAbsoultaCoordeandaY, RangoCercanoCotaMinima, RangoCercanoCotaMaxima);
        return (coordenadaXEnRango  | coordenadaYEnRango);
    }

    //pre: xUno, yUno, xDos yDos son numeros enteros pertenecientes a dos duplas que representan puntos en un plano
    //pos: devuelve true si, tomando un punto como centro de un cuadrado de 10x10, el otro punto esta ubicado en este cuadrado pero
    //no esta ubicado en un cuadrado de 4x4 desde el centro. En otro caso devuelve false.
    public boolean coordenadasEstanEnRangoMediano(int xUno, int yUno, int xDos, int yDos){
        int restaAbsolutaCoordenadaX = Math.abs(xUno-xDos);
        int restaAbsoultaCoordeandaY = Math.abs(yUno-yDos);
        boolean coordenadaXEnRango = numeroEnRango(restaAbsolutaCoordenadaX, RangoMedianoCotaMinima, RangoMedianoCotaMaxima);
        boolean coordenadaYEnRango = numeroEnRango(restaAbsoultaCoordeandaY, RangoMedianoCotaMinima, RangoMedianoCotaMaxima);
        return (coordenadaXEnRango  | coordenadaYEnRango);
    }

    //pre: xUno, yUno, xDos yDos son numeros enteros pertenecientes a dos duplas que representan puntos en un plano
    //pos: devuelve true si un punto NO esta ubicado en un cuadrado de 10x10 tomando al otro como centro. En otro caso devuelve false.
    public boolean coordenadasEstanEnRangoLejano(int xUno, int yUno, int xDos, int yDos){
        int restaAbsolutaCoordenadaX = Math.abs(xUno-xDos);
        int restaAbsoultaCoordeandaY = Math.abs(yUno-yDos);
        boolean coordenadaXEnRango = numeroEnRango(restaAbsolutaCoordenadaX, RangoLejanoCotaMinima, RangoLejanoCotaMaxima);
        boolean coordenadaYEnRango = numeroEnRango(restaAbsoultaCoordeandaY, RangoLejanoCotaMinima, RangoLejanoCotaMaxima);
        return (coordenadaXEnRango  | coordenadaYEnRango);
    }
}
