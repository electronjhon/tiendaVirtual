package mintic.edu.tiendaVirtual.modelo;

/**
 *
 * @author Jhon
 */
public class Venta {
    private int cod_venta;
    private int idCliente;
    private int idUsuario;
    private double ivaVenta;
    private double totalVenta;
    private double valorVenta;

    public Venta() {
    }

    public Venta(int cod_venta, int idCliente, int idUsuario, double ivaVenta, double totalVenta, double valorVenta) {
        this.cod_venta = cod_venta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.ivaVenta = ivaVenta;
        this.totalVenta = totalVenta;
        this.valorVenta = valorVenta;
    }

    public int getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(double ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    @Override
    public String toString() {
        return "venta{" + "cod_venta=" + cod_venta + ", idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", ivaVenta=" + ivaVenta + ", totalVenta=" + totalVenta + ", valorVenta=" + valorVenta + '}';
    }
    
    
}
