package mintic.edu.tiendaVirtual.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon
 */

public class ClienteDAO {
    
    

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

    public List<Cliente> getClientes() {
        String sql = "SELECT * FROM cliente";

        List<Cliente> clientes = new ArrayList<>();

        try {
            con = cn.Conexion();
            stm = con.createStatement(); 
            res = stm.executeQuery(sql);
            while (res.next()) { // Recorrer todo el ResultSet
                Cliente cli = new Cliente(); // Instanciamos un objeto tipo Usuario
                cli.setIdCliente(res.getInt(1));
                cli.setNombreCliente(res.getString(2));
                cli.setCorreoCliente(res.getString(3));
                cli.setDireccionCliente(res.getString(4));
                cli.setTelefonoCliente(res.getString(5));
                clientes.add(cli); // Agregarlo al ArrayList
            }
            stm.close(); // Cerrar toda la conexión a la BDs
            res.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return clientes; // Devuelve el ArrayList clientes
    }
    
    public boolean agregarCliente(Cliente cliente) {
        boolean registrar = false; // Permite identificar si ya existe el usuario
        boolean encontrado = false; // Encuentra un usuario con el correo Institucional
        String buscar = "SELECT * FROM cliente where idCliente = " // Instrucción sql
                + cliente.getIdCliente(); // Para buscar un registro con el mismo id
        encontrado = buscar(buscar); // Ejecutamos el método con la consulta
        if(!encontrado){
            // La instrucción para insertar el registro
            String sql = "INSERT INTO cliente values (" + cliente.getIdCliente()
                    + ", '" + cliente.getNombreCliente()
                    + "' ,'" + cliente.getCorreoCliente()
                    + "' , '" + cliente.getDireccionCliente()
                    + "','" + cliente.getTelefonoCliente()
                    + "')";
            try {
                con = cn.Conexion();
                stm = con.createStatement();
                stm.execute(sql);
                registrar = true;
                stm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDao, método agregarCliente");
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
                System.out.println("Error: Clase ClienteDao, método agregarCliente"+e.getMessage());
            }
        return encontrado;
    }

    public Cliente getClienteId(int id) {
        String sql = "SELECT * FROM cliente WHERE idCliente=" + id;
        Cliente cli = new Cliente();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                cli.setIdCliente(res.getInt(1));
                cli.setNombreCliente(res.getString(2));
                cli.setCorreoCliente(res.getString(3));
                cli.setDireccionCliente(res.getString(4));
                cli.setTelefonoCliente(res.getString(5));
            }
            // cerramos el jdbc
            ps.close();
            res.close();
            con.close();
        } catch (SQLException er) {
            System.err.println("Error:" + er);
        }
        return cli;
    }
    
    public Cliente getClienteCedula(int id) {
        String sql = "SELECT * FROM cliente WHERE idCliente=" + id;
        Cliente clic = new Cliente();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                clic.setIdCliente(res.getInt(1));
                clic.setNombreCliente(res.getString(2));
                clic.setCorreoCliente(res.getString(3));
                clic.setDireccionCliente(res.getString(4));
                clic.setTelefonoCliente(res.getString(5));
            }
            // cerramos el jdbc
            ps.close();
            res.close();
            con.close();
        } catch (SQLException er) {
            System.err.println("Error:" + er);
        }
        return clic;
    }

    public boolean actualizarCliente(Cliente cliente) {
        boolean encontrado = false;
        boolean actualizar = false;
        String sql = "UPDATE cliente SET idCliente = '" + cliente.getIdCliente()
                + "', nombreCliente='" + cliente.getNombreCliente()
                 + "', correoCliente = '"  + cliente.getCorreoCliente()
                + "', direccionCliente = '" + cliente.getDireccionCliente()
                + "' , telefonoCliente= '" + cliente.getTelefonoCliente() + "'"
                + " WHERE idCliente = " + cliente.getIdCliente();
        System.out.println(""+sql);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }
 
    public boolean eliminarCliente(int id) {
        boolean encontrado = false;
        boolean eliminar = false;
        String buscar = "SELECT * FROM cliente WHERE idCliente=" + id;
        encontrado = buscar(buscar);
        String sql = "DELETE FROM cliente WHERE idCliente = " + id;
        if(encontrado){
            try {
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.executeUpdate(sql);
                eliminar = true;
            } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDao, método eliminar");
                e.printStackTrace();
            }
        }
        return eliminar;
    }
    
}
