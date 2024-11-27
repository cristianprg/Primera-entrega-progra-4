package servicios;


import ventanasPrincipales.PantallaPrincipal;
import ventanasPrincipales.PantallaLogin;
import repositorios.UsuarioRepositorio;
import clasesBase.Usuario;



public class UsuarioServicio extends UsuarioRepositorio{
    private UsuarioRepositorio usuarioRepositorio;
    private ProductoServicio prodcutoServicio;
    private ProveedorServicio proveedorServicio;
    private MovimientoServicio movimientoServicio;
    
    
    public UsuarioServicio() {
        this.usuarioRepositorio = new UsuarioRepositorio();
        
        usuarioRepositorio.crearUsuario(1, "John", "Piedrahita", "C.C", "1047396518", "La casa de mi abuela", "no_spam@gmail.com", "1234jajamelo", "3789928611", true, "Auxiliar");
        
        usuarioRepositorio.crearUsuario(2, "Usuario", "Administrador", "T.I", "4463728436", "La casa de mi abuelo", "", "", "3324723681", true, "Administrador");
        
        usuarioRepositorio.crearUsuario(3, "Cristian", "Lopez", "C.C", "0000000000", "The White House", "123@123.com", "123", "999999999", true, "Auxiliar");
        
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
    
public void iniciarLogin(ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio, MovimientoServicio movimientoServicio) {
        new PantallaLogin(this, prodcutoServicio, proveedorServicio, movimientoServicio).mostrar();
    }

    public void mostrarPantallaPrincipal(Usuario usuario, ProductoServicio prodcutoServicio, ProveedorServicio proveedorServicio, MovimientoServicio movimientoServicio) {
        new PantallaPrincipal(usuario, prodcutoServicio, proveedorServicio, movimientoServicio, this).mostrar();
    }
}
