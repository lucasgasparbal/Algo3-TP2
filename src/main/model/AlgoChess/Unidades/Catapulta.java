package model;

public class Catapulta extends Unidad {

    private AtaqueEnArea ataque = new AtaqueEnArea (20);

    public Catapulta (int x, int y) {
        // Ubicacion en si tiene que estar en Unidad //
        vida = new Vida (50);
        costo = new Costo (5);
    }

    public void atacar (Unidad objetivo) {
        ataque.atacar(objetivo);
    }
}
