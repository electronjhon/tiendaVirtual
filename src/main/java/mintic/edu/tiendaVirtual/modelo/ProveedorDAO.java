
package mintic.edu.tiendaVirtual.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProveedorDAO {
    // Definir los Atributos. Capa de Datos. Se comunica con la BDs
    Connection con = null; // Hacer la conexion a la BDs
    Conexion cn = new Conexion();
    Statement stm = null; // Separa el espacio para construir un comando SQL
    ResultSet res = null; // Guarda el resultado de la consulta
    PreparedStatement ps = null;
    
    public String login(Usuario usu) {
        String estado = "";
        ResultSet rs;
        try 
        {
            con = cn.Conexion();
            String sql = "select tipoUsuario, correo from usuario where nombreUsuario=? and clave=?";
            ps =con.prepareStatement(sql);
            ps.setString(1, usu.getNombreUsuario());
            ps.setString(2, usu.getClave());
            rs= ps.executeQuery();
            if (rs.next()) {
                estado = "true";
            }
            usu.setTipoUsuario(rs.getString("tipoUsuario"));
            usu.setCorreo(rs.getString("correo"));
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
        return estado;
    }
    
    public List<Proveedor> getProveedores() {
        String sql = "SELECT * FROM proveedor";

        List<Proveedor> proveedores = new ArrayList<>();

        try {
            con = cn.Conexion();
            stm = con.createStatement(); 
            res = stm.executeQuery(sql);
            while (res.next()) { // Recorrer todo el ResultSet
                Proveedor pro = new Proveedor(); // Instanciamos un objeto tipo Usuario
                pro.setIdProveedor(res.getInt(1));
                pro.setNombreProveedor(res.getString(2));
                pro.setDireccionProveedor(res.getString(3));
                pro.setTelefonoProveedor(res.getString(4));
                pro.setCiudadProveedor(res.getString(5));
                proveedores.add(pro); // Agregarlo al ArrayList
            }
            stm.close(); // Cerrar toda la conexión a la BDs
            res.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return proveedores; // Devuelve el ArrayList usuarios
    }
    
    public boolean agregarProveedor(Proveedor proveedor) {
        boolean registrar = false; // Permite identificar si ya existe el usuario
        boolean encontrado = false; // Encuentra un usuario con el correo Institucional
        String buscar = "SELECT * FROM proveedor where idProveedor = " // Instrucción sql
                + proveedor.getIdProveedor(); // Para buscar un registro con el mismo id
        encontrado = buscar(buscar); // Ejecutamos el método con la consulta
        if(!encontrado){
            // La instrucción para insertar el registro
            String sql = "INSERT INTO proveedor values (" + proveedor.getIdProveedor()
                    + ", '" + proveedor.getNombreProveedor()
                    + "' ,'" + proveedor.getDireccionProveedor()
                    + "' , '" + proveedor.getTelefonoProveedor()
                    + "','" + proveedor.getCiudadProveedor()
                    + "')";
            try {
                con = cn.Conexion();
                stm = con.createStatement();
                stm.execute(sql);
                registrar = true;
                stm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: Clase ProveedorDao, método agregarProveedor");
                e.printStackTrace();
            }
        }

        return registrar;
    }
    
    public boolean buscar(String sql){
        boolean encontrado = false;
        con = cn.Conexion();
        try {
            stm = con.createStatement();
            res = stm.executeQuery(sql);
            while(res.next()){
                encontrado = true;
            }
        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                System.out.println("Error: Clase ProveedorDao, método agregarProveedor"+e.getMessage());
            }
        return encontrado;
    }

    public Proveedor getProveedorId(int id) {
        String sql = "SELECT * FROM proveedor WHERE idProveedor=" + id;
        Proveedor pro = new Proveedor();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                pro.setIdProveedor(res.getInt(1));
                pro.setNombreProveedor(res.getString(2));
                pro.setDireccionProveedor(res.getString(3));
                pro.setTelefonoProveedor(res.getString(4));
                pro.setCiudadProveedor(res.getString(5));
            }
            // cerramos el jdbc
            stm.close();
            res.close();
            con.close();
        } catch (SQLException er) {
            System.err.println("Error:" + er);
        }
        return pro;
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        boolean encontrado = false;
        boolean actualizar = false;
        String sql = "UPDATE proveedor SET idProveedor = '" + proveedor.getIdProveedor()
                + "', nombreProveedor='" + proveedor.getNombreProveedor()
                 + "', direccionProveedor = '"  + proveedor.getDireccionProveedor()
                + "', telefonoProveedor = '" + proveedor.getTelefonoProveedor()
                + "' , ciudadProveedor= '" + proveedor.getCiudadProveedor() + "'"
                + " WHERE idProveedor = " + proveedor.getIdProveedor();
        System.out.println(""+sql);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ProveedorDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }
 
    public boolean eliminarProveedor(int id) {
        boolean encontrado = false;
        boolean eliminar = false;
        String buscar = "SELECT * FROM proveedor WHERE idProveedor=" + id;
        encontrado = buscar(buscar);
        String sql = "DELETE FROM proveedor WHERE idProveedor = " + id;
        if(encontrado){
            try {
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.executeUpdate(sql);
                eliminar = true;
            } catch (SQLException e) {
                System.out.println("Error: Clase ProveedorDao, método eliminar");
                e.printStackTrace();
            }
        }
        return eliminar;
    }
}
