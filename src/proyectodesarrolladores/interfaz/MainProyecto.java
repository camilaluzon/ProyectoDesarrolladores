package proyectodesarrolladores.interfaz;

import proyectodesarrolladores.modelo.Desarrollador;
import proyectodesarrolladores.modelo.Proyecto;
import proyectodesarrolladores.utilitario.Validar;

public class MainProyecto {
    static void main() {
        // Crear desarrolladores antes del proyecto
        Desarrollador[] desarrolladores = new Desarrollador[3];

        for (int i = 0; i < desarrolladores.length; i++) {

            System.out.println("\n--- INGRESO DEL DESARROLLADOR " + (i + 1) + " ---");

            String identificacion = Validar.leerString("Ingrese la identificacion");

            String nombre = Validar.leerString("Ingrese el nombre");

            String especialidad = Validar.leerString("Ingrese la especialidad");

            double horas = Validar.leerDoublePositivo("Ingrese las horas asignadas");

            desarrolladores[i] = new Desarrollador(
                    identificacion, nombre, especialidad, horas
            );
        }

        // Crear proyecto
        Proyecto proyecto = new Proyecto(
                Validar.leerString("\nIngrese el nombre del proyecto")
        );

        // Comprobar proyecto vacio
        System.out.println("\n--- PROYECTO INICIALMENTE VACIO ---");
        System.out.println(proyecto.mostrarEquipo());

        // Agregar desarrolladores existentes
        for (int i = 0; i < desarrolladores.length; i++) {
            proyecto.agregarDesarrollador(desarrolladores[i]);
        }

        // Mostrar equipo
        System.out.println("\n--- EQUIPO DEL PROYECTO ---");
        System.out.println(proyecto.mostrarEquipo());

        // Buscar desarrollador existente
        System.out.println("\n--- BUSCAR DESARROLLADOR ---");

        String identificacion = Validar.leerString(
                "Ingrese la identificacion que desea buscar"
        );

        Desarrollador encontrado = proyecto.buscarDesarrollador(identificacion);

        if (encontrado != null) {
            System.out.println(encontrado.mostrarInformacion());
        } else {
            System.out.println("Desarrollador no encontrado");
        }

        // Buscar desarrollador inexistente
        System.out.println("\n--- BUSQUEDA INEXISTENTE ---");

        Desarrollador inexistente = proyecto.buscarDesarrollador("D999");

        if (inexistente == null) {
            System.out.println("La busqueda retorno null correctamente");
        }

        // Calcular horas totales
        System.out.println("\nTotal de horas asignadas: "
                + proyecto.calcularTotalHoras());

        // Eliminar desarrollador
        System.out.println("\n--- ELIMINAR DESARROLLADOR ---");

        String idEliminar = Validar.leerString(
                "Ingrese la identificacion que desea eliminar"
        );

        boolean eliminado = proyecto.eliminarDesarrollador(idEliminar);

        if (eliminado) {
            System.out.println("Desarrollador eliminado correctamente");
        } else {
            System.out.println("No se encontro el desarrollador");
        }

        // Mostrar equipo actualizado
        System.out.println("\n--- EQUIPO ACTUALIZADO ---");
        System.out.println(proyecto.mostrarEquipo());

        // Desafio adicional
        System.out.println("\n--- DESARROLLADOR CON MAYOR CARGA ---");

        Desarrollador mayor = proyecto.obtenerMayorCarga();

        if (mayor != null) {
            System.out.println(mayor.mostrarInformacion());
        }
    }
}
