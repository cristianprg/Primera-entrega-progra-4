

public class UsuarioServicio extends UsuarioRepositorio{
    private UsuarioRepositorio usuarioRepositorio;
    private ProductoServicio prodcutoServicio;
    private ProveedorServicio proveedorServicio;
    
    
    public UsuarioServicio() {
        this.usuarioRepositorio = new UsuarioRepositorio();
        
        usuarioRepositorio.crearUsuario(0);
        usuarioRepositorio.modificarUsurario(0, 1, "John", "Piedrahita", "C.C", "1047396518", "La casa de mi abuela", "no_spam@gmail.com", "1234jajamelo", "3789928611", true);
        
        usuarioRepositorio.crearUsuario(1);
        usuarioRepositorio.modificarUsurario(1, 1, "Mel", "Gibson", "T.I", "4463728436", "La casa de mi abuelo", "", "", "3324723681", true);
        
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
    
public void iniciarLogin(ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio) {
        new PantallaLogin(this, prodcutoServicio, proveedorServicio).mostrar();
    }

    public void mostrarPantallaPrincipal(Usuario usuario, ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio) {
        new PantallaPrincipal(usuario, prodcutoServicio, proveedorServicio).mostrar();
    }
}
