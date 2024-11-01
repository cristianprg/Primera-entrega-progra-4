import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroProductoVentana {
    
    private ProductoServicio productoServicio;

    public RegistroProductoVentana(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public void mostrar() {
        // Crear el marco principal
        JFrame frame = new JFrame("Agregar nuevo producto");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        JLabel tituloLabel = new JLabel("Agregar nuevo producto");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloLabel.setForeground(new Color(51, 102, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(tituloLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // ID
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(idLabel, gbc);

        JTextField idField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(idField, gbc);

        // Cantidad
        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cantidadLabel, gbc);

        JTextField cantidadField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(cantidadField, gbc);

        // Precio Unitario
        JLabel precioLabel = new JLabel("Precio Unitario:");
        precioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(precioLabel, gbc);

        JTextField precioField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(precioField, gbc);

        // Nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(nombreLabel, gbc);

        JTextField nombreField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        // Categoría
        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(categoriaLabel, gbc);

        String[] categorias = {"Alimentos", "Bebidas", "Limpieza", "Electrónica"};
        JComboBox<String> categoriaCombo = new JComboBox<>(categorias);
        gbc.gridx = 1;
        panel.add(categoriaCombo, gbc);

        // Fecha de Expiración
        JLabel fechaExpLabel = new JLabel("Fecha de Expiración (opcional):");
        fechaExpLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(fechaExpLabel, gbc);

        JTextField fechaExpField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(fechaExpField, gbc);

        // Botón Agregar
        JButton agregarButton = new JButton("Agregar");
        agregarButton.setFont(new Font("Arial", Font.BOLD, 14));
        agregarButton.setBackground(new Color(51, 153, 255));
        agregarButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(agregarButton, gbc);

        // Acción del botón Agregar
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    int cantidad = Integer.parseInt(cantidadField.getText());
                    double precioUnitario = Double.parseDouble(precioField.getText());
                    String nombre = nombreField.getText();
                    String categoria = (String) categoriaCombo.getSelectedItem();
                    String fechaExpiracion = fechaExpField.getText();

                    // Validar que los campos obligatorios no estén vacíos
                    if (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "El nombre del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Mostrar el mensaje del producto agregado
                    String mensaje = "Producto agregado:\nID: " + id + "\nNombre: " + nombre;
                    if (!fechaExpiracion.isEmpty()) {
                        mensaje += "\nFecha de Expiración: " + fechaExpiracion;
                    }
                    JOptionPane.showMessageDialog(frame, mensaje);
                    
                    productoServicio.createProducto(id, cantidad, precioUnitario, nombre, categoria, fechaExpiracion);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón Cerrar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cerrarButton.setBackground(new Color(255, 51, 51));
        cerrarButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(cerrarButton, gbc);

        // Acción del botón Cerrar
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });

        // Agregar el panel a la ventana y hacer visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
