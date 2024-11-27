package clasesBase;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import servicios.MovimientoServicio;
import servicios.ProductoServicio;

public class ReporteCSV {
    private ProductoServicio productoServicio;
    private MovimientoServicio movimientoServicio;
    private JFrame frame;

    public ReporteCSV(ProductoServicio productoServicio, MovimientoServicio movimientoServicio, JFrame frame) {
        this.productoServicio = productoServicio;
        this.movimientoServicio = movimientoServicio;
        this.frame = frame;
    }
    
    public void GenerarCSV(){
        File f = new File("./Informe.csv");
        try(FileWriter fw = new FileWriter(f);){
            fw.write("producto, saldo, costopromedio, costototal \n");
            var productos = productoServicio.getProductos();
            
            for(Producto producto : productos){
                String name = producto.getNombre();
                int saldo = movimientoServicio.SumaMovimientosPorId(producto.getId(), producto.getCantidad());
                double costoPromedio = producto.getPrecioUnitario();
                double costoTotal = costoPromedio * saldo;
                
                fw.write(name + ", " + saldo + ", " + costoPromedio + ", " + costoTotal + "\n");
            }
            JOptionPane.showMessageDialog(frame, "Archivo informe CSV generado.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, "No se pudo generar el archivo CSV", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
