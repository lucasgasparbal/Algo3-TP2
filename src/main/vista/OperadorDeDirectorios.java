package vista;

public class OperadorDeDirectorios {

    public String obtenerDirectorioRelativoDeRecurso(String archivoRecurso){
       return this.getClass().getResource("/"+archivoRecurso).toString();
    }
}
