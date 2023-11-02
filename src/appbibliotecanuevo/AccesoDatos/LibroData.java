/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.AccesoDatos;


import appbibliotecanuevo.entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Otras
 */
public class LibroData {
    
    private Connection con = null;
    
    
  public LibroData() {
      
      con = Conexion.getConexion();
    
    }  
    
   public void guardarLibro(Libro libro){
   
       String sql= "INSERT INTO libro(titulo , autor , anio , genero , editorial , estado) VALUES (?, ?, ?, ?, ?, ?) ";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getGenero());
            ps.setString(5, libro.getEditorial());
            ps.setBoolean(6, libro.isEstado());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
            libro.setIsbn(rs.getInt(1));
           JOptionPane.showMessageDialog(null, "Libro Guardado Exitosamente"); 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla libro" + ex.getMessage());
        }
   
   } 
    
public Libro buscarLibroPorIdLibro(int idIsbn){

    Libro libro=null;
    
    String sql = "SELECT idIsbn, titulo, autor, anio, genero, editorial FROM libro WHERE idIsbn = ? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idIsbn);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
            libro = new Libro();
            libro.setIsbn(idIsbn);
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("Autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
  
            }else{
            JOptionPane.showMessageDialog(null, "No existe ese Libro");
            }
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
        }
        return libro;
}

public Libro buscarLibroPorTitulo(String titulo) {
    Libro libro = null;
    
    String sql = "SELECT idIsbn, titulo, autor, anio, genero, editorial, estado FROM libro WHERE titulo = ?";
//String sql="SELECT * FROM libro WHERE titulo LIKE ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, titulo);
        ResultSet rs = ps.executeQuery(); 
        if (rs.next()) {
            libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existe un libro con ese titulo.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return libro;
}

public Libro buscarLibroPorAnio(int anio) {
    Libro libro = null;
    
    String sql = "SELECT idIsbn, titulo, autor, anio, genero, editorial, estado FROM libro WHERE anio = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, anio);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(anio);
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existe un libro con ese año.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return libro;
}



public Libro buscarLibroPorGenero(String genero){

    Libro libro=null;
    
    String sql = "SELECT idIsbn, titulo, autor, anio, editorial, estado FROM libro WHERE genero = ? AND estado = 1 ";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, genero);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(genero);
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese Genero");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return libro;
}

public Libro buscarLibroPorAutor(String autor){

    Libro libro=null;
    
    String sql = "SELECT idIsbn, titulo, anio, genero, editorial, estado FROM libro WHERE autor = ? AND estado = 1 ";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, autor);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(autor);
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese Autor");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return libro;
}

public Libro buscarLibroPorEditorial(String editorial){

    Libro libro=null;
    
    String sql = "SELECT idIsbn, titulo, autor, anio, genero, estado FROM libro WHERE editorial = ? AND estado = 1 ";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, editorial);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(editorial);
            libro.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existe esa Editorial");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return libro;
}

public void modificarLibro(Libro libro){

String sql = "UPDATE libro SET titulo = ? , autor = ? , anio = ? , genero = ? , editorial = ?  WHERE idIsbn = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getAnio());
            ps.setString(4, libro.getGenero());
            ps.setString(5, libro.getEditorial());
            ps.setInt(6, libro.getIsbn());
            
                     int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Libro modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Libro buscado no existe. ");
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }


}

public List<Libro> listarLibro(){
ArrayList<Libro> libros = new ArrayList<>();

    String sql = "SELECT * FROM libro WHERE estado = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
           Libro libro = new Libro();
           libro.setIsbn(rs.getInt("idIsbn"));
           libro.setTitulo(rs.getString("Titulo"));
           libro.setAutor(rs.getString("Autor"));
           libro.setAnio(rs.getInt("anio"));
           libro.setGenero(rs.getString("Genero"));
           libro.setEditorial(rs.getString("Editorial"));
           libro.setEstado(true);
           
           libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
        }
        return libros;
}

