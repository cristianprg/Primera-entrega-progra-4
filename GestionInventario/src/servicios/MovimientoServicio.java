package servicios;

import repositorios.MovimientoRepositorio;

public class MovimientoServicio extends MovimientoRepositorio{
    private final MovimientoRepositorio movimientoRepositorio;

    public MovimientoServicio(MovimientoRepositorio movimientoRepositorio) {
        this.movimientoRepositorio = movimientoRepositorio;
        
        movimientoRepositorio.createMovimiento("2024-02-12", "Ingreso", "Se ingresan nuevos articulos al por mayor", 0, 2);
        movimientoRepositorio.createMovimiento("2024-03-15", "Venta", "Se vendieron articulos al cliente", 1, -3);
        movimientoRepositorio.createMovimiento("2024-04-22", "Ingreso", "Se ingresan nuevos articulos al por mayor", 2, 5);
    }
    
    
}
