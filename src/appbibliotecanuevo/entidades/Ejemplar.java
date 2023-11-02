/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.entidades;
import appbibliotecanuevo.entidades.EstadoEjemplar;
/**
 *
 * @author Otras
 */
public class Ejemplar {
    private int idEjemplar;
    private Libro idIsbn; // Mantener la propiedad idIsbn como objeto Libro
    private int idIsbnInt; // Agregar una propiedad adicional para el valor int        
    private EstadoEjemplar estado;
    private boolean activo;
    
    public Ejemplar() {
    }

    public Ejemplar(int idEjemplar, Libro idIsbn, int idIsbnInt, EstadoEjemplar estado, boolean activo) {
        this.idEjemplar = idEjemplar;
        this.idIsbn = idIsbn;
        this.idIsbnInt = idIsbnInt;
        this.estado = estado;
        this.activo = activo;
    }

    public Ejemplar(Libro idIsbn, int idIsbnInt, EstadoEjemplar estado, boolean activo) {
        this.idIsbn = idIsbn;
        this.idIsbnInt = idIsbnInt;
        this.estado = estado;
        this.activo = activo;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public Libro getIdIsbn() {
        return idIsbn;
    }

    public void setIdIsbn(Libro idIsbn) {
        this.idIsbn = idIsbn;
    }

    public EstadoEjemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoEjemplar estado) {
        this.estado = estado;
    }
    
    public int getIdIsbnInt() {
        return idIsbnInt;
    }

    public void setIdIsbnInt(int idIsbnInt) {
        this.idIsbnInt = idIsbnInt;
    }
    
    // Método para cambiar el estado a "INACTIVO"
    public void desactivar() {
        this.estado = EstadoEjemplar.INACTIVO_PRESTADO;
    }

    // Método para cambiar el estado a "ACTIVO"
    public void activar() {
        this.estado = EstadoEjemplar.DISPONIBLE_BIBLIOTECA;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
//    @Override
//    public Libro toString() {
//        //return "Ejemplar{" + "idEjemplar=" + idEjemplar + ", idIsbn=" + idIsbn + ", idIsbnInt=" + idIsbnInt + ", estado=" + estado + ", activo=" + activo + '}';
//            //return idEjemplar+", "+idIsbn+", "+estado;
//         return idIsbn;   
//    }

    @Override
    public String toString() {
        return  String.valueOf(idEjemplar);
    }

    
    
 
}