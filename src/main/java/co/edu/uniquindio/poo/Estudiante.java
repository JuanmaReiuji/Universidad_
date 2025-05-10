package co.edu.uniquindio.poo;

import java.util.*;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private List<Nota> notas;

    public Estudiante (String nombre,String identificacion){
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", listado de Notas=" + notas +
                '}';
    }


    private Optional<Nota> buscarNota(String nombreNota){
        return notas.stream().filter(n -> n.getNombre().equals(nombreNota)).findFirst();
    }

    public String agregarNota(Nota nuevaNota){
        Optional<Nota> buscando = buscarNota(nuevaNota.getNombre());
        if(buscando.isPresent()){
            return "La nota ya existe";
        } if(notas.size() >= 5){
            return "No se puede agregar la nota, maximo de notas ya alcanzado (5)";
        } else {
            notas.add(nuevaNota);
            return "Nota agregada";
        }
    }


    public String actualizarNota(String nombreNota, float nuevoValorNota){
        Optional<Nota> buscando = buscarNota(nombreNota);
        if(buscando.isPresent()){
            Nota notaEncontrada = buscando.get();
            notaEncontrada.setValor(nuevoValorNota);
            return "Nota actualizada";
        } else {
            return "La nota no existe";
        }
    }

    public float calcularPromedio() {
        float suma = 0;
        for (Nota nota : notas) {
            if (nota != null) {
                suma += nota.getValor();
            }
        }
        return suma / notas.size();
    }
}