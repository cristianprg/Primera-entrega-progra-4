package clasesBase;

import servicios.MovimientoServicio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    MovimientoServicio movimientoServicio;
    int ID_Producto, Cantidad, ID_Proveedor;
    String Estado;

    public Pedido(MovimientoServicio movimientoServicio, int ID_Producto, int Cantidad, int ID_Proveedor, String Estado) {
        this.movimientoServicio = movimientoServicio;
        this.ID_Producto = ID_Producto;
        this.Cantidad = Cantidad;
        this.ID_Proveedor = ID_Proveedor;
        this.Estado = Estado;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public void hacerPedidoMovimiento(){
        movimientoServicio.createMovimiento(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "Ingreso", "Se ingresa por pedido debido a falta de stock", ID_Producto, Cantidad);
    }
}
