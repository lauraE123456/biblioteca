import java.util.InputMismatchException;
import java.util.Scanner;
import entities.Biblioteca;
import entities.Libro;
import entities.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // llamado de la clase biblioteca y hacer uso de sus metodos
        Biblioteca b = new Biblioteca();
        int opcion = 0;
        // do-while para que el menú se muestre al menos una vez
        do {
            try {
                System.out.println("\n-----Bienvenido al sistema de gestión de biblioteca-----");
                System.out.println("\n-----¿Qué deseas hacer hoy?-----");
                System.out.println("1. Gestión Libros");
                System.out.println("2. Gestión Usuarios");
                System.out.println("3. Gestión Préstamo");
                System.out.println("0. Salir");
                System.out.print("Por favor, digita una opción: ");

                opcion = sc.nextInt();
                sc.nextLine(); // limpiar despues de leer un entero

                switch (opcion) {
                    // MODULO GESTIÓN DE LIBROS
                    case 1:
                        boolean menuLibro = false;
                        while (!menuLibro) {
                            System.out.println("\n---- Gestión de Libros ----");
                            System.out.println("\n---- Por favor elija una de las acciones que desea hacer hoy ----");
                            System.out.println(
                                    "1. Ver Catálogo \n2. Agregar Libro \n3. Borrar Libro \n4. Volver al Menú Principal");
                            System.out.print("Por favor, digita una opción: ");
                            int opcionLibros = sc.nextInt();
                            sc.nextLine(); // limpiar despues de leer un entero

                            switch (opcionLibros) {
                                case 1:
                                    System.out.println("\n---- Catálogo de Libros ----");
                                    b.verCatalogo();
                                    break;
                                case 2:
                                    int idLibro = b.generarIdLibro();
                                    System.out.println("\n---- Vamos a agregar un libro: ----");
                                    System.out.println("\n---- Por favor ingrese: ----");
                                    System.out.print("Título del libro: ");
                                    String tituloLibro = sc.nextLine();
                                    System.out.print("Autor del libro: ");
                                    String autorLibro = sc.nextLine();

                                    Libro l = new Libro(idLibro, tituloLibro, autorLibro);
                                    b.agregarLibro(l);
                                    System.out.println("Libro agregado con éxito.");
                                    break;
                                case 3:
                                    System.out.println("\n---- Vamos a borrar un libro: ----");
                                    System.out.print("Ingrese el ID a eliminar: ");
                                    int id = sc.nextInt();
                                    sc.nextLine(); // limpiar despues de leer un entero
                                    b.borrarLibro(id);
                                    break;
                                case 4:
                                    System.out.print("Saliendo del menú de libros...\n");
                                    menuLibro = true;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                        }
                        break;
                    // MODULO DE GESTIÓN DE USUARIOS
                    case 2:
                        boolean menuUsuario = false;
                        while (!menuUsuario) {
                            System.out.println("\n---- Gestión de Usuarios ----");
                            System.out.println("\n---- Por favor elija una de las acciones que desea hacer hoy ----");
                            System.out.println(
                                    "1. Ver Usuario \n2. Agregar Usuario \n3. Borrar Usuario  \n4. Volver al Menú Principal");
                            System.out.print("Por favor, digita una opción: ");
                            int opcionUsuario = sc.nextInt();
                            sc.nextLine(); // !!! LIMPIAR BÚFER
                            int idUsuario;
                            switch (opcionUsuario) {
                                case 1:
                                    b.verUsuarios();
                                    break;
                                case 2:
                                    System.out.print("Agregar Usuario: \n");
                                    idUsuario = b.generarIdUsuario();
                                    System.out.println("Nombre del usuario:");
                                    String nombreUsuario = sc.nextLine();
                                    System.out.println("Email del usuario:");
                                    String correoElectronico = sc.nextLine();
                                    System.out.println("Telefono del usuario:");
                                    String numeroTelefono = sc.nextLine();

                                    // agregar usuario llamando a la clase usuario
                                    Usuario usuario = new Usuario(idUsuario, nombreUsuario, correoElectronico, numeroTelefono);
                                    b.agregarUsuarios(usuario);
                                    break;
                                case 3:
                                    System.out.print("Borrar Usuario: \n");
                                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                                    idUsuario= sc.nextInt();
                                    sc.nextLine(); // !!! LIMPIAR BÚFER
                                    b.borrarUsuario(idUsuario);
                                    break;
                                case 4:
                                    System.out.print("Saliendo del menú de usuarios...\n");
                                    menuUsuario = true;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }

                        }
                        break;
                    // MODULO DE PRESTAMO
                    case 3:
                        // iniciar el menu en false para que abra y al terminar o querer salir
                        // habilitarlo como true
                        boolean menuPrestamo = false;
                        while (!menuPrestamo) {
                            System.out.println("\n -----Gestión de Prestamo-----");
                            System.out.println(
                                    "1. Prestar libro \n2. Devolver libro \n3. Ver lista de Espera   \n4. Ver ultimas acciones\n5. Ver historial de préstamos\n6. Volver al Menú Principal");
                            System.out.print("Por favor, digita una opción: ");
                            int opcionPrestamo = sc.nextInt();
                            sc.nextLine();
                            int idUsuario;
                            int idLibro;
                            switch (opcionPrestamo) {
                                case 1:
                                    System.out.println(
                                            "--------Bienvenido a la sesión de prestar.-------- \n por favor, Ingrese:");
                                    System.out.println(" ID Usuario:");
                                    idUsuario = sc.nextInt();
                                    System.out.println("ID Libro");
                                    idLibro = sc.nextInt();

                                    b.prestarLibro(idUsuario, idLibro);
                                    break;
                                case 2:
                                    System.out.print("Devolver libro: \n");
                                    System.out.println(" ID Usuario:");
                                    idUsuario = sc.nextInt();
                                    System.out.println("ID Libro");
                                    idLibro = sc.nextInt();
                                    b.devolverLibro(idLibro, idUsuario);
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
                                    System.out.print("Estas son las acciones de prestamos realizadas:");
                                    b.verHistorialPrestamos();
                                    break;
                                case 6:
                                    System.out.print("Saliendo del menú de préstamos...\n");
                                    menuPrestamo = true;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }

                        }

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        System.out.println("Gracias por usar el sistema.");
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