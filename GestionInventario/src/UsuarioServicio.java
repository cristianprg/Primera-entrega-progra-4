import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioServicio {
    private UsuarioRepositorio usuarioRepositorio;
    
    
    public UsuarioServicio() {
        this.usuarioRepositorio = new UsuarioRepositorio();
        
        usuarioRepositorio.crearUsuario(0);
        usuarioRepositorio.modificarUsurario(0, 1, "John", "Piedrahita", "C.C", "1047396518", "La casa de mi abuela", "no_spam@gmail.com", "1234jajamelo", "3789928611", true);
        
        usuarioRepositorio.crearUsuario(1);
        usuarioRepositorio.modificarUsurario(1, 1, "Mel", "Gibson", "T.I", "4463728436", "La casa de mi abuelo", "mell_pepe@utp.com", "contrasena", "3324723681", true);
        
        usuarioRepositorio.crearUsuario(2);
        usuarioRepositorio.modificarUsurario(2, 1, "Cristian", "Lopez", "C.C", "0000000000", "The White House", "admin@admin.com", "admin123", "999999999", true);
        
    }
    
    public boolean validarUsuario(Usuario usuarioSeleccionado){
        
        Usuario newUsuario = usuarioRepositorio.obtenerUsuarioPorCorreo(usuarioSeleccionado.getCorreoElectronico());
        boolean flag = false;
        
        if(newUsuario.isEstado()){
            if(newUsuario.getContrasena().equals(usuarioSeleccionado.getContrasena())){
                flag = true;
            }
        }
        
        return flag;
    }
    
public void pantallaLogin() {
    // Crear el frame
    JFrame frame = new JFrame("Login");
    frame.setSize(900, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Crear los componentes
    JLabel correoLabel = new JLabel("Correo:");
    JTextField correoTextField = new JTextField(15);
    JLabel contrasenaLabel = new JLabel("Contraseña:");
    JPasswordField contrasenaPasswordField = new JPasswordField(15);
    JButton loginButton = new JButton("Login");

    // Panel con GridBagLayout para centrar los componentes
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER; // Centra los componentes

    // Agregar los componentes al panel
    panel.add(correoLabel, gbc);
    gbc.gridx = 1;
    panel.add(correoTextField, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(contrasenaLabel, gbc);
    gbc.gridx = 1;
    panel.add(contrasenaPasswordField, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(loginButton, gbc);

    // Agregar el panel al frame
    frame.add(panel);
    frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    frame.setVisible(true);

    // Acción del botón de login
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String correo = correoTextField.getText();
            String contrasena = new String(contrasenaPasswordField.getPassword());

            Usuario temporalUser = new Usuario(correo, contrasena);

            if (validarUsuario(temporalUser)) {
                JOptionPane.showMessageDialog(frame, "Login exitoso");
                frame.dispose(); // Cerrar la ventana de login
                pantallaPrincipal(usuarioRepositorio.obtenerUsuarioPorCorreo(correo)); // Mostrar pantalla principal
            } else {
                JOptionPane.showMessageDialog(frame, "Correo o contraseña incorrectos. Intente de nuevo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                frame.dispose();
                pantallaLogin();
            }
        }
    });
}

public void pantallaPrincipal(Usuario usuario) {
    // Crear el frame
    JFrame frame = new JFrame("Pantalla Principal");
    frame.setSize(1200, 900);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Crear los componentes
    JLabel welcomeLabel = new JLabel("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido());
    JButton logoutButton = new JButton("Cerrar Sesión");

    // Panel con GridBagLayout para centrar los componentes
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(20, 20, 20, 20); // Espaciado entre componentes
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER; // Centrar los componentes

    // Agregar los componentes al panel
    panel.add(welcomeLabel, gbc);
    
    gbc.gridy = 1;
    panel.add(logoutButton, gbc);

    // Agregar el panel al frame
    frame.add(panel);
    frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    frame.setVisible(true);

    // Acción del botón de cerrar sesión
    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose(); // Cierra la ventana principal
            pantallaLogin(); // Vuelve a la pantalla de login
        }
    });
    }
}
