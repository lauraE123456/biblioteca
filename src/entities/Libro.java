package entities;

public class Libro {

    private int isbn;
    private String titulo;
    private String autor;
    private EstadoLibro estado;
    private String possedor_id;

    // Constructor para la clase libro
    public Libro(int isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = EstadoLibro.DISPONIBLE;
        this.possedor_id = null;
    }

    public String getName() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", estado=" + estado
                + ", possedor_id=" + possedor_id + "]";
    }

    // generador de getter y setter-> asegurar la integridad de los datos
    // Getters: Permiten "leer" el valor de un atributo privado desde fuera de la
    // clase
    public EstadoLibro getEstado() {
        return estado;
    }

    // Setters (Modificación): Permiten "escribir"
    // o cambiar el valor, pero con la oportunidad de validar los datos antes de
    // guardarlos.
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public String getPossedor_id() {
        return possedor_id;
    }

    public void setPossedor_id(String possedor_id) {
        this.possedor_id = possedor_id;
    }

    public void setId(int id_libro) {
        this.isbn = id_libro;
    }

    public int getId() {
        return isbn;
    }

}
