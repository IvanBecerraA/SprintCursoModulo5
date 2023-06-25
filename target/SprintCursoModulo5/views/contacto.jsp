<%--
  Created by IntelliJ IDEA.
  User: oscar
  Date: 23-06-23
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <script>
            // Función para validar el formulario y mostrar el cuerpo del mensaje en una alerta
            function validarFormulario() {
                var nombre = document.getElementById('nombre').value;
                var apellidos = document.getElementById('apellidos').value;
                var telefono = document.getElementById('telefono').value;
                var email = document.getElementById('email').value;
                var mensaje = document.getElementById('mensaje').value;

                // Expresión regular para validar el formato del correo
                var correoRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                var nombreRegex = /^[A-Za-z]+$/;
                var telefonoRegex = /^\+\d{9}$/;
                var apellidoRegex = /^[A-Za-z]+$/;



                // Validar todos los campos (no deben estar vacíos)
                if (nombre.trim() === '' || apellidos.trim() === '' || correo.trim() === '' || email.trim() === '' || mensaje.trim() === '') {
                    alert('Por favor, complete todos los campos.');
                    return false;
                }

                // Validar el correo
                if (!correo.match(correoRegex)) {
                    alert('Por favor, ingrese un correo válido.');
                    return false;
                }
                if(!nombre.match(nombreRegex)){
                    alert('Por favor, ingrese solo letras en nombre y apellido')
                    return false;
                }
                if(!apellidos.match(apellidoRegex)){
                    alert('Por favor, ingrese solo letras en nombre y apellido')
                    return false;
                }
                if(!telefono.match(telefonoRegex)){
                    alert('Telefono ingresado no es valido')
                    return false;
                }

                // Mostrar el cuerpo del mensaje en una alerta
                alert('Nombre: '+nombre+'\nCuerpo del mensaje:\n\n' + mensaje+'\nMensaje Enviado');

                // Si todos los campos son válidos, enviar el formulario
                return true;
            }

            // Asignar la función de validación al evento "submit" del formulario
            document.getElementById('contactForm').addEventListener('submit', validarFormulario);
        </script>
    </head>

        <body>
                    <form id="contactForm" onsubmit="return validarFormulario()">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required>

                    <label for="apellidos">Apellidos:</label>
                    <input type="text" id="apellidos" name="apellidos" required>

                    <label for="telefono">telefono:</label>
                    <input type="text" id="telefono" name="telefono" required>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>

                    <label for="mensaje">Mensaje:</label>
                    <textarea id="mensaje" name="mensaje" required></textarea>

                    <input type="button" value="Enviar" onclick="validarFormulario()">
                </form>

        </body>
</html>
