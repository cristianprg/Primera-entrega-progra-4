package ventanasPrincipales;

import servicios.ProductoServicio;
import servicios.MovimientoServicio;
import clasesBase.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultaIventarioVentana {
    private ProductoServicio productoServicio;
    private MovimientoServicio movimientoServicio;

    public ConsultaIventarioVentana(ProductoServicio productoServicio, MovimientoServicio movimientoServicio) {
        this.productoServicio = productoServicio;
        this.movimientoServicio = movimientoServicio;
    }

    public void mostrar() {
        // Crear el marco principal
        JFrame frame = new JFrame("Consulta de Inventario");
        frame.setSize(400, 350); // Ajustar el tamaño para el botón Cerrar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre del Producto");
        modeloTabla.addColumn("Stock Disponible");

        // Crear la tabla con el modelo
        JTable tablaInventario = new JTable(modeloTabla);
        tablaInventario.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaInventario.setRowHeight(25);

        // Colocar la tabla en un panel con barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(tablaInventario);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Crear el botón Cerrar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cerrarButton.setBackground(new Color(255, 51, 51));
        cerrarButton.setForeground(Color.WHITE);
        cerrarButton.addActionListener(e -> frame.dispose());

        // Añadir el botón Cerrar en la parte inferior de la ventana
        JPanel panelInferior = new JPanel();
        panelInferior.add(cerrarButton);
        frame.add(panelInferior, BorderLayout.SOUTH);
        
        var productos = productoServicio.getProductos();
        
        for(Producto producto : productos){
            modeloTabla.addRow(new Object[]{producto.getNombre(), movimientoServicio.SumaMovimientosPorId(producto.getId(), producto.getCantidad())});
        }

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
