package clasesBase;


import servicios.ProductoServicio;
import servicios.ProveedorServicio;
import servicios.MovimientoServicio;
import servicios.UsuarioServicio;
import repositorios.ProveedorRepositorio;
import repositorios.ProductoRepositorio;
import repositorios.MovimientoRepositorio;

public class GestionInventario {

    public static void main(String[] args) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        ProductoServicio productoServicio = new ProductoServicio(new ProductoRepositorio());
        ProveedorServicio proveedorServicio = new ProveedorServicio(new ProveedorRepositorio());
        MovimientoServicio movimientoServicio = new MovimientoServicio(new MovimientoRepositorio());
        
        usuarioServicio.iniciarLogin(productoServicio, proveedorServicio, movimientoServicio);
    }
    
}
