package estructuras;

import java.util.LinkedList;
import java.util.Queue;

public class Cola<T> {
    private Queue<T> fila = new LinkedList<>();

    /*
     * Usamos el FIFO, para esta cola, ya que la primera persona
     * en llegar en hacer una fila, tendra que ser la primera en salir
     */

    // Metodo para agregar a la fila a la persona que quiere el libro
    public void encolar(T elemento) {
        fila.add(elemento);
    }

    // Metodo para atender primero a la persona que ingreso por el libro
    public T desencolar(T elemento) {
        if (fila.isEmpty()) {
            return null;
        }
        // extrae y elimina el primer elemento
        return fila.poll();
    }

    // Metodo para ver quien sigue en la fila sin sacarlo
    public T verPrimero() {
        return fila.peek();
    }

}
