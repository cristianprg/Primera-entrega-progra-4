package ventanasUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import servicios.UsuarioServicio;

public class RegistrarUsuarioVentana {
    public UsuarioServicio usuarioServicio;

    public RegistrarUsuarioVentana(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    public void mostrar() {
        // Crear el frame
        JFrame frame = new JFrame("Formulario de Registro de Usuario");
        frame.setSize(500, 650); // Ajustado para los nuevos campos
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Crear el panel principal con un borde para separación
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaciado interno

        // Campos del formulario
        JLabel idUsuarioLabel = new JLabel("ID de Usuario:");
        JTextField idUsuarioTextField = new JTextField(20);

        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreTextField = new JTextField(20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        JTextField apellidoTextField = new JTextField(20);

        JLabel tipoDocumentoLabel = new JLabel("Tipo de documento de identidad:");
        String[] opcionesDocumento = {"C.C", "T.I", "C.E"};
        JComboBox<String> tipoDocumentoComboBox = new JComboBox<>(opcionesDocumento);

        JLabel numeroDocumentoLabel = new JLabel("Número de documento:");
        JTextField numeroDocumentoTextField = new JTextField(20);

        JLabel direccionLabel = new JLabel("Dirección:");
        JTextField direccionTextField = new JTextField(20);

        JLabel correoLabel = new JLabel("Correo electrónico:");
        JTextField correoTextField = new JTextField(20);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        JPasswordField contrasenaTextField = new JPasswordField(20);

        JLabel telefonoLabel = new JLabel("Teléfono:");
        JTextField telefonoTextField = new JTextField(20);

        JLabel tipoUsuarioLabel = new JLabel("Tipo de Usuario:");
        String[] opcionesUsuario = {"Administrador", "Auxiliar"};
        JComboBox<String> tipoUsuarioComboBox = new JComboBox<>(opcionesUsuario);

        // Botones con colores
        JButton agregarButton = new JButton("Agregar");
        agregarButton.setBackground(new Color(30, 144, 255)); // Azul
        agregarButton.setForeground(Color.WHITE);
        agregarButton.setFocusPainted(false);

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.setBackground(new Color(220, 20, 60)); // Rojo
        cerrarButton.setForeground(Color.WHITE);
        cerrarButton.setFocusPainted(false);

        // Configuración de botones
        agregarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cerrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar componentes al panel con centrado y espaciado
        panel.add(idUsuarioLabel);
        panel.add(idUsuarioTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(nombreLabel);
        panel.add(nombreTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(apellidoLabel);
        panel.add(apellidoTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(tipoDocumentoLabel);
        panel.add(tipoDocumentoComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(numeroDocumentoLabel);
        panel.add(numeroDocumentoTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(direccionLabel);
        panel.add(direccionTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(correoLabel);
        panel.add(correoTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(contrasenaLabel);
        panel.add(contrasenaTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(telefonoLabel);
        panel.add(telefonoTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(tipoUsuarioLabel);
        panel.add(tipoUsuarioComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(agregarButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(cerrarButton);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);

        // Acción del botón "Cerrar"
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });

        // Acción del botón "Agregar"
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuario = Integer.parseInt(idUsuarioTextField.getText());
                    String nombre = nombreTextField.getText();
                    String apellido = apellidoTextField.getText();
                    String tipoDocumento = (String) tipoDocumentoComboBox.getSelectedItem();
                    String numeroDocumento = numeroDocumentoTextField.getText();
                    String direccion = direccionTextField.getText();
                    String correo = correoTextField.getText();
                    String contrasena = new String(contrasenaTextField.getPassword());
                    String telefono = telefonoTextField.getText();
                    String tipoUsuario = (String) tipoUsuarioComboBox.getSelectedItem();

                    // Registrar usuario en el servicio
                    usuarioServicio.crearUsuario(idUsuario, nombre, apellido, tipoDocumento, numeroDocumento, direccion, correo, contrasena, telefono, true, tipoUsuario);

                    JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
