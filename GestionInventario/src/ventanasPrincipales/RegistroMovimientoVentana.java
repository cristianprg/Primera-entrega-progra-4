package ventanasPrincipales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import servicios.MovimientoServicio;

public class RegistroMovimientoVentana {

    private MovimientoServicio movimientoServicio;

    public RegistroMovimientoVentana(MovimientoServicio movimientoServicio) {
        this.movimientoServicio = movimientoServicio;
    }

    public void mostrar() {
        // Crear el frame
        JFrame frame = new JFrame("Formulario de Movimiento");
        frame.setSize(500, 400); // Tamaño ajustado para que todos los elementos quepan
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Crear el panel principal con un borde para separación
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaciado interno

        // Campos del formulario
        JLabel fechaLabel = new JLabel("Fecha del movimiento:");
        JTextField fechaTextField = new JTextField(20);

        JLabel tipoMovimientoLabel = new JLabel("Tipo de movimiento:");
        String[] opcionesMovimiento = {"Ingreso", "Venta"};
        JComboBox<String> tipoMovimientoComboBox = new JComboBox<>(opcionesMovimiento);

        JLabel motivoLabel = new JLabel("Motivo:");
        JTextField motivoTextField = new JTextField(20);

        JLabel idProductoLabel = new JLabel("ID del producto:");
        JTextField idProductoTextField = new JTextField(20);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        JTextField cantidadTextField = new JTextField(20);

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
        panel.add(fechaLabel);
        panel.add(fechaTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado entre campos

        panel.add(tipoMovimientoLabel);
        panel.add(tipoMovimientoComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(motivoLabel);
        panel.add(motivoTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(idProductoLabel);
        panel.add(idProductoTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(cantidadLabel);
        panel.add(cantidadTextField);
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
                String fecha = fechaTextField.getText();
                String tipoMovimiento = (String) tipoMovimientoComboBox.getSelectedItem();
                String motivo = motivoTextField.getText();
                int idProducto;
                int cantidad;

                try {
                    idProducto = Integer.parseInt(idProductoTextField.getText());
                    cantidad = Integer.parseInt(cantidadTextField.getText());
                    
                    if(tipoMovimiento.equals("Venta")){
                        cantidad = cantidad * -1;
                    }

                    movimientoServicio.createMovimiento(fecha, tipoMovimiento, motivo, idProducto, cantidad);

                    JOptionPane.showMessageDialog(frame, "Movimiento agregado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor ingrese valores válidos para ID y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
