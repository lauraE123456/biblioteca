package entities;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // definir atributos privados

    private String id_usuario;
    private String name;
    private String email;
    private List<Libro> libros_prestados = new ArrayList<Libro>();

    public Usuario(String id_usuario, String name, String email) {
        this.id_usuario=id_usuario;
        this.name=name;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", name=" + name + ", email=" + email + ", libros_prestados="
                + libros_prestados + "]";
    }

}
