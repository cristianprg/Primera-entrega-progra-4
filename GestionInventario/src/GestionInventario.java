public class GestionInventario {

    public static void main(String[] args) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        ProductoServicio productoServicio = new ProductoServicio(new ProductoRepositorio());
        ProveedorServicio proveedorServicio = new ProveedorServicio(new ProveedorRepositorio());
        
        usuarioServicio.iniciarLogin(productoServicio, proveedorServicio);
    }
    
}
