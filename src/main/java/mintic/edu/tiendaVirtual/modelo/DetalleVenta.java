package mintic.edu.tiendaVirtual.modelo;

/**
 *
 * @author Jhon
 */
public class DetalleVenta {
    
    //Atributos
    private int cod_detalle;
    private int codigo;
    private String descripcion;
    private int cod_venta;
    private int cantidadProducto;
    private double precioVenta;
    private double valorTotal;
    private double valorVenta;
    private double valorIva;

    public DetalleVenta() {
    }

    public DetalleVenta(int cod_detalle, int codigo, String descripcion, int cod_venta, int cantidadProducto, double precioVenta, double valorTotal, double valorVenta, double valorIva) {
        this.cod_detalle = cod_detalle;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cod_venta = cod_venta;
        this.cantidadProducto = cantidadProducto;
        this.precioVenta = precioVenta;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    public int getCod_detalle() {
        return cod_detalle;
    }

    public void setCod_detalle(int cod_detalle) {
        this.cod_detalle = cod_detalle;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    @Override
    public String toString() {
        return "detalleVenta{" + "cod_detalle=" + cod_detalle + ", codigo=" + codigo + ", descripcion=" + descripcion + ", cod_venta=" + cod_venta + ", cantidadProducto=" + cantidadProducto + ", precioVenta=" + precioVenta + ", valorTotal=" + valorTotal + ", valorVenta=" + valorVenta + ", valorIva=" + valorIva + '}';
    }
    
    
}
