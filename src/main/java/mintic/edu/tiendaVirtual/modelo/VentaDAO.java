package mintic.edu.tiendaVirtual.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jhon
 */
public class VentaDAO {
    
    // Definir los Atributos. Capa de Datos. Se comunica con la BDs
    Connection con = null; // Hacer la conexion a la BDs
    Conexion cn = new Conexion();
    Statement stm = null; // Separa el espacio para construir un comando SQL
    ResultSet res = null; // Guarda el resultado de la consulta
    PreparedStatement ps = null;
    
    public int calcularIdVenta(){
        int idVenta = 0;
        String sql = "SELECT max(id) from venta";
        try {
            con = cn.Conexion();            
            stm= con.createStatement();
            res = stm.executeQuery(sql);
            while(res.next()){
                idVenta = res.getInt(1);
            }
            stm.close();;
            con.close();;
            res.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return  idVenta;
    }
    
}
