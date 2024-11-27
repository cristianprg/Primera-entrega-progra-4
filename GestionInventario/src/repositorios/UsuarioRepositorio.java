package repositorios;

import clasesBase.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private static final List<Usuario> usuarios = new ArrayList<>();
    
    public int getLenght(){
        return usuarios.size();
    }
    
    public void crearUsuario(int id, String nombre, String apellido, String tipoDocumentoIdentidad, String numeroDocumentoIdentidad, String direccion, String correoElectronico, String contrasena, String telefono, boolean estado, String tipoUsuario){
        usuarios.add(new Usuario(id, nombre, apellido, tipoDocumentoIdentidad, numeroDocumentoIdentidad, direccion, correoElectronico, contrasena, telefono, estado, tipoUsuario));
    }
    
    public void modificarUsurario(Usuario usuario, int id, String nombre, String apellido, String tipoDocumentoIdentidad, String numeroDocumentoIdentidad, String direccion, String correoElectronico, String contrasena, String telefono, boolean estado, String tipoUsuario){
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTipoDocumentoIdentidad(tipoDocumentoIdentidad);
        usuario.setNumeroDocumentoIdentidad(numeroDocumentoIdentidad);
        usuario.setDireccion(direccion);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setContrasena(contrasena);
        usuario.setTelefono(telefono);
        usuario.setEstado(estado);
        usuario.setTipoUsuario(tipoUsuario);
    }
    
    public Usuario obtenerUsuarioPorCorreo(String correo){
        
        for (Usuario usuario : usuarios) {
            if (usuario == null) {
                break;
            }
            if (usuario.getCorreoElectronico().equals(correo)) {
                return usuario;
            }
        }
        return new Usuario();
    }
    
    public void obtenerUsuariosGeneral(){
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }
    
    public void activarUsuario(Usuario usuarioSeleccionado){
        usuarioSeleccionado.setEstado(true);
    }
    
    public void inactivarUsuario(Usuario usuarioSeleccionado){
        usuarioSeleccionado.setEstado(false);
    }
}