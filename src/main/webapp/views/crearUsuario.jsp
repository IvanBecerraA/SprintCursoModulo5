<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Crear Usuario</title>
    <%@ include file='head.jsp'  %>
</head>
<body>
    <%@ include file='header.jsp' %>

    <form action="ServletCreaUsuario" method="post" class="container p-3" style="width: 50%; text-align: center;">
        <h2 class="pb-4">Formulario Crear Usuario</h2>

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

        <%@ include file='camposCliente.jsp' %>
        <%@ include file='camposProfesional.jsp' %>
        <%@ include file='camposAdministrativo.jsp' %>


        <!-- botones, cancelar debe redirigir a inicio cuando exista la view -->
        <button type="submit" class="btn btn-primary btn-lg">Crear</button>
        <button type="submit" formaction="inicio.jsp" class="btn btn-outline-danger" formnovalidate>Cancelar</button>

    </form>

    <%@ include file='footer.jsp' %>

    <!-- SCRIPT PARA MOSTRAR CAMPOS ADICIONALES, trasladar a js file -->
    <script>
        function camposAdicionales() {
            var select = document.getElementById("floatingSelect");
            var cliente = document.getElementById("cliente");
            var profesional = document.getElementById("profesional");
            var administrativo = document.getElementById("administrativo");

            if (select.value === "1") {
                cliente.style.display = "block";
            } else {
                cliente.style.display = "none";
            }

            if (select.value === "2") {
                profesional.style.display = "block";
            } else {
                profesional.style.display = "none";
            }

            if (select.value === "3") {
                administrativo.style.display = "block";
            } else {
                administrativo.style.display = "none";
            }
        }
    </script>
</body>
</html>