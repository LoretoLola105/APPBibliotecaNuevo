/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.AccesoDatos;

import appbibliotecanuevo.entidades.Ejemplar;
import appbibliotecanuevo.entidades.EstadoEjemplar;
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
public class EjemplarData {

    private Connection con = null;
    private LibroData libData = new LibroData();
    private LectorData lecData = new LectorData();

    public EjemplarData() {
        con = Conexion.getConexion();

    }

    public Ejemplar buscarEjemplar(int idEjemplar) {
    String sql = "SELECT idIsbn, estado, activo FROM ejemplar WHERE idEjemplar = ? AND estado = 'DISPONIBLE_BIBLIOTECA' AND activo = 1";
    Ejemplar ejemplar = null;
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idEjemplar);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            ejemplar = new Ejemplar();
            ejemplar.setIdEjemplar(idEjemplar);
            Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                ejemplar.getIdIsbnInt();
                ejemplar.setIdIsbn(lib);
                ejemplar.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                ejemplar.setActivo(true);

           
        } else {
            JOptionPane.showMessageDialog(null, "No existe un ejemplar con ese Número de ID en estado 'disponible_biblioteca'.");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar: " + ex.getMessage());
    }
    
    return ejemplar;
}
    
    
    public void guardarEjemplar(Ejemplar ejemplar) {
        String sql = "INSERT INTO ejemplar(idEjemplar, idIsbn, estado, activo) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ejemplar.getIdEjemplar());
            ps.setInt(2, ejemplar.getIdIsbn().getIsbn());
            //ps.setInt(2, ejemplar.getIdIsbnInt());// Asigna el valor int directamente
            //ps.setString(3, ejemplar.getEstado());
            ps.setString(3, ejemplar.getEstado().name());
            ps.setBoolean(4, true);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ejemplar.setIdEjemplar(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplar Guardado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
    }

    public void actualizarEjemplar(int idEjemplar, int idIsbn, EstadoEjemplar estado, boolean activo) {

        String sql = "UPDATE ejemplar SET estado = ? , activo = ? WHERE idEjemplar = ? AND idIsbn = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estado.name()); // Convierte el enum a su nombre (cadena)
            ps.setInt(2, idEjemplar);
            ps.setInt(3, idIsbn);
            ps.setBoolean(4, activo);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Ejemplar Actualizado con Éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
    }

    public List<Ejemplar> obtenerEjemplares() {
        ArrayList<Ejemplar> solicitados = new ArrayList<>();

        String sql = "SELECT * FROM ejemplar ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                eje.setActivo(true);
                solicitados.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }

        return solicitados;
    }
    
    public List<Ejemplar> obtenerEjemplaresActivos() {
        ArrayList<Ejemplar> activos = new ArrayList<>();

        String sql = "SELECT * FROM `ejemplar` WHERE activo = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                eje.setActivo(true);
                activos.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return activos;
    }

