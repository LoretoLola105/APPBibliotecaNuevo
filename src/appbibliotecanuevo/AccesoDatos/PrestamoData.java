/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.AccesoDatos;

import appbibliotecanuevo.entidades.EstadoPrestamo;
import appbibliotecanuevo.entidades.EstadoEjemplar;
import appbibliotecanuevo.entidades.Ejemplar;
import appbibliotecanuevo.entidades.Lector;
import appbibliotecanuevo.entidades.Libro;
import appbibliotecanuevo.entidades.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Otras
 */
public class PrestamoData {

    private Connection con = null;
    private EjemplarData ejeData = new EjemplarData();
    //private LibroData libData = new LibroData();
    private LectorData lecData = new LectorData();
    Prestamo prestamo;

    public PrestamoData() {

        con = Conexion.getConexion();

    }

    
    
     public boolean ejemplarPrestadoFechas(int codigoEjemplar, String fechaInicioStr, String fechaFinStr) {
    String sql = "SELECT idPrestamos FROM prestamos WHERE idEjemplar = ? " +
                 "AND (fechaPrestamos <= ? AND fechaDevolucion >= ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codigoEjemplar);
        ps.setString(2, fechaInicioStr);
        ps.setString(3, fechaFinStr);

        ResultSet rs = ps.executeQuery();

        return rs.next(); // Si hay resultados, el ejemplar está prestado en esas fechas
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false; // En caso de error o si no está prestado
}
    public void guardarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos(idPrestamos, idLector, idEjemplar, fechaPrestamo, fechaDevolucion, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, prestamo.getIdPrestamo());
            ps.setInt(2, prestamo.getLector().getIdLector());
            ps.setInt(3, prestamo.getEjemplar().getIdEjemplar());
            ps.setString(4, prestamo.getFechaPrestamo());
            ps.setString(5, prestamo.getFechaDevolucion());
            ps.setString(6, prestamo.getEstado().name()); // Convierte el estado a una cadena usando name()

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                prestamo.setIdPrestamo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Prestamo Registrado Exitosamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
    }

    public void efectuarPrestamo(Prestamo prestamo) {
        String consultaExistencia = "SELECT * FROM prestamos WHERE idLector = ? AND idEjemplar = ?";
        String sqlInsert = "INSERT INTO prestamos(idLector, idEjemplar, fechaPrestamo, fechaDevolucion, estado) VALUES (?, ?, ?, ?, ?)";
        String sqlUpdate = "UPDATE prestamos SET estado = ? WHERE idLector = ? AND idEjemplar = ?";

        try {
            // Verificar si el préstamo ya existe
            PreparedStatement psExistencia = con.prepareStatement(consultaExistencia);
            psExistencia.setInt(1, prestamo.getLector().getIdLector());
            psExistencia.setInt(2, prestamo.getEjemplar().getIdEjemplar());
            ResultSet rsExistencia = psExistencia.executeQuery();

            if (rsExistencia.next()) {
                // El préstamo ya existe, actualiza su estado
                PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
                psUpdate.setString(1, prestamo.getEstado().name());
                psUpdate.setInt(2, prestamo.getLector().getIdLector());
                psUpdate.setInt(3, prestamo.getEjemplar().getIdEjemplar());
                int rowsUpdated = psUpdate.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Estado del préstamo actualizado Exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el préstamo");
                }

                psUpdate.close();
            } else {
                // El préstamo no existe, inserta un nuevo préstamo
                PreparedStatement psInsert = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                psInsert.setInt(1, prestamo.getLector().getIdLector());
                psInsert.setInt(2, prestamo.getEjemplar().getIdEjemplar());
                psInsert.setString(3, prestamo.getFechaPrestamo());
                psInsert.setString(4, prestamo.getFechaDevolucion());
                psInsert.setString(5, prestamo.getEstado().name());

                int rowsInserted = psInsert.executeUpdate();

                if (rowsInserted > 0) {
                    ResultSet rs = psInsert.getGeneratedKeys();
                    if (rs.next()) {
                        prestamo.setIdPrestamo(rs.getInt(1));
                    }
                    JOptionPane.showMessageDialog(null, "Prestamo Registrado Exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar el préstamo");
                }

                psInsert.close();
            }

            psExistencia.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }

        // Desactivar el ejemplar con el ID asignado al préstamo
        ejeData.desactivarEjemplar(prestamo.getEjemplar().getIdEjemplar());
    }

    public void devolverPrestamo(Prestamo prestamo) {
        String sqlUpdatePrestamo = "UPDATE prestamos SET fechaDevolucion = ?, estado = ? WHERE idPrestamos = ?";
        String sqlUpdateEjemplar = "UPDATE ejemplar SET estado = ? , activo =  ? WHERE idEjemplar = ? AND idIsbn = ?";

        try {
            // Actualiza el préstamo para registrar la fecha de devolución y marcarlo como completado
            PreparedStatement psUpdatePrestamo = con.prepareStatement(sqlUpdatePrestamo);
            psUpdatePrestamo.setString(1, prestamo.getFechaDevolucion());
            psUpdatePrestamo.setString(2, prestamo.getEstado().name()); // Convierte el enum a su nombre (cadena)
            psUpdatePrestamo.setInt(3, prestamo.getIdPrestamo());

            int rowsUpdatedPrestamo = psUpdatePrestamo.executeUpdate();

            if (rowsUpdatedPrestamo > 0) {
                // Marca el ejemplar como disponible
                PreparedStatement psUpdateEjemplar = con.prepareStatement(sqlUpdateEjemplar);
                psUpdateEjemplar.setInt(1, prestamo.getEjemplar().getIdEjemplar());

                int rowsUpdatedEjemplar = psUpdateEjemplar.executeUpdate();

                if (rowsUpdatedEjemplar > 0) {
                    JOptionPane.showMessageDialog(null, "Devolución Exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el estado del ejemplar");
                }

                psUpdateEjemplar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado del préstamo");
            }

            psUpdatePrestamo.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver el préstamo: " + ex.getMessage());
        }
    }

    public void actualizarPrestamo(int idPrestamos, int idLector, int idEjemplar, String fechaPrestamo, String fechaDevolucion, EstadoEjemplar estado) {

        String sql = "UPDATE prestamos SET idLector = ? , idEjemplar = ? , fechaPrestamo = ? , fechaDevolucion = ? , estado = ? WHERE idPrestamos = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            ps.setInt(2, idEjemplar);
            ps.setString(3, fechaPrestamo);
            ps.setString(4, fechaDevolucion);
            ps.setString(5, estado.name()); // Convierte el enum a su nombre (cadena)
            ps.setInt(6, idPrestamos);
            int filas = ps.executeUpdate();//nos devuelve un entero

            System.out.println("Número de filas actualizadas: " + filas); // Agrega esta línea para depuración
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Prestamo actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos" + ex.getMessage());
        }
    }

    
    public void modificarPrestamo(Prestamo prestamo) {

        String sql = "UPDATE prestamos SET idLector = ? , idEjemplar = ? , fechaPrestamo = ? , fechaDevolucion = ? , estado = ? WHERE idPrestamos = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, prestamo.getIdPrestamo());
            ps.setInt(2, prestamo.getLector().getIdLector());
            ps.setInt(3, prestamo.getEjemplar() .getIdEjemplar());
            ps.setString(4, prestamo.getFechaPrestamo());
            ps.setString(5, prestamo.getFechaDevolucion());
            ps.setString(6, prestamo.getEstado().name()); // Convierte el enum a su nombre (cadena)
            int filas = ps.executeUpdate();//nos devuelve un entero

            System.out.println("Número de filas actualizadas: " + filas); // Agrega esta línea para depuración
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Prestamo actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros para actualizar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos" + ex.getMessage());
        }
    }
    
    
    public void borrarPrestamoFisico(int idPrestamos, int idLector, int idEjemplar) {
        String sql = "DELETE FROM prestamos WHERE idPrestamos = ? AND idLector = ? AND idEjemplar = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPrestamos);
            ps.setInt(2, idLector);
            ps.setInt(3, idEjemplar);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Prestamo Borrado Exitosamente.");

            } else {

                JOptionPane.showMessageDialog(null, "No se encontraron registros para borrar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
    }
//los prestamos actuales son los que se encuentran con el estado INACTIVO_PRESTADO

    public List<Prestamo> obtenerPrestamos() {
        ArrayList<Prestamo> solicitados = new ArrayList<>();

        String sql = "SELECT * FROM prestamos ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {//mientras ResultSet tenga elemento va a seguir recorriendo

                Prestamo pres = new Prestamo();
                pres.setIdPrestamo(rs.getInt("idPrestamos"));
                // Asumiendo que lecData y ejeData son instancias válidas de las clases Lector y Ejemplar
                Lector lec = lecData.buscarLector(rs.getInt("idLector"));
                Ejemplar eje = ejeData.buscarEjemplar(rs.getInt("idEjemplar"));
                pres.setLector(lec);
                pres.setEjemplar(eje);
                pres.setFechaPrestamo(rs.getString("fechaPrestamo"));
                pres.setFechaDevolucion(rs.getString("fechaDevolucion"));
                pres.setEstado(EstadoEjemplar.PRESTADO);
                // Ahora, puedes comprobar si el ejemplar está disponible antes de agregarlo a la lista.
                if (pres.getEstado() == EstadoEjemplar.PRESTADO) {
                    solicitados.add(pres);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
        return solicitados;
    }

//    public Prestamo obtenerPrestamosPorLector(int id) {
//
//        String sql = "SELECT * FROM prestamos WHERE idPrestamo = ? ";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {//mientras ResultSet tenga elemento va aa seguir recorriendo
//                int idPrestamo = rs.getInt("idPrestamo");
//                int idLector = rs.getInt("idLector");
//                int idEjemplar = rs.getInt("idEjemplar");
//                Lector lec = lecData.buscarLector(rs.getInt("idLector"));
//                Ejemplar eje = ejeData.buscarEjemplar(rs.getInt("idEjemplar"));
//                 int idLector(lec);
//                int idEjemplar(eje);
//                String fechaPrestamo = rs.getString("fechaPrestamo");
//                String fechaDevolucion = rs.getString("fechaDevolucion");
//                String estadoValue=rs.getString("estado");
//                EstadoEjemplar estadoE = (estadoValue != null) ? EstadoEjemplar.valueOf(estadoValue) : EstadoEjemplar.VALOR_POR_DEFECTO;
//                prestamo = new Prestamo(idPrestamo, fechaPrestamo, fechaDevolucion, ejemplar, lector, estadoE);
//
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
//        }
//        return prestamo;
//    }
    public Prestamo obtenerPresPorLector(int id) {
        Prestamo prestamo = new Prestamo(); // Debes declarar e inicializar la variable de Prestamo

        String sql = "SELECT * FROM prestamos WHERE idPrestamos = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                prestamo.setIdPrestamo(rs.getInt("idPrestamos"));
                prestamo.setLector(lecData.buscarLector(rs.getInt("idLector")));
                prestamo.setEjemplar(ejeData.buscarEjemplar(rs.getInt("idEjemplar")));
                prestamo.setFechaPrestamo(rs.getString("fechaPrestamo"));
                prestamo.setFechaDevolucion(rs.getString("fechaDevolucion"));
                String estadoValue = rs.getString("estado");
                System.out.println(estadoValue);
                EstadoEjemplar estadoE = (estadoValue != null) ? EstadoEjemplar.valueOf(estadoValue) : EstadoEjemplar.VALOR_POR_DEFECTO;
                prestamo.setEstado(estadoE);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
        return prestamo;
    }

    public List<Prestamo> obtenerPrestamosPorLectores(int idLector) {
        ArrayList<Prestamo> solicitados = new ArrayList<>();

        String sql = "SELECT * FROM prestamos WHERE idLector = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {//mientras ResultSet tenga elemento va aa seguir recorriendo
                Prestamo pres = new Prestamo();
                pres.setIdPrestamo(rs.getInt("idPrestamos"));
                // Asumiendo que lecData y ejeData son instancias válidas de las clases Lector y Ejemplar
                Lector lec = lecData.buscarLector(rs.getInt("idLector"));
                Ejemplar eje = ejeData.buscarEjemplar(rs.getInt("idEjemplar"));
                pres.setLector(lec);
                pres.setEjemplar(eje);
                pres.setFechaPrestamo(rs.getString("fechaPrestamo"));
                pres.setFechaDevolucion(rs.getString("fechaDevolucion"));
                pres.setEstado(EstadoEjemplar.PRESTADO);
                solicitados.add(pres);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
        return solicitados;
    }

    public int contarPrestamosXLector(int idLector) {
        int contador = 0;
        String sql = "SELECT COUNT(*) FROM prestamos WHERE idLector = 11 AND estado = 'PRESTADO' ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                contador = rs.getInt(1); // Obtiene el valor del conteo.
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar prestamos disponibles del lector: " + ex.getMessage());
            ex.printStackTrace();
        }

        return contador;
    }

//    public List<Prestamo> obtenerPrestamosPorEjemplar(int idEjemplar) {
//        ArrayList<Prestamo> solicitados = new ArrayList<>();
//
//        String sql = "SELECT * FROM prestamos WHERE idEjemplar = ? ";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idEjemplar);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {//mientras ResultSet tenga elemento va a seguir recorriendo
//                Prestamo pres = new Prestamo();
//                pres.setIdPrestamo(rs.getInt("idPrestamos"));
//                // Asumiendo que lecData y ejeData son instancias válidas de las clases Lector y Ejemplar
//                Lector lec = lecData.buscarLector(rs.getInt("idLector"));
//                Ejemplar eje = ejeData.buscarEjemplar(rs.getInt("idEjemplar"));
//                pres.setLector(lec);
//                pres.setEjemplar(eje);
//                pres.setFechaPrestamo(rs.getString("fechaPrestamo"));
//                pres.setFechaDevolucion(rs.getString("fechaDevolucion"));
//                String estadoValue=rs.getString("estado");
//                EstadoEjemplar estado=(estadoValue != null) ? EstadoEjemplar.valueOf(estadoValue:EstadoEjemplar.VALOR_POR_DEFECTO);
//                pres.setEstado(EstadoEjemplar ejemplar.getEstado().name()););
//                solicitados.add(pres);
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
//        }
//        return solicitados;
//    }
//SELECT
//    prestamos.idEjemplar,
//    idIsbn
//FROM
//    prestamos,
//    ejemplar
//WHERE
//    prestamos.idEjemplar = ejemplar.idEjemplar AND prestamos.idLector = 1
// 

    public List<Ejemplar> obtenerLibrosPrestados(int idLector) {
        ArrayList<Ejemplar> ejemplares = new ArrayList<>();

        String sql = "SELECT libro.idIsbn, libro.titulo, libro.autor, libro.anio, libro.genero, libro.editorial, libro.estado "
                + "FROM ejemplar "
                + "INNER JOIN prestamos ON ejemplar.idEjemplar = prestamos.idEjemplar "
                + "INNER JOIN libro ON libro.idIsbn = ejemplar.idIsbn "
                + "WHERE prestamos.idLector = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
                ejemplar.setIdIsbnInt(rs.getInt("idIsnb"));
                ejemplar.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                ejemplar.setActivo(true);
                ejemplares.add(ejemplar);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
        return ejemplares;
    }

    public List<Ejemplar> obtenerLibrosNOPrestados(int idLector) {
        ArrayList<Ejemplar> ejemplares = new ArrayList<>();
        //ESTADO DISPONIBLE
        String sql = "SELECT * FROM ejemplar WHERE estado = 1 AND idEjemplar not in "
                + "(SELECT idEjemplar FROM prestamos WHERE idLector = ?) ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLector);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
                ejemplar.setIdIsbnInt(rs.getInt("idIsnb"));
                ejemplar.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                ejemplares.add(ejemplar);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }
        return ejemplares;
    }

    public static String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");

        return formatoFecha.format(fecha);

    }

