package model;

public class Soldado extends UnidadMovible {

    AtaqueCuerpoACuerpo ataque = new AtaqueCuerpoACuerpo(10);

    public Soldado(int x, int y) {
        super(x, y);
        vida = new Vida (100);
    }

    public void atacar(Unidad objetivo) {
        ataque.atacar(objetivo);
    }
}
