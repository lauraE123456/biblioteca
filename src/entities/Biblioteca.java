package entities;

import estructuras.Cola;
import estructuras.ListaEnlazada;
import estructuras.Nodo;
import estructuras.Pila;

public class Biblioteca {

    private int contadorLibros;
    // Definir atributos privados

    private ListaEnlazada<Libro> catalogo;
    private ListaEnlazada<Usuario> usuarios;
    private Pila<Libro> historialNuevos; // Para visualizar los ultimos libros agregados
    private Cola<Usuario> listaEspera; // Para turnos es espera

    public Biblioteca() {
        // Este es el constructor, donde definimos los datos que son necesarios.
        this.catalogo = new ListaEnlazada<>();
        this.usuarios = new ListaEnlazada<>();
        this.historialNuevos = new Pila<>();
        this.listaEspera = new Cola<>();
        this.contadorLibros = 0;
    }

    public int generar_nuevo_id() {
        contadorLibros++;
        return contadorLibros;
    }

    // Creación de metodos para Gestion de Libro
    public void agregarLibro(Libro libro) {
        // int id_libro = generar_nuevo_id();
        // libro.getId(id_libro);
        catalogo.agregarElemento(libro);
        historialNuevos.apilar(libro);
        System.out.println("Libro creado correctamente");

    }

    public void verCatalogo(Usuario usuario) {
        catalogo.imprimirElementos();
        listaEspera.encolar(usuario);
    }

    // Actualizar datos de un libro
    public void actualizarLibro() {

    }

    public Libro buscarLibroPorId(int id) {
        Nodo<Libro> actual = catalogo.getCabeza();

        while (actual != null) {
            Libro libro = actual.getDato();

            if (libro.getId(id) == id) {
                return libro;
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    // Metodo para borrar
    public void borrarLibro(int id_dato) {
        Libro libroAEliminar = buscarLibroPorId(id_dato);
        if (libroAEliminar != null) {
            catalogo.eliminarElemento(libroAEliminar);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    // Metodo para ver usuarios
    public void verUsuarios() {
        usuarios.imprimirElementos();
    }

    // Creación de metodo para Gestion de Usuarios
    public void agregarUsuarios(Usuario usuario) {
        usuarios.agregarElemento(usuario);
        System.out.println("Usuario creado correctamente");
    }

    // Metodo para buscar usuario por id
    public Usuario buscarUsuarioPorId(int id) {
        Nodo<Usuario> actual = usuarios.getCabeza();

        while (actual != null) {
            Usuario usuario = actual.getDato();

            if (usuario.getId(id) == id) {
                return usuario;
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    // Metodo para eliminar el usuario
    public void borrarUsuario(int id_dato) {
        Usuario usuarioAEliminar = buscarUsuarioPorId(id_dato);
        if (usuarioAEliminar != null) {
            usuarios.eliminarElemento(usuarioAEliminar);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

}
