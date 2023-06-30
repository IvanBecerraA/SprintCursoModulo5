<%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 27/06/2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>

<%@page import="models.Usuario"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
    <title>Listar Usuarios</title>
    <!-- INCLUYENDO HEAD.JSP PARA TRAER BOOTSTRAP, ESTILOS,ETC  -->
    <%@ include file='head.jsp' %>
    <!-- PARA ICONOS BOOTSTRAP EDITAR/ELIMINAR  -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <style>
        thead th{
          background-color: #7952b3;
          color: #fff;
        }
        .table th:first-child {
          border-top-left-radius: 8px;
        }

        .table th:last-child {
          border-top-right-radius: 8px;
        }

        tr:last-child td:first-child {
          border-bottom-left-radius: 8px;
        }

        tr:last-child td:last-child {
          border-bottom-right-radius: 8px;
        }
        </style>
</head>
<body>
<!-- navbar  -->
<%@ include file='header.jsp' %>

<!-- título y boton crear usuario  -->
<div style="display: flex; flex-direction: column;">
    <h2 class="text-center mt-5">Listado de Usuarios</h2>
    <button type="button" style="width: 150px;" class="btn btn-primary m-auto mb-2">Crear Usuario</button>
</div>

  <div class="container mb-5 pb-3" style="min-height: 55vh; max-width: 75%;">
    <div class="row m-auto mt-5" style="box-shadow: 0 0 5px rgba(0, 0, 0, 0.3); border-radius: 8px;">
<!--Generamos una tabla-->
<table class="table mb-0">
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
        <td class="align-middle"><form class="mb-0" action="/../SprintCursoModulo5/update" method="POST"><!--actualizar-->
            <input type="hidden" name="idUsuario" value="<%=x.getId_usuario() %>">
            <input type="hidden" name="tipoUsuario" value="<%=tipoUsuario %>">
            <button type="submit" class="btn btn-success" name="actualizarFormulario" value="Editar"><i class="bi bi-pencil-square"></i></button>
        </form></td>
        <td class="align-middle"><form class="mb-0" action="/../SprintCursoModulo5/delete" method="POST"><!--eliminar-->
            <input type="hidden" name="idUsuario" value="<%=x.getId_usuario() %>">
            <input type="hidden" name="tipoUsuario" value="<%=tipoUsuario %>">
            <button type="submit" class="btn btn-danger" name="eliminar" value="Eliminar"><i class="bi bi-trash"></i></button>
        </form></td>
    </tr>
    <% } %>
</table>
</div>
</div>

<!-- agregando footer, que contiene además script de bootstrap  -->
<%@ include file='footer.jsp' %>
</body>
</html>