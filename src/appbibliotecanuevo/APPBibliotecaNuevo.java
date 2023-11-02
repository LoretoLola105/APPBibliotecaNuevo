/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo;

import appbibliotecanuevo.AccesoDatos.EjemplarData;
import appbibliotecanuevo.AccesoDatos.LectorData;
import appbibliotecanuevo.AccesoDatos.LibroData;
import appbibliotecanuevo.AccesoDatos.PrestamoData;
import appbibliotecanuevo.entidades.Ejemplar;
import appbibliotecanuevo.entidades.EstadoEjemplar;
import static appbibliotecanuevo.entidades.EstadoEjemplar.INACTIVO_PRESTADO;
import appbibliotecanuevo.entidades.EstadoPrestamo;
import appbibliotecanuevo.entidades.Lector;
import appbibliotecanuevo.entidades.Libro;
import appbibliotecanuevo.entidades.Prestamo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Otras
 */
public class APPBibliotecaNuevo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Connection con = Conexion.getConexion();
//METODO GUARDAR LIBRO 

        /* Libro retrato = new Libro("El retrato de Dorian Gray", "Oscar Wilde", 1890, "Novela", "Lippincotts Monthly Magazine", true );
        LibroData lib = new LibroData();
        lib.guardarLibro(retrato);*/
// EL METODO FUNCIONA GUARDA EL LIBRO EL RETRATO DE DORIAN GREY idLibro  23
        //***********************************************************************************************************************************
//METODO BUSCAR LIBRO POR idISBN 

      /*   LibroData lib=new LibroData();
       Libro libroEncontrado=lib.buscarLibroPorIdLibro(2);
      if(libroEncontrado!=null){//para que no muestre el nullpointerexception
        System.out.println("Titulo: "+libroEncontrado.getTitulo());
        System.out.println("Autor: "+libroEncontrado.getAutor());
        System.out.println("Editorial: "+libroEncontrado.getEditorial()); */
        
        
//RESULTADO ENCUENTRA AL LIBRO CON ID (2): run: Titulo: Cien años de soledad, Autor: Gabriel Garcia Marquez, Editorial: Sudamericana.
//************************************************************************************************************************++  
//METODO BUSCAR LIBRO POR TITULO 

        /*LibroData lib=new LibroData();
       Libro libroEncontrado=lib.buscarLibroPorTitulo("orgullo y prejuicio");
      if(libroEncontrado!=null){//para que no muestre el nullpointerexception
        System.out.println("Titulo: "+libroEncontrado.getTitulo());
        System.out.println("Autor: "+libroEncontrado.getAutor());
        System.out.println("Editorial: "+libroEncontrado.getEditorial());*/
//RESULTADO ENCUENTRA AL LIBRO CON TITULO (orgullo y prejuicio): 
//run: Titulo: orgullo y prejuicio, Autor: Jane Austen, Editorial: T. Egerton, Whitehall, BUILD SUCCESSFUL (total time: 3 seconds)
//******************************************************************************************************************

//METODO BUSCAR LIBRO POR TITULO 

        /*LibroData lib=new LibroData();
       Libro libroEncontrado=lib.buscarLibroPorTitulo("orgullo y prejuicio");
      if(libroEncontrado!=null){//para que no muestre el nullpointerexception
        System.out.println("Titulo: "+libroEncontrado.getTitulo());
        System.out.println("Autor: "+libroEncontrado.getAutor());
        System.out.println("Editorial: "+libroEncontrado.getEditorial());*/
//RESULTADO ENCUENTRA AL LIBRO CON TITULO (orgullo y prejuicio): 
//run: Titulo: orgullo y prejuicio, Autor: Jane Austen, Editorial: T. Egerton, Whitehall, BUILD SUCCESSFUL (total time: 3 seconds)
//******************************************************************************************************************

//METODO BUSCAR LIBRO POR ANIO EDICION

      
    /*LibroData libroData = new LibroData();
    
    int anioBuscado = 1985;  // Reemplaza esto con el año que quieras buscar.
    Libro libroEncontrado = libroData.buscarLibroPorAnio(anioBuscado);

    // 4. Muestra los resultados en la consola o haz lo que desees con los datos devueltos.
    if (libroEncontrado != null) {
        System.out.println("Libro encontrado:");
        System.out.println("ISBN: " + libroEncontrado.getIsbn());
        System.out.println("Título: " + libroEncontrado.getTitulo());
        System.out.println("Autor: " + libroEncontrado.getAutor());
        System.out.println("Año: " + libroEncontrado.getAnio());
        System.out.println("Género: " + libroEncontrado.getGenero());
        System.out.println("Editorial: " + libroEncontrado.getEditorial());
        System.out.println("Estado: " + (libroEncontrado.isEstado() ? "Disponible" : "No Disponible"));
    } else {
        System.out.println("No se encontró ningún libro con el año solicitado " + anioBuscado);
    }
} */

    //RESULTADO EXITOSO run: Libro encontrado: ISBN: 21, Título: El amor en los tiempos del colera, Autor: Gabriel Garcia Marquez, 
//Año: 1985, Género: Novela, Editorial: Oveja Negra, Estado: Disponible BUILD SUCCESSFUL (total time: 6 seconds)

//******************************************************************************************************************



//METODO BUSCAR LIBRO POR GENERO CIENCIA FICCION
        /*LibroData lib = new LibroData();
        String generoBuscado = "ciencia ficcion";
        Libro libroEncontrado = lib.buscarLibroPorGenero(generoBuscado);

        if (libroEncontrado != null) {
            System.out.println("Libro encontrado: ");
            System.out.println("Título: " + libroEncontrado.getTitulo());
            System.out.println("Autor: " + libroEncontrado.getAutor());
            System.out.println("Editorial: " + libroEncontrado.getEditorial());  
            System.out.println("--------------------------------------------------------");
        }*/
        ////RESULTADO ENCUENTRA AL LIBRO CON CIENCIA FICCION run: Libro encontrado: Título: Los juegos del hambreAutor: Suzanne Collins Editorial: Scholastic BUILD SUCCESSFUL (total time: 3 seconds)
        //************************************************************************************************************   
//METODO LISTAR LIBROS 
//MUESTRA LA LISTA DE LIBROS ACTIVOS
        /* LibroData lib = new LibroData();
        for (Libro libro : lib.listarLibro()) {
            System.out.println(libro.getIsbn());
            System.out.println(libro.getTitulo());
            System.out.println(libro.getAutor());
            System.out.println(libro.getAnio());
            System.out.println(libro.getGenero());
            System.out.println(libro.getEditorial());
            System.out.println("--------------------");
        }*/
// RESULTADO EXITOSO MUESTRA A LOS LIBROS ACTIVOS run: 
//1, 1984, George Orwell, 1949, novela Distopía, Secker & Warburg ;
// 2, Cien años de soledad, Gabriel Garcia Marquez, 1967, Realismo Magico, Sudamericana;
//3, Matar a un ruiseñor, Harper Lee, 1960, Novela, J.B. Lippincott & Co.
// 4, El gran Gatsby, F. Scott Fitsgerald, 1925, Ficcion Moderna, Charles Scribners Sons; 
//5, En busca del tiempo Perdido, Marcel Proust, 1913, Novela, Varios editores
//6, Crimen y Castigo, Fyodor Dostoevsky, 1866, Novela Psicologica, The Russian Messenger; 
//7, Ulises, James Joyce, 1922, Novela Modernista, Sylvia Beach
//8, Moby-Dick, Herman Melville, 1851, Novela de aventuras, Harper & Brothers; 
//9, Sobre Heroes y Tumbas, Ernesto Sabato, 1961, Novela, Compañía General Fabril Editora
//10, Ceremonia Secreta, Marco Denevi, 1977, Novela, Sudamericana;
//12, El corazon de las tinieblas, Joseph Conrad, 1899, Novela corta, Blackwoods Magazine; 13, Orgullo y Prejuicio, 
//Jane Austen, 1813, Novela Romantica, T. Egerton, Whitehall; 
//14, Orgullo y Prejuicio, Jane JANE Austen, 1813, Novela Romantica Britanica, T. Egerton, Whitehall BUILD SUCCESSFUL (total time: 3 seconds)
        //************************************************************************************************************ 
