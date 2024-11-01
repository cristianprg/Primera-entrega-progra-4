import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarProveedorVentanaFormulario {
    
    private Proveedor proveedor;

    public ActualizarProveedorVentanaFormulario(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public void mostrar() { 
        // Crear el marco principal
        JFrame frame = new JFrame("Agregar nuevo proveedor");
        frame.setSize(400, 350);
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
        JLabel tituloLabel = new JLabel("Agregar nuevo proveedor");
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

        // Nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nombreLabel, gbc);

        JTextField nombreField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        // Dirección
        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(direccionLabel, gbc);

        JTextField direccionField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(direccionField, gbc);

        // Teléfono
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(telefonoLabel, gbc);

        JTextField telefonoField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(telefonoField, gbc);

        // Botón Agregar
        JButton agregarButton = new JButton("Actualizar");
        agregarButton.setFont(new Font("Arial", Font.BOLD, 14));
        agregarButton.setBackground(new Color(51, 153, 255));
        agregarButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(agregarButton, gbc);

        // Acción del botón Agregar
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText().trim());
                    String nombre = nombreField.getText().trim();
                    String direccion = direccionField.getText().trim();
                    String telefono = telefonoField.getText().trim();

                    // Validar que los campos obligatorios no estén vacíos
                    if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Mostrar el mensaje del proveedor agregado
                    String mensaje = "Proveedor actualizado:\nID: " + id + "\nNombre: " + nombre + "\nDirección: " + direccion + "\nTeléfono: " + telefono;
                    JOptionPane.showMessageDialog(frame, mensaje);

                    proveedor.setDireccion(direccion);
                    proveedor.setId(id);
                    proveedor.setNombre(nombre);
                    proveedor.setTelefono(telefono);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa un ID numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón Cerrar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cerrarButton.setBackground(new Color(255, 51, 51));
        cerrarButton.setForeground(Color.WHITE);
        gbc.gridy = 6;
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
