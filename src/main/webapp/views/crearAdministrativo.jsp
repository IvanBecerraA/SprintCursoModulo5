<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Crear Administrativo</title>
    <%@ include file='head.jsp'  %>
</head>
<body>
    <%@ include file='header.jsp' %>

    <div  class="container p-3" style="width: 50%; text-align: center;">
        <h2 class="pb-4">Formulario Crear Usuario Administrativo</h2>

        <!-- Datos basicos de usuario -->
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="nombre">
            <label for="nombre">Nombre</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="apellido1">
            <label for="apellido1">Primer Apellido</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="apellido2">
            <label for="apellido2">Segundo Apellido</label>
        </div>
        <div class="form-floating mb-3">
            <input type="date" class="form-control" id="fechaNacimiento">
            <label for="fechaNacimiento">Fecha de Nacimiento</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="run">
            <label for="run">RUN</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="password">
            <label for="password">Contraseña</label>
        </div>

        <!-- Select para perfil de usuario, podría ser un recurso a incluir -->
        <div class="form-floating">
          <select class="form-select" id="floatingSelect" aria-label="Floating label select example" onchange="camposAdicionales()">
            <option selected>Selecciona un perfil</option>
            <option value="1">Cliente</option>
            <option value="2">Profesional</option>
            <option value="3">Administrativo</option>
          </select>
          <label for="floatingSelect">Usuario</label>
        </div>

        <!-- Campos adicionales para Administrativo -->
        <div id="additionalFields" class="cantainer pt-3" style="display: none;">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="area">
                <label for="area">Área</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="experienciaPrevia">
                <label for="experienciaPrevia">Experiencia Previa</label>
            </div>
        </div>

    </div>

    <%@ include file='footer.jsp' %>

    <!-- SCRIPT PARA MOSTRAR CAMPOS ADICIONALES, trasladar a js file -->
    <script>
        function camposAdicionales() {
            var select = document.getElementById("floatingSelect");
            var additionalFields = document.getElementById("additionalFields");
            var value = select.value;
            if (value === "3") {
                additionalFields.style.display = "block";
            } else {
                additionalFields.style.display = "none";
            }
        }
    </script>
</body>
</html>