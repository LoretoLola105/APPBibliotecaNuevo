/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.AccesoDatos;


import appbibliotecanuevo.entidades.Lector;
import appbibliotecanuevo.entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Otras
 */
public class LectorData {

    private Connection con = null;

    public LectorData() {
        con = Conexion.getConexion();
    }

    public void guardarLector(Lector lector) {

        String sql = "INSERT INTO lector(nombre, dni, domicilio, email, telefono, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, lector.getNombre());
            ps.setInt(2, lector.getDni());
            ps.setString(3, lector.getDomicilio());
            ps.setString(4, lector.getEmail());
            ps.setInt(5, lector.getNumeroTel());
            ps.setBoolean(6, true); // if reducido
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                lector.setIdLector(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Lector Guardado con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Lector" + ex.getMessage());

        }

    }

    public Lector buscarLector(int id) {
     
        
        String sql = "SELECT nombre, dni, domicilio, email, telefono, estado FROM lector "
                + "WHERE  idLector = ? AND estado = 1";
   Lector lector = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);//reemplaza en signo de pregunta por el id
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lector = new Lector();//se utiliza el constructor vacio para crear un nuevo alumno
                lector.setIdLector((id));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setEmail(rs.getString("email"));
                lector.setNumeroTel(rs.getInt("telefono"));
                lector.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese lector");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Lector " + ex.getMessage());

        }
        return lector;

    }

    public Lector buscarLectorPorDni(int dni) {

        String sql = "SELECT idLector, nombre, dni, domicilio, email,  telefono, estado FROM lector WHERE dni = ? AND estado = 1";

        Lector lector = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                lector = new Lector();
                lector.setIdLector(rs.getInt("idLector"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setEmail(rs.getString("email"));
                lector.setNumeroTel(rs.getInt("telefono"));
                lector.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Lector");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Lector " + ex.getMessage());
        }
        return lector;
    }

    public List<Lector> listarLectores() {
        ArrayList<Lector> lectores = new ArrayList<>();
        String sql = "SELECT idLector, nombre, dni, domicilio, email, telefono, estado FROM lector WHERE estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Lector lector = new Lector();
                lector.setIdLector(rs.getInt("idLector"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setEmail(rs.getString("email"));
                lector.setNumeroTel(rs.getInt("telefono"));
                lector.setEstado(true);

                lectores.add(lector);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return lectores;
    }

    public List<Lector> listarLectoresInactivos() {
        ArrayList<Lector> lectoresInactivos = new ArrayList<>();
        String sql = "SELECT idLector, nombre, dni, domicilio, email, telefono, estado FROM lector WHERE estado = 0";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Lector lector = new Lector();
                lector.setIdLector(rs.getInt("idLector"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setEmail(rs.getString("email"));
                lector.setNumeroTel(rs.getInt("telefono"));
                lector.setEstado(true);

                lectoresInactivos.add(lector);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return lectoresInactivos;
    }


    public void modificarLector(Lector lector) {
 
        String sql ="UPDATE lector SET nombre = ? , dni = ? , domicilio = ? , email = ? ,  telefono = ? , estado = ? "
                + "WHERE idLector = ?";
if (lector != null) 
 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, lector.getNombre());
            ps.setInt(2, lector.getDni());
            ps.setString(3, lector.getDomicilio());
            ps.setString(4, lector.getEmail());
            ps.setInt(5, lector.getNumeroTel());
            ps.setBoolean(6, lector.getEstado());
           ps.setInt(7, lector.getIdLector());
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
            
           JOptionPane.showMessageDialog(null, "Lector Modificado Exitosamente.");
            
            }    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Lector " + ex.getMessage());
        }

    }

    public void eliminarLector(int idLector) {
        String sql = " UPDATE lector SET estado = 0 WHERE idLector = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Lector Eliminado con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Lector" + e.getMessage());
        }

    }
    
    public void activarLector(int idLector) {
    // Primero, verifica si el lector ya está activo.
    if (estaActivo(idLector)) {
        JOptionPane.showMessageDialog(null, "El lector ya está activo en la lista de lectores de la biblioteca.");
        return; // No es necesario continuar.
    }
    
    // Si el lector no está activo, procede con la activación.
    String sql = "UPDATE lector SET estado = 1 WHERE idLector = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idLector);
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Lector Activado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún lector con el ID proporcionado.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Lector: " + ex.getMessage());
    }
}

// Método para verificar si el lector ya está activo.
private boolean estaActivo(int idLector) {
    // Realiza una consulta para verificar el estado del lector.
    String sql = "SELECT estado FROM lector WHERE idLector = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idLector);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int estado = rs.getInt("estado");
            return estado == 1;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return false; // Si hay un error, devuelve false por precaución.
}

 public void desactivarLector(int idLector) {
    // Verifica si el lector ya está inactivo.
    if (!estaActivo(idLector)) {
        JOptionPane.showMessageDialog(null, "El lector ya está inactivo en la lista de lectores de la biblioteca.");
        return; // No es necesario continuar.
    }
    
    // Si el lector está activo, procede con la desactivación.
    String sql = "UPDATE lector SET estado = 0 WHERE idLector = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idLector);
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Lector Desactivado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún lector con el ID proporcionado.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Lector: " + ex.getMessage());
    }
}

//   SELECT p.idPrestamos, p.idLector, p.idEjemplar, p.fechaPrestamo, p.fechaDevolucion
//FROM prestamos p
//INNER JOIN ejemplar e ON p.idEjemplar = e.idEjemplar
//INNER JOIN libro l ON e.idIsbn = l.idIsbn
//WHERE p.idLector = 3
//  AND p.fechaDevolucion < CURDATE();



 public ArrayList<Libro> obtenerLibrosSolicitados(int idLector) {

        ArrayList<Libro> librosSolicitados = new ArrayList<>();
        String sql = "SELECT p.idPrestamos, p.idLector, p.idEjemplar, p.fechaPrestamo, p.fechaDevolucion "
                + "FROM prestamos "
                + "INNER JOIN ejemplar e ON p.idEjemplar = e.idEjemplar "
                + "INNER JOIN libro l ON e.idIsbn = l.idIsbn WHERE p.idLector = ? " ;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Libro libro = new Libro();
                libro.setIsbn(rs.getInt("idIsbn"));
                libro.setTitulo(rs.getString("Titulo"));
                libro.setAutor(rs.getString("Autor"));
                libro.setAnio(rs.getInt("Año"));
                libro.setGenero(rs.getString("Genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(true);
                
                librosSolicitados.add(libro);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamo");
        }
        return librosSolicitados;
    }

 /*   public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();

//    String sql="SELECT * "
//            + "FROM materia "
//            + "WHERE estado = 1 "
//            + "AND idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)"; 
//     
        String sql = "SELECT * "
                + "FROM materia "
                + "WHERE idMateria "
                + "NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return materias;
    }

*/


 
     
}
