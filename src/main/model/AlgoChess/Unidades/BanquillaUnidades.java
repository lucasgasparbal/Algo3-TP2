package model.AlgoChess.Unidades;

public class BanquillaUnidades {
    private int cantidadSoldados = 0;
    private int cantidadJinetes = 0;
    private int cantidadCuranderos = 0;
    private int cantidadCatapultas = 0;

    public boolean tieneSoldados(){
        return cantidadSoldados > 0;
    }

    public boolean tieneJinetes(){
        return cantidadJinetes > 0;
    }

    public boolean tieneCuranderos(){
        return cantidadCuranderos > 0;
    }

    public boolean tieneCatapultas(){
        return cantidadCatapultas > 0;
    }

    public void agregarSoldado(){
        cantidadSoldados++;
    }

    public void agregarJinete(){
        cantidadJinetes++;
    }

    public void agregarCurandero(){
        cantidadCuranderos++;
    }

    public void agregarCatapulta(){
        cantidadCatapultas++;
    }
}
