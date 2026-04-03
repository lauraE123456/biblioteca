package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // definir atributos privados

    private int idUsuario;
    private String nombreUsuario;
    private String correoElectronico;
    private String numeroTelefono;
    private List<Libro> librosPrestados = new ArrayList<Libro>();

    public Usuario(int idUsuario, String nombreUsuario, String correoElectronico, String numeroTelefono) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    public String getName() {
        return nombreUsuario;
    }

    // Obtener los libros prestado
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + idUsuario + ", name=" + nombreUsuario + ", email=" + correoElectronico + ", libros_prestados="
                + librosPrestados + "Telefono=" + numeroTelefono + "]";
    }

    public int getId() {
        return idUsuario;
    }

}
