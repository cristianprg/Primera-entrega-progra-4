import java.util.ArrayList;
import java.util.List;

public class ProveedorRepositorio {
    private static final List<Proveedor> proveedores = new ArrayList<>();
    
    public void createProveedor(int id, String nombre, String direccion, String telefono){
        proveedores.add(new Proveedor(id, nombre, direccion, telefono));
    }

    public static List<Proveedor> getProveedores() {
        return proveedores;
    }
    
    public void deleteProveedor(Proveedor proveedor){
        proveedores.remove(proveedor);
    }
    
    public Proveedor obtenerProveedorPorID(int ID){
        for(int i = 0; i < proveedores.size(); i++){
            if(proveedores.get(i).getId() == ID){
                return proveedores.get(i);
            }
        }
        return null;
    }
    
    public void actualizarProveedor(int id, String nombre, String direccion, String telefono){
        Proveedor temporalProveedor = obtenerProveedorPorID(id);
        if(temporalProveedor != null){
            temporalProveedor.setNombre(nombre);
            temporalProveedor.setDireccion(direccion);
            temporalProveedor.setTelefono(telefono);
        }
    }
}
