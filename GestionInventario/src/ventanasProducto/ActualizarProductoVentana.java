package ventanasProducto;

import servicios.ProductoServicio;
import clasesBase.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarProductoVentana {

    private ProductoServicio productoServicio;

    public ActualizarProductoVentana(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Actualizar Producto");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Etiqueta y campo de texto para el ID del producto
        JLabel idLabel = new JLabel("Ingrese el ID del producto:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(idLabel);

        JTextField idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(200, 25));
        idField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(idField);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Botón Buscar
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProducto = idField.getText().trim();
                      
                if (!idProducto.isEmpty()) {
                    
                    Producto producto = productoServicio.obtenerProductoPorID(Integer.parseInt(idProducto));

                    if (producto != null) {
                        JOptionPane.showMessageDialog(frame, "Producto encontrado: " + producto.getNombre());
                        new ActualizarProductoVentanaFormulario(producto).mostrar();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(buscarButton);

        // Botón Cerrar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });
        buttonPanel.add(cerrarButton);

        // Agregar el panel de botones al panel principal
        panel.add(buttonPanel);

        // Agregar el panel a la ventana y hacer visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
