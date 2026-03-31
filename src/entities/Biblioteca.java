package entities;

import java.time.LocalDate;

import estructuras.ListaEnlazada;
import estructuras.Nodo;
import estructuras.Pila;

public class Biblioteca {

    private int contadorLibro;
    private int contadorUsuario;
    // Definir atributos privados

    private ListaEnlazada<Libro> catalogo;
    private ListaEnlazada<Usuario> usuarios;
    private Pila<Libro> historialNuevos; // Para visualizar los ultimos libros agregados
    private ListaEnlazada<Prestamo> historialPrestamo;

    public Biblioteca() {
        // Este es el constructor, donde definimos los datos que son necesarios.
        this.catalogo = new ListaEnlazada<>();
        this.usuarios = new ListaEnlazada<>();
        this.historialNuevos = new Pila<>();
        this.contadorLibro = 0;
        this.contadorUsuario = 0;
        this.historialPrestamo = new ListaEnlazada<>();
    }

    public int generarIdUsuario() {
        return ++contadorLibro;
    }

    public int generarIdLibro() {
        return ++contadorUsuario;
    }

    // Creación de metodos para Gestion de Libro
    public void agregarLibro(Libro libro) {
        // int id_libro = generar_nuevo_id();
        // libro.getId(id_libro);
        catalogo.agregarElemento(libro);
        historialNuevos.apilar(libro);
        System.out.println("Libro creado correctamente");

    }

    public void verCatalogo() {
        catalogo.imprimirElementos();
    }

    // Actualizar datos de un libro
    public void actualizarLibro() {

    }

    public Libro buscarLibroPorId(int id) {
        Nodo<Libro> actual = catalogo.getCabeza();

        while (actual != null) {
            Libro libro = actual.getDato();

            if (libro.getId() == id) {
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

            if (usuario.getId() == id) {
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

    // Metodo para prestar libro y usar la cola para agregar
    public void prestarLibro(int id_usuario, int id_libro) {
        Libro libro = buscarLibroPorId(id_libro);
        Usuario usuario = buscarUsuarioPorId(id_usuario);

        if (usuario == null) {
            System.out.println("Error, El usuario con ID " + id_usuario + " no existe.");
            return;
        }
        if (libro == null) {
            System.out.println("Error, El libro con ID " + id_libro + " no existe.");
            return;
        }

        if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
            libro.setEstado(EstadoLibro.PRESTADO);
            libro.setPossedor_id(id_usuario);

            // Agregar al historial de prestamo, para poder visualizar y usar la clase
            // prestamo
            String idPrestamo = "P-" + (historialPrestamo.getTamano() + 1);

            Prestamo nuevPrestamo = new Prestamo(idPrestamo, libro.getId(), usuario.getId(), LocalDate.now());
            historialPrestamo.agregarElemento(nuevPrestamo);
            System.out.println("Libro prestado con éxito al Usuario: " + usuario.getName());
        } else {
            System.out.println("El libro está ocupado. Agregando a " + usuario.getName()
                    + " a la lista de espera del libro " + libro.getName());
            libro.getListaEspera().encolar(usuario);
        }

    }

    // Metodo para devolver el libro prestado
    public void devolverLibro(int id_libro, int id_usuario) {
        Libro libro = buscarLibroPorId(id_libro);

        if (libro != null && libro.getEstado() == EstadoLibro.PRESTADO) {
            // Revisamos si hay alguien esperando ESTE libro
            Usuario siguienteUsuario = libro.getListaEspera().desencolar();

            if (siguienteUsuario != null) {
                System.out.println("El libro devuelto ha sido asignado automáticamente a " + siguienteUsuario.getName()
                        + " que estaba en la lista de espera.");
                libro.setPossedor_id(siguienteUsuario.getId());
                // El estado sigue siendo PRESTADO
            } else {
                libro.setEstado(EstadoLibro.DISPONIBLE);
                libro.setPossedor_id(0);
                System.out.println("Libro devuelto con éxito. Ahora está disponible.");
            }
        } else {
            System.out.println("El libro no estaba prestado o no existe.");
        }
    }

    public void verListaEspera() {
        Nodo<Libro> actual = catalogo.getCabeza();
        boolean hayEspera = false;

        while (actual != null) {
            Libro libro = actual.getDato();
            if (libro.getListaEspera().verPrimero() != null) {
                System.out.println("\n--- Esperando por el libro: " + libro.getName() + " ---");
                libro.getListaEspera().imprimirCola();
                hayEspera = true;
            }
            actual = actual.getSiguiente();
        }

        if (!hayEspera) {
            System.out.println("No hay usuarios en lista de espera para ningún libro.");
        }
    }

    public void mostrarUltimaAccion() {
        Libro ultimo = historialNuevos.verUltimo();
        if (ultimo != null) {
            System.out.println(ultimo.toString());
        }
    }
}
