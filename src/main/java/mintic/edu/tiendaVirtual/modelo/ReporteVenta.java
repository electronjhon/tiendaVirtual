
package mintic.edu.tiendaVirtual.modelo;

/**
 *
 * @author ingab
 */
public class ReporteVenta {
    private int idCliente;
    private String nombreCliente;
    private double ventaTotal;

    public ReporteVenta() {
    }

    public ReporteVenta(int idCliente, String nombreCliente, double ventaTotal) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.ventaTotal = ventaTotal;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getVentaTotal() {
        return ventaTotal;
    }

    public void setVentaTotal(double ventaTotal) {
        this.ventaTotal = ventaTotal;
    }

    @Override
    public String toString() {
        return "ReporteVenta{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", ventaTotal=" + ventaTotal + '}';
    }
    
    
}
