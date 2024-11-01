import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerProveedoresVentana {
    
    private ProveedorServicio proveedorServicio;

    public VerProveedoresVentana(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Proveedores");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");

        // Crear la tabla con el modelo
        JTable tablaProveedores = new JTable(modeloTabla);
        tablaProveedores.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaProveedores.setRowHeight(25);

        var proveedores = proveedorServicio.getProveedores();
        
        for(Proveedor proveedor : proveedores){
            modeloTabla.addRow(new Object[]{proveedor.getId(), proveedor.getNombre(), proveedor.getDireccion(), proveedor.getTelefono()});
        }

        // Colocar la tabla en un panel con barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(tablaProveedores);
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

