/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Otras
 */
public class CustomRendererLectores extends DefaultTableCellRenderer{
   private final int columnaNombre = 1; // Índice de la columna "Nombre"

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == columnaNombre) {
            String autor = table.getValueAt(row, columnaNombre).toString();
            
            // Verifica el contenido de la celda de la columna "Autor" y colorea la fila en consecuencia
            if (autor.toLowerCase().contains("texto a buscar")) {
                c.setBackground(Color.GREEN);
            } else {
                c.setBackground(Color.CYAN);
            }
        } else {
            // Restablece el fondo predeterminado para otras columnas
            c.setBackground(table.getBackground());
        }
        
        return c;
    }

      
}
