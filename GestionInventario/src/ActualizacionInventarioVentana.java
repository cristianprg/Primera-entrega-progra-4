import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizacionInventarioVentana {

    private ProductoServicio productoServicio;

    public ActualizacionInventarioVentana(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Actualizar Producto");
        frame.setSize(400, 250);
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

        // Etiqueta y campo de texto para la nueva cantidad
        JLabel cantidadLabel = new JLabel("Nueva cantidad:");
        cantidadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cantidadLabel);

        JTextField cantidadField = new JTextField(20);
        cantidadField.setMaximumSize(new Dimension(200, 25));
        cantidadField.setAlignmentX(Component.CENTER_ALIGNMENT);
        cantidadField.setEnabled(false);  // Inicialmente deshabilitado hasta que se encuentre el producto
        panel.add(cantidadField);

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
                    // Llamada a la función de búsqueda en productoServicio
                    Producto producto = productoServicio.obtenerProductoPorID(Integer.parseInt(idProducto));

                    if (producto != null) {
                        JOptionPane.showMessageDialog(frame, "Producto encontrado: " + producto.toString());
                        cantidadField.setEnabled(true); // Activar el campo de cantidad
                    } else {
                        JOptionPane.showMessageDialog(frame, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        cantidadField.setEnabled(false); // Desactivar el campo de cantidad si no se encuentra
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(buscarButton);

        // Botón Actualizar
        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.setEnabled(false); // Inicialmente deshabilitado
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaCantidadText = cantidadField.getText().trim();
                
                if (!nuevaCantidadText.isEmpty()) {
                    try {
                        int nuevaCantidad = Integer.parseInt(nuevaCantidadText);
                        Producto producto = productoServicio.obtenerProductoPorID(Integer.parseInt(idField.getText()));
                        producto.setCantidad(nuevaCantidad);
                        JOptionPane.showMessageDialog(frame, "Cantidad actualizada a: " + nuevaCantidad);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese una nueva cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(actualizarButton);

        // Botón Cerrar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });
        buttonPanel.add(cerrarButton);

        // Activar/desactivar botón "Actualizar" basado en la búsqueda
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarButton.setEnabled(cantidadField.isEnabled());
            }
        });

        // Agregar el panel de botones al panel principal
        panel.add(buttonPanel);

        // Agregar el panel a la ventana y hacer visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