//METODO LISTAR LIBROS POR GENERO SE BUSCA EL GENERO "NOVELA"
//MUESTRA LA LISTA DE LIBROS ACTIVOS CON GENERO NOVELA

        /*LibroData lib = new LibroData();

    // Luego, llama al método para listar libros por género.
    String generoBuscado = "Novela";  // Reemplaza "Aventura" con el género que deseas buscar.
    List<Libro> librosEncontrados = lib.listarLibrosPorGenero(generoBuscado);

    if (!librosEncontrados.isEmpty()) {
        System.out.println("Libros encontrados con el género " + generoBuscado + ":");
        for (Libro libro : librosEncontrados) {
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año: " + libro.getAnio());
            System.out.println("Género: " + libro.getGenero());
            System.out.println("Editorial: " + libro.getEditorial());
            System.out.println("Estado: " + (libro.isEstado() ? "Disponible" : "No Disponible"));
            System.out.println("--------------");
        }
    } else {
        System.out.println("No se encontraron libros con el género " + generoBuscado);
    }
}*/
//  RESULTADO run: idLibro:3, Titulo: Matar a un ruiseñor, Autor: Harper Lee, Genero: Novela, Editorial: J.B. Lippincott & Co; idLibro:5, Titulo: En busca del tiempo perdido, Autor: Marcel Proust
//Genero: Novela, Editorial: Varios Editores; idLibro:6, Titulo: Crimen y castigo, Autor: Fyodor Dostoevsky, Genero: Novela Psicologica, Editorial: The Russian Messenger; idLibro:7, Titulo: Ulises
//Autor: James Joyce, Genero: Novela Modernista, Editorial: Sylvia Beach; idLibro:8, Titulo: Moby-Dick, Autor: Herman Melville, Genero: Novela de Aventuras, Editorial: Harper & Brothers
//idLibro:9, Titulo: El corazon de las tinieblas, Autor: Joseph Conrad, Genero: Novela Corta, Editorial: Blackwoods Magazine; idLibro:10, Titulo: Orgullo y Prejuicio, Autor: Jane JANE Austen
//Genero: Novela Romantica Britanica, Editorial: T. Egerton, Whitehall; idLibro:13, Titulo: Crónica de una muerte anunciada, Autor: Gabriel Garcia Marquez, Genero: Novela, Editorial: Editorial La Oveja Negra
//idLibro:17, Titulo: Don Quijote de la Mancha, Autor: Francisco de Robles, Genero: Novela Clasica, Editorial: Miguel de Cervantes; idLibro:20, Titulo: El extranjero, Autor: Albert Camus, Genero: Novela filosofica
//Editorial: Gallimard; idLibro:21, Titulo: El amor en los tiempos del colera, Autor: Gabrile Garcia Marquez, Genero: Novela, Editorial: Oveja Negra; idLibro:22, Titulo: Orgullo y Prejuicio Zombie
//Autor: Jane Austen, Genero: Novela Romantica, Editorial: T. Egerton, Whitehall BUILD SUCCESSFUL (total time: 4 seconds)
//*****************************************************************************************************************************************
        //METODO LISTAR LIBROS POR AUTOR
        //METODO LISTAR LIBROS SE BUSCA EL AUTOR "gabriel garcia marquez"
//MUESTRA LA LISTA DE LIBROS ACTIVOS CON GENERO NOVELA

       /* LibroData lib = new LibroData();
        for (Libro libro : lib.listarLibrosPorAutor("george orwell")) {
            System.out.println("idLibro:"+libro.getIsbn());
            System.out.println("Titulo: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("Año: "+libro.getAnio());
            System.out.println("Genero: "+libro.getGenero());
            System.out.println("Editorial: "+libro.getEditorial());
            System.out.println("--------------------");
        }*/
//RESULTADO EXITOSO run: 
//idLibro:2, Titulo: Cien años de soledad, Autor: Gabriel Garcia Marquez, Genero: Realismo Magico, Editorial: Sudamericana;
//idLibro:13, Titulo: Crónica de una muerte anunciada, Autor: Gabriel Garcia Marquez, Genero: Novela, Editorial: Editorial La Oveja Negra BUILD SUCCESSFUL (total time: 3 seconds)
//*************************************************************************************************************************************************
        //METODO LISTAR LIBROS POR LA  EDITORIAL
        //METODO LISTAR LIBROS SE BUSCA LA EDITORIAL "sudamericana"

        /*LibroData lib = new LibroData();

    // Luego, llama al método para listar libros por género.
    String editorialBuscada = "Sudamericana";  // Reemplaza "Aventura" con el género que deseas buscar.
    List<Libro> librosEncontrados = lib.listarLibrosPorEditorial(editorialBuscada);

    if (!librosEncontrados.isEmpty()) {
        System.out.println("Libros encontrados con la editorial " + editorialBuscada + ":");
        for (Libro libro : librosEncontrados) {
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año: " + libro.getAnio());
            System.out.println("Género: " + libro.getGenero());
            System.out.println("Editorial: " + libro.getEditorial());
            System.out.println("Estado: " + (libro.isEstado() ? "Disponible" : "No Disponible"));
            System.out.println("--------------");
        }
    } else {
        System.out.println("No se encontraron libros con la editorial " + editorialBuscada);
    }*/
        //RESULTADO EXITOSO run: 
        //idLibro:2, Titulo: Cien años de soledad, Autor: Gabriel Garcia Marquez, Genero: Realismo Magico, Editorial: Sudamericana;
        //idLibro:18, Titulo: Rayuela, Autor: Julio Cortazar, Genero: Ficcion Experimental, Editorial: Sudamericana BUILD SUCCESSFUL (total time: 3 seconds)
//****************************************************************************************************************************************************     
        //METODO LISTAR LIBROS POR EL AÑO DE EDICION 
        //METODO LISTAR LIBROS SE BUSCA LOS LIBRO PUBLICADOS EL AÑO (1985)

        /*LibroData lib = new LibroData();
        for (Libro libro : lib.listarLibrosPorAnioEdicion(1985)) {
            System.out.println("idLibro:"+libro.getIsbn());
            System.out.println("Titulo: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("Año: "+libro.getAutor());
            System.out.println("Genero: "+libro.getGenero());
            System.out.println("Editorial: "+libro.getEditorial());
            System.out.println("--------------------");
        }*/
//RESULTADO EXITOSO run: run: 
//idLibro:21 Titulo: El amor en los tiempos del colera Autor: Gabrile Garcia Marquez Año: Gabrile Garcia Marquez, Genero: Novela Editorial: Oveja Negra; 
//idLibro:24 Titulo: El cuento de la criada Autor: Margaret Atwood Año: Margaret Atwood Genero: Novela-Ficcion distopica, Editorial: McClelland & Stewart BUILD SUCCESSFUL (total time: 5 seconds)
//***************************************************************************************************************
//METODO MODIFICAR LIBRO

        /* Libro orgullo = new Libro(26, "Orgullo y Prejuicio ZOMBIE", "Jane JANE Austen" , 1813, "Novela Romantica Britanica" , "T. Egerton, Whitehall", true);
        LibroData lib = new LibroData();
        lib.modificarLibro(orgullo);*/
//SE MODIFICO EL LIBRO  EN EL idISBN 26 "Orgullo y prejuicio ZOMBIE"
//*****************************************************************************************************************************************        
        //METODO ELIMINAR LIBRO DE FORMA LOGICA
        
       /* Libro orgullo = new Libro("Orgullo y Prejuicio ZOMBIE", "Jane Austen" ,1813,  "Novela Romantica" , "T. Egerton, Whitehall", true);
        LibroData lib = new LibroData();
        lib.eliminarLibroLogico(25); */
        
//ELIMINA EXITOSAMENTE LIBRO DE FORMA LOGICA idLibro (25) 
        //***********************************************************************************************************************************
         //METODO ELIMINAR LIBRO
        /*Libro orgullo = new Libro("Orgullo y Prejuicio ZOMBIE", "Jane Austen" ,1813,  "Novela Romantica" , "T. Egerton, Whitehall", true);
        LibroData lib = new LibroData();
        lib.eliminarLibro(26);*/
        //ELIMINA EXITOSAMENTE LIBRO idLibro (26) 
//***********************************************************************************************************************************
        ///METODO GUARDAR LECTOR nombre, dni, domicilio, telefono, estado) 
        /*Lector juan = new Lector("Martinez Juan", 999, "French 2354", "juanPablo@gmail.com",  456789, true);
        LectorData lecData = new LectorData();
        lecData.guardarLector(juan);*/
        //FUNCIONA GUARDA CORRECTAMENTE A L LECTOR ID 9 "Martinez Juan", 999, French 2354, 456789 1;
//************************************************************************************************************************************
//METODO BUSCAR LECTOR nombre, dni, domicilio, telefono, estado FROM lector "
        /*LectorData lecData = new LectorData();
        int id = 4;
        Lector lectorEncontrado = lecData.buscarLector(4);
        if (lectorEncontrado != null) {//para que no muestre el nullpointerexception
            System.out.println("IdLector : " + lectorEncontrado.getIdLector());
            System.out.println("Nombre : " + lectorEncontrado.getNombre());
            System.out.println("DNI: " + lectorEncontrado.getDni());
        }*/
        //FUNCIONA CORRECTAMENTE BUSCA AL ID 4, run: IdLector : 4, Nombre : Portales Ana, DNI: 44444 BUILD SUCCESSFUL (total time: 3 seconds)
