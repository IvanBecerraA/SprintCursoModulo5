<%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 27/06/2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>

<%@page import="models.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Listado de Usuarios</title>
    <!-- INCLUYENDO HEAD.JSP PARA TRAER BOOTSTRAP, ESTILOS,ETC  -->

    <!-- PARA ICONOS BOOTSTRAP EDITAR/ELIMINAR  -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <style>

        </style>
          <link rel="stylesheet" href="https://cdnjs-cloudflare-com.translate.goog/ajax/libs/twitter-bootstrap/5.3.0-alpha3/css/bootstrap.min.css">
          <link rel="stylesheet" href="https://cdn-datatables-net.translate.goog/1.13.4/css/dataTables.bootstrap5.min.css">
</head>
<body>
<!-- navbar  -->
<%@ include file='header.jsp' %>

<!-- título y boton crear usuario  -->
<div style="display: flex; flex-direction: column;">
    <h1 class="text-center mt-5">Listado de Usuarios</h1>

</div>

  <div class="container mb-5" style="min-height: 55vh;">
    <div class="row m-auto mt-3" style="">
<!--Generamos una tabla-->
<table id="example" class="table table-striped">
    <!--Cabecera de mi tabla-->
    <thead class="text-center align-middle">
    <th scope="col"> ID </th>
    <th scope="col"> Nombre </th>
    <th scope="col"> Apellido Paterno </th>
    <th scope="col"> Apellido Materno </th>
    <th scope="col"> Fecha de nacimiento </th>
    <th scope="col"> run</th>
    <th scope="col"> Tipo de usuario</th>
    <th scope="col"> Editar </th>
    <th scope="col"> Eliminar </th>
    </thead><!--Cerramos cabecera de mi tabla-->
    <%
        //Recuperamos el contenedor usuarios pero por su nombre Html
        //y lo guardamos en un arraylist usuario
        ArrayList<Usuario> usu = (ArrayList<Usuario>)request.getAttribute("usuariosHtml");
        //Generamos el foreach para recorrer el arreglo usuario
        for (Usuario x: usu){
            String tipoUsuario="";
            //evaluamos el tipo de usuario para agregar su texto
            switch (x.getTipo_usuario()){
                case 1: tipoUsuario= "Cliente";break;
                case 2: tipoUsuario= "Profesional"; break;
                case 3: tipoUsuario= "Administrativo"; break;
            }
    %>
    <!--Generamos los datos de usuario-->
    <tr class="text-center align-middle">
        <td class="fw-bold"><%=x.getId_usuario() %></td>
        <td><%=x.getNombre() %></td>
        <td><%=x.getApellido1() %></td>
        <td><%=x.getApellido2() %></td>
        <td><%=x.getFechaNacimiento() %></td>
        <td><%=x.getRun() %></td>
        <td><%=tipoUsuario %></td>
        <!--Creamos el formulario para recuperar el ID y redirigirnos a su servlet respectivo-->
        <td class="align-middle"><form class="mb-0" action="update" method="GET"><!--actualizar-->
            <input type="hidden" name="idUsuario" value="<%=x.getId_usuario() %>">
            <input type="hidden" name="tipoUsuario" value="<%=tipoUsuario %>">
            <button type="submit" class="btn btn-success"><i class="bi bi-pencil-square"></i></button>
             <%-- name="actualizarFormulario" value="update" --%>
        </form></td>
        <td class="align-middle"><form class="mb-0" action="delete" method="POST"><!--eliminar-->
            <input type="hidden" name="idUsuario" value="<%=x.getId_usuario() %>">
            <input type="hidden" name="tipoUsuario" value="<%=tipoUsuario %>">
            <button type="submit" class="btn btn-danger" name="eliminar" value="Eliminar"><i class="bi bi-trash"></i></button>
        </form></td>
    </tr>
    <% } %>
</table>
</div>
</div>
  <script src="https://code-jquery-com.translate.goog/jquery-3.5.1.js"></script>
  <script src="https://cdn-datatables-net.translate.goog/1.13.4/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn-datatables-net.translate.goog/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <script>
      $('#example').DataTable();
    </script>
<% if (request.getAttribute("valido") != null || request.getAttribute("error") != null) { %>
    <input type="hidden" id="idValido" value="<%=request.getAttribute("valido")%>"/>
    <input type="hidden" id="idError" value="<%=request.getAttribute("error")%>"/>
    <script>
        window.onload = function() {
            var idValido = document.getElementById('idValido');
            var idError = document.getElementById('idError');
            if (idValido.value !== "") {
                Swal.fire({
                    title: 'Felicidades!',
                    text: idValido.value,
                    confirmButtonText: 'OK',
                    icon: 'success'
                });
            } else {
                Swal.fire({
                    title: 'Error!',
                    text: idError.value,
                    confirmButtonText: 'OK',
                    icon: 'error'
                });
            }
        };
    </script>
<% } %>

<!-- agregando footer, que contiene además script de bootstrap  -->
<%@ include file='footer.jsp' %>
</body>
</html>