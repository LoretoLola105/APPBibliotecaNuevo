/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.entidades;



/**
 *
 * @author Otras
 */
public class Prestamo {
    private int idPrestamo;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Ejemplar ejemplar;
    private Lector lector;
    private EstadoEjemplar estado;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, String fechaPrestamo, String fechaDevolucion, Ejemplar ejemplar, Lector lector,  EstadoEjemplar estado) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public Prestamo(String fechaPrestamo, String fechaDevolucion, Ejemplar ejemplar, Lector lector,   EstadoEjemplar estado) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public EstadoEjemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }

    


    
    
    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", ejemplar=" + ejemplar + ", lector=" + lector + ", estado=" + estado + '}';
    }

    public Lector getIdLector() {
         return lector;
    }

    public Ejemplar getIdEjemplar() {
        return ejemplar;
    }

}