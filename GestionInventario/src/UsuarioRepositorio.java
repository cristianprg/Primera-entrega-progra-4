
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private static List<Usuario> usuarios = new ArrayList<>();
    
    public int getLenght(){
        return usuarios.size();
    }
    
    public void crearUsuario(int newPosition){
        usuarios.add(new Usuario());
    }
    
    public void modificarUsurario(int position, int id, String nombre, String apellido, String tipoDocumentoIdentidad, String numeroDocumentoIdentidad, String direccion, String correoElectronico, String contrasena, String telefono, boolean estado ){
        usuarios.get(position).setId(id);
        usuarios.get(position).setNombre(nombre);
        usuarios.get(position).setApellido(apellido);
        usuarios.get(position).setTipoDocumentoIdentidad(tipoDocumentoIdentidad);
        usuarios.get(position).setNumeroDocumentoIdentidad(numeroDocumentoIdentidad);
        usuarios.get(position).setDireccion(direccion);
        usuarios.get(position).setCorreoElectronico(correoElectronico);
        usuarios.get(position).setContrasena(contrasena);
        usuarios.get(position).setTelefono(telefono);
        usuarios.get(position).setEstado(estado);
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
