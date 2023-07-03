<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <%@ include file='head.jsp'  %>
</head>
<body>
<%@ include file="header.jsp" %>



<main class="container">
<section>
<h2 class="text-center mt-5">Formulario de Contacto</h2>
</section>
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 my-column">
                <form id="contactForm" method="post" class="mx-auto mt-5" action="/contactosv">
                    <div class="form-group mb-3">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                    </div>

                    <div class="form-group mb-3">
                        <label for="apellidos">Apellidos:</label>
                        <input type="text" class="form-control" id="apellidos" name="apellidos" required>
                    </div>

                    <div class="form-group mb-3">
                        <label for="telefono">Teléfono:</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" required placeholder="+56999999999">
                    </div>

                    <div class="form-group mb-3">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" required maxlength="100" placeholder="micorreo@email.com">
                        <small id="emailHelp" class="form-text text-muted">Nunca compartiremos tu correo electrónico con
                            nadie más.</small>
                    </div>

                    <div class="form-group mb-3">
                        <label for="mensaje">Mensaje:</label>
                        <textarea class="form-control" id="mensaje" name="mensaje" required></textarea>
                    </div>

                    <button type="submit" class="btn btn-primary mb-5">Enviar</button>
                </form>

            </div>
        </div>
</main>
        <script>
            // Función para validar el formulario y mostrar el cuerpo del mensaje en una alerta
            function validarFormulario(event) {
                //event.preventDefault();

                var nombre = document.getElementById('nombre').value;
                var apellidos = document.getElementById('apellidos').value;
                var telefono = document.getElementById('telefono').value;
                var email = document.getElementById('email').value;
                var mensaje = document.getElementById('mensaje').value;

                // Expresión regular para validar el formato del correo
                var correoRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                var nombreRegex = /^[A-Za-zñÑ]+$/;
                var telefonoRegex = /^\+\d{6,11}$/;
                var apellidoRegex = /^[A-Za-zñÑ]+$/;

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
                    alert('Por favor, ingrese un nombre valido');
                    return false;
                }
                if (!apellidos.match(apellidoRegex)) {
                    alert('Por favor, ingrese un apellido valido');
                    return false;
                }
                if (!telefono.match(telefonoRegex)) {
                    alert('ingrese un telefono valido');
                    return false;
                }

                // Mostrar el cuerpo del mensaje en una alerta
                alert(`Sr/a: ${nombre}\n\nSu mensaje:\n\n${mensaje}\n\n¡Se ha enviado con éxito!`);

                // Si todos los campos son válidos, enviar el formulario
                return true;
            }

            // Asignar la función de validación al evento "submit" del formulario
            document.getElementById('contactForm').addEventListener('submit', validarFormulario);
        </script>
<%@ include file="footer.jsp" %>
</body>
</html>
