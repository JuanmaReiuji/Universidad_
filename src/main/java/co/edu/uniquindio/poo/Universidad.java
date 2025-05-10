package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Optional;

public class Universidad {
    private String nombre;
    private String ubicacion;
    private ArrayList<Estudiante> listaEstudiantes;

    public Universidad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    // Registrar estudiante
    public String registrarEstudiante(String nombre, String identificacion) {
        Optional<Estudiante> encontrado = buscarEstudiante(identificacion);
        if (encontrado.isPresent()) {
            return "El estudiante " + nombre + " ya existe en la universidad.";
        }

        Estudiante nuevoEstudiante = new Estudiante(nombre, identificacion);
        listaEstudiantes.add(nuevoEstudiante);
        return "El estudiante fue registrado exitosamente.";
    }

    // Buscar estudiante
    private Optional<Estudiante> buscarEstudiante(String identificacion) {
        return listaEstudiantes.stream()
                .filter(estudiante -> estudiante.getIdentificacion().equals(identificacion))
                .findFirst();
    }

    // Agregar nota
    public String agregarNota(String identificacion, String nombreNota, float valorNota) {
        Optional<Estudiante> estudianteEncontrado = buscarEstudiante(identificacion);
        if (estudianteEncontrado.isPresent()) {
            Estudiante estudiante = estudianteEncontrado.get();
            Nota nuevaNota = new Nota(nombreNota, valorNota);
            return estudiante.agregarNota(nuevaNota);
        }
        return "Estudiante con la identificación " + identificacion + " no existe.";
    }

    // Actualizar nota
    public String actualizarNota(String identificacion, String nombreNota, float nuevoValorNota) {
        Optional<Estudiante> estudianteEncontrado = buscarEstudiante(identificacion);
        if (estudianteEncontrado.isPresent()) {
            Estudiante estudiante = estudianteEncontrado.get();
            return estudiante.actualizarNota(nombreNota, nuevoValorNota);
        }
        return "Estudiante con la identificación " + identificacion + " no existe.";
    }

    // Calcular promedio general
    public float calcularPromedioGeneral() {
        if (listaEstudiantes.isEmpty()) {
            return 0;
        }

        float sumatoria = 0;
        for (Estudiante estudiante : listaEstudiantes) {
            sumatoria += estudiante.calcularPromedio();
        }
        return sumatoria / listaEstudiantes.size();
    }
}

