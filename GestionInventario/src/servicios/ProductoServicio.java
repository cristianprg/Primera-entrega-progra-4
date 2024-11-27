package servicios;


import repositorios.ProductoRepositorio;

public class ProductoServicio extends ProductoRepositorio{
    private final ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
        
        productoRepositorio.createProducto(0, 50, 15.99, "Dog Chaw", "Mascotas", null, 0);
        productoRepositorio.createProducto(1, 60, 20.99, "Jack Daniels", "Licor", "02-02-2025", 1);
        productoRepositorio.createProducto(2, 35, 5.99, "Aceite Motul", "Vehiculos", null, 2);
        
    }
    
}
