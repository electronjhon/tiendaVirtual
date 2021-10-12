<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Facturación</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
        <script src="js/alert.js" type="text/javascript"></script>
    </head>
    <body>
        <h1 style="text-align: center">Factura de Venta</h1>
        <form method="post" action="../Controlador?menu=Ventas">
            <div class="d-flex">
                <div class="col-sm-5">
                    <div class="card">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4">
                                    <input type="text" name="txtCedula"  value="${clienteFactura.getIdCliente()}" class="form-control" placeholder="Cédula del Cliente">
                                </div>
                                <div class="col-sm-2">
                                    <button type="submit" name="accion" value="buscarCliente" class="btn btn-outline-success">Consultar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreCliente"  value="${clienteFactura.getNombreCliente()}" class="form-control" placeholder="Nombre del Cliente" readonly="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos del Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4">
                                    <input type="text" name="txtCodigo"  class="form-control" placeholder="Código del Producto">
                                </div>
                                <div class="col-sm-2">
                                    <button type="submit" name="accion" value="buscarProducto" class="btn btn-outline-info">Consultar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreProducto"  value="${productoFactura.getNombre()}" class="form-control" placeholder="Nombre del Producto" readonly="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>+ Datos</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <button type="submit" name="accion" value="agregarProducto" class="btn btn-outline-primary">Agregar Producto</button>
                                </div>
                                <div class="col-sm-2">
                                    <input type="number" name="txtCantidad" class="form-control" value="1" style="text-align: right">
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" name="txtPrecioVenta"  value="${productoFactura.getPrecioVenta()}" class="form-control" placeholder="$/ 0.000.00" style="text-align: right" readonly="">
                                </div>
                            </div>
                                <br>
                            <div class="form-group d-flex">
                               <c:if test="${mensaje != null}">
                    <div class="alert alert-success alert-dismissible">
                        <button type="button" class="btn-close" data-dismiss="alert"></button>
                        ${mensaje}
                    </div>
                </c:if>
                <c:if test="${aviso != null}">
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="btn-close" data-dismiss="alert"></button>
                        ${aviso}
                    </div>
                </c:if> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="card">
                        <div class="card-header">
                            <div class="d-flex col-sm-6">
                                <label>Factura de Venta No:</label>
                                <input type="text" name="numeroFactura"  value="${idVenta}" class="form-control"  style="text-align: right" readonly="">
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="col-sm-12 ml-auto">
                                <table border="0" class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>CÓDIGO</th>
                                            <th>DESCRIPCIÓN</th>
                                            <th>PRECIO VENTA</th>
                                            <th>CANTIDAD</th>
                                            <th>TOTAL</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <div class="card-footer">
                            <div class="form-group d-flex">
                                <table border="0" class="table table-active" >
                                    <tbody>
                                        <tr>
                                            <td>
                                                <button type="submit" name="accion" value="generarFactura" class="btn btn-success">Generar Factura</button>  
                                            </td>
                                            <td>
                                                <button type="submit" name="accion" value="cancelarFactura" class="btn btn-danger">Cancelar Registro</button>  
                                            </td>
                                            <td>
                                                <label>Subtotal:</label>
                                            </td>
                                            <td>
                                                <input type="text" name="txtSubtotal" class="form-control"  style="text-align: right" readonly="" placeholder="$/ 0.000.00">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td>
                                                <label>Valor IVA:</label>
                                            </td>
                                            <td>
                                                <input type="text" name="txtIva" class="form-control"  style="text-align: right" readonly="" placeholder="$/ 0.000.00">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td>
                                                <label>Total con IVA:</label>
                                            </td>
                                            <td>
                                                <input type="text" name="txtTotal" class="form-control"  style="text-align: right" readonly="" placeholder="$/ 0.000.00">
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
        crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