//**************************************************************************************************************************************
//METODO BUSCAR LECTOR POR DNI

        /*LectorData lecData = new LectorData();
        int dni = 111;
        Lector lectorEncontrado = lecData.buscarLectorPorDni(111);
        if (lectorEncontrado != null) {//para que no muestre el nullpointerexception
            System.out.println("IdLector : " + lectorEncontrado.getIdLector());
            System.out.println("Nombre : " + lectorEncontrado.getNombre());
            System.out.println("DNI: " + lectorEncontrado.getDni());
        }*/
//RESULTADO EXITOSO (BUSCA A EL EJEMPLAR CON DNI 111) run: IdLector : 1, Nombre : Peralta Nicolas, DNI: 111 BUILD SUCCESSFUL (total time: 5 seconds)
//*****************************************************************************************************************************************
        //METODO LISTAR LECTORES MUESTRA LA LISTA DE LECTORES ACTIVOS 

        /*LectorData lecData = new LectorData();
        for (Lector lector: lecData.listarLectores()){
            System.out.println("IdLector : " + lector.getIdLector());
            System.out.println("Nombre : " + lector.getNombre());
            System.out.println("DNI: " + lector.getDni());
            System.out.println("--------------------");
        }*/
//EL METODO FUNCIONA CORRECTAMENTE LISTA A LOS LECTORES ACTIVOS run: 
//IdLector : 1, Nombre : Peralta Nicolas, DNI: 111; 
//IdLector : 2, Nombre : Santillan Luciana, DNI: 222; 
//IdLector : 3, Nombre : Perez Monica, DNI: 333; 
//IdLector : 4, Nombre : Portales Ana, DNI: 444; 
//IdLector : 5, Nombre : Rodriguez Bianca, DNI: 555; 
//IdLector : 6, Nombre : Gomez Erika, DNI: 666;
//IdLector : 7, Nombre : Blanco Sandra, DNI: 777; 
//IdLector : 8, Nombre : Martinez Carlos, DNI: 888; 
//IdLector : 9, Nombre : Martinez Juan, DNI: 999 BUILD SUCCESSFUL (total time: 3 seconds)
//**************************************************************************************************************************************
//****************************************************************************************************************************************** 
//METODO MODIFICAR LECTOR

        /* Lector juan = new Lector(9, "Martinez Juan Pablo", 99933, "French 2354", "juan@gmail.com", 456789, true);
        LectorData lecData = new LectorData();
        lecData.modificarLector(juan);*/
        //FUNCIONA GUARDA CORRECTAMENTE A L LECTOR ID (9 ,"Martinez Juan Pablo", 25689745, French 2354, 456789 1);
//******************************************************************************************************************************************
        //METODO ELIMINAR LECTOR
        /*Lector juan = new Lector(9, "Martinez Juan Pablo", 999, "French 2354", 456789, true);
        LectorData lecData = new LectorData();
        lecData.eliminarLector(9);*/
        //ELIMINA EXITOSAMENTE LECTOR CON ID( 9, "Martinez Juan Pablo", 999, "French 2354", 456789, true);
//******************************************************************************************************************************************
        //METODO ACTIVAR LECTOR QUE SE ENCUENTRA INACTIVO

        /*Lector juan = new Lector(3,"Perez Monica", 333, "mendoza 2354", "perezMo@gmail.com", 456787, true);
        LectorData lecData = new LectorData();
        lecData.activarLector(3);*/
        // ACTIVA EXITOSAMENTE A LA LECTORA CON ID (3,"Perez Monica", 333, "mendoza 2354", "perezMo@gmail.com", 456787, true);
//**************************************************************************************************************************************
//METODO DESACTIVAR LECTOR QUE SE ENCUENTRA ACTIVO

        /*Lector juan = new Lector(3,"Perez Monica", 333, "mendoza 2354", "perezMo@gmail.com", 456787, true);
        LectorData lecData = new LectorData();
        lecData.desactivarLector(3);*/
        // DESACTIVA EXITOSAMENTE A LA LECTORA CON ID (3,"Perez Monica", 333, "mendoza 2354", "perezMo@gmail.com", 456787, true);
//**************************************************************************************************************************************
////PROCEDIMIENTO PARA GUARDAR EJEMPLAR 

        /* Libro libro = new Libro();
    libro.setIsbn(6); // Reemplaza 12 con el ISBN del libro deseado
    libro.setEstado(true); // Establece el estado del libro

    Ejemplar ejemplar = new Ejemplar();
    ejemplar.setIdIsbn(libro);
    //ejemplar.setLibro(libro); // Asigna el libro al ejemplar
    ejemplar.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
    

    // Luego, llama al método guardarEjemplar para guardar el ejemplar en la base de datos.
    EjemplarData ejemplarData = new EjemplarData();
    ejemplarData.guardarEjemplar(ejemplar);

    // Verifica si el ID del ejemplar se actualizó después de la inserción
    int idEjemplar = ejemplar.getIdEjemplar();
    System.out.println("Ejemplar guardado con ID: " + idEjemplar);
          
}*/
//PROCEDIMIENTO EXITOSO idEjemplar: 45, idIsbn: 7 - Ulises , estado: DISPONIBLE_BIBLIOTECA;  Ejemplar guardado con ID: 50
//***************************************************************************************************************************
//METODO ACTUALIZAR EJEMPLAR    
/*Libro libro = new Libro();
    libro.setIsbn(6); // Reemplaza 12 con el ISBN del libro deseado
    libro.setEstado(true); // Establece el estado del libro

    Ejemplar ejemplar = new Ejemplar();
    ejemplar.setIdIsbn(libro);
    //ejemplar.setLibro(libro); // Asigna el libro al ejemplar
    ejemplar.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
   
    EjemplarData ejemplarData = new EjemplarData();
    ejemplarData.actualizarEjemplar(49, 5, EstadoEjemplar.INACTIVO_PRESTADO, false);
        

    // Verifica que los valores se hayan actualizado correctamente
System.out.println("Ejemplar actualizado con éxito.");  */
//PROCEDIMIENTO EXITOSO idEjemplar: 49, idIsbn: 6 - Ulises , estado: PRESTADO;
//******************************************************************************************************************   
//METODO OBTENER LIBROS POR EJEMPLAR BUSCA EL TITULO DEL LIBRO
        /* LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for(Libro lib: ejeData.obtenerLibroPorEjemplar(5)){
            System.out.println("id ISBN: "+lib.getIsbn());
            System.out.println("Titulo: " +lib.getTitulo());
            System.out.println("Autor: "+lib.getAutor());
            System.out.println("Genero: "+lib.getGenero());
            System.out.println("Año de edicion: "+lib.getAnio());
            System.out.println("Editorial: "+lib.getEditorial());
        }*/
//RESULTADO EXITOSO BUSCA EL LIBRO( INFORMACION) POR EL NUMERO DE ID EJEMPLAR(38)
//run: id ISBN: 21, Titulo: El amor en los tiempos del colera, Autor: Gabriel Garcia Marquez, Genero: Novela, Año de edicion: 1985, Editorial: Oveja Negra BUILD SUCCESSFUL (total time: 3 seconds)
//*********************************************************************************************************************************
//METODO BUSCAR EJEMPLAR POR ID

        /* LibroData libData = new LibroData();
       EjemplarData ejeData = new EjemplarData();
        
        Ejemplar ejemplarEncontrado = ejeData.buscarEjemplar(5);
          //  System.out.println("idEjemplar: "+ejemplarEncontrado.getIdEjemplar());        
          System.out.println("idEjemplar: "+ejemplarEncontrado.getIdEjemplar());  
          System.out.println("idIsbn: "+ejemplarEncontrado.getIdIsbn().getIsbn());
          System.out.println("Titulo: " + ejemplarEncontrado.getIdIsbn().getTitulo());
          System.out.println("Autor: "+ejemplarEncontrado.getIdIsbn().getAutor());
          System.out.println("Editorial: "+ejemplarEncontrado.getIdIsbn().getEditorial());
           System.out.println("activo: "+ejemplarEncontrado.isActivo());
            System.out.println("____________");
        }*/
//RESULTADO EXITOSO BUSCA EL ID EJEMPLAR (5) run: idEjemplar: 5, idIsbn: 21, Titulo: El amor en los tiempos del colera, Autor: Gabriel Garcia Marquez
//Editorial: Oveja Negra, Estado: true BUILD SUCCESSFUL (total time: 3 seconds)
//***************************************************************************************************************************
//METODO BUSCAR EJEMPLAR POR ID ISBN

        /* LibroData libData = new LibroData();
       EjemplarData ejeData = new EjemplarData();
        
        Ejemplar ejemplarEncontrado = ejeData.buscarEjemplarXIsbn(25);
         System.out.println("idIsbn: "+ejemplarEncontrado.getIdIsbn().getIsbn());        
         System.out.println("idEjemplar: "+ejemplarEncontrado.getIdEjemplar());  
          System.out.println("Titulo: " + ejemplarEncontrado.getIdIsbn().getTitulo());
          System.out.println("Autor: "+ejemplarEncontrado.getIdIsbn().getAutor());
          System.out.println("Editorial: "+ejemplarEncontrado.getIdIsbn().getEditorial());
          System.out.println("Estado: "+ejemplarEncontrado.getIdIsbn().isEstado());
            System.out.println("____________");
        }  */
