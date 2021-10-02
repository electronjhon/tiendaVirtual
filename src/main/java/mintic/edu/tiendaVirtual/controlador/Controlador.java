package mintic.edu.tiendaVirtual.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mintic.edu.tiendaVirtual.modelo.Cliente;
import mintic.edu.tiendaVirtual.modelo.ClienteDAO;
import mintic.edu.tiendaVirtual.modelo.Proveedor;
import mintic.edu.tiendaVirtual.modelo.ProveedorDAO;
import mintic.edu.tiendaVirtual.modelo.Usuario;
import mintic.edu.tiendaVirtual.modelo.UsuarioDAO;

/**
 *
 * @author Jhon
 */
public class Controlador extends HttpServlet {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDao = new ClienteDAO();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Usuarios")) {
            switch (accion) {
                case "Listar":
                    String tipos [] = {"Administrador","Vendedor"}; 
                    request.setAttribute("usuarios", usuarioDao.getUsuarios());
                    request.setAttribute("tipos", tipos);
                    request.setAttribute("usuarioEdit", new Usuario());
                    break;
                case "Agregar":
                    int idUsuario = Integer.parseInt(request.getParameter("txtId"));
                    String nombreCompleto = request.getParameter("txtNombre");
                    String correo = request.getParameter("txtCorreo");
                    String nombreUsuario = request.getParameter("txtUsuario");
                    String clave = request.getParameter("txtClave");
                    String tipoUsuario = request.getParameter("txtTipo");
                    usuario.setIdUsuario(idUsuario);
                    usuario.setNombreCompleto(nombreCompleto);
                    usuario.setCorreo(correo);
                    usuario.setNombreUsuario(nombreUsuario);
                    usuario.setClave(clave);
                    usuario.setTipoUsuario(tipoUsuario);
                    usuarioDao.agregarUsuario(usuario);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int ideu = Integer.valueOf(request.getParameter("id"));
                    Usuario usu = new Usuario();
                    String [] categorias = {"Administrador","Vendedor"};
                    usu = usuarioDao.getUsuarioId(ideu);
                    request.setAttribute("usuarioEdit", usu);
                    request.setAttribute("categorias", categorias);
                    break;
                case "Consultar":
                    int idac = Integer.valueOf(request.getParameter("txtBuscar"));
                    Usuario consU = new Usuario();
                    consU = usuarioDao.getUsuarioCedula(idac);
                    request.setAttribute("usuarioEdit", consU);
                    break;
                case "Actualizar":
                    int idUsuarioa = Integer.parseInt(request.getParameter("txtId"));
                    String nombreCompletoa = request.getParameter("txtNombre");
                    String correoa = request.getParameter("txtCorreo");
                    String nombreUsuarioa = request.getParameter("txtUsuario");
                    String clavea = request.getParameter("txtClave");
                    String tipoUsuarioa = request.getParameter("txtTipo");
                    usuario.setIdUsuario(idUsuarioa);
                    usuario.setNombreCompleto(nombreCompletoa);
                    usuario.setCorreo(correoa);
                    usuario.setNombreUsuario(nombreUsuarioa);
                    usuario.setClave(clavea);
                    usuario.setTipoUsuario(tipoUsuarioa);
                    usuarioDao.actualizarUsuario(usuario);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idUsuarioe = Integer.valueOf(request.getParameter("id"));
                    usuarioDao.eliminarUsuario(idUsuarioe);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/usuarios.jsp").forward(request, response);
        }

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    String tipos [] = {"Administrador","Vendedor"}; 
                    request.setAttribute("clientes", clienteDao.getClientes());
                    request.setAttribute("tipos", tipos);
                    request.setAttribute("clienteEdit", new Cliente());
                    break;
                case "Agregar":
                    int idCliente = Integer.parseInt(request.getParameter("txtId"));
                    String nombreCliente = request.getParameter("txtNombre");
                    String correoCliente = request.getParameter("txtCorreo");
                    String direccionCliente = request.getParameter("txtUsuario");
                    String telefonoCliente = request.getParameter("txtClave");
                    cliente.setIdCliente(idCliente);
                    cliente.setNombreCliente(nombreCliente);
                    cliente.setCorreoCliente(correoCliente);
                    cliente.setDireccionCliente(direccionCliente);
                    cliente.setTelefonoCliente(telefonoCliente);
                    clienteDao.agregarCliente(cliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int idec = Integer.valueOf(request.getParameter("id"));
                    Cliente cli = new Cliente();
                    cli = clienteDao.getClienteId(idec);
                    request.setAttribute("clienteEdit", cli);
                    break;
                case "Consultar":
                    int idcc = Integer.valueOf(request.getParameter("txtBuscar"));
                    Cliente consC = new Cliente();
                    consC = clienteDao.getClienteCedula(idcc);
                    request.setAttribute("clienteEdit", consC);
                    break;
                case "Actualizar":
                    int idClientea = Integer.parseInt(request.getParameter("txtId"));
                    String nombreClientea = request.getParameter("txtNombre");
                    String correoClientea = request.getParameter("txtCorreo");
                    String direccionClientea = request.getParameter("txtUsuario");
                    String telefonoClientea = request.getParameter("txtClave");
                    cliente.setIdCliente(idClientea);
                    cliente.setNombreCliente(nombreClientea);
                    cliente.setCorreoCliente(correoClientea);
                    cliente.setDireccionCliente(direccionClientea);
                    cliente.setTelefonoCliente(telefonoClientea);
                    clienteDao.actualizarCliente(cliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idClientee = Integer.valueOf(request.getParameter("id"));
                    clienteDao.eliminarCliente(idClientee);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/cliente.jsp").forward(request, response);

        }
        
        if (menu.equals("Proveedores")) {
            switch (accion) {
                case "Listar":
                    String tipos [] = {"Administrador","Vendedor"}; 
                    request.setAttribute("proveedores", proveedorDAO.getProveedores());
                    request.setAttribute("tipos", tipos);
                    request.setAttribute("proveedorEdit", new Proveedor());
                    break;
                case "Agregar":
                    int idProveedor = Integer.parseInt(request.getParameter("txtId"));
                    String nombreProveedor = request.getParameter("txtNombre");
                    String direccionProveedor = request.getParameter("txtDireccion");
                    String telefonoProveedor = request.getParameter("txtTelefono");
                    String ciudadProveedor = request.getParameter("txtCiudad");
                    proveedor.setIdProveedor(idProveedor);
                    proveedor.setNombreProveedor(nombreProveedor);
                    proveedor.setDireccionProveedor(direccionProveedor);
                    proveedor.setTelefonoProveedor(telefonoProveedor);
                    proveedor.setCiudadProveedor(ciudadProveedor);
                    proveedorDAO.agregarProveedor(proveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int idec = Integer.valueOf(request.getParameter("id"));
                    Proveedor pro = new Proveedor();
                    pro = proveedorDAO.getProveedorId(idec);
                    request.setAttribute("proveedorEdit", pro);
                    break;
                case "Consultar":
                    int idcp = Integer.valueOf(request.getParameter("txtBuscar"));
                    Proveedor consP = new Proveedor();
                    consP = proveedorDAO.getProveedorNit(idcp);
                    request.setAttribute("proveedorEdit", consP);
                    break;
                case "Actualizar":
                    int idProveedora = Integer.parseInt(request.getParameter("txtId"));
                    String nombreProveedora = request.getParameter("txtNombre");
                    String direccionProveedora = request.getParameter("txtDireccion");
                    String telefonoProveedora = request.getParameter("txtTelefono");
                    String ciudadProveedora = request.getParameter("txtCiudad");
                    proveedor.setIdProveedor(idProveedora);
                    proveedor.setNombreProveedor(nombreProveedora);
                    proveedor.setDireccionProveedor(direccionProveedora);
                    proveedor.setTelefonoProveedor(telefonoProveedora);
                    proveedor.setCiudadProveedor(ciudadProveedora);
                    proveedorDAO.actualizarProveedor(proveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    int idProveedore = Integer.valueOf(request.getParameter("id"));
                    proveedorDAO.eliminarProveedor(idProveedore);
                    request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/proveedor.jsp").forward(request, response);

        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
