package entities;

import estructuras.Cola;

public class Libro {

    private int isbn;
    private String tituloLibro;
    private String autorLibro;
    private EstadoLibro estadoLibro;
    private int possedorId;
    private Cola<Usuario> listaEspera;

    // Constructor para la clase libro
    public Libro(int isbn, String tituloLibro, String autorLibro) {
        this.isbn = isbn;
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.estadoLibro = EstadoLibro.DISPONIBLE;
        this.possedorId = 0;
        this.listaEspera = new Cola<>();
    }

    public Cola<Usuario> getListaEspera() {
        return listaEspera;
    }

    public String getName() {
        return tituloLibro;
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titulo=" + tituloLibro + ", autor=" + autorLibro + ", estado=" + estadoLibro
                + ", possedor_id=" + possedorId + "";
    }

    // generador de getter y setter-> asegurar la integridad de los datos
    // Getters: Permiten "leer" el valor de un atributo privado desde fuera de la
    // clase
    public EstadoLibro getEstado() {
        return estadoLibro;
    }

    // Setters (Modificación): Permiten "escribir"
    // o cambiar el valor, pero con la oportunidad de validar los datos antes de
    // guardarlos.
    public void setEstado(EstadoLibro estado) {
        this.estadoLibro = estado;
    }

    public int getPossedor_id() {
        return possedorId;
    }

    public void setPossedor_id(int possedorId) {
        this.possedorId = possedorId;
    }

    public void setId(int id_libro) {
        this.isbn = id_libro;
    }

    public int getId() {
        return isbn;
    }

}