//RESULTADO EXITOSO BUSCA EL ID ISBN run: idIsbn: 5, idEjemplar: 19, Titulo: En busca del tiempo perdido, Autor: Marcel Proust
//Editorial: Varios Editores, Estado: true BUILD SUCCESSFUL (total time: 3 seconds)
//***********************************************************************************************************************************
//METODO obtenerEjemplaresPorLibro1(int idIsbn)

        /*   EjemplarData ejemplarData = new EjemplarData();

    // ID de ISBN válido para el libro que deseas consultar.
    int idIsbn = 12; // Reemplaza con el ID de ISBN correcto.

    // Llama al método obtenerEjemplaresPorLibro con el ID de ISBN.
    List<Ejemplar> ejemplares = ejemplarData.obtenerEjemplaresPorLibro(idIsbn);

    // Muestra los resultados.
    if (!ejemplares.isEmpty()) {
        System.out.println("Ejemplares del libro con ID de ISBN " + idIsbn + ":");
        for (Ejemplar ejemplar : ejemplares) {
            System.out.println("ID de Ejemplar: " + ejemplar.getIdEjemplar());
            System.out.println("ID de ISBN: " + ejemplar.getIdIsbn());
            System.out.println("Estado: " + ejemplar.getEstado());
            System.out.println("Activo: "+ejemplar.isActivo());
            System.out.println("---------------");
           
        }
    } else {
        System.out.println("No se encontraron ejemplares para el libro con ID de ISBN " + idIsbn);
    }
}   */
//RESULTADO EXITOSO: run: Ejemplares del libro con ID de ISBN 12: 
//ID de Ejemplar: 46, ID de ISBN: 12, Los juegos del hambre, Suzanne Collins, Estado: DISPONIBLE_BIBLIOTECA, Activo: true;
//ID de Ejemplar: 47, ID de ISBN: 12, Los juegos del hambre, Suzanne Collins, Estado: DISPONIBLE_BIBLIOTECA, Activo: true:  BUILD SUCCESSFUL (total time: 3 seconds)
//*********************************************************************************************************************************
//METODO LIST OBTENER EJEMPLARES

        /*Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplares()) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn: " + ejem.getIdIsbn());
            System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
            System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        }*/
//RESULTADO EXITOSO OBTIENE LA LISTA DE LOS EJEMPLARES : run: 
//idEjemplar: 2, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, Titulo: El amor en los tiempos del colera, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 3, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, Titulo: El amor en los tiempos del colera, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 4, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, Titulo: El amor en los tiempos del colera, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 5, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, Titulo: El amor en los tiempos del colera, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 6; idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, Titulo: Orgullo y Prejuicio, estado: DISPONIBLE_BIBLIOTECA
//id Ejemplar: 7, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, Titulo: Orgullo y Prejuicio, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 8; idIsbn: 10, Orgullo y Prejuicio, Jane JANE AustenTitulo: Orgullo y Prejuicio, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 9, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, Titulo: Orgullo y Prejuicio Zombie, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 10, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, Titulo: Orgullo y Prejuicio Zombie, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 11, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, Titulo: Orgullo y Prejuicio Zombie, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 12, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, Titulo: Orgullo y Prejuicio Zombie, estado: DISPONIBLE_BIBLIOTECA
//id Ejemplar: 13, idIsbn: 1, 1984, George Orwell, Titulo: 1984, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 14, idIsbn: 1, 1984, George Orwell, Titulo: 1984, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 15, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, Titulo: El gran Gatsby, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 16, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, Titulo: El gran Gatsby, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 17, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, Titulo: El gran Gatsby, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 18, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, Titulo: El gran Gatsby, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 19, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA
//id Ejemplar: 20, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 21, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 22; idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 23, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 24, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia MarquezTitulo: Crónica de una muerte anunciada, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 25; idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez; Titulo: Crónica de una muerte anunciada; estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 26, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, Titulo: Crónica de una muerte anunciada, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 27, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, Titulo: Crónica de una muerte anunciada, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 28, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 29, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 30, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 31, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 32, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 33; idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez ,Titulo: Crónica de una muerte anunciada, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 34, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, Titulo: Crónica de una muerte anunciada, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 35, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, Titulo: Crónica de una muerte anunciada, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 36, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 37, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 38, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 39, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 40, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: DISPONIBLE_BIBLIOTECA;
//id Ejemplar: 41, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 42, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 44, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 45, idIsbn: 7, Ulises, James Joyce, Titulo: Ulises, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 46, idIsbn: 12, Los juegos del hambre, Suzanne Collins, Titulo: Los juegos del hambre, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 47, idIsbn: 12, Los juegos del hambre, Suzanne Collins, Titulo: Los juegos del hambre, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 48; idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: DISPONIBLE_BIBLIOTECA; 
//id Ejemplar: 49, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: DISPONIBLE_BIBLIOTECA; BUILD SUCCESSFUL (total time: 4 seconds)
//*********************************************************************************************************************
//METODO OBTENER EJEMPLARES ACTIVOS "DISPONIBLE_BIBLOTECA"

        /*Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplaresActivos()) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn: " + ejem.getIdIsbn());
            //System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
            System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        }*/
//RESULTADO EXITOSO: run: id Ejemplar: 2, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 3, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 4, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 5, idIsbn: 21, El amor en los tiempos del colera, Gabriel Garcia Marquez, Titulo: El amor en los tiempos del colera, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 6, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 7, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 8, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 9, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 10, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 12, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 14, idIsbn: 1, 1984, George Orwell, Titulo: 1984, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 15, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 16, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 17, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 18, idIsbn: 4, El gran Gatsby, F. Scott Fitzgerald, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 19, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 21, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 23, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 24, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 25, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 27, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 28, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 29, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 30, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 31, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 33, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 34, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 35, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 36, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 37, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 42, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 44, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, estado: DISPONIBLE_BIBLIOTECA, activo: true, activo: true
//id Ejemplar: 46, idIsbn: 12, Los juegos del hambre, Suzanne Collins, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 47, idIsbn: 12, Los juegos del hambre, Suzanne Collins, estado: DISPONIBLE_BIBLIOTECA, activo: true
//id Ejemplar: 48, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, estado: DISPONIBLE_BIBLIOTECA, activo: true  BUILD SUCCESSFUL (total time: 3 seconds)
//*************************************************************************************************************************************
//METODO OBTENER EJEMPLARES INACTIVOS

        /*Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplaresInactivos()) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn : " + ejem.getIdIsbn());
            //System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
             System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        } */
//RESULTADO EXITOSO BUSCA LOS EJEMPLARES INACTIVOS_ PRESTADOS: run: 
//id Ejemplar: 39, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, estado: INACTIVO_PRESTADO, activo: false
//id Ejemplar: 40, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, estado: INACTIVO_PRESTADO, activo: false
//id Ejemplar: 41, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, estado: INACTIVO_PRESTADO,activo: false
//id Ejemplar: 45, idIsbn: 7, Ulises, James Joyce, estado: INACTIVO_PRESTADO, activo: false BUILD SUCCESSFUL (total time: 3 seconds)
//*************************************************************************************************************************************
//METODO LIST OBTENER EJEMPLARES INACTIVOS_PRESTADOS
        /*  Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplaresPrestados()) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn: " + ejem.getIdIsbn());
            System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
             System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        }*/
//RESULTADO EXITOSO BUSCA LOS EJEMPLARES INACTIVOS_PRESTADOS run:
//id Ejemplar: 39, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: INACTIVO_PRESTADO, activo: false
//id Ejemplar: 40, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes, Titulo: Don Quijote de la Mancha, estado: INACTIVO_PRESTADO, activo: false
//id Ejemplar: 41, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: INACTIVO_PRESTADO, activo: false
//id Ejemplar: 45, idIsbn: 7, Ulises, James Joyce, Titulo: Ulises, estado: INACTIVO_PRESTADO, activo: false BUILD SUCCESSFUL (total time: 3 seconds)
//*********************************************************************************************************************
//METODO LIST OBTENER EJEMPLARES EN-REPARACION

        /* Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplaresEnReparacion()) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn: " + ejem.getIdIsbn());
            System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
             System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        }*/
