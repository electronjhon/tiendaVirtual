

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" crossorigin="anonymous">
        <script src="js/alert.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="d-flex"> 
            <div class="card col-sm-4">
                <div class="card-body">
                    <form class="needs-validation" action="Controlador?menu=Clientes" method="POST" novalidate>
                        <div class="form-group" >
                            <label>Cédula</label>
                            <c:if test="${clienteEdit.idCliente!=0}">
                                <input  type="text" name="txtId" value="${clienteEdit.idCliente}" readonly="" 
                                        class="form-control">
                            </c:if>
                            <c:if test="${clienteEdit.idCliente==0}">
                                <input  type="text" name="txtId" class="form-control" placeholder="campo obligatorio" >
                            
                                <div class="valid-feedback">Campo OK</div>
                                <div class="invalid-feedback">Complete los datos</div>
                            </c:if>
                        </div>
                        <div class="form-group" >
                            <label>Nombre Completo</label>
                            <input  type="text" name="txtNombre" value="${clienteEdit.nombreCliente}" 
                                    class="form-control" required="">
                            <div class="valid-feedback">Campo OK</div>
                            <div class="invalid-feedback">Complete los datos</div>
                        </div>
                        <div class="form-group" >
                            <label>Correo</label>
                            <input  type="text" name="txtCorreo" value="${clienteEdit.correoCliente}" 
                                    class="form-control" required="">
                            <div class="valid-feedback">Campo OK</div>
                            <div class="invalid-feedback">Complete los datos</div>
                        </div>
                        <div class="form-group" >
                            <label>Dirección</label>
                            <input  type="text" name="txtUsuario" value="${clienteEdit.direccionCliente}" 
                                    class="form-control" required="">
                            <div class="valid-feedback">Campo OK</div>
                            <div class="invalid-feedback">Complete los datos</div>
                        </div>
                        <div class="form-group" >
                            <label>Teléfono</label>
                            <input  type="text" name="txtClave" value="${clienteEdit.telefonoCliente}" 
                                    class="form-control" required="">
                            <div class="valid-feedback">Campo OK</div>
                            <div class="invalid-feedback">Complete los datos</div>
                        </div>
                        
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" >
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success" >
                    </form>
                </div>
            <form action="Controlador?menu=Clientes" method="POST" class="row g-3 align-items-center">
                <div class="col-auto">
                    <span class="form-text">
                        Actualizar por cédula de cliente
                    </span>
                    <input type="text" name="txtBuscar" value="${clienteEdit.idCliente}" class="form-control" placeholder="Ingrese cédula">
                </div>
                <div class="col-auto">
                    <br>
                    <button type="submit" class="btn btn-primary btn-sm" name="accion" value="Consultar" >
                    <a class="btn btn-primary btn-sm" href="../Controlador?menu=Clientes&accion=Listar">Consultar</a>
                </div>
            </form>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CEDULA</th>
                            <th>NOMBRE</th>
                            <th>CORREO</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>ACCIONES</th>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${clientes}">
                            <tr>
                                <td>${e.idCliente}</td>
                                <td>${e.nombreCliente}</td>
                                <td>${e.correoCliente}</td>
                                <td>${e.direccionCliente}</td>
                                <td>${e.telefonoCliente}</td>
                                <td>
                                    <a href="Controlador?menu=Clientes&accion=Editar&id=${e.idCliente}"
                                   class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                                <a href="Controlador?menu=Clientes&accion=Eliminar&id=${e.idCliente}" onclick="return confirmarDelete()"
                                   class="btn btn-danger btn-sm"><i class="fa fa-trash-alt"></i></a>
                                    <!-- Modal -->
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>               
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
        crossorigin="anonymous"></script>
        <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
        .forEach(function (form) {
        form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
        }
        form.classList.add('was-validated')
        }, false)
        })
        })()
    </script>
    </body>
</html>