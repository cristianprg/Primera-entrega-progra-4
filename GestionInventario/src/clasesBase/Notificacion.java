package clasesBase;

import servicios.ProductoServicio;
import servicios.MovimientoServicio;
import clasesBase.Pedido;
import javax.swing.JOptionPane;
import javax.swing.*;

public class Notificacion {
   private ProductoServicio productoServicio;
   private MovimientoServicio movimientoServicio;
   private JFrame frame;

    public Notificacion(ProductoServicio productoServicio, MovimientoServicio movimientoServicio, JFrame frame) {
        this.productoServicio = productoServicio;
        this.movimientoServicio = movimientoServicio;
        this.frame = frame;
    }
   
   public void CrearNotificacion(){
       var productos = productoServicio.getProductos();
       for(Producto producto : productos){
           int CantidadActual = movimientoServicio.SumaMovimientosPorId(producto.getId(), producto.getCantidad());
           
           if (CantidadActual < producto.getStockMinimo()){
               
               JOptionPane.showMessageDialog(frame, "Alerta!, Se encontró stock por debajo del mínimo en el prodcuto " + producto.getNombre() + ". Se realizará el pedido automáticamente.", "Error", JOptionPane.ERROR_MESSAGE);
               
               int CantidadPorPedir = producto.getStockMaximo() - CantidadActual;
               
               Pedido pedido = new Pedido(movimientoServicio, producto.getId(), CantidadPorPedir, producto.getID_Proveedor(), "Procesado");
               pedido.hacerPedidoMovimiento();
           }
       }
   }
}