//RESULTADO EXITOSO run: 
//id Ejemplar: 10, idIsbn: 25, Orgullo y Prejuicio Zombie, Jane JANE Austen, Titulo: Orgullo y Prejuicio Zombie, estado: EN_REPARACION, activo: true; 
//id Ejemplar: 13, idIsbn: 1, 1984, George Orwell, Titulo: 1984, estado: EN_REPARACION, activo: true;
//id Ejemplar: 22, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, Titulo: En busca del tiempo perdido, estado: EN_REPARACION, activo: true;
//id Ejemplar: 26, idIsbn: 13, Crónica de una muerte anunciada, Gabriel Garcia Marquez Titulo: Crónica de una muerte anunciada, estado: EN_REPARACION, activo: true; 
//id Ejemplar: 38, idIsbn: 17, Don Quijote de la Mancha, Miguel de Cervantes; Titulo: Don Quijote de la Mancha, estado: EN_REPARACION, activo: true; 
//id Ejemplar: 41, idIsbn: 6, Crimen y castigo, Fyodor Dostoevsky, Titulo: Crimen y castigo, estado: EN_REPARACION, activo: true BUILD SUCCESSFUL (total time: 3 seconds)
//*********************************************************************************************************************
//METODO LIST OBTENER EJEMPLARES DEVUELTOS
        /* Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplaresDevueltos()) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn: " + ejem.getIdIsbn());
            //System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
            System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        }*/
//RESULTADO EXITOSO BUSCA LOS EJEMPLARES DEVUELTOS
//run: id Ejemplar: 32, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DEVUELTO, activo: true
//*********************************************************************************************************************
//METODO OBTENER EJEMPLARES POR LIBRO
        /*Libro lib = new Libro();
        LibroData libData = new LibroData();
        LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        for (Ejemplar ejem : ejeData.obtenerEjemplaresPorLibro(5)) {
            System.out.println("id Ejemplar: " + ejem.getIdEjemplar());
            System.out.println("idIsbn: " + ejem.getIdIsbn());
            //System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejem.getEstado());
            System.out.println("activo: "+ejem.isActivo());
            System.out.println("--------------------------------");
        }*/
        //RESULTADO EXITOSO: run: 
//id Ejemplar: 19, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 20, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 21, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 22; idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 23, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 28, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 29, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 30, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true; 
//id Ejemplar: 31, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true;  
//id Ejemplar: 32, idIsbn: 5, En busca del tiempo perdido, Marcel Proust, estado: DISPONIBLE_BIBLIOTECA, activo: true BUILD SUCCESSFUL (total time: 3 seconds)
//***************************************************************************************************************************
//METODO OBTENER EJEMPLARES ACTIVOS

        /*EjemplarData ejeData = new EjemplarData();
    List<Libro> libros = ejeData.obtenerLibrosConEjemplaresActivos();

    for (Libro libro : libros) {
        System.out.println("idIsbn: " + libro.getIsbn());
        System.out.println("Titulo: " + libro.getTitulo());
        System.out.println("Estado: " + libro.isEstado()); // Utiliza el getter para obtener el estado
        System.out.println("--------------------------------");
    }
}*/
//RESULTADO run: 
//idIsbn: 1, Titulo: 1984, Estado: true; 
//idIsbn: 2, Titulo: Cien años de soledad, Estado: true;
//idIsbn: 3, Titulo: Matar a un ruiseñor, Estado: true; 
//idIsbn: 4; Titulo: El gran Gatsby,  Estado: true; 
//idIsbn: 5, Titulo: En busca del tiempo perdido, Estado: true
//idIsbn: 6, Titulo: Crimen y castigo, Estado: true; 
//idIsbn: 7, Titulo: Ulises, Estado: true; 
//idIsbn: 8, Titulo: Moby-Dick, Estado: true; 
//idIsbn: 9, Titulo: El corazon de las tinieblas, Estado: true; 
//idIsbn: 10, Titulo: Orgullo y PrejuicioEstado: true; 
//idIsbn: 11, Titulo: El hombre del viento, Estado: true; 
//idIsbn: 12, Titulo: Los juegos del hambre, Estado: true; 
//idIsbn: 13, Titulo: Crónica de una muerte anunciada, Estado: true; 
//idIsbn: 14, Titulo: Sapiens: De animales a dioses,  Estado: true, 
//idIsbn: 15, Titulo: La sombra del viento, Estado: true; 
//idIsbn: 16, Titulo: El hobbit, Estado: true; 
//idIsbn: 17, Titulo: Don Quijote de la Mancha, Estado: true; 
//idIsbn: 18, Titulo: Rayuela, Estado: true; 
//idIsbn: 19Titulo: La insoportable levedad del ser, Estado: true; 
//idIsbn: 20, Titulo: El extranjero, Estado: true; 
//idIsbn: 21, Titulo: El amor en los tiempos del colera, Estado: true; 
//idIsbn: 22, Titulo: La metamorfosis, Estado: true; 
//idIsbn: 23, Titulo: El retrato de Dorian Gray, Estado: true; 
//idIsbn: 24, Titulo: El cuento de la criada, Estado: true; 
//idIsbn: 25, Titulo: Orgullo y Prejuicio Zombie, Estado: true
//****************************************************************************************************************************       
//METODO List<Ejemplar> buscarEjemplaresPorTitulo(String titulo) 

        /*    EjemplarData ejeData = new EjemplarData(); // Asegúrate de tener una instancia válida

    // Define el título que deseas buscar
    String tituloBuscado = "Orgullo y prejuicio"; // Reemplaza con el título que quieras buscar
    
    List<Ejemplar> ejemplaresEncontrados = ejeData.buscarEjemplaresPorTitulo(tituloBuscado);

    if (ejemplaresEncontrados.isEmpty()) {
        System.out.println("No se encontraron ejemplares con el título: " + tituloBuscado);
    } else {
        for (Ejemplar ejemplar : ejemplaresEncontrados) {
            System.out.println("id Ejemplar: " + ejemplar.getIdEjemplar());
            System.out.println("idIsbn: " + ejemplar.getIdIsbn());
            //System.out.println("Titulo: "+ejem.getIdIsbn().getTitulo());
            System.out.println("estado: " + ejemplar.getEstado());
            System.out.println("Activo: "+ejemplar.isActivo());
            System.out.println("--------------------------------");  
        }
    }
}   */
        //RESULTADO EXITOSO BUSCA LOS LIBROS CON TITULO "ORGULLO Y PREJUICIO" run: 
//id Ejemplar: 6, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, Activo: true; 
//id Ejemplar: 7, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, Activo: true; 
//id Ejemplar: 8, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, Activo: true; 
//id Ejemplar: 10, idIsbn: 10, Orgullo y Prejuicio, Jane JANE Austen, estado: DISPONIBLE_BIBLIOTECA, Activo: true; BUILD SUCCESSFUL (total time: 3 seconds) 
//********************************************************************************************************************************************
//METODO CONTAR EJEMPLARES
        /*     EjemplarData ejeData = new EjemplarData();

// Luego, elige un idIsbn para contar los ejemplares disponibles.
        int idIsbn = 12; // Reemplaza 5 con el valor que desees.

        int contador = ejeData.contarEjemplaresDisponibles(idIsbn);

        System.out.println("Cantidad de ejemplares disponibles para el idIsbn " + idIsbn + " Nº : " + contador);

// Suponiendo que tienes una lista de ejemplares
        List<Ejemplar> ejemplares = ejeData.obtenerEjemplaresPorLibro(idIsbn);

        for (Ejemplar ejemplar : ejemplares) {
            System.out.println("id Ejemplar: " + ejemplar.getIdEjemplar());
            System.out.println("idIsbn: " + ejemplar.getIdIsbn());
            //System.out.println("Titulo: "+ejemplar.getIdIsbn().getTitulo());
            System.out.println("Estado: " + ejemplar.getEstado());
            System.out.println("Activo: " + ejemplar.isActivo());
            System.out.println("--------------------------------");
        } */
