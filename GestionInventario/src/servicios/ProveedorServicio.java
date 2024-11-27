package servicios;


import repositorios.ProveedorRepositorio;

public class ProveedorServicio extends ProveedorRepositorio{
    private final ProveedorRepositorio proveedorRepositorio;

    public ProveedorServicio(ProveedorRepositorio proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
        
        proveedorRepositorio.createProveedor(0, "Pedro Gonzalez", "Carrera 15 #23-40", "3136315875");
        proveedorRepositorio.createProveedor(1, "Maria Castaño", "Calle 18 #15-24", "3198764511");
        proveedorRepositorio.createProveedor(2, "Licores Colombia", "Avenida Circunvalar, Local 3", "3145723100");
        
    }
    
    
    
}
