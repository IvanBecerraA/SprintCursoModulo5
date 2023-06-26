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

    <form action="ServletCreaUsuario" method="post" class="container p-3" style="width: 50%; text-align: center;">
        <h2 class="pb-4">Formulario Crear Usuario Administrativo</h2>

        <!-- Datos basicos de usuario -->
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="nombre" placeholder="Jane" required>
            <label for="nombre">Nombre</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="apellido1" placeholder="Doe" required>
            <label for="apellido1">Primer Apellido</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="apellido2" placeholder="Doe" required>
            <label for="apellido2">Segundo Apellido</label>
        </div>
        <div class="form-floating mb-3">
            <input type="date" class="form-control" id="fechaNacimiento" required>
            <label for="fechaNacimiento">Fecha de Nacimiento</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="run" placeholder="11222333-3" required>
            <label for="run">RUN</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="contrasena" placeholder="ej: 1234" required>
            <label for="contrasena">Contraseña</label>
        </div>

        <!-- Select para perfil de usuario, podría ser un recurso a incluir -->
        <div class="form-floating pb-3">
          <select class="form-select" id="floatingSelect" onchange="camposAdicionales()" required>
            <option value="">Selecciona un perfil</option>
            <option value="1">Cliente</option>
            <option value="2">Profesional</option>
            <option value="3">Administrativo</option>
          </select>
          <label for="floatingSelect">Usuario</label>
        </div>

        <!-- Campos adicionales para Administrativo -->
        <div id="additionalFields" class="cantainer" style="display: none;">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="area" placeholder="RRHH" required>
                <label for="area">Área</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="experienciaPrevia" placeholder="4 años" required>
                <label for="experienciaPrevia">Experiencia Previa</label>
            </div>
        </div>

        <!-- botones, cancelar debe redirijir a inicio cuando exista la view -->
        <button type="submit" class="btn btn-success btn-lg">Crear</button>
        <button type="submit" formaction="inicio.jsp" class="btn btn-outline-danger" formnovalidate>Cancelar</button>

    </form>

    <%@ include file='footer.jsp' %>

    <!-- SCRIPT PARA MOSTRAR CAMPOS ADICIONALES, trasladar a js file -->
    <script>
        function camposAdicionales() {
            var select = document.getElementById("floatingSelect");
            var additionalFields = document.getElementById("additionalFields");
            if (select.value === "3") {
                additionalFields.style.display = "block";
            } else {
                additionalFields.style.display = "none";
            }
        }
    </script>
</body>
</html>