//RESULTADO EXITOSO BUSCA LA CANTIDAD DE EJEMPLARES run: Cantidad de ejemplares disponibles para el idIsbn 12 Nº : 2
//id Ejemplar: 46, idIsbn: 12, Los juegos del hambre, Suzanne Collins, estado: DISPONIBLE_BIBLIOTECA, Activo: true;
//id Ejemplar: 47, idIsbn: 12, Los juegos del hambre, Suzanne Collins, estado: DISPONIBLE_BIBLIOTECA, Avtivo: true;  BUILD SUCCESSFUL (total time: 3 seconds)
////*********************************************************************************************************************************************
//******************************************************************************************************************************************
        //METODO ACTIVAR EJEMPLAR QUE SE ENCUENTRA INACTIVO
        // Supongamos que tienes una instancia válida de la clase donde se encuentra tu método activarEjemplar.
        /* EjemplarData ejeData = new EjemplarData();

    // Llamamos al método para activar un ejemplar (reemplaza 1 con el ID del ejemplar que deseas activar).
    int idEjemplarAActivar = 40;
    ejeData.activarEjemplar(idEjemplarAActivar);
}*/
//RESULTADO EXITOSO: EL EJEMPLAR CON ID 40 EL EJEMPLAR SE ACTIVO CON EXITO ("El Ejemplar se activó y cambió su estado con éxito.");
//40, 17, DISPONIBLE_BIBLIOTECA, 1
//**************************************************************************************************************************************
//METODO DESACTIVAR LECTOR QUE SE ENCUENTRA ACTIVO

        /*    EjemplarData ejeData = new EjemplarData();

        // Luego, llama al método desactivarEjemplar con el ID de un ejemplar que deseas desactivar.
        int idEjemplarADesactivar = 25; // Reemplaza con el ID del ejemplar que deseas desactivar.
        ejeData.desactivarEjemplar(idEjemplarADesactivar);
    }
}*/
//RESULTADO EXITOSO: EL EJEMPLAR CON ID 40 EL EJEMPLAR SE ACTIVO CON EXITO ("El Ejemplar se activó y cambió su estado con éxito.");
//40, 17, DISPONIBLE_BIBLIOTECA, 1
//**************************************************************************************************************************************
//
//////PROCEDIMIENTO PARA ACTUALIZAR EJEMPLARES DISPONIBLES
////*_____________________________________________________________________________
//    int idIsbn = 5; // Reemplaza con tu valor real
//    int cantidadEjemplaresDisponibles = 10; // Reemplaza con tu valor real
//
//    // Llama a buscarEjemplarPorCodigoIsbn para obtener el idIsbn
//    EjemplarData ejeData = new EjemplarData();
//    Ejemplar ejemplar = ejeData.buscarEjemplarXIsbn(idIsbn);
//
//    if (ejemplar != null) {
//        // Ahora que tienes el idIsbn y la nueva cantidad, llama a actualizarEjemplaresDisponibles
//        ejeData.actualizarEjemplaresDisponibles(idIsbn, cantidadEjemplaresDisponibles);
//    }
//
//
//}
//***************************************************************************************************************************
//***********************************************************************************************************************
//METODO PARA BORRAR EJEMPLARES

        /* LibroData libData = new LibroData();
LectorData lecData = new LectorData();
EjemplarData ejeData = new EjemplarData();
ejeData.borrarEjemplar(49, 6); */
//FUNCIONA CORRECTAMENTE BORRA FISICAMENTE EL EJEMPLAR 49, ID ISBN 6 ESTADO "REPARACION"
//***************************************************************************************************************************
//metodo obtenerPrestamosPorLector(int id)
/*PrestamoData presData=new PrestamoData();
Prestamo pres=new Prestamo();
presData.obtenerPrestamosPorLector(21);
        System.out.println(presData.obtenerPrestamosPorLector(21));
*/
//Resultado run:run:
//Prestamo{idPrestamo=21, fechaPrestamo=2023-05-11, fechaDevolucion=2023-06-11, ejemplar=Ejemplar{idEjemplar=10, idIsbn=Orgullo y Prejuicio, idIsbnInt=0, estado=DISPONIBLE_BIBLIOTECA, activo=true}, lector=martinez juan pablo, estado=DISPONIBLE_BIBLIOTECA} BUILD SUCCESSFUL (total time: 3 seconds)

//*************************************************************************************************************************************************************
//METODO GUARDAR PRESTAMO
        // Crea un objeto 'Prestamo' con los datos necesarios para la inserción.

        /*  Prestamo prestamo = new Prestamo();
    
    // Establece los datos del préstamo (reemplaza estos valores con los datos reales).
    prestamo.setIdPrestamo(0); // Reemplaza con el ID del préstamo (o 0 si es autoincremental).
    prestamo.setFechaPrestamo("2023-05-14"); // Fecha de inicio del préstamo.
    prestamo.setFechaDevolucion("2023-05-18"); // Fecha de devolución.
    prestamo.setEstado(EstadoEjemplar.INACTIVO_PRESTADO); // Estado del préstamo.
    // A continuación, crea un lector y un ejemplar para el préstamo (simplemente para ilustrar).
    Lector lector = new Lector();
    lector.setIdLector(5); // Reemplaza con el ID del lector que deseas buscar.

    Ejemplar ejemplar = new Ejemplar();
    ejemplar.setIdEjemplar(12); // Reemplaza con el ID del ejemplar que deseas buscar.

    // Asigna el lector y el ejemplar al préstamo.
    prestamo.setLector(lector);
    prestamo.setEjemplar(ejemplar);

    // Llama al método para guardar el préstamo en la base de datos.
    PrestamoData presData = new PrestamoData(); 
    presData.guardarPrestamo(prestamo);  
    
    }
        //RESULTADO EXITOSO GUARDA EL PRESTAMO (ID 2, LECTOR 1,ISBN 10; "2023-05-11", "2023-06-11", 1)

//************************************************************************************************************************
//METODO EFECTUAR PRESTAMO //DESCUENTA EJEMPLAR PRESTADO LO MUESTRA INACTIVO_PRESTADO EN LA BASE DE DATOS
        // Crea un objeto 'Prestamo' con los datos necesarios para la inserción.

      /*  Prestamo prestamo = new Prestamo();
    
    // Establece los datos del préstamo (reemplaza estos valores con los datos reales).
    prestamo.setIdPrestamo(0); // Reemplaza con el ID del préstamo (o 0 si es autoincremental).
    prestamo.setFechaPrestamo("2023-05-14"); // Fecha de inicio del préstamo.
    prestamo.setFechaDevolucion("2023-05-18"); // Fecha de devolución.
    prestamo.setEstado(EstadoEjemplar.INACTIVO_PRESTADO); // Estado del préstamo.
    // A continuación, crea un lector y un ejemplar para el préstamo (simplemente para ilustrar).
    Lector lector = new Lector();
    lector.setIdLector(5); // Reemplaza con el ID del lector que deseas buscar.

    Ejemplar ejemplar = new Ejemplar();
    ejemplar.setIdEjemplar(12); // Reemplaza con el ID del ejemplar que deseas buscar.

    // Asigna el lector y el ejemplar al préstamo.
    prestamo.setLector(lector);
    prestamo.setEjemplar(ejemplar);

    // Llama al método para guardar el préstamo en la base de datos.
    PrestamoData presData = new PrestamoData(); 
    presData.efectuarPrestamo(prestamo);  
    
    }*/
        //RESULTADO EXITOSO GUARDA EL PRESTAMO (idPrestamo 28, 5, 12, "2023-05-14", "2023-05-18", INACTIVO_PRESTADO)
//*************************************************************************************************************************************************************
//METODO DEVOLVER PRESTAMO //ACTIVA EL EJEMPLAR PRESTADO, LO MUESTRA ACTIVO DISPOBIBLE_BIBLIOTECA PARA SER PRESTADO EN LA BASE DE DATOS
        /* Prestamo prestamo = new Prestamo();
    prestamo.setIdPrestamo(1); 
    prestamo.setFechaDevolucion("2023-10-15"); 
    prestamo.setEstado(EstadoPrestamo.DEVUELTO); 


    // Crear una instancia de Prestamo con los valores necesarios para actualizar
    int idPrestamoActualizar = 28; 
    int idLector = 5; 
    int idEjemplar = 12; 
    String fechaPrestamo = "2023-05-14"; 
    String fechaDevolucion = "2023-05-28"; 
    EstadoEjemplar estado = EstadoEjemplar.DISPONIBLE_BIBLIOTECA; 

    // Llama a actualizarPrestamo
    PrestamoData presData = new PrestamoData(); 
    presData.actualizarPrestamo(idPrestamoActualizar, idLector, idEjemplar, fechaPrestamo, fechaDevolucion, estado);
    } */
        //RESULTADO EXITOSO MODIFICA EL ESTADO DEL PRESTAMO Y REACTIVA EL EJEMPLAR (idPrestamo 28, 5, 12, "2023-05-14", "2023-05-28", DISPONIBLE_BIBLIOTECA)
//*************************************************************************************************************************************************************
        //METODO ACTUALIZAR PRESTAMO
        /* PrestamoData prestamoData = new PrestamoData(); // Asegúrate de que esta instancia esté conectada a tu base de datos

    int idPrestamos = 19; // Reemplaza con el ID del prestamo que deseas actualizar
    int idLector = 4; // Reemplaza con el nuevo ID de Lector
    int idEjemplar = 7; // Reemplaza con el nuevo ID de Ejemplar
    String fechaPrestamo = "2023-09-10"; // Reemplaza con la nueva fecha de prestamo
    String fechaDevolucion = "2023-09-25"; // Reemplaza con la nueva fecha de devolución
    EstadoEjemplar estado = EstadoEjemplar.DEVUELTO; // Reemplaza con el nuevo estado

    prestamoData.actualizarPrestamo(idPrestamos, idLector, idEjemplar, fechaPrestamo, fechaDevolucion, estado); */
