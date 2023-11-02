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
public class CustomRendererAutor extends DefaultTableCellRenderer {
   
    private final int columnaAutor = 2; // Índice de la columna "Autor"

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == columnaAutor) {
            String autor = table.getValueAt(row, columnaAutor).toString();
            
            // Verifica el contenido de la celda de la columna "Autor" y colorea la fila en consecuencia
            if (autor.toLowerCase().contains("texto a buscar")) {
                c.setBackground(Color.GREEN);
            } else {
                c.setBackground(Color.cyan);
            }
        } else {
            // Restablece el fondo predeterminado para otras columnas
            c.setBackground(table.getBackground());
        }
        
        return c;
    }

}
