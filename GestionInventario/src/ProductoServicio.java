public class ProductoServicio extends ProductoRepositorio{
    private final ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
        
        productoRepositorio.createProducto(0, 12, 15.99, "Dog Chaw", "Mascotas", null);
        productoRepositorio.createProducto(1, 4, 20.99, "Jack Daniels", "Licor", "02-02-2025");
        productoRepositorio.createProducto(2, 10, 5.99, "Aceite Motul", "Vehiculos", null);
        
    }
    
}