//RESULTADO EXITOSO: (19, 4, 7, "2023-09-10", "2023-09-25", Devuelto)
//*******************************************************************************************************************+
//BORRAR PRESTAMO DE FORMA FISICA

        /* LectorData lecData = new LectorData();
EjemplarData ejeData = new EjemplarData();
PrestamoData presData=new PrestamoData();

Lector Portales =lecData.buscarLector(9);
Ejemplar Gatsby=ejeData.buscarEjemplar(15);
Prestamo prestamo=new Prestamo("2023-05-11", "2023-06-28", Gatsby,  Portales, EstadoPrestamo.DEVUELTO);
presData.borrarPrestamoFisico(19, 4, 7); */
//RESULTADO EXITOSO BORRA FISICAMENTE EL PRESTAMO ID 19 Prestamo(19, 4, 7);
//**********************************************************************************************************************
//METODO OBTENER LISTA DE TODOS LOS PRESTAMOS
        // Crear instancias de LectorData y EjemplarData
        /*     LectorData lecData = new LectorData();
    EjemplarData ejeData = new EjemplarData();
    PrestamoData presData=new PrestamoData();

    // Llamar al método obtenerPrestamos para obtener la lista de prestamos
    List<Prestamo> prestamos = presData.obtenerPrestamos();
//comprobaciones para asegurarte de que los objetos no sean nulos antes de intentar acceder a sus propiedades
//Para evitar el error NullPointerException se produce cuando estás intentando acceder a una propiedad de un objeto que es nulo.
   
for (Prestamo prestamo : prestamos) {
    System.out.println("ID del Prestamo: " + prestamo.getIdPrestamo());

    Lector lector = prestamo.getLector();
    if (lector != null) {
        System.out.println("ID del Lector: " + lector.getIdLector());
    } else {
        System.out.println("Lector no encontrado.");
    }

    Ejemplar ejemplar = prestamo.getEjemplar();
    if (ejemplar != null) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        Libro libro = ejemplar.getIdIsbn();
        if (libro != null) {
            System.out.println("ID ISBN: " + libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    } else {
        System.out.println("Ejemplar no encontrado.");
    }

    System.out.println("Fecha de Prestamo: " + prestamo.getFechaPrestamo());
    System.out.println("Fecha de Devolución: " + prestamo.getFechaDevolucion());
    System.out.println("Estado: " + prestamo.getEstado());
    System.out.println("------------------------------");

        }  */
        //RESULTADO EXITOSO: run: 
//ID del Prestamo: 19, ID del Lector: 8, ID del Ejemplar: 7, ID ISBN: Orgullo y Prejuicio, Fecha de Prestamo: 2023-09-10, Fecha de Devolución: 2023-09-25, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 20, ID del Lector: 11, ID del Ejemplar: 24, ID ISBN: Crónica de una muerte anunciada, Fecha de Prestamo: 2023-10-15, Fecha de Devolución: 2023-10-19, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 21, ID del Lector: 1, ID del Ejemplar: 10, ID ISBN: Orgullo y Prejuicio, Fecha de Prestamo: 2023-05-11, Fecha de Devolución: 2023-06-11, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 25, ID del Lector: 6, ID del Ejemplar: 14, ID ISBN: 1984, Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 26, ID del Lector: 7, ID del Ejemplar: 12, ID ISBN: Orgullo y Prejuicio Zombie, Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 27, ID del Lector: 8, ID del Ejemplar: 15, ID ISBN: El gran Gatsby, Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA BUILD SUCCESSFUL (total time: 3 seconds)
//********************************************************************************************************************************************************************
////METODO OBTENER LISTA DE PRESTAMOS POR ID LECTOR

        /* LectorData lecData = new LectorData();
    EjemplarData ejeData = new EjemplarData();
    PrestamoData presData=new PrestamoData();

    // Llama al método para obtener la lista de préstamos
    List<Prestamo> prestamos = presData.obtenerPrestamosPorLector(11);
    
    //comprobaciones para asegurarte de que los objetos no sean nulos antes de intentar acceder a sus propiedades
//Para evitar el error NullPointerException se produce cuando estás intentando acceder a una propiedad de un objeto que es nulo.
   
for (Prestamo prestamo : prestamos) {
    System.out.println("ID del Prestamo: " + prestamo.getIdPrestamo());

    Lector lector = prestamo.getLector();
    if (lector != null) {
        System.out.println("ID del Lector: " + lector.getIdLector());
    } else {
        System.out.println("Lector no encontrado.");
    }

    Ejemplar ejemplar = prestamo.getEjemplar();
    if (ejemplar != null) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        Libro libro = ejemplar.getIdIsbn();
        if (libro != null) {
            System.out.println("ID ISBN: " + libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    } else {
        System.out.println("Ejemplar no encontrado.");
    }

    System.out.println("Fecha de Prestamo: " + prestamo.getFechaPrestamo());
    System.out.println("Fecha de Devolución: " + prestamo.getFechaDevolucion());
    System.out.println("Estado: " + prestamo.getEstado());
    System.out.println("------------------------------");

        } */
//RESULTADO EXITOSO BUSCA LOS PRESTAMOS DEL LECTOR 11: run:
//ID del Prestamo: 20, ID del Lector: 11, ID del Ejemplar: 24, ID ISBN: Crónica de una muerte anunciada, Fecha de Prestamo: 2023-10-15, Fecha de Devolución: 2023-10-19, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 25, ID del Lector: 11, ID del Ejemplar: 14, ID ISBN: 1984, Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 26, ID del Lector: 11, Ejemplar no encontrado,Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA BUILD SUCCESSFUL (total time: 6 seconds)
//********************************************************************************************************************************************
//METODO CONTAR EJEMPLARES

        /*PrestamoData presData=new PrestamoData();
         //Ejemplar eje = new Ejemplar();
         Prestamo pres = new Prestamo(); 
         EjemplarData ejeData = new EjemplarData();
         
// Luego, elige un idLector para contar los ejemplares disponibles.
int idLector = 11; // Reemplaza 5 con el valor que desees.

int contador = presData.contarPrestamosXLector(idLector);

System.out.println("Cantidad de Prestamos disponibles para el Lector " + idLector + " Nº : " + contador);

//  lista de Prestamos
// Llama al método para obtener la lista de préstamos
    List<Prestamo> prestamos = presData.obtenerPrestamosPorLector(11);
    //comprobaciones para asegurarte de que los objetos no sean nulos antes de intentar acceder a sus propiedades
//Para evitar el error NullPointerException se produce cuando estás intentando acceder a una propiedad de un objeto que es nulo.
   
for (Prestamo prestamo : prestamos) {
    System.out.println("ID del Prestamo: " + prestamo.getIdPrestamo());

    Lector lector = prestamo.getLector();
    if (lector != null) {
        System.out.println("ID del Lector: " + lector.getIdLector());
    } else {
        System.out.println("Lector no encontrado.");
    }

    Ejemplar ejemplar = prestamo.getEjemplar();
    if (ejemplar != null) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        Libro libro = ejemplar.getIdIsbn();
        if (libro != null) {
            System.out.println("ID ISBN: " + libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    } else {
        System.out.println("Ejemplar no encontrado.");
    }

    System.out.println("Fecha de Prestamo: " + prestamo.getFechaPrestamo());
    System.out.println("Fecha de Devolución: " + prestamo.getFechaDevolucion());
    System.out.println("Estado: " + prestamo.getEstado());
    System.out.println("------------------------------");

        } */
        //RESULTADO EXITOSO BUSCA LOS PRESTAMOS ASOCIADOS AL LECTOR ID 11: run: //Cantidad de Prestamos disponibles para el Lector 11 Nº : 3
//ID del Prestamo: 20, ID del Lector: 11, ID del Ejemplar: 24, ID ISBN: Crónica de una muerte anunciada, Fecha de Prestamo: 2023-10-15, Fecha de Devolución: 2023-10-19, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 25, ID del Lector: 11, ID del Ejemplar: 14, ID ISBN: 1984, Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA
//ID del Prestamo: 26, ID del Lector: 11, Ejemplar no encontrado., Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18, Estado: DISPONIBLE_BIBLIOTECA    BUILD SUCCESSFUL (total time: 5 seconds)
////********************************************************************************************************************************************
//METODO FECHA ACTUAL

       /* Date fecha=new Date();
       SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(formatoFecha.format(fecha)); */
//RESULTADO EXITOSO run: 2023-10-22 BUILD SUCCESSFUL (total time: 4 seconds)
//******************************************************************************************************
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//METODO LISTAR LOS LECTORES A LOS QUE SE LES VENCIO EL PRESTAMO 

