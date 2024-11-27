package clasesBase;

public class Movimiento {
    private String fechaMovimiento, tipoMovimiento, motivo;
    private int ID_Producto, cantidad;

    public Movimiento(String fechaMovimiento, String tipoMovimiento, String motivo, int ID_Producto, int cantidad) {
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.motivo = motivo;
        this.ID_Producto = ID_Producto;
        this.cantidad = cantidad;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
