package model.AlgoChess.Unidad;

public class Catapulta extends Unidad {

    AtaqueEnArea ataque = new AtaqueEnArea (20);

    public Catapulta (int x, int y) {
        // Ubicacion en si tiene que estar en Unidad //
        vida = new Vida (50);
    }

    public void atacar (Unidad objetivo) {
        ataque.atacar(objetivo);
    }
}
