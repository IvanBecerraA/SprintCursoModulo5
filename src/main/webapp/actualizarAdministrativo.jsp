<%@ page import="models.Administrativo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 27/06/2023
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //Recuperamos el contenedor usuarios pero por su nombre Html
    //y lo guardamos en un arraylist usuario
    Administrativo adm = (Administrativo) (request.getAttribute("administrativosHtml"));
    //Generamos el foreach para recorrer el arreglo usuario


    %>
    <form action="ActualizarAdministrativo" method="GET" >
        <!--Datos ocultos-->
        <input type="hidden" name="idUsuario" value="<%=adm.getIdUsuario()%>">
        <input type="hidden" name="idtipo" value="<%=adm.getTipo_usuario()%>">
        <input type="hidden" name="run" value="<%=adm.getRun()%>">
        <input type="hidden" name="idAdministrativo" value="<%=adm.getIdAdministrativo()%>">
        <!--Datos que se mostraran al usuario-->
        <label >Nombre: </label>
        <input type="text" name="nombre"  value="<%= adm.getNombre() %>" required>
        <label >Apellido Paterno: </label>
        <input type="text" name="apellido1" placeholder="Ingrese Apellido Paterno" value="<%= adm.getApellido1()%>" required>
        <label >Apellido Materno </label>
        <input type="text" name="apellido2" placeholder="Ingrese Apellido Materno" value="<%= adm.getApellido2()%>" required>
        <label >Fecha de nacimiento </label>
        <% System.out.println(adm.getFechaNacimiento()); %>
        <input type="date" name="fechaNac"  value="<%= adm.getFechaNacimiento()%>" required>
        <label >Contraseña </label>
        <input type="password" name="contrasenia" placeholder="Ingrese Contraseña" value="<%=adm.getPassword()%>" required>
        <label >Area</label>
        <input type="text" name="area" placeholder="Area" value="<%= adm.getArea()%>" required>
        <label >Años de Experiencia </label>
        <input type="number" name="experiencia" placeholder="Ingrese Años de Experiencia" value="<%= adm.getExperienciaPrevia()%>" required>

        <button type="submit">Editar</button>
    </form>

</body>
</html>
