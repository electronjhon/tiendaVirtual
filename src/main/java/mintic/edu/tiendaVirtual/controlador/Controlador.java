package mintic.edu.tiendaVirtual.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mintic.edu.tiendaVirtual.modelo.Cliente;
import mintic.edu.tiendaVirtual.modelo.ClienteDAO;
import mintic.edu.tiendaVirtual.modelo.DetalleVenta;
import mintic.edu.tiendaVirtual.modelo.DetalleVentaDAO;
import mintic.edu.tiendaVirtual.modelo.Producto;
import mintic.edu.tiendaVirtual.modelo.ProductoDAO;
import mintic.edu.tiendaVirtual.modelo.Proveedor;
import mintic.edu.tiendaVirtual.modelo.ProveedorDAO;
import mintic.edu.tiendaVirtual.modelo.Usuario;
import mintic.edu.tiendaVirtual.modelo.UsuarioDAO;
import mintic.edu.tiendaVirtual.modelo.Venta;
import mintic.edu.tiendaVirtual.modelo.VentaDAO;

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
    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    Venta venta = new Venta();
    VentaDAO ventaDao = new VentaDAO();
    DetalleVenta detalleVenta = new DetalleVenta();
    DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
    List<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();
    String mensaje = null, aviso = null;
    int cedulaCliente = 0;
    int codigoProducto = 0;
    int numeroFactura = 0;
    int item = 0;
    int idProducto = 0;
    String descripcion = null;
    int cantidadProducto = 0;
    double precioVenta = 0;
    double valorTotal = 0;
    double valorVenta = 0;
    double valorIva = 0;
    double subtotal = 0;
    double totalIva = 0;
    double totalFactura = 0;
    Usuario usuarioVenta = new Usuario();
    int idUsuario = 0;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession objSesionVentas = request.getSession(); //se define variable de tipo sesion
        usuarioVenta =  (Usuario) objSesionVentas.getAttribute("objusuario"); //recuperar objusuario con casting
        //imprimir para verificar si se recupero el objusuario
        System.out.println("Usuario: " + usuarioVenta.getIdUsuario() + " -Correo: " + usuarioVenta.getCorreo());
        //almacenar el valor en la variable idUsuario
        idUsuario = usuarioVenta.getIdUsuario();
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Usuarios")) {
            switch (accion) {
                case "Listar":
                    String tipos[] = {"Administrador", "Vendedor"};
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
                    boolean creado = usuarioDao.agregarUsuario(usuario);
                    if (creado) {
                        mensaje = "Usuario creado exitosamente";
                        aviso = null;
                    } else {
                        aviso = "Error, cédula de usuario ya existe";
                        mensaje = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    int ideu = Integer.valueOf(request.getParameter("id"));
                    Usuario usu = new Usuario();
                    String[] categorias = {"Administrador", "Vendedor"};
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
                    String tipos[] = {"Administrador", "Vendedor"};
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
                    boolean creado = clienteDao.agregarCliente(cliente);
                    if (creado) {
                        mensaje = "Cliente creado exitosamente";
                        aviso = null;
                    } else {
                        aviso = "Error, cédula de cliente ya existe";
                        mensaje = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
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
                    String tipos[] = {"Administrador", "Vendedor"};
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
                    boolean creado = proveedorDAO.agregarProveedor(proveedor);
                    if (creado) {
                        mensaje = "Proveedor creado exitosamente";
                        aviso = null;
                    } else {
                        aviso = "Error, NIT de proveedor ya existe";
                        mensaje = null;
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
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

        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":
                    List<Producto> productos = new ArrayList<>();
                    productos = productoDAO.getProductos();
                    request.setAttribute("productos", productos);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Consultar":
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/productos.jsp").forward(request, response);

        }

        if (menu.equals("Ventas")) {
            switch (accion) {
                case "Listar":
                    item = 0;
                    subtotal = 0;
                    totalIva = 0;
                    totalFactura = 0;
                    detalleVentas = new ArrayList<DetalleVenta>();
                    numeroFactura = ventaDao.calcularIdVenta();
                    numeroFactura += 1;
                    request.setAttribute("idVenta", numeroFactura);
                    break;
                case "generarFactura":
                    //recuperar los valores de las variables a usar en ventas
                    cedulaCliente = Integer.parseInt(request.getParameter("txtCedula"));
                    totalIva = Double.parseDouble(request.getParameter("txtIva"));
                    subtotal = Double.parseDouble(request.getParameter("txtSubtotal"));
                    totalFactura = Double.parseDouble(request.getParameter("txtTotal"));
                    //Hacer set a las variables para confirmarlas en el objeto venta
                    venta.setCod_venta(numeroFactura);
                    venta.setIdCliente(cedulaCliente);
                    venta.setIdUsuario(idUsuario);
                    venta.setIvaVenta(totalIva);
                    venta.setValorVenta(subtotal);
                    venta.setTotalVenta(totalFactura);
                    //agregar el objeto a la tabla venta
                    boolean crearVenta = ventaDao.agregarVenta(venta);
                    if (crearVenta){
                        mensaje = "Factura creada exitosamente";
                        aviso = null;
                    }else {
                        mensaje = null;
                        aviso = "No se pudo crear la factura";
                    }
                    //agregar los datos a la tabla detalleVenta
                    int numeroProductos = 0;
                    for(DetalleVenta detalleVenta:detalleVentas) {
                        //insertar el registro en la tabla
                        detalleVentaDAO.agregarDetalleVenta(detalleVenta);
                        numeroProductos += 1;
                        //System.out.println("Datos de venta por productos: " + detalleVenta.toString());
                    }
                    
                    request.setAttribute("mensaje", mensaje + "Productos en factura: " + numeroProductos);
                    request.setAttribute("aviso", aviso);
                    request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request, response);
                    break;
                case "cancelarFactura":
                    request.setAttribute("aviso", "Se canceló la factura");
                    request.setAttribute("mensaje", "Se inicia una nueva factura");
                    request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request, response);
                    break;
                case "agregarProducto":
                    item +=1;
                    numeroFactura = Integer.parseInt(request.getParameter("numeroFactura"));
                    codigoProducto = Integer.parseInt(request.getParameter("txtCodigo"));
                    descripcion = request.getParameter("txtNombreProducto");
                    cantidadProducto = Integer.parseInt(request.getParameter("txtCantidad"));
                    precioVenta = Double.parseDouble(request.getParameter("txtPrecioVenta"));
                    valorVenta = precioVenta * cantidadProducto;
                    //alorIva = Math.round((valorVenta * producto.getIva() / 100) * 100 / 100);
                    valorIva = Math.round(valorVenta * producto.getIva() / 100);
                    valorTotal = valorVenta + valorIva;
                    subtotal += valorVenta;
                    totalIva += valorIva;
                    detalleVenta = new DetalleVenta();
                    detalleVenta.setCod_detalle(item);
                    detalleVenta.setCod_venta(numeroFactura);
                    detalleVenta.setDescripcion(descripcion);
                    detalleVenta.setCantidadProducto(cantidadProducto);
                    detalleVenta.setCodigo(codigoProducto);
                    detalleVenta.setPrecioVenta(precioVenta);
                    detalleVenta.setValorVenta(valorVenta);
                    detalleVenta.setValorIva(valorIva);
                    detalleVenta.setValorTotal(valorTotal);
                    detalleVentas.add(detalleVenta);
                    totalFactura = subtotal + totalIva;
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("clienteFactura", cliente);
                    request.setAttribute("productoFactura", producto);
                    request.setAttribute("detalleVentas", detalleVentas);
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("totalIva", totalIva);
                    request.setAttribute("totalFactura", totalFactura);
                    break;
                case "Editar":
                    break;
                case "buscarCliente":
                    if (request.getParameter("txtCedula").isEmpty()) {
                        aviso = "Error, cédula del cliente en blanco. Reintente";
                        mensaje = null;
                    } else {
                        cedulaCliente = Integer.parseInt(request.getParameter("txtCedula"));
                        cliente = clienteDao.getClienteId(cedulaCliente);
                        if (cliente.getNombreCliente() == null) {
                            aviso = "Cédula no se encuentra registrada en la base de datos";
                            mensaje = null;
                        } else {
                            aviso = null;
                            mensaje = "Busqueda de cliente exitosa";
                        }
                    }

                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("clienteFactura", cliente);
                    break;
                case "Consultar":
                    break;
                case "buscarProducto":
                    if (request.getParameter("txtCodigo").isEmpty()) {
                        aviso = "Código del producto en blanco. Reintente";
                        mensaje = null;
                    } else {
                        codigoProducto = Integer.parseInt(request.getParameter("txtCodigo"));
                        //implementar en el DAO el método de buscar un producto por el código
                        producto = productoDAO.buscarProductoId(codigoProducto);
                        if (producto.getNombre() == null) {
                            aviso = "Código del producto no se encuentra registrada en la base de datos";
                            mensaje = null;
                        } else {
                            aviso = null;
                            mensaje = "Búsqueda de producto exitosa";
                        }
                    }

                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("aviso", aviso);
                    request.setAttribute("idVenta", numeroFactura);
                    request.setAttribute("detalleVentas", detalleVentas);
                    request.setAttribute("clienteFactura", cliente);
                    request.setAttribute("productoFactura", producto);
                    break;
                case "Actualizar":
                    break;
                case "Eliminar":
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("jsp/facturas.jsp").forward(request, response);

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