/*Prestamo pres=new Prestamo();
Lector lec =new Lector();
LectorData lecData=new LectorData();
PrestamoData presData = new PrestamoData();

    // Define la fecha a partir de la cual deseas buscar préstamos vencidos
    String fechaDevolucion = "2023-10-23"; // Asegúrate de que esta fecha esté en el formato correcto

    // Llama al método para obtener los lectores con préstamos vencidos
    List<Integer> lectoresVencidos = presData.obtenerLectoresConPrestamosVencidos(fechaDevolucion);
//    
//    int idLector=0;
//    idLector = lecData.buscarLector(0);

    if (!lectoresVencidos.isEmpty()) {
        
        System.out.println("Lectores con préstamos vencidos después de " + fechaDevolucion + ":");
        for (int idLector : lectoresVencidos) {
            System.out.println("ID del Lector: " + idLector);
            System.out.println("-------------------------");
        }
    } else {
        System.out.println("No se encontraron lectores con préstamos vencidos después de " + fechaDevolucion);
    }
}*/

//RESULTADO DE LA BUSQUEDA DE ID LECTORES QUE SE LES VENCIO EL PRESTAMO run:
//Lectores con préstamos vencidos después de 2023-10-23:
//ID del Lector: 5
//ID del Lector: 5 BUILD SUCCESSFUL (total time: 3 seconds)

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&666
//******************************************************************************************************
//METODO LISTAR FECHA DETERMINADA DE LOS PRESTAMOS  

      /*  LectorData lecData = new LectorData();
        EjemplarData ejeData = new EjemplarData();
        PrestamoData presData = new PrestamoData();

        // Especificar la fecha que deseas buscar
        String fechaPrestamo = "2023-10-15";

        // Llamar al método para obtener los prestamos para la fecha especificada
        List<Prestamo> prestamos = presData.listarFechaPrestamo(fechaPrestamo);
for (Prestamo prestamo : prestamos) {
    System.out.println("ID del Prestamo: " + prestamo.getIdPrestamo());

    Lector lector = prestamo.getLector();
    if (lector != null) {
        System.out.println("ID del Lector: " + lector.getIdLector());
    } else {
        System.out.println("Lector no encontrado.");
    }

    Ejemplar ejemplar = prestamo.getEjemplar();
    if (ejemplar != null) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        Libro libro = ejemplar.getIdIsbn();
        if (libro != null) {
            System.out.println("ID ISBN: " + libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    } else {
        System.out.println("Ejemplar no encontrado.");
    }

    System.out.println("Fecha de Prestamo: " + prestamo.getFechaPrestamo());
    System.out.println("Fecha de Devolución: " + prestamo.getFechaDevolucion());
    System.out.println("Estado: " + prestamo.getEstado());
    System.out.println("------------------------------");

        } */

//RESULTADO run:
//ID del Prestamo: 28, Lector no encontrado., Ejemplar no encontrado., Fecha de Prestamo: 2023-10-14, Fecha de Devolución: 2023-10-28, Estado: PRESTADO
//ID del Prestamo: 29, Lector no encontrado.,Ejemplar no encontrado.Fecha de Prestamo: 2023-10-14, Fecha de Devolución: 2023-10-29, Estado: PRESTADO BUILD SUCCESSFUL (total time: 7 seconds)

//run: ID del Prestamo: 20, ID del Lector: 11, ID del Ejemplar: 24, ID ISBN: Crónica de una muerte anunciada, Fecha de Prestamo: 2023-10-15, Fecha de Devolución: 2023-10-19 ,Estado: PRESTADO BUILD SUCCESSFUL (total time: 3 seconds)

//********************************************************************************************************************************************************************

//METODO OBTENER PRESTAMOS POR ID EJEMPLAR BUSCA UN EJEMPLAR ESPECIFICO POR SU NUMERO DE ID
/*
    LectorData lecData = new LectorData();
EjemplarData ejeData = new EjemplarData();
PrestamoData presData=new PrestamoData();

Lector Portales =lecData.buscarLector(4);
Ejemplar ulises=ejeData.buscarEjemplar(7);
//Prestamo prestamo=new Prestamo(18, "2023-09-10", "2023-09-20", ulises, Portales, "Devuelto");
for(Prestamo prestamo:presData.obtenerPrestamosPorEjemplar(15)){
    System.out.println("ID del Prestamo: " + prestamo.getIdPrestamo());

    Lector lector = prestamo.getLector();
    if (lector != null) {
        System.out.println("ID del Lector: " + lector.getIdLector());
    } else {
        System.out.println("Lector no encontrado.");
    }

    Ejemplar ejemplar = prestamo.getEjemplar();
    if (ejemplar != null) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        Libro libro = ejemplar.getIdIsbn();
        if (libro != null) {
            System.out.println("ID ISBN: " + libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    } else {
        System.out.println("Ejemplar no encontrado.");
    }

    System.out.println("Fecha de Prestamo: " + prestamo.getFechaPrestamo());
    System.out.println("Fecha de Devolución: " + prestamo.getFechaDevolucion());
    System.out.println("Estado: " + prestamo.getEstado());
    System.out.println("------------------------------");

        } */


//RESULTADO EXITOSO: run: 
//ID del Prestamo: 27, ID del Lector: 8, ID del Ejemplar: 15, ID ISBN: El gran Gatsby, Fecha de Prestamo: 2023-05-14, Fecha de Devolución: 2023-05-18 Estado: PRESTADO BUILD SUCCESSFUL (total time: 12 seconds)

//*******************************************************************************************************************************************
//OBTENER PRESTAMOS POR EJEMPLAR

    /*int idLector = 11;  // Reemplaza esto con el ID del lector deseado.

    // Luego, crea una instancia de tu Data Access Object (DAO) para Ejemplares.
    EjemplarData ejeData = new EjemplarData();

    // Llama al método para obtener los libros prestados por el lector.
    List<Ejemplar> librosPrestados = ejeData.obtenerLibrosPrestados(int idLector)){

    // Itera a través de los libros prestados y muestra la información.
    for (Ejemplar ejemplar : librosPrestados) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        System.out.println("ID ISBN: " + ejemplar.getIdIsbnInt());

        // Asegúrate de que tengas la enumeración 'EstadoEjemplar' con el método 'name' adecuadamente definido.
        System.out.println("Estado: " + ejemplar.getEstado().name());

        System.out.println("------------------------------");
    }
}*/
//********************************************************************************************************************************************
/*LectorData lecData = new LectorData();
EjemplarData ejeData = new EjemplarData();
PrestamoData presData=new PrestamoData();
    // Llamar al método para obtener los lectores con préstamos vencidos
    List<Lector> lectoresVencidos = presData.listarLectoresVencidos();

    // Iterar a través de la lista de lectores y mostrar la información
    for (Lector lector : lectoresVencidos) {
        System.out.println("ID Lector: " + lector.getIdLector());
        System.out.println("Nombre: " + lector.getNombre());
        System.out.println("DNI: " + lector.getDni());
    }
}*/
//RESULTADO EXITOSO: run:
//ID Lector: 11, Nombre: Martinez alba, DNI: 100
//ID Lector: 1, Nombre: Peralta Nicolas, DNI: 111
//ID Lector: 11, Nombre: Martinez alba, DNI: 100
//ID Lector: 11, Nombre: Martinez alba, DNI: 100
//ID Lector: 8, Nombre: Martinez Carlos, DNI: 888 BUILD SUCCESSFUL (total time: 3 seconds)


    //**********************************************************************************************************************************************
    //public void modificarPrestamo(Prestamo prestamo) {
 /*   LectorData lecData = new LectorData();
EjemplarData ejeData = new EjemplarData();
PrestamoData presData=new PrestamoData();




Lector Portales =lecData.buscarLector(11);
Ejemplar ulises=ejeData.buscarEjemplar(24);
//Prestamo prestamo=new Prestamo(18, "2023-09-10", "2023-09-20", ulises, Portales, "Devuelto");
for(Prestamo prestamo:presData.obtenerPrestamosPorEjemplar(18)){
    System.out.println("ID del Prestamo: " + prestamo.getIdPrestamo());

    Lector lector = prestamo.getLector();
    if (lector != null) {
        System.out.println("ID del Lector: " + lector.getIdLector());
    } else {
        System.out.println("Lector no encontrado.");
    }

    Ejemplar ejemplar = prestamo.getEjemplar();
    if (ejemplar != null) {
        System.out.println("ID del Ejemplar: " + ejemplar.getIdEjemplar());
        Libro libro = ejemplar.getIdIsbn();
        if (libro != null) {
            System.out.println("ID ISBN: " + libro.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }
    } else {
        System.out.println("Ejemplar no encontrado.");
    }

Prestamo prestamo=new Prestamo(20, "2023-03-15" , "2023-03-22", ejemplar, lector ,  "DISPONIBLE_BIBLIOTECA");


presData.modificarPrestamo(prestamo);
    
    */
    
   //***********************************************************************************************************************************************
    
    }


}