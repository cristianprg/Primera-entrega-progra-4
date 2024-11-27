package ventanasMovimiento;

import servicios.MovimientoServicio;
import clasesBase.Movimiento;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VerMovimientosVentana {
    private MovimientoServicio movimientoServicio;

    public VerMovimientosVentana(MovimientoServicio movimientoServicio) {
        this.movimientoServicio = movimientoServicio;
    }
    
    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Movimientos");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID del Producto");
        modeloTabla.addColumn("Tipo de movimiento");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Motivo");

        // Crear la tabla con el modelo
        JTable tablaProductos = new JTable(modeloTabla);
        tablaProductos.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaProductos.setRowHeight(25);

        // Agregar algunos datos de ejemplo
        
        var movimientos = movimientoServicio.getMovimientos();
        
        for(Movimiento movimiento : movimientos){
            modeloTabla.addRow(new Object[]{movimiento.getID_Producto(), movimiento.getTipoMovimiento(), movimiento.getCantidad(), movimiento.getFechaMovimiento(), movimiento.getMotivo()});
        }

        // Colocar la tabla en un panel con barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Botón para cerrar la ventana
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });
        
        // Agregar el botón en la parte inferior de la ventana
        JPanel panelBoton = new JPanel();
        panelBoton.add(cerrarButton);
        frame.add(panelBoton, BorderLayout.SOUTH);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
