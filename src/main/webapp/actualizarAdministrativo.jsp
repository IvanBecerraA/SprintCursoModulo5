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
    ArrayList<Administrativo> adm = (ArrayList<Administrativo>)request.getAttribute("administrativosHtml");
    //Generamos el foreach para recorrer el arreglo usuario
    for (Administrativo x: adm){
        System.out.println(x.getNombre());
    %>
    <form action="ActualizarAdministrativo" method="GET" >
        <!--Datos ocultos-->
        <input type="hidden" name="idUsuario" value="<%=x.getIdUsuario()%>">
        <input type="hidden" name="idtipo" value="<%=x.getTipo_usuario()%>">
        <input type="hidden" name="run" value="<%=x.getRun()%>">
        <input type="hidden" name="idAdministrativo" value="<%=x.getIdAdministrativo()%>">
        <!--Datos que se mostraran al usuario-->
        <label >Nombre: </label>
        <input type="text" name="nombre"  value="<%= x.getNombre() %>" required>
        <label >Apellido Paterno: </label>
        <input type="text" name="apellido1" placeholder="Ingrese Apellido Paterno" value="<%= x.getApellido1()%>" required>
        <label >Apellido Materno </label>
        <input type="text" name="apellido2" placeholder="Ingrese Apellido Materno" value="<%= x.getApellido2()%>" required>
        <label >Fecha de nacimiento </label>
        <% System.out.println(x.getFechaNacimiento()); %>
        <input type="date" name="fechaNac"  value="<%= x.getFechaNacimiento()%>" required>
        <label >Contraseña </label>
        <input type="password" name="contrasenia" placeholder="Ingrese Contraseña" value="<%=x.getPassword()%>" required>
        <label >Area</label>
        <input type="text" name="area" placeholder="Area" value="<%= x.getArea()%>" required>
        <label >Años de Experiencia </label>
        <input type="number" name="experiencia" placeholder="Ingrese Años de Experiencia" value="<%= x.getExperienciaPrevia()%>" required>
        <% } %>
        <button type="submit">Editar</button>
    </form>

</body>
</html>
