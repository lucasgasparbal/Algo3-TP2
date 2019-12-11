package vista;

public class DirectorioRecursos {

    public String obtenerRecurso(String recurso){
        return getClass().getResource("/"+recurso).toString();
    }
}
