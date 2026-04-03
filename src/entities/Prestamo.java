package entities;

import java.time.LocalDate;

public class Prestamo {

    // Definir los atributos privados
    private String idPrestamo;
    private int isbn;
    private int idUsuario;
    private LocalDate fecha;

    // Generar el constructor de la clase Prestamo
    public Prestamo(String id_prestamo, int isbn, int id_usuario, LocalDate fecha) {
        this.idPrestamo = id_prestamo;
        this.isbn = isbn;
        this.idUsuario = id_usuario;
        this.fecha = fecha;
    }

    public String getName() {
        return idPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo [id_prestamo=" + idPrestamo + ", isbn=" + isbn + ", id_usuario=" + idUsuario + ", fecha="
                + fecha + "]";
    }

}
