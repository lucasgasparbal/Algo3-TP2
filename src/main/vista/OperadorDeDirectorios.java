package vista;

import java.nio.file.Paths;

public class OperadorDeDirectorios {

    public String obtenerDirectorioRelativoDeRecurso(String archivoRecurso) {
        return this.getClass().getResource("/"+archivoRecurso).toString();
    }

}
