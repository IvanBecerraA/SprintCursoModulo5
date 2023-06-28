<%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 27/06/2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@page import="controllers.ProcesoListarUsuario"%>
<%@page import="models.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--Generamos una tabla-->
<table class="table">
    <!--Cabecera de mi tabla-->
    <thead class="table-dark">
    <th> ID </th>
    <th> Nombre </th>
    <th> Apellido Paterno </th>
    <th> Apellido Materno </th>
    <th> Fecha de nacimiento </th>
    <th> run</th>
    <th> Tipo de usuario</th>
    <th> </th>
    <th> </th>
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
                case 2: tipoUsuario= "Administrativo"; break;
                case 3: tipoUsuario= "Profesional"; break;
            }
    %>
    <!--Generamos los datos de usuario-->
    <tr>
        <td><%=x.getIdUsuario() %></td>
        <td><%=x.getNombre() %></td>
        <td><%=x.getApellido1() %></td>
        <td><%=x.getApellido2() %></td>
        <td><%=x.getFechaNacimiento() %></td>
        <td><%=x.getRun() %></td>
        <td><%=tipoUsuario %></td>
        <!--Creamos el formulario para recuperar el ID y redirigirnos a su servlet respectivo-->
        <td><form action="/../SprintCursoModulo5/update" method="POST"><!--actualizar-->
            <input type="hidden" name="idUsuario" value="<%=x.getIdUsuario() %>">
            <input type="hidden" name="tipoUsuario" value="<%=tipoUsuario %>">
            <input type="submit" name="actualizar" value="Actualizar">
    </form></td>
        <td><form action="/../SprintCursoModulo5/delete" method="POST"><!--eliminar-->
            <input type="hidden" name="idUsuario" value="<%=x.getIdUsuario() %>">
            <input type="hidden" name="tipoUsuario" value="<%=tipoUsuario %>">
            <input type="submit" name="eliminar" value="Eliminar">
        </form></td>
    </tr>
    <% } %>
</table>
</body>
</html>
