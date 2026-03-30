import java.util.InputMismatchException;
import java.util.Scanner;
import entities.Biblioteca;
import entities.Libro;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Biblioteca b = new Biblioteca();
        int opcion = 0;
        // do-while para que el menú se muestre al menos una vez
        do {
            try {
                System.out.println("\n-----Bienvenido al sistema de gestión de biblioteca-----");
                System.out.println("1. Gestión Libros");
                System.out.println("2. Gestión Usuarios");
                System.out.println("3. Gestión Historial Préstamo");
                System.out.println("0. Salir");
                System.out.print("Por favor, digita una opción: ");

                opcion = sc.nextInt();
                sc.nextLine(); // !!! LIMPIAR BÚFER después de nextInt()

                switch (opcion) {
                    case 1:
                        boolean menuLibro = false;
                        while (!menuLibro) {
                            System.out.println("\n---- Gestión de Libros ----");
                            System.out.println(
                                    "1. Ver Catálogo \n2. Agregar Libro \n3. Borrar Libro \n4. Volver al Menú Principal");
                            int opcionLibros = sc.nextInt();
                            sc.nextLine(); // !!! LIMPIAR BÚFER

                            switch (opcionLibros) {
                                case 1:
                                    b.verCatalogo();
                                    break;
                                case 2:
                                    int id_libro = b.generarIdLibro();
                                    System.out.print("Título del libro: ");
                                    String titulo = sc.nextLine();
                                    System.out.print("Autor del libro: ");
                                    String autor = sc.nextLine();

                                    Libro l = new Libro(id_libro, titulo, autor);
                                    b.agregarLibro(l);
                                    System.out.println("Libro agregado con éxito.");
                                    break;
                                case 3:
                                    System.out.print("Ingrese el ID a eliminar: ");
                                    int id = sc.nextInt();
                                    sc.nextLine(); // !!! LIMPIAR BÚFER
                                    b.borrarLibro(id);
                                    break;
                                case 4:
                                    menuLibro = true;
                                    break;
                            }
                        }
                        break;
                    case 2:
                        boolean menuUsuario = false;
                        while (!menuUsuario) {
                            System.out.println("\n---- Gestión de Usuarios ----");
                            System.out.println(
                                    "1. Ver Usuario \n2. Agregar Usuario \n3. Borrar Usuario  \n4. Volver al Menú Principal");
                            int opcionUsuario = sc.nextInt();
                            sc.nextLine(); // !!! LIMPIAR BÚFER
                            switch (opcionUsuario) {
                                case 1:
                                    b.verUsuarios();
                                    break;
                                case 2:
                                    int id_usuario = b.generarIdUsuario();
                                    System.out.println("Nombre del usuario:");
                                    String nombre = sc.nextLine();
                                    System.out.println("Email del usuario:");
                                    String email = sc.nextLine();
                                    System.out.println("Telefono del usuario:");
                                    int telefono = sc.nextInt();

                                    // agregar usuario llamando a la clase usuario
                                    Usuario usuario = new Usuario(id_usuario, nombre, email, telefono);
                                    b.agregarUsuarios(usuario);
                                    break;
                                case 3:
                                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                                    int id = sc.nextInt();
                                    sc.nextLine(); // !!! LIMPIAR BÚFER
                                    b.borrarUsuario(id);
                                    break;
                                case 4:
                                    menuUsuario = true;
                                    break;
                            }

                        }
                        break;
                    case 3:
                        boolean menuPrestamo = false;
                        while (!menuPrestamo) {
                            System.out.println("\n -----Gestión de Prestamo-----");
                            System.out.println(
                                    "1. Prestar libro \n2. Devolver libro \n3. Ver lista de Espera   \n4. Ver ultimas acciones\n5. Volver al Menú Principal");
                            int opcionPrestamo = sc.nextInt();
                            sc.nextLine();
                            int id_usuario;
                            int id_libro;
                            switch (opcionPrestamo) {
                                case 1:
                                    System.out.println(
                                            "--------Bienvenido a la sesión de prestar.-------- \n por favor, Ingrese:");
                                    System.out.println(" ID Usuario:");
                                    id_usuario = sc.nextInt();
                                    System.out.println("ID Libro");
                                    id_libro = sc.nextInt();

                                    b.prestarLibro(id_usuario, id_libro);
                                    break;
                                case 2:
                                    System.out.println(" ID Usuario:");
                                    id_usuario = sc.nextInt();
                                    System.out.println("ID Libro");
                                    id_libro = sc.nextInt();
                                    b.devolverLibro(id_libro, id_usuario);
                                    break;
                                case 3:
                                    System.out.println("Esta es la lista de espera:");
                                    b.verListaEspera();
                                    break;
                                case 4:
                                    System.out.println("Estas son las ultimas acciones:");
                                    b.mostrarUltimaAccion();
                                    break;
                                case 5:
                                    menuPrestamo = true;
                                    break;
                                default:
                                    break;
                            }

                        }

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error debe ingresar un numero");
                sc.nextLine();
                opcion = -1;
            }

        } while (opcion != 0);

        sc.close(); // Se cierra solo al final de todo el programa
    }
}