//LocalDate now = LocalDate.now();
//int year =now.getYear();
//int dia =now.getDayOfMonth();
//int month=now.getMonthValue();
//String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
//fecha.setText("Hoy es "+dia+" de "+meses[month - 1])+" de "+year
//  String sqlUpdateLector="SELECT lector.idLector, lector.nombre, lector.dni, lector.domicilio, lector.email, lector.telefono, lector.estado "
//            + "FROM prestamos "
//            + "INNER JOIN lector ON lector.idLector = prestamos.idLector "
//            + "WHERE prestamos.fechaDevolucion > '2023-10-23' LIMIT 0, 25 ";
    public List<Integer> obtenerLectoresConPrestamosVencidos(String fechaDevolucion) {
        List<Integer> lectoresVencidos = new ArrayList<>();
        String sql = "SELECT idLector FROM prestamos WHERE fechaDevolucion > ? ";

// Obtener la fecha actual
        String fechaActual = fechaActual();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fechaDevolucion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idLector = rs.getInt("idLector");
                lectoresVencidos.add(idLector);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }

        return lectoresVencidos;
    }

//   public List<Integer> obtenerLectoresConPrestamosVencidos(String fechaDevolucion) {
//    List<Integer> lectoresVencidos = new ArrayList<>();
//    String sql = "SELECT idLector FROM prestamos WHERE fechaDevolucion < '2023-10-23' ";
////SELECT idLector FROM prestamos WHERE fechaDevolucion > '2023-10-23'
//    try {
//        // Obtener la fecha actual
//        String fechaActual = fechaActual();
//        
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, fechaActual);
//        ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//            int idLector = rs.getInt("idLector");
//            lectoresVencidos.add(idLector);
//        }
//        
//        ps.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
//    }
//    
//    return lectoresVencidos;
//}
    public List<Prestamo> listarFechaPrestamo(String fechaPrestamo) {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos WHERE fechaPrestamo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fechaPrestamo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamos"));
                // Asumiendo que lecData y ejeData son instancias válidas de las clases Lector y Ejemplar
                Lector lec = lecData.buscarLector(rs.getInt("idLector"));
                Ejemplar eje = ejeData.buscarEjemplar(rs.getInt("idEjemplar"));
                prestamo.setLector(lec);
                prestamo.setEjemplar(eje);
                prestamo.setFechaPrestamo(rs.getString("fechaPrestamo"));
                prestamo.setFechaDevolucion(rs.getString("fechaDevolucion"));
                prestamo.setEstado(EstadoEjemplar.DISPONIBLE_BIBLIOTECA);
                prestamos.add(prestamo);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }

        return prestamos;
    }

    public List<Lector> listarLectoresVencidos() {
        List<Lector> lectoresVencidos = new ArrayList<>();
        String sql = "SELECT l.idLector, l.nombre, l.dni, l.domicilio, l.email, l.telefono "
                + "FROM prestamos AS p "
                + "INNER JOIN lector AS l ON p.idLector = l.idLector "
                + "WHERE p.fechadevolucion < ? ";

        try {
            // Obtener la fecha actual
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
            String fechaDevolucion = formatoFecha.format(fechaActual);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fechaDevolucion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lector lector = new Lector();
                lector.setIdLector(rs.getInt("idLector"));
                lector.setNombre(rs.getString("nombre"));
                lector.setDni(rs.getInt("dni"));
                lector.setDomicilio(rs.getString("domicilio"));
                lector.setEmail(rs.getString("email"));
                lector.setNumeroTel(rs.getInt("telefono"));
                lectoresVencidos.add(lector);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
        }

        return lectoresVencidos;
    }

