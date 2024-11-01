import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal {
    private Usuario usuario;
    private ProductoServicio prodcutoServicio;
    private ProveedorServicio proveedorServicio;

    public PantallaPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    public PantallaPrincipal(Usuario usuario, ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio) {
        this.usuario = usuario;
        this.prodcutoServicio = prodcutoServicio;
        this.proveedorServicio = proveedorServicio;
    }
    
    

    public void mostrar() {
        // Crear el frame
        JFrame frame = new JFrame("Pantalla Principal");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));

        // Crear el componente de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido());
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Crear los botones
        JButton registroProductoButton = new JButton("Registro de Productos");
        JButton actualizacionInventarioButton = new JButton("Actualización de Inventario");
        JButton consultaInventarioButton = new JButton("Consulta de Inventario");
        JButton gestionProveedoresButton = new JButton("Gestión de Proveedores");
        JButton logoutButton = new JButton("Cerrar Sesión");

        // Estilo y alineación de botones
        JButton[] buttons = {registroProductoButton, actualizacionInventarioButton, consultaInventarioButton, gestionProveedoresButton, logoutButton};
        for (JButton button : buttons) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(200, 30));
        }

        // Agregar los componentes al panel
        panel.add(Box.createRigidArea(new Dimension(0, 20)));  // Espacio superior
        panel.add(welcomeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(registroProductoButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(actualizacionInventarioButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(consultaInventarioButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(gestionProveedoresButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(logoutButton);

        // Agregar el panel al frame
        frame.add(panel);
        frame.setVisible(true);

        // Acción del botón de cerrar sesión
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Cierra la ventana principal
                new PantallaLogin(new UsuarioServicio(), prodcutoServicio, proveedorServicio).mostrar();  // Vuelve a la pantalla de login
            }
        });

        // Acción para abrir la ventana de registro de productos
        registroProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductoVentana(prodcutoServicio).mostrar();
            }
        });

        // Acción para abrir la ventana de actualización de inventario
        actualizacionInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ActualizacionInventarioVentana(prodcutoServicio).mostrar();
            }
        });

        // Acción para abrir la ventana de consulta de inventario
        consultaInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultaIventarioVentana(prodcutoServicio).mostrar();
            }
        });

        // Acción para abrir la ventana de gestión de proveedores
        gestionProveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionProveedoresVentana(proveedorServicio).mostrar();
            }
        });
    }
}
