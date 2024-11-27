package ventanasProveedor;

import servicios.ProveedorServicio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarProveedorVentana {
    
    private ProveedorServicio proveedorServicio;

    public AgregarProveedorVentana(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Agregar Proveedor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo ID
        JLabel idLabel = new JLabel("ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        JTextField idField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(idField, gbc);

        // Campo Nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nombreLabel, gbc);

        JTextField nombreField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        // Campo Dirección
        JLabel direccionLabel = new JLabel("Dirección:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(direccionLabel, gbc);

        JTextField direccionField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(direccionField, gbc);

        // Campo Teléfono
        JLabel telefonoLabel = new JLabel("Teléfono:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(telefonoLabel, gbc);

        JTextField telefonoField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(telefonoField, gbc);

        // Botón Agregar
        JButton agregarButton = new JButton("Agregar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario
                String id = idField.getText();
                String nombre = nombreField.getText();
                String direccion = direccionField.getText();
                String telefono = telefonoField.getText();

                // Validación simple de datos
                if (!id.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Proveedor agregado:\nID: " + id + "\nNombre: " + nombre);
                    proveedorServicio.createProveedor(Integer.parseInt(id), nombre, direccion, telefono);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(agregarButton, gbc);

        // Botón Cerrar
        JButton cerrarButton = new JButton("Cerrar");
        gbc.gridx = 1;
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });
        panel.add(cerrarButton, gbc);

        // Agregar el panel a la ventana y hacer visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
