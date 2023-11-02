package appbibliotecanuevo.Vistas;


import appbibliotecanuevo.AccesoDatos.EjemplarData;
import appbibliotecanuevo.AccesoDatos.LectorData;
import appbibliotecanuevo.AccesoDatos.LibroData;
import appbibliotecanuevo.AccesoDatos.PrestamoData;
import appbibliotecanuevo.Utilidades.CustomRendererAutor;
import appbibliotecanuevo.Utilidades.RellenarCombos;
import appbibliotecanuevo.entidades.Libro;
import appbibliotecanuevo.entidades.Prestamo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PrestamosDeLibrosXFecha extends javax.swing.JPanel {
private List<Prestamo> listP;
    private List<Libro> listaL;
    private LibroData libData;
    private EjemplarData ejeData;
    private PrestamoData presData;
    private LectorData lecData;
        private Libro lib = new Libro();
    private Libro libroActual = null;

    private DefaultTableModel modelo;
        RellenarCombos re = new RellenarCombos();
        
        
        
    public PrestamosDeLibrosXFecha() {
        initComponents();
        InitStyles();
        CargarPrestamos();
        libData = new LibroData();
        listaL = libData.listarLibro();
         modelo = new DefaultTableModel();
         // re.RellenarComboBox("libro", "titulo",  jComboBox1);
        DefaultTableModel modelo = new DefaultTableModel();
        JTable jtablaTitulo = new JTable(modelo);
//         jComboBox1.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String opcionSeleccionada = (String)  jComboBox1.getSelectedItem();
//            // Actualiza su tabla en función de la opción seleccionada
          //  actualizarTabla(opcionSeleccionada);
        

//    });
    }
    
    private void InitStyles() {
//        title.putClientProperty("FlatLaf.styleClass", "h1");
//        title.setForeground(Color.black);
    }
    
    private void CargarPrestamos() {
//        try {
//            
//            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//            // Limpiamos tabla
//              model.setRowCount(0);
//              presData.obtenerPrestamos().forEach(prestamo)-> model.addRow(new Object[]{u.getUser_id(), u.getBook_id(), u.getDate_out(), u.getDate_return()}));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }

//              ArrayList<Object> filaCabecera = new ArrayList<>();
//        filaCabecera.add("IdPrestamo");
//        filaCabecera.add("IdEjemplar");
//        filaCabecera.add("IdLector");
//        filaCabecera.add("Fecha Prestamo");
//        filaCabecera.add("Fecha Devolución");
//        filaCabecera.add("Estado");
//        for (Object it : filaCabecera) {
//            modelo.addColumn(it);
//        }
//        jTable1.setModel(modelo);
//
//          
//            dao.listar().forEach((u) -> model.addRow(new Object[]{u.getUser_id(), u.getBook_id(), u.getDate_out(), u.getDate_return()}));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
        
    
   
    
     private void cargaPrestamos() {
        for (Prestamo pres : listP) {
             jTable2.setModel(modelo);
        }
    }

    private void armarCabeceraTablaPrestamo() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
       filaCabecera.add("IdPrestamo");
        filaCabecera.add("IdEjemplar");
        filaCabecera.add("IdLector");
        filaCabecera.add("Fecha Prestamo");
        filaCabecera.add("Fecha Devolución");
        filaCabecera.add("Estado");

        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }

        jTable2.setModel(modelo);

        // Aplica el renderer personalizado a la columna "Autor"
//        int columnaAutor = 1;
//        jTable2.getColumnModel().getColumn(columnaIdEjemplar).setCellRenderer(new CustomRendererAutor());
    }

private void borrarFilas() {
    try {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        int filas = modelo.getRowCount();
        for (int f = filas - 1; f >= 0; f--) {
            modelo.removeRow(f);
        }
    } catch (NullPointerException ex) {
        JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
    }
}
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 430));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(18, 90, 173));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Actualizar");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MOSTRAR LISTADO DE PRESTAMOS:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton2)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CargarPrestamos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}