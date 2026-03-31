package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // definir atributos privados

    private int id_usuario;
    private String name;
    private String email;
    private int telefono;
    private List<Libro> libros_prestados = new ArrayList<Libro>();

    public Usuario(int id_usuario, String name, String email, int telefono) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.email = email;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    // Obtener los libros prestado
    public List<Libro> getLibrosPrestados() {
        return libros_prestados;
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", name=" + name + ", email=" + email + ", libros_prestados="
                + libros_prestados + "Telefono=" + telefono + "]";
    }

    public int getId() {
        return id_usuario;
    }

}