public List<Libro> listarLibroxID(int isbn) {
    ArrayList<Libro> librosIsbn = new ArrayList<>();

    String sql = "SELECT idIsbn, titulo, autor, anio, genero, editorial FROM libro WHERE idIsbn = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, isbn); // Establece el valor de ISBN en la consulta
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Libro libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("Titulo"));
            libro.setAutor(rs.getString("Autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("Genero"));
            libro.setEditorial(rs.getString("Editorial"));
            libro.setEstado(true);

            librosIsbn.add(libro);
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }

    return librosIsbn;
}


public List<Libro> listarLibrosPorGenero(String genero) {
    List<Libro> listaLibros = new ArrayList<>();
    String sql = " SELECT * FROM libro WHERE genero LIKE ? ";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, genero); 
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Libro libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
            listaLibros.add(libro); // Agregamos el libro a la lista
        }

        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen libros con ese género.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return listaLibros;
}

//public List listarLibrosPorAutor(String autor) {
////    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
////    modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos.
//
//    List<Libro> listaAutores = new ArrayList<>();
//    String sql = "SELECT * FROM libro WHERE autor LIKE ?";
//    
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, autor);
//        ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//            Libro libro = new Libro();
//            libro.setIsbn(rs.getInt("idIsbn"));
//            libro.setTitulo(rs.getString("titulo"));
//            libro.setAutor(rs.getString("autor"));
//            libro.setAnio(rs.getInt("anio"));
//            libro.setGenero(rs.getString("genero"));
//            libro.setEditorial(rs.getString("editorial"));
//            libro.setEstado(true);
//            listaAutores.add(libro);
//        }
//
////        for (Libro libro : listaLibros) {
////            modelo.addRow(new Object[]{libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getAnio(), libro.getGenero(), libro.getEditorial(), libro.isEstado(), libro.getInformacion()});
////        }
//
//        if (listaAutores.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "No existen libros con ese autor.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
//    }
//    return listaAutores;
//}

public List<Libro> listarLibrosPorAutor(String autor) {
    List<Libro> listaLibros = new ArrayList<>();
    String sql = "SELECT idIsbn, titulo, autor, anio, genero, editorial FROM libro WHERE autor LIKE ? ";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + autor + "%");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("idIsbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(true);

                listaLibros.add(libro);
            }
        }

        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen libros con ese Autor.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }

    return listaLibros;
}

//public List<Libro> listarLibrosPorAutor(String autor) {
//    List<Libro> listaLibros = new ArrayList<>();
//    String sql = " SELECT * FROM libro WHERE autor LIKE ? ";
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, autor); 
//        ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//            Libro libro = new Libro();
//            libro.setIsbn(rs.getInt("idIsbn"));
//            libro.setTitulo(rs.getString("titulo"));
//            libro.setAutor(rs.getString("autor"));
//            libro.setAnio(rs.getInt("anio"));
//            libro.setGenero(rs.getString("genero"));
//            libro.setEditorial(rs.getString("editorial"));
//            libro.setEstado(true);
//            listaLibros.add(libro); // Agregamos el libro a la lista
//        }
//
//        if (listaLibros.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "No existen libros con ese Autor.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
//    }
//    return listaLibros;
//}

public List<Libro> listarLibrosPorEditorial (String editorial) {
    List<Libro> listaLibros = new ArrayList<>();
    String sql = "SELECT * FROM libro WHERE editorial = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, editorial);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Libro libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
            listaLibros.add(libro);
        }

        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen libros publicados con el nombre " + editorial + ".");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return listaLibros;
}



public List<Libro> listarLibrosPorAnioEdicion(int anio) {
    List<Libro> listaLibros = new ArrayList<>();
    String sql = "SELECT * FROM libro WHERE anio = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, anio);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Libro libro = new Libro();
            libro.setIsbn(rs.getInt("idIsbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(rs.getString("autor"));
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(true);
            listaLibros.add(libro);
        }

        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen libros publicados en el año " + anio + ".");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro. " + ex.getMessage());
    }
    return listaLibros;
}

public void eliminarLibroLogico(int id){

    String sql = "UPDATE libro SET estado = false WHERE idIsbn = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Libro Eliminado Exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún Libro con el ID proporcionado.");
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro: " + ex.getMessage());
    }
}

public void eliminarLibro(int id){

 String sql = " UPDATE libro SET estado = 0 WHERE idIsbn = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Libro Eliminado Exitosamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Libro"+ex.getMessage());
        }

}
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

   
}
