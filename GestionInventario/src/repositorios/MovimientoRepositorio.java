package repositorios;

import clasesBase.Movimiento;
import java.util.ArrayList;
import java.util.List;

public class MovimientoRepositorio {
    private static final List<Movimiento> movimientos = new ArrayList<>();

    public static List<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    public void createMovimiento(String fechaMovimiento, String tipoMovimiento, String motivo, int ID_Producto, int cantidad){
        movimientos.add(new Movimiento(fechaMovimiento, tipoMovimiento, motivo, ID_Producto, cantidad));
    }
    
    public Movimiento obtenerMovimientoPorID(int ID_Producto){
        for(int i = 0; i < movimientos.size(); i++){
            if(movimientos.get(i).getID_Producto() == ID_Producto){
                return movimientos.get(i);
            }
        }
        return null;
    }
    
    public int SumaMovimientosPorId(int ID_Producto, int CantidadInicial){
        int CantidadFinal = CantidadInicial;
        for(Movimiento movimiento : movimientos){
            if(movimiento.getID_Producto() == ID_Producto){
                CantidadFinal += movimiento.getCantidad();
            }
        }
        
        return CantidadFinal;
    }
}
