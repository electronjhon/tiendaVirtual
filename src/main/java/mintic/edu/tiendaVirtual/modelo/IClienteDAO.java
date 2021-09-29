package mintic.edu.tiendaVirtual.modelo;

import java.util.List;

/**
 *
 * @author Jhon
 */
public interface IClienteDAO {
    
    //Interfaza para
    //Agregar registro
    //Mostrar los datos
    //Editar registros
    //Eliminar registros
    
    public boolean agregarCliente(Cliente cliente);
    public List<Cliente> getClientes();
    public boolean actualizarCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);
}
