
package mintic.edu.tiendaVirtual.modelo;

/**
 *
 * @author ingab
 */
public class ReporteCliente {
    private int idCliente;
    private String nombreCliente;
    private String correoCliente;
    private String direccionClientes;
    private String telefonoCliente;

    public ReporteCliente() {
    }

    public ReporteCliente(int idCliente, String nombreCliente, String correoCliente, String direccionClientes, String telefonoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.direccionClientes = direccionClientes;
        this.telefonoCliente = telefonoCliente;
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

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionClientes() {
        return direccionClientes;
    }

    public void setDireccionClientes(String direccionClientes) {
        this.direccionClientes = direccionClientes;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Override
    public String toString() {
        return "ReporteCliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", correoCliente=" + correoCliente + ", direccionClientes=" + direccionClientes + ", telefonoCliente=" + telefonoCliente + '}';
    }
    
    
}
