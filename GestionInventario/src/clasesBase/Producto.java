package clasesBase;

public class Producto {
    private int id, cantidad, ID_Proveedor, stockMinimo, stockMaximo;
    private double precioUnitario;
    private String nombre, categoria, fechaExpiracion;

    public Producto(int id, int cantidad, double precioUnitario, String nombre, String categoria, String fechaExpiracion, int ID_Proveedor, int stockMinimo, int stockMaximo) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaExpiracion = fechaExpiracion;
        this.ID_Proveedor = ID_Proveedor;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }
    
    
    
    
}
