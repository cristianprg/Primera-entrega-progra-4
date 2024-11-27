package ventanasPrincipales;

import ventanasProveedor.GestionProveedoresVentana;
import ventanasUsuario.RegistrarUsuarioVentana;
import ventanasProducto.ProductoVentana;
import ventanasMovimiento.VerMovimientosVentana;
import servicios.ProductoServicio;
import servicios.ProveedorServicio;
import servicios.UsuarioServicio;
import servicios.MovimientoServicio;
import clasesBase.Usuario;
import clasesBase.Notificacion;
import clasesBase.ReporteCSV;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal {
    private UsuarioServicio usuarioServicio;
    private Usuario usuario;
    private ProductoServicio prodcutoServicio;
    private ProveedorServicio proveedorServicio;
    private MovimientoServicio movimientoServicio;

    public PantallaPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    public PantallaPrincipal(Usuario usuario, ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio, MovimientoServicio movimientoServicio, UsuarioServicio usuarioServicio) {
        this.usuario = usuario;
        this.prodcutoServicio = prodcutoServicio;
        this.proveedorServicio = proveedorServicio;
        this.movimientoServicio = movimientoServicio;
        this.usuarioServicio = usuarioServicio;
    }
    
    

    public void mostrar() {
        
        // Crear el frame
        JFrame frame = new JFrame("Pantalla Principal");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
        
        //Se crea el pbjeto notificación que después se encargará de revisar y hacer pedidos automáticamente.
        Notificacion notificacion = new Notificacion(prodcutoServicio, movimientoServicio, frame);

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
        JButton actualizacionInventarioButton = new JButton("Registro de Movimientos");
        JButton verMovimientosButton = new JButton("Ver movimientos");
        JButton consultaInventarioButton = new JButton("Consulta de Inventario");
        JButton gestionProveedoresButton = new JButton("Gestión de Proveedores");
        JButton registrarUsuariosButton = new JButton("Agregar nuevo usuario");
        JButton reporteButton = new JButton("Generación de reporte CSV");
        JButton logoutButton = new JButton("Cerrar Sesión");

        // Estilo y alineación de botones
        JButton[] buttons = {registroProductoButton, actualizacionInventarioButton, verMovimientosButton, consultaInventarioButton, gestionProveedoresButton, registrarUsuariosButton, reporteButton, logoutButton};
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
        panel.add(verMovimientosButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(actualizacionInventarioButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(consultaInventarioButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(gestionProveedoresButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(registrarUsuariosButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(reporteButton);
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
                new PantallaLogin(new UsuarioServicio(), prodcutoServicio, proveedorServicio, movimientoServicio).mostrar();  // Vuelve a la pantalla de login
            }
        });

        // Acción para abrir la ventana de registro de productos
        registroProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductoVentana(usuario, prodcutoServicio, proveedorServicio).mostrar();
            }
        });

        // Acción para abrir la ventana de registro de movimientos
        actualizacionInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroMovimientoVentana(movimientoServicio).mostrar();
            }
        });
        
        // Acción para abrir la ventana de movimientos
        verMovimientosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerMovimientosVentana(movimientoServicio).mostrar();
            }
        });

        // Acción para abrir la ventana de consulta de inventario
        consultaInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultaIventarioVentana(prodcutoServicio, movimientoServicio).mostrar();
            }
        });

        // Acción para abrir la ventana de gestión de proveedores
        gestionProveedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionProveedoresVentana(usuario, proveedorServicio).mostrar();
            }
        });
        
        // Acción para abrir la ventana de registro de usuarios
        registrarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.getTipoUsuario().equals("Auxiliar")){
                    JOptionPane.showMessageDialog(frame, "El usuario no tiene permisos para esto,", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }else{
                    new RegistrarUsuarioVentana(usuarioServicio).mostrar();
                }
            }
        });
        
        // Acción para ejecutar la generación de reporte CSV
        reporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReporteCSV reporte = new ReporteCSV(prodcutoServicio, movimientoServicio, frame);
                reporte.GenerarCSV();
            }
        });
        
        //Se hace la verificación  de stock, y se realiza el pedido en caso de ser necesario
        notificacion.CrearNotificacion();
        
    }
}
