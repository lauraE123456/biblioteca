import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Libro;
import entities.Prestamo;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Libro l = new Libro("Cincuenta sombras","Cincuenta sombras","Cincuenta sombras");
        System.out.println("Este es el libro en el stock"+ l.getName());

        Usuario users= new Usuario("hola","laura","");
        System.out.println("Este es el nuevo usuario:"+users.getName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse("27/06/2024", formatter);
        Prestamo p = new Prestamo("Hola","","",fecha);
        System.out.println("Este es el libro prestado"+ p.getName());
    }
}
