/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.Vistas;

import appbibliotecanuevo.AccesoDatos.EjemplarData;
import appbibliotecanuevo.AccesoDatos.LectorData;
import appbibliotecanuevo.AccesoDatos.LibroData;
import appbibliotecanuevo.AccesoDatos.PrestamoData;
import appbibliotecanuevo.entidades.Lector;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Antonio
 */
public class Ejemplares extends javax.swing.JPanel {
private List<Lector> listaLec;
private List<Prestamos> listaP;
private LibroData libData;
private EjemplarData ejeData;
private PrestamoData presData;
private LectorData lecData;

private DefaultTableModel modelo;
    /**
     * Creates new form Principal
     */
    public Ejemplares() {
        initComponents();
   
        libData=new LibroData();
        listaLec = lecData.listarLectores();
        modelo=new DefaultTableModel();
        presData =new PrestamoData();
        lecData=new LectorData();
        
   
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
