package mintic.edu.tiendaVirtual.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jhon
 */
public class DetalleVentaDAO {
    // Definir los Atributos. Capa de Datos. Se comunica con la BDs
    Connection con = null; // Hacer la conexion a la BDs
    Conexion cn = new Conexion();
    Statement stm = null; // Separa el espacio para construir un comando SQL
    ResultSet res = null; // Guarda el resultado de la consulta
    PreparedStatement ps = null;
    
    public boolean agregarDetalleVenta(DetalleVenta detalleVenta) {
        boolean registrar = false; // Permite identificar si ya existe el usuario
        boolean encontrado = false; // Encuentra un usuario con el correo Institucional
        if(!encontrado){
            // La instrucción para insertar el registro
            String sql = "INSERT INTO detalleventa (codigo, cod_venta, cantidadProducto, valorTotal, valorVenta, valorIva) "
                    + "values (" + detalleVenta.getCodigo()
                    + " , " + detalleVenta.getCod_venta()
                    + " ," + detalleVenta.getCantidadProducto()
                    + " , " + detalleVenta.getValorTotal()
                    + " , " + detalleVenta.getValorVenta()
                    + " ," + detalleVenta.getValorIva()
                    + " )";
            try {
                con = cn.Conexion();
                stm = con.createStatement();
                stm.execute(sql);
                registrar = true;
                stm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: Clase DetalleVentaDao, método detalleVenta");
                e.printStackTrace();
            }
        }

        return registrar;
    }
}
