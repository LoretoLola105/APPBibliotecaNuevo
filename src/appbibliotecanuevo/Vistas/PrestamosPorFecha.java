package appbibliotecanuevo.Vistas;

import appbibliotecanuevo.AccesoDatos.EjemplarData;
import appbibliotecanuevo.AccesoDatos.LectorData;
import appbibliotecanuevo.AccesoDatos.LibroData;
import appbibliotecanuevo.AccesoDatos.PrestamoData;
import appbibliotecanuevo.Utilidades.CustomRenderer;
import appbibliotecanuevo.Utilidades.RellenarCombos;
import appbibliotecanuevo.entidades.Lector;
import appbibliotecanuevo.entidades.Libro;
import appbibliotecanuevo.entidades.Prestamo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;

public class PrestamosPorFecha extends javax.swing.JPanel {

    private LectorData lecData;

    private List<Prestamo> listP;
    private List<Libro> listaL;
    private List<Lector> listaLec;
    private LibroData libData;
    private EjemplarData ejeData;
    private PrestamoData presData;

    private Libro libro = new Libro();
    private DefaultTableModel modelo;

    RellenarCombos re = new RellenarCombos();

    public PrestamosPorFecha() {
        initComponents();
        PrestamoData presData = new PrestamoData();
        ejeData = new EjemplarData();
        lecData = new LectorData();

        Object lectorActual = null;
        libData = new LibroData();
        listaL = libData.listarLibro();

        listP = presData.listarFechaPrestamo("2023-11-02");
        re.RellenarComboBox("prestamos", "fechaPrestamo", jComboBox1);
        DefaultTableModel modelo = new DefaultTableModel();
        JTable  jTable1 = new JTable(modelo);
        modelo = new DefaultTableModel();
        RowFilter<Object, Object> rowFilter = RowFilter.regexFilter("(?i)", 1);
        cargaPrestamoLibros();
        // cargarCombo();
        armarCabeceraTabla();
        borrarFilas();
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) jComboBox1.getSelectedItem();
                // Actualiza su tabla en función de la opción seleccionada
                //actualizarTabla(opcionSeleccionada);
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 430));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("OBTENER FECHA DE PRESTAMOS DE LOS LIBROS");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("LIMPIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox1KeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("LISTADO DE PRESTAMOS BUSCAR POR FECHA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(179, 179, 179))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            String opcionSeleccionada = (String) jComboBox1.getSelectedItem();

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0); // Limpia la tabla antes de agregar los nuevos resultados.

            for (Libro lib : libData.listarLibro()) {
                if (opcionSeleccionada.equals("Todos") || lib.getTitulo().toLowerCase().startsWith(opcionSeleccionada.toLowerCase())) {
                    modelo.addRow(new Object[]{
                        lib.getIsbn(),
                        lib.getTitulo(),
                        lib.getAutor(),
                        lib.getAnio(),
                        lib.getGenero(),
                        lib.getEditorial(),
                        lib.isEstado()
                    });
                }
            }

            jTable1.setModel(modelo);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBox1KeyReleased

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void cargaPrestamoLibros() {
        if (listaL != null && !listaL.isEmpty()) {
            for (Libro libro : listaL) {
                jTable1.setModel(modelo);
            }
        }
    }

    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        if (filaCabecera != null && !filaCabecera.isEmpty()) {
            filaCabecera.add("ID ISBN");
            filaCabecera.add("Titulo");
            filaCabecera.add("Autor");
            filaCabecera.add("Año");
            filaCabecera.add("Genero");
            filaCabecera.add("Editorial");
            filaCabecera.add("Estado");

            for (Object it : filaCabecera) {
                modelo.addColumn(it);
            }
            jTable1.setModel(modelo);

            // Aplica el renderer personalizado a la columna "ID ISBN"
            int columnaTitulo = 1;
            jTable1.getColumnModel().getColumn(columnaTitulo).setCellRenderer(new CustomRenderer());
        }
    }

    private void borrarFilas() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int filas = modelo.getRowCount();
            for (int f = filas - 1; f >= 0; f--) {
                modelo.removeRow(f);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
    }

    private void actualizarTabla(String opcionSeleccionada) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0); // Borra la tabla antes de agregar nuevos resultados.

        for (Libro lib : libData.listarLibro()) {
            if (opcionSeleccionada.equals("Todos") || lib.getTitulo().toLowerCase().startsWith(opcionSeleccionada.toLowerCase())) {
                modelo.addRow(new Object[]{
                    lib.getIsbn(),
                    lib.getTitulo(),
                    lib.getAutor(),
                    lib.getAnio(),
                    lib.getGenero(),
                    lib.getEditorial(),
                    lib.isEstado()
                });
            }
        }

        jTable1.setModel(modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
