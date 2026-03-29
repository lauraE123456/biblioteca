package estructuras;

public class Nodo<T> {

    // Generar los atributos privados
    private T dato;
    private Nodo<T> siguiente;

    // Generar constructor
    public Nodo() {
        setSiguiente(null);
        setDato(null);
    }

    public Nodo(T l) {
        setSiguiente(null);
        setDato(l);
    }

    public Nodo(T l, Nodo<T> n) {
        setSiguiente(n);
        setDato(l);
    }

    // Generación de getters y setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

}
