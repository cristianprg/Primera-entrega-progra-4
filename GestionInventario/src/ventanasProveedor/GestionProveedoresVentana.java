package ventanasProveedor;

import servicios.ProveedorServicio;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clasesBase.Usuario;

public class GestionProveedoresVentana {
    
    private ProveedorServicio proveedorServicio;
    private Usuario usuario;

    public GestionProveedoresVentana(Usuario usuario, ProveedorServicio proveedorServicio) {
        this.usuario = usuario;
        this.proveedorServicio = proveedorServicio;
    }

    public void mostrar() {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Gestión de Proveedores");
        if(usuario.getTipoUsuario().equals("Administrador")){
            frame.setSize(400, 350); 
        }else{
            frame.setSize(400, 250); 
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Crear botones
        JButton btnIngresarProveedor = new JButton("Ingresar Proveedor");
        btnIngresarProveedor.setBounds(50, 30, 300, 30);
        frame.add(btnIngresarProveedor);
        
        if(usuario.getTipoUsuario().equals("Administrador")){
             JButton btnActualizarProveedor = new JButton("Actualizar Proveedor");
            btnActualizarProveedor.setBounds(50, 80, 300, 30);
            frame.add(btnActualizarProveedor);

            JButton btnEliminarProveedor = new JButton("Eliminar Proveedor");
            btnEliminarProveedor.setBounds(50, 130, 300, 30);
            frame.add(btnEliminarProveedor);
            
            JButton btnVerProveedores = new JButton("Ver Proveedores");
            btnVerProveedores.setBounds(50, 180, 300, 30);
            frame.add(btnVerProveedores);
            
            btnActualizarProveedor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ActualizarProveedorVentana(proveedorServicio).mostrar();
                }
            });

            btnEliminarProveedor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EliminarProveedorVentana(proveedorServicio).mostrar();
                }
            });
            btnVerProveedores.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new VerProveedoresVentana(proveedorServicio).mostrar();
                }
            });
            
            JButton btnCerrar = new JButton("Cerrar");
            btnCerrar.setBounds(50, 230, 300, 30);
            btnCerrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose(); // Cierra la ventana actual
                }
            });
            frame.add(btnCerrar);
        }else{
            
            JButton btnVerProveedores = new JButton("Ver Proveedores");
            btnVerProveedores.setBounds(50, 80, 300, 30);
            frame.add(btnVerProveedores);
            
            btnVerProveedores.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new VerProveedoresVentana(proveedorServicio).mostrar();
                }
            });
            
            JButton btnCerrar = new JButton("Cerrar");
            btnCerrar.setBounds(50, 130, 300, 30);
            btnCerrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose(); // Cierra la ventana actual
                }
            });
            frame.add(btnCerrar);
        }
        

        

        // Botón Cerrar
        

        // Añadir ActionListeners a los botones existentes
        btnIngresarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarProveedorVentana(proveedorServicio).mostrar();
            }
        });
        
        // Hacer visible el marco
        frame.setVisible(true);
    }
}
