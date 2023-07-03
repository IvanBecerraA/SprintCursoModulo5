<%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 30/06/2023
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Administrativo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Usuario" %>
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
  Usuario usu = (Usuario) (request.getAttribute("usuariosHtml"));
  Administrativo adm = (Administrativo) (request.getAttribute("administrativosHtml"));
  Profesional pro = (Profesional) (request.getAttribute("profesionalesHtml")) ;
  //Generamos el foreach para recorrer el arreglo usuario

  System.out.println("Entre al formulario Actualizar ADM");
%>
<form action="/../SprintCursoModulo5/usuario?option=update&amp;id_usuario=<%=usu.getIdUsuario()%>&amp;id_tipoUsuario=<%=usu.getTipo_usuario()%>" method="POST" >
  <!--Datos ocultos-->

  <input type="hidden" name="run" value="<%=usu.getRun()%>">
  <input type="hidden" name="idAdministrativo" value="<%=adm.getIdAdministrativo()%>">
  <!--Datos que se mostraran al usuario-->
  <label >Nombre: </label>
  <input type="text" name="nombre"  value="<%= usu.getNombre() %>" required>
  <label >Apellido Paterno: </label>
  <input type="text" name="apellido1" placeholder="Ingrese Apellido Paterno" value="<%= usu.getApellido1()%>" required>
  <label >Apellido Materno </label>
  <input type="text" name="apellido2" placeholder="Ingrese Apellido Materno" value="<%= usu.getApellido2()%>" required>
  <label >Fecha de nacimiento </label>
  <input type="date" name="fechaNac"  value="<%= usu.getFechaNacimiento()%>" required>
  <label >Contraseña </label>
  <input type="password" name="contrasenia" placeholder="Ingrese Contraseña" value="<%=usu.getPassword()%>" required>
  <imput></imput>
  <select name="tipoUsuario" onchange="mostrarEtiquetasPorPerfil()">
    <option value="1">Cliente</option>
    <option value="2">Profesional</option>
    <option value="3">Administrador</option>
  </select>
  <div id="mostrarCliente" style="display: none;">
    <h1>Cliente</h1>
  </div>
  <div id="mostrarProfesional" style="display: none;">
  <h1>Profesional</h1>
    <label >Area</label>
    <input type="text" name="titulo" placeholder="Titulo" value="<%=  (pro.getTitulo() != null) ? pro.getTitulo() : "" %>" required>
    <label >Area</label>
    <input type="Date" name="fechaIngreso"  value="<%=  pro.getFecha_ingreso()  %>" required>
  </div>
<div id="mostrarAdministrativo" style="display: none;">
  <h1>Administrativo</h1>
  <label >Area</label>
  <input type="text" name="area" placeholder="Area" value="<%=  (adm.getArea() != null) ? adm.getArea() : "" %>" required>
  <label >Años de Experiencia </label>
  <input type="number" name="experiencia" placeholder="Ingrese Años de Experiencia" value="<%= adm.getExperienciaPrevia()%>" required>

</div>
  <input type="submit" name="actualizarCargar" value="Editar">
</form>
<script>
  function mostrarEtiquetasPorPerfil() {
    var seleconarEliminar = document.getElementsByName("tipoUsuario")[0];
    var seleccioneOpcion = seleconarEliminar.options[seleconarEliminar.selectedIndex].value;

    var cliente = document.getElementById("mostrarCliente");
    var profesional = document.getElementById("mostrarProfesional");
    var administrativo = document.getElementById("mostrarAdministrativo");
    var experiencia = document.getElementsByName("experiencia");
    var area = document.getElementsByName("area");
    var titulo = document.getElementsByName("titulo");
    var fechaIngreso = document.getElementsByName("fechaIngreso");
    if (seleccioneOpcion === "1") {
      cliente.style.display = "block";
    } else {
      cliente.style.display = "none";
    }
    if (seleccioneOpcion === "2") {
      profesional.style.display = "block";
    } else {
      profesional.style.display = "none";
      titulo.required===false;
      fechaIngreso.required ===false;
    }
    if (seleccioneOpcion === "3") {
      administrativo.style.display = "block";
    } else {
      administrativo.style.display = "none";
      experiencia.required === false;
      area.required===false;
    }
  }
</script>
</body>
</html>