import java.util.Scanner;

import entities.Biblioteca;
import entities.Libro;

public class App {
    public static void main(String[] args) throws Exception {

        // Dar la bienvenida al sistema.
        System.out.println(
                "-----Bienvenido al sistema de gestión de biblioteca----- \n ¿Qué desea hacer hoy? \n 1. Gestion Libros \n 2. Gestión Usuarios \n 3. Gestion Historial Prestamo");

        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, dijita un numero según las opciones:");

        int opcion = sc.nextInt();
        // while para poder eleguir la opción segun lo que dijite el usuario
        Biblioteca b = new Biblioteca();
        while (opcion == 1) {
            System.out.println(
                    "----Gestion de Libros: \n 1. Ver Catalogo \n 2. Agregar Libro \n 3. Borrar Libro.");
            int opcionLibros = sc.nextInt();
            switch (opcionLibros) {
                case 1:
                    b.verCatalogo(null);
                    break;
                case 2:

                    System.out.println("Por favor, ingresa los siguientes datos:");
                    // Pedir los datos que tiene la clase Libro
                    int id_libro = b.generar_nuevo_id();

                    System.out.println("Titulo del libro:");
                    String titulo = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Autor del libro:");
                    String autor = sc.nextLine();
                    sc.nextLine();

                    Libro l = new Libro(id_libro, titulo, autor);
                    l.setId(id_libro);

                    b.agregarLibro(l);
                    break;
                case 3:
                    System.out.println("Ingrese el id a eliminar:");
                    int id = sc.nextInt();
                    b.borrarLibro(id);
                    break;
                default:
                    break;
            }

        }

        sc.close();
    }
}
