import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaLogin {
    private UsuarioServicio usuarioServicio;
    private ProductoServicio prodcutoServicio;
    private ProveedorServicio proveedorServicio;

    public PantallaLogin(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
    
    public PantallaLogin(UsuarioServicio usuarioServicio, ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio) {
        this.usuarioServicio = usuarioServicio;
        this.prodcutoServicio = prodcutoServicio;
        this.proveedorServicio = proveedorServicio;
    }

    

    public void mostrar() {
        // Crear el frame
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

        // Crear el panel principal con GridBagLayout para centrar componentes
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));  // Color de fondo suave
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear los componentes
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField correoTextField = new JTextField(15);
        
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JPasswordField contrasenaPasswordField = new JPasswordField(15);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(51, 153, 255));  // Color azul para el botón
        loginButton.setForeground(Color.WHITE);  // Texto blanco en el botón
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Añadir los componentes al panel con configuración de centrado
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(correoLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(correoTextField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(contrasenaLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(contrasenaPasswordField, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);

        // Acción del botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = correoTextField.getText();
                String contrasena = new String(contrasenaPasswordField.getPassword());

                Usuario temporalUser = new Usuario(correo, contrasena);

                if (usuarioServicio.validarUsuario(temporalUser)) {
                    JOptionPane.showMessageDialog(frame, "Login exitoso");
                    frame.dispose();  // Cerrar la ventana de login
                    usuarioServicio.mostrarPantallaPrincipal(usuarioServicio.obtenerUsuarioPorCorreo(correo), prodcutoServicio, proveedorServicio);
                } else {
                    JOptionPane.showMessageDialog(frame, "Correo o contraseña incorrectos. Intente de nuevo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
