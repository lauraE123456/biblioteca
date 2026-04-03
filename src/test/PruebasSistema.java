package test;
import entities.Biblioteca;
import entities.Libro;
import entities.Usuario;
public class PruebasSistema {
    public static void main(String[] args) {
        System.out.println("Pruebas del sistema");
        System.out.println("Iniciando pruebas automaticas...");
        Biblioteca b = new Biblioteca();
        //Prueba de agregar libros con nodos
        //generar 3 libros y usar generador de id para cada uno
        System.out.println("--------Gestión Libros--------");
        int id_libro1 = b.generarIdLibro();
        Libro libro1 =new Libro(id_libro1,"El Quijote", "Miguel de Cervantes");

        int id_libro2 = b.generarIdLibro();
        Libro libro2 =new Libro(id_libro2,"Don Juan Tenorio", "José Zorrilla");

        int id_libro3 = b.generarIdLibro();
        Libro libro3 =new Libro(id_libro3,"Cien Años de Soledad", "Gabriel García Márquez");

        b.agregarLibro(libro1);
        b.agregarLibro(libro2);
        b.agregarLibro(libro3);

        //Prueba para ver la lista de libros
        System.out.println("Lista de libros en la biblioteca:");
        b.verCatalogo();

        // Prueba para borrar un libro
        System.out.println("Borrando el libro con ID 2...");
        b.borrarLibro(id_libro2);
        System.out.println("Libro borrado.");

        //Verificar que el libro se ha borrado
        System.out.println("--------------Verificando el dato eliminado--------------");
        System.out.println("Lista de libros en la biblioteca:");
        b.verCatalogo();

        // Prueba de agregar usuarios
        System.out.println("--------Gestión Usuarios--------");

        //Generar nuevo id para el usuario
        int id_usuario1 = b.generarIdUsuario();
        //agregar nuevo usuario
        Usuario usuario1= new Usuario(id_usuario1, "Laura Albarracin", "laura@gmail.com", "3244582033");
        b.agregarUsuarios(usuario1);

        int id_usuario2 = b.generarIdUsuario();
        Usuario usuario2= new Usuario(id_usuario2, "Karen Avellaneda", "karen@gmail.com", "3242526999");
        b.agregarUsuarios(usuario2);

        int id_usuario3 = b.generarIdUsuario();
        Usuario usuario3= new Usuario(id_usuario3, "Sharick Albarracín", "sharick@gmail.com", "3133231532");
        b.agregarUsuarios(usuario3);

        //Mostrar usuario
        System.out.println("Ver los usuarios agregados");
        b.verUsuarios();
        // Prueba para borrar usuario
        System.out.println("Borrar usurario con id 2");
        // identificar el usuario a borrar id=2
        b.borrarUsuario(id_usuario2);
        System.out.println("--------------Verificando el dato eliminado--------------");
        b.verUsuarios();

        //Uso de pilas y colas
        System.out.println("--------Gestión Prestamo--------");
        System.out.println("Prestando Libro");
        b.prestarLibro(id_usuario3, id_libro3);
        b.prestarLibro(id_usuario1, id_libro1);

        // Prueba para devolver un libro
        System.out.println("Devolver Libro con id 3");
        b.devolverLibro(id_libro3, id_usuario3);

        // Ver la ultima accción del sistema
        System.out.println("Estas son las ultimas acciones:");
        b.mostrarUltimaAccion();
        // Ver historial de prestamos
        System.out.print("Estas son las acciones de prestamos realizadas:");
        b.verHistorialPrestamos();

        //prestar libro para poner en la lista de espera el usuario
        b.prestarLibro(id_usuario3, id_libro1);
        // Ver lista de espera
        System.out.println("Esta es la lista de espera:");
        b.verListaEspera();



    }
    
}
