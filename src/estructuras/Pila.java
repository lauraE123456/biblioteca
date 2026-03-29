package estructuras;

import java.util.Stack;

public class Pila<T> {

    // Crear atributo privado
    // Usamos el estandar de clase T para poder de forma universal
    private Stack<T> historial = new Stack<>();

    // Nuevo metodo para agregar un libro al historial
    public void apilar(T elemento) {
        historial.push(elemento);

    }

    // Metodo para borra el historial
    public T desapilar() {
        if (historial.isEmpty()) {
            return null;
        }
        return historial.pop();
    }

    // Metodo para visualizar el ultimo sin quitarlo
    public T verUltimo() {
        // usamos operador ternario en lugar de usar if
        return historial.isEmpty() ? null : historial.peek();
    }

}
