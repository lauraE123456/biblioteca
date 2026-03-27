1. requisitos del proyecto:
    objetivo: sistema de gestión de biblioteca con uso de estructuras lineales.
    - Gestión de Libros

        Registro: Inserción dinámica en la Lista Enlazada.

        Búsqueda: Recorrido secuencial de la lista por ISBN o Título.

        Préstamo: Cambio de estado de DISPONIBLE a PRESTADO y asignación de poseedor_id.

        Devolución: Reintegración al stock y liberación del usuario.
    - Gestión de Usuarios

        Registro/Actualización: Manejo de nodos en la lista de usuarios.

        Eliminación: Desvinculación de nodos (ajuste de punteros next).
2. estructuras de datos a usar, orden:
    1. lista enlazada-> para tener el catalogo de libros, insertar y eliminar objetos en cualquier posición (base de datos para usuarios o libros )
    2. cola-> gestión de Turnos y Reservas, respetar el orden de llegada debe respetarse, primero en llegar primero en salir(Firts In Firsts Out)
    3. pila-> para control de historial de actividad, ver el ultimo libro que ingreso al sistema, o la ultima modificacion 
    
    
3. Diseñar como se organizara la información, definir que datos seran almacenados
    - Definir clase Libro
    isbn String
    titulo String
    autor String
    estado:Enum
    poseedor_id

    - Definir clase Usuario
    id_usuario String
    nombre String
    email String
    libros_prestados
    
    - Clase Prestamo 
    id_prestamo, isbn, id_usuario, fecha
    - Clase Biblioteca -conteine metodos como prestar_libro(),recibir_devolucion()
4. Buenas practicas de programación 
5. interfaz intuitiva
    La interfaz debe ser un bucle que presente un Menú Principal claro:

    1. Módulo Libros: (Submenú: Agregar, Buscar, Ver Catálogo).

    2. Módulo Usuarios: (Submenú: Registrar, Eliminar).

    3. Operaciones: (Prestar, Devolver).

    Reportes: (Ver Historial [Pila], Ver Reservas [Cola]).
6. Pruebas y depuracion