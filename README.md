1. requisitos del proyecto:
   objetivo: sistema de gestión de biblioteca con uso de estructuras lineales.
   - Gestión de Libros

     Registro Libro: Inserción dinámica en la Lista Enlazada.

     Ver Libro: Muestra la lista actual de los libros que estan en el sistema.

     Borrar Libro: Pedirle al usuario el ID del libro a eliminar y borrar de la lista

   - Gestión de Usuarios

     Registro Usuarios: Manejo de nodos en la lista de usuarios.

     Ver Usuarios: Muestra la lista de los usuarios y con los libros que tiene en uso

     Borrar Usuario: Elimina usuario, preguntado el id del usuario, valida si exite lo elimina, si no existe muestra un error

   - Gestión de Prestamo

     Prestar libro: Pide al usuario el id del libro y el id del usuario.

     Devolver Libro : Aqui desencolamos el libro y lo habilitamos como disponible cuando lo devuelven

     Ver Lista Espera: Aqui hacemos uso de un nodo, que es la cabeza principal donde nos muestra quien llego de primeras y quien va a ocupar el libro de primera

     Ver ultima acción: Muestra la ultima accion dentro del sistema.

     Ver historial de prestamos:
     Muestra el historial de los libros y cual fue el ultimo en ser devuelto.

2. estructuras de datos a usar, orden:
   1. lista enlazada-> para tener el catalogo de libros, insertar y eliminar objetos en cualquier posición . Uso de nodo, realizando una simulacion con la lista, aqui se creo una variable cabeza a la cual se iba haciendo una modificacion, al que llegaba, se asignaba como el siguiente y asi sucesivamente
   2. cola-> gestión de Turnos y Reservas, respetar el orden de llegada debe respetarse, primero en llegar primero en salir(Firts In Firsts Out)
   3. pila-> para control de historial de actividad, ver el ultimo libro que ingreso al sistema, o la ultima modificacion
3. Diseñar como se organizara la información, definir que datos seran almacenados
   - Definir clase Libro
     isbn int
     titulo String
     autor String
     estado:Enum
     poseedor_id

   - Definir clase Usuario
     id_usuario int
     nombre String
     email String
     telefono String
     libros_prestados
   - Clase Prestamo
     id_prestamo String
     isbn int
     id_usuario int
     fecha date
   - Clase Biblioteca
     conteine metodos para cada uno de sus modulos y son los siguientes:
     _---Modulo Usuario---_
     verUsuarios(), generarIdUsuario(), agregarUsuario(), buscarUsuarioPorId(), borrarUsuario()
     _---Modulo Libro---_
     generarIdLibro(), agregarLibro(), verCatalogo(), buscarLibroPorID(), borrarLibro
     _---Modulo Prestar Libro---_
     prestar_libro(), devolverLibro(), verListaEspera(), mostrarUltimaAccion(), verHistorialPrestamos()

     La clase biblioteca invoca los atributos necesarios para llamar las diferentes metodos de cola, pila, lista y nodo

   Uso de Nodo
   quise hacer uso de esta unidad _Nodo_, ya que se me hizo muy interesante, observando videos, tengo la conclusión que hace parte de la estructura de datos dinamica y que su función se basa en almacenar información en este caso datos, además cada nodo apunta al siguiente, lo cual facilita agregar o eliminar un elemento.

4. Buenas practicas de programación
   Para cumplir con este punto, quise hacer uso a lo que le llama POO, ya que me parece que es importante hacer uso de la buenas practicas, asi como el llamado de las variables con el uso de camelCase
   Además cree clases como Libro, Usuarios, Prestamo y Biblioca, cada una con sus correspondientes atributos privados y el llamado de estos en el constructor.
   Cree metodos con nombres claros y descriptivos
5. interfaz intuitiva
   La interfaz debe ser un bucle que presente un Menú Principal claro:
   1. Módulo Libros: (Submenú: Agregar, Buscar, Ver Catálogo).

   2. Módulo Usuarios: (Submenú: Registrar, Eliminar).

   3. Módulo Prestamo: (Prestar, Devolver).

6. Pruebas y depuracion
