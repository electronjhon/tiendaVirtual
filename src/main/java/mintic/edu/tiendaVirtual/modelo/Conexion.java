package mintic.edu.tiendaVirtual.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jhon
 */
public class Conexion {
    private Connection con;
    Statement consulta;
    private static final String URL = "jdbc:mysql://localhost:3306/tiendavirtual";
    private static final String USER = "root";
    private static final String PASS = "";
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            consulta = con.createStatement();
            if(con != null){
                System.out.println("Conectados a la Base de Datos");
            }
        }catch(ClassNotFoundException | SQLException e){
                System.out.println("Error"+e.getMessage());
    }
    return con;
    }   
    
}
