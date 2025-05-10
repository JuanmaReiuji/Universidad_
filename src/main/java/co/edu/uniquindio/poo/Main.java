package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Universidad
        Universidad universidad = new Universidad("Universidad del Quindío", "Armenia");

        // Registrar estudiantes
        System.out.println(universidad.registrarEstudiante("Carlos Pérez", "12345"));
        System.out.println(universidad.registrarEstudiante("Ana López", "67890"));
        System.out.println(universidad.registrarEstudiante("Carlos Pérez", "12345")); // Intentar registrar un estudiante duplicado

        // Agregar notas a los estudiantes
        Estudiante estudiante1 = universidad.getListaEstudiantes().get(0);
        Estudiante estudiante2 = universidad.getListaEstudiantes().get(1);

        System.out.println(universidad.agregarNota(estudiante1.getIdentificacion(), "Matemáticas", 4.5f));
        System.out.println(universidad.agregarNota(estudiante1.getIdentificacion(), "Física", 3.8f));
        System.out.println(universidad.agregarNota(estudiante2.getIdentificacion(), "Matemáticas", 4.9f));
        System.out.println(universidad.agregarNota(estudiante2.getIdentificacion(), "Física", 4.0f));

        // Intentar agregar más de 5 notas
        System.out.println(universidad.agregarNota(estudiante1.getIdentificacion(), "Química", 3.5f));
        System.out.println(universidad.agregarNota(estudiante1.getIdentificacion(), "Biología", 4.0f));
        System.out.println(universidad.agregarNota(estudiante1.getIdentificacion(), "Inglés", 3.2f));
        System.out.println(universidad.agregarNota(estudiante1.getIdentificacion(), "Historia", 4.1f)); // Superando el límite de 5 notas

        // Actualizar una nota
        System.out.println(universidad.actualizarNota(estudiante1.getIdentificacion(), "Matemáticas", 5.0f));

        // Intentar actualizar una nota inexistente
        System.out.println(universidad.actualizarNota(estudiante1.getIdentificacion(), "Química", 4.7f)); // Nota no existe

        // Calcular promedio general de la universidad
        System.out.println("Promedio general de la universidad: " + universidad.calcularPromedioGeneral());

        // Mostrar todos los estudiantes y sus notas
        for (Estudiante estudiante : universidad.getListaEstudiantes()) {
            System.out.println(estudiante);
        }
    }
}
