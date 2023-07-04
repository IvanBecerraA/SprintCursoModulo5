<%--
  Created by IntelliJ IDEA.
  User: AGENTE MDA 05
  Date: 30/06/2023
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Administrativo" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Editar Administrativo</title>
  <jsp:include page="head.jsp"/>
  <%@ include file='header.jsp' %>
</head>
<body>
<%
  //Recuperamos el contenedor usuarios pero por su nombre Html
  //y lo guardamos en un arraylist usuario
  Administrativo adm = (Administrativo) (request.getAttribute("administrativosHtml"));
  System.out.println("Desde el formulario Editar ADM "+adm.getId_usuario());
  //Generamos el foreach para recorrer el arreglo usuario


%>
  <main class="container mx-auto" style="width: 80vw; min-height: 70vh;">
    <form action="update" method="post">
      <div class="row d-flex justify-content-between mt-4">
        <h2 class="p-10">Actualizar Administrativo</h2>

      </div>
      <!--Datos ocultos-->
      <input type="hidden" name="idUsuario" value="<%=adm.getId_usuario()%>">
      <input type="hidden" name="idtipo" value="<%=adm.getTipo_usuario()%>">
      <input type="hidden" name="run" value="<%=adm.getRun()%>">
      <input type="hidden" name="idAdministrativo" value="<%=adm.getId_administrativo()%>">
      <!--Datos que se mostraran al usuario-->

      <div class="row gutter-2 mt-4">
        <!-- Nombre -->
        <div class="col-md-4 mb-3">
          <div class="form-group">
            <label class="form-label">Nombre: </label>
            <input type="text" class="form-control form-control-sm" name="nombre" value="<%= adm.getNombre() %>"
              required>
          </div>
        </div>

        <!-- Apellido Paterno -->
        <div class="col-md-4 mb-3">
          <div class="form-group">
            <label class="form-label">Apellido Paterno: </label>
            <input type="text" class="form-control form-control-sm" name="apellido1"
              placeholder="Ingrese Apellido Paterno" value="<%= adm.getApellido1()%>" required>
          </div>
        </div>

        <!-- Apellido Materno -->
        <div class="col-md-4 mb-3">
          <div class="form-group">
            <label class="form-label">Apellido Materno </label>
            <input type="text" class="form-control form-control-sm" name="apellido2"
              placeholder="Ingrese Apellido Materno" value="<%= adm.getApellido2()%>" required>
          </div>
        </div>

      </div>

      <div class="row gutter-2 mt-4">
        <!-- Fecha Nacimiento -->
        <div class="col-md-4 mb-3">
          <div class="form-group">
            <label class="form-label">Fecha de nacimiento </label>
            <!-- *** DESCOMENTAS LO DE AQUÍ ABAJO ***  -->
            <% System.out.println(adm.getFechaNacimiento()); %>
            <input type="date" name="fechaNac" class="form-control form-control-sm"
              value="<%= adm.getFechaNacimiento()%>" required>
          </div>
        </div>

        <!-- Contraseña -->
        <div class="col-md-4 mb-3">
          <div class="form-group">
            <label class="form-label">Contraseña </label>
            <input class="form-control form-control-sm" type="password" name="contrasenia"
              placeholder="Ingrese Contraseña" value="<%=adm.getContrasenia()%>" required>
          </div>
        </div>

              <!-- Area -->
              <div class="col-md-4 mb-3">
                <div class="form-group">
                  <label class="form-label">Perfil</label>
                  <input class="form-control form-control-sm" type="text" name="area" placeholder="Area"
                    value="<%= adm.getArea()%>" required>
                </div>
              </div>

      </div>


      <div class="row gutter-2 mt-4">


        <!-- Experiencia -->
        <div class="col-md-4 mb-3">
          <div class="form-group">
            <label class="form-label">Años de Experiencia </label>
            <input class="form-control form-control-sm" type="number" name="experiencia"
              placeholder="Ingrese Años de Experiencia" value="<%= adm.getExperienciaPrevia()%>" required>
          </div>
        </div>
      </div>
      <!-- boton -->
      <div class="text-center mt-5">
        <button type="submit" name="actualizarCargar" value="Editar" class="btn btn-primary mb-5"
          style="width: 150px;">Actualizar</button>
      </div>
    </form>
  </main>
<%@ include file='footer.jsp' %>
</body>
</html>