public List<Ejemplar> obtenerEjemplaresInactivos() {
        ArrayList<Ejemplar> inactivosPrestados = new ArrayList<>();

        String sql = "SELECT * FROM `ejemplar` WHERE activo = 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.INACTIVO_PRESTADO);
                eje.setActivo(false);
                inactivosPrestados.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return inactivosPrestados;
    }

    public List<Ejemplar> obtenerEjemplaresPrestados() {
        ArrayList<Ejemplar> prestados = new ArrayList<>();

        String sql = "SELECT * FROM `ejemplar` WHERE estado = 'INACTIVO_PRESTADO'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.INACTIVO_PRESTADO);
                eje.setActivo(false);
                prestados.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return prestados;
    }

    public List<Ejemplar> obtenerEjemplaresEnReparacion() {
        ArrayList<Ejemplar> reparados = new ArrayList<>();

        String sql = "SELECT * FROM ejemplar WHERE estado = 'en_reparacion'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.EN_REPARACION);
                 eje.setActivo(true);
                reparados.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return reparados;
    }

    public List<Ejemplar> obtenerEjemplaresDevueltos() {
        ArrayList<Ejemplar> devueltos = new ArrayList<>();

        String sql = "SELECT * FROM `ejemplar` WHERE estado = 'devuelto' ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.DEVUELTO);
                 eje.setActivo(true);
                devueltos.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return devueltos;
    }

    public List<Ejemplar> obtenerEjemplaresPorLibro(int idIbsn) {
        ArrayList<Ejemplar> cargados = new ArrayList<>();

        String sql = "SELECT * FROM ejemplar WHERE idIsbn = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idIbsn);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
                eje.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                 eje.setActivo(true);
                cargados.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return cargados;
    }

    public List<Libro> obtenerLibrosConEjemplaresActivos() {
        ArrayList<Libro> libros = new ArrayList<>();

        String sql = "SELECT libro.idIsbn, libro.titulo, libro.autor, libro.anio, libro.genero, libro.editorial, libro.estado "
                + "FROM libro "
                + "WHERE libro.estado = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro lib = new Libro();
                lib.setIsbn(rs.getInt("idIsbn"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setAnio(rs.getInt("anio"));
                lib.setGenero(rs.getString("genero"));
                lib.setEditorial(rs.getString("editorial"));
                lib.setEstado(rs.getBoolean("estado"));

                libros.add(lib);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro: " + ex.getMessage());
        }
        return libros;
    }

    public List<Libro> obtenerLibroPorEjemplar(int idIsbn) {
        ArrayList<Libro> librosEjemplares = new ArrayList<>();

        String sql = "SELECT libro.idIsbn, libro.titulo, libro.autor, libro.anio, libro.genero, libro.editorial, libro.estado "
                + "FROM ejemplar "
                + "INNER JOIN libro libro ON ejemplar.idIsbn = libro.idIsbn "
                + "WHERE ejemplar.idEjemplar = ? AND libro.estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idIsbn);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Libro lib = new Libro();
                lib.setIsbn(rs.getInt("idIsbn"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setAnio(rs.getInt("anio"));
                lib.setGenero(rs.getString("genero"));
                lib.setEditorial(rs.getString("editorial"));
                lib.setEstado(rs.getBoolean("estado"));
                librosEjemplares.add(lib);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
        return librosEjemplares;
    }

    
    
public Ejemplar buscarEjemplarXIsbn(int idIsbn) {
    String sql = "SELECT idEjemplar, idIsbn, estado, activo FROM ejemplar WHERE  idIsbn = ? AND estado = 'disponible_biblioteca' AND activo = 1 ";
    Ejemplar ejemplar = null;
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idIsbn);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            ejemplar = new Ejemplar();
            ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
            ejemplar.setIdIsbnInt(rs.getInt("idIsbn"));            
            Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                ejemplar.getIdIsbnInt();
                ejemplar.setIdIsbn(lib);
                ejemplar.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                ejemplar.setActivo(true);

           
        } else {
            JOptionPane.showMessageDialog(null, "No existe un ejemplar con ese Número de ID en estado 'disponible_biblioteca'.");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar: " + ex.getMessage());
    }
    
    return ejemplar;
}  


     public List<Ejemplar> buscarEjemplaresPorTitulo(String titulo) {
        List<Ejemplar> ejemplaresEncontrados = new ArrayList<>();
        String sql = "SELECT ejemplar.idEjemplar, libro.idIsbn, libro.titulo, libro.autor, libro.anio, libro.genero, libro.editorial, libro.estado "
                + "FROM ejemplar "
                + "INNER JOIN libro libro ON ejemplar.idIsbn = libro.idIsbn "
                + "WHERE libro.titulo = ? AND libro.estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, titulo);  // Establecer el título como argumento

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                       Ejemplar eje = new Ejemplar();
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                Libro lib = libData.buscarLibroPorIdLibro(rs.getInt("idIsbn"));
                eje.getIdIsbnInt();
                eje.setIdIsbn(lib);
//            para comprobar si el ejemplar está disponible antes de agregarlo a la lista.
//            if (ejemplar.getEstado() == EstadoEjemplar.DISPONIBLE_BIBLIOTECA) {
                eje.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                eje.setActivo(true);
                ejemplaresEncontrados.add(eje);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar: " + ex.getMessage());
        }

        return ejemplaresEncontrados;
    }

     public List<Ejemplar> obtenerEjemplaresPorLibro1(int idIsbn) {
    ArrayList<Ejemplar> ejemplares = new ArrayList<>();

    String sql = "SELECT * FROM ejemplar WHERE idIsbn = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idIsbn);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ejemplar ejemplar = new Ejemplar();
            ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
            ejemplar.setIdIsbnInt(rs.getInt("idIsbn"));
            ejemplar.setEstado(EstadoEjemplar.valueOf(rs.getString("estado"))); // Convierte el estado a Enum
            ejemplar.setActivo(true);

            // Ahora, puedes comprobar si el ejemplar está disponible antes de agregarlo a la lista.
            if (ejemplar.getEstado() == EstadoEjemplar.DISPONIBLE_BIBLIOTECA) {
                ejemplares.add(ejemplar);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
    }
    return ejemplares;
}
         
