package ventanasProveedor;

import servicios.ProveedorServicio;
import clasesBase.Proveedor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarProveedorVentana {
    
    private ProveedorServicio proveedorServicio;

    public ActualizarProveedorVentana(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }
    

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Actualizar Proveedor");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo de texto para el ID del proveedor
        JLabel idLabel = new JLabel("Ingrese el ID del proveedor:");
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
                String idProveedor = idField.getText();
                
                // Verificación simple del ID
                if (!idProveedor.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Buscando proveedor con ID: " + idProveedor);
                    
                    Proveedor proveedor = proveedorServicio.obtenerProveedorPorID(Integer.parseInt(idProveedor));
                    
                    if (proveedor != null) {
                        JOptionPane.showMessageDialog(frame, "Proveedor encontrado: " + proveedor.getNombre());
                        new ActualizarProveedorVentanaFormulario(proveedor).mostrar();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Proveedor no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
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