//public void informacionPrestamoVencido(String ){
//    String sqlUpdatePrestamo = "UPDATE prestamos SET fechaDevolucion = ?, estado = ? WHERE idPrestamos = ?";
//    String sqlUpdateEjemplar = "UPDATE ejemplar SET estado = ? , activo =  ? WHERE idEjemplar = ? AND idIsbn = ?";
//
//    try {
//        // Actualiza el préstamo para registrar la fecha de devolución y marcarlo como completado
//        PreparedStatement psUpdatePrestamo = con.prepareStatement(sqlUpdatePrestamo);
//        psUpdatePrestamo.setString(1, prestamo.getFechaDevolucion());
//        psUpdatePrestamo.setString(2, prestamo.getEstado().name()); // Convierte el enum a su nombre (cadena)
//        psUpdatePrestamo.setInt(3, prestamo.getIdPrestamo());
//
//        int rowsUpdatedPrestamo = psUpdatePrestamo.executeUpdate();
//
//        if (rowsUpdatedPrestamo > 0) {
//            // Marca el ejemplar como disponible
//            PreparedStatement psUpdateEjemplar = con.prepareStatement(sqlUpdateEjemplar);
//            psUpdateEjemplar.setInt(1, prestamo.getEjemplar().getIdEjemplar());
//
//            int rowsUpdatedEjemplar = psUpdateEjemplar.executeUpdate();
//
//            if (rowsUpdatedEjemplar > 0) {
//                JOptionPane.showMessageDialog(null, "Devolución Exitosa");
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al actualizar el estado del ejemplar");
//            }
//
//            psUpdateEjemplar.close();
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del préstamo");
//        }
//
//        psUpdatePrestamo.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al devolver el préstamo: " + ex.getMessage());
//    }
//}
//    public void realizarPrestamo(Prestamo prestamo) {
//        // Verificar que haya ejemplares disponibles
//        int ejemplaresDisponibles = obtenerEjemplaresDisponibles(prestamo.getEjemplar().getIdIsbn());
//
//        if (ejemplaresDisponibles > 0) {
//            // Realizar el préstamo
//            String sql = "INSERT INTO prestamos(idLector, idEjemplar, fechaPrestamo, fechaDevolucion, estado) VALUES (?, ?, ?, ?, ?)";
//
//            try {
//                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//                ps.setInt(1, prestamo.getLector().getIdLector());
//                ps.setInt(2, prestamo.getEjemplar().getIdEjemplar());
//                ps.setString(3, prestamo.getFechaPrestamo());
//                ps.setString(4, prestamo.getFechaDevolucion());
//                ps.setString(5, prestamo.getEstado());
//                ps.executeUpdate();
//
//                ResultSet rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    prestamo.setIdPrestamo(rs.getInt(1));
//                    JOptionPane.showMessageDialog(null, "Préstamo Registrado Exitosamente");
//
//                    // Actualizar el número de ejemplares disponibles
//                    actualizarEjemplaresDisponibles(prestamo.getEjemplar().getIdIsbn(), ejemplaresDisponibles - 1);
//                }
//                ps.close();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Prestamos: " + ex.getMessage());
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No hay ejemplares disponibles para este título.");
//        }
//    }

   
    
}
