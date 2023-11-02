/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.entidades;

import java.util.Objects;

/**
 *
 * @author Otras
 */
public class Libro {
   private int Isbn;
    private String titulo;
    private String  autor;
    private int anio;
    private String genero;
    private String editorial;
    private boolean estado;

    //construcctores
      public Libro() {
    }

    public Libro(int Isbn, String titulo, String autor, int anio, String genero, String editorial, boolean estado) {
        this.Isbn = Isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.editorial = editorial;
        this.estado = estado;
    }

    public Libro(String titulo, String autor, int anio, String genero, String editorial, boolean estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.editorial = editorial;
        this.estado = estado;
    }

    public Libro(String titulo, String autor, String anio, String genero, String editorial, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    //getters and setters

    public int getIsbn() {
        return Isbn;
    }

    public void setIsbn(int Isbn) {
        this.Isbn = Isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
      //  return "Libro{" + "Isbn=" + Isbn + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", genero=" + genero + ", editorial=" + editorial + ", estado=" + estado + '}';
 //   return  Isbn+", "+titulo+", "+autor;
        return titulo; // Retorna el título como representación en cadena
    }

    public Object getInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
   
    
    
}
