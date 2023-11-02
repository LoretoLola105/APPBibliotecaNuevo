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
public class Lector {
    private int idLector;
    private String nombre;
    private int dni;
    private String domicilio;
    private String email;
    private int numeroTel;
    private boolean estado;

    //constructores
    public Lector() {
    }

    public Lector(int idLector, String nombre, int dni, String domicilio, String email, int numeroTel, boolean estado) {
        this.idLector = idLector;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.email = email;
        this.numeroTel = numeroTel;
        this.estado = estado;
    }

    public Lector(String nombre, int dni, String domicilio, String email, int numeroTel, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.email = email;
        this.numeroTel = numeroTel;
        this.estado = estado;
    }

    public Lector(String nombre, int dni, String domicilio, String email, int telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdLector() {
        return idLector;
    }

    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
     //   return "Lector{" + "idLector=" + idLector + ", nombre=" + nombre + ", dni=" + dni + ", domicilio=" + domicilio + ", email=" + email + ", numeroTel=" + numeroTel + ", estado=" + estado + '}';
   //  return  idLector+", "+nombre+", "+dni;
   
    return nombre; 
}

    public Object getIdPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getLector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   
    
}
