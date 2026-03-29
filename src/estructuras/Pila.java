package estructuras;

import java.util.Stack;

import entities.Libro;

public class Pila<T> {

    // Crear atributo privado
    private Stack<Libro> historial = new Stack<>();

    // Nuevo metodo para agregar un libro al historial
    public void apilar(Libro l) {
        historial.add(l);

    }

    // Metodo para borra el historial
    public Libro desapilar() {
        return historial.pop();
    }

}
