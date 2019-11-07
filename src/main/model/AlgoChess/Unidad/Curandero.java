package model.AlgoChess.Unidad;

public class Curandero extends UnidadMovible {

    Curacion ataque = new Curacion(15);

    public void curar(Unidad objetivo) {
        ataque.atacar(objetivo);
    }

    public Curandero(int x, int y) {
        super(x, y);
        vida = new Vida (75);
    }
}
