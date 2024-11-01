

public class Usuario {
    private int id;
    private String nombre, apellido, tipoDocumentoIdentidad, numeroDocumentoIdentidad, direccion, correoElectronico, contrasena, telefono;
    private boolean estado;
    
    /*Constructor*/
    public Usuario(int id, String nombre, String apellido, String tipoDocumentoIdentidad, String numeroDocumentoIdentidad, String direccion, String correoElectronico, String contrasena, String telefono, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.estado = estado;
    }
    
    public Usuario() {
        this.id = 0000;
        this.nombre = "Default Name";
        this.apellido = "Default Lastname";
        this.tipoDocumentoIdentidad = "C.C";
        this.numeroDocumentoIdentidad = "999999999";
        this.direccion = "Calle X #x-xx";
        this.correoElectronico = "aaaa@aaa.aaa";
        this.contrasena = "123";
        this.telefono = "1234567890";
        this.estado = false;
    }
    
    public Usuario(String correo, String contrasena){
        this.id = 0000;
        this.nombre = "Default Name";
        this.apellido = "Default Lastname";
        this.tipoDocumentoIdentidad = "C.C";
        this.numeroDocumentoIdentidad = "999999999";
        this.direccion = "Calle X #x-xx";
        this.correoElectronico = correo;
        this.contrasena = contrasena;
        this.telefono = "1234567890";
        this.estado = false;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}