<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 28-06-23
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.jsp" %>

</head>

<body>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-6">

            <form id="contactForm" method="post" class="mx-auto">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required style="width: 400px">
                </div>

                <div class="form-group">
                    <label for="apellidos">Apellidos:</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos" required style="width: 400px">
                </div>

                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" required style="width: 400px">
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required maxlength="100" style="width: 400px;">
                    <small id="emailHelp" class="form-text text-muted">Nunca compartiremos tu correo electrónico con nadie más.</small>
                </div>

                <div class="form-group">
                    <label for="mensaje">Mensaje:</label>
                    <textarea class="form-control" id="mensaje" name="mensaje" required style="width: 400px;"></textarea>
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </div>
    </div>
</div>
<script>
    // Función para validar el formulario y mostrar el cuerpo del mensaje en una alerta
    function validarFormulario(event) {
        event.preventDefault();

        var nombre = document.getElementById('nombre').value;
        var apellidos = document.getElementById('apellidos').value;
        var telefono = document.getElementById('telefono').value;
        var email = document.getElementById('email').value;
        var mensaje = document.getElementById('mensaje').value;

        // Expresión regular para validar el formato del correo
        var correoRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        var nombreRegex = /^[A-Za-z]+$/;
        var telefonoRegex = /^\+\d{6,9}$/;
        var apellidoRegex = /^[A-Za-z]+$/;

        // Validar todos los campos (no deben estar vacíos)
        if (nombre.trim() === '' || apellidos.trim() === '' || telefono.trim() === '' || email.trim() === '' || mensaje.trim() === '') {
            alert('Por favor, complete todos los campos.');
            return false;
        }

        // Validar el correo
        if (!email.match(correoRegex)) {
            alert('Por favor, ingrese un correo válido.');
            return false;
        }
        if (!nombre.match(nombreRegex)) {
            alert('Por favor, ingrese solo letras en nombre');
            return false;
        }
        if (!apellidos.match(apellidoRegex)) {
            alert('Por favor, ingrese solo letras en apellido');
            return false;
        }
        if (!telefono.match(telefonoRegex)) {
            alert('Teléfono ingresado no es válido');
            return false;
        }

        // Mostrar el cuerpo del mensaje en una alerta
        alert('Nombre: ' + nombre + '\nCuerpo del mensaje:\n\n' + mensaje + '\nMensaje Enviado');

        // Si todos los campos son válidos, enviar el formulario
        return true;
    }

    // Asignar la función de validación al evento "submit" del formulario
    document.getElementById('contactForm').addEventListener('submit', validarFormulario);
</script>
<%@ include file="footer.jsp" %>
</body>
</html>
