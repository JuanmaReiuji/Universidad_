package co.edu.uniquindio.poo;

import java.util.*;

public class Nota {
    private String nombre;
    private float valor;

    // Constructor
    public Nota(String nombre, float valor) {
        this.nombre = nombre;
        setValor(valor); // Usamos el setter para aplicar validaciones
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }

    // Setters con validaciones
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(float valor) {
        if (valor < 0 || valor > 5) { // Ajusta el rango según necesites
            throw new IllegalArgumentException("El valor de la nota debe estar entre 0 y 5.");
        }
        this.valor = valor;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Nota{" +
                "nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }


    public String actualizarNota(float nuevoValorNota){
        setValor(nuevoValorNota);
        return "Nota actualizada";
    }


}