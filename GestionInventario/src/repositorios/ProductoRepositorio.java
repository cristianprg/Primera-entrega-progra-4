package repositorios;

import clasesBase.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorio {
    private static final List<Producto> productos = new ArrayList<>();

    public static List<Producto> getProductos() {
        return productos;
    }
    
    public void createProducto(int id, int cantidad, double precioUnitario, String nombre, String categoria, String fechaExpiracion, int ID_Proveedor){
        productos.add(new Producto(id, cantidad, precioUnitario, nombre, categoria, fechaExpiracion, ID_Proveedor, cantidad / 5, cantidad * 2));
    }
    
    public Producto obtenerProductoPorID(int ID){
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getId() == ID){
                return productos.get(i);
            }
        }
        return null;
    }
    
    public void delteProducto(Producto producto){
        productos.remove(producto);
    }
    
    public void actualizarProducto(int id, int cantidad, double precioUnitario, String nombre, String categoria, String fechaExpiracion, int ID_Proveedor){
        Producto temporalProducto = obtenerProductoPorID(id);
        if(temporalProducto != null){
            temporalProducto.setCantidad(cantidad);
            temporalProducto.setPrecioUnitario(precioUnitario);
            temporalProducto.setNombre(nombre);
            temporalProducto.setCategoria(categoria);
            temporalProducto.setCantidad(cantidad);
            temporalProducto.setID_Proveedor(ID_Proveedor);
            temporalProducto.setStockMinimo(cantidad / 5);
            temporalProducto.setStockMaximo(cantidad * 2);
        }
    }
}
