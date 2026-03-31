package entities;

import java.time.LocalDate;

public class Prestamo {

    // Definir los atributos privados
    private String id_prestamo;
    private int isbn;
    private int id_usuario;
    private LocalDate fecha;

    // Generar el constructor de la clase Prestamo
    public Prestamo(String id_prestamo, int isbn, int id_usuario, LocalDate fecha) {
        this.id_prestamo = id_prestamo;
        this.isbn = isbn;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
    }

    public String getName() {
        return id_prestamo;
    }

    @Override
    public String toString() {
        return "Prestamo [id_prestamo=" + id_prestamo + ", isbn=" + isbn + ", id_usuario=" + id_usuario + ", fecha="
                + fecha + "]";
    }

}
