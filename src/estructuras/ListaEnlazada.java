package estructuras;

public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    // private List<archivo_csv> archivo_csv="data/libros.csv"

    // Generar el constructor
    public ListaEnlazada() {
        this.cabeza = null;
    }

    // Metodo para visualizar los libros
    public void imprimirElementos() {
        if (cabeza == null) {
            System.out.println("El catalogo esta vacio");
            return;
        }
        Nodo<T> actual = cabeza;
        System.out.println("---Libros en el Catalogo---");
        while (actual != null) {

            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    // Metodo para agregar
    public void agregarElemento(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }

    }

    // Metodo para eliminar
    public void eliminarElemento(T id_dato) {

        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return;
        }
        if (cabeza.getDato() == id_dato) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Dato Eliminado");
            return;
        }
        Nodo<T> actual = cabeza.getSiguiente();
        Nodo<T> anterior = cabeza;

        while (actual != null) {
            if (actual.getDato() == id_dato) {
                anterior.setSiguiente(actual.getSiguiente());
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();

        }

    }

    // Obtener cabeza (para recorrer fuera de esta clase)
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public int getTamano() {
        int count = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.getSiguiente();
        }
        return count;
    }

}
