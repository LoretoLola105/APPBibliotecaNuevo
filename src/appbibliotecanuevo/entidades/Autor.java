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
public class Autor {
    private String apellido;
    private String nombre;
    private String titulo;
    private String tipo;
    private String editorial;
    private int anioEdicion;
    private boolean estado;

    public Autor(String apellido, String nombre, String titulo, String tipo, String editorial, int anioEdicion, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.tipo = tipo;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.estado = estado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Autor{" + "apellido=" + apellido + ", nombre=" + nombre + ", titulo=" + titulo + ", tipo=" + tipo + ", editorial=" + editorial + ", anioEdicion=" + anioEdicion + ", estado=" + estado + '}';
    }
    
    
    
}
