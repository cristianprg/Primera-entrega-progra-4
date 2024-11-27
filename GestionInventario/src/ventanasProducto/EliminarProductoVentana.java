package ventanasProducto;

import servicios.ProductoServicio;
import clasesBase.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarProductoVentana {
    
    private ProductoServicio productoServicio;

    public EliminarProductoVentana(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Eliminar Producto");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo de texto para el ID del producto
        JLabel idLabel = new JLabel("Ingrese el ID del producto:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(idLabel, gbc);

        JTextField idField = new JTextField(20);
        gbc.gridy = 1;
        panel.add(idField, gbc);

        // Botón Buscar
        JButton buscarButton = new JButton("Buscar");
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idProducto = idField.getText();
                
                // Verificación simple del ID
                if (!idProducto.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Buscando producto con ID: " + idProducto);
                    Producto producto = productoServicio.obtenerProductoPorID(Integer.parseInt(idProducto));
                    if(producto != null){
                        productoServicio.delteProducto(producto);
                         JOptionPane.showMessageDialog(frame, "Producto Eliminado");
                    }else{
                         JOptionPane.showMessageDialog(frame, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(buscarButton, gbc);

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

