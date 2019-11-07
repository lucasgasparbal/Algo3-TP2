package model;

public class Jinete extends UnidadMovible {

    AtaqueCuerpoACuerpo ataque1 = new AtaqueCuerpoACuerpo(5);
    AtaqueADistancia ataque2 = new AtaqueADistancia(15);

    public Jinete(int x, int y) {
        super(x, y);
        vida = new Vida (100);
    }

    public void atacar (Unidad objetivo) {
        // aca falta la logica que le hace atacar de una u otra forma //
        ataque1.atacar(objetivo);

    }
}
