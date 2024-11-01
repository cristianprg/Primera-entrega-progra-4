import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoVentana {
    private ProductoServicio productoServicio;

    public ProductoVentana(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }
    

    public void mostrar() {
        // Crear el marco principal
        JFrame frame = new JFrame("Gestión de Productos");
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // Cambiar a 5 filas para incluir el botón Cerrar
        panel.setBackground(new Color(245, 245, 245));

        // Botón "Crear Producto"
        JButton btnCrearProducto = new JButton("Crear Producto");
        btnCrearProducto.setFont(new Font("Arial", Font.BOLD, 14));
        btnCrearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroProductoVentana(productoServicio).mostrar();
            }
        });
        panel.add(btnCrearProducto);

        // Botón "Ver Productos"
        JButton btnVerProductos = new JButton("Ver Productos");
        btnVerProductos.setFont(new Font("Arial", Font.BOLD, 14));
        btnVerProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerProductosVentana(productoServicio).mostrar();
            }
        });
        panel.add(btnVerProductos);

        // Botón "Actualizar Producto"
        JButton btnActualizarProducto = new JButton("Actualizar Producto");
        btnActualizarProducto.setFont(new Font("Arial", Font.BOLD, 14));
        btnActualizarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ActualizarProductoVentana(productoServicio).mostrar();
            }
        });
        panel.add(btnActualizarProducto);

        // Botón "Eliminar Producto"
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setFont(new Font("Arial", Font.BOLD, 14));
        btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarProductoVentana(productoServicio).mostrar();
            }
        });
        panel.add(btnEliminarProducto);

        // Botón "Cerrar"
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCerrar.setBackground(new Color(255, 51, 51));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
            }
        });
        panel.add(btnCerrar);

        // Agregar el panel a la ventana y hacer visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