public void actualizarEjemplaresDisponiblesXPrestamo(int idIsbn, int idEjemplar) {
    String sql = "UPDATE libro SET ejemplaresDisponibles = ? WHERE idIsbn = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idEjemplar);
        ps.setInt(2, idIsbn);
        
        int filas = ps.executeUpdate();

        if (filas > 0) {
            JOptionPane.showMessageDialog(null, "Ejemplares disponibles actualizados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar.");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar ejemplares disponibles: " + ex.getMessage());
    }
}  
/*
SELECT COUNT(*)
FROM ejemplar
JOIN prestamos ON ejemplar.idEjemplar = prestamos.idEjemplar
WHERE ejemplar.idEjemplar= 15 
AND ejemplar.estado = 'disponible_biblioteca' 
AND prestamos.idPrestamos = 17 
AND ejemplar.idIsbn = 4 

*/
    public int contarEjemplaresDisponibles(int idIsbn) {
        int contador = 0;
        String sql = "SELECT COUNT(*) FROM ejemplar WHERE idIsbn = ? AND estado = 'disponible_biblioteca' AND activo = 1 ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idIsbn);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                contador = rs.getInt(1); // Obtiene el valor del conteo.
            } 
            rs.close();
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al actualizar ejemplares disponibles: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return contador;
    }
    
    public void activarEjemplar(int idEjemplar) {
    // Primero, verifica si el ejemplar ya está activo.
    if (estaActivo(idEjemplar)) {
        JOptionPane.showMessageDialog(null, "El Ejemplar ya está activo en la lista de Ejemplares de la biblioteca.");
        return; // No es necesario continuar.
    }
    
    // Si el ejemplar no está activo, procede con la activación.
    String sqlActivar = "UPDATE ejemplar SET activo = 1 WHERE idEjemplar = ?";
    String sqlCambiarEstado = "UPDATE ejemplar SET estado = 'DISPONIBLE_BIBLIOTECA' WHERE idEjemplar = ?";

    try (PreparedStatement psActivar = con.prepareStatement(sqlActivar);
         PreparedStatement psCambiarEstado = con.prepareStatement(sqlCambiarEstado)) {
        con.setAutoCommit(false); // Deshabilita la confirmación automática para la transacción
        
        // Primero, activa el ejemplar
        psActivar.setInt(1, idEjemplar);
        int exitoActivar = psActivar.executeUpdate();

        if (exitoActivar == 1) {
            // Después, cambia el estado del ejemplar a DISPONIBLE_BIBLIOTECA
            psCambiarEstado.setInt(1, idEjemplar);
            int exitoCambiarEstado = psCambiarEstado.executeUpdate();

            if (exitoCambiarEstado == 1) {
                con.commit(); // Confirma la transacción si ambas actualizaciones son exitosas
                JOptionPane.showMessageDialog(null, "El Ejemplar se activó y cambió su estado con éxito.");
            } else {
                con.rollback(); // Revierte la transacción si no se pudo cambiar el estado
                JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado del Ejemplar.");
            }
        } else {
            con.rollback(); // Revierte la transacción si no se pudo activar el ejemplar
            JOptionPane.showMessageDialog(null, "No se encontró ningún Ejemplar con el ID proporcionado.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        try {
            con.rollback(); // Revierte la transacción en caso de excepción
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar: " + ex.getMessage());
    } finally {
        try {
            con.setAutoCommit(true); // Habilita la confirmación automática nuevamente
        } catch (SQLException autoCommitEx) {
            autoCommitEx.printStackTrace();
        }
    }
}

    
   public void desactivarEjemplar(int idEjemplar) {
    // Primero, verifica si el ejemplar ya está desactivado.
    if (!estaActivo(idEjemplar)) {
        JOptionPane.showMessageDialog(null, "El Ejemplar ya está desactivado en la lista de Ejemplares de la biblioteca.");
        return; // No es necesario continuar.
    }

    // Si el ejemplar está activo, procede con la desactivación.
    String sqlDesactivar = "UPDATE ejemplar SET activo = 0 WHERE idEjemplar = ?";
    String sqlCambiarEstado = "UPDATE ejemplar SET estado = 'INACTIVO_PRESTADO' WHERE idEjemplar = ?";

    try (PreparedStatement psDesactivar = con.prepareStatement(sqlDesactivar);
         PreparedStatement psCambiarEstado = con.prepareStatement(sqlCambiarEstado)) {
        con.setAutoCommit(false); // Deshabilita la confirmación automática para la transacción

        // Primero, desactiva el ejemplar
        psDesactivar.setInt(1, idEjemplar);
        int exitoDesactivar = psDesactivar.executeUpdate();

        if (exitoDesactivar == 1) {
            // Después, cambia el estado del ejemplar a INACTIVO_PRESTADO
            psCambiarEstado.setInt(1, idEjemplar);
            int exitoCambiarEstado = psCambiarEstado.executeUpdate();

            if (exitoCambiarEstado == 1) {
                con.commit(); // Confirma la transacción si ambas actualizaciones son exitosas
                JOptionPane.showMessageDialog(null, "El Ejemplar se desactivó y cambió su estado con éxito.");
            } else {
                con.rollback(); // Revierte la transacción si no se pudo cambiar el estado
                JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado del Ejemplar.");
            }
        } else {
            con.rollback(); // Revierte la transacción si no se pudo desactivar el ejemplar
            JOptionPane.showMessageDialog(null, "No se encontró ningún Ejemplar con el ID proporcionado.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        try {
            con.rollback(); // Revierte la transacción en caso de excepción
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar: " + ex.getMessage());
    } finally {
        try {
            con.setAutoCommit(true); // Habilita la confirmación automática nuevamente
        } catch (SQLException autoCommitEx) {
            autoCommitEx.printStackTrace();
        }
    }
}

    
//    public void activarEjemplar(int idEjemplar) {
//    // Primero, verifica si el lector ya está activo.
//    if (estaActivo(idEjemplar)) {
//        JOptionPane.showMessageDialog(null, "El Ejemplar ya está activo en la lista de Ejemplares de la biblioteca.");
//        return; // No es necesario continuar.
//    }
//    
//    // Si el lector no está activo, procede con la activación.
//    String sql = "UPDATE ejemplar SET activo = 1 WHERE idEjemplar = ?";
//
//    try (PreparedStatement ps = con.prepareStatement(sql)) {
//        ps.setInt(1, idEjemplar);
//        int exito = ps.executeUpdate();
//
//        if (exito == 1) {
//            JOptionPane.showMessageDialog(null, "El Ejemplar se Activo con éxito");
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encontró ningún Ejemplar con el ID proporcionado.");
//        }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar: " + ex.getMessage());
//    }
//}
//
//    
//    // Método para verificar si el Ejemplar ya está activo.
private boolean estaActivo(int idEjemplar) {
     //Realiza una consulta para verificar el estado del Ejemplar.
    String sql = "SELECT activo FROM Ejemplar WHERE idEjemplar = ? ";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idEjemplar);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int activo = rs.getInt("activo");
            return activo == 1;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return false; // Si hay un error, devuelve false por precaución.
}

// public void desactivarEjemplar(int idEjemplar) {
//    // Verifica si el lector ya está inactivo.
//    if (!estaActivo(idEjemplar)) {
//        JOptionPane.showMessageDialog(null, "El Ejemplar ya está inactivo en la lista de Ejemplares de la biblioteca.");
//        return; // No es necesario continuar.
//    }
//    
//    // Si el lector está activo, procede con la desactivación.
//    String sql = "UPDATE ejemplar SET activo = 0 WHERE idEjemplar = ? ";
//
//    try (PreparedStatement ps = con.prepareStatement(sql)) {
//        ps.setInt(1, idEjemplar);
//        int exito = ps.executeUpdate();
//
//        if (exito == 1) {
//            JOptionPane.showMessageDialog(null, "Ejemplar Desactivado con éxito");
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encontró ningún Ejemplar con el ID proporcionado.");
//        }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ejemplar: " + ex.getMessage());
//    }
//} 


    public void borrarEjemplar(int idEjemplar, int idIsbn) {
        String sql = "DELETE FROM ejemplar WHERE idEjemplar = ? AND idIsbn = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEjemplar);
            ps.setInt(2, idIsbn);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Ejemplar Borrada Exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ejemplar " + ex.getMessage());
        }
    }

    

//    public void estadoEjemplar(Ejemplar ejemplar) {
//        // ... tu código previo para obtener estadoEnDB ...
//        String sql = "SELECT estado FROM ejemplar WHERE idEjemplar = ?";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            int idEjemplar = 0;
//            ps.setInt(1, idEjemplar); // Supongamos que estás buscando el estado por algún ID
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                String estadoEnDB = null;
//                estadoEnDB = rs.getString("estado");
//            }
//        } catch (SQLException ex) {
//            // Manejo de excepciones si hay un error en la consulta
//            ex.printStackTrace();
//        }
//        String estadoEnDB = null;
//        EstadoEjemplar estadoEjemplar;
//
//        switch (estadoEnDB) {
//            case "DISPONIBLE_BIBLIOTECA":
//                estadoEjemplar = EstadoEjemplar.DISPONIBLE_BIBLIOTECA;
//                break;
//            case "EN_REPARACION":
//                estadoEjemplar = EstadoEjemplar.EN_REPARACION;
//                break;
//            case "PRESTADO":
//                estadoEjemplar = EstadoEjemplar.PRESTADO;
//                break;
//            case "DEVUELTO":
//                estadoEjemplar = EstadoEjemplar.DEVUELTO;
//                break;
//            default:
//                // Manejo de casos no reconocidos
//                estadoEjemplar = null;
//        }
//
//        ejemplar.setEstado(estadoEjemplar); // Establece el estado en el objeto Ejemplar
//    }
//



    
   


}
