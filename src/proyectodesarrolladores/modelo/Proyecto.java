package proyectodesarrolladores.modelo;

import java.util.ArrayList;

public class Proyecto {
    // Atributos
    private String nombre;
    private ArrayList<Desarrollador> desarrolladores;

    // Constructor
    public Proyecto(String nombre) {
        this.nombre = nombre;
        desarrolladores = new ArrayList<>();
    }

    // Agregar desarrollador
    public void agregarDesarrollador(Desarrollador desarrollador) {
        desarrolladores.add(desarrollador);
    }

    // Buscar desarrollador por identificacion
    public Desarrollador buscarDesarrollador(String identificacion) {

        for (Desarrollador desarrollador : desarrolladores) {

            if (desarrollador.getIdentificacion().equals(identificacion)) {
                return desarrollador;
            }
        }

        return null;
    }

    // Eliminar desarrollador
    public boolean eliminarDesarrollador(String identificacion) {

        Desarrollador encontrado = buscarDesarrollador(identificacion);

        if (encontrado != null) {
            desarrolladores.remove(encontrado);
            return true;
        }

        return false;
    }

    // Calcular total de horas
    public double calcularTotalHoras() {

        double total = 0;

        for (Desarrollador desarrollador : desarrolladores) {
            total += desarrollador.getHorasAsignadas();
        }

        return total;
    }

    // Mostrar equipo
    public String mostrarEquipo() {

        String resultado = "Proyecto: " + nombre + "\n";

        for (Desarrollador desarrollador : desarrolladores) {
            resultado += "\n" + desarrollador.mostrarInformacion() + "\n";
        }

        return resultado;
    }

    // Desafio adicional: desarrollador con mayor carga
    public Desarrollador obtenerMayorCarga() {

        Desarrollador mayor = null;

        for (Desarrollador desarrollador : desarrolladores) {

            if (mayor == null
                    || desarrollador.getHorasAsignadas() > mayor.getHorasAsignadas()) {

                mayor = desarrollador;
            }
        }

        return mayor;
    }
}
