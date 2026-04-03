package estructuras;

import java.util.Stack;

public class Pila<T> {

    // Crear atributo privado
    // Usamos el estandar de clase T para poder usar de forma universal
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
        if (historial.isEmpty()) {
            System.out.println("No hay acciones registradas ");
            return null;
        }
        System.out.println("Estas son las ultimas acciones: ");
        return historial.peek();
    }
}
