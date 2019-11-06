package mocks;

import model.Casillero;

public class CasilleroMock implements Casillero {

    private boolean libre = true;

    @Override
    public boolean estaLibre() {
        return libre;
    }

    @Override
    public void ocuparCasillero() {
        libre = false;
    }
}
