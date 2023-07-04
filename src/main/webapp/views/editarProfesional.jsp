<%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 30/06/2023
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Profesional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  //Recuperamos el contenedor usuarios pero por su nombre Html
  //y lo guardamos en un arraylist usuario
  Profesional pro = (Profesional) (request.getAttribute("profesionalHtml"));
  System.out.println("Desde el formulario editar profesional "+pro.getId_profesional());
  //Generamos el foreach para recorrer el arreglo usuario


%>
<form action="update" method="post" >
  <!--Datos ocultos-->
  <input type="hidden" name="idUsuario" value="<%=pro.getId_usuario()%>">
  <input type="hidden" name="idtipo" value="<%=pro.getTipo_usuario()%>">
  <input type="hidden" name="run" value="<%=pro.getRun()%>">
  <input type="hidden" name="idProfesional" value="<%=pro.getId_profesional()%>">
  <!--Datos que se mostraran al usuario-->
  <h1>Usuario:</h1>
  <hr>
  <label >Nombre: </label>
  <input type="text" name="nombre"  value="<%= pro.getNombre() %>" required>
  <label >Apellido Paterno: </label>
  <input type="text" name="apellido1" placeholder="Ingrese Apellido Paterno" value="<%= pro.getApellido1()%>" required>
  <label >Apellido Materno </label>
  <input type="text" name="apellido2" placeholder="Ingrese Apellido Materno" value="<%= pro.getApellido2()%>" required>
  <label >Fecha de nacimiento </label>
  <% System.out.println(pro.getFechaNacimiento()); %>
  <input type="date" name="fechaNac"  value="<%= pro.getFechaNacimiento()%>" required>
  <label >Contraseña </label>
  <input type="password" name="contrasenia" placeholder="Ingrese Contraseña" value="<%=pro.getContrasenia()%>" required>
  <h1>Profesional: </h1>
  <hr>
  <label >Titulo</label>
  <input type="text" name="titulo" placeholder="Titulo" value="<%= pro.getTitulo()%>" required>
  <label >Fecha ingreso </label>
  <input type="date" name="fechaIngreso" placeholder="Fecha de ingreso" value="<%= pro.getFecha_ingreso()%>" required>

  <input type="submit" name="actualizarCargar" value="Editar">
</form>

</body>
</html>