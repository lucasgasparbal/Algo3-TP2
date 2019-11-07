package model;

public class Curandero extends UnidadMovible {

    private Curacion ataque = new Curacion(15);

    public void atacar(Unidad objetivo) {
        ataque.atacar(objetivo);
    }

    public Curandero(int x, int y) {
        super(x, y);
        vida = new Vida (75);
        costo = new Costo (2);
    }